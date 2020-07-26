package org.zero._02_链表;

import org.zero._00_统一接口.ZeroList;

/**
 * @author 水寒
 * @date 2020/5/19
 */
public class Main {

    public static void main(String[] args) {
        ZeroList<Integer> list = new ZeroSingleLinkedList<>();
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

        System.out.println(list.get(0));
    }
}
