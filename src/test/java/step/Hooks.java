package step;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Hooks {

    public static WebDriver driver;


    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Tiempo de espera implicito:Es una espera genérica para la ejecución completa
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @After
    public void tearDown(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
