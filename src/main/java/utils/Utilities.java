package utils;
//creer des methodes qui nous serrons utiles 
// des methodes static qui seront vues dans toutes les autres classes
// appeler les methodes static par la classe elle meme
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utilities {
	
		//remove hardcoded wait time in Base class
		public static final int Implicit_WaitTime=10;
		public static final int pageWaitTime=5;

		//generer un nouveau email à chaque nouvelle execution de test avec le timeStamp
		//utiliser pour débloquer  les tentatives successives de login avec invalid email
		//generate an email with a different prefix+timestamp
		public static String generateTimeStamp() {
			Date date = new Date();
			String timeStamp = date.toString().replace(" ", "_").replace(":", "_");
			return "tester"+timeStamp+"@gmail.com";
			
	//Dans le teardown supprimer l'email créé, pour éviter le surcharge de la base de données		

		}
		//generer two Dimensions Table
		//un fichier execel un workbook
		//lire les donnees a partir d'excel
		
		public static Object [] [] getDataFromExcel(String sheetName) throws Exception{
			//specifier a Java ou se trouve notre fichier excel pour le manipuler
			//On utilise la classe system pour ne pas dependre de l'emplacement local
			File excelFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\testData\\ninjaTestData.xlsx");
			//lire les donnees 
			FileInputStream fis = new FileInputStream(excelFile); //gerer l'exception
			// manipuler nos donnes excel dans fis avec l'objet workbook
			// definir la variable
			//class API POI
			//creer un objet a partir de la classe XSSFWorkbook qui ns permet d'ecrire, lire un fichier excel
			XSSFWorkbook workbook = new XSSFWorkbook(fis); //gerer l'exception
			//creer un objet de type 'sheet' pour manipuler les donnees
			XSSFSheet sheet = workbook.getSheet(sheetName); //shhet est la reference de l'objet
			// lire le max des lignes et des colonnes qui ont des donnees afin de mieux controler nos boucles For ulterieurement
			//on a cree 2 objets a partir des methodes get de notre objet sheet
			int rows = sheet.getLastRowNum();
			int columns = sheet.getRow(0).getLastCellNum();
			// liste d'une valeur homogene de meme type, liste heterogene contient tous les types
			// on a cree un tableau generique qui contient tout genre d'objets string, integer, booleen 
			Object[] [] data = new Object[rows] [columns];
			//Parcourir le tableau row et column, for imbrique
			for(int i=0;i<rows;i++){
				XSSFRow row = sheet.getRow(i+1); //i+1 pour ne pas traiter le header du tableau, la ligne qui suit le row 0
				for(int j=0;j<columns;j++) {
					XSSFCell cell = row.getCell(j); //j traiter la colonne actuelle
					CellType celltype= cell.getCellType();
					//structure conditionnelle comme le if else imbrique
					//switch case
					switch(celltype) {
					case STRING:
						data[i] [j] = cell.getStringCellValue();
						break;
					case NUMERIC:
						data[i] [j] = Integer.toString((int)cell.getNumericCellValue()); //class wraper Integer
						break;
					case BOOLEAN:
						data[i] [j] = cell.getBooleanCellValue();
						break;
					}
				}
			}
			return data; //retourne le tableau data
			
			
		}
		public static String captureScreenShot (WebDriver driver, String testName) {
			File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String destinationScreenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png";
			try {
				FileHandler.copy(screenshot, new File(destinationScreenshotPath));
			} catch (IOException e) {
				e.printStackTrace();
			}
			return destinationScreenshotPath;
		}
		
	}

