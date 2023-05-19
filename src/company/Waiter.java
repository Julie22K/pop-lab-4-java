package company;

import java.util.concurrent.Semaphore;

public class Waiter  {
    public final Semaphore[] forks;
    public final Semaphore can_eat;
    public Waiter(Semaphore[] forks,Semaphore can_eat) {
        this.forks = forks;
        this.can_eat = can_eat;
    }
}
