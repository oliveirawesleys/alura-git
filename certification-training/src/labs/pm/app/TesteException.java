package labs.pm.app;

import java.io.FileNotFoundException;

public class TesteException {
    public static void main(String[] args) {
        try {
            doA();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void doA() throws Exception, IndexOutOfBoundsException {
        if (false) {
            throw new FileNotFoundException();
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
}
