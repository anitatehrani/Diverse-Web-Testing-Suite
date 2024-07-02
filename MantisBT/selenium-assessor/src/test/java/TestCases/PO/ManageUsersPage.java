package TestCases.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ManageUsersPage {
    private WebDriver driver;

    public ManageUsersPage(WebDriver driver) {
        this.driver = driver;
    }

    private By createNewAccountButton = By.cssSelector("input[value='Create New Account']");
    private By usernameField = By.name("username");
    private By realNameField = By.name("realname");
    private By emailField = By.name("email");
    private By accessLevelDropdown = By.name("access_level");
    private By createUserButton = By.cssSelector("input[value='Create User']");

    public void clickCreateNewAccount() {
        driver.findElement(createNewAccountButton).click();
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterRealName(String realName) {
        driver.findElement(realNameField).sendKeys(realName);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void selectAccessLevel(String accessLevel) {
        driver.findElement(accessLevelDropdown).sendKeys(accessLevel);
    }

    public void clickCreateUser() {
        driver.findElement(createUserButton).click();
    }

    public boolean isUserPresent(String username) {
        return driver.findElement(By.xpath("//td[contains(text(), '" + username + "')]")).isDisplayed();
    }

    public boolean isEmailPresent(String email) {
        return driver.findElement(By.xpath("//td[contains(text(), '" + email + "')]")).isDisplayed();
    }

    public boolean isAccessLevelPresent(String accessLevel) {
        return driver.findElement(By.xpath("//td[contains(text(), '" + accessLevel + "')]")).isDisplayed();
    }
}
