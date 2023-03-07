package step;

import base.ConfigFileReader;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Hooks {

    public static final WebDriver driver = createDriver();


    private static WebDriver createDriver() {
        String browser = ConfigFileReader.getProp("browser").toLowerCase();
        switch (browser) {
            case "chrome":
                return new ChromeDriver();
            case "firefox":
                return new FirefoxDriver();
            default:
                throw new RuntimeException("Browser no soportado: " + browser);
        }
    }


    @Before
    public void setUp() {
        //driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Tiempo de espera implicito:Es una espera genérica para la ejecución completa
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @AfterStep
    public void screenshot(Scenario scenario) {
        //if (scenario.isFailed()) {
        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getName());
        //}
    }


    @After
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
