package org.zero._01_数组;


import java.util.Objects;

/**
 * @author 水寒
 * @date 2020/5/19
 */
public class ZeroArrayList<E> {

    /**
     * 元素数量
     */
    private int size;

    /**
     * 所有元素数组
     */
    private Object[] elements;

    /**
     * 默认容量
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 不存在的元素索引
     */
    private static final int ELEMENT_NOT_FOUNT = -1;

    public ZeroArrayList(int capacity) {
        capacity = (capacity <= 0) ? DEFAULT_CAPACITY : capacity;
        elements = new Object[capacity];
    }

    // 默认构造器
    public ZeroArrayList() {
        this(DEFAULT_CAPACITY);
    }

    // 返回集合长度
    public int size() {
        return size;
    }

    // 判断集合是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 判断集合是否包含某元素
    public boolean contain(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUNT;
    }

    // 获取某个索引的元素
    public E get(int index) {
        rangeCheck(index);
        return (E) elements[index];
    }

    // 设置集合的元素
    public void set(int index, E element) {
        rangeCheck(index);
        elements[index] = element;
    }

    // 获取元素的索引
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

    // 清空集合
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    // 添加元素
    public void add(E element) {
        this.add(size, element);
    }

    // 指定位置添加元素
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

    // 扩容
    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) {
            return;
        }
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        Object[] newElements = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
        System.out.println("数组扩容: " + oldCapacity + "->" + newCapacity);
    }

    // 删除元素
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

    // 校验索引
    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            outOfBounds(index);
        }
    }

    // 校验索引
    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            outOfBounds(index);
        }
    }

    // 抛异常
    private void outOfBounds(int index) {
        throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
    }
}
