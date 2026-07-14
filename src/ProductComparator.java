import java.util.Comparator;

public class ProductComparator implements Comparator<Product> {

    @Override
    public int compare(Product one, Product two) {
        return Integer.compare(one.getPrice(), two.getPrice());
    }
}
