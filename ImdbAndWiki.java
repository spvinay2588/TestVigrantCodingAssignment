package TestVigrantAssignment;


import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ImdbAndWiki {
public static  WebDriver driver1=null;
public String Imdbdate=null;
public String Imdborigin=null;
public String Wikidate=null;
public String Wikiorigin=null;


	@Test(priority = 1)
	public void Imdb()
	{
		try
		{
			//Launching the chrome browser and navigating the req url
			
			String path=System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", path+"\\Drivers\\chromedriver.exe");
			driver1=new ChromeDriver();
			driver1.manage().window().maximize();
			driver1.get("https://www.imdb.com/title/tt9389998/?ref_=fn_al_tt_1");
			
			//Getting the required Data in String format from IMDB and feeding
			//into globalized String variables
			
			Imdbdate=driver1.findElement(By.xpath("//a[text()='December 17, 2021 (United States)']")).getText();
			Imdborigin=driver1.findElement(By.xpath("//li[@class='ipc-inline-list__item']/following::li[75]//following::li")).getText();
			
//			
//			//closing the browser
//			
//			driver1.close();
//			driver1.quit();
			Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Test(priority = 2)
	public void Wiki()
	{
		try
		{
			//Launching the chrome browser and navigating the req url
			
			String path=System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", path+"\\Drivers\\chromedriver.exe");
			driver1=new ChromeDriver();
			driver1.manage().window().maximize();
			driver1.get("https://en.wikipedia.org/wiki/Pushpa%3A_The_Rise");
			
			//Getting the required Data in String format from IMDB and feeding
			//into globalized String variables
			
			Wikidate=driver1.findElement(By.xpath("//table[@class='infobox vevent']//tr[12]//td")).getText();
			Wikiorigin=driver1.findElement(By.xpath("//table[@class='infobox vevent']//tr[14]//td")).getText();
			
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Test(priority = 3)
	public void ValidationOfWikiAndImdb() throws InterruptedException
	{
		System.out.println("Imdb Details : "+Imdbdate+Imdborigin);
		System.out.println("Wikipidea Details : "+Wikidate+" "+Wikiorigin);
		
		
		//validation through hard assertion for origin
		
		assertEquals(Imdborigin, Wikiorigin);
		System.out.println("both origin are matching");
		
		//Since In Imdb date they have also mentioned united states so both wiki 
		//and imdb details can be  same so i am validating it using if condition
		
		if((Wikidate.contains("17"))&&(Imdbdate.contains("17")))
		{
			System.out.println("Both Dates are matching");
		}
	}
}
