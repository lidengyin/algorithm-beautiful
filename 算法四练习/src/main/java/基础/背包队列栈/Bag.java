package 基础.背包队列栈;

import java.util.Iterator;

import java.util.NoSuchElementException;

/**
 * 定义泛型背包类
 */
public class Bag<Item> implements Iterable<Item> {
    //泛型元素链表
    private Node first;
    //元素数量
    private int N;
    //当前链表指向的元素


    /**
     * 创建一个控背包
     */
    public Bag() {

    }

    /**
     * 添加一个元素
     * @param item
     */
    public void add(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item=item;
        first.next=oldFirst;
        N++;
    }

    /**
     * 背包是否为空
     * @return
     */
    public boolean isEmpty(){

        return first==null;
    }
//    public Iterator iterator(){
//        return (Iterator) new ListIterator<Item>(first);
//    }

    /**
     * 背包中元素的数量
     * @return
     */
    public int size(){
        return N;
    }

    /**
     * 实现一个迭代器
     * @return
     */
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator(first);

    }

    /**
     * 具体迭代器实现
     *
     */
    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        /**
         * 使用背包的链表子元素
         * @param first
         */
        public ListIterator(Node first) {
            this.current = first;
        }

        /**
         * 链表是否为空
         * @return
         */
        public boolean hasNext() {
            return current != null;
        }
        public void remove(){
            throw new UnsupportedOperationException();
        }

        /**
         * 当前链表的下一个元素
         * @return
         */
        public Item next() {
//            if (!hasNext()){
//                throw new NoSuchElementException();
//            }
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
