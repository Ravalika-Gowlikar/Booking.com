package booking.comPages;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class SearchPage {

	WebDriver driver;
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
	}
	
	String checkInMonth = "February 2024";
	String dateVal = "25";
	
	String checkOutMonth = "March 2024";
	String dateValue = "2";
	
	By place = By.id(":re:");
	By check_in = By.xpath("(//span[@class='a8887b152e'])[1]"); 
	By mon_Incheck = By.xpath("(//h3[@class='e1eebb6a1e ee7ec6b631'])[1]");
	By mon_Outcheck= By.xpath("(//*[@class='e1eebb6a1e ee7ec6b631'])[2]");
	By arrow_clk= By.xpath("(//div[@class='a10b0e2d13 c807ff2d48'])/button");
	By sel_Indate  = By.xpath("(//table[@class='eb03f3f27f']//span[text()="+dateVal+"])[1]");
	By sel_Outdate = By.xpath("(//table[@class='eb03f3f27f']//span[text()="+dateValue+"])[2]");
	By sel_rooms   = By.xpath("//*[@class='d777d2b248']");  
	By room_adult1 = By.xpath("//*[@id=\":rf:\"]/div/div[1]/div[2]/button[2]");
	By room_adult2 = By.xpath("//*[@id=\":rf:\"]/div/div[1]/div[2]/button[1]");
	By room_child = By.xpath("//*[@id=\":rf:\"]/div/div[2]/div[2]/button[2]");
	By drop_down   = By.name("age");
//	By num_rooms   = By.xpath("//*[@id=\":rf:\"]/div/div[5]/div[2]/button[2]");
//	By num_rooms2  = By.xpath("//*[@id=\":rf:\"]/div/div[5]/div[2]/button[1]");
//	By Done_btn    = By.xpath("//*[@id=\":rf:\"]/button");
	By submit_btn  = By.xpath("//*[@id=\"indexsearch\"]/div[2]/div/form/div[1]/div[4]/button");              //span[@class='e4adce92df'][text()='Search'])"
	By drag1       = By.xpath("//*[@id=\"filter_group_price_:rg:\"]/div[2]/div[2]/div/input[1]");
	By drag2       = By.xpath("//*[@id=\"filter_group_price_:rg:\"]/div[2]/div[2]/div/input[2]");
	By star_select = By.xpath("(//div[@data-filters-item=\"class:class=5\"])[1]");
	By popular_hotle= By.xpath("(//div[@data-filters-item=\"ht_id:ht_id=204\"])[1]");
	By AC_facility=By.xpath("(//div[@data-filters-item=\"roomfacility:roomfacility=11\"])[1]");
	By wheelchair = By.xpath("(//div[@data-filters-item=\"accessible_facilities:accessible_facilities=185\"])[1]");
	
	public void search() throws InterruptedException, Exception {
        //check-in date
		Thread.sleep(5000);
//		File src = new File(System.getProperty("user.dir")+"//POMScreenshots//HomePage.png");
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File f2 = ts.getScreenshotAs(OutputType.FILE);
//		FileHandler.copy(f2, src);
		
		WebElement wb = driver.findElement(place);
		wb.sendKeys("Chennai");
		
		//datepicker
		
		driver.findElement(check_in).click();
		Thread.sleep(2000);
		while(true)
		{
			String month = (driver.findElement(mon_Incheck).getText());
			
			if(month.equals(checkInMonth))
			{
				break;
			}
			else
			{
				driver.findElement(arrow_clk).click();
			}
		}
		
		driver.findElement(sel_Indate).click();
		
		//check-out date
		
		Thread.sleep(2000);
		while(true)
		{
			String month = (driver.findElement(mon_Outcheck).getText());
			
			if(month.equals(checkOutMonth))
			{
				break;
			}
			else
			{
				driver.findElement(arrow_clk).click();
			}
		}
		
		driver.findElement(sel_Outdate).click();
		
		//room selection
		driver.findElement(sel_rooms).click();
		
		driver.findElement(room_adult1).click();
		Thread.sleep(2000);
		driver.findElement(room_adult2).click();
		Thread.sleep(2000);
		driver.findElement(room_child).click();
		
		Select drp_down = new Select(driver.findElement(drop_down));
		drp_down.selectByIndex(5);
		
		driver.findElement(submit_btn).click();
		
		Thread.sleep(3000);
		File src3 = new File(System.getProperty("user.dir")+"//POMScreenshots//propertiesPage.png");
		TakesScreenshot ts3 = (TakesScreenshot) driver;
		File f23 = ts3.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(f23, src3);
		
		Actions action = new Actions(driver);
		WebElement draggable = driver.findElement(drag1);
		action.dragAndDropBy(draggable, 45, 0);
		
		WebElement daggable1 = driver.findElement(drag2);
		action.dragAndDropBy(daggable1, 0, -100);
		Thread.sleep(2000);
		driver.findElement(star_select).click();
		driver.findElement(popular_hotle).click();
		driver.findElement(AC_facility).click();
		driver.findElement(wheelchair).click();
	}

}
