package com.algs.basic.stack;

import java.util.Iterator;

interface IStack<Item> {
    void push(Item item);

    Item pop();

    boolean isEmpty();

    int size();
}
