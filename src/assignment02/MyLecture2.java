package assignment02;
import java.io.*;
import java.util.*;

//入力ファイルの科目名を保持しているデータから探し、開講時限を加えたファイルを出力する
public class MyLecture2 {
	//科目名と開講時限のデータ
	private Map<String, String> lectureData = new HashMap<>();
	{
		lectureData.put("論理回路", "Fr1"); lectureData.put("プログラミング言語", "Mo2");
		lectureData.put("情報理論", "Tu1"); lectureData.put("コンピュータネットワーク", "Tu1");
		lectureData.put("線形代数学続論", "Mo2"); lectureData.put("確率論基礎", "Th1");
	}
	public void convert(String inputFilename, String outputFilename) {
		//入出力するファイルのFileオブジェクト
		File input = new File(inputFilename), 
			 output = new File(outputFilename);
		//入力ファイルのテキストを保持する変数
		List<String> lines = new ArrayList<>();
		
		try(Scanner sc = new Scanner(input)){
			//次の行があれば読み込んでlinesに追加する
			while(sc.hasNext()) {
				lines.add(sc.next());
			}
		}catch(FileNotFoundException e) {
			System.out.println("指定されたファイル　" + inputFilename + " が見つかりません。");
		}
		
		try(FileWriter wr = new FileWriter(output)){
			//読み込んだすべての科目について、開講時限がわかっていれば科目名とともにファイルに書き込む
			for(String line:lines) {
				if(lectureData.containsKey(line)) {
					String times = lectureData.get(line);
					wr.write(times + "\t" + line + "\n");
				}
				else {
					wr.write("unknown" + "\t" + line + "\n");
				}
			}
		}catch(IOException e) {
			System.out.println("ファイルに書き込めませんでした。");
		}
	}
}
