package assignment08;
import java.util.*;
import java.io.*;
public class SortTest {
	
	//入力ファイル名とArrayListを受け取り, 入力ファイル内の整数を読み込んで, arrayListに格納する.
	private static void inputArrayListFromFile(String filename, ArrayList<Integer> arrayList) throws FileNotFoundException{
		Scanner sc = new Scanner(new File(filename));
		//10000個まで整数を読み込む.
		for(int i = 0; i < 10000; i++) {
			if(sc.hasNext()) {
				arrayList.add(sc.nextInt());
			}
			else {
				break;
			}
		}	
		sc.close();
	}
	
	//ソートされたデータを標準出力に出力する.
	private static void outputArrayListToConsole(ArrayList<Integer> arrayList) {
		
		for(int i = 0; i < arrayList.size(); i++) {
			if(i % 10 == 9) {
				System.out.printf(" %8d%n", arrayList.get(i));
			}
			else {
				System.out.printf(" %8d", arrayList.get(i));
			}
		}
	}
	
	public static void main(String[] args) {
		//整数列を格納するリスト
		ArrayList<Integer> arrayList = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
				
		String filename;
		//ファイル名が指定されていなければ、エラーメッセージを出しファイル名入力を求める。
		if(args.length != 0) {
			filename = args[0];
		}else {
			System.out.println("ファイル名を入力してください.");
			filename = sc.next();
		}
		
		//ファイルの読み込みとデータの格納
		for(;;) {
			try {
				SortTest.inputArrayListFromFile(filename, arrayList);
			}catch(FileNotFoundException e) {	//ファイルが見つからなければ再度入力させる.
				System.out.println("指定されたファイルが見つかりません。");
				System.out.println("ファイル名を入力してください.");
				filename = sc.next();
				continue;
			}catch(InputMismatchException e) { //intでないものを含むときは実行終了
				System.out.println("ファイルの形式が不適切です。");
				System.out.println("ファイル名を入力してください.");
				filename = sc.next();
				continue;
			}
			break;
		}
		
		QuickSort.sort(arrayList);
		SortTest.outputArrayListToConsole(arrayList);
	}
}
