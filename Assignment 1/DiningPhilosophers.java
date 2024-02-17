public class DiningPhilosophers {

  public static void main(String[] args) throws InterruptedException {

    if (args.length != 5) {
      System.out.println("Usage: java DiningPhilosophers <np> <nc> <tt> <et> <rl>");
      return;
    }
    
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
      Chopstick leftChopstick = Chopsticks[i];
      Chopstick rightChopstick = chopsticks[(i+1) % np];

      // If philosophers are left-handed, swap
      if (rl == 1 && i % 2 != 0){
        leftChopstick = chopsticks[(i+1) % np];
        rightChopstick = chopsticks[i];
      }
      
      philosophers[i] = new Philosopher(i, leftChopstick, rightChopstick, nc, tt, et, rl);
      philosophers[i].start();
    }
    for (int i = 0; i < np; ++i)
      philosophers[i].join();
  }
}


