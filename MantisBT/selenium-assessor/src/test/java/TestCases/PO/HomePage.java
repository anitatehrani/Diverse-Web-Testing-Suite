package TestCases.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By manageLink = By.linkText("Manage");
    private By logoutLink = By.linkText("Logout");

    public void clickManage() {
        driver.findElement(manageLink).click();
    }

    public void clickLogout() {
        driver.findElement(logoutLink).click();
    }
}
