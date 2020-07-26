package org.zero._08_集合;

/**
 * @author 水寒
 * @date 2020/6/27
 */
public class Main {

    public static void main(String[] args) {
        ZeroSet<Integer> set = new ZeroListSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(4);
        set.add(5);
        set.traversal(new ZeroSet.Visitor<Integer>() {
            @Override
            public boolean visit(Integer element) {
            	System.out.println(element);
                return false;
            }
        });
    }
}
