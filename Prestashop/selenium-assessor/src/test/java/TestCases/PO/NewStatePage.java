package TestCases.PO;

// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

public class NewStatePage {

    WebDriver driver;

    JavascriptExecutor js;

    Map<String, Object> vars;

    public NewStatePage(WebDriver driver, JavascriptExecutor js, Map<String, Object> vars) {
        this.driver = driver;
        this.js = js;
        this.vars = vars;
    }

    public void getData() {
        By elem = By.cssSelector("ol > li:nth-child(2)");
        MyUtils.WaitForElementLoaded(driver, elem);
    }

    public void clickSave() {
        By elem = By.cssSelector(".process-icon-save");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).click();
        getData();
    }

    public String set_CSSSELECTOR_ollinth_child2() {
        By elem = By.cssSelector("ol > li:nth-child(2)");
        MyUtils.WaitForElementLoaded(driver, elem);
        return driver.findElement(elem).getText();
    }

    public void click_CSSSELECTOR_employee_namestring_long() {
        By elem = By.cssSelector(".employee_name > .string-long");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).click();
    }

    public void click_ID_header_logout() {
        By elem = By.id("header_logout");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).click();
    }

    public void SignOut() {
        click_CSSSELECTOR_employee_namestring_long();
        click_ID_header_logout();
    }

    public void changeISOCode(String key1, String key2) {
        By elem = By.id("iso_code");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).clear();
        driver.findElement(elem).sendKeys(key2);
    }

    public void changeCountry() {
        By elem = By.id("id_country");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).click();
    }

    public void click_CSSSELECTOR_id_countryoptionnth_child4() {
        By elem = By.cssSelector("#id_country > option:nth-child(4)");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).click();
    }

    public void changeZone(String key3) {
        {
            By elem = By.id("id_zone");
            MyUtils.WaitForElementLoaded(driver, elem);
            WebElement dropdown = driver.findElement(elem);
            elem = By.xpath("//option[. = '" + key3 + "']");
            MyUtils.WaitForElementLoaded(driver, elem);
            dropdown.findElement(elem).click();
        }
        By elem = By.cssSelector("#id_zone > option:nth-child(4)");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).click();
    }

    public void clickSave_1() {
        By elem = By.id("state_form_submit_btn");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).click();
    }

    public void changeName(String key1, String key2, String key3) {
        By elem = By.id("name");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).clear();
        driver.findElement(elem).sendKeys(key1);
        changeISOCode(key1, key2);
        changeCountry();
        click_CSSSELECTOR_id_countryoptionnth_child4();
        changeZone(key3);
        clickSave_1();
    }
}