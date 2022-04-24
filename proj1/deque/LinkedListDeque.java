/* First part of project 1
 * Deque implemented by linked list
 * @author Yi Dingcheng
 * */
package deque;

public class LinkedListDeque<T> implements Deque<T>{
    /*Inner class of Node*/
    private class IntNode {
        private T item;
        private IntNode next;
        private IntNode prev;

        public IntNode(T i, IntNode n, IntNode p) {
            item = i;
            next = n;
            prev = p;
        }
    }

    private int size;
    private final IntNode sentinel;

    public LinkedListDeque() {
        sentinel = new IntNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    @Override
    public void addFirst(T item) {
        IntNode node = new IntNode(item, sentinel.next, sentinel);
        sentinel.next = node;
        node.next.prev = node;
        size += 1;
    }

    @Override
    public void addLast(T item) {
        IntNode node = new IntNode(item, sentinel, sentinel.prev);
        sentinel.prev = node;
        node.prev.next = node;
        size += 1;
    }

    @Override
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

    private T getRecursiveHelp(int index, IntNode p) {
       if (index == 0) {
           return p.item;
       }
       return getRecursiveHelp(index - 1, p.next);
    }
    public T getRecursive(int index) {
        if (size < index + 1 || index < 0) {
            return null;
        }
        return getRecursiveHelp(index, sentinel.next);
    }

    @Override
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

    @Override
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

    @Override
    public int size() {
        return size;
    }

    @Override
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
