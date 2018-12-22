package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.util.List;

public class Googlepg extends Page {
    private String url = "https://www.google.com";
    private By searchField = By.cssSelector("input.gLFyf.gsfi");

    WebElement searchFieldControl;

    public void InitPageAttributes()
    {
        searchFieldControl = driver.findElement(searchField);
    }

    public Googlepg(WebDriver d)
    {
        driver = d;
        PageFactory.initElements(d,this);
        wait = new WebDriverWait(d, 10);
    }

    public void Navigate()
    {
        driver.get(url);
        InitPageAttributes();
    }

    public void Search(String text)
    {
        searchFieldControl.sendKeys(text);
        searchFieldControl.sendKeys(Keys.ENTER);
    }

    public boolean FindInResults(String text)
    {
        String tmp1, tmp2;
        List<WebElement> searchResult = driver.findElements(By.xpath("//h3[@class = 'LC20lb']"));
        for (WebElement we : searchResult) {
            tmp1 = we.getText().toLowerCase().replaceAll("[,.!@#$%^&*?]","");
            tmp2 = text.toLowerCase().replaceAll("[,.!@#$%^&*?]","");
            if(tmp1.contains(tmp2) || tmp2.contains(tmp1)) return true;
        }
        return false;
    }
}
