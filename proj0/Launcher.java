
import java.lang.*;
public class Launcher {
    public static void main(String[] args) {
        Body test = new Body(10, 20, 30, 40, 60, "test");
        Body test2 = new Body(test);
        System.out.println(test.G);
    }
}