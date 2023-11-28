package electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.Utility;

public class Electronics extends Utility {

    String baseURL = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseURL);
    }

    //Test name
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {

        //Mouse hover on Electronics tab
        mouseHoverToElement(By.xpath("//a[text()='Electronics ']"));

        //Mouse hover on Cell phones and click
        mouseHoverToElementAndClick(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));

        //verify the text "Cell phones"
        verifyElements("error", "Cell phones", By.xpath("//h1[contains(text(),'Cell phones')]"));

    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {

        //Mouse Hover on Electronics Tab
        mouseHoverToElement(By.xpath("//a[text()='Electronics ']"));

        //Mouse hover on Cell phones and click
        mouseHoverToElementAndClick(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));

        //Verify the text Cell phones
        verifyElements("error", "Cell phones", By.xpath("//h1[contains(text(),'Cell phones')]"));

        //click on list view tab
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));

        //CLick on product name "Nokia Lumia 1020" link
        Thread.sleep(1000);
        clickOnElement(By.xpath("//h2[@class='product-title']//a[contains(text(),'Nokia Lumia 1020')]"));

        //Verify the text "Nokia Lumia 1020"
        verifyElements("error", "Nokia Lumia 1020", By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"));

        //Verify the price "$349.00"
        verifyElements("error", "$349.00", By.xpath("//span[contains(text(),'$349.00')]"));

        //change quantity to 2
        sendTextToElement(By.id("product_enteredQuantity_20"), Keys.BACK_SPACE + "2");

        //click on "ADD TO CART" tab
        clickOnElement(By.id("add-to-cart-button-20"));

        //verify the message,  "The product has been added to your shopping cart" on Top green Bar After that close the bar clicking on the cross button.
        verifyElements("error", "The product has been added to your shopping cart", By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"));
        clickOnElement(By.xpath("//span[@title='Close']"));
        Thread.sleep(1000);

        //Then MouseHover on "Shopping Cart" and click on "GO TO CART button
        mouseHoverToElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));
        Thread.sleep(1000);

        //Verify the message "Shopping cart"
        verifyElements("error", "Shopping cart", By.xpath("//h1[contains(text(),'Shopping cart')]"));

        //verify quantity is 2
        verifyElements("error", "(2)", By.xpath("//span[contains(text(),'(2)')]"));

        //verify the total $698.00
        verifyElements("error", "$698.00", By.xpath("//span[@class='value-summary']//strong[contains(text(),'$698.00')]"));

        //click on clickbox "I agree with the terms of service"
        clickOnElement(By.id("termsofservice"));

        //click on checkout
        clickOnElement(By.id("checkout"));

        //verify the text "Welcome, Please Sign In"
        verifyElements("error", "Welcome, Please Sign In!", By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));

        //click on register tab
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));

        //verify the text Register
        verifyElements("error", "Register", By.xpath("//h1[contains(text(),'Register')]"));

        //fill the mandatory fields
        sendTextToElement(By.id("FirstName"), "Raj");
        sendTextToElement(By.id("LastName"), "Gupta");
        sendTextToElement(By.id("Email"), "RajGupta123@gmail.com");
        sendTextToElement(By.id("Password"), "Raj@123");
        sendTextToElement(By.id("ConfirmPassword"), "Raj@123");

        //2.21 Click on “REGISTER” Button
        clickOnElement(By.id("register-button"));

        //Verify the message "Your registration completed"
        verifyElements("error", "Your registration completed", By.xpath("//div[contains(text(),'Your registration completed')]"));

        //click on "CONTINUE" tab
        clickOnElement(By.xpath("//a[@class='button-1 register-continue-button']"));

        //verify the text "Shopping Card"
        verifyElements("error", "Shopping cart", By.xpath("//h1[contains(text(),'Shopping cart')]"));

        //click on checkbox "I agree with terms of service"
        clickOnElement(By.id("termsofservice"));

        //click on "CHECKOUT"
        clickOnElement(By.id("checkout"));

        //2.27 Fill the Mandatory fields

        selectByVisibleTextFromDropDown(By.id("BillingNewAddress_CountryId"), "United Kingdom");
        sendTextToElement(By.id("BillingNewAddress_City"), "London");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "123 High Street");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "EC157YN");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "1234567");

        //2.28 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));

        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.id("shippingoption_2"));

        //Click on Radio Button "2nd Day Air($0.00)"
        clickOnElement(By.id("shippingoption_2"));

        //click on continue
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));

        //Select Radio button "Credit Card"
        clickOnElement(By.id("paymentmethod_1"));
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));

        //Select Visa from Select credit card dropdown
        selectByVisibleTextFromDropDown(By.id("CreditCardType"), "Visa");

        //2.33 Fill all the details
        sendTextToElement(By.id("CardholderName"), "Mr Ben Peter");
        sendTextToElement(By.id("CardNumber"), "5566 6248 1788 6920");
        selectByVisibleTextFromDropDown(By.id("ExpireMonth"), "12");
        selectByVisibleTextFromDropDown(By.id("ExpireYear"), "2028");
        sendTextToElement(By.id("CardCode"), "453");

        //click on continue
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));

        //verify "payment method" is "credit card"
        verifyElements("error", "Payment Method:", By.xpath("//span[contains(text(),'Payment Method:')]"));

        //verify "Shipping method" is "2nd Day Air"
        verifyElements("error", "Credit Card", By.xpath("//span[contains(text(),'Credit Card')]"));
        verifyElements("error", "Shipping Method:", By.xpath("//span[contains(text(),'Shipping Method:')]"));
        verifyElements("error", "2nd Day Air", By.xpath("//span[contains(.,'2nd Day Air')]"));

        //verify total is "$698.00"
        verifyElements("error", "$698.00", By.xpath("//span[@class='value-summary']//strong[contains(text(),'$698.00')]"));

        //click on confirm
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));

        //verify the text "Thank you"
        verifyElements("error", "Thank you", By.xpath("//h1[contains(text(),'Thank you')]"));

        //verify the message "Your order has been successfully processed!"
        verifyElements("error", "Your order has been successfully processed!", By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));

        //click on continue
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));

        //verify the text welcome to our store
        verifyElements("error", "Welcome to our store", By.xpath("//h2[contains(text(),'Welcome to our store')]"));

        //click on logout link
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));

        //verify the URL is “https://demo.nopcommerce.com/”
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://demo.nopcommerce.com/");
    }

    @After
    public void tearDown() {
        closeBrowser();
    }


}
