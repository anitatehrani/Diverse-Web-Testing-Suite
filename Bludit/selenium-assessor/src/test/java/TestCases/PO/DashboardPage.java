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

public class DashboardPage {

    WebDriver driver;

    JavascriptExecutor js;

    Map<String, Object> vars;

    public DashboardPage(WebDriver driver, JavascriptExecutor js, Map<String, Object> vars) {
        this.driver = driver;
        this.js = js;
        this.vars = vars;
    }

    public void click_CSSSELECTOR_uk_row_firstuk_panelnth_child1a() {
        By elem = By.cssSelector(".uk-row-first > .uk-panel:nth-child(1) a");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).click();
    }

    public void set_ID_jstitle(String key1) {
        By elem = By.id("jstitle");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).clear();
        driver.findElement(elem).sendKeys(key1);
    }

    public void clickSaveAsDraft() {
        By elem = By.id("jsSaveDraft");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).click();
    }

    public void clickNewContent(String key1) {
        click_CSSSELECTOR_uk_row_firstuk_panelnth_child1a();
        set_ID_jstitle(key1);
        clickSaveAsDraft();
    }

    public void clickUsers() {
        By elem = By.linkText("Users");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).click();
    }

    public void clickContent() {
        By elem = By.linkText("Content");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).click();
    }
}
