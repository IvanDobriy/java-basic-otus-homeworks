package ru.otus.java.basic.homeworks.lesson4;

public class Box {

    private final Size size;
    private Color color;
    private boolean isOpened;

    private Box box;

    public Box(Size aSize, Color aColor, boolean isOpened) {
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
        color = aColor;
    }

    public boolean isOpened() {
        return isOpened;
    }

    public void open() {
        isOpened = true;
    }

    public void close() {
        isOpened = false;
    }

    public boolean canContain(Box box) {
        if (box.size.getLength() >= size.getLength()) {
            return false;
        }
        if (box.size.getWidth() >= size.getWidth()) {
            return false;
        }
        if (box.size.getHeight() >= size.getHeight()) {
            return false;
        }
        return true;
    }

    public boolean putBox(Box aBox) {
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
        return box;
    }

    public String getInfo() {
        final var template = new StringBuilder("Box\n");
        template.append(String.format("size: %dx%dx%d, description: %s\n",
                size.getWidth(), size.getHeight(), size.getLength(), size.getDescription()));
        template.append(String.format("color code: %d, name: %s\n", color.getCode(), color.getName()));
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
