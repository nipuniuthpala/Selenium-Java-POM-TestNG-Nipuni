package sample.Tests;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


import functionLibrary.ReportLog;
import io.github.bonigarcia.wdm.WebDriverManager;
import quickstart.Pages.TravelSearchPage;
import quickstart.Pages.TravelSearchResultPage;


public class DemoTest {
	WebDriver driver;
	TravelSearchPage googleSearch ;
	TravelSearchResultPage googlesearchresults;
	ReportLog logger;


	@BeforeSuite
	public void startTestSuite() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		logger= new ReportLog(driver);

	}
	@BeforeMethod
	public void startTest(Method m) {
		logger.startTest(m.getName());
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

	}

	@AfterMethod
	public void endTest() {
		logger.endTest();

	}

	@AfterSuite
	public void endTestSuite() {
		logger.endTestSuite();
		driver.quit();
	}

	@Test
	public  void Search_flight() throws InterruptedException {
		googleSearch.selectRoundTrip();
		googleSearch.enterFrom();
		googleSearch.enterTo();
		googleSearch.selectDates();
		googleSearch.search();
		googlesearchresults.isResultsDisplayed();
	}




	}





