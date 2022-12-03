package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.internal.IConfigEavesdropper;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions sdOptions = new ChromeOptions();
		sdOptions.addArguments("--disable-notifications");
		ChromeDriver sdDriver = new ChromeDriver(sdOptions);
		sdDriver.manage().window().maximize();
		sdDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		sdDriver.get("https://snapdeal.com/");
		WebElement menEle =	sdDriver.findElement(By.xpath("//span[@class='catText']"));
		
		Actions mouseMove = new Actions(sdDriver);
		
		mouseMove.moveToElement(menEle).pause(Duration.ofSeconds(2)).perform();
	    WebElement shoesEle= sdDriver.findElement(By.xpath("//span[text()='Sports Shoes']"));
		mouseMove.moveToElement(shoesEle).click().perform();
		
        WebElement countShoes = sdDriver.findElement(By.xpath("//div[@class='child-cat-count ']"));
        String countShoe= countShoes.getText();
        int numShoes = Integer.parseInt(countShoe);
        System.out.println("number of sport shoes: "+numShoes);
        
        sdDriver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
        WebElement sortElement = sdDriver.findElement(By.xpath("//div[contains(text(),'Popularity')]"));
        mouseMove.moveToElement(sortElement).click().perform();
        
        WebElement sort = sdDriver.findElement(By.xpath("//li[@data-sorttype='plth']"));
        mouseMove.moveToElement(sort).click().pause(Duration.ofSeconds(5)).perform();
        System.out.println("Shoes listed");
         
         
        WebElement fromVal = sdDriver.findElement(By.xpath("//input[@name='fromVal']"));
        fromVal.clear();
        fromVal.sendKeys("400");
        WebElement toVal = sdDriver.findElement(By.xpath("//input[@name='toVal']"));
        toVal.clear();
        toVal.sendKeys("700");
        sdDriver.findElement(By.xpath("//div[contains(text(),'GO')]")).click();
        Thread.sleep(3000);
        WebElement colourElement = sdDriver.findElement(By.xpath("//label[@for='Color_s-Navy']"));
    	mouseMove.moveToElement(colourElement).click().perform();
    	
    
    	Thread.sleep(3000);
        WebElement firstPic = sdDriver.findElement(By.xpath("//p[text()='TUFF 5005 Navy Training Shoes']"));
        WebElement viewQuick= sdDriver.findElement(By.xpath("//div[contains(text(),'Quick View')]"));
        Thread.sleep(3000);
        mouseMove.moveToElement(firstPic).pause(Duration.ofSeconds(5)).perform();
        mouseMove.moveToElement(viewQuick).click().perform();
        
        
        Set<String> winHandle= sdDriver.getWindowHandles();
        List<String> listOfWindows = new ArrayList<String>(winHandle);
		System.out.println(listOfWindows);
        

	    WebElement priceEle =sdDriver.findElement(By.xpath("//span[@class='payBlkBig']"));
	    String price= priceEle.getText();
    	System.out.println("Price is: "+price);
	    WebElement discount = sdDriver.findElement(By.xpath("//span[@class='percent-desc ']"));
	    String dis= discount.getText();
	    System.out.println("Discount is: "+dis);
	    
   	
    	
        }

}
