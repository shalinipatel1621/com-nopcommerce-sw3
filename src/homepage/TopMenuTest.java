package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class TopMenuTest extends Utility {

    String baseURL = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseURL);
    }

    public void selectMenu(String menu) {
        List<WebElement> selectMenu = driver.findElements(By.xpath("//ul[@class='top-menu notmobile']/child::li"));
        for (WebElement element : selectMenu) {
            if (element.getText().equalsIgnoreCase(menu)) {
                element.click();
                break;
            }


        }
    }

    //Create the @Test method name verifyPageNavigation.use selectMenu method to select the menu and click on it and verify the page navagation
    @Test
    public void verifyPageNavigation() {
        selectMenu("Computers");
        verifyText("Computers", getTextFromElement(By.xpath("//h1[contains(text(),'Computers')]")));
        selectMenu("Electronics");
        verifyText("Electronics", getTextFromElement(By.xpath(("(//a[normalize-space()='Electronics'])[1]"))));
        selectMenu("Apparel");
        verifyText("Apparel", getTextFromElement(By.xpath("(//a[normalize-space()='Apparel'])[1]")));
        selectMenu("Digital Downloads");
        verifyText("Digital Downloads", getTextFromElement(By.xpath("(//a[normalize-space()='Digital downloads'])[1]")));
        selectMenu("Books");
        verifyText("Books", getTextFromElement(By.xpath("(//a[normalize-space()='Books'])[1]")));
        selectMenu("Jewelery");
        verifyText("Jewelry", getTextFromElement(By.xpath("(//a[normalize-space()='Jewelry'])[1]")));
        selectMenu("Gift Cards");
        verifyText("Gift Cards", getTextFromElement(By.xpath("(//a[normalize-space()='Gift Cards'])[1]")));

    }

    @After
    public void tearDown() {
        closeBrowser();

    }
}
