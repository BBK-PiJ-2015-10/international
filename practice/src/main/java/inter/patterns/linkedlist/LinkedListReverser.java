package inter.patterns.linkedlist;

public class LinkedListReverser {

    public Node reverseList(Node node){
        Node previousNode =  null;
        Node nextNode = null;
        Node currentNode = node;
        while (currentNode!=null){
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;;
        }
        return previousNode;
    }

    public void print(Node node){
        System.out.println(String.format("Node %d",node.value));
        if (node.next!=null){
            print(node.next);
        }
    }


}
