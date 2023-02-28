package page;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(linkText = "Generate Card Number")
    private WebElement btnGenerarTarjeta;

    @FindBy(name = "quantity")
    private WebElement cbCantidad;


    @FindBy(xpath = "//*[@class='button special']")
    private WebElement btnComprar;

    public void clickGenerarTarjeta() {
        wait.until(ExpectedConditions.elementToBeClickable(btnGenerarTarjeta));
        btnGenerarTarjeta.click();
    }

    public void seleccionarCant() {
        wait.until(ExpectedConditions.visibilityOf(cbCantidad));
        new Select(cbCantidad).selectByValue("5");
    }


    public void seleccionarCantFinal(int cant) {
        wait.until(ExpectedConditions.visibilityOf(cbCantidad));
        new Select(cbCantidad).selectByValue(String.valueOf(cant));
    }

    public void clickComprar() {
        btnComprar.click();
    }

}
