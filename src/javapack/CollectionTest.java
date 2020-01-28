import java.util.*;

/**
 * Created by CYF
 * on 2019/8/27.
 */
public class CollectionTest {

    public volatile boolean exit = false;

    public static void main(String[] args) {
        /*List*/



        List<String> list = new ArrayList<String>();
        list.add("List:ArrayList");

        List<String> list2 = new Vector<String>();
        list2.add("List;Vector");

        List<String> list3 = new LinkedList<String>();
        list3.add("List:LinkedList");
        list3.remove(0);

        Queue<String> queue = new LinkedList<String>();
        queue.add("Queue:LinkedList");

        /* set */
        Set<String> set = new HashSet<String>();
        set.add("HashSet");

        Set<String> treeSet = new TreeSet<String>();
        treeSet.add("TreeSet");

        Set<String> linkedHashSet = new LinkedHashSet<String>();
        linkedHashSet.add("LinkedHashSet");

        /* map */
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("HashMap",3);

        Map<String,Integer> hashTable = new Hashtable<String,Integer>();
        hashTable.put("hashTable",3);

        Map<String,Integer> treeMap = new TreeMap<String,Integer>();
        treeMap.put("treeMap",3);


    }
}
