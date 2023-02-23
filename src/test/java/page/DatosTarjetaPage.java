package page;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Set;

public class DatosTarjetaPage extends BasePage {
    public DatosTarjetaPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String VENTANA_ORIGINAL;

    protected static String tarjeta;

    protected static String cvv;

    protected static String mes;

    protected static String anio;


    @FindBy(xpath = "//h4[1]")
    private WebElement lblNroTarjeta;

    @FindBy(xpath = "//h4[2]")
    private WebElement lblCvv;

    @FindBy(xpath = "//h4[3]")
    private WebElement lblFechaExp;


    public void cambiarVentana() {
        VENTANA_ORIGINAL = driver.getWindowHandle();
        Set<String> TODAS_LAS_VENTANAS = driver.getWindowHandles();
        for (String ventana : TODAS_LAS_VENTANAS) {
            if (!ventana.equalsIgnoreCase(VENTANA_ORIGINAL)) {
                driver.switchTo().window(ventana);
            }
            System.out.println("Ventana: " + ventana);
        }
    }

    public void capturarTarjeta() {
        wait.until(ExpectedConditions.visibilityOf(lblNroTarjeta));
        tarjeta = lblNroTarjeta.getText().replace("Card Number:- ", "");
        System.out.println("Nro Tarjeta: " + tarjeta);
    }

    public void capturarCvv() {
        wait.until(ExpectedConditions.visibilityOf(lblCvv));
        cvv = lblCvv.getText().replace("CVV:- ", "");
        System.out.println("Cvv: " + cvv);
    }

    public void capturarFechaExp() {
        String[] fecha = lblFechaExp.getText().replace("Exp:- ", "").split("/");
        mes = fecha[0];
        anio = fecha[1];
        System.out.println("Mes: " + mes);
        System.out.println("Año: " + anio);
    }

    public void cerrarVentana() {
        driver.close();
        driver.switchTo().window(VENTANA_ORIGINAL);
    }

}
