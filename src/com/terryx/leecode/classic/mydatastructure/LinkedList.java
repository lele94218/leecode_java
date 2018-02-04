package com.terryx.leecode.classic.mydatastructure;

/**
 * @author taoranxue on 10/7/17 8:08 PM.
 */
public class LinkedList<E> implements List<E> {
    private int size = 0;
    private Node<E> first;
    private Node<E> last;

    private class Node<E> {
        Node<E> prev;
        Node<E> next;
        E item;

        Node(Node<E> prev, Node<E> next, E item) {
            this.prev = prev;
            this.next = next;
            this.item = item;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        int index = 0;
        for (Node<E> x = first; x != null; x = x.next) {
            result[index++] = x.item;
        }
        return result;
    }

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}
