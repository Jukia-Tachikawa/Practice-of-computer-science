package assignment08;
import java.util.*;
public class SortSpeed {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < 100000; i++) {
			list.add((int)(Math.random() * i));
		}
		
		
		
		long start = System.currentTimeMillis();
		list.sort(null);
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		
		start = System.currentTimeMillis();
		QuickSort.sort(list);
		end = System.currentTimeMillis();
		System.out.println(end - start);
	}
}
