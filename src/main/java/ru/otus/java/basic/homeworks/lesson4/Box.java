package ru.otus.java.basic.homeworks.lesson4;

import java.util.Objects;

public class Box implements IBox {

    private final Size size;
    private Color color;
    private boolean isOpened;

    private IBox content;

    public Box(Size aSize, Color aColor, boolean isOpened) {
        Objects.requireNonNull(aSize);
        Objects.requireNonNull(aColor);
        size = aSize;
        color = aColor;
        this.isOpened = isOpened;
    }

    @Override
    public Size getSize() {
        return size;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color aColor) {
        Objects.requireNonNull(aColor);
        color = aColor;
    }

    @Override
    public boolean isOpened() {
        return isOpened;
    }

    @Override
    public void open() {
        isOpened = true;
    }

    @Override
    public void close() {
        isOpened = false;
    }

    @Override
    public boolean canContain(IBox aBox) {
        Objects.requireNonNull(aBox);
        if (aBox.getSize().getLength() >= size.getLength()) {
            return false;
        }
        if (aBox.getSize().getWidth() >= size.getWidth()) {
            return false;
        }
        if (aBox.getSize().getHeight() >= size.getHeight()) {
            return false;
        }
        return true;
    }

    @Override
    public void putContent(IBox aBox) {
        Objects.requireNonNull(aBox);
        if (!isOpened) {
            throw new RuntimeException("Box is closed");
        }
        if (!Objects.isNull(content)) {
            throw new RuntimeException("Box is full");
        }
        if (!canContain(aBox)) {
            throw new RuntimeException(String.format("Box: %s can`t contain aBox: %s", size, aBox.getSize()));
        }
        content = aBox;
    }

    @Override
    public IBox removeContent() {
        if (Objects.isNull(content)) {
            throw new RuntimeException("Box is empty");
        }
        if (!isOpened) {
            throw new RuntimeException("Box is closed");
        }
        final var currentBox = content;
        content = null;
        return currentBox;
    }

    @Override
    public String getInfo() {
        final var template = new StringBuilder("Box")
                .append("\n")
                .append(size)
                .append("\n")
                .append(color)
                .append("\n")
                .append(String.format("is opened: %b", isOpened))
                .append("\n");
        if (!Objects.isNull(content)) {
            template.append(String.format("contains box: %s", content.getInfo()));
        } else {
            template.append("is empty");
        }
        return template.toString();
    }

    @Override
    public void printInfo() {
        System.out.println(getInfo());
    }
}
