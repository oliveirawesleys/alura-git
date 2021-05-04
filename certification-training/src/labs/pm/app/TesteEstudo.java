package labs.pm.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TesteEstudo {

    public enum Status {
       // BRONZE(5);
    }
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        List<String> list2 = Collections.unmodifiableList(list);
        list.add("C");
        System.out.println(list);
        System.out.println(list2);
    }
}
