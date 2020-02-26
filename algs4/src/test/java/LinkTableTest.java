import org.junit.Test;

/**
 * @author cntlb
 * @since 2020/2/26 10:41
 */
public class LinkTableTest {
    private class Node {
        Object item;
        Node next;
    }

    Node first = new Node();
    Node second = new Node();
    Node third = new Node();

    private void init() {
        first.item = 1;
        first.next = second;

        second.item = 2;
        second.next = third;

        third.item = 3;
    }

    private void print(){
        for(Node node = first; node!=null; node = node.next)
            System.out.println(node.item);
    }

    @Test
    public void insertFirst() {
        init();
        Node oldFirst = first;
        first = new Node();
        first.item = 0;
        first.next = oldFirst;
        print();
    }

    @Test
    public void delFirst() {
        init();
        first = first.next;
        print();
    }


}
