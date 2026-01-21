class EmptyStringException extends Exception{
    EmptyStringException(String msg){
        super(msg);
    }
}
public class CustomException {
    static void checkInput(String input) throws EmptyStringException{
        if(input.isEmpty()){
            throw new EmptyStringException("The string is empty");
        }
    }
}