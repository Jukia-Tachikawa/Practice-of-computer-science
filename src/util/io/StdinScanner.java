package util.io;
import java.util.*;
import java.util.concurrent.*;
//タイムアウト処理の機能を備えた標準入力の読み込みクラス
public class StdinScanner{
  private Scanner sc;
  private ExecutorService executor;

  public StdinScanner(){
    sc = new Scanner(System.in);
    executor = Executors.newFixedThreadPool(1);
  }
  // 最大で指定された時間 次の入力を待って, 入力があればそれを返す.
  public String next(long timeout, TimeUnit unit) throws TimeoutException{
    class Read implements Callable<String> {
      public String call(){
        return sc.next();
      }
    }
    Future<String> future = executor.submit(new Read());
    try{
      return future.get(timeout, unit);
    }catch(InterruptedException e){ // 基本的に割り込みは起きないと考えて, 特に例外処理しない.
			throw new RuntimeException(e);
		}catch (ExecutionException e) { // ラップされた例外はNoSuchElementException, IllegalStateExceptionのどちらかである.
      throw new RuntimeException(e.getCause());
    }
    /*　注意
     * TimeoutException発生した後そのままではshutdownNow()でexecutorのスレッドが終了しない. 
     * (TimeoutException発生した後もReadは実行中で, 割り込んでも応答しないから?)
     * shutdownNow()後, 何かを入力すると(Readの標準入力待ちが終われば?), executorのスレッドが終了する.
     * 入力なしに終わるにはSystem.exit()がある.　ただJVMが終了するのでexecutorのスレッドだけ終了させたいときには使えない.
     */
  }
  // 最大で指定された時間 次のintの入力を待って, intの入力があればそれを返す.
  public int nextInt(long timeout, TimeUnit unit) throws TimeoutException{
    try{
      return Integer.parseInt(next(timeout, unit));
    }catch(NumberFormatException e){// ScannerのnextInt()に対応させるためにInputMismatchExceptionをスローする.
      throw new InputMismatchException();
    }
  }
  // 終了処理を行う.
  public void close(){
    executor.shutdownNow();
  }
}
