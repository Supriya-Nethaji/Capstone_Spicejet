import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Date {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		//depart date 
		driver.findElement(By.xpath("(//div[@class='css-76zvg2 css-bfa6kz r-1862ga2 r-1gkfh8e'])[1]")).click();
		
		//september 5
		driver.findElement(By.xpath("(//div[text()='5'])[2]")).click();
		

	}

}
