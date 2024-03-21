package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;

public class ShoppingCartTablePage extends BasePage {


    WebDriver driver;

    public ShoppingCartTablePage(WebDriver driver) {
        super(driver);
    }

    String linkText = "Shopping cart";

    By tableClass = By.xpath("//table[@class=\"cart\"]");
    By rows = By.xpath("//table[@class=\"cart\"]/tbody/tr");

    By column = By.xpath("//table[@class=\"cart\"]/thead/tr/th");

    By celda1_1 = By.xpath("//table[@class=\"cart\"]/tbody/tr[1]/td[1]");

    

    By buttons = By.xpath("//button[@class=\"button-2 product-box-add-to-cart-button\"]");


    By contador = By.xpath("//ul/li[@id=\"topcartlink\"]/a/span[@class=\"cart-qty\"]");

    public void goToAddtoCart() {
        visitUrl("https://demo.nopcommerce.com/cell-phones");
    }

    public int sizeRows() {

        return allElements(rows).size();

    }

    public int sizeColumn() {

        return allElements(column).size();

    }

    public void ClicAddToCart() throws InterruptedException {
        clicToAllElements(buttons);
    }


    public void GoToLinkCart() {
        goToLinkText(linkText);
    }


    public String texto() {
        return textFromElement(contador);
    }

    public String Celda() {
        return textFromElement(celda1_1);
    }


}

