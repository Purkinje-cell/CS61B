/*
 * Deque implemented by array - circular
 * @author Yi Dingcheng */

package deque;

public class ArrayDeque<T> {
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
        if (size < items.length) { // shrink the Array
            for (int i = 0; i < this.size; i++) {
                System.arraycopy(items, head, newArray, i, 1);
                head = addOne(head);
            }
            head = 0;
            tail = this.size;
            items = newArray;
        } else { // enlarge the array
            if (tail <= head) {
                System.arraycopy(items, 0, newArray, 0, tail);
                System.arraycopy(items, head, newArray, head + size - items.length, items.length - head);
            } else {
                System.arraycopy(items, head, newArray, head + size - items.length, tail - head + 1);
                tail = tail + size - items.length;
            }
            head = size - (items.length - head);
        }
        items = newArray;
    }

    /*method to add item in the tail*/
    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[tail] = item;
        tail += 1;
        size += 1;
    }

    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        head = minusOne(head);
        items[head] = item;
        size += 1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

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
    public void printDeque() {
        for (int i = head; i != tail; i = addOne(i)) {
            System.out.print(items[i]+" ");
        }
        System.out.println();
    }

    public T get(int index) {
        int i = index + head;
        if (i > items.length) {
            i -= items.length;
        }
        return items[i];
    }
}
