package TestCases.PO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CoursePage {
    WebDriver driver;

    public CoursePage(WebDriver driver) {
        this.driver = driver;
    }

    public void addEvent(String title, String day, String month, String year, String location) {
        driver.findElement(By.id("CLCAL")).click();
        driver.findElement(By.linkText("Add an event")).click();
        driver.findElement(By.id("title")).sendKeys(title);

        Select daySelect = new Select(driver.findElement(By.name("fday")));
        daySelect.selectByVisibleText(day);

        Select monthSelect = new Select(driver.findElement(By.name("fmonth")));
        monthSelect.selectByVisibleText(month);

        Select yearSelect = new Select(driver.findElement(By.name("fyear")));
        yearSelect.selectByVisibleText(year);

        driver.findElement(By.name("location")).sendKeys(location);
        driver.findElement(By.name("submitEvent")).click();
    }

    public void addExercise(String title) {
        driver.findElement(By.id("CLQWZ")).click();
        driver.findElement(By.linkText("New exercise")).click();
        driver.findElement(By.id("title")).sendKeys(title);
        driver.findElement(By.cssSelector("input[type='submit']")).click();
    }

    public void makeExerciseVisible() {
        driver.findElement(By.id("CLQWZ")).click();
        driver.findElement(By.xpath("//a[contains(@href,'cmd=exMkVis')]")).click();
    }

    public void enrollUserInCourse(String courseName) {
        driver.findElement(By.linkText("Enrol on a new course")).click();
        driver.findElement(By.id("coursesearchbox_keyword")).sendKeys(courseName);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        driver.findElement(By.className("enrolment")).click();
    }
}
