package com.algs.basic.stack;

interface IStack<Item> {
    void push(Item item);

    Item pop();

    boolean isEmpty();

    int size();
}
