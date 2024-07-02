package TestCases;

import TestCases.PO.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertNotNull;

public class TestCases {
    private WebDriver driver;
    private String baseUrl;
    private LoginPage loginPage;
    private HomePage homePage;
    private ManagePage managePage;
    private ManageUsersPage manageUsersPage;
    private ManageProjectsPage manageProjectsPage;
    private ReportIssuePage reportIssuePage;
    private ViewIssuesPage viewIssuesPage;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        baseUrl = "http://localhost:3000/mantisbt/";
        driver.get(baseUrl);

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        managePage = new ManagePage(driver);
        manageUsersPage = new ManageUsersPage(driver);
        manageProjectsPage = new ManageProjectsPage(driver);
        reportIssuePage = new ReportIssuePage(driver);
        viewIssuesPage = new ViewIssuesPage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testLoginAsAdmin() {
        loginPage.enterUsername("administrator");
        loginPage.enterPassword("root");
        loginPage.clickLogin();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.italic")));

        assertTrue(driver.findElement(By.cssSelector("span.italic")).getText().contains("administrator"));
    }

    @Test
    public void testAddNewUser() {
        loginAsAdmin();
        homePage.clickManage();
        managePage.clickManageUsers();
        manageUsersPage.clickCreateNewAccount();
        manageUsersPage.enterUsername("username001");
        manageUsersPage.enterRealName("username001");
        manageUsersPage.enterEmail("username@username.it");
        manageUsersPage.selectAccessLevel("updater");
        manageUsersPage.clickCreateUser();
        managePage.clickManageUsers();

        assertTrue(manageUsersPage.isUserPresent("username001"));
        assertTrue(manageUsersPage.isEmailPresent("username@username.it"));
        assertTrue(manageUsersPage.isAccessLevelPresent("updater"));

        homePage.clickLogout();
    }

    @Test
    public void testAddExistingUserFails() {
        loginAsAdmin();
        homePage.clickManage();
        managePage.clickManageUsers();
        manageUsersPage.clickCreateNewAccount();
        manageUsersPage.enterUsername("username001");
        manageUsersPage.enterRealName("username001");
        manageUsersPage.enterEmail("username@username.it");
        manageUsersPage.selectAccessLevel("updater");
        manageUsersPage.clickCreateUser();

        WebElement errorMessage = driver.findElement(By.xpath("//p[contains(text(), 'That username is already being used. Please go back and select another one.')]"));
        assertNotNull(errorMessage);

        homePage.clickLogout();
    }

    @Test
    public void testAddEmptyUserFails() {
        loginAsAdmin();
        homePage.clickManage();
        managePage.clickManageUsers();
        manageUsersPage.clickCreateNewAccount();
        manageUsersPage.clickCreateUser();

        WebElement errorMessage = driver.findElement(By.xpath("//p[contains(text(), 'A necessary field \"\" was empty. Please recheck your inputs.')]"));
        assertNotNull(errorMessage);

        homePage.clickLogout();
    }

    @Test
    public void testAddNewProject() {
        loginAsAdmin();
        homePage.clickManage();
        managePage.clickManageProjects();
        manageProjectsPage.clickCreateNewProject();
        manageProjectsPage.enterProjectName("Project001");
        manageProjectsPage.selectStatus("release");
        manageProjectsPage.selectViewStatus("public");
        manageProjectsPage.enterDescription("Description");
        manageProjectsPage.clickAddProject();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue(manageProjectsPage.isProjectPresent("Project001"));
        assertTrue(manageProjectsPage.isStatusPresent("release"));
        assertTrue(manageProjectsPage.isViewStatusPresent("public"));
        assertTrue(manageProjectsPage.isDescriptionPresent("Description"));

        homePage.clickLogout();
    }

    @Test
    public void testAddExistingProjectFails() {
        loginAsAdmin();
        homePage.clickManage();
        managePage.clickManageProjects();
        manageProjectsPage.clickCreateNewProject();
        manageProjectsPage.enterProjectName("Project001");
        manageProjectsPage.selectStatus("release");
        manageProjectsPage.selectViewStatus("public");
        manageProjectsPage.enterDescription("Description");
        manageProjectsPage.clickAddProject();

        WebElement errorMessage = driver.findElement(By.xpath("//p[contains(text(), 'A project with that name already exists. Please go back and enter a different name.')]"));
        assertNotNull(errorMessage);

        homePage.clickLogout();
    }

    @Test
    public void testAddCategory() {
        loginAsAdmin();
        homePage.clickManage();
        managePage.clickManageProjects();
        manageProjectsPage.enterCategoryName("Category001");
        manageProjectsPage.clickAddCategory();
        homePage.clickLogout();
    }

    @Test
    public void testAddExistingCategoryFails() {
        loginAsAdmin();
        homePage.clickManage();
        managePage.clickManageProjects();
        manageProjectsPage.enterCategoryName("Category001");
        manageProjectsPage.clickAddCategory();

        WebElement errorMessage = driver.findElement(By.xpath("//p[contains(text(), 'A category with that name already exists.')]"));
        assertNotNull(errorMessage);

        homePage.clickLogout();
    }

    @Test
    public void testAddNewIssue() {
        loginAsAdmin();
        driver.findElement(By.linkText("Report Issue")).click();
//        reportIssuePage.selectProject("Project001");
        reportIssuePage.selectCategory("[All Projects] Category001");
        reportIssuePage.selectReproducibility("random");
        reportIssuePage.selectSeverity("crash");
        reportIssuePage.selectPriority("immediate");
        reportIssuePage.enterSummary("Summary001");
        reportIssuePage.enterDescription("description001");
        reportIssuePage.clickSubmitReport();
        driver.findElement(By.linkText("View Issues")).click();

        assertTrue(driver.findElement(By.xpath("//td[contains(text(), 'Category001')]")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//span[contains(text(), 'crash')]")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//td[contains(text(), 'Summary001')]")).isDisplayed());

        homePage.clickLogout();
    }

    @Test
    public void testAssignIssue() {
        loginAsAdmin();
        driver.findElement(By.linkText("View Issues")).click();
        viewIssuesPage.clickFirstIssueCheckbox();
        viewIssuesPage.selectAction("Assign");
        viewIssuesPage.clickOk();
        viewIssuesPage.clickAssignIssues();

        assertTrue(driver.findElement(By.xpath("//span[contains(text(), 'assigned')]")).isDisplayed());

        homePage.clickLogout();
    }

    @Test
    public void testDeleteIssue() {
        loginAsAdmin();

        driver.findElement(By.linkText("View Issues")).click();

        viewIssuesPage.clickFirstIssueCheckbox();

        new Select(driver.findElement(By.cssSelector("select[name='action']"))).selectByVisibleText("Delete");

        driver.findElement(By.cssSelector("input[value='OK']")).click();

        driver.findElement(By.cssSelector("input[value='Delete Issues']")).click();

        String headerText = driver.findElement(By.cssSelector("span.floatleft")).getText();
        assertEquals("Viewing Issues (0 - 0 / 0)", headerText);
        homePage.clickLogout();
    }

    private void loginAsAdmin() {
        loginPage.enterUsername("administrator");
        loginPage.enterPassword("root");
        loginPage.clickLogin();
    }
}
