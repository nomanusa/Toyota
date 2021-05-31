package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import util.TestUtil;


public class corolla2015 {

		public static WebDriver driver;
		public static Properties prop;
		
		
		public corolla2015() throws IOException {
			prop = new Properties();
			FileInputStream ip = null;
				try {
				ip = new FileInputStream("C:\\Users\\Noman\\workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
					prop.load(ip);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch(IOException e) {
					e.printStackTrace();
				}finally {
					ip.close();
				}
			
		}
		
		public static void initialization() {
			String browserName = prop.getProperty("browser");
		    //if(browserName.equals("chrome")) {
			browserName = System.setProperty("webdriver.chrome.driver", "C:\\Users\\Noman\\Desktop\\QA Class\\Selenium\\chromedriver.exe");
				driver = new ChromeDriver();
			//}
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);  // ClassName.variableName = TestUtil.PAGE_LOAD_TIMEOUT
//			page_load_timeout means If page did not load at that time, it will show error
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);       // ClassName.variableName = TestUtil.IMPLICIT_WAIT
//			Implicit_wait means Wait to page load
//			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);  // ClassName.variableName = TestUtil.PAGE_LOAD_TIMEOUT
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);       // ClassName.variableName = TestUtil.IMPLICIT_WAIT
			
			driver.get(prop.getProperty("url"));
		}

	


}
