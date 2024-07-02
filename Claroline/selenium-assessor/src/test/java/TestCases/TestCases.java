package TestCases;

import TestCases.PO.AdminPage;
import TestCases.PO.CoursePage;
import TestCases.PO.LoginPage;
import TestCases.PO.UserPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TestCases {
    WebDriver driver;
    LoginPage loginPage;
    AdminPage adminPage;
    UserPage userPage;
    CoursePage coursePage;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("http://localhost:3000/claroline11110/index.php");
        loginPage = new LoginPage(driver);
        adminPage = new AdminPage(driver);
        userPage = new UserPage(driver);
        coursePage = new CoursePage(driver);
    }

    @Test
    public void testAddUser() {
        loginPage.loginAs("admin", "admin");
        adminPage.navigateToPlatformAdministration();
        adminPage.createUser("Name001", "Firstname001", "user001", "password001");

        String confirmationMessage = UserPage.getConfirmationMessage();
        assertThat(confirmationMessage, is("The new user has been sucessfully created"));
    }

    @Test
    public void testSearchUser() {
        loginPage.loginAs("admin", "admin");
        adminPage.navigateToPlatformAdministration();
        userPage.searchUser("user001");
        assert(driver.getPageSource().contains("Name001"));
        assert(driver.getPageSource().contains("Firstname001"));
    }

    @Test
    public void testLoginAsUser() {
        loginPage.loginAs("user001", "password001");
        assert(driver.getPageSource().contains("Firstname001 Name001"));
    }

    @Test
    public void testAddCourse() {
        loginPage.loginAs("admin", "admin");
        adminPage.navigateToPlatformAdministration();
        adminPage.createCourse("Course001", "001", new String[]{"Sciences", "Economics"});
        String confirmationMessage = AdminPage.getConfirmationMessage();
        assertThat(confirmationMessage, is("You have just created the course website : 001"));
    }


    @Test
    public void testEnrollUserInCourse() {
        loginPage.loginAs("user001", "password001");
        coursePage.enrollUserInCourse("Course001");
        assert(driver.getPageSource().contains("You've been enrolled on the course"));
    }

    @Test
    public void testAddEventToCourse() {
        loginPage.loginAs("admin", "admin");
        driver.findElement(By.linkText("001 - Course001")).click();
        coursePage.addEvent("Exam 001", "31", "May", "2023", "Genoa");
        assert(driver.getPageSource().contains("Event added to the agenda"));
    }

    @Test
    public void testAddExerciseToCourse() {
        loginPage.loginAs("admin", "admin");
        driver.findElement(By.linkText("001 - Course001")).click();
        coursePage.addExercise("Exercise 001");
        assert(driver.getPageSource().contains("Exercise added"));
    }

    @Test
    public void testMakeExerciseVisible() {
        loginPage.loginAs("admin", "admin");
        driver.findElement(By.linkText("001 - Course001")).click();
        coursePage.makeExerciseVisible();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@href,'cmd=exMkInvis')]")));

        String altAttribute = element.getAttribute("alt");
        if (altAttribute != null) {
            assert(altAttribute.equals("Make invisible"));
        }
    }

    @Test
    public void testAddMultipleUsers() {
        loginPage.loginAs("admin", "admin");
        adminPage.navigateToPlatformAdministration();

        AdminPage.createUsers("testuser1", "testuser1", "testuser1", "testuser1", "student");
        driver.findElement(By.linkText("Back to admin page")).click();
        AdminPage.createUsers("testuser2", "testuser2", "testuser2", "testuser2", "teacher");
        driver.findElement(By.linkText("Back to admin page")).click();
        AdminPage.createUsers("testuser3", "testuser3", "testuser3", "testuser3", "administrator");
        driver.findElement(By.linkText("Back to admin page")).click();

        driver.findElement(By.linkText("User list")).click();

        assertTrue(driver.getPageSource().contains("testuser1"));
        assertTrue(driver.getPageSource().contains("testuser2"));
        assertTrue(driver.getPageSource().contains("testuser3"));
    }

    @Test
    public void testAddUserWithoutRequiredFields() {
        loginPage.loginAs("admin", "admin");
        adminPage.navigateToPlatformAdministration();

        adminPage.createUser("", "", "","");

        assertTrue(adminPage.isErrorMessageDisplayed("You left some required fields empty"));
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}
