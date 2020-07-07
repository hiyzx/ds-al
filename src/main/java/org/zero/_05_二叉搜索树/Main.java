package org.zero._05_二叉搜索树;

import org.zero.printer.BinaryTrees;

import java.util.Arrays;
import java.util.List;

/**
 * @author 水寒
 * @date 2020/5/30
 */
public class Main {

    public static BinarySearchTree<Integer> testComparator() {
        List<Integer> list = Arrays.asList(5, 3, 7, 6, 2, 8, 4, 1);
        BinarySearchTree<Integer> tree = new BinarySearchTree<>((o1, o2) -> o1 - o2);
        for (int i = 0; i < list.size(); i++) {
            tree.add(list.get(i));
        }
        BinaryTrees.print(tree);
        return tree;
    }

    public static BinarySearchTree<Person> testComparable() {
        List<Integer> list = Arrays.asList(5, 3, 7, 8, 2, 9, 4);
        BinarySearchTree<Person> tree = new BinarySearchTree<>();
        for (int i = 0; i < list.size(); i++) {
            tree.add(new Person(list.get(i)));
        }
        BinaryTrees.print(tree);
        return tree;
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = testComparator();
        // tree.preOrder();
        // tree.inOrder();
        // tree.postOrder();
        /*tree.levelOrder(element -> {
            System.out.println("层序遍历" + element);
            return element == 4;
        });*/
        // System.out.println(tree.height());
        // System.out.println(tree.isComplete());
        // testComparable();
        // System.out.println(tree.predecessor(tree.node(6)));
        // System.out.println(tree.successor(tree.node(6)));
        tree.remove(3);
        System.out.print("");
        BinaryTrees.print(tree);
    }
}

class Person implements Comparable<Person> {

    private Integer age;

    public Person(Integer age) {
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        return age - o.age;
    }

    @Override
    public String toString() {
        return "age=" + age;
    }
}
