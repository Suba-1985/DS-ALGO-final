package dsAlgo_Utilities;


import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageUtils {
	static Properties prop;
	static WebDriverWait wait ;

		 	public static void scrolldown(WebDriver driver)
		{	JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,500)", "");}
	 	
	 	public static void scrolldown(WebDriver driver,WebElement e)
		{	JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,500)", e);}
	 
	 	public static void implicit_wait(WebDriver driver,WebElement e) {
		new WebDriverWait(driver,Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(e));}
	
	 	public static void menu_click(WebDriver driver,List<WebElement> e,String option) {
		scrolldown(driver);
		for (WebElement item : e) {
		implicit_wait(driver, item);
		if(item.getText().equalsIgnoreCase(option))
		{item.click();
		 break;		}}
		}
	 	
	 	public static void entercode(WebDriver driver,WebElement e,String code)
	 	{		
	 		for (int j=0;j<=40;j++) { 
			  	e.sendKeys(Keys.DELETE);   } 
	 			e.sendKeys(code);
		}
	 	
	 	public static void mouse_action(WebDriver driver,WebElement e) {
		Actions act=new Actions(driver);
		act.scrollToElement(e);	 	}
		public static String getPythonCodefromExcel(String sheetname, int rownumber) throws IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {
			ExcelReader reader = new ExcelReader();
			List<Map<String, String>> testdata = reader.getData(ConfigReader.excelPath(), sheetname);
			String result = testdata.get(rownumber).get("PythonCode");
			//LoggerLoad.info("Expected result from Excel sheetname " + sheetname + " and " + rownumber + " : " + result);
			return result;
		}
		
		public static void practice_click(WebElement pQ)
	 	{	
	 		pQ.click();
	 		
	 	}
			
}
