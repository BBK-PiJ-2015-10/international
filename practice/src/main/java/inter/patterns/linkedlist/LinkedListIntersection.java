package inter.patterns.linkedlist;

public class LinkedListIntersection {

    public Node findIntersectionNode(Node list1, Node list2) {
        Node pointer1 = list1;
        Node pointer2 = list2;
        while (pointer1 != pointer2) {
            pointer1 = pointer1.next == null ? list2 : pointer1.next;
            pointer2 = pointer2.next == null ? list1 : pointer2.next;
        }
        return pointer1;
    }

}
