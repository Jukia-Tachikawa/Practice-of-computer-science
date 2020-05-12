package util.myexception;

// 入力整数が指定の範囲の外の整数であるときにスローされる.
public class IllegalInputIntegerException extends RuntimeException{
  public IllegalInputIntegerException(){
    super();
  }
  public IllegalInputIntegerException(String message){
    super(message);
  }
}
