package com.algs.basic.stack.ex;

/**
 * 删除第k个元素的队列(数组实现)
 *
 * @author cntlb
 * @since 2020/2/27 14:21
 */
public class GeneralizedArrayQueue<E> {
    private int n;
    private E[] a = (E[]) new Object[1];
    private int last;


    public boolean isEmpty() {
        return n == 0;
    }

    public void insert(E e) {
        if (isEmpty()) {
            last = 0;
            a[last] = e;
        } else {
            a[++last] = e;
        }
        n++;
        if (n == a.length) resize(2 * n);
    }

    /**
     * 删除第k个元素
     */
    public E delete(int k) {
        if (k < 0 || k >= n) throw new IndexOutOfBoundsException();
        E item = a[k];
        //[k+1,n]移动到[k,n-1]
        for (int i = k; i < n - 1; i++) {
            a[i] = a[i + 1];
        }
        a[n - 1] = null;
        last--;
        n--;
        if (n > 0 && n < a.length / 4) resize(a.length / 2);
        return item;
    }

    private void resize(int cap) {
        E[] b = (E[]) new Object[cap];
        for (int i = 0; i < n; i++) {
            b[i] = a[i];
        }
        a = b;
    }

    public static void main(String[] args) {
        GeneralizedArrayQueue<Integer> q = new GeneralizedArrayQueue<>();
        q.insert(1);
        q.insert(2);
        q.insert(3);
        q.insert(4);
        q.insert(5);
        q.delete(3);
        q.delete(3);
    }
}
