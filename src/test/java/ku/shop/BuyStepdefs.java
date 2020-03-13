package ku.shop;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BuyStepdefs {

    private ProductCatalog catalog;
    private Order order;

    @Before
    public void setup() {
        catalog = new ProductCatalog();
        order = new Order();
    }

    @Given("(.+) of product (.+) with price (.+) exists")
    public void product_with_quantity_exists(int quantity, String name, double price) {
        catalog.addProduct(name, price, quantity);
    }

    @When("I buy (.+) with quantity (.+)")
    public void i_buy_with_quantity(String name, int quant) {
        if (catalog.itemAvaliable(name, quant)) {
            Product prod = catalog.getProduct(name);
            order.addItem(prod, quant);
            prod.setQuantity(prod.getQuantity() - quant);
        }
    }

    @Then("total should be (.+)")
    public void total_should_be(double total) {
        assertEquals(total, order.getTotal());
    }

    @Then("The quantity of (.+) product should be (.+)")
    public void total_quantity_should_be(String name, int quantity) {
        Product prod = catalog.getProduct(name);
        assertEquals(quantity, prod.getQuantity());
    }

    @Then("my order of (.+) of (.+) was cancelled")
    public void i_buy_product_out_of_stock(int quantity, String name) {
        Product prod = catalog.getProduct(name);
        assertTrue(quantity > prod.getQuantity());
    }
}

