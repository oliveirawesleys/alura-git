package labs.pm.app;

import java.util.HashSet;
import java.util.Set;

public class TesteLoft {

    //Iterator

    public int solution(int[] A) {
        // write your code in Java SE 8
        int n = A.length;
        Set<Integer> set = new HashSet<>();

        for (int a : A) {
            if (a > 0) {
                set.add(a);
            }
        }

        for (int i = 1; i <= n +1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return n;
    }

    public int exercicio3(String s) {
        return 1;
    }

}
