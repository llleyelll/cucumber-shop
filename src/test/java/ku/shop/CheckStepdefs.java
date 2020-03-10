package ku.shop;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckStepdefs {

    private ProductCatalog catalog;
    private Order order;

    @Before
    public void setup() {
        catalog = new ProductCatalog();
        order = new Order();
    }

    @Given("(.+) of product (.+) with price (.+) exists")
    public void product_with_quantity_exists(int quantity, String name, double price) {
        catalog.addProduct(name, price);
        catalog.addQuantity(name, quantity);
    }

    @When("I sell (.+) with quantity (.+)")
    public void i_sell_with_quantity(String name, int quantity) {
        if (catalog.itemAvaliable(name, quantity)) {
            Product prod = catalog.getProduct(name);
            order.addItem(prod, quantity);
            prod.setQuantity(prod.getQuantity() - quantity);
        }
    }

    @Then("The quantity of (.+) product should be (.+)")
    public void total_should_be(String name, int quantity) {
        Product prod = catalog.getProduct(name);
        assertEquals(quantity, prod.getQuantity());
    }
}
