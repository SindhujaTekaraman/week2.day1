package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead 
{
	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();

		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		driver.findElement(By.className("decorativeSubmit")).click();

		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();

		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestingCo");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Shiva");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Ram");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Shiv");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Testing");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Sample test");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("sindhuja.triad@gmail.com");

		WebElement dropdown1=driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select select = new Select(dropdown1);
		select.selectByVisibleText("New York");

		driver.findElement(By.className("smallSubmit")).click();

		String title = driver.getTitle();
		String verifyViewLead = "View Lead | opentaps CRM";
		if(title.equals(verifyViewLead))
		{			
			System.out.println("Verify Lead page loaded successfully");
		}
	}
}
