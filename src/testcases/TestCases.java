package testcases;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCases {
	
	private WebDriver driver; 
	private String categoriaTitEsperada="Categoría: Análisis";
	private String tituloEsperado="InicioLa Paradinha | Revista digital de fútbol";
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");

		driver = new ChromeDriver(); 
	}
	
	@Test
	public void TestLPCategoria() {
		driver.get("https://www.laparadinha.com");
		
		driver.findElement(By.id("menu-item-96")).click();
		
		WebElement categoria = driver.findElement(By.className("archive-title"));
		String titCategoria= categoria.getText();
		
		assertEquals(categoriaTitEsperada,titCategoria);


	}
	
	@Test
	public void tituloLP() {
		driver.get("https://www.laparadinha.com");
		
		driver.findElement(By.id("menu-item-96")).click();
		
		driver.navigate().back();
		
		String titulo = driver.getTitle(); 
		System.out.println(titulo);
		
		assertEquals(tituloEsperado,titulo);


		
	}
	
	@After
	public void shutdown() {
		driver.quit();
	}
	

}
