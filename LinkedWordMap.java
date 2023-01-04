import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

/**
 * An implementation of the interface WordMap using linked elements.
 *
 * @author Marcel Turcotte (marcel.turcotte@uottawa.ca)
 */

public class LinkedWordMap implements WordMap {


  HashMap<String, Integer> map;
  LinkedWordMap() {
    map = new HashMap<>();
  }

  /**
   * Returns the logical size of this WordMap. That is the number of
   * associations currently stored in it.
   *
   * @return the logical size of this WordMap
   */

  public int size() {
    return this.map.size();
  }

  /**
   * Returns true if and only if this WordMap contains the specified
   * word.
   *
   * @param key the specified word
   * @return true if and only if this WordMap contains the specified word
   * @throws NullPointerException if the value of the parameter is null
   */

  public boolean contains(String key) {

    if (key == null) throw new NullPointerException("Can not pass null");

    return this.map.get(key) != null;
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
    if (key == null) throw new NullPointerException("Can not pass null");

    return this.map.get(key) != null ? this.map.get(key) : 0;
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
    this.map.merge(key, 1, Integer::sum);
  }

  /**
   * Returns all the keys (words) of this WordMap using their
   * natural order.
   *
   * @return all the keys (words)
   */

  public String[] keys() {
    Set<String> keys = this.map.keySet();

    int n = keys.size();
    String[] arr = new String[n];
    keys.toArray(arr);

    Arrays.sort(arr);

    return arr;
  }

  /**
   * Returns all the counts associated with keys in this
   * WordMap. The counts are in the same order as that of the keys
   * returned by the method keys().
   *
   * @return all the counts
   */

  public Integer[] counts() {
    Collection<Integer> values = map.values();
    Integer[] arr = new Integer[values.size()];

    values.toArray(arr);

    Arrays.sort(arr);

    return arr;
  }
}
