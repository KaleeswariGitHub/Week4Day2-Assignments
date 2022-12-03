package week4.day2;

import java.time.Duration;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChittorgarhAction {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.chittorgarh.com/");

		driver.findElement(By.xpath("//a[text()='STOCK MARKET ']")).click();
		driver.findElement(By.xpath("//a[text()='NSE Bulk Deals']")).click();
        String titleName =	driver.findElement(By.xpath("//table[@class='table table-bordered table-condensed table-striped']//tr/th[3]/a")).getText();
        System.out.println(titleName + ":");
        
        List<WebElement> securityRows = driver.findElements(By.xpath("//table[@class='table table-bordered table-condensed table-striped']/tbody/tr"));
        int rowSize= securityRows.size();
        System.out.println("row size:" +rowSize);
        
     
        
        Set<String> securitySet = new LinkedHashSet<>();
        for(int i=1;i<=rowSize; i++)
        {
           String securityName = driver.findElement(By.xpath("//table[@class='table table-bordered table-condensed table-striped']//tbody/tr["+i+"]/td[3]")).getText();	
           System.out.println(securityName);
           securitySet.add(securityName);
        }
        
        System.out.println("LIST OF SECURITY NAMES: " +securitySet);
        System.out.println("SIZE OF THE SET IS :"+securitySet.size());
		
	}

}
