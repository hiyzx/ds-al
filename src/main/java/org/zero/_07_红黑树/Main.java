package org.zero._07_红黑树;

import org.zero.printer.BinaryTrees;

public class Main {

    public static void main(String[] args) {
        Integer data[] = new Integer[] {55, 87, 56, 74, 96, 22, 62, 20, 70, 68, 90, 50};

        ZeroRbTree<Integer> rb = new ZeroRbTree<>();
        for (int i = 0; i < data.length; i++) {
            rb.add(data[i]);
			System.out.println("---------------------------------------");
			System.out.println("【" + data[i] + "】");
			BinaryTrees.println(rb);
        }

        BinaryTrees.println(rb);

        for (int i = 0; i < data.length; i++) {
            rb.remove(data[i]);
            System.out.println("---------------------------------------");
            System.out.println("【" + data[i] + "】");
            BinaryTrees.println(rb);
        }
    }
}
