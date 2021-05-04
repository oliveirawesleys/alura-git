package labs.pm.app;

public class Ava extends Game {
    public Object[] move(Number x, Number y) {
        System.out.println("Move caracter");
        return super.move(x.intValue(), y.intValue());
    }

    public static void main(String... args) {
        var character = new Ava();
        character.move(10.0, 10.0);
        character.move(10, 10);
    }

}
