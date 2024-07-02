package TestCases.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ManagePage {
    private WebDriver driver;

    public ManagePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickManageUsers() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='/mantisbt/manage_user_page.php']")));
        driver.findElement(By.cssSelector("a[href='/mantisbt/manage_user_page.php']")).click();
    }

    public void clickManageProjects() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='/mantisbt/manage_proj_page.php']")));
        driver.findElement(By.cssSelector("a[href='/mantisbt/manage_proj_page.php']")).click();
    }
}
