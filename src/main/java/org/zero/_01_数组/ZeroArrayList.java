package org.zero._01_数组;


import org.zero._00_统一接口.ZeroAbstractList;

import java.util.Objects;

/**
 * @author 水寒
 * @date 2020/5/19
 */
public class ZeroArrayList<E> extends ZeroAbstractList<E> {

    /**
     * 所有元素数组
     */
    private E[] elements;

    /**
     * 默认容量
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 不存在的元素索引
     */
    private static final int ELEMENT_NOT_FOUNT = -1;

    /**
     * 默认构造器
     */
    public ZeroArrayList() {
        this(DEFAULT_CAPACITY);
    }

    /**
     *  构造器
     * @param capacity 默认容量
     */
    public ZeroArrayList(int capacity) {
        capacity = (capacity <= 0) ? DEFAULT_CAPACITY : capacity;
        elements = (E[]) new Object[capacity];
    }

    /**
     * 获取某个索引的元素
     */
    @Override
    public E get(int index) {
        rangeCheck(index);
        return (E) elements[index];
    }

    /**
     * 设置集合的元素
     */
    @Override
    public E set(int index, E element) {
        rangeCheck(index);
        E old = elements[index];
        elements[index] = element;
        return old;
    }

    /**
     * 获取元素的索引
     */
    @Override
    public int indexOf(E element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (Objects.equals(elements[i], element)) {
                    return i;
                }
            }
        }
        return ELEMENT_NOT_FOUNT;
    }

    /**
     * 清空集合
     */
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }


    /**
     * 指定位置添加元素
     */
    @Override
    public void add(int index, E element) {
        // 校验index
        rangeCheckForAdd(index);
        // 校验扩容
        ensureCapacity(size + 1);
        // 插入元素
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    /**
     * 扩容
     */
    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) {
            return;
        }
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[])new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
        System.out.println("数组扩容: " + oldCapacity + "->" + newCapacity);
    }

    /**
     * 删除元素
     */
    @Override
    public E remove(int index) {
        rangeCheck(index);
        E old = (E) elements[index];
        for (int i = index + 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }
        size--;
        return old;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("size:").append(size).append(",[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i != size - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
