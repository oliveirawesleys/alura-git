package labs.pm.app;

public class Mondial {
    static String prefix = "Mondial:";
    private String name = "domainmodel";

    public static  String getName() {
        return new Mondial().name;
    }

    public static void main(String[] args) {
        Mondial m = new Mondial();
        System.out.println(Mondial.prefix + Mondial.getName());
        System.out.println(new Mondial().prefix + new Mondial().name);

    }
}
