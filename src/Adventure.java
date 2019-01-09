import java.util.Scanner;

public class Adventure {
    public static void main(String[] arg){
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Hello there, Welcome!" + "Enter your hero name:");
        String hero = scanner.next();
        System.out.println("Hello " + hero + "!" + " Do you choose to accept this adventure?");
        String userInput = scanner.next();
        if(userInput.contains("yes")){
            System.out.println(" ");
        }else{
            System.out.println("Game over!");
        }
    }
}
