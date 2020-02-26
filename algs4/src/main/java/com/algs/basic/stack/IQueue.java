package com.algs.basic.stack;

/**
 * @author cntlb
 * @since 2020/2/26 11:17
 */
public interface IQueue<Item> {
    void enqueue(Item item);
    Item dequeue();
    int size();
    boolean isEmpty();
}
