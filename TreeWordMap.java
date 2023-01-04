import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * A Binary Search Tree implementation of the interface WordMap.
 *
 * @author Marcel Turcotte (marcel.turcotte@uottawa.ca)
 */

public class TreeWordMap implements WordMap {

    private static class Elem {

        private String key;
        private int count;
        private Elem left, right;

        private Elem(String key) {
            this.key = key;
            count = 1;
        }

    }

    private Elem root;
    private int size;

    /**
     * Returns true if and only if this WordMap contains the specified
     * word.
     *
     * @param key the specified word
     * @return true if and only if this WordMap contains the specified key
     * @throws NullPointerException if the value of the parameter is null
     */
    
    public boolean contains(String key) {

        if (key == null) {
            throw new NullPointerException();
        }
        
        boolean found = false;
        Elem current = root;
        while (! found && current != null) {
            int test = key.compareTo(current.key);
            if (test == 0) {
                found = true;
            } else if (test < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return found;
    }
    
    /**
     * Increments by 1 the counter associated with the specified
     * word. If the specified word is absent from the data structure,
     * a new association is created.
     *
     * @param key the specified word
     * @throws NullPointerException if the value of the parameter is null
     */
    
    public void update(String key) {

        if (key == null) throw new NullPointerException();

        if (root == null) {
            root = new Elem(key);
            size++;
            return;
        }

        if (this.contains(key)) {
            Elem p = findNode(key);
            p.count++;
            return;
        }
        Elem current = root;

        while (true) {
            int test = key.compareTo(current.key);
            if (test < 0) {
                if (current.left != null) {
                    current = current.left;
                } else {
                    current.left = new Elem(key);
                    size++;
                    break;
                }
            } else if(test > 0) {
                if (current.right != null) {
                    current = current.right;
                } else {
                    current.right = new Elem(key);
                    size++;
                    break;
                }
            }
        }

    }

    private Elem findNode(String key) {
        boolean found = false;
        Elem current = root;
        while (!found & current != null) {
            int test = key.compareTo(current.key);
            if (test == 0) {
                found = true;
                return current;
            } else if (test < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return null;
    }
    
    /**
     * Returns the count associated with the specified word or 0 if
     * the word is absent.
     *
     * @param key the specified word
     * @return the count associated with the specified word or 0 if absent
     * @throws NullPointerException if the value of the parameter is null
     */
    
    public int get(String key) {

        if (key == null) {
            throw new NullPointerException();
        }
        
        boolean found = false;
        Elem current = root;
        while (current != null) {
            int test = key.compareTo(current.key);
            if (test == 0) {
                return current.count;
            } else if (test < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return 0;
    }
    
    /**
     * Returns the logical size of this WordMap. That is the number of
     * associations currently stored in it.
     *
     * @return the logical size of this WordMap
     */
    
    public int size() {
        return size;
    }
    
    /**
     * Returns all the keys (words) of this WordMap using their
     * natural order.
     *
     * @return all the keys (words)
     */
    
    public String[] keys() {

        if (root == null)
            return null;

        Queue<String> q = new LinkedList<>();
        inOrderKeys(root, q);
        String[] keys = new String[q.size()];

        for (int i = 0; i<keys.length; i++) {
            keys[i] = q.poll();
            size--;
        }

        return keys;
    }

    private void inOrderKeys(Elem root, Queue<String> queue) {

        if (root == null) return;

        inOrderKeys(root.left, queue);

        queue.offer(root.key);

        inOrderKeys(root.right, queue);
    }
    
    /**
     * Returns all the counts associated with keys in this
     * WordMap. The counts are in the same order as that of the keys
     * returned by the method keys().
     *
     * @return all the counts
     */
    
    public Integer[] counts() {

        if (root == null)
            return null;

        Queue<Integer> q = new LinkedList<>();
        inOrderCount(root, q);
        Integer[] counts = new Integer[q.size()];

        for (int i = 0; i<counts.length; i++) {
            counts[i] = q.poll();
        }

        Arrays.sort(counts);

        return counts;
        
    }

    private void inOrderCount(Elem root, Queue<Integer> queue) {

        if (root == null) return;

        inOrderCount(root.left, queue);

        queue.offer(root.count);

        inOrderCount(root.right, queue);
    }

}
