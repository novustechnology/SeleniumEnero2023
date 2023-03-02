package step;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import page.FormularioPage;

public class FormularioStep {

    FormularioPage formularioPage;

    public FormularioStep() {
        formularioPage = new FormularioPage(Hooks.driver);
    }


    @Given("ingreso a la pagina TutorialsPoint")
    public void ingresoALaPaginaTutorialsPoint() {
        Hooks.driver.get("https://www.tutorialspoint.com/selenium/selenium_automation_practice.htm");
    }

    @And("ingreso los datos del formulario")
    public void ingresoLosDatosDelFormulario(DataTable dataTable) {
        formularioPage.ingresarDatosFormulario(dataTable);
    }

    @And("cargo una imagen y selecciono el tipo de Selenium {string}")
    public void cargoUnaImagenYSeleccionoElTipoDeSelenium(String tipoSelenium) throws InterruptedException {
        formularioPage.cargarImagen();
        formularioPage.seleccionarTipoSelenium(tipoSelenium);
    }

    @And("selecciono el continente {string} y los comandos de selenium")
    public void seleccionoElContinenteYLosComandosDeSelenium(String arg0) {
    }
}
