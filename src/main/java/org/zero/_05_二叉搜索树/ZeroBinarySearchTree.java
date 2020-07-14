package org.zero._05_二叉搜索树;

import org.zero.printer.BinaryTreeInfo;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 水寒
 * @date 2020/5/30
 */
public class ZeroBinarySearchTree<E> implements BinaryTreeInfo {

    // 节点数量
    protected int size;

    // 根节点
    protected Node<E> root;

    protected Comparator<E> comparator;

    // 带比较的构造器
    public ZeroBinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    // 无参构造器, 使用类自定义的比较
    public ZeroBinarySearchTree() {}

    // 添加元素
    public void add(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element 不能为空");
        }
        // 如果根节点为空,直接添加到根节点
        if (root == null) {
            root = createNode(element, null);
            afterAdd(root);
            return;
        }
        // 非根节点
        Node<E> parent = root;
        Node<E> node = root;
        while (node != null) {
            parent = node;
            int compare = compare(element, node.element);
            if (compare > 0) { // element > node, 右子节点
                node = node.right;
            } else if (compare < 0) { // element < node, 左子节点
                node = node.left;
            } else {
                return;
            }
        }
        // 插入节点
        Node<E> newElement = createNode(element, parent);
        int compare = compare(newElement.element, parent.element);
        if (compare > 0) { // 右子节点
            parent.right = newElement;
        } else {
            parent.left = newElement;
        }
        size++;
        afterAdd(newElement);
    }

    /**
     * 添加后的操作
     */
    protected void afterAdd(Node<E> node) {}

    /**
     * 删除后的操作
     */
    protected void afterRemove(Node<E> node) {}

    protected Node<E> createNode(E element, Node<E> parent) {
        return new Node<>(element, parent);
    }

    // 是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 返回数量
    public int size() {
        return size;
    }

    // 清空
    public void clear() {
        root = null;
        size = 0;
    }

    // 比较
    private int compare(E e1, E e2) {
        if (comparator != null) {
            return comparator.compare(e1, e2);
        }
        return ((Comparable<E>)e1).compareTo(e2);
    }

    // 前序遍历 从上到下, 中 左 右
    public void preOrder(Visitor<E> visitor) {
        preOrder(root, visitor);
    }

    private void preOrder(Node<E> node, Visitor<E> visitor) {
        if (node == null) {
            return;
        }
        System.out.println(node.element);
        preOrder(node.left, visitor);
        preOrder(node.right, visitor);
    }

    // 中序遍历 从下到上, 左 中 右, 有一个从小到大的顺序(返过来也行)
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node<E> node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.element);
        inOrder(node.right);
    }

    // 后序遍历 从下到上 左 右 中
    public void postOrder(Visitor<E> visitor) {
        postOrder(root);
    }

    private void postOrder(Node<E> node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.element);
    }

    // 层序遍历 (使用队列先进先出来实现)
    public void levelOrder(Visitor<E> visitor) {
        if (root == null) {
            return;
        }
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            if (visitor.visitor(node.element)) {
                return;
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    /**
     * 计算二叉树的高度
     *
     * @return 树高
     */
    public int height() {
        if (root == null) {
            return 0;
        }
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        int levelSize = 0;// 队列容量,后面用来判断是否遍历完一个层级
        int height = 0;// 树高,没遍历完一个层级就+1
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
                levelSize++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                levelSize++;
            }
            if (levelSize == queue.size()) {
                height++;
                levelSize = 0;
            }
        }

        return height;
    }

    /**
     * 递归计算二叉树的高度
     *
     * @return 树高
     */
    public int height2() {
        return height(root);
    }

    public int height(Node<E> node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    /**
     * 判断一棵树是否完全二叉树
     *
     * @return 返回值
     */
    public boolean isComplete() {
        if (root == null) {
            return false;
        }
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        boolean leaf = false;
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            System.out.println(node.element);
            if (leaf && !node.isLeaf()) {
                return false;
            }
            if (node.left != null) {
                queue.offer(node.left);
                if (node.right != null) {
                    queue.offer(node.right);
                } else {
                    leaf = true;
                }
            } else {
                if (node.right != null) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 前驱节点
     */
    public Node<E> predecessor(Node<E> node) {
        if (node == null) {
            return null;
        }
        // 如果前驱节点在左子树中.
        Node<E> p = node.left;
        if (p != null) {
            while (p.right != null) {
                p = p.right;
            }
            return p;
        }
        // 左子树没有,就往父节点,祖父节点寻找
        while (node.parent != null && node == node.parent.left) {
            node = node.parent;
        }
        return node.parent;
    }

    /**
     * 后驱节点
     */
    public Node<E> successor(Node<E> node) {
        if (node == null) {
            return null;
        }
        // 如果后驱节点在右子树中.
        Node<E> p = node.right;
        if (p != null) {
            while (p.left != null) {
                p = p.left;
            }
            return p;
        }
        // 右子树没有,就往父节点,祖父节点寻找
        while (node.parent != null && node == node.parent.right) {
            node = node.parent;
        }
        return node.parent;
    }

    /**
     * 删除元素
     */
    public void remove(E element) {
        remove(node(element));
    }

    /**
     * 删除元素
     */
    public void remove(Node<E> node) {
        if (node == null) {
            return;
        }
        size--;
        // 如果删除的是度为2的节点,则用他的后驱节点来覆盖
        if (node.hasTwoChildren()) {
            // 找到后驱节点
            Node<E> successor = successor(node);
            node.element = successor.element;
            // 这里直接将后驱节点赋值给node,后面也是删除node的逻辑.
            node = successor;
        }

        // node的前驱或者后继节点,必然是度为0或者1
        Node<E> replacement = node.left != null ? node.left : node.right;

        if (replacement != null) { // 度为1的节点
            // 更改parent
            replacement.parent = node.parent;
            if (node.parent == null) { // 根节点
                root = replacement;
            } else { // 不是根节点
                if (node == node.parent.left) {
                    node.parent.left = replacement;
                } else {
                    node.parent.right = replacement;
                }
            }
            afterRemove(node);
        } else { // 叶子节点
            if (node.parent == null) { // 根节点
                root = null;
            } else { // 不是根节点
                if (node == node.parent.left) {
                    node.parent.left = null;
                } else {
                    node.parent.right = null;
                }
            }
        }
    }

    /**
     * 根据元素找到节点对象
     */
    public Node<E> node(E element) {
        Node<E> node = root;
        while (node != null) {
            int compare = compare(element, node.element);
            if (compare > 0) {
                node = node.right;
            } else if (compare < 0) {
                node = node.left;
            } else {
                return node;
            }
        }
        return null;
    }

    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((Node<E>)node).left;
    }

    @Override
    public Object right(Object node) {
        return ((Node<E>)node).right;
    }

    @Override
    public Object string(Object node) {
        Node<E> myNode = (Node<E>)node;
        String parentString = "null";
        if (myNode.parent != null) {
            parentString = myNode.parent.element.toString();
        }
        return myNode.element + "_p(" + parentString + ")";
    }

    // 节点对象
    protected static class Node<E> {
        // 父节点
        public Node<E> parent;
        // 当前节点
        public E element;
        // 左子节点
        public Node<E> left;
        // 右子节点
        public Node<E> right;

        protected Node(E element, Node<E> parent) {
            this.parent = parent;
            this.element = element;
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }

        public boolean hasTwoChildren() {
            return left != null && right != null;
        }

        public boolean isLeftChild() {
            return parent != null && this == parent.left;
        }

        public boolean isRightChild() {
            return parent != null && this == parent.right;
        }

        public Node<E> sibling() {
            if (isLeftChild()) {
                return parent.right;
            }

            if (isRightChild()) {
                return parent.left;
            }

            return null;
        }

        @Override
        public String toString() {
            return "element = " + element;
        }
    }

    public static interface Visitor<E> {

        Boolean visitor(E element);
    }
}
