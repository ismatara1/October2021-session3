package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {

	WebDriver driver;

	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("http://www.techfios.com/billing/?ng=login/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void loginTest() {
		// ELEMENT LIST
		// type name =value
		WebElement USERNAME_ELEMENT = driver.findElement(By.xpath("//input[@id= 'username']"));
		WebElement PASSWORD_ELEMENT = driver.findElement(By.xpath("//*[@id= \"password\"]"));
		WebElement SIGNIN_BUTTON_ELEMENT = driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/button"));
		// WebElement
		// DASHBOARD_HEADER_ELEMENT=driver.findElement(By.xpath("//h2[contains(Text(),
		// 'Dashboard')]"));

		By USERNAME_LOCATOR = By.xpath("//input[@id= 'username']");
		By PASSWORD_LOCATOR = By.xpath("//*[@id=\\\"password\\\"]");
		By SIGNIN_BUTTON_LOCATOR = By.xpath("/html/body/div/div/div/form/div[3]/button");
		By DASHBOARD_HEADER_LOCATOR = By.xpath("//h2[contains(Text(), 'Dashboard')]");

		USERNAME_ELEMENT.clear();
		USERNAME_ELEMENT.sendKeys("demo@techfios.com");
		// driver.findElement(USERNAME_LOCATOR).sendKeys("demo@techfios.com");
		PASSWORD_ELEMENT.sendKeys("abc123");
		SIGNIN_BUTTON_ELEMENT.click();
		
		boolean pageTitleDisplayStatus;
		try {
			WebElement DASHBOARD_HEADER_ELEMENT = driver.findElement(By.xpath("\"//h2[contains(Text(), 'Dashboard')]"));
			 pageTitleDisplayStatus = true;
		} catch (Exception e) {
			pageTitleDisplayStatus = false;
			e.printStackTrace();
		}
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(DASHBOARD_HEADER_LOCATOR));
		Assert.assertTrue("wrong page||", pageTitleDisplayStatus);

	}

}
