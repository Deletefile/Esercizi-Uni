import java.util.Random;

public class Tamagotchi {

    public static final int MAX_HUNGER = 90;
    public static final int MIN_HUNGER = 30;
    public static final int MIN_JOY = 30;
    public static final int MAX_JOY = 100;

    private int joy;
    private int hunger;
    private String name;

    public Tamagotchi(String name, int hunger, int joy) {
        this.name = name;
        this.hunger = hunger;
        this.joy = joy;
    }

    public int getJoy() {
        return joy;
    }

    public void setJoy(int joy) {
        this.joy = joy;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////

    public void giveBiscuit() {
        Random x = new Random();
        hunger = hunger + x.nextInt(10) + 1;
    }

    public void giveLove() {
        Random x = new Random();
        joy = joy + x.nextInt(10) + 1;
    }

    public void checkStatus() {

        if (hunger <= MAX_HUNGER && hunger >= MIN_HUNGER) {
            System.out.printf("\n%s è sazio! [%d/100]\n", name, hunger);
        }
        else {
            System.out.printf("\nOh no! %s ha mangiato troppo ed è morto!\n", name);
        }

        if (joy > MIN_JOY && joy <= MAX_JOY && hunger <= MAX_HUNGER || hunger <= MAX_HUNGER && joy >MAX_JOY) {
            if (joy>MAX_JOY) {
                joy = 100;
            }
            System.out.printf("%s è felice :D [%d/100]\n", name, joy);
        }
        else if (!isDead()) {
            System.out.printf("Oh no! %s è triste, ha bisogno di carezze! [%d/100]\n", name, joy);
        }
    }

    public boolean isDead() {
        if (hunger >= MAX_HUNGER || hunger <= MIN_HUNGER) {
            return true;
        }
        else {
            return false;
        }
    }
}
