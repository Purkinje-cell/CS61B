/* First part of project 1
* Deque implemented by linked list
* @author Yi Dingcheng
* */
package deque;

import afu.org.checkerframework.checker.igj.qual.I;

public class LinkedListDeque<T> {
    /*Inner class of Node*/
    private class IntNode {
        public T item;
        public IntNode next;
        public IntNode prev;
        public IntNode(T i, IntNode n, IntNode p) {
            item = i;
            next = n;
            prev = p;
        }
    }
    private int size;
    private IntNode sentinel;
    public LinkedListDeque() {
        sentinel = new IntNode(null, sentinel, sentinel);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        IntNode node = new IntNode(item, sentinel.next, sentinel);
        sentinel.next = node;
        node.next.prev = node;
        size += 1;
    }
    public void addLast(T item) {
        IntNode node = new IntNode(item, sentinel, sentinel.prev);
        sentinel.prev = node;
        node.prev.next = node;
        size += 1;
    }
    public T get(int index) {
        if (size < index + 1 || index < 0) {
            return null;
        }
        IntNode p = sentinel;
        for (int i = 0; i <= index; i++) {
            p = p.next;
        }
        return p.item;
    }

    public T getIndexRecursive(int index, IntNode p) {
        if (size < index + 1 || index < 0) {
            return null;
        }
        if (index == 0) {
            return p.item;
        } else {
            return getIndexRecursive(index-1, p.next);
        }


    }
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        IntNode p = sentinel.next;
        sentinel.next = p.next;
        p.next.prev = sentinel;
        size -= 1;
        return p.item;
    }
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        IntNode p = sentinel.prev;
        sentinel.prev = p.prev;
        p.prev.next = sentinel;
        size -= 1;
        return p.item;
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }

    public void printDeque() {
        IntNode p = sentinel;
        while (p.next != sentinel) {
            p = p.next;
            if (p.next == sentinel) {
                System.out.print(p.item);
            } else {
                System.out.print(p.item + " ");
            }
        }
        System.out.println();
    }
}
