package TestCases.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReportIssuePage {
    private WebDriver driver;

    public ReportIssuePage(WebDriver driver) {
        this.driver = driver;
    }

    private By projectDropdown = By.name("project_id");
    private By categoryDropdown = By.name("category_id");
    private By reproducibilityDropdown = By.name("reproducibility");
    private By severityDropdown = By.name("severity");
    private By priorityDropdown = By.name("priority");
    private By summaryField = By.name("summary");
    private By descriptionField = By.name("description");
    private By submitReportButton = By.cssSelector("input[value='Submit Report']");

    public void selectCategory(String category) {
        driver.findElement(categoryDropdown).sendKeys(category);
    }

    public void selectProject(String project) {
        WebElement projectElement = driver.findElement(projectDropdown);
        if (projectElement.isDisplayed() && projectElement.isEnabled()) {
            projectElement.sendKeys(project);
        }
    }
    public void selectReproducibility(String reproducibility) {
        driver.findElement(reproducibilityDropdown).sendKeys(reproducibility);
    }

    public void selectSeverity(String severity) {
        driver.findElement(severityDropdown).sendKeys(severity);
    }

    public void selectPriority(String priority) {
        driver.findElement(priorityDropdown).sendKeys(priority);
    }

    public void enterSummary(String summary) {
        driver.findElement(summaryField).sendKeys(summary);
    }

    public void enterDescription(String description) {
        driver.findElement(descriptionField).sendKeys(description);
    }

    public void clickSubmitReport() {
        driver.findElement(submitReportButton).click();
    }
}
