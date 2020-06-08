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

    // 集合长度
    public int size() {
        return list.size();
    }

    // 是否为空
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // 清空
    public void clear() {
        list.clear();
    }

    // 进
    public void enQueue(E element) {
        list.add(element);
    }

    // 出
    public void deQueue() {
        list.remove(0);
    }

    // 获取第一个元素
    public E front() {
        return list.get(0);
    }
}
