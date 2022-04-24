/*
 * Deque implemented by array - circular
 * @author Yi Dingcheng */

package deque;


import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
    private T[] items;
    /*Deque Size*/
    private int size;
    /*head and tail are used to indicate the first and the last item*/
    private int head;
    private int tail;

    /*Constructor of Array-based Deque*/
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        head = 0;
        tail = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof ArrayDeque) {
            if (this.size == ((ArrayDeque<?>) o).size) {
                for (int i = 0; i <= this.size; i++) {
                    if (this.get(i) != ((ArrayDeque<?>) o).get(i)) {
                        return false;
                    }
                }
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /*iterator class*/
    private class ArrayDequeIterator implements Iterator<T> {
        private int currPos;
        private int passed;

        ArrayDequeIterator() {
            currPos = head;
            passed = 0;
        }

        public boolean hasNext() {
            return passed < size;
        }

        public T next() {
            T ret = items[currPos];
            currPos = addOne(currPos);
            passed += 1;
            return ret;
        }
    }

    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    /*method to minus "one" in index */
    private int minusOne(int index) {
        if (index == 0) {
            return items.length - 1;
        }
        return index - 1;
    }

    /*method to add "one" in index*/
    private int addOne(int index) {
        if (index == items.length - 1) {
            return 0;
        }
        return index + 1;
    }

    /*method to resize of the Deque*/
    private void resize(int size) {
        T[] newArray = (T[]) new Object[size];
        for (int i = 0; i < this.size; i++) {
            System.arraycopy(items, head, newArray, i, 1);
            head = addOne(head);
        }
        head = 0;
        tail = this.size;
        items = newArray;
    }

    @Override
    /*method to add item in the tail*/ public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[tail] = item;
        tail += 1;
        size += 1;
    }

    @Override
    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        head = minusOne(head);
        items[head] = item;
        size += 1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        if (items.length >= 16 && (float) size / items.length <= 0.25) {
            resize(items.length / 2);
        }
        if (size == 0) {
            return null;
        }
        T ret = items[head];
        items[head] = null;
        head = addOne(head);
        size -= 1;
        return ret;
    }

    @Override
    public T removeLast() {
        if (items.length >= 16 && (float) size / items.length <= 0.25) {
            resize(items.length / 2);
        }
        if (isEmpty()) {
            return null;
        }
        T ret = items[minusOne(tail)];
        items[minusOne(tail)] = null;
        tail = minusOne(tail);
        size -= 1;
        return ret;
    }

    /*print Deque content*/
    @Override
    public void printDeque() {
        for (int i = head; i != tail; i = addOne(i)) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    @Override
    public T get(int index) {
        int i = index + head;
        if (i > items.length) {
            i -= items.length;
        }
        return items[i];
    }


}
