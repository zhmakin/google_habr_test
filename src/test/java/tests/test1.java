package tests;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.*;

import java.util.concurrent.TimeUnit;

public class test1 {
    private static WebDriver driver;

    @BeforeClass
    public static void setup()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
    }

    @Test
    public void testAction()
    {
        Googlepg ngp = new Googlepg(driver);
        ngp.Navigate();
        ngp.Search("habrahabr");

        Resultpg spg = new Resultpg(driver);
        spg.GoToFirst("habrahabr.ru");

        Habrpg hpg = new Habrpg(driver);
        hpg.GoToSandbox();

        Sandboxpg sbpg = new Sandboxpg(driver);
        sbpg.GoToSandboxPage2();

        Sandbox2ndpg sb2pg = new Sandbox2ndpg(driver);

        ngp.Navigate();
        ngp.Search(sb2pg.GetTitle());
        Assert.assertTrue(ngp.FindInResults(sb2pg.GetTitle()));
    }

    @AfterClass
    public static void finish()
    {
        driver.close();
    }
}
