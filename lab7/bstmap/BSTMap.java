package bstmap;

import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {
    private BSTNode root;
    private int size;
    /*BSTNode - node in the tree*/
    private class BSTNode {
        private K key;
        private V value;
        private BSTNode left;
        private BSTNode right;
        BSTNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
        BSTNode(K key, V value, BSTNode left, BSTNode right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    private V search(K key, BSTNode node) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) == 0) {
            return node.value;
        } else if (key.compareTo(node.key) > 0) {
            return search(key, node.right);
        }
        else {
            return search(key, node.left);
        }
    }
    private boolean contains(K key, BSTNode node) {
        if (node == null) {
            return false;
        }
        if (key.compareTo(node.key) == 0) {
            return true;
        } else if (key.compareTo(node.key) > 0) {
            return contains(key, node.right);
        }
        else {
            return contains(key, node.left);
        }

    }
    private BSTNode insert(K key, V value, BSTNode node) {
        if (node == null) {
           return new BSTNode(key, value);
        }
        if (key.compareTo(node.key) == 0) {
            node.value = value;
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = insert(key, value, node.right);
        }
        else {
            node.left = insert(key, value, node.left);
        }
        return node;
    }
    BSTMap() {
        size = 0;
        root = null;
    }

    /*remove all the mappings in BSTMap*/
    public void clear() {
        size = 0;
        root = null;
    }

    /* Returns true if this map contains a mapping for the specified key. */
    public boolean containsKey(K key) {
        return contains(key, root);
    }

    /* Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    public V get(K key) {
      return search(key, root);
    }

    /* Returns the number of key-value mappings in this map. */
    public int size() {
        return size;
    }

    /* Associates the specified value with the specified key in this map. */
    public void put(K key, V value) {
       root = insert(key, value, root);
       size += 1;
    }

    /* Returns a Set view of the keys contained in this map. Not required for Lab 7.
     * If you don't implement this, throw an UnsupportedOperationException. */
    public Set<K> keySet() {
        throw new UnsupportedOperationException("This operation is unsupported");
    }

    /* Removes the mapping for the specified key from this map if present.
     * Not required for Lab 7. If you don't implement this, throw an
     * UnsupportedOperationException. */
    public V remove(K key) {
        throw new UnsupportedOperationException("This operation is unsupported now");
    }

    /* Removes the entry for the specified key only if it is currently mapped to
     * the specified value. Not required for Lab 7. If you don't implement this,
     * throw an UnsupportedOperationException.*/
    public V remove(K key, V value) {
        throw new UnsupportedOperationException("This operation is unsupported now");
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException("This operation is unsupported now");
    }
}
