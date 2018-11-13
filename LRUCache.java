import java.util.*;

/**
 * Created by pradyumna on 8/26/18.
 */


/*

Check private inner class
final class
 */
public class LRUCache {

    final int capacity;
    Map<Integer, CustomList<CacheEntry>.ListEntry> cache;
    CustomList keyAccessList;
    final CustomList<CacheEntry>.ListEntry defaultEntry;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache =  new HashMap<>();
        keyAccessList = this.new CustomList();
        CacheEntry cacheEntry = new CacheEntry(-1);
        defaultEntry = this.new CustomList().new ListEntry(cacheEntry);
    }

    public int get(int key) {
        CustomList<CacheEntry>.ListEntry listEntry = defaultEntry;
        if (cache.containsKey(key)) {
            listEntry = this.cache.get(key);
            keyAccessList.moveNodeToEnd(listEntry);
        }
        return listEntry.value.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            CustomList.ListEntry listEntry = this.cache.get(key);
            keyAccessList.removeNode(listEntry);
        }
        if (cache.keySet().size() >= capacity) {
            CacheEntry headEntry = (CacheEntry)keyAccessList.getLeastUsed().value;
            keyAccessList.removeLeastUsed();
            cache.remove(headEntry.value);
        }
        CacheEntry cacheEntry = new CacheEntry(value);
        keyAccessList.addNode(cacheEntry);
        cache.put(key, keyAccessList.tail);

    }

    private class CacheEntry {
       final int value;
        CacheEntry (int value) {
            this.value = value;
        }
    }

    private class CustomList<V> {

        ListEntry head;
        ListEntry tail;
        int size = 0;

        CustomList() {
            head = new ListEntry(null);
            tail = new ListEntry(null);
            head.next = tail;
            tail.prev = head;
        }

        class ListEntry {
            V value;
            ListEntry next;
            ListEntry prev;

            ListEntry(V value) {
                this.value = value;
            }
        }

        public void addNode (V value) {
            ListEntry node = new ListEntry(value);
            ListEntry after = head.next;
            node.prev = head;
            node.next = after;

            after.prev = node;
            head.next = node;
        }

        public ListEntry getLeastUsed () {
            return head.next;
        }

        public void removeLeastUsed () {
            ListEntry after = head.next.next;
            head.next = after;
            after.prev = head;
        }

        public void removeNode (ListEntry node) {
            if (node == null) {
                return;
            }
            ListEntry prev = node.prev;
            ListEntry after = node.next;
            prev.next = after;
            after.prev = prev;
        }

        public void moveNodeToEnd(ListEntry node) {
            if (node == null) {
                return;
            }
            removeNode(node);
            ListEntry prev = tail.prev;
            prev.next = node;
            node.prev = prev;
            node.next = tail;
            tail.prev = node;
        }
    }


    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(1);

        lruCache.put(1,1);
        System.out.println(lruCache.get(1));
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
        lruCache.put(3,3);
        System.out.println(lruCache.get(1));
    }
}
