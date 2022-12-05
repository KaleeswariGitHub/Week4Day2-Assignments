package week4.day2;

import java.time.Duration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NykaaAction {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.nykaa.com/");
		
		//WebDriverWait wait = new WebDriverWait(driver, 30);
		
		
		WebElement brandsEle =	driver.findElement(By.xpath("//a[text()='brands']"));
        WebElement typeBrand = driver.findElement(By.xpath("//input[@id='brandSearchBox']"));
        
		Actions mouseMove = new Actions(driver);
		mouseMove.moveToElement(brandsEle).click(typeBrand).sendKeys("L'Oreal Paris").perform();
		Thread.sleep(2000);
        WebElement parisElement = driver.findElement(By.xpath("//div/a[contains(text(),'Oreal Paris')]"));
        mouseMove.moveToElement(parisElement).click().perform();
        
        WebElement sortBy = driver.findElement(By.xpath("//span[text()='Sort By : popularity']"));
        mouseMove.moveToElement(sortBy).click().perform();
        
        WebElement checkTopRated = driver.findElement(By.xpath("//span[text()='customer top rated']"));
        mouseMove.moveToElement(checkTopRated).click().perform();
        
        WebElement choseCategory = driver.findElement(By.xpath("//span[text()='Category']"));
        mouseMove.moveToElement(choseCategory).click().perform();
        Thread.sleep(3000);
        System.out.println("Catergory");
        WebElement choseHair = driver.findElement(By.xpath("//span[text()='Hair']"));
        mouseMove.moveToElement(choseHair).click().perform();
        System.out.println("Hair");
        WebElement choseHairCare = driver.findElement(By.xpath("(//span[text()='Hair Care'])[2]"));
        //Thread.sleep(3000);
        mouseMove.moveToElement(choseHairCare).click().perform();
        //Thread.sleep(3000);
        System.out.println("haircare");
        WebElement choseShampoo= driver.findElement(By.xpath("//span[text()='Shampoo']"));
        Thread.sleep(3000);
         WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Shampoo']")));
        Boolean boolean1 = wait.until(ExpectedConditions.textToBePresentInElement(choseShampoo, "Shampoo"));
        System.out.println(boolean1);
         driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
        
        //mouseMove.moveToElement(choseShampoo).click().perform();
        //choseShampoo.click();
        System.out.println("shampoo");
        String shampString= choseShampoo.getText();
        Thread.sleep(3000);
        WebElement choseConcern = driver.findElement(By.xpath("//span[text()='Concern']"));
        mouseMove.moveToElement(choseConcern).click().perform();
        System.out.println("Concern");
          Thread.sleep(3000);
        WebElement colorProctection = driver.findElement(By.xpath("//span[text()='Color Protection']"));
        mouseMove.moveToElement(colorProctection).click().perform();
        Thread.sleep(3000);
        System.out.println("Colour pro");
        
        List<WebElement> filterApplied = driver.findElements(By.xpath("//span[@class='filter-value']"));
        
        List<WebElement> filterValues = new ArrayList<>(filterApplied);
        String colorProString = colorProctection.getText();
        System.out.println(colorProString);
        Thread.sleep(3000);
        //String shampString= choseShampoo.getText(); 
        Set<String> filterSet = new HashSet<>();
        for (WebElement allFilterValues : filterValues) 
        {
		   String filter = allFilterValues.getText();
		   filterSet.add(filter);
		   System.out.println(filter);
        }
        
        System.out.println(filterSet);
       
//        if(filterSet.contains(shampString))
//        {
            if(filterSet.contains(colorProString))
            		
                         System.out.println("Filter is applied for all selection");
            		
      //  }
        else
        System.out.println("Filter is not applied for all selection");
        
        
        WebElement clickLoreal = driver.findElement(By.xpath("//div[contains(text(),'Oreal Paris Colour Protect Shampoo')]"));
        mouseMove.moveToElement(clickLoreal).click().perform();
        
               
        Set<String>  windowsList = driver.getWindowHandles();
		List<String> listOfWindows = new ArrayList<String>(windowsList);
		System.out.println(listOfWindows);
		driver.switchTo().window(listOfWindows.get(1));
		System.out.println("Child Title: "+driver.getTitle());
		
		//Alert messAlert= new Alert
        
		WebElement sizeML = driver.findElement(By.xpath("//select[@title='SIZE']"));
		
		Select sizeSelect = new Select(sizeML);
		sizeSelect.selectByVisibleText("175ml");
		
    	String rate =	driver.findElement(By.xpath("//span[text()='MRP:']/following::span")).getText();
        System.out.println("The rate of the selected shampoo: "+rate);
		
        driver.findElement(By.xpath("//button/span[text()='Add to Bag']")).click();
        driver.findElement(By.xpath("//span[@class='cart-count']")).click();
        
        WebElement iframElement = driver.findElement(By.xpath("//iframe[1]"));
        driver.switchTo().frame(iframElement);
        String grandTotal= driver.findElement(By.xpath("//div[@data-test-id='footer']//span")).getText();
        System.out.println(grandTotal);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Proceed']")).click();
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//button[text()='Continue as guest']")).click();
        
        Set<String>  windowsList1 = driver.getWindowHandles();
		List<String> listOfWindows1 = new ArrayList<String>(windowsList1);
		System.out.println(listOfWindows1);
		driver.switchTo().window(listOfWindows1.get(1));
		System.out.println("Second Child Title: "+driver.getTitle());

		WebElement framElement = driver.findElement(By.xpath("//iframe"));
        driver.switchTo().frame(framElement);
       	
		//driver.findElement(By.xpath("//img[@src='https://adn-static1.nykaa.com/media/wysiwyg/Payments/desktop-icons/tick-icon.svg']")).click();
		driver.switchTo().window(listOfWindows1.get(1));
        String totValue = driver.findElement(By.xpath("//p[contains(text(),'You are saving')]/parent::div/following-sibling::p")).getText();
        System.out.println("The total value is "+ totValue);
	}

}
