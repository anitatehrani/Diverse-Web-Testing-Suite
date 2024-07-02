// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class BluditTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
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
  public void addAsDraftTest() {
    driver.get("http://localhost:8080/admin");
    driver.manage().window().setSize(new Dimension(1314, 699));
    System.out.println("{ASSESSOR}:LoginPage:doLogin");
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).sendKeys("password");
    driver.findElement(By.cssSelector(".uk-button")).click();
    System.out.println("{ASSESSOR}:DashboardPage:clickNewContent");
    driver.findElement(By.cssSelector(".uk-row-first > .uk-panel:nth-child(1) a")).click();
    driver.findElement(By.id("jstitle")).sendKeys("Draft Content");
    System.out.println("{ASSESSOR}:DashboardPage:clickSaveAsDraft");
    driver.findElement(By.id("jsSaveDraft")).click();
    System.out.println("{ASSESSOR}:ManageContentPage:getData");
    System.out.println("{ASSESSOR}:ManageContentPage:logout");
    driver.findElement(By.linkText("Log out")).click();
  }
  @Test
  public void addContestTest() {
    driver.get("http://localhost:8080/admin");
    driver.manage().window().setSize(new Dimension(1103, 696));
    System.out.println("{ASSESSOR}:LoginPage:doLogin");
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).sendKeys("password");
    driver.findElement(By.cssSelector(".uk-button")).click();
    System.out.println("{ASSESSOR}:DashboardPage:clickNewContent");
    driver.findElement(By.cssSelector(".uk-row-first > .uk-panel:nth-child(1) a")).click();
    System.out.println("{ASSESSOR}:AddContentPage:createContent");
    driver.findElement(By.id("jstitle")).sendKeys("Test Content");
    driver.findElement(By.cssSelector(".uk-button:nth-child(1)")).click();
    System.out.println("{ASSESSOR}:ManageContentPage:getData");
    assertThat(driver.findElement(By.linkText("Test Content")).getText(), is("Test Content"));
    System.out.println("{ASSESSOR}:ManageContentPage:logout");
    driver.findElement(By.linkText("Log out")).click();
  }
  @Test
  public void addUserTest() {
    driver.get("http://localhost:8080/admin");
    driver.manage().window().setSize(new Dimension(1220, 699));
    System.out.println("{ASSESSOR}:LoginPage:doLogin");
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).sendKeys("password");
    driver.findElement(By.cssSelector(".uk-button")).click();
    System.out.println("{ASSESSOR}:DashboardPage:clickUsers");
    driver.findElement(By.linkText("Users")).click();
    System.out.println("{ASSESSOR}:UsersPage:clickAddANewUser");
    driver.findElement(By.linkText("Add a new user")).click();
    driver.findElement(By.id("jsnew_username")).sendKeys("usertest");
    driver.findElement(By.id("jsnew_password")).sendKeys("usertest123");
    driver.findElement(By.id("jsconfirm_password")).sendKeys("usertest123");
    {
      WebElement dropdown = driver.findElement(By.id("jsrole"));
      dropdown.findElement(By.xpath("//option[. = 'Administrator']")).click();
    }
    driver.findElement(By.cssSelector("option:nth-child(2)")).click();
    driver.findElement(By.id("jsemail")).sendKeys("user@test.com");
    System.out.println("{ASSESSOR}:NewUserPage:clickSave");
    driver.findElement(By.cssSelector(".uk-button-primary")).click();
    System.out.println("{ASSESSOR}:UsersPage:getData");
    System.out.println("{ASSESSOR}:UsersPage:logout");
    driver.findElement(By.linkText("Log out")).click();
  }
  @Test
  public void changeParentTest() {
    driver.get("http://localhost:8080/admin");
    driver.manage().window().setSize(new Dimension(1219, 699));
    System.out.println("{ASSESSOR}:LoginPage:doLogin");
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).sendKeys("password");
    driver.findElement(By.cssSelector(".uk-button")).click();
    System.out.println("{ASSESSOR}:DashboardPage:clickContent");
    driver.findElement(By.linkText("Content")).click();
    System.out.println("{ASSESSOR}:ManageContentPage:clickTestContent");
    driver.findElement(By.linkText("Test Content")).click();
    System.out.println("{ASSESSOR}:EditContentPage:clickAdvanced");
    driver.findElement(By.cssSelector("li:nth-child(7) > .sidebar-button")).click();
    System.out.println("{ASSESSOR}:EditContentPage:changeParent");
    {
      WebElement dropdown = driver.findElement(By.id("jsparent"));
      dropdown.findElement(By.xpath("//option[. = 'Create your own content']")).click();
    }
    System.out.println("{ASSESSOR}:EditContentPage:clickSave");
    driver.findElement(By.cssSelector(".uk-button:nth-child(1)")).click();
    System.out.println("{ASSESSOR}:EditContentPage:clickContent");
    driver.findElement(By.linkText("Content")).click();
    System.out.println("{ASSESSOR}:ManageContentPage:clickTestContent");
    driver.findElement(By.linkText("Test Content")).click();
    System.out.println("{ASSESSOR}:EditContentPage:clickAdvanced");
    driver.findElement(By.cssSelector("li:nth-child(7) > .sidebar-button")).click();
    System.out.println("{ASSESSOR}:EditContentPage:getData");
    {
      WebElement element = driver.findElement(By.id("jsparent"));
      String value = element.getAttribute("value");
      String locator = String.format("option[@value='%s']", value);
      String selectedText = element.findElement(By.xpath(locator)).getText();
      assertThat(selectedText, is("Create your own content"));
    }
    driver.findElement(By.linkText("Log out")).click();
  }
  @Test
  public void changePasswordTest() {
    driver.get("http://localhost:8080/admin");
    driver.manage().window().setSize(new Dimension(1182, 699));
    System.out.println("{ASSESSOR}:LoginPage:doLogin");
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).sendKeys("password");
    driver.findElement(By.cssSelector(".uk-button")).click();
    System.out.println("{ASSESSOR}:DashboardPage:clickUsers");
    driver.findElement(By.linkText("Users")).click();
    System.out.println("{ASSESSOR}:UsersPage:clickUsertest");
    driver.findElement(By.linkText("usertest")).click();
    System.out.println("{ASSESSOR}:EditUserPage:clickChangePassword");
    driver.findElement(By.linkText("Change password")).click();
    driver.findElement(By.id("jsnew_password")).sendKeys("newpassword");
    driver.findElement(By.id("jsconfirm_password")).sendKeys("newpassword");
    System.out.println("{ASSESSOR}:EditUserPage:clickSave");
    driver.findElement(By.cssSelector(".uk-button-primary")).click();
    System.out.println("{ASSESSOR}:UsersPage:getData");
    System.out.println("{ASSESSOR}:UsersPage:logout");
    driver.findElement(By.linkText("Log out")).click();
    driver.close();
  }
  @Test
  public void changeUrlTest() {
    driver.get("http://localhost:8080/admin");
    driver.manage().window().setSize(new Dimension(1294, 699));
    System.out.println("{ASSESSOR}:LoginPage:doLogin");
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).sendKeys("password");
    System.out.println("{ASSESSOR}:LoginPage:doLogin");
    driver.findElement(By.cssSelector(".uk-button")).click();
    System.out.println("{ASSESSOR}:DashboardPage:clickContent");
    driver.findElement(By.linkText("Content")).click();
    System.out.println("{ASSESSOR}:ManageContentPage:clickTestContent");
    driver.findElement(By.linkText("Test Content")).click();
    System.out.println("{ASSESSOR}:EditContentPage:clickAdvanced");
    driver.findElement(By.cssSelector("li:nth-child(7) > .sidebar-button")).click();
    System.out.println("{ASSESSOR}:EditContentPage:clearFriendlyUrl");
    System.out.println("{ASSESSOR}:EditContentPage:enterFriendlyUrl");
    driver.findElement(By.id("jsslug")).sendKeys("new-post-url");
    System.out.println("{ASSESSOR}:EditContentPage:clickSave");
    driver.findElement(By.cssSelector(".uk-button:nth-child(1)")).click();
    System.out.println("{ASSESSOR}:EditContentPage:clickContent");
    driver.findElement(By.linkText("Content")).click();
    System.out.println("{ASSESSOR}:ManageContentPage:getData");
    assertThat(driver.findElement(By.linkText("/new-post-url")).getText(), is("/new-post-url"));
    System.out.println("{ASSESSOR}:ManageContentPage:logout");
    driver.findElement(By.linkText("Log out")).click();
  }
  @Test
  public void deletePostTest() {
    driver.get("http://localhost:8080/admin");
    driver.manage().window().setSize(new Dimension(1296, 699));
    System.out.println("{ASSESSOR}:LoginPage:doLogin");
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).sendKeys("password");
    driver.findElement(By.cssSelector(".uk-button")).click();
    System.out.println("{ASSESSOR}:DashboardPage:clickContent");
    driver.findElement(By.linkText("Content")).click();
    System.out.println("{ASSESSOR}:ManageContentPage:clickFollowBuldit");
    driver.findElement(By.linkText("Follow Bludit")).click();
    System.out.println("{ASSESSOR}:EditContentPage:clickDelete");
    driver.switchTo().alert().accept();
    driver.findElement(By.id("jsdelete")).click();
    System.out.println("{ASSESSOR}:EditContentPage:clickOk");
    System.out.println("{ASSESSOR}:ManageContentPage:getData");
    System.out.println("{ASSESSOR}:ManageContentPage:logout");
    driver.findElement(By.linkText("Log out")).click();
  }
  @Test
  public void setStickyPostTest() {
    driver.get("http://localhost:8080/admin");
    driver.manage().window().setSize(new Dimension(1274, 699));
    System.out.println("{ASSESSOR}:LoginPage:doLogin");
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).sendKeys("password");
    driver.findElement(By.cssSelector(".uk-button")).click();
    System.out.println("{ASSESSOR}:DashboardPage:clickContent");
    driver.findElement(By.linkText("Content")).click();
    System.out.println("{ASSESSOR}:ManageContentPage:clickSetUpYourNewSite");
    driver.findElement(By.linkText("Set up your new site")).click();
    System.out.println("{ASSESSOR}:EditContentPage:clickAdvanced");
    driver.findElement(By.cssSelector("li:nth-child(7) > .sidebar-button")).click();
    System.out.println("{ASSESSOR}:EditContentPage:changeStatus");
    {
      WebElement dropdown = driver.findElement(By.id("jsstatus"));
      dropdown.findElement(By.xpath("//option[. = 'Sticky']")).click();
    }
    driver.findElement(By.cssSelector("#jsstatus > option:nth-child(3)")).click();
    System.out.println("{ASSESSOR}:EditContentPage:clickSave");
    driver.findElement(By.cssSelector(".uk-button:nth-child(1)")).click();
    System.out.println("{ASSESSOR}:EditContentPage:clickContent");
    driver.findElement(By.linkText("Content")).click();
    System.out.println("{ASSESSOR}:ManageContentPage:getData");
    assertThat(driver.findElement(By.linkText("/set-up-your-new-site")).getText(), is("/set-up-your-new-site"));
    System.out.println("{ASSESSOR}:ManageContentPage:logout");
    driver.findElement(By.linkText("Log out")).click();
  }
  @Test
  public void changePositionTest() {
    driver.get("http://localhost:8080/admin");
    driver.manage().window().setSize(new Dimension(1166, 699));
    System.out.println("{ASSESSOR}:LoginPage:doLogin");
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).sendKeys("password");
    driver.findElement(By.cssSelector(".uk-button")).click();
    System.out.println("{ASSESSOR}:DashboardPage:clickContent");
    driver.findElement(By.linkText("Content")).click();
    System.out.println("{ASSESSOR}:ManageContentPage:clickTestContent");
    driver.findElement(By.linkText("Test Content")).click();
    System.out.println("{ASSESSOR}:EditContentPage:clickAdvanced");
    driver.findElement(By.cssSelector("li:nth-child(7) > .sidebar-button")).click();
    System.out.println("{ASSESSOR}:EditContentPage:changePosition");
    System.out.println("{ASSESSOR}:EditContentPage:clickSave");
    driver.findElement(By.cssSelector(".uk-button:nth-child(1)")).click();
    System.out.println("{ASSESSOR}:EditContentPage:clickContent");
    driver.findElement(By.linkText("Content")).click();
    System.out.println("{ASSESSOR}:ManageContentPage:clickTestContent");
    driver.findElement(By.linkText("Test Content")).click();
    System.out.println("{ASSESSOR}:EditContentPage:clickAdvanced");
    driver.findElement(By.cssSelector("li:nth-child(7) > .sidebar-button")).click();
    System.out.println("{ASSESSOR}:EditContentPage:getData");
    System.out.println("{ASSESSOR}:EditContentPage:logout");
    driver.findElement(By.linkText("Log out")).click();
  }
  @Test
  public void addSocialsTest() {
    driver.get("http://localhost:8080/admin");
    driver.manage().window().setSize(new Dimension(1222, 699));
    System.out.println("{ASSESSOR}:LoginPage:doLogin");
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).sendKeys("password");
    driver.findElement(By.cssSelector(".uk-button")).click();
    System.out.println("{ASSESSOR}:DashboardPage:clickUsers");
    driver.findElement(By.linkText("Users")).click();
    System.out.println("{ASSESSOR}:UsersPage:clickAdmin");
    driver.findElement(By.linkText("admin")).click();
    System.out.println("{ASSESSOR}:EditUserPage:changeFacebook");
    driver.findElement(By.id("jsfacebook")).sendKeys("https://www.facebook.com/some_fake_user_name_52432562135863");
    System.out.println("{ASSESSOR}:EditUserPage:changeInstagram");
    driver.findElement(By.id("jsinstagram")).sendKeys("https://instagram.com/some_fake_user_name_52432562135863");
    System.out.println("{ASSESSOR}:EditUserPage:clickSave");
    driver.findElement(By.cssSelector(".uk-button-primary")).click();
    System.out.println("{ASSESSOR}:EditUserPage:clickUsers");
    driver.findElement(By.linkText("Users")).click();
    System.out.println("{ASSESSOR}:UsersPage:clickAdmin");
    driver.findElement(By.cssSelector("tr:nth-child(1) > td:nth-child(1)")).click();
    driver.findElement(By.linkText("admin")).click();
    System.out.println("{ASSESSOR}:EditUserPage:getData");
    System.out.println("{ASSESSOR}:EditUserPage:logout");
    driver.findElement(By.linkText("Log out")).click();
  }
}