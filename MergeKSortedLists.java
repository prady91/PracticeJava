import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by pradyumna on 8/19/18.
 */
public class MergeKSortedLists {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length < 1) {
            return null;
        }

        if (lists.length == 1) {
            return lists[0];
        }

        PriorityQueue<ListNode> nodeHeap = new PriorityQueue<>((l1, l2) -> l1.val-l2.val);
        ListNode mergedList = new ListNode(-1); // dummy pointer
        for (ListNode node : lists) {
            if (node != null) {
                nodeHeap.add(node);
            }
        }

        ListNode processingNode = mergedList;
        while (!nodeHeap.isEmpty()) {
            ListNode currNode = nodeHeap.poll();
            processingNode.next = currNode;
            processingNode = processingNode.next;
            if (processingNode.next != null) {
                nodeHeap.add(processingNode.next);
            }
        }
        ListNode result = mergedList.next;
        mergedList.next = null;
        return result;
    }


    public static void main(String[] args) {




    }

}
