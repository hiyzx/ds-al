package org.zero._08_集合;

import org.zero._01_数组.ZeroArrayList;

/**
 * @author 水寒
 * @date 2020/6/27
 */
public class ZeroListSet<E> implements ZeroSet<E> {

    private ZeroArrayList<E> list;

    public ZeroListSet(){
        list = new ZeroArrayList<>();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public boolean contains(E element) {
        return list.contains(element);
    }

    @Override
    public void add(E element) {
        int index = list.indexOf(element);
        if (index != ZeroArrayList.ELEMENT_NOT_FOUNT) {
            list.set(index, element);
        } else {
            list.add(element);
        }
    }

    @Override
    public void remove(E element) {
        int index = list.indexOf(element);
        if (index != ZeroArrayList.ELEMENT_NOT_FOUNT) {
            list.remove(index);
        }
    }

    @Override
    public void traversal(Visitor<E> visitor) {
        if (visitor == null) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (visitor.visit(list.get(i))) {
                return;
            }
        }
    }
}
