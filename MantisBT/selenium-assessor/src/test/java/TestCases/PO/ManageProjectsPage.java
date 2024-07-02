package TestCases.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ManageProjectsPage {
    private WebDriver driver;

    public ManageProjectsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By createNewProjectButton = By.cssSelector("input[value='Create New Project']");
    private By projectNameField = By.name("name");
    private By statusDropdown = By.name("status");
    private By viewStatusDropdown = By.name("view_state");
    private By descriptionField = By.name("description");
    private By addProjectButton = By.cssSelector("input[value='Add Project']");

    public void clickCreateNewProject() {
        driver.findElement(createNewProjectButton).click();
    }

    public void enterProjectName(String projectName) {
        driver.findElement(projectNameField).sendKeys(projectName);
    }

    public void enterCategoryName(String categorytName) {
        driver.findElement(projectNameField).sendKeys(categorytName);
    }

    public void selectStatus(String status) {
        driver.findElement(statusDropdown).sendKeys(status);
    }

    public void selectViewStatus(String viewStatus) {
        driver.findElement(viewStatusDropdown).sendKeys(viewStatus);
    }

    public void enterDescription(String description) {
        driver.findElement(descriptionField).sendKeys(description);
    }

    public void clickAddProject() {
        driver.findElement(addProjectButton).click();
    }

    public boolean isProjectPresent(String projectName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='" + projectName + "']")));
        return driver.findElement(By.xpath("//a[text()='" + projectName + "']")).isDisplayed();
    }

    public boolean isStatusPresent(String status) {
        return driver.findElement(By.xpath("//td[contains(text(), '" + status + "')]")).isDisplayed();
    }

    public boolean isViewStatusPresent(String viewStatus) {
        return driver.findElement(By.xpath("//td[contains(text(), '" + viewStatus + "')]")).isDisplayed();
    }

    public boolean isDescriptionPresent(String description) {
        return driver.findElement(By.xpath("//td[contains(text(), '" + description + "')]")).isDisplayed();
    }

    public void clickAddCategory() {
        driver.findElement(By.cssSelector("input[value='Add Category']")).click();
    }
}
