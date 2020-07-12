package 基础.背包队列栈;

/**
 * 一个简单的链表
 * @param <Item>
 */
public class Node<Item>{
     Item var;
     Node next;

    public Node(Item var) {
        this.var = var;
    }

    public Node() {
    }

    public Item getVar() {
        return var;
    }

    public void setVar(Item var) {
        this.var = var;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}