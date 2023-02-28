package page;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class DatosPagoPage extends BasePage {
    public DatosPagoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@placeholder='Enter Your Card Number']")
    private WebElement txtNroTarjeta;

    @FindBy(name = "month")
    private WebElement cbMes;

    @FindBy(name = "year")
    private WebElement cbAnio;

    @FindBy(id = "cvv_code")
    private WebElement txtCvv;

    @FindBy(name = "submit")
    private WebElement btnComprar;


    public void ingresarDatos() {
        txtNroTarjeta.sendKeys(DatosTarjetaPage.tarjeta);
        new Select(cbMes).selectByVisibleText(DatosTarjetaPage.mes);
        new Select(cbAnio).selectByVisibleText(DatosTarjetaPage.anio);
        txtCvv.sendKeys(DatosTarjetaPage.cvv);
        btnComprar.click();
    }
}
