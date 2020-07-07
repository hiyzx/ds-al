package org.zero._07_红黑树;

import com.sun.deploy.util.BlackList;
import org.zero._05_二叉搜索树.BinarySearchTree;

import java.util.Comparator;

/**
 * @author 水寒
 * @date 2020/6/22
 */
public class RbTree<E> extends BinarySearchTree<E> {

    private static final boolean RED = false;
    private static final boolean BLACK = true;

    public RbTree() {
        this(null);
    }

    public RbTree(Comparator<E> comparator) {
        super(comparator);
    }

    @Override
    protected void afterAdd(Node<E> node) {
        Node<E> parent = node.parent;

        // 添加的是根节点,或者上溢达到根节点
        if (parent == null) {
            black(node);
            return;
        }

        // 如果父节点是黑色,直接返回
        if (isBlack(parent)) {
            return;
        }

        // 叔父节点
        Node<E> uncle = parent.sibling();
        // 祖父节点
        Node<E> grand = red(parent.parent);
        if (isRed(uncle)) { // 叔父节点是红色【B树节点上溢】
            black(parent);
            black(uncle);
            // 把祖父节点当做是新添加的节点
            afterAdd(grand);
            return;
        }

        // 叔父节点不是红色
        if (parent.isLeftChild()) { // L
            if (node.isLeftChild()) { // LL
                black(parent);
            } else { // LR
                black(node);
                rotateLeft(parent);
            }
            rotateRight(grand);
        } else { // R
            if (node.isLeftChild()) { // RL
                black(node);
                rotateRight(parent);
            } else { // RR
                black(parent);
            }
            rotateLeft(grand);
        }

    }

    // 左旋
    private void rotateLeft(Node<E> grand) {
        Node<E> parent = grand.right;
        Node<E> child = parent.left;
        grand.right = child;
        parent.left = grand;
        afterRotate(grand, parent, child);
    }

    // 右旋
    private void rotateRight(Node<E> grand) {
        Node<E> parent = grand.left;
        Node<E> child = parent.right;
        grand.left = child;
        parent.right = grand;
        afterRotate(grand, parent, child);

    }

    // 统一旋转处理
    private void afterRotate(Node<E> grand, Node<E> parent, Node<E> child) {
        parent.parent = grand.parent;
        if (grand.isLeftChild()) {
            grand.parent.left = parent;
        } else if (grand.isRightChild()) {
            grand.parent.right = parent;
        } else {
            root = parent;
        }

        if (child != null) {
            child.parent = grand;
        }
        grand.parent = parent;
    }

    @Override
    protected Node<E> createNode(E element, Node<E> parent) {
        return new RbNode<>(element, parent);
    }

    // 染红
    private Node<E> red(Node<E> node) {
        return color(node, RED);
    }

    // 染黑
    private Node<E> black(Node<E> node) {
        return color(node, BLACK);
    }

    private boolean isRed(Node<E> node) {
        return colorOf(node) == RED;
    }

    private boolean isBlack(Node<E> node) {
        return colorOf(node) == BLACK;
    }

    // 返回节点颜色
    private boolean colorOf(Node<E> node) {
        return node == null ? BLACK : ((RbNode<E>) node).color;
    }

    // 染色
    private Node<E> color(Node<E> node, boolean color) {
        if (node == null) {
            return node;
        } else {
            ((RbNode<E>) node).color = color;
            return node;
        }
    }

    private static class RbNode<E> extends Node<E> {
        boolean color = RED;

        public RbNode(E element, Node<E> parent) {
            super(element, parent);
        }

        @Override
        public String toString() {
            String str = "";
            if (color == RED) {
                str = "R_";
            }
            return str + element.toString();
        }
    }

}
