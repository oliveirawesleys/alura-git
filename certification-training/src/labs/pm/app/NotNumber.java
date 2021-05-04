package labs.pm.app;

public class NotNumber {

    public float vali (String s, float min, float max) throws IllegalArgumentException {
        float f = Float.parseFloat(s);
        if (!Float.isFinite(f) || f < min || f > max) {
            throw new IllegalArgumentException();
        }
        return f;
    }

    public float valis (String s) throws IllegalArgumentException {
        return Float.parseFloat(s);
    }

    public static void main(String[] args) {
        NotNumber n = new NotNumber();
        n.valis("Teste");
    }
}
