package labs.pm.app;

import java.util.Arrays;
import java.util.Comparator;

public class TesteBoston {
    public static void main(String[] args) {
        String[] t = {"boston", "paris", "bang", "oman"};
        Comparator<String> ms = (a,b) ->  b.compareTo(a);
        Arrays.sort(t, ms);

        System.out.println(Arrays.binarySearch(t, "oman", ms));
    }
}
