package com.algs.basic.stack.ex;

import com.algs.basic.stack.Queue;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * Josephus问题:
 *
 * 假设有N个人围坐一圈并从第1个人开始报数，报到M的人被杀死,直到最后一个人留下来.
 *
 * @author cntlb
 * @since 2020/2/27 13:39
 */
public class Josephus {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int M = Integer.parseInt(args[1]);
        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i < N; i++) {
            queue.enqueue(i);
        }

        int k = 1;
        while (!queue.isEmpty()) {
            Queue<Integer> org = queue;
            queue = new Queue<>();
            Iterator<Integer> itr = org.iterator();
            while (itr.hasNext()) {
                if (k % M != 0)
                    queue.enqueue(itr.next());
                else
                    StdOut.print(itr.next() + " ");
                k++;
            }
        }
        //参考答案
        /*
        while (!queue.isEmpty()) {
            for (int i = 0; i < M - 1; i++) {
                queue.enqueue(queue.dequeue());
            }
            StdOut.print(queue.dequeue() + " ");
        }*/
        StdOut.println();
    }
}
