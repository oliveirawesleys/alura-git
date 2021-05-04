package labs.pm.app;

class ConSuperTest  {

        protected ConSuperTest() {
            this(2);
            System.out.println("3");
        }
        protected ConSuperTest(int a) {
            System.out.println(a);
        }

}

class Tetete extends ConSuperTest {
    Tetete() {
        this(4);
        System.out.println("1");
    }
    Tetete(int a) {
        System.out.println(a);
    }
    public static void main(String[] args) {
        new Tetete(4);
    }
}
