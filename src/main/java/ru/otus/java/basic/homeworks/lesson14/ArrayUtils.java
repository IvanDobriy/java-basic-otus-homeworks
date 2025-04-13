package ru.otus.java.basic.homeworks.lesson14;

public class ArrayUtils {
    static long getExecutionTime(Runnable runnable) {
        final long now = System.nanoTime();
        runnable.run();
        return System.nanoTime() - now;
    }

    static double[] createArray() {
        final double[] arr = new double[100_000_000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }
        return arr;
    }

    static double[] createArrayParallel() {
        try {
            final double[] arr = new double[100_000_000];
            final Thread[] threads = new Thread[4];
            for (int i = 0; i < threads.length; i++) {
                final int threadIndex = i;
                threads[i] = new Thread(() -> {
                    for (int j = threadIndex * arr.length / threads.length; j < (threadIndex + 1) * arr.length / threads.length; j++) {
                        arr[j] = 1.114 * Math.cos(j) * Math.sin(j * 0.2) * Math.cos(j / 1.2);
                    }
                });
                threads[i].start();
            }
            for (int i = 0; i < threads.length; i++) {
                threads[i].join();
            }
            return arr;
        } catch (InterruptedException interruptedException) {
            throw new RuntimeException(interruptedException);
        }
    }
}
