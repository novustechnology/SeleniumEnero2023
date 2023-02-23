package page;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(linkText = "Generate Card Number")
    private WebElement btnGenerarTarjeta;


    public void clickGenerarTarjeta() {
    wait.until(ExpectedConditions.elementToBeClickable(btnGenerarTarjeta));
    btnGenerarTarjeta.click();


    }


}
