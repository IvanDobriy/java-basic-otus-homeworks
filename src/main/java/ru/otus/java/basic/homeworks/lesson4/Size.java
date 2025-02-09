package ru.otus.java.basic.homeworks.lesson4;

/**
 * To set size of some objects like box, unit of measurement [mm]
 */
public enum Size {
    SMALL(100, 100, 100, "Small"),
    MEDIUM(500, 500, 500, "Medium"),
    LARGE(1000, 1000, 1000, "Large");

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public String getDescription() {
        return description;
    }

    Size(int aWidth, int aHeight, int aLength, String aDescription) {
        width = aWidth;
        height = aHeight;
        length = aLength;
        description = aDescription;
    }

    private int width;
    private int height;
    private int length;
    private String description;
}
