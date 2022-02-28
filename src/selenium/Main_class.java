package selenium;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main_class {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver(); 
		
		// Para buscar un elemento, espera 10 segundos hasta que el elemento aparezca
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		try {
			
			driver.get("https://www.laparadinha.com");
			
			/* Desarrolla un método de espera con tiempo límite y lo aplica para encontrar un elemento tras la espera. Ese 
			 * método wait se puede aplicar para cualquier elemento posterior. El polling es para hacer comprobación cada 
			 * cierto tiempo. Si no lo encuentra en primer momento para que no salte la Exception, la ignoramos
			 
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
					.pollingEvery(Duration.ofSeconds(5)).
					ignoring(NoSuchElementException.class);
			
			WebElement botonImp =wait.until(new Function<WebDriver, WebElement>(){
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.id("boton"));
				}
			});
			
			botonImp.click();
			*/
			
			/* Evolución del anterior. Se puede definir las condiciones necesarias que ha de tener para pedir que se haga
			 * una instrucción (que sea clicable, por ejemplo) 
			 
			WebDriverWait wait = new WebDriverWait(driver, 10); 
			
			WebElement botonExp = wait.until(ExpectedConditions.elementToBeClickable(By.id("boton")));
			
			botonExp.click();
			*/
			
			Thread.sleep(5000);
			
			WebElement div = driver.findElement(By.cssSelector("#feat-categories>div:nth-of-type(3)"));
			System.out.println(div.getText());
			
			
			driver.findElement(By.id("menu-item-96")).click();
			
			Thread.sleep(5000);

			
			String titulo = driver.getTitle(); 

			
			System.out.println(titulo);
			
			
			driver.findElement(By.linkText("Opinión")).click();
			
			Thread.sleep(5000);

			
			String titulo2 = driver.getTitle(); 

			
			System.out.println(titulo2);
			
			List<WebElement> h3 = driver.findElements(By.tagName("h3"));
			
			System.out.println(h3);
			
			WebElement title = driver.findElement(By.tagName("title"));
			
			String cadena = title.getAttribute("innerText");
			
			System.out.println(cadena);
			/*
			WebElement link = driver.findElement(By.xpath("//*[@id=\"feat-categories\"]//*[text()='Reportajes']"));
			
			link.click();		
	
			Thread.sleep(2000);

			
			String titulo3 = driver.getTitle(); 

			
			System.out.println(titulo3);
			*/

		}catch(Exception e){
			e.printStackTrace();
		}finally {
			driver.quit();
		}
	}

}
