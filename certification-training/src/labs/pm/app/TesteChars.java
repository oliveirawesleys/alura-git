package labs.pm.app;

public class TesteChars {
    public static void main(String[] args) {
        char[] [] arrays = {{'g', 'j'}, {'h', 'k'}, {'i', 'l'}};

        for (char[] xx : arrays) {
            for (char yy : xx) {
                System.out.println(yy);
            }
            System.out.println(" ");
        }
    }
}
