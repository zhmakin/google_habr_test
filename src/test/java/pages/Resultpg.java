package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Resultpg extends Page {

    String text = "habrahabr.ru";
    private By searchField = By.xpath("//div[@class = 'rc']//child::a");

    List<WebElement> resultLinksControl;

    public void InitPageAttributes()
    {
        resultLinksControl = driver.findElements(searchField);
    }

    public Resultpg(WebDriver d)
    {
        driver = d;
        PageFactory.initElements(d,this);
        wait = new WebDriverWait(d, 10);
        InitPageAttributes();
    }

    public void GoToFirst(String text)
    {
        for(int i = 0; i< resultLinksControl.size(); i++)
        if(resultLinksControl.get(i).getAttribute("href").contains(text)) {
            Navigate(resultLinksControl.get(i).getAttribute("href"));
            break;
        }
    }

    public void Navigate(String url)
    {
        driver.get(url);
    }
}
