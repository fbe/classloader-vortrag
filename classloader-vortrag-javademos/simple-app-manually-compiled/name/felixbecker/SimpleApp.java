package name.felixbecker;

public class SimpleApp {

  private static long INITIALIZATION_TIME = System.currentTimeMillis();

  public void greet(String name){
    System.out.println("Hello " + name + " - this class (not object) has been initialized on " + INITIALIZATION_TIME);
  }
}
