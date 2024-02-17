import java.util.Random;

class Philosopher extends Thread {
  private Chopstick left, right;
  private Random random;
  private int thinkCount;
  private int id;
  private int nc;
  private int tt;
  private int et;
  private int rt;

  public Philosopher(int id, Chopstick left, Chopstick right, int nc, int tt, int et, int rl) {
    this.id = id;
    this.left = left; 
    this.right = right;
    this.nc = nc;
    this.tt = tt;
    this.et = et;
    this.rl = rl;
    
    random = new Random();
  }

  public void run() {
    try {
      while(true) {
        ++thinkCount;
        if (thinkCount % 10 == 0)
          System.out.println("Philosopher " + id + " has thought " + thinkCount + " times");
        Thread.sleep(random.nextInt(tt));     // Think for a while

        Chopstick rightChopstick = (rl == 0 || id % 2 == 0) ? left : right;
        Chopstick leftChopstick = (rl == 0 || id % 2 == 0) ? right : left;

        System.out.println("Philosopher " + id + " wants " + rightChopstick + " chopstick");
        synchronized(rightChopstick) {                    // Grab right chopstick 
          System.out.println("Philosopher " + id + " has " + rightChopstick + " chopstick");
          System.out.println("Philosopher " + id + " wants " + leftChopstick + " chopstick");
          synchronized(leftChopstick) {                 // Grab left chopstick 
            System.out.println("Philosopher " + id + " has " + leftCHopstick + "chopstick");
            Thread.sleep(random.nextInt(et)); // Eat for a while
          }
          System.out.println("Philosopher " + id + " releases " + leftCHopstick + " chopstick");
        }
        System.out.println("Philosopher " + id + " releases " + rightChopsticks + " chopsticks");
      }
    } catch(InterruptedException e) {}
  }
}
