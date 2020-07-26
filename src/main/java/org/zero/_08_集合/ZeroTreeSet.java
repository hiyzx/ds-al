package org.zero._08_集合;

import org.zero._05_二叉搜索树.ZeroBinarySearchTree;
import org.zero._07_红黑树.ZeroRbTree;

/**
 * @author 水寒
 * @date 2020/7/27
 */
public class ZeroTreeSet<E> implements ZeroSet<E> {

	private ZeroBinarySearchTree<E> rbTree;

	ZeroTreeSet(){
		rbTree = new ZeroRbTree<>();
	}

    @Override
    public int size() {
        return rbTree.size();
    }

    @Override
    public boolean isEmpty() {
        return rbTree.isEmpty();
    }

    @Override
    public void clear() {
		rbTree.clear();
    }

    @Override
    public boolean contains(E element) {
        return rbTree.contains(element);
    }

    @Override
    public void add(E element) {
		rbTree.add(element);
    }

    @Override
    public void remove(E element) {
		rbTree.remove(element);
    }

    @Override
    public void traversal(Visitor<E> visitor) {

    }
}
