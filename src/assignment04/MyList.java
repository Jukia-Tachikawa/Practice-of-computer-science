package assignment04;
import java.util.*;

public class MyList {
	//linkedList に x をinsert する．
	public void insert(int x, LinkedList<Integer> linkedList) {
		//linkedListの一番前の要素から順にxと比較し,x以上であればその直前に挿入
		ListIterator<Integer> it = linkedList.listIterator();
		while(it.hasNext()) {
			if(x <= it.next()) {
				it.previous(); // ひとつ前に戻る.
				it.add(x);
				return;
			}
		}
		it.add(x);
	}
	//linkedList から x を全て delete する.
	public void delete(int x, LinkedList<Integer> linkedList) {
		List<Integer> remove = new ArrayList<>();
		remove.add(x);
		linkedList.removeAll(remove);
	}
	//linkedList の内容を表示する．
	public void output(LinkedList<Integer> linkedList) {
		for(Integer n:linkedList) {
			System.out.print(n + " ");
		}
		System.out.print("\n"); //最後に改行.
	}
}
