package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sandboxpg extends Page {

    private By controlSandoxPage_2Button = By.xpath("//a[@href = '/sandbox/page2/']");

    WebElement regSandoxPage_2Button;

    public void InitPageAttributes()
    {
        regSandoxPage_2Button = driver.findElement(controlSandoxPage_2Button);
    }

    public Sandboxpg(WebDriver d)
    {
        driver = d;
        PageFactory.initElements(d,this);
        wait = new WebDriverWait(d, 2);
        InitPageAttributes();
    }

    public void GoToSandboxPage2()
    {
        regSandoxPage_2Button.click();
    }
}
