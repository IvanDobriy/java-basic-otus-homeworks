package ru.otus.java.basic.homeworks.lesson4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BoxTests {

    @Test
    void fieldsTest() {
        final var box = new Box(Size.SMALL, Color.BLACK, false);
        Assertions.assertEquals(Size.SMALL, box.getSize());
        Assertions.assertEquals(Color.BLACK, box.getColor());
        Assertions.assertFalse(box.isOpened());
    }

    @Test
    void changeColorTest() {
        final var box = new Box(Size.SMALL, Color.BLACK, false);
        box.setColor(Color.WHITE);
        Assertions.assertEquals(Color.WHITE, box.getColor());
    }

    @Test
    void changeOpenedStatusTest() {
        final var box = new Box(Size.SMALL, Color.WHITE, false);
        Assertions.assertFalse(box.isOpened());
        box.open();
        Assertions.assertTrue(box.isOpened());
        box.close();
        Assertions.assertFalse(box.isOpened());
    }

    @Test
    void getInfoTest() {
        final var box = new Box(Size.SMALL, Color.WHITE, false);
        final var expected = "Box\nsize width: 100, height: 100, length: 100, description: Small\n" +
                "color name: White, code: 1\nis opened: false\n" +
                "is empty";
        Assertions.assertEquals(expected, box.getInfo());
    }

    @Test
    void canContainTest() {
        final var mediumBox = new Box(Size.SMALL, Color.BLACK, true);
        final var largeBox = new Box(Size.LARGE, Color.BLACK, true);
        final var largeBox2 = new Box(Size.LARGE, Color.WHITE, true);
        Assertions.assertTrue(largeBox.canContain(mediumBox));
        Assertions.assertFalse(largeBox.canContain(largeBox2));
        Assertions.assertFalse(mediumBox.canContain(largeBox));
    }

    @Test
    void putContentTest() {
        final var smallBox = new Box(Size.SMALL, Color.BLACK, true);
        final var mediumBox = new Box(Size.MEDIUM, Color.BLACK, true);
        final var largeBox = new Box(Size.LARGE, Color.BLACK, true);
        mediumBox.putContent(smallBox);
        largeBox.putContent(mediumBox);
        largeBox.printInfo();

        final var largeBoxContent = largeBox.removeContent();
        final var nextContent = largeBoxContent.removeContent();
        Assertions.assertEquals(mediumBox, largeBoxContent);
        Assertions.assertEquals(smallBox, nextContent);
    }

    @Test
    void putContentSameSize() {
        final var largeBox = new Box(Size.LARGE, Color.BLACK, true);
        final var largeBox2 = new Box(Size.LARGE, Color.WHITE, true);
        final var exception = Assertions.assertThrows(RuntimeException.class, () -> {
            largeBox.putContent(largeBox2);
        });
        Assertions.assertEquals("Box: size width: 1000, height: 1000, length: 1000, description: Large " +
                "can`t contain aBox: size width: 1000, height: 1000, length: 1000, description: Large", exception.getMessage());
    }

    @Test
    void putContentLargeSize() {
        final var largeBox = new Box(Size.MEDIUM, Color.BLACK, true);
        final var largeBox2 = new Box(Size.LARGE, Color.WHITE, true);
        final var exception = Assertions.assertThrows(RuntimeException.class, () -> {
            largeBox.putContent(largeBox2);
        });
        Assertions.assertEquals("Box: size width: 500, height: 500, length: 500, description: Medium " +
                "can`t contain aBox: size width: 1000, height: 1000, length: 1000, description: Large", exception.getMessage());
    }

    @Test
    void putContentIfBoxIsClosed() {
        final var smallBox = new Box(Size.SMALL, Color.BLACK, false);
        final var mediumBox = new Box(Size.MEDIUM, Color.BLACK, false);
        final var exception = Assertions.assertThrows(RuntimeException.class, () -> {
            mediumBox.putContent(smallBox);
        });
        Assertions.assertEquals("Box is closed", exception.getMessage());
    }

    @Test
    void removeContentIfBoxIsClosed() {
        final var smallBox = new Box(Size.SMALL, Color.BLACK, true);
        final var mediumBox = new Box(Size.MEDIUM, Color.BLACK, true);
        mediumBox.putContent(smallBox);
        mediumBox.close();
        final var exception = Assertions.assertThrows(RuntimeException.class, mediumBox::removeContent);
        Assertions.assertEquals("Box is closed", exception.getMessage());
    }
}
