package assignment03;
import java.util.*;

public class BubbleSort {

	//バブルソートによりarrayListに格納されているデータを昇順ソートする．
	public static void sort(ArrayList<Integer> arrayList) {
		for(int i = arrayList.size() - 1 ; i > 0; i--) {
			//0-i番目までの整数のうち最大のものをi番目に持ってくる
			for(int j = 0; j < i; j++) {
				int current = arrayList.get(j);
				int next = arrayList.get(j+1);
				
				if(current > next) {
					arrayList.set(j, next);
					arrayList.set(j+1, current);
				}
			}
		}
	}
}
