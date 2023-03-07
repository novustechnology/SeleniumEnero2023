package page;

import base.BasePage;
import base.ConfigFileReader;
import io.cucumber.datatable.DataTable;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import util.Util;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class FormularioPage extends BasePage {
    public FormularioPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    String CSV_FILE_PATH = "src/test/resources/data/test.csv";

    @FindBy(id = "banner-accept")
    private WebElement btnBanner;

    @FindBy(name = "firstname")
    private WebElement txtFirstname;

    @FindBy(name = "lastname")
    private WebElement txtLastname;

    @FindBy(name = "photo")
    private WebElement btnImagen;

    @FindBy(name = "continents")
    private WebElement cbContinente;

    @FindBy(xpath = "//button[text()='Button']")
    private WebElement btnEnviar;


    public void ingresarUrl() {
        driver.get(ConfigFileReader.getProp("url"));
    }


    public void ingresarDatosFormulario(DataTable dataTable) {
        wait.until(ExpectedConditions.elementToBeClickable(btnBanner));
        btnBanner.click();

        List<Map<String, String>> lista = dataTable.asMaps(String.class, String.class);
        for (int i = 0; i < lista.size(); i++) {
            txtFirstname.sendKeys(lista.get(i).get("firstName"));
            txtLastname.sendKeys(lista.get(i).get("lastName"));
            driver.findElement(By.xpath("//input[@value='" + lista.get(i).get("sex") + "']")).click();
            driver.findElement(By.xpath("//span[text()='" + lista.get(i).get("yearsExperience") + "']")).click();
            driver.findElement(By.xpath("//input[@value='" + lista.get(i).get("profession") + "']")).click();
        }

    }


    public void ingresarDatosCsv() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btnBanner)).click();
            Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader());

            for (CSVRecord csvRecord : csvParser) {
                txtFirstname.sendKeys(csvRecord.get("firstName"));




            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public void cargarImagen() throws InterruptedException {
        btnImagen.sendKeys("D:\\Proyectos Intellij\\SeleniumFebrero\\src\\test\\resources\\data\\cucumber.png");
        Thread.sleep(5000);
    }

    public void seleccionarTipoSelenium(String tipoSelenium) {
        System.out.println("-----NO SELECCIONADOS------");
        System.out.println("isEnable " + driver.findElement(By.xpath("//input[@value='RC']")).isEnabled());
        System.out.println("isSelected " + driver.findElement(By.xpath("//input[@value='RC']")).isSelected());
        System.out.println("isDisplayed " + driver.findElement(By.xpath("//input[@value='RC']")).isDisplayed());


        System.out.println("-----SELECCIONADOS------");
        driver.findElement(By.xpath("//input[@value='" + tipoSelenium + "']")).click();
        WebElement seleniumTipo = driver.findElement(By.xpath("//input[@value='" + tipoSelenium + "']"));
        System.out.println("isEnabled " + seleniumTipo.isEnabled());
        System.out.println("isSelected " + seleniumTipo.isSelected());
        System.out.println("isDisplayed " + seleniumTipo.isDisplayed());
    }

    public void seleccionarContinente(String continente) {
        new Select(cbContinente).selectByVisibleText(continente);
    }

    public void seleccionarComandoSelenium() {
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.LEFT_CONTROL)
                .click(driver.findElement(By.xpath("//option[text()='Browser Commands']")))
                .click(driver.findElement(By.xpath("//option[text()='Navigation Commands']")))
                .keyUp(Keys.LEFT_CONTROL)
                .build()
                .perform();
        //Util.scrollToElement(btnEnviar);
    }

    public void clickBotonEnviar() {
        btnEnviar.click();
        wait.until(ExpectedConditions.alertIsPresent()).dismiss();
        //Alert alerta = driver.switchTo().alert();
        //alerta.accept();
    }


}
