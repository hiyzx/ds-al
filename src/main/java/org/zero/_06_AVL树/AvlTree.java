package org.zero._06_AVL树;

import org.zero._05_二叉搜索树.BinarySearchTree;

import java.util.Comparator;

/**
 * @author 水寒
 * @date 2020/6/10
 */
public class AvlTree<E> extends BinarySearchTree<E> {

    public AvlTree() {
        this(null);
    }

    public AvlTree(Comparator<E> comparator) {
        super(comparator);
    }

    @Override
    protected void afterAdd(Node<E> node) {
        while ((node = node.parent) != null) { // node往上的节点,都要更新高度
            if (isBalance(node)) { // 当前节点平衡,则更新高度
                updateHeight(node);
            } else { // 恢复平衡
                reBalance(node);
                // 如果当前节点平衡,则所有的节点平衡
                break;
            }
        }
    }

    @Override
    protected void afterRemove(Node<E> node) {
        while ((node = node.parent) != null) { // node往上的节点,都要更新高度
            if (isBalance(node)) { // 当前节点平衡,则更新高度
                updateHeight(node);
            } else { // 恢复平衡
                reBalance(node);
            }
        }
    }

    @Override
    protected Node<E> createNode(E element, Node<E> parent) {
        return new AvlNode<>(element, parent);
    }

    private void reBalance(Node<E> grand) {
        Node<E> parent = ((AvlNode<E>) grand).tallerChild();
        Node<E> node = ((AvlNode<E>) parent).tallerChild();
        if (parent.isLeftChild()) {
            if (node.isLeftChild()) { // LL
                rotateRight(grand);
            } else { // LR
                rotateRight(parent);
                rotateLeft(grand);
            }
        } else {
            if (node.isLeftChild()) { // RL
                rotateLeft(parent);
                rotateRight(grand);
            } else { // RR
                rotateLeft(grand);
            }
        }
    }

    private void rotateLeft(Node<E> grand) {
        Node<E> parent = grand.right;
        Node<E> child = parent.left;
        grand.right = child;
        parent.left = grand;
        afterRotate(grand, parent, child);
    }

    private void rotateRight(Node<E> grand) {
        Node<E> parent = grand.left;
        Node<E> child = parent.right;
        grand.left = child;
        parent.right = grand;
        afterRotate(grand, parent, child);

    }

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

        updateHeight(grand);
        updateHeight(parent);
    }

    // 是否平衡
    private boolean isBalance(Node<E> node) {
        return Math.abs(((AvlNode) node).balanceFactor()) <= 1;
    }

    // 更新高度
    private void updateHeight(Node<E> node) {
        ((AvlNode<E>) node).updateHeight();
    }

    private static class AvlNode<E> extends Node<E> {

        int height;

        public AvlNode(E element, Node<E> parent) {
            super(element, parent);
        }

        public int balanceFactor() {
            int leftHeight = left == null ? 0 : ((AvlNode) left).height;
            int rightHeight = right == null ? 0 : ((AvlNode) right).height;
            return leftHeight - rightHeight;
        }

        public void updateHeight() {
            int leftHeight = left == null ? 0 : ((AvlNode) left).height;
            int rightHeight = right == null ? 0 : ((AvlNode) right).height;
            height = 1 + Math.max(leftHeight, rightHeight);
        }

        public Node<E> tallerChild() {
            int leftHeight = left == null ? 0 : ((AvlNode<E>) left).height;
            int rightHeight = right == null ? 0 : ((AvlNode<E>) right).height;
            if (leftHeight > rightHeight) {
                return left;
            }
            if (leftHeight < rightHeight) {
                return right;
            }
            return isLeftChild() ? left : right;
        }
    }
}
