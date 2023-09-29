package base;
//Les tests que nous allons creer vont tous heriter de cette classe base
//Par consequent ils auront acces aux donnees des fichier

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.Utilities;

//contenir tous les setup, teardown communs à tous les tests
public class Base {
	WebDriver driver;
	public Properties prop;
	public Properties dataProp;

	public Base(){
		prop=new Properties();
		dataProp=new Properties();
		//File propFile=new File("D:\\College_BoisDeBoulgone_Assurance_Qualite_logiciell_Groupe1247\\Cours_cohorte_Groupe_1247\\Eclipse_Workspace\\frameworkSeleniumOpencart\\src\\main\\java\\config\\config.properties");
		//user.dir > affiche l'emplacement actuel de mon projet
		File propFile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\config\\config.properties");
		File dataPropFile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\testData\\testData.properties");
		//Lire à partir d'un fichier morceau par morceau
		try {
			FileInputStream dataFis=new FileInputStream(propFile);
			//pour loader le fichier
			//il faut gerer l'exception
				prop.load(dataFis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			FileInputStream dataPropFis=new FileInputStream(dataPropFile);
			dataProp.load(dataPropFis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}
	public WebDriver initialiserNavigateurEtOuvrirUrl (String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
		driver = new ChromeDriver();
	}
	else if (browserName.equalsIgnoreCase("edge")) {
		driver=new EdgeDriver();
	}
	else if (browserName.equalsIgnoreCase("firefox")) {
		
	}
	else {
		driver=new FirefoxDriver();
	}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.Implicit_WaitTime));
		driver.get(prop.getProperty("qaUrl"));
		return driver;
		
	}

}


