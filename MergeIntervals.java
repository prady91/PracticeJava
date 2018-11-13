
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by pradyumna on 8/16/18.
 */
public class MergeIntervals {

    static class Interval{
        int start;
        int end;
        Interval() {
            start = 0;
            end = 0;
        }
        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {

        if (intervals == null || intervals.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        Comparator<Interval> intervalComparator = Comparator.comparingInt(i -> i.start);
        intervals.sort(intervalComparator);

        LinkedList<Interval> mergedIntervals = new LinkedList<>();

        for (Interval interval : intervals) {
            if (mergedIntervals.isEmpty() || mergedIntervals.getLast().end < interval.start) {
                mergedIntervals.add(interval);
            } else {
                Interval prev = mergedIntervals.removeLast();
                prev.end = Math.max(prev.end, interval.end);
                mergedIntervals.add(prev);
            }
        }
        return mergedIntervals;
    }

    public static void main(String[] args) {

        Interval i1 = new Interval(1, 3);
        Interval i2 = new Interval(2, 6);
        Interval i3 = new Interval(7, 10);
        MergeIntervals mergeIntervals = new MergeIntervals();
        List<Interval> result = mergeIntervals.merge(Arrays.asList(i1, i2, i3));
        System.out.println(result.size());
        result.stream().map(i -> i.start).forEachOrdered(System.out::print);
        System.out.println();
        result.stream().map(i -> i.end).forEachOrdered(System.out::print);
    }

}
