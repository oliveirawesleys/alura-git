package labs.pm.app;

public class TesteLMN {
    class L extends Exception {}
    class M extends L {    }
    class N extends RuntimeException {}

    public void p() throws L {
        throw new M();
    }

    public void q() throws N { throw new N();}

    public static void main(String[] args) {
        try {
            TesteLMN t = new TesteLMN();
            t.p();
            t.q();
        } catch (L e) {
            e.printStackTrace();
        }
    }
}
