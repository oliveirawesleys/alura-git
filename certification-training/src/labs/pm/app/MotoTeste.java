package labs.pm.app;

import java.util.ArrayList;
import java.util.List;

public class MotoTeste {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>(List.of("Plane", "Automo", "Motor"));

        List<String> list2 = new ArrayList<>(List.copyOf(list1));

        list1.sort((String item1, String item2) -> item1.compareTo(item2));
        list2.sort((String item1, String item2) -> item1.compareTo(item2));
        System.out.println(list1.equals(list2));
    }
}
