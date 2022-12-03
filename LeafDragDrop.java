package week4.day2;

import java.awt.Desktop.Action;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafDragDrop {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions Options = new ChromeOptions();
		Options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(Options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://leafground.com/drag.xhtml;jsessionid=node01qey7o6oowt9dc09s8l9hc4bu437441.node0");
		
	
	
		WebElement dragElement1 = driver.findElement(By.xpath("//span[text()='Drag and Drop']"));
		System.out.println(dragElement1.getLocation());
	    Actions mouseAction = new Actions(driver);
	    mouseAction.dragAndDropBy(dragElement1, 75, 75).perform();
	    WebElement dragElement2 = driver.findElement(By.xpath("(//p)[2]"));
	    WebElement dragElement3 = driver.findElement(By.xpath("//div[@id='form:drop_header']"));
		System.out.println(dragElement2.getLocation());
	    mouseAction.dragAndDrop(dragElement2, dragElement3).perform();
	    
	
	    WebElement col1= driver.findElement(By.xpath("//span[text()='Category']"));
	    WebElement col2= driver.findElement(By.xpath("//span[text()='Quantity']"));
	    mouseAction.dragAndDrop(col2,col1).pause(Duration.ofSeconds(3)).perform();
	    //Point location1 = col1.getLocation();
//	    System.out.println(location1);
//	    Point location2 = col2.getLocation();
//	    System.out.println(location2);
	    
	    
	    WebElement row1= driver.findElement(By.xpath("(//table[@role='grid'])[2]//tr/td[text()='Blue T-Shirt']"));
	    System.out.println(row1.getLocation());
	    WebElement row2= driver.findElement(By.xpath("(//table[@role='grid'])[2]//tr/td[text()='Brown Purse']"));
	    System.out.println(row2.getLocation());
	    mouseAction.dragAndDropBy(row1, 527, 784).perform();

	    
	    driver.findElement(By.xpath("//span[text()='Start']")).click();
	    
	    
	    

	    
	}

}
