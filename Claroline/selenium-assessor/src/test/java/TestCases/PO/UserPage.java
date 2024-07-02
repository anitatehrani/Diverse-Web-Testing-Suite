package TestCases.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserPage {
    static WebDriver driver;

    public UserPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchUser(String username) {
        driver.findElement(By.id("search_user")).sendKeys(username);
        driver.findElement(By.cssSelector("input[type='submit']")).click();
    }

    public static String getConfirmationMessage() {
        return driver.findElement(By.cssSelector(".claroDialogMsg.msgSuccess")).getText();
    }
}
