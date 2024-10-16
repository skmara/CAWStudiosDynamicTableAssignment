package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SamplePage {
    public void launchUrl(String url){
        WebDriver driver=new EdgeDriver();
        driver.get(url);
        //driver.findElement(By.xpath("//textarea[@title='Search']")).sendKeys("SreeDurgaGod");

    }
}
