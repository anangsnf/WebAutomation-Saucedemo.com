package saucedemo.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class myStepDefinitions {
    WebDriver driver;
    String baseUrl = "https://saucedemo.com";
    @Given("user already open saucedemo")
    public void user_already_open_saucedemo() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); //set timeout for web driver on waiting element
        driver.get(baseUrl);

        //Assertion
        String LoginPageAssert = driver.findElement(By.xpath("//div[contains(text(),'Swag Labs')]")).getText();
        Assert.assertEquals(LoginPageAssert,"Swag Labs");

    }

    @When("user input valid username")
    public void user_input_valid_username() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("user input valid password")
    public void user_input_valid_password() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("user click login button")
    public void user_click_login_button() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("user successfully logged in and redirected to products page")
    public void user_successfully_logged_in_and_redirected_to_products_page() {
        driver.findElement(By.xpath("//span[contains(text(), 'Products')]"));
        String tombolAddToCart = driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).getText();
        Assert.assertEquals(tombolAddToCart, "Add to cart");
    }

    @And("user input invalid password")
    public void user_input_invalid_password() {
        driver.findElement(By.id("password")).sendKeys("12345");
    }

    @Then("user failed to log in and get error message")
    public void user_failed_to_log_in_and_get_error_message() {
        String ErrorLogin = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        Assert.assertEquals(ErrorLogin, "Epic sadface: Username and password do not match any user in this service");
    }

    @When("user click product title")
    public void user_click_product_title() {
        driver.findElement(By.id("item_4_title_link")).click();
    }

    @When("user successfully open product details")
    public void user_successfully_open_product_details() {
        String tombolBackToProducts = driver.findElement(By.id("back-to-products")).getText();
        Assert.assertEquals(tombolBackToProducts, "Back to products");
    }

    @When("user click sort icon")
    public void user_click_sort_icon() {
        driver.findElement(By.xpath("//span[@class='select_container']")).click();
    }

    @And("user choose price low to high")
    public void user_choose_price_low_to_high() {
        driver.findElement(By.xpath("//option[@value='lohi']")).click();
    }

    @Then("user successfully sort product by price low to high")
    public void user_successfully_sort_product_by_price_low_to_high() {
        driver.findElement(By.xpath("//span[contains(text(), 'Products')]"));
        String priceFirstProduct = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div")).getText();
        Assert.assertEquals(priceFirstProduct, "$7.99");
    }

    @When("user click add to cart")
    public void user_click_add_to_cart() {
        driver.findElement(By.xpath("//button[contains(text(),'Add to cart')]")).click();
    }

    @Then("the cart shows amount product badge")
    public void the_cart_shows_amount_product_badge() {
        String amountProductBadge = driver.findElement(By.className("shopping_cart_badge")).getText();
        Assert.assertEquals(amountProductBadge, "1");
    }

    @When("user click cart icon")
    public void user_click_cart_icon() {
        driver.findElement(By.className("shopping_cart_link")).click();
    }

    @And("user click checkout button")
    public void user_click_checkout_button() {
        driver.findElement(By.id("checkout")).click();
    }

    @And("user input first name")
    public void user_input_first_name() {
        driver.findElement(By.id("first-name")).sendKeys("Anang Syaifuddin");
    }

    @And("user input last name")
    public void user_input_last_name() {
        driver.findElement(By.id("last-name")).sendKeys("Nurul Fadli");
    }

    @And("user input postal code")
    public void user_input_postal_code() {
        driver.findElement(By.id("postal-code")).sendKeys("76125");
    }

    @And("user click continue button")
    public void user_click_continue_button() {
        driver.findElement(By.id("continue")).click();
    }

    @And("user click finish button")
    public void user_click_finish_button() {
        driver.findElement(By.id("finish")).click();
    }

    @Then("user successfully order product")
    public void user_successfully_order_product() {
        String checkoutStatus = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals(checkoutStatus, "Checkout: Complete!");
    }
}
