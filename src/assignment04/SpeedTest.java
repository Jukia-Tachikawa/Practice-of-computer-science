package assignment04;
import java.util.*;

public class SpeedTest {
	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<>();
		MyList mylist = new MyList();
		int x = 600000;
		long start, end;
		
		for(int i = 0; i < 1000000; i++) {
			linkedList.add(i);
		}
		
		//insert
		start = System.currentTimeMillis();
		mylist.insert(x, linkedList);
		end = System.currentTimeMillis();
		System.out.println(end - start);
		
		start = System.currentTimeMillis();
		for(int i = 0; i < linkedList.size(); i++) {
			if(x <= linkedList.get(i)) {
				linkedList.add(i, x);
				break;
			}
		}
		end = System.currentTimeMillis();
		System.out.println(end - start);
				
	}
}
