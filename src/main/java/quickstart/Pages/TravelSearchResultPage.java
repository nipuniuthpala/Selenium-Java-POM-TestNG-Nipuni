package quickstart.Pages;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Constants.TimeOuts;

public class TravelSearchResultPage {

	WebDriver driver;


	public TravelSearchResultPage() {
		PageFactory.initElements(driver, this);
	}


	public  void isResultsDisplayed() {



		driver.manage().deleteAllCookies();
		String ActualTitle=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/p/span")).getText();
		String ExpectedTitle="Flights from Hyderabad to Chennai";
		Assert.assertEquals(ExpectedTitle,ActualTitle);
	}
	

}
