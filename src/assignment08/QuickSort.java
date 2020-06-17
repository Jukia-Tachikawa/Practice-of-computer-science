package assignment08;
import java.util.*;

public class QuickSort {
	private static final int INSERT_SIZE = 4;
	private static ArrayList<Integer> list;  //ソートするArrayList
	
	public static void sort(ArrayList<Integer> arrayList) {
		list = arrayList;
		partition(0, list.size() - 1);
	}
	
	private static void partition(int firstIndex, int lastIndex) {
		//要素数がINSER_SIZE以下の時は挿入ソートする.
		if(lastIndex - firstIndex <= INSERT_SIZE){
			for(int i = firstIndex + 1; i <= lastIndex; i++) {
				int pnum = list.get(i);

				if(list.get(i-1) > pnum){
					int j = i;
					while(j > 0 && list.get(j-1) > pnum){
						list.set(j, list.get(j-1));
						j--;
					}
					list.set(j, pnum);
				}
			
			}
			return;
		}else {
			int pivotValue = pivot(firstIndex, lastIndex);
			int left = firstIndex, right = lastIndex;
			
			//入れ替えが必要なところまでleft,rightを移動させる.
			for(;list.get(left) < pivotValue; left++);
			for(;list.get(right) > pivotValue; right--); 
	
			
			//pivot未満が前にpivot以上が後ろになるように並べ替える.
			while(left <= right) {
				//leftは先頭からpivotより小さいもの,rightは最後からpivot未満を探して入れ替える.
				int element_l = list.get(left), element_r = list.get(right);
						
				if(element_l <= pivotValue) {
					left++;
				}
				if(element_r >= pivotValue) {
					right--;
					continue;
				}
				if(element_l > pivotValue) {
					list.set(left, element_r);
					list.set(right, element_l);
					left++;
					right--;
				}
			}
			
			/*      pivot以下　<- | -> pivot以上
			 *     | |...|left-1|left|...|　|
			 * 		
			 * 		上図のようにlistを分割する
			 */
			if(left == firstIndex){ //leftとfirstIndexが等しい時、うまく分割できるようにするため.
				left++;
			}
			partition(firstIndex, left-1); 
			partition(left, lastIndex);
		}
	}
	
	//最初と最後、そして真ん中のあたりの中央値をpivotとする.
	static int pivot(int firstIndex, int lastIndex) { 
		int middleIndex = (firstIndex + lastIndex) / 2;
		int e1 = list.get(firstIndex), e2 = list.get(middleIndex), e3 = list.get(lastIndex);
		
		//e1,e2,e3の中央値を返す.
		if(e1 <= e2) {  
			if(e2 <= e3) {
				return e2;
			}else if(e1 <= e3){
				return e3;
			}else {
				return e1;
			}
		}else {
			if(e1 <= e3) {
				return e1;
			}else if(e2 <= e3) {
				return e3;
			}else {
				return e2;
			}
		}
	}
}
