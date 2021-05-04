package labs.pm.app;


public class Game {
    public Object[] move(int x, int y) {
        System.out.println("Move game");
        return new Integer[] {x + 10, y + 10};
    }


}
