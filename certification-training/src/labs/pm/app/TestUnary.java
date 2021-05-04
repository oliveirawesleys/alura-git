package labs.pm.app;

import java.util.Arrays;
import java.util.function.UnaryOperator;

public class TestUnary {
    public static void main(String[] args) {
        Integer[] in = {1,2,3,4,5,6,7};
        var list = Arrays.asList(in);

        UnaryOperator<Integer> uo = (var x) -> (x * 3);
        list.replaceAll(uo);
    }
}
