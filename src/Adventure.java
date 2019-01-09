import java.util.Scanner;
import java.util.Random;

public class Adventure {
    public static void main(String[] arg){
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        Random rand = new Random();

        System.out.println("Hello there, Welcome!" + " Enter your hero name:");
        String hero = scanner.next();
        boolean quest = false;
        int hp = 100;
        int mp = 50;
        int potions = 3;
        int mpPotions = 2;
        int attack = rand.nextInt(20) + 5;
        int crit = rand.nextInt(10)+1;
        int zombieCrit = rand.nextInt(10)+1;
        int zombiehp = 100;
        int zombieattack = rand.nextInt(30) + 1;

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
                System.out.println(hero.toUpperCase()+"\n"+"HP: " + hp + "\nMP: "+ mp +"\nPOTIONS: " + potions + "\nMP POTIONS: " + mpPotions);
                System.out.println("========\n");
                System.out.println("ENEMY\n"+"HP: "+zombiehp);
                if(hp < 30){
                    System.out.println("Your HP is low, you feel your life fading away!");
                }
                if(zombiehp < 20){
                    System.out.println("Victory seems certain!");
                }
                System.out.println("What do you do?\n 1. Attack\n 2. Potion\n 3. MP Potion\n 4. Magic\n 5. Run");
                int action = scanner.nextInt();
                if (action == 1){
                    crit = rand.nextInt(10)+1;
                    zombieCrit = rand.nextInt(10)+1;
                    if (crit == 10){
                        attack = rand.nextInt(30) + 10;
                        zombieattack = rand.nextInt(30) + 1;
                        int tempAttack = attack;
                        int tempZombieAttack = zombieattack;
                        zombiehp -= attack;
                        hp -= zombieattack;
                        System.out.println("CRITICAL HIT! You hit the zombie for " + tempAttack);
                        System.out.println("The zombie did " + tempZombieAttack + " damage.");
                    }
                    else if (zombieCrit == 10){
                        attack = rand.nextInt(20) + 5;
                        zombieattack = rand.nextInt(40) + 10;
                        int tempAttack = attack;
                        int tempZombieAttack = zombieattack;
                        zombiehp -= attack;
                        hp -= zombieattack;
                        System.out.println("You hit the zombie for " + tempAttack);
                        System.out.println("A SAVAGE BLOW! The zombie did " + tempZombieAttack + " damage.");
                    }
                    else{
                        attack = rand.nextInt(20) + 5;
                        zombieattack = rand.nextInt(29) + 1;
                        int tempAttack = attack;
                        int tempZombieAttack = zombieattack;
                        zombiehp -= attack;
                        hp -= zombieattack;
                        System.out.println("You hit the zombie for " + tempAttack);
                        System.out.println("The zombie did " + tempZombieAttack + " damage.");
                    }
                }
                else if (action == 2){
                    if(potions > 0){
                        System.out.println("You quaff the potion!");
                        hp += 15;
                        potions -= 1;
                    }else{
                        System.out.println("You are out of potions!");
                    }
                }
                else if (action == 3){
                    if (mpPotions > 0){
                        System.out.println("You quaff the potion");
                        mp += 15;
                        mpPotions -= 1;
                    }
                    else {
                        System.out.println("You dont have any more potions.");
                    }
                }
                else if (action == 4){
                    if (mp >=20){
                        System.out.println("The air crackles, you cast forth a bolt of lightning");
                        zombiehp -= 30;
                        zombieattack = rand.nextInt(30) + 1;
                        System.out.println("The zombie hits you for " + zombieattack + " damage.");
                        hp -= zombieattack;
                        mp -= 20;
                    }
                    else {
                        System.out.println("You do not have enough MP.");
                    }

                }
                else if (action == 5){
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
                else {
                    System.out.println("That is not a valid action");
                }
            }
            System.out.println("Game Over");
        }
    }
}
