package dev.botcity.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class SystemProperties {
	
	public static Properties getProp() throws IOException {
		try {
			Properties props = new Properties();
			FileInputStream file = new FileInputStream(
					"./src/main/resources/dados.properties");
			props.load(file);
			return props;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Falha ao ler arquivo de propriedades!");
		}
		return null;
	}
}
