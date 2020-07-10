package org.zero._00_统一接口;

/**
 * @author 水寒
 * @date 2020/7/10
 * @description 集合抽象类
 */
public abstract class ZeroAbstractList<E> implements ZeroList<E> {
    /**
     * 元素的数量
     */
    protected int size;

    /**
     * 元素的数量
     * 
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * 是否为空
     * 
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 是否包含某个元素
     * 
     * @param element
     * @return
     */
    @Override
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    /**
     * 添加元素到尾部
     * 
     * @param element
     */
    @Override
    public void add(E element) {
        add(size, element);
    }

    protected void outOfBounds(int index) {
        throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
    }

    protected void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            outOfBounds(index);
        }
    }

    protected void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            outOfBounds(index);
        }
    }
}
