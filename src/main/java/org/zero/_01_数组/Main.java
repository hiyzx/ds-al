package org.zero._01_数组;

/**
 * @author 水寒
 * @date 2020/5/19
 */
public class Main {

	public static void main(String[] args){
		ZeroArrayList list = new ZeroArrayList(5);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);

		list.set(1,22);
		list.remove(1);
		System.out.println(list);
	}
}
