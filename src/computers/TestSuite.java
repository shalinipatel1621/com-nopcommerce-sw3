package computers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class TestSuite extends Utility {
    String baseURL = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseURL);
    }

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {
        //Click on computer menu
        clickOnElement(By.xpath("//a[@href='/computers']"));

        //click on desktop menu
        clickOnElement(By.xpath("//img[@alt='Picture for category Desktops']"));

        //select sort by position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.name("products-orderby"), "Name: Z to A");

        //Verify that the products will arrange in Descending order
        verifyElements("error", "Name: Z to A", By.xpath("//option[contains(text(),'Name: Z to A')]"));

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessfully() throws InterruptedException {

        //click on computer
        clickOnElement(By.xpath("//a[@href='/computers']"));

        //click on desktop
        clickOnElement(By.xpath("//img[@alt='Picture for category Desktops']"));

        //select sort by position "Name A to Z"
        selectByVisibleTextFromDropDown(By.name("products-orderby"), "Name: A to Z");
        Thread.sleep(1000);

        //Click on add to cart
        clickOnElement(By.xpath("(//button[@type='button'][normalize-space()='Add to cart'])[1]"));

        //verify the text "Build your own computer"
        verifyElements("error", "Build your own computer", By.xpath("//h1[contains(text(),'Build your own computer')]"));

        //select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByVisibleTextFromDropDown(By.id("product_attribute_1"), "2.2 GHz Intel Pentium Dual-Core E2200");

        //select "8gb [+$60.00]" using select
        selectByVisibleTextFromDropDown(By.id("product_attribute_2"), "8GB [+$60.00]");

        //select HDD radio "400 GB [+100.00]"
        clickOnElement(By.id("product_attribute_3_7"));

        //select OS radio "Vista Premium [+60.00]"
        clickOnElement(By.id("product_attribute_4_9"));
        Thread.sleep(2000);

        //Check two check boxes "Microsoft Office [+50.00] and "Total Commander [$5.00]"
        clickOnElement(By.id("product_attribute_5_12"));

        //Verify the price $1475.00
        Thread.sleep(2000);
        verifyElements("error", "$1,475.00", By.id("price-value-1"));


        //click on ADD TO CARD button
        clickOnElement(By.id("add-to-cart-button-1"));

        //verify the message "The product has been added to your shopping cart" on Top green Bar After that close the bar clicking on the cross button.
        verifyElements("error", "The product has been added to your shopping cart", By.xpath("//p[@class='content']"));
        clickOnElement(By.xpath("//span[@title='Close']"));

        //Then mouseHover on "Shopping cart" and click on "GO TO CART" button
        mouseHoverToElement(By.xpath("//span[@class='cart-label']"));
        clickOnElement(By.xpath("//button[@class='button-1 cart-button']"));
        Thread.sleep(1000);

        //Verify the message "Shopping Cart"
        verifyElements("error", "Shopping cart", By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Thread.sleep(2000);

        //change to QTY to "2" and click on "Update to shopping cart"
        WebElement quantity = driver.findElement(By.xpath("//td[@class=\"quantity\"]/child::input"));
        quantity.clear();
        quantity.sendKeys("2");
        Thread.sleep(2000);
        clickOnElement(By.id("updatecart"));
        Thread.sleep(1000);

        //verify the Total "$2950.00"
        verifyElements("error", "$2,950.00", By.xpath("//span[@class='value-summary']//strong[contains(text(),'$2,950.00')]"));

        //click on checkbox "I agree with the terms of service"
        clickOnElement(By.id("termsofservice"));

        //click on CHECKOUT
        clickOnElement(By.id("checkout"));

        //verify the text "Welcome, Please Sign In!"
        verifyElements("error", "Welcome, Please Sign In!", By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));

        //Click on "CHECKOUT AS GUEST" Tab
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));

        //fill all mandatory fields
        sendTextToElement(By.id("BillingNewAddress_FirstName"), "Jack");
        sendTextToElement(By.id("BillingNewAddress_LastName"), "Doe");
        sendTextToElement(By.id("BillingNewAddress_Email"), "JackDoe147@gmail.com");
        sendTextToElement(By.id("BillingNewAddress_Company"), "CK Limited");
        sendTextToElement(By.id("BillingNewAddress_CountryId"), "United Kingdom");
        sendTextToElement(By.id("BillingNewAddress_City"), "London");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "17 Burroughs Street");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "NW4 4XS");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "7896541");

        //click on continue
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));

        //Click on Radio button "Next Day Air($0.00)"
       // clickOnElement(By.id("shippingoption_1"));

        //click on continue
        clickOnElement(By.xpath("(//button[@class='button-1 shipping-method-next-step-button'])[1]"));

        clickOnElement(By.xpath("(//button[@class='button-1 shipping-method-next-step-button'])[1]"));

        //click on continue
              // clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));

        //click on confirm
       // clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));

        //Verify the text "Thank you"
       // verifyElements("error", "Thank you", By.xpath("//h1[contains(text(),'Thank you')]"));

        //Verify the message "Your order has been successfully processed!"
        verifyElements("error", "Your order has been successfully processed!", By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));

        //click on continue
        //clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));

        //verify the text "Welcome to our store
        verifyElements("error", "Welcome to our store", By.xpath("//h2[contains(text(),'Welcome to our store')]\n"));

    }

    @After
    public void tearDown() {
        //closeBrowser();
    }

}

