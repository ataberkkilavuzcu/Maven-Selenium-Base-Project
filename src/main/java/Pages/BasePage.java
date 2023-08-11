package Pages;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ataberkkilavuzcu.Driver.DriverChrome;

public class BasePage {
    
    ChromeDriver driver = DriverChrome.getDriver(); 

    public BasePage(){
        
    }
    
    public void launch(String url){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get(url);
    }

    public void click(By by){   
        driver.findElement(by).click();
    }
    
    public void sendKeys(By by, String text){
        driver.findElement(by).sendKeys(text);
    }

    public String getText(By by){
        return driver.findElement(by).getText();
    }

    public void waitForElement(By by, int time){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));        
    }

    public void switchToTab(int tabIndex){
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabIndex));
    }
}
