package TestNG;

import org.testng.annotations.Test;

import com.google.inject.Key;

import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.testng.annotations.AfterMethod;

public class NYTimes {
  WebDriver driver = null;
  
  @BeforeMethod
  public void beforeMethod() {
	  
	    System.setProperty("webdriver.gecko.driver", "A:\\New folder\\Selenium\\WebDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.navigate().to("http://www.nytimes.com/");
		driver.manage().window().maximize();
  }
  
  @Test
  public void f() throws InterruptedException {

	  driver.findElement(By.cssSelector(".button.search-button")).click();
	  driver.findElement(By.cssSelector("#search-input")).sendKeys("Olympic", Keys.ENTER);
	 

	  System.out.println(driver.getTitle());      // .story.element2>h3>a
	  List<WebElement> listOfLinks = driver.findElements(By.cssSelector("#searchResults .searchResultsList.flush li"));
	  for (WebElement element: listOfLinks){
		  element.click();
		  Thread.sleep(3000);
		  driver.navigate().back();
		  listOfLinks = driver.findElements(By.cssSelector("#searchResults .searchResultsList.flush li"));

	  }
      Thread.sleep(3000);
  }
  
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
