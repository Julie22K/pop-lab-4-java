package company;

public class Philosopher extends Thread {
    public final int id;
    public final int num_meals;
    public final Waiter waiter;
    public Philosopher(int id,int num_meals,Waiter waiter){
        this.id=id;
        this.num_meals=num_meals;
        this.waiter=waiter;
    }
    public void run() {
        try {
            for (int i=0;i<num_meals;i++){
                waiter.can_eat.acquire();
                System.out.println("Philosopher#"+this.id + " thinking " + i+" time");
                waiter.forks[id].acquire();
                System.out.println("Philosopher#"+this.id + " took left fork");
                waiter.forks[id<4?id+1:0].acquire();
                System.out.println("Philosopher#"+this.id + " took right fork");

                System.out.println("Philosopher#"+this.id + " eating " + i+" time");

                waiter.forks[id].release();
                System.out.println("Philosopher#"+this.id + " put left fork");
                waiter.forks[id<4?id+1:0].release();
                System.out.println("Philosopher#"+this.id + " put right fork");

                waiter.can_eat.release();
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
