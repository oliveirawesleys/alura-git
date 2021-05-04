package labs.pm.app;


public interface Copier {
	int field = 99;
	default void method() {
		System.out.print(field);
	}
}

