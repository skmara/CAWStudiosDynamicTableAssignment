package Pages;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

public class SamplePage {
    WebDriver driver = null;
    public List<Map<String, Object>> data = null;
    private List<WebElement> values = null;

    public void launchUrl(String url) {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    public void highLightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.background = 'yellow'", element);
    }

    public void clickTableDataButton() {
        WebElement dataTableButton = driver.findElement(By.xpath("//summary[text()='Table Data']"));
        highLightElement(dataTableButton);
        dataTableButton.click();
    }

    public String getJsonAsString() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        data = objectMapper.readValue(new File("src/main/java/TestData/data.json"), List.class);
        return objectMapper.writeValueAsString(data);

    }

    public void enterJsonValue() throws IOException {
        WebElement inputTextBox = driver.findElement(By.xpath("//textarea[@id='jsondata']"));
        inputTextBox.clear();
        inputTextBox.sendKeys(getJsonAsString());
        highLightElement(inputTextBox);
    }

    public void clickRefreshTable() {
        WebElement refreshButton = driver.findElement(By.xpath("//button[text()='Refresh Table']"));
        refreshButton.click();
    }

    public String getValue(String value, int i) {
        switch (value) {
            case "name":
                values = driver.findElements(By.xpath("//table[@id='dynamictable']/tr/td[1]"));
                break;
            case "age":
                values = driver.findElements(By.xpath("//table[@id='dynamictable']/tr/td[2]"));
                break;
            case "gender":
                values = driver.findElements(By.xpath("//table[@id='dynamictable']/tr/td[3]"));
                break;
        }
        highLightElement(values.get(i));
//        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.visibilityOf(values.get(i)));
        return values.get(i).getText();
    }

}



