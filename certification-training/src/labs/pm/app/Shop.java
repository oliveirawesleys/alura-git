package labs.pm.app;

import labs.pm.data.Product;
import labs.pm.data.ProductManager;
import labs.pm.data.Rating;

import java.math.BigDecimal;
import java.util.*;

import static labs.pm.data.Rating.*;

public class Shop {

    public static void main(String[] args) {

        ProductManager pm = new ProductManager("en-GB");
        pm.createProduct(101, "Tea", BigDecimal.valueOf(1.99), NOT_RATED);
//        pm.printProductReport(101);
        pm.reviewProduct(101, FOUR_STAR, "Nice hot cup of tea.");
        pm.reviewProduct(101, FIVE_STAR, "Rather weak tea.");
        pm.reviewProduct(101, TWO_STAR, "Just add some lemon.");
        pm.reviewProduct(101, FIVE_STAR, "Perfect tea.");
//        pm.printProductReport(101);

        pm.changeLocale("fr-FR");

        pm.createProduct(102, "Coffee", BigDecimal.valueOf(2.99), NOT_RATED);
        pm.reviewProduct(102, THREE_STAR, "Coffee was ok");
        pm.reviewProduct(102, ONE_STAR, "Where is the milk?!");
        pm.reviewProduct(102, FIVE_STAR, "It's perfect with ten spoons of sugar!");
//        pm.printProductReport(102);

        Comparator<Product> ratingSorter = (p1, p2) -> p2.getRating().ordinal() - p1.getRating().ordinal();

        Comparator<Product> priceSorter = (p1, p2) -> p2.getPrice().compareTo(p1.getPrice());
        pm.printProducts(ratingSorter.thenComparing(priceSorter));
        pm.printProducts(ratingSorter.thenComparing(priceSorter).reversed());
//        pm.printProducts(priceSorter);
//        pm.printProducts(ratingSorter);


 /*       Product p2 = pm.createProduct(102, "Coffee", BigDecimal.valueOf(1.99), FOUR_STAR);
        Product p3 = pm.createProduct(103, "Cake", BigDecimal.valueOf(3.99), FIVE_STAR, LocalDate.now().plusDays(2));
        Product p4 = pm.createProduct(105, "Cookie", BigDecimal.valueOf(3.99), TWO_STAR, LocalDate.now());
        Product p5 = p3.applyRating(THREE_STAR);
        Product p6 = pm.createProduct(104, "Chocolate", BigDecimal.valueOf(2.99), FIVE_STAR);
        Product p7 = pm.createProduct(104, "Chocolate", BigDecimal.valueOf(2.99), FIVE_STAR, LocalDate.now().plusDays(2));
        Product p8 = p4.applyRating(FIVE_STAR);
        Product p9 = p1.applyRating(TWO_STAR);
        System.out.println(p6.equals(p7));
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
        System.out.println(p5);
        System.out.println(p6);
        System.out.println(p7);
        System.out.println(p8);
        System.out.println(p9);*/

/*        List<Integer> listaNumeros = new ArrayList<>();
        listaNumeros.add(1);
        listaNumeros.add(170);
        listaNumeros.add(61);
        listaNumeros.add(72);
        listaNumeros.add(2);

        System.out.println(listaNumeros.stream().filter(pares -> pares % 2 == 0)
                .sorted(Integer::compareTo).collect(Collectors.toList()));*/

/*        p2.getBestBefore();
        p3.getBestBefore();*/

/*        if (p3 instanceof Food) {
            LocalDate bestBefore = ((Food)p3).getBestBefore();
        }*/

        //p3 = p3.applyRating(THREE_STAR);
/*        p1.setId(101);
        p1.setName("Tea");
        p1.setPrice(BigDecimal.valueOf(1.99));*/

/*
        System.out.println(p1.getId() + " " + p1.getName() + " " + p1.getPrice() + " " + p1.getDiscount() + " " + p1.getRating().getStars());
        System.out.println(p2.getId() + " " + p2.getName() + " " + p2.getPrice() + " " + p2.getDiscount() + " " + p2.getRating().getStars());
        System.out.println(p3.getId() + " " + p3.getName() + " " + p3.getPrice() + " " + p3.getDiscount() + " " + p3.getRating().getStars());
        System.out.println(p4.getId() + " " + p4.getName() + " " + p4.getPrice() + " " + p4.getDiscount() + " " + p4.getRating().getStars());
        System.out.println(p5.getId() + " " + p5.getName() + " " + p5.getPrice() + " " + p5.getDiscount() + " " + p5.getRating().getStars());
*/
    }
}
