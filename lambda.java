package lambda_test;
import org.assertj.core.api.SoftAssertions;

import java.time.*;
import java.util.ArrayList;
import java.util.Arrays;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.junit.Assert;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	System.setProperty("webdriver.gecko.driver","geckodriver.exe");
	//	WebDriver driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		String baseUrl = "https://www.lambdatest.com/";

        
        driver.get(baseUrl);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\";"));
        System.out.println("i waited");
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/div/span[1]")).click();
        JavascriptExecutor je = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/section[7]/div/div/div/div/a"));
        je.executeScript("arguments[0].scrollIntoView(true);",element);
        String clicklnk = Keys.chord(Keys.CONTROL,Keys.ENTER);
        element.sendKeys(clicklnk);
        System.out.println("DONE");
        ArrayList<String> Titles = new ArrayList<String>();
        Titles.add(driver.getWindowHandle());
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        Titles.add(driver.getWindowHandle());
        
        for(String pd : Titles) {
            System.out.println(pd);
        }
        String currentURL;
        currentURL = driver.getCurrentUrl();
        String ExpectedURL="https://www.lambdatest.com/integrations";
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(currentURL).isEqualTo(ExpectedURL);

        
        
        WebElement element1 = driver.findElement(By.cssSelector("#codeless_row > h2"));
        je.executeScript("arguments[0].scrollIntoView(true);",element1);
       // WebElement Email = driver.findElement(By.cssSelector("input[id=email]"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//*[@id=\"codeless_row\"]/div/div[4]/a")).click();
   //     new WebDriverWait(driver,  Duration.ofSeconds(60)).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div[2]/div[4]/div/div[4]/a"))).click();

       // driver.findElement(By.xpath("//*[@id=\"codeless_row\"]/div/div[4]/a")).click();
        String ExpectedTitle = "TestingWhiz Integration | LambdaTest";
        String title = driver.getTitle();
        softAssertions.assertThat(title).as("Checking Titles").isEqualTo(ExpectedTitle);
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
 
 driver.switchTo().window(Titles.get(1));
 driver.close();
 Titles.remove(1);
 
 System.out.println(driver.getWindowHandles().toArray().length);

 driver.switchTo().window(Titles.get(0));
 driver.navigate().to("https://www.lambdatest.com/blog");  
 driver.findElement(By.xpath("//*[@id=\"menu-item-10121\"]/a")).click();
 String strUrl = driver.getCurrentUrl();
 softAssertions.assertThat(strUrl).as("Checking urls").isEqualTo("https://community.lambdatest.com/");
 System.out.println("Done");
 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 driver.quit();

	}
	}


