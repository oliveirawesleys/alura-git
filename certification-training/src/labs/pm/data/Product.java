package labs.pm.data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import static java.math.RoundingMode.HALF_UP;
import static labs.pm.data.Rating.NOT_RATED;

public abstract class Product implements Rateable<Product>, Serializable {

    /**
     * A constant that defines a {@link java.math.BigDecimal}
     * value of the discount rate.
     *
     * Discount rate is 10%
     */
    public static final BigDecimal DISCOUNT_RATE = BigDecimal.valueOf(0.1);
    private int id;
    private String name;
    private BigDecimal price;
    private Rating rating;

/*
    Product() {
        this(000, "No name", BigDecimal.ZERO);
    }
*/

    Product(int id, String name, BigDecimal price, Rating rating) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    Product(int id, String name, BigDecimal price) {
        this(id, name, price, NOT_RATED);
    }

    public int getId() {
        return id;
    }

/*    public void setId(final int id) {
        this.id = id;
    }*/

    public String getName() {
        return name;
    }

/*    public void setName(final String name) {
        this.name = name;
    }*/

    public BigDecimal getPrice() {
        return price;
    }

/*    public void setPrice(final BigDecimal price) {
        this.price = price;
    }*/

    public BigDecimal getDiscount() {
        return price.multiply(DISCOUNT_RATE).setScale(2, HALF_UP);
    }

    @Override
    public Rating getRating() {
        return rating;
    }

    /*public abstract Product applyRating(Rating newRating);*/
/*    {
        return new Product(id, name, price, newRating);
    }*/

    public LocalDate getBestBefore() {
        return LocalDate.now();
    }


    @Override
    public String toString() {
        return id + ", " +  name  + ", " + price + ", " + getDiscount() + ", " + rating.getStars() + ", " + getBestBefore();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        //if (o != null && getClass() == o.getClass()) {
        if (o instanceof Product) {
            final Product other = (Product) o;
            return this.id == other.id && Objects.equals(this.name, other.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
