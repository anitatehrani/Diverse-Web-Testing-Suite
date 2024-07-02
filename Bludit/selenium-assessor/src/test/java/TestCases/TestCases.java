package TestCases;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import java.util.HashMap;
import java.util.Map;
import TestCases.PO.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestCases {

    @BeforeClass
    public static void setup() {
    }

    private WebDriver driver;
    private Map<String, Object> vars;
    private JavascriptExecutor js;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testAddAsDraft() {
        driver.get("http://localhost:8080/admin");
        driver.manage().window().setSize(new Dimension(1314, 699));
        LoginPage _LoginPage = new LoginPage(driver, js, vars);
        _LoginPage.doLogin("admin", "password");
        DashboardPage _DashboardPage = new DashboardPage(driver, js, vars);
        _DashboardPage.clickNewContent("Draft Content");
        ManageContentPage _ManageContentPage = new ManageContentPage(driver, js, vars);
        _ManageContentPage.getData();
    }

    @Test
    public void testAddContest() {
        driver.get("http://localhost:8080/admin");
        driver.manage().window().setSize(new Dimension(1103, 696));
        LoginPage _LoginPage = new LoginPage(driver, js, vars);
        _LoginPage.doLogin("admin", "password");
        DashboardPage _DashboardPage = new DashboardPage(driver, js, vars);
        _DashboardPage.click_CSSSELECTOR_uk_row_firstuk_panelnth_child1a();
        AddContentPage _AddContentPage = new AddContentPage(driver, js, vars);
        _AddContentPage.createContent("Test Content");
        ManageContentPage _ManageContentPage = new ManageContentPage(driver, js, vars);
        assertThat(_ManageContentPage.getData_1(), is("Test Content"));
        _ManageContentPage.logout();
    }

    @Test
    public void testAddSocials() {
        driver.get("http://localhost:8080/admin");
        driver.manage().window().setSize(new Dimension(1222, 699));
        LoginPage _LoginPage = new LoginPage(driver, js, vars);
        _LoginPage.doLogin("admin", "password");
        DashboardPage _DashboardPage = new DashboardPage(driver, js, vars);
        _DashboardPage.clickUsers();
        UsersPage _UsersPage = new UsersPage(driver, js, vars);
        _UsersPage.clickAdmin();
        EditUserPage _EditUserPage = new EditUserPage(driver, js, vars);
        _EditUserPage.changeFacebook("https://www.facebook.com/some_fake_user_name_52432562135863", "https://instagram.com/some_fake_user_name_52432562135863");
        _UsersPage.clickAdmin_1();
        _EditUserPage.getData();
    }

    @Test
    public void testAddUser() {
        driver.get("http://localhost:8080/admin");
        driver.manage().window().setSize(new Dimension(1220, 699));
        LoginPage _LoginPage = new LoginPage(driver, js, vars);
        _LoginPage.doLogin("admin", "password");
        DashboardPage _DashboardPage = new DashboardPage(driver, js, vars);
        _DashboardPage.clickUsers();
        UsersPage _UsersPage = new UsersPage(driver, js, vars);
        _UsersPage.clickAddANewUser("usertest", "usertest123", "usertest123", "Administrator", "user@test.com");
        NewUserPage _NewUserPage = new NewUserPage(driver, js, vars);
        _NewUserPage.clickSave();
        _UsersPage.getData();
    }

    @Test
    public void testChangeParent() {
        driver.get("http://localhost:8080/admin");
        driver.manage().window().setSize(new Dimension(1219, 699));
        LoginPage _LoginPage = new LoginPage(driver, js, vars);
        _LoginPage.doLogin("admin", "password");
        DashboardPage _DashboardPage = new DashboardPage(driver, js, vars);
        _DashboardPage.clickContent();
        ManageContentPage _ManageContentPage = new ManageContentPage(driver, js, vars);
        _ManageContentPage.clickTestContent();
        EditContentPage _EditContentPage = new EditContentPage(driver, js, vars);
        _EditContentPage.clickAdvanced("Create your own content");
        _ManageContentPage.clickTestContent();
        _EditContentPage.clickAdvanced_1();
        assertThat(_EditContentPage.set_XPATH_locator(), is("Create your own content"));
        _EditContentPage.click_LINKTEXT_Logout();
    }

    @Test
    public void testChangePassword() {
        driver.get("http://localhost:8080/admin");
        driver.manage().window().setSize(new Dimension(1182, 699));
        LoginPage _LoginPage = new LoginPage(driver, js, vars);
        _LoginPage.doLogin("admin", "password");
        DashboardPage _DashboardPage = new DashboardPage(driver, js, vars);
        _DashboardPage.clickUsers();
        UsersPage _UsersPage = new UsersPage(driver, js, vars);
        _UsersPage.clickUsertest();
        EditUserPage _EditUserPage = new EditUserPage(driver, js, vars);
        _EditUserPage.clickChangePassword("newpassword", "newpassword");
        _UsersPage.getData();
    }

    @Test
    public void testChangePosition() {
        driver.get("http://localhost:8080/admin");
        driver.manage().window().setSize(new Dimension(1166, 699));
        LoginPage _LoginPage = new LoginPage(driver, js, vars);
        _LoginPage.doLogin("admin", "password");
        DashboardPage _DashboardPage = new DashboardPage(driver, js, vars);
        _DashboardPage.clickContent();
        ManageContentPage _ManageContentPage = new ManageContentPage(driver, js, vars);
        _ManageContentPage.clickTestContent();
        EditContentPage _EditContentPage = new EditContentPage(driver, js, vars);
        _EditContentPage.clickAdvanced_4();
        _ManageContentPage.clickTestContent();
        _EditContentPage.clickAdvanced_5();
    }

    @Test
    public void testChangeUrl() {
        driver.get("http://localhost:8080/admin");
        driver.manage().window().setSize(new Dimension(1294, 699));
        LoginPage _LoginPage = new LoginPage(driver, js, vars);
        _LoginPage.doLogin("admin", "password");
        DashboardPage _DashboardPage = new DashboardPage(driver, js, vars);
        _DashboardPage.clickContent();
        ManageContentPage _ManageContentPage = new ManageContentPage(driver, js, vars);
        _ManageContentPage.clickTestContent();
        EditContentPage _EditContentPage = new EditContentPage(driver, js, vars);
        _EditContentPage.clickAdvanced_2("/new-post-url");
        assertEquals(_ManageContentPage.getData_2(), "/new-post-url");
        _ManageContentPage.logout();
    }

    @Test
    public void testDeletePost() {
        driver.get("http://localhost:8080/admin");
        driver.manage().window().setSize(new Dimension(1296, 699));
        LoginPage _LoginPage = new LoginPage(driver, js, vars);
        _LoginPage.doLogin("admin", "password");
        DashboardPage _DashboardPage = new DashboardPage(driver, js, vars);
        _DashboardPage.clickContent();
        ManageContentPage _ManageContentPage = new ManageContentPage(driver, js, vars);
        _ManageContentPage.clickFollowBuldit();
        EditContentPage _EditContentPage = new EditContentPage(driver, js, vars);
        _EditContentPage.clickDelete();
        _ManageContentPage.getData();
    }

    @Test
    public void testSetStickyPost() {
        driver.get("http://localhost:8080/admin");
        driver.manage().window().setSize(new Dimension(1274, 699));
        LoginPage _LoginPage = new LoginPage(driver, js, vars);
        _LoginPage.doLogin("admin", "password");
        DashboardPage _DashboardPage = new DashboardPage(driver, js, vars);
        _DashboardPage.clickContent();
        ManageContentPage _ManageContentPage = new ManageContentPage(driver, js, vars);
        _ManageContentPage.clickSetUpYourNewSite();
        EditContentPage _EditContentPage = new EditContentPage(driver, js, vars);
        _EditContentPage.clickAdvanced_3("Sticky");
        assertThat(_ManageContentPage.getData_3(), is("/set-up-your-new-site"));
        _ManageContentPage.logout();
    }
}
