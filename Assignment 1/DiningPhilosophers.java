public class DiningPhilosophers {

  public static void main(String[] args) throws InterruptedException {
    int np = Integer.parseInt(args[0]);
    int nc = Integer.parseInt(args[1]);
    int tt = Integer.parseInt(args[2]);
    int et = Integer.parseInt(args[3]);
    int rl = Integer.parseInt(args[4]);
    
    
    Philosopher[] philosophers = new Philosopher[np];
    Chopstick[] chopsticks = new Chopstick[np];
    
    for (int i = 0; i < np; ++i)
      chopsticks[i] = new Chopstick(i);
    for (int i = 0; i < np; ++i) {
      philosophers[i] = new Philosopher(chopsticks[i], chopsticks[(i + 1) % 5]);
      philosophers[i].start();
    }
    for (int i = 0; i < np; ++i)
      philosophers[i].join();
  }
}


