package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead 
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

		String title1 = driver.getTitle();
		String verifyViewLead = "View Lead | opentaps CRM";
		if(title1.equals(verifyViewLead))
		{			
			System.out.println("Verify Lead page loaded successfully");
		}

		driver.findElement(By.linkText("Duplicate Lead")).click();

		driver.findElement(By.id("createLeadForm_companyName")).clear();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Microsoft");
		driver.findElement(By.id("createLeadForm_firstName")).clear();
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Sindhuja");
		driver.findElement(By.className("smallSubmit")).click();

		String title2 = driver.getTitle();
		String verifyDuplicateLead = "View Lead | opentaps CRM";
		if(title2.equals(verifyDuplicateLead))
		{			
			System.out.println("After duplicating, View Lead page loaded successfully");
		}
	}
}
