package com.algs.basic.stack.ex;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author cntlb
 * @since 2020/2/26 16:13
 */
public class DrawTest {
    public static void main(String[] args) throws Exception {
        int n = 0;
        if(args.length != 0)
            n = Integer.parseInt(args[0]);
        Method method = DrawTest.class.getDeclaredMethod("draw" + n);
        method.invoke(null);
    }

    private static void draw0() {
        int n = 100;
        StdDraw.setXscale(0, n);
        StdDraw.setYscale(0, n * n);
        StdDraw.setPenRadius(.01);
        for (int i = 0; i <= n; i++) {
            StdDraw.setPenColor(Color.RED);
            StdDraw.point(i, i);
            StdDraw.setPenColor(Color.GREEN);
            StdDraw.point(i, i * i);
            StdDraw.setPenColor(Color.BLACK);
            StdDraw.point(i, i * Math.log(i));
        }
    }

    private static void draw1() {
        int n = 50;
        double[] a = new double[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.random();
        }
        for (int i = 0; i < n; i++) {
            double x = 1.0*i/n;
            double y = a[i]/2.0;
            double rw = .5/n;
            double rh = a[i]/2.0;
            StdDraw.filledRectangle(x,y,rw, rh);
        }
    }

    private static void draw2() {
        int n = 50;
        double[] a = new double[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.random();
        }
        Arrays.sort(a);
        for (int i = 0; i < n; i++) {
            double x = 1.0*i/n;
            double y = a[i]/2.0;
            double rw = .5/n;
            double rh = a[i]/2.0;
            StdDraw.filledRectangle(x,y,rw, rh);
        }
    }
}
