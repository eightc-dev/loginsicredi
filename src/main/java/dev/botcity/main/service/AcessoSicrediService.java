package dev.botcity.main.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dev.botcity.util.SystemProperties;

public class AcessoSicrediService {

	public WebElement acessoCpf(WebDriver driver)  {

		Properties prop;
		try {
			prop = SystemProperties.getProp();
			String cpf = prop.getProperty("prop.bank.cpfcnpj");
			driver.findElement(By.id("dropdownMenu1")).click();
			driver.findElement(By.id("li-cpf")).click();
			WebElement acessarConta = acessarContaCpf(driver, cpf);

			return acessarConta;
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("ERRO AO TENTAR INSERIR CPF");
		}
		return null;

	}

	public WebElement acessoCnpj(WebDriver driver) {
		
		Properties prop;
		try {
			prop = SystemProperties.getProp();
			String cnpj = prop.getProperty("prop.bank.cpfcnpj");
			driver.findElement(By.id("dropdownMenu1")).click();
			WebElement defineCpfCpnj = driver.findElement(By.id("li-cnpj"));
			defineCpfCpnj.click();
			WebElement acessarConta = acessarContaCnpj(driver, cnpj);
			
			return acessarConta;
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("ERRO AO TENTAR INSERIR CPF");
		}
		return null;

	}

	private WebElement acessarContaCpf(WebDriver driver, String cpf) throws InterruptedException {

		WebElement acessarConta = driver.findElement(By.id("input-login")).findElement(By.className("cpf"));
		acessarConta.click();
		acessarConta.sendKeys(cpf + Keys.ENTER);

		return acessarConta;
	}

	private WebElement acessarContaCnpj(WebDriver driver, String cnpj) {

		WebElement acessarConta = driver.findElement(By.id("input-login")).findElement(By.className("cnpj"));
		acessarConta.click();
		acessarConta.sendKeys(cnpj + Keys.ENTER);

		return acessarConta;
	}

	public void inserirAgenciaConta(WebDriver driver) {

		Properties prop;
		try {
			
			prop = SystemProperties.getProp();
			String agencia = prop.getProperty("prop.bank.agencia");
			String conta = prop.getProperty("prop.bank.conta");
			driver.findElement(By.id("coop")).sendKeys(agencia);
			driver.findElement(By.id("conta")).sendKeys(conta + Keys.ENTER);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void insereSenha(WebDriver driver) {
		
		List<WebElement> elementos = getDadosBtnLogin(driver);
		
		if (!getPropsPass().isEmpty()) {
			for (String p : getPropsPass()) {
				for (WebElement web : elementos) {
					System.out.println("VALOR DO ELEMENTO: " + web.getText());
					if (p.equals(String.valueOf(web.getText().charAt(0)))
							|| p.equals(String.valueOf(web.getText().charAt(5)))) {
						System.out.println("found");
						web.click();
					} else {
						System.out.println("not found");
					}
				}
			}
		}
	}
	
	private List<WebElement> getDadosBtnLogin (WebDriver driver) {
		
		WebElement btnOne = driver.findElement(By.id("0"));
		WebElement btnTwo = driver.findElement(By.id("1"));
		WebElement btnTree = driver.findElement(By.id("2"));
		WebElement btnFour = driver.findElement(By.id("3"));
		WebElement btnFive = driver.findElement(By.id("4"));
		List<WebElement> lBtn = new ArrayList<WebElement>();
		lBtn.add(btnOne);
		lBtn.add(btnTwo);
		lBtn.add(btnTree);
		lBtn.add(btnFour);
		lBtn.add(btnFive);
		
		return lBtn;
	}

	private List<String> getPropsPass() {

		Properties prop;
		try {
			prop = SystemProperties.getProp();
			String propOne = prop.getProperty("prop.bank.password.one");
			String propTwo = prop.getProperty("prop.bank.password.two");
			String propTree = prop.getProperty("prop.bank.password.tree");
			String propFour = prop.getProperty("prop.bank.password.four");
			String propFive = prop.getProperty("prop.bank.password.five");
			String propSix = prop.getProperty("prop.bank.password.six");

			List<String> props = new ArrayList<String>();
			props.add(propOne);
			props.add(propTwo);
			props.add(propTree);
			props.add(propFour);
			props.add(propFive);
			props.add(propSix);
			return props;
		} catch (IOException e) {

			e.printStackTrace();
		}
		return null;
	}

}
