package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.ShoppingCartTablePage;

public class ShoppingCartTableSteps {

WebDriver driver;
ShoppingCartTablePage shopping;


    @Given("Estoy en la pagina de Cell phones con productos para agregar al carrito")
    public void estoy_en_la_pagina_de_cell_phones_con_productos_para_agregar_al_carrito() {

        shopping=new ShoppingCartTablePage(driver);
        driver=shopping.ChromeConection();

        shopping.goToAddtoCart();
    }
    @When("Agrego todos los productos que existen al carrito")
    public void agrego_todos_los_productos_que_existen_al_carrito() throws InterruptedException {

        shopping.ClicAddToCart();
        System.out.println("Se seleccino todos los botones");

    }
    @Then("Se muestra los productos agregados correctamente")
    public void se_muestra_los_productos_agregados_correctamente() throws InterruptedException {

        Thread.sleep(2000);
        String show=shopping.texto();
        System.out.println("La cantidad de productos son " + show);
        if (show=="(0)"){
            System.out.println("No se agregó ningun producto al carrito ");
        }
    }
    @When("Doy clic en el carrito para verificar mis productos")
    public void doy_clic_en_el_carrito_para_verificar_mis_productos() {

        shopping.GoToLinkCart();
    }
    @Then("Obtengo la cantidad de filas que hay en mii tabla de productos agregados")
    public void obtengo_la_cantidad_de_filas_que_hay_en_mii_tabla_de_productos_agregados() {

        System.out.println("El size de la cantidad de filas en la tabla es " + shopping.sizeRows());
    }
    @And("Obtengo el numero de columnas de m tabla de productos")
    public void obtengo_el_numero_de_columnas_de_m_tabla_de_productos() {
        System.out.println("El size de la cantidad de columnas en la tabla es " + shopping.sizeColumn());
    }

    @And("Obtengo el valor de la primera celda primera columna")
    public void obtengo_el_valor_de_la_primera_celda_primera_columna() {
        System.out.println("La celda que corresponde a la primera fila primera columna es  " + shopping.Celda());
    }
}
