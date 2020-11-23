import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.NoSuchElementException;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FruitStandTest {
    @Test public void test4_fruitstand_lookup() {
        FruitStand fs = new FruitStand("fruits.csv");
        double price = fs.lookup_price(4701);
        assertEquals(8.99, price, 0.001);
        try {
            price = fs.lookup_price(4920);
        } catch (NoSuchElementException e) {
            return;
        }
        assertTrue(false);
    }
}
