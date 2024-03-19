package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ComputerPage extends BasePage{


    By classList= By.xpath("//div[@class=\"item-box\"]//div[@class=\"picture\"]//a");


    public ComputerPage(WebDriver driver) {
        super(driver);
    }

   public void navigateToComputerPage(){
        visitUrl("https://demo.nopcommerce.com/computers");
   }

public void ElectronicLink(String text){
        goToLinkText(text);
}

public List<WebElement> sizeLista() {
    return allElements(classList);

}


}
