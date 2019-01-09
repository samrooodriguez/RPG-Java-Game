import java.util.Scanner;

public class Adventure {
    public static void main(String[] arg){
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Hello there, Welcome!" + "Enter your hero name:");
        String hero = scanner.next();
        boolean quest = false;
        int hp = 100;
        int potions = 3;
        int attack = 20;
        int zombiehp = 60;
        int zombieattack = 30;
        System.out.println("Hello " + hero + "!" + " Do you choose to accept this adventure?");
        String userInput = scanner.next();
        if(userInput.equalsIgnoreCase("yes")|| userInput.equalsIgnoreCase("y")){
            System.out.println("Your journey begins...");
            quest = true;
        }else{
            System.out.println("Game over!");
        }
        if (quest){
            System.out.println("Hark! A zombie approaches! Ready yourself!");
            while (hp > 0){
                if (zombiehp <= 0){
                    System.out.println("YOU WIN");
                    break;
                }
                System.out.println("YOU\n"+"HP: " + hp + "\nPOTIONS: " + potions);
                System.out.println("========\n");
                System.out.println("ENEMY\n"+"HP: "+zombiehp);
                System.out.println("What do you do?\n 1. Attack\n 2. Potion\n 3. Run");
                int action = scanner.nextInt();
                if (action == 1){
                    zombiehp -= attack;
                    hp -=zombieattack;
                }
                else if (action == 2){
                    hp += 15;
                    potions -= 1;
                }
                else if (action == 3){
                    double run = Math.random();
                    if (run > .5){
                        System.out.println("You escape!");
                        break;
                    }
                    else {
                        System.out.println("You can't run!");
                        System.out.println("The Zombie attacks!");
                        hp -= zombieattack;
                    }
                }
            }
            System.out.println("Game Over");
        }
    }
}
