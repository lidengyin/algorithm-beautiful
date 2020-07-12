package 基础.背包队列栈;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 下压栈
 * @param <Item>
 */
public class Stack<Item> implements Iterable<Item> {
    //下压栈栈顶(最近添加的元素)
    private Node first;
    //元素数量
    private int N;

    /**
     * 空构造函数
     */
    public Stack() {
    }

    /**
     * 添加一个元素
     * @param item
     */
    public void push(Item item){
        //
        Node oldFirst = first;
        first = new Node();
        first.item=item;
        first.next=oldFirst;
        N++;
    }

    /**
     * 删除最近添加的元素
     * @return
     */
    public Item pop(){
//        if (first == null){
//            throw new NoSuchElementException();
//        }
        Item item = first.item;
        first=first.next;
        N--;
        return item;
    }

    /**
     * 栈是否为空
     * @return
     */
    public boolean isEmpty(){
        return first==null;
    }//或者:N==0

    /**
     * 栈中元素数量
     * @return
     */
    public int size(){
        return N;
    }


    @Override
    public Iterator<Item> iterator() {
        return new StackIterator(first);
    }
    private class  StackIterator implements Iterator<Item>{
        private Node current;

        public StackIterator(Node first) {
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
            current = current.next;
            return item;
        }
    }
    private class Node{
        //定义了结点的嵌套类
        Item item;
        Node next;
    }

}
