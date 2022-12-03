package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TagsTableLibrary {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://html.com/tags/table/");
		
			
		
		List<WebElement> libraryElements = driver.findElements(By.xpath("(//table)[1]//tbody/tr/td[1]"));
		List<WebElement> libraryDetails = driver.findElements(By.xpath("(//table)[1]//tbody/tr"));
		
		System.out.println("List of Libraries are:");
		for (WebElement libraryList : libraryElements)
		{
		  String libraryName  =	libraryList.getText();
		  System.out.println(libraryName);
		} 
		System.out.println("Details of the listed libraries are:");
		 
		 for (WebElement library : libraryDetails)
		  {
				String details = library.getText();
				System.out.println(details);
		  }
	
	}
	
}
