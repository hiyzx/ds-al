package org.zero._03_栈;

import java.util.ArrayList;
import java.util.List;

/**
 * 先进后出
 *
 * @author 水寒
 * @date 2020/5/21
 */
public class ZeroStack<E> {

    // 用集合来实现栈
    private List<E> list = new ArrayList<>();

    // 移动栈顶元素
    public void pop() {
        if (list.isEmpty()) {
            return;
        }
        list.remove(list.size() - 1);
    }

    // 往栈顶添加元素
    public void push(E e) {
        list.add(e);
    }

    // 获取栈顶元素
    public E top() {
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    // 判断栈是否为空
    public Boolean isEmpty() {
        return list.size() == 0;
    }

    // 返回栈元素数量
    public Integer size() {
        return list.size();
    }
}
