package labs.pm.app;

public class EstudandoTeste {
    private  int sum;
    public int compute() {
        int x = 0;
        while (x < 3) {
            sum += ++x;
        }
        return sum/4;
    }
    public static void main(String[] args) {
      EstudandoTeste t = new EstudandoTeste();
      int sum = t.compute();
      sum = t.compute();
      t.compute();
        System.out.println(sum);
    }



  /*  private static Plant plant;

    public static void main(String[] args) {
        plant = new Tulip();
        feed(plant);
        feed(plant);

    }

    public static void feed(Plant p) {

    }

    public class Plant {

    }

    public class Tulip extends Plant {

    }*/

}





