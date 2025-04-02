package ru.otus.java.basic.homeworks.lesson11.tree;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;


public class Finder<T> implements SearchTree<T> {
    public class Node<T> {
        private T key;
        private Node<T> left;
        private Node<T> right;

        public Node(T key) {
            Objects.requireNonNull(key);
            this.key = key;
            left = right = null;
        }

        public T getKey() {
            return key;
        }

        public Node<T> getLeft() {
            return left;
        }

        public Node<T> getRight() {
            return right;
        }

        public void setKey(T key) {
            this.key = key;
        }

        public void setLeft(Node<T> left) {
            this.left = left;
        }

        public void setRight(Node<T> right) {
            this.right = right;
        }

    }

    private final List<T> elements;

    private final Node<T> root;

    private final Comparator<T> comparator;

    int pathLength;

    public Finder(List<T> elements, Comparator<T> comparator) {
        Objects.requireNonNull(elements);
        Objects.requireNonNull(comparator);
        if (!isSorted(elements, comparator)) {
            throw new IllegalArgumentException("Expected sorted list of elements");
        }
        this.elements = elements;
        this.comparator = comparator;
        if (elements.isEmpty()) {
            root = null;
            return;
        }
        pathLength = 0;
        root = sortedListToBst(elements, 0, elements.size() - 1);
    }

    public boolean isSorted(List<T> elements, Comparator<T> comparator) {
        T previous = null;
        for (T element : elements) {
            if (element == null) {
                throw new RuntimeException("element into sorted list must not be null");
            }
            if (previous == null) {
                previous = element;
            }
            if (comparator.compare(previous, element) > 0) {
                return false;
            }
        }
        return true;
    }


    public Node<T> sortedListToBst(List<T> list, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        if ((end - start) % 2 != 0) {
            mid += 1;
        }
        Node<T> root = new Node<T>(list.get(mid));
        root.setLeft(sortedListToBst(list, start, mid - 1));
        root.setRight(sortedListToBst(list, mid + 1, end));
        return root;
    }

    public Node<T> find(Node<T> root, T element) {
        pathLength++;
        if (root == null || root.getKey().equals(element)) {
            return root;
        }
        if (comparator.compare(root.getKey(), element) < 0) {
            return find(root.getRight(), element);
        }
        return find(root.getLeft(), element);
    }

    public int getPathLength() {
        return pathLength;
    }

    @Override
    public T find(T element) {
        if (root == null) {
            return null;
        }
        pathLength = 0;
        final var result = find(root, element);
        if (result == null) {
            return null;
        }
        return result.getKey();
    }

    @Override
    public List<T> getSortedList() {
        return elements;
    }
}
