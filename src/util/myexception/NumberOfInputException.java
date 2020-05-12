package util.myexception;

//入力が想定した入力個数と異なるにスローされる.
public class NumberOfInputException extends RuntimeException{
  public NumberOfInputException(){
    super();
  }

  public NumberOfInputException(String message){
    super(message);
  }
}
