package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sandbox2ndpg extends Page{

    private By controlfirstPostTitle = By.xpath("//h2[@class = 'post__title']//child::a");

    WebElement firstPostTitle;
    String postTitle;

    public void InitPageAttributes()
    {
        firstPostTitle = driver.findElement(controlfirstPostTitle);
        postTitle = firstPostTitle.getText();
    }

    public Sandbox2ndpg(WebDriver d)
    {
        driver = d;
        PageFactory.initElements(d,this);
        wait = new WebDriverWait(d, 2);
        InitPageAttributes();
    }
    public String GetTitle()
    {
        return postTitle;
    }
}
