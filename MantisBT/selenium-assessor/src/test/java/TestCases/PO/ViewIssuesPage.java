package TestCases.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewIssuesPage {
    private WebDriver driver;

    public ViewIssuesPage(WebDriver driver) {
        this.driver = driver;
    }

    private By firstIssueCheckbox = By.name("bug_arr[]");
    private By actionDropdown = By.name("action");
    private By okButton = By.cssSelector("input[value='OK']");
    private By assignIssuesButton = By.cssSelector("input[value='Assign Issues']");

    public void clickFirstIssueCheckbox() {
        driver.findElement(firstIssueCheckbox).click();
    }

    public void selectAction(String action) {
        driver.findElement(actionDropdown).sendKeys(action);
    }

    public void clickOk() {
        driver.findElement(okButton).click();
    }

    public void clickAssignIssues() {
        driver.findElement(assignIssuesButton).click();
    }

}
