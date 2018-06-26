package reg;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class GmailReg 
{

	public static void main(String[] args) throws BiffException, IOException, InterruptedException
	{
		//Launch gmail site
		
		System.setProperty("webdriver.chrome.driver","E:\\batch238\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://accounts.google.com/signup/v2/webcreateaccount?hl=en-GB&flowName=GlifWebSignIn&flowEntry=SignUp");
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 File f=new File("GmailData.xls");
		 //for reading Excel sheet
		Workbook rwb=Workbook.getWorkbook(f);
		Sheet rsh1=rwb.getSheet(0);
				
		//firstname
		 String fn=rsh1.getCell(0,1).getContents();
		 driver.findElement(By.name("firstName")).sendKeys(fn);
		 
		 //lastname
		 String ln=rsh1.getCell(1,1).getContents();
		 driver.findElement(By.name("lastName")).sendKeys(ln);
		 
		//username
		 String un=rsh1.getCell(2,1).getContents();
		 driver.findElement(By.name("Username")).sendKeys(un);
		 
		//password
		 String pwd=rsh1.getCell(3,1).getContents();
		 driver.findElement(By.name("Passwd")).sendKeys(pwd);
		 
		 //cnfrmpassword
		 String cpwd=rsh1.getCell(4,1).getContents();
		 driver.findElement(By.name("ConfirmPasswd")).sendKeys(cpwd);
		 
		 //Next
		 driver.findElement(By.xpath("//*[text()='Next']")).click();
		
		 //Phno
		 String phno=rsh1.getCell(5,1).getContents();
		 driver.findElement(By.xpath("//*[@aria-label='Enter a phone number']")).sendKeys(phno,Keys.ENTER);
		 
		  
		 //verification code
		 String code=rsh1.getCell(6,1).getContents();
		 
		 driver.findElement(By.id("code")).sendKeys(code,Keys.ENTER);
	    
		//driver.findElement(By.xpath("[//*text()='Next']")).click();
		  
		 Thread.sleep(4000);
		 //recoveryemail
		String receml=rsh1.getCell(7,1).getContents();
		driver.findElement(By.xpath("//*[@aria-label='Recovery email address (optional)']")).sendKeys(receml);
		
		//Day
		String day=rsh1.getCell(8,1).getContents();
		driver.findElement(By.xpath("//*[@aria-label='Day']")).sendKeys(day);
		
		//dropdown (month)
		 WebElement e1=driver.findElement(By.id("month"));
		 Select s=new Select(e1);
		 String mnth=rsh1.getCell(9,1).getContents();
		 s.selectByVisibleText(mnth);
		 
		 //year		 
		 String yr=rsh1.getCell(10,1).getContents();
		 driver.findElement(By.xpath("//*[@aria-label='Year']")).sendKeys(yr);
		 
		 
		 //gender
		 String g=rsh1.getCell(11,1).getContents();		
		 WebElement e2=driver.findElement(By.id("gender"));
		 //Select s1=new Select(e2);
		 Actions a=new Actions(driver);
		 a.sendKeys(e2,g).build().perform();
         a.sendKeys(Keys.ENTER).build().perform();
		 
		 //next
		 driver.findElement(By.xpath("//*[text()='Next']")).click();
		
					
	}


	
}
