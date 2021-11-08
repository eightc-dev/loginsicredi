package dev.botcity.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.botcity.framework.bot.DesktopBot;
import dev.botcity.main.service.AcessoSicrediService;

public class FirstBot extends DesktopBot {

	public FirstBot() {
		try {
			setResourceClassLoader(this.getClass().getClassLoader());
			load();
			action();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void action(){

		teste_sicredi();
	}

	private void teste_sicredi()  {

		System.setProperty("webdriver.chrome.driver", "D:/RPA/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			driver.get("https://www.sicredi.com.br/");

			AcessoSicrediService service = new AcessoSicrediService();
			service.acessoCpf(driver);
			wait(2000);
			service.inserirAgenciaConta(driver);
			wait(2000);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"secureForm\"]/label")));
			service.insereSenha(driver);
			WebElement btnLogin = driver.findElement(By.id("avancar-login"));
			btnLogin.click();
			wait(2000);

		} finally {
			driver.quit();
		}
	}

	private void notFound(String label) {
		System.out.println("not found:" + label);
	}

	private void load() {
		//addImage("youtube", "./src/resources/youtube.png");
	}

	public static void main(String[] args) {
		new FirstBot();
	}
}
