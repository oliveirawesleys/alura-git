package labs.pm.app;

public class Cube extends Square {
    public int calcArea(int x) {
        return super.calcArea(x * 6);
    }
}
