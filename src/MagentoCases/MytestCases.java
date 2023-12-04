package MagentoCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MytestCases extends Parameter {
	
	Parameter Magento=new Parameter();
	SoftAssert softassert=new SoftAssert();
	
	
	@BeforeTest
	public void MyBeforeTest() {
		driver.get(Website);
	}
	
	
	
@Test(priority=1)
public void SignUp() throws InterruptedException {
	driver.get(signUp);
	WebElement FirstName=driver.findElement(By.id("firstname"));
	WebElement LastName=driver.findElement(By.id("lastname"));
	WebElement Email=driver.findElement(By.id("email_address"));
	WebElement Password=driver.findElement(By.id("password"));
	WebElement Confirm=driver.findElement(By.id("password-confirmation"));
	WebElement Create=driver.findElement(By.className("submit"));
	
	FirstName.sendKeys(Magento.firstname);
	LastName.sendKeys(Magento.lastname);
	Email.sendKeys(Magento.mail);
	Password.sendKeys(Magento.password);
	Confirm.sendKeys(Magento.password);
	Create.click();
	
	Thread.sleep(2000);

	String  WelcomeMsg = driver.findElement(By.xpath("//div[@class='panel header']")).getText();
    softassert.assertEquals(WelcomeMsg.contains ("Welcome"), true,"validation the signup process");
    softassert.assertAll();	
}

@Test(priority=2 )
public void LogOut() throws InterruptedException  {
	
	driver.get(logout);
	Thread.sleep(7000);
	
	softassert.assertEquals(driver.getCurrentUrl(), Website);
	softassert.assertAll();
}

@Test(priority=3 )
public void LoginTest() {
	driver.get(login);
	WebElement Email=driver.findElement(By.id("email"));
	WebElement Password=driver.findElement(By.id("pass"));
	WebElement LogInButton=driver.findElement(By.id("send2"));
	
	Email.sendKeys(Magento.mail);
	Password.sendKeys(Magento.password);
	LogInButton.click();

	String account=driver.findElement(By.className("base")).getText();
	softassert.assertEquals(account.contains("My Account"), true);
	softassert.assertAll();
	
	String info=driver.findElement(By.className("block-title")).getText();
	softassert.assertEquals(info.contains(" Account Information"), false, info);
	softassert.assertAll();

	
}


@AfterTest
public void MyAfterTest() {}



}
