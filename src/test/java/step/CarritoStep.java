package step;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.DatosTarjetaPage;
import page.HomePage;

public class CarritoStep {

    HomePage homePage;

    DatosTarjetaPage datosTarjetaPage;

    public CarritoStep() {
        homePage = new HomePage(Hooks.driver);
        datosTarjetaPage= new DatosTarjetaPage(Hooks.driver);
    }

    @Given("la pagina DemoGuru esta disponible")
    public void laPaginaDemoGuruEstaDisponible() {
        Hooks.driver.get("https://demo.guru99.com/payment-gateway/index.php");
    }

    @When("doy click en generar tarjeta")
    public void doyClickEnGenerarTarjeta() {
        homePage.clickGenerarTarjeta();

    }

    @And("capturo los datos de la tarjeta")
    public void capturoLosDatosDeLaTarjeta() {
        datosTarjetaPage.cambiarVentana();
        datosTarjetaPage.capturarTarjeta();
        datosTarjetaPage.capturarCvv();
        datosTarjetaPage.capturarFechaExp();
        datosTarjetaPage.cerrarVentana();
    }

    @And("selecciono una cantidad de productos al carritos y le doy comprar")
    public void seleccionoUnaCantidadDeProductosAlCarritosYLeDoyComprar() {
    }

    @Then("ingreso los datos de la tarjeta")
    public void ingresoLosDatosDeLaTarjeta() {
    }
}
