package labs.pm.app;
interface Teee {
    public int cal(int a, int b);
}
public class Abacus {

    public static void main(String[] args) {
        int res = 0;

        Teee ava = (int e, int f) ->{return  e *f;};
        //Teee ava = (a , f) ->a *f;

        res = ava.cal(10,20);
        System.out.println(res);
    }


}
