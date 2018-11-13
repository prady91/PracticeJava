import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by pradyumna on 8/19/18.
 */
public class TopKFrequentElements {

    public List<Integer> topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        Map<Integer, Integer> countMap = new HashMap<>();
        List<Integer>[] buckets = new List[nums.length+1];
        for (int n : nums) {
            countMap.put(n, countMap.getOrDefault(n, 0)+1);
        }
        for (Integer key : countMap.keySet()) {
            int freq = countMap.get(key);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);
        }
        List<Integer> topk = new ArrayList<>();
        for (int i=nums.length; topk.size() < k;  i--) {
            if (buckets[i] != null) {
                topk.addAll(buckets[i]);
            }
        }
        return topk.subList(0, k);
    }




}
