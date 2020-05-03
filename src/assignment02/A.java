package assignment02;

import java.util.Arrays;

public class A {
	public static void main(String[] args) {
		int[] a = new int[1000];
		for(int i = 1; i <= 1000; i++) {
			a[i - 1] = (int) (Math.random() * i);
		}
		
		Arrays.sort(a);
	}
}
