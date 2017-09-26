package iframedemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class demoiframe {
	@Test(groups="login")
	public void testframe() {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("file:///C:/09.03.17/Jenkins/fram.html");
		driver.switchTo().frame(2);
		driver.findElement(By.xpath("//a[@name='prod']")).click();
		driver.findElement(By.xpath("//tr[td[text()='Ruby']]/td/input[@type='checkbox']")).click();
		driver.findElement(By.id("btn")).click();
		WebDriverWait wait= new WebDriverWait(driver, 7);
		WebElement elet=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='WebDriver']")));
		//WebElement elem= driver.findElement(By.xpath("//p[text()='WebDriver']"));
		boolean status= elet.isDisplayed();
		if(status){
			System.out.println("Got the element");
		}
		else{
			System.out.println("Nooooooooo");
		}
		driver.switchTo().defaultContent();
		WebElement ele=driver.findElement(By.xpath("//iframe[@title='lim']"));
		driver.switchTo().frame(ele);
		driver.findElement(By.xpath("//a[@id='up']")).click();
		System.out.println(driver.getTitle());
		driver.switchTo().defaultContent();
		int nofram= driver.findElements(By.tagName("iframe")).size();
		System.out.println(nofram);
		WebElement elem= driver.findElement(By.xpath("//body[@id='bdy']/a"));
		Actions act= new Actions(driver);
		act.moveToElement(elem).click().build().perform();
		String alertMessage = driver.switchTo().alert().getText();
		System.out.println(alertMessage);
		driver.switchTo().alert().dismiss();
		//driver.navigate().back();
		driver.findElement(By.xpath("//input[@name='uname']")).sendKeys("ABCDEF");
		driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("124578", Keys.ENTER);
		driver.navigate().back();
		Select drpdn= new Select(driver.findElement(By.name("airline")));
		drpdn.selectByVisibleText("ille");
		driver.findElement(By.xpath("//input[@id='btt']")).submit();
		System.out.println(driver.getTitle());
		driver.navigate().back();
		driver.navigate().forward();
		driver.quit();
	}

}
