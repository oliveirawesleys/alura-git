package labs.pm.app;

public class TesteSomamm {
    private int sum;
    public int compute() {
        int x = 0;
        while (x < 3) {
            sum += ++x;
        }
        return sum/4;
    }

    public static void main(String[] args) {
        TesteSomamm t = new TesteSomamm();
        int sum = t.compute();
        sum = t.compute();
        t.compute();
        System.out.println(sum);
    }
}
