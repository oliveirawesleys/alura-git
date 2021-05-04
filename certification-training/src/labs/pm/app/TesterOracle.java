package labs.pm.app;

import java.util.stream.IntStream;

public class TesterOracle {
        public static String convert(int x) {
            if (x % 15 ==0) return "FizzBuzz";
            else if (x % 3 ==0) return "Fizz";
            else if (x % 5 ==0) return "Buzz";
            else return Integer.toString(x);
        }

    public static void main(String[] args) {
/*        for (int i = 1; i < 101; i++) {
            System.out.println(convert(i));
        }*/

        //IntStream.range(1, 100).mapToObj(TesterOracle::convert).forEach(System.out::println);
        IntStream.rangeClosed(1, 100).mapToObj(TesterOracle::convert).forEach(System.out::println);


    }
}
