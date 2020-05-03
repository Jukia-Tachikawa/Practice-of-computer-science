package assignment03;
import java.io.*;
import java.util.*;
public class Test {
	public static void main(String[] args) {
		Scanner sc;
		try {
			sc = new Scanner(new File("sample.txt"));
			System.out.println(sc.nextInt());
			System.out.println(sc.nextInt());
			System.out.println(sc.nextInt());
			System.out.println(sc.nextInt());
			System.out.println(sc.nextInt());
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		String arg = null;
		System.out.print(arg);
	}
}
