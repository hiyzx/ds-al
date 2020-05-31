package org.zero._01_数组;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 水寒
 * @date 2020/5/19
 */
public class Main {

    public static void main(String[] args) {
        ZeroArrayList<Integer> list = new ZeroArrayList<>(5);
        list.add(1);
        System.out.println(list);
        list.add(2);
        System.out.println(list);
        list.add(3);
        System.out.println(list);
        list.add(4);
        System.out.println(list);
        list.add(5);
        System.out.println(list);
        list.add(6);
        System.out.println(list);
        list.set(1, 22);
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
    }
}
