package page;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MenuPage extends BasePage {
    public MenuPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
