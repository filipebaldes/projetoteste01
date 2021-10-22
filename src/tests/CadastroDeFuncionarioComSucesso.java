package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CadastroDeFuncionarioComSucesso {

	@Test
	public void testCadastroDeFuncionarioComSucesso() {

		// executando o driver do googlechrome
		System.setProperty("webdriver.chrome.driver", "c:\\chromedriver\\chromedriver.exe");

		// Abrindo o navegador (google chrome)
		WebDriver driver = new ChromeDriver();

		// maximizar o navegador
		driver.manage().window().maximize();

		// acessar a página wen do sistema que será testada
		driver.get("http://exercteste01-001-site1.gtempurl.com/Home/Exercicio01");

		// Preencher o nome do funcionário
		driver.findElement(By.xpath("//*[@id=\"Nome\"]")).sendKeys("Sergio Mendes");

		// Preencher a data de admissão do funcionário
		driver.findElement(By.xpath("//*[@id=\"DataAdmissao\"]")).sendKeys("19/10/2021");

		// Preencher o cpf do funcionário
		driver.findElement(By.xpath("//*[@id=\"CPF\"]")).sendKeys("123.456.789-00-");

		// Preencher resumo de atividades do funcionário
		driver.findElement(By.xpath("//*[@id=\"ResumoAtividades\"]")).sendKeys("Programador de sistemas");

		// Clicar no botão de configuração do cadastro
		driver.findElement(By.xpath("//*[@id=\"btnCadastro\"]")).click();

		// Capturar a mensagem obtida no sistem
		String mensagem = driver.findElement(By.xpath("//*[@id=\"mensagem\"]")).getText();

		// Comparando se a mensagem obtida do sistema é "Funcionário cadastrado com
		// sucesso"
		assertEquals(mensagem, "Funcionário cadastrado com sucesso");

		try {
			// o selenium irá fazer um print da tela e armazenar em memória
			File arquivo = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			// salvando o arquivo na pasta
			FileUtils.copyFile(arquivo, new File("c:\\evidencias_teste\\Cadastro de funcionário com sucesso.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Fechar o navegador
		driver.close();
		driver.quit();

	}

	// função de teste para validação de campos obrigatórios
	@Test
	public void testValidacaoDeCamposObrigatorios() {

		// executando o driver do googlechrome
		System.setProperty("webdriver.chrome.driver", "c:\\chromedriver\\chromedriver.exe");

		// abrir o google chrome
		WebDriver driver = new ChromeDriver();

		// maximizar o navegador
		driver.manage().window().maximize();

		// acessar a página de cadastro de funcionarios
		driver.get("http://exercteste01-001-site1.gtempurl.com/Home/Exercicio01");

		// clicar no botão de cadastro
		driver.findElement(By.xpath("//*[@id=\"btnCadastro\"]")).click();

		// capturar as mensagens exibidas pelo sistema
		String erroNome = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div[1]/div[1]/span")).getText();
		String erroCpf = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div[1]/div[2]/span")).getText();
		String erroDataAdmissao = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div[2]/div[1]/span"))
				.getText();
		String erroResumoAtividades = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div[2]/div[2]/span"))
				.getText();

		// Comparando o resultado esperado x resultado obtido

		assertEquals(erroNome, "Informe o nome do funcionário.");
		assertEquals(erroCpf, "Informe o cpf do funcionário.");
		assertEquals(erroDataAdmissao, "Informe a data de admissão do funcionário.");
		assertEquals(erroResumoAtividades, "Informe o resumo de atividades do funcionário");

		try {
			// o selenium irá fazer um print da tela e armazenar em memória
			File arquivo = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			// salvando o arquivo na pasta
			FileUtils.copyFile(arquivo, new File("c:\\evidencias_teste\\Validação de campos obrigatórios.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Fechar o navegador
		driver.close();
		driver.quit();

	}

}
