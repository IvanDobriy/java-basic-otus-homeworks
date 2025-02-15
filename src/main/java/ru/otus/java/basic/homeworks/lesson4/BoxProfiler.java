package ru.otus.java.basic.homeworks.lesson4;

import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;
import java.util.logging.Logger;

public class BoxProfiler implements IBox {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final IBox box;

    private interface CallbackWithReturn<T> {
        T run();
    }

    private interface Callback {
        void run();
    }

    private <T> T profileWithReturn(String methodName, CallbackWithReturn<T> callback) {
        final var tag = UUID.randomUUID();
        logger.info(String.format("before, tag: %s, method name: %s", tag, methodName));
        final T result;
        try {
            final var time = System.currentTimeMillis();
            result = callback.run();
            logger.info(String.format("after, tag: %s, method name: %s, result: %s, time: %d", tag, methodName, result, System.currentTimeMillis() - time));
        } catch (Exception e) {
            logger.info(String.format("exception tag: %s, into method name: %s, message: %s, stacktrace: %s",  tag, methodName, e.getMessage(), Arrays.toString(e.getStackTrace())));
            throw e;
        }
        return result;
    }

    private void profile(String methodName, Callback callback) {
        final var tag = UUID.randomUUID();
        logger.info(String.format("before, tag: %s, method name: %s", tag, methodName));
        try {
            final var time = System.currentTimeMillis();
            callback.run();
            logger.info(String.format("after, method name: %s, time: %d", methodName, System.currentTimeMillis() - time));
        } catch (Exception e) {
            logger.info(String.format("exception tag: %s, into method name: %s, message: %s, stacktrace: %s",  tag, methodName, e.getMessage(), Arrays.toString(e.getStackTrace())));
            throw e;
        }
    }

    public BoxProfiler(IBox aBox) {
        Objects.requireNonNull(aBox);
        box = aBox;
    }

    @Override
    public Size getSize() {
        return profileWithReturn("getSize", box::getSize);
    }

    @Override
    public Color getColor() {
        return profileWithReturn("getColor", box::getColor);
    }

    @Override
    public void setColor(Color aColor) {
        profile("setColor", () -> box.setColor(aColor));
    }

    @Override
    public boolean isOpened() {
        return profileWithReturn("isOpened", box::isOpened);
    }

    @Override
    public void open() {
        profile("open", box::open);
    }

    @Override
    public void close() {
        profile("close", box::close);
    }

    @Override
    public boolean canContain(IBox aBox) {
        return profileWithReturn("canContain", () -> box.canContain(aBox));
    }

    @Override
    public void putContent(IBox aBox) {
        profile("putContent", () -> box.putContent(aBox));
    }

    @Override
    public IBox removeContent() {
        return profileWithReturn("removeContent", box::removeContent);
    }

    @Override
    public String getInfo() {
        return profileWithReturn("getInfo", box::getInfo);
    }

    @Override
    public void printInfo() {
        profile("printInfo", box::printInfo);
    }
}
