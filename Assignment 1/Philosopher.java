import java.util.Random;

class Philosopher extends Thread {
  private Chopstick left, right;
  private Random random;
  private int thinkCount;
  private int id;

  public Philosopher(int id, Chopstick left, Chopstick right) {
    this.id = id;
    this.left = left; this.right = right;
    random = new Random();
  }

  public void run() {
    try {
      while(true) {
        ++thinkCount;
        if (thinkCount % 10 == 0)
          System.out.println("Philosopher " + this + " has thought " + thinkCount + " times");
        Thread.sleep(random.nextInt(1000));     // Think for a while

        Chopstick firstChopstick = (left.getId() < right.getId()) ? left : right;
        Chopstick secondChopstick = (left.getId() < right.getId()) ? right : left;
        
        synchronized(left) {                    // Grab left chopstick 
          synchronized(right) {                 // Grab right chopstick 
            Thread.sleep(random.nextInt(1000)); // Eat for a while
          }
        }
      }
    } catch(InterruptedException e) {}
  }
}
