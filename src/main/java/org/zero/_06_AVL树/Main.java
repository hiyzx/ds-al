package org.zero._06_AVL树;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.zero.printer.BinaryTrees;

/**
 * @author 水寒
 * @date 2020/5/30
 */
public class Main {

    public static AvlTree<Integer> testComparator() {
        List<Integer> list = Arrays.asList(5, 3, 7, 6, 2, 8, 4, 9);
        AvlTree<Integer> tree = new AvlTree<>(Comparator.comparingInt(o -> o));
        for (int i = 0; i < list.size(); i++) {
            tree.add(list.get(i));
        }
        BinaryTrees.print(tree);
        return tree;
    }

    public static void main(String[] args) {
        AvlTree<Integer> tree = testComparator();
        // tree.preOrder();
        // tree.inOrder();
        // tree.postOrder();
        /*
         * tree.levelOrder(element -> { System.out.println("层序遍历" + element); return
         * element == 4; });
         */
        // System.out.println(tree.height());
        // System.out.println(tree.isComplete());
        // testComparable();
        // System.out.println(tree.predecessor(tree.node(6)));
        // System.out.println(tree.successor(tree.node(6)));
    }
}
