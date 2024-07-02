package TestCases.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AdminPage {
    static WebDriver driver;

    By platformAdministrationLink = By.linkText("Platform administration");
    By createUserLink = By.linkText("Create user");
    By createCourseLink = By.linkText("Create course");

    public AdminPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToPlatformAdministration() {
        driver.findElement(platformAdministrationLink).click();
    }

    public void createUser(String name, String firstName, String username, String password) {
        driver.findElement(createUserLink).click();
        driver.findElement(By.id("lastname")).sendKeys(name);
        driver.findElement(By.id("firstname")).sendKeys(firstName);
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("password_conf")).sendKeys(password);
        driver.findElement(By.id("student")).click();
        driver.findElement(By.id("applyChange")).click();
    }

    public static void createUsers(String name, String firstName, String username, String password, String role) {
        driver.findElement(By.linkText("Create user")).click();
        driver.findElement(By.id("lastname")).sendKeys(name);
        driver.findElement(By.id("firstname")).sendKeys(firstName);
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("password_conf")).sendKeys(password);

        switch (role) {
            case "student":
                driver.findElement(By.id("student")).click();
                break;
            case "teacher":
                driver.findElement(By.id("courseManager")).click();
                break;
            case "administrator":
                driver.findElement(By.id("platformAdmin")).click();
                break;
            default:
                break;
        }

        driver.findElement(By.id("applyChange")).click();
    }

    public void createCourse(String title, String code, String[] categories) {
        driver.findElement(createCourseLink).click();
        driver.findElement(By.id("course_title")).sendKeys(title);
        driver.findElement(By.id("course_officialCode")).sendKeys(code);
        for (String category : categories) {
            Select categorySelect = new Select(driver.findElement(By.id("mslist2")));
            categorySelect.selectByVisibleText(category);
            driver.findElement(By.id("mslist1")).click();
        }
        driver.findElement(By.id("access_public")).click();
        driver.findElement(By.id("registration_true")).click();
        driver.findElement(By.name("changeProperties")).click();
    }

    public boolean isErrorMessageDisplayed(String errorMessage) {
        return driver.findElement(By.xpath("//*[contains(text(),'" + errorMessage + "')]")).isDisplayed();
    }

    public static String getConfirmationMessage() {
        return driver.findElement(By.cssSelector(".claroDialogMsg.msgSuccess")).getText();
    }

}
