package ru.otus.java.basic.homeworks.lesson4;

import java.util.Objects;

public class Box {

    private final Size size;
    private Color color;
    private boolean isOpened;

    private Box box;

    public Box(Size aSize, Color aColor, boolean isOpened) {
        Objects.requireNonNull(aSize);
        Objects.requireNonNull(aColor);
        size = aSize;
        color = aColor;
        this.isOpened = isOpened;
    }

    public Size getSize() {
        return size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color aColor) {
        Objects.requireNonNull(aColor);
        color = aColor;
    }

    public boolean isOpened() {
        return isOpened;
    }

    public void open() {
        System.out.println("open");
        isOpened = true;
    }

    public void close() {
        System.out.println("close");
        isOpened = false;
    }

    public boolean canContain(Box aBox) {
        Objects.requireNonNull(aBox);
        if (aBox.size.getLength() >= size.getLength()) {
            return false;
        }
        if (aBox.size.getWidth() >= size.getWidth()) {
            return false;
        }
        if (aBox.size.getHeight() >= size.getHeight()) {
            return false;
        }
        return true;
    }

    public boolean putBox(Box aBox) {
        System.out.println("putBox");
        Objects.requireNonNull(aBox);
        if (!isOpened) {
            return false;
        }
        if (!canContain(aBox)) {
            return false;
        }
        box = aBox;
        return true;
    }

    public Box getBox() {
        System.out.println("getBox");
        return box;
    }

    public String getInfo() {
        final var template = new StringBuilder("Box\n");
        template.append(size.toString());
        template.append(color.toString());
        template.append(String.format("is opened: %b\n", isOpened));
        if (box != null) {
            template.append(String.format("contains box: %s", box.getInfo()));
        } else {
            template.append("is empty");
        }
        return template.toString();
    }

    public void printInfo() {
        System.out.println(getInfo());
    }
}
