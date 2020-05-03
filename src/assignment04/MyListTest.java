package assignment04;
import java.util.*;

public class MyListTest {
	public static void main(String[] args) {
		//自然数のリスト
		LinkedList<Integer> list = new LinkedList<>();
		
		MyListTest.input(list);
		MyListTest.insertTest(list);
		MyListTest.deleteTest(list);
		sc.close();
	}
	
	private static Scanner sc = new Scanner(System.in);
	
	//課題内容中の1の動作を行う.
	private static void input(LinkedList<Integer> list) {
		MyList mylist = new MyList();
		
		//自然数を10個listに追加する
		for(;;) {
			System.out.println("自然数を10個入力してください.");
			try {
				for(int i = 0; i < 10; i++) {
					list.add(sc.nextInt());
				}
				mylist.output(list);
				return;
			}catch(InputMismatchException e) {  //int以外がふくまれたときは再度入力を求める.
				System.out.println("入力形式が不適切です.");
				sc.nextLine();
			}
		}
	}
	//課題内容中の2の動作を行う.
	private static void insertTest(LinkedList<Integer> list) {
		MyList mylist = new MyList();
		//入力された1個の自然数についてinsertし,outputすることを10回行う.
		int count = 0;
		while(count < 10) {
			System.out.println("insert: 自然数を1個入力してください.");
			try {
				mylist.insert(sc.nextInt(), list);
				mylist.output(list);
				count++;
			}catch(InputMismatchException e) { //入力がintでなかった場合は10回のうちにカウントしないで次のループに移る。
				System.out.println("入力形式が不適切です.");
				sc.nextLine();
			}
		}
	}
	//課題内容中の3の動作を行う.
	private static void deleteTest(LinkedList<Integer> list) {
		MyList mylist = new MyList();
		//入力された1個の自然数についてdeleteし,outputすることを10回行う.
		int count = 0;
		while(count < 10) {
			System.out.println("delete: 自然数を1個入力してください.");
			try {
				mylist.delete(sc.nextInt(), list);
				mylist.output(list);
				count++;
			}catch(InputMismatchException e) { //入力がintでなかった場合は10回のうちにカウントしないで次のループに移る。
				System.out.println("入力形式が不適切です.");
				sc.nextLine();
			}
		}
	}
}
