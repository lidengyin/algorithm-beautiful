package 基础.背包队列栈;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 先进先出队列
 * @param <Item>
 */
public class Queue<Item> implements Iterable<Item> {
    //最早添加的结点的链接
    private Node first;
    //最近添加的结点的链接
    private Node last;
    //队列中元素的数量
    private int N;

    /**
     * 添加一个元素
     * @param item
     */
    public void enqueue(Item item){
        //向对尾添加元素
        Node oldLast = last;
        last.item=item;
        last.next=null;
        if (isEmpty()){
            first = last;
        }else{
            oldLast.next=last;
        }
        N++;
    }

    public int size(){
        return N;
    }
    /**
     * 删除表头元素
     */
    public Item dequeue(){
//        if (isEmpty()){
//
//            throw new NoSuchElementException();
//        }
        //从表头删除元素
        Item item = first.item;
        first=first.next;
        if (isEmpty()){
            last=null;
        }
        N--;
        return item;
    }

    /**
     * 空构造函数
     */
    public Queue() {

    }

    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty(){
        return first == null;
    }//或者N==0

    /**
     * 迭代器
     * @return
     */
    @Override
    public Iterator<Item> iterator() {
        return new QueueStack(first);
    }
    private class QueueStack implements Iterator<Item>{
        private Node current;

        public QueueStack(Node first) {
            this.current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()){
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current=current.next;
            return item;
        }
    }
    private class Node{
        //定义了结点的嵌套类
        Item item;
        Node next;
    }
}
