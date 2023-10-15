package quickstart.Pages;


import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TravelSearchPage {

	WebDriver driver;
	

	public TravelSearchPage(WebDriver driver) throws IOException {
		this.driver=driver;

	}

	public void selectRoundTrip(){
		driver.findElement(By.xpath("//*[@data-cy=\"roundTrip\"]")).click();
	}

	public void enterFrom() {


		Select objSelect = new Select(driver.findElement(By.id("fromCity")));
		objSelect.selectByVisibleText("HYD");

	}
	public void enterTo() {

		Select objSelect = new Select(driver.findElement(By.id("toCity")));
		objSelect.selectByVisibleText("MAA");
	}
	public void selectDates() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='hp-widget__depart']")).click();
		Thread.sleep(2000);

		Date d = new Date(1);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM-yyyy");
		String date = formatter.format(d);
		String splitter[] = date.split("-");
		String month_year = splitter[1];
		String day = splitter[0];
		System.out.println(month_year);
		System.out.println(day);
		selectDate(month_year, day);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='hp-widget__return']")).click();
		Thread.sleep(2000);
		Date d1 = new Date(1);
		SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MMMM-yyyy");
		String date1 = formatter1.format(d1);
		String splitter1[] = date1.split("-");
		String month_year1 = splitter1[1];
		String day1 = splitter1[0];
		System.out.println(month_year1);
		System.out.println(day1);
		selectDate(month_year1, day1);

	}
	public TravelSearchResultPage search() {
		driver.findElement(By.xpath("//a[contains(@class,'widgetSearchBtn') and text()='Search")).click();
		driver.manage().deleteAllCookies();
		return new TravelSearchResultPage();
	}


		public void selectDate(String month_year, String select_day) throws InterruptedException
		{
			List<WebElement> elements = driver.findElements(By.xpath("//div[@class='ui-datepicker-title']/span[1]"));

			for (int i=0; i<elements.size();i++) {
				System.out.println(elements.get(i).getText());

            //Selecting the month
				if (elements.get(i).getText().equals(month_year)) {

               //Selecting the date
					List<WebElement> days = driver.findElements(By.xpath("//div[@class='ui-datepicker-inline ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all ui-datepicker-multi ui-datepicker-multi-2']/div[2]/table/tbody/tr/td/a"));

					for (WebElement d : days)
					{
						System.out.println(d.getText());
						if(d.getText().equals(select_day))
						{
							d.click();
							Thread.sleep(10000);
							return;
						}
					}

				}

			}
			driver.findElement(By.xpath("//div[@class='ui-datepicker-inline ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all ui-datepicker-multi ui-datepicker-multi-2']/div[2]/div/a/span")).click();
			selectDate(month_year,select_day);
			}



}
