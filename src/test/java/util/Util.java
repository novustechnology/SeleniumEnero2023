package util;

import base.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Util extends BasePage {
    public Util(WebDriver driver) {
        super(driver);
    }

    public static boolean scrollToElement(WebElement element) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", element);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
