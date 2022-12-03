package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TagsTable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://html.com/tags/table/");
	
		List<WebElement> tables = driver.findElements(By.xpath("//table"));
		System.out.println("Total number of tables in this page: "+ tables.size());

		
		for(int i=1;i<=tables.size();i++)
		{
		
		List<WebElement> rows = driver.findElements(By.xpath("(//table)["+i+"]//tbody//tr"));
		System.out.println("Number of rows in "+i+" Table: "+rows.size());
		
		}
		
		for(int j=1;j<=tables.size();j++)
		{
		
		List<WebElement> columns = driver.findElements(By.xpath("(//table)["+j+"]//tr/th"));
		System.out.println("Number of columns in "+j+" Table: "+columns.size());
		
		}
		
		
				

	}

}
