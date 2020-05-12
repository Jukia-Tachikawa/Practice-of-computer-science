package assignment04;

import java.util.*;
import java.util.concurrent.*;
import util.myexception.IllegalInputIntegerException;
import util.io.*;

public class MyListTest{
	// 標準入力のScanner
	private static StdinScanner sc = new StdinScanner();
	//入力待ちの待ち時間.
  private static final long TIMEOUT = 3;
  private static final TimeUnit UNIT = TimeUnit.MINUTES;

	//10個の自然数をキーボードから入力し，それらを入力順に先頭から並べたリストを作り，画面に表示する．
	private static void input(LinkedList<Integer> list) throws TimeoutException{
		MyList mylist = new MyList();

		//自然数を10個listに追加する
		System.out.println("自然数を10個入力してください.");
		for(int i = 0; i < 10; i++) {
			int number = sc.nextInt(TIMEOUT, UNIT);
			if(number > 0){
				list.add(number);
			}else{
				throw new IllegalInputIntegerException();
			}
		}
		mylist.output(list); //listの内容を表示.
	}

	//次の処理を10回繰り返す: 自然数をキーボードから入力する度に，それを insert した結果のリストを出力する．
	private static void insertTest(LinkedList<Integer> list) throws TimeoutException {
		MyList mylist = new MyList();
		//入力された1個の自然数についてinsertし,outputすることを10回行う.
		for(int i = 1; i <= 10; i++) {
			System.out.println("insert-" + i + " : 自然数を1個入力してください.");
			int number = sc.nextInt(TIMEOUT, UNIT);
			if(number > 0){
				mylist.insert(number, list);
				mylist.output(list);
			}else{ //int型で自然数でなければIllegalInputIntegerExceptionを発生.
				throw new IllegalInputIntegerException();
			}
		}
	}

	/*
	 * 次の処理を10回繰り返す: 自然数をキーボードから入力する度に，それを delete した結果のリストを出力する．
	 * insertTest()とほぼ同様の仕様.
	*/
	private static void deleteTest(LinkedList<Integer> list) throws TimeoutException {
		MyList mylist = new MyList();
		//入力された1個の自然数についてdeleteし,outputすることを10回行う.
		for(int i = 1; i <= 10; i++) {
			System.out.println("delete-"+ i +" : 自然数を1個入力してください.");
			int number = sc.nextInt(TIMEOUT, UNIT);
			if(number > 0){
				mylist.delete(number, list);
				mylist.output(list);
			}else{ //int型で自然数でなければIllegalInputIntegerExceptionを発生.
				throw new IllegalInputIntegerException();
			}
		}
	}

	public static void main(String[] args) {
		//自然数のリスト
		LinkedList<Integer> list = new LinkedList<>();

		try{
			MyListTest.input(list);
			MyListTest.insertTest(list);
			MyListTest.deleteTest(list);
		}catch(InputMismatchException | IllegalInputIntegerException e){ //入力が自然数でない場合はエラーメッセージを出し、プログラム終了.
			System.out.println("エラー: 入力形式が不適切です. 自然数を入力してください.");
			return;
		}catch (TimeoutException e) {
			System.out.println("一定時間入力がなかったため, プログラムを終了します.");
			System.exit(1); // StdinScanner.javaの28行目からの理由によってreturnではなくSystem.exit(1).
		}finally{
			sc.close();
		}
	}
}
