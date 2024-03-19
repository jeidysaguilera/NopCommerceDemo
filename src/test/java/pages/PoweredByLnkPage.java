package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PoweredByLnkPage extends BasePage{



   String link= "nopCommerce";
 String titulo="Free and open-source eCommerce platform. ASP.NET Core based shopping cart. - nopCommerce";
    public PoweredByLnkPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToComputerPage(){
        visitUrl("https://demo.nopcommerce.com/computers");
    }

    public  void goToLinknoCommerce(){
     goToLinkText(link);
     SwitchToWindows(1);
    }

    public Boolean VerificarTitulo(){
       // SwitchToWindows(1);
        return Title().equals(titulo);
    }
    public void closeSecondsWindow(){
         closeBrowser();
    }
}
