import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Jaccard implements Similarity {
  @Override
  public double score(WordMap a, WordMap b) {
    if (a == null || b == null) return 0d;

    String[] arr1 = a.keys();
    String[] arr2 = b.keys();

    int intersection = getIntersection(arr1, arr2);
    int union = (arr1.length + arr2.length) - intersection;

    return (double)intersection/union;
  }

  int getIntersection(String[] a, String[] b) {

    Set<String> set = new HashSet<>(Arrays.asList(a));
    Set<String> res = new HashSet<>();

    for(String val: b){
      if(set.contains(val)){
        res.add(val);
      }
    }

    return res.size();
  }

  int getUnion(String[] a, int n, String[] b, int m) {
    // find min of n and m
    int min = Math.min(n, m);

    // set container
    Set<String> set = new HashSet<>();

    // add elements from both the arrays for
    // index from 0 to min(n, m)-1
    for (int i = 0; i < min; i++) {
      set.add(a[i]);
      set.add(b[i]);
    }

    if (n > m) {
      for (int i = m; i < n; i++) {
        set.add(a[i]);
      }
    }
    else if (n < m) {
      for (int i = n; i < m; i++) {
        set.add(b[i]);
      }
    }

    System.out.println("The union set of both arrays is :");
    System.out.print(set.toString());
    return set.size();
  }
}
