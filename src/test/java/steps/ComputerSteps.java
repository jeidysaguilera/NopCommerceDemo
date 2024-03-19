package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.ComputerPage;

public class ComputerSteps {

    ComputerPage compu;
    WebDriver driver;

    @Given("entro en la pagina de NoCommerce")
    public void entro_en_la_pagina_de_no_commerce() {
       compu=new ComputerPage(driver);
       driver=compu.ChromeConection();

       compu.navigateToComputerPage();
    }

    @Given("voy al link {string}")
    public void voy_al_link(String string) {
       compu.ElectronicLink(string);
    }

    @When("voy a {string}")
    public void voy_a(String string) {
       compu.ElectronicLink(string);
    }

    @Then("Verifico que hay {int} productos disponibles")
    public void verifico_que_hay_productos_disponibles(Integer int1){
        System.out.println("el sisze es " + compu.sizeLista().size());
        int valorActual=compu.sizeLista().size();
        if (int1==valorActual){
            System.out.println("Los valores son iguales ");
        }else {
            System.out.println("Los valores NO son iguales ");
        }
    }

    @When("voy a las diferentes {string}")
    public void voy_a_las_diferentes(String string) {
        compu.ElectronicLink(string);
    }

    @Then("Obtengo el nombre de todas las que visite")
    public void obtengo_el_nombre_de_todas_las_que_visite() {

    }

    @Then("Verifico con la cantidad Actual")
    public void verifico_con_la_cantidad_actual() {

    }
}
