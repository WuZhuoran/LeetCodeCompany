import java.util.*;

public class MainLinkedList {
    private static LinkedList<Integer> llist;

    public static void main(String[] args) {
        llist = new LinkedList<Integer>();

        addValue(60);
        addValue(30);
        addValue(10);
        addValue(-5);
        addValue(1000);
        addValue(50);
        addValue(60);
        addValue(90);
        addValue(1000);
        addValue(0);
        addValue(100);
        addValue(-1000);
        System.out.println("Linked List is: " + llist);

    }

    private static void addValue(int val) {

        if (llist.size() == 0) {
            llist.add(val);
        } else if (llist.get(0) > val) {
            llist.add(0, val);
        } else if (llist.get(llist.size() - 1) < val) {
            llist.add(llist.size(), val);
        } else {
            int i = 0;
            while (llist.get(i) < val) {
                i++;
            }
            llist.add(i, val);
        }

    }

    public static int deleteValue(int val) {

    }

    public static int search() {

    }

}
