package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Habrpg extends Page {

    private By controlSandoxButton = By.xpath("//a[@href = 'https://habr.com/sandbox/']");

    WebElement regSandoxButton;

    public void InitPageAttributes()
    {
        regSandoxButton = driver.findElement(controlSandoxButton);
    }

    public Habrpg(WebDriver d)
    {
        driver = d;
        PageFactory.initElements(d,this);
        wait = new WebDriverWait(d, 2);
        InitPageAttributes();
    }

    public void GoToSandbox()
    {
        regSandoxButton.click();
    }
}
