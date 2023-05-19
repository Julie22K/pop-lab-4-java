package company;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        int num_meals=10;
        Semaphore[] forks=new Semaphore[]{
                new Semaphore(1),
                new Semaphore(1),
                new Semaphore(1),
                new Semaphore(1),
                new Semaphore(1),
        };

        Waiter waiter=new Waiter(forks,new Semaphore(2));
        for(int i=1;i<5;i++){
            (new Philosopher(i,num_meals,waiter)).start();
        }
    }
}