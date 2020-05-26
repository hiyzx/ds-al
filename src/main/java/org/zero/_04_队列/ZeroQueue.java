package org.zero._04_队列;

import java.util.LinkedList;
import java.util.List;

/**
 * 先进先出
 *
 * @author 水寒
 * @date 2020/5/27
 */
public class ZeroQueue<E> {

    private List<E> list = new LinkedList<>();

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void clear() {
        list.clear();
    }

    public void enQueue(E element) {
        list.add(element);
    }

    public void deQueue() {
        list.remove(0);
    }

    public E front() {
        return list.get(0);
    }
}
