package steps;

import manager.PageFactoryManager;
import org.jbehave.core.annotations.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class BeforeAfterSteps {
    WebDriver driver;
    PageFactoryManager pageFactoryManager;

    @Given("a step that is executed before each scenario")
    public void setUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @Given("a step that is executed after each scenario")
    public void tearDown() {
        driver.close();
    }
}
