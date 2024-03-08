package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

public class BasePage {

    private WebDriver driver;
    private Actions action;
    private WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

   public BasePage(WebDriver driver){
       this.driver=driver;
   }


    //metodo para la cnexion con el navegador este caso el CHROME, l q hace es llamar al chrome driver

    public WebDriver ChromeConection() {

        System.setProperty("webdriver.chrome.driver", "/mnt/Data/COSAS JEI/JAVA/drivers/chromedriver-linux64/chromedriver");
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    //metodo get , es el encargado d recibir la url y abrir la pagina
    public void visitUrl(String url) {
        driver.get(url);
    }

    //ir al link por el texto por parametro al dar clic
    public void goToLinkText(String texLink){
       driver.findElement(By.linkText(texLink)).click();
    }

    //cerrar el navegador
    public void closeBrowser(){
       driver.quit();
    }

    //metodo privado de un webElement para esperar por la presencia del elemento y evitar poner esperas mas veces
    private WebElement Find(By locator){
       return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    //clic en un elemnto que ya fue pasado por el find declarado arriba
    public void clicElement(By locator){
       Find(locator).click();
    }

   //submit cuando se trata de un formulario
   public void submitElement(By locator){
       Find(locator).submit();
   }

   // escribir en un input antes limpiarlo
   public void write(By locator,String text){
       Find(locator).clear();
       Find(locator).sendKeys(text);
   }


   // texto de un elemento
    public String textFromElement(By locator){
       return Find(locator).getText();
    }

    //elemento habilitado
    public boolean elementEnable(By locator){
        return Find(locator).isEnabled();
    }

    //elemento disponible
    public boolean elementIsDisplayed(By locator){
        return Find(locator).isDisplayed();
    }

    //elemento selccionado
    public boolean elementIsSelected(By locator){
        return Find(locator).isSelected();
    }

   //////////////////////////////              LISTAS                   /////////////////////////////////


    //me devuelve una lista de elementos
    public List<WebElement> allElements(By locator){
       return driver.findElements(locator);
    }

    //selecciona un elemento de lista WebElement seggun su indice
    public  void selectFromElementsList(By locator, int index){
        List<WebElement>lista=driver.findElements(locator);

        lista.get(index).click();
    }

    //selecciona un elemento de lista WebElement seggun su texto
    public  void selectTextFromList(By locator, String text){
        List<WebElement>lista=driver.findElements(locator);
 for (WebElement options:lista){
      if (options.getText().equals(text)){
          options.click();
          break;
      }
 }

    }
//////////////                     DropDown     /  Select              //////////////////////////////

   // tamaño de una lista de tipo Select
   public int dropdownSize(By locator){
      Select select=new Select(Find(locator));
     List<WebElement>list= select.getOptions();
     return list.size();
   }

   //seleccionar un valor de una lista de tipo select
   public void dropdownFromValue(By locator, String value){
     Select select=new Select(Find(locator));
     select.selectByValue(value);
   }

   //seleccionar un elemento de una lista por el index

    public void dropdownByIndex(By locator,int index){

       Select select=new Select(Find(locator));
       select.selectByIndex(index);

    }

   //seleccionar un elemento por su texto
   public void dropdownByText(By locator, String text){
     Select select=new Select(Find(locator));
     select.selectByVisibleText(text);
       }

//////////////////////////           ACCIONES CON EL MOUSE            ///////////////////////////////

    // pasar sobre un elemento
    public void hoverOverElement(By locator){
        action.moveToElement(Find(locator));
    }

    //doble clic en un elemento
    public void dobleClicElement(By locator){
        action.doubleClick(Find(locator));
    }

    // clic derecho

    public void rightClic(By locator){
        action.contextClick(Find(locator));
    }

    // arrstar clic y luego soltalo

    public void moveToElement(By locator,By locator2){

        action.clickAndHold();
        action.dragAndDrop(Find(locator),Find(locator2));
        action.build().perform();
    }

    //////////////////////////////////                   TABLAS                    /////////////////////////////


    // devuelve un texto de un valor dentro de la tabla
/*
    public String getValueFromTable(By locator,int row, int colum){
       String celdaINed= locator+"/table/tbody/tr["+row+"]/td["+colum+"]";
       return Find(celdaINed).getText();
    }
*/

    ////////////////////////                     IFrames  + Alertas                    ////////////////////////////

    public  void swichtToFrames(int frameIndex){

        driver.switchTo().frame(frameIndex);
    }

    public  void swichtToParentFrames(){

        driver.switchTo().parentFrame();
    }

    public  void dissmisAlert(){

        try {
            driver.switchTo().alert().dismiss();
        }catch (NoAlertPresentException e){
            e.printStackTrace();
        }
    }
    public void AccepAlert(){
        driver.switchTo().alert().accept();
    }


}
