package tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DesafioKlokTest {

	private WebDriver driver; // objeto do selenium webDriver
	private String url; //Url do site (Amazon)

	@Before
	public void iniciar() throws Exception {
		url = "https://www.amazon.com.br/prime";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ayanne\\eclipse-workspace\\desafiotecnicoklok\\drivers\\chrome\\103\\chromedriver.exe");
		driver = new ChromeDriver();

	}

	@After
	public void finalizar() throws Exception {
		driver.quit();
	}
	
	// O teste abaixo é automatizado e faz o fluxo de ponta a ponta de um cliente que entra em um grande portal de comércio online (Amazon), realiza uma busca por algum produto e tenta validar o retorno dessa busca
	@Test
	public void buscarProdutoValido() throws InterruptedException {
		driver.get(url); // Abre o navegador na página indicada pela url
		WebElement campoPesquisar = driver.findElement(By.id("twotabsearchtextbox"));
		campoPesquisar.sendKeys("Redmi Note 11 Pro+ 5G Star Blue 6GB RAM 128GM ROM"); //Nome do produto que vai ser passado no campo de busca do site
		WebElement botaoPesquisar = driver.findElement(By.id("nav-search-submit-button"));
		botaoPesquisar.click(); // Comando para que o botão de busca seja acionado
		WebElement resultado = driver.findElement(By.id("p_72/17833784011"));
		assertTrue("Resultado da pesquisa diferente do esperado", resultado.getText().contentEquals("Redmi Note 11 Pro+ 5G Star Blue 6GB RAM 128GM ROM")); // compara o resultado da pesquisa com o nome do produto que está no site
		Thread.sleep(3000);

	}
	
	// Testando um produto que não existe no site da Amazon
	@Test
	public void buscarProdutoInvalido() throws InterruptedException {
		driver.get(url); // Abre o navegador na página indicada pela url
		WebElement campoPesquisar = driver.findElement(By.id("twotabsearchtextbox"));
		campoPesquisar.sendKeys("xxxxxx"); // Produto inexistente no site da Amazon que vai ser passado no campo de busca do site
		WebElement botaoPesquisar = driver.findElement(By.id("nav-search-submit-button"));
		botaoPesquisar.click(); // Comando para que o botão de busca seja acionado
		
	}
	
	// Testando campo de busca vazio, sem passar o nome do produto
	@Test
	public void buscarProdutoSemNome() throws InterruptedException {
		driver.get(url); // Abre o navegador na página indicada pela url
		WebElement campoPesquisar = driver.findElement(By.id("twotabsearchtextbox"));
		campoPesquisar.sendKeys(""); // Não está sendo passado nenhum produto para o campo de busca
		WebElement botaoPesquisar = driver.findElement(By.id("nav-search-submit-button"));
		botaoPesquisar.click(); // Comando para que o botão de busca seja acionado

	}
	
	
	
	
}
