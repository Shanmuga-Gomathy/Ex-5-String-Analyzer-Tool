import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

class EmptyStringException extends Exception{
    EmptyStringException(String msg){
        super(msg);
    }
}
class CustomException {
    static void checkInput(String input) throws EmptyStringException{
        if(input.isEmpty()){
            throw new EmptyStringException("The string is empty");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        List<String> userList = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the no of strings to store on list: ");
        int n = scan.nextInt();
        scan.nextLine();


        for(int i=0; i< n; i++){
            System.out.print("Enter String no "+(i+1)+":");
            String userStr= scan.nextLine();
            //4.Throw custom exception if empty string entered
            try{
                CustomException.checkInput(userStr);

                userList.add(userStr);
            }
            catch (EmptyStringException e){
                System.out.println("Caught Exception:" + e.getMessage());

            }
        }
        System.out.println("List of user entered String: "+userList);

        //1.Reverse each string
        System.out.println("Reverse string:");
        Consumer<String> strReverse = s -> {
            StringBuffer rev = new StringBuffer(s);
            rev.reverse();
            System.out.println(rev);
        };
        userList.forEach(strReverse);

        //5.Use Streams to filter strings with length > 5
        System.out.println("String with length greater than 5: ");
        userList.stream().filter(s -> s.length() > 5).forEach(System.out::println);

        //2.Count vowels in each string
        userList.forEach(Main::getVowelsCount);

        /*List<Character> list = Arrays.asList('a', 'e', 'i', 'o', 'u');
        for(String s:userList){
            s= s.toLowerCase();
            int count = 0;
            for(int i = 0 ; i< s.length();i++){
                char c = s.charAt(i);

                if(list.contains(c)){
                    count++;
                }

            }
            System.out.println("Count is: "+count);
        }*/


        //3.Find duplicate strings
        System.out.println("Duplicate Strings: ");
        Predicate<String> freqMoreThanOne = s -> Collections.frequency(userList,s)>1;
        userList.stream().filter(freqMoreThanOne).forEach(System.out::println);

    }
    private static void getVowelsCount (String name) {

        long count = name.toLowerCase().chars().filter(a -> "aeiou".indexOf(a) != -1).count();
        System.out.println("Vowels Count"+ count);
    }

}


