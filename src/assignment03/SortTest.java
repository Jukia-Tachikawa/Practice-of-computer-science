package assignment03;
import java.util.*;
import java.io.*;
import util.myexception.NumberOfInputException;
public class SortTest {

	//入力ファイル名とArrayListを受け取り, 入力ファイル内の整数を読み込んで, arrayListに格納する.
	private static void inputArrayListFromFile(String filename, ArrayList<Integer> arrayList) throws FileNotFoundException{
		Scanner sc = new Scanner(new File(filename));
		//10,001回整数を読み込む.
		for(int i = 1; i <= 10001; i++) {
			if(sc.hasNext()) {
				arrayList.add(sc.nextInt());
			}
			else { //入力された整数がi-1個(i=1,...,10,001)の場合はメソッドの処理は終了
				sc.close();
				return;
			}
		}

	  //入力が10,000個を超える場合は例外を発生する.
		sc.close();
		throw new NumberOfInputException(" 10,000個以上入力できません.");
	}

	//ソートされたデータを標準出力に出力する.
	private static void outputArrayListToConsole(ArrayList<Integer> arrayList) {

		for(int i = 0; i < arrayList.size(); i++) {
			if(i % 10 == 9) { //一番右端に表示される整数
				System.out.printf(" %8d%n", arrayList.get(i));
			}
			else { //それ以外
				System.out.printf(" %8d", arrayList.get(i));
			}
		}
	}

	public static void main(String[] args) {
		//整数列を格納するリスト
		ArrayList<Integer> arrayList = new ArrayList<>();
		//入力ファイル名
		String filename;

		//ファイル名が指定されていなければ、エラーメッセージを出し、プログラムを終了する。
		if(args.length != 0) {
			filename = args[0];
		}else {
			System.out.println("エラー: ファイル名が指定されていません. コマンドライン引数でファイル名を指定してください.");
			return;
		}

		/*filename内の整数をarrayListに格納.
		 *ファイルが見つからないとき, ファイルにint型の整数以外のものが含まれるとき,
		 *ファイルに10,000個以上の整数が含まれるときはエラーメッセージを出し, プログラムを終了する.
	 	*/
		try {
			SortTest.inputArrayListFromFile(filename, arrayList);
		}catch(FileNotFoundException e) {
			System.out.println("エラー: 指定されたファイルが見つかりません.");
			return;
		}catch(InputMismatchException e) {
			System.out.println("エラー: ファイルの形式が不適切です. sortできないものが含まれています.");
			return;
		}catch(NumberOfInputException e){
			System.out.println("エラー: ファイルの形式が不適切です." + e.getMessage());
			return;
		}

		//sortを実行する.
		BubbleSort.sort(arrayList);
		//結果を出力する.
		SortTest.outputArrayListToConsole(arrayList);
	}
}
