package Helper;

import java.time.Duration;

import org.joda.time.Seconds;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class GreenMileHelper {
	WebDriver driver;
	
	
	
	/**
	 * Start the Application Site GreenMile
	 */
	
	protected void startApplicationGreenMile(){
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.greenmile.com/#/login");
	}
	
	/**
	 * Login in GreenMile Site
	 */
	protected void loginGreenMile(){
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("j_username")));
		driver.findElement(By.id("j_username")).sendKeys("GM-Carlos");
		driver.findElement(By.id("j_password")).sendKeys("greenmile");
		WebElement loginBtn = driver.findElement(By.xpath(".//*[@id='Login']/div[2]/div/button"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", loginBtn);
	}
	
	/**
	 * Navigate to Functionality Smart Survivy
	 */
	protected void navigateToSmartSurvivy(){
		WebDriverWait waitMaintenance = new WebDriverWait(driver, 60);
		waitMaintenance.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Maintenance")));
		driver.findElement(By.linkText("Maintenance")).click();;
		driver.findElement(By.linkText("Smart Survey")).click();;
		
	}
	/**
	 * Waiting button
	 */
	protected void waitButtonNEW(){
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Survey_btn_novo")));
	}
	/**
	 * Click in Button NEW
	 */
	protected void clickButtonNEW(){
		driver.findElement(By.id("Survey_btn_novo")).click();
	}
	
	/**
	 * Fill Filds Description And Organization in Register Question
	 * @throws InterruptedException
	 */
	protected void fillFildsDescriptionAndOrganization() throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("SurveyDescriptionFilter")));
		driver.findElement(By.id("SurveyDescriptionFilter")).sendKeys("Question in Happy Day 4");
		
		Actions teste = new Actions(driver);
		teste.sendKeys(Keys.TAB).build().perform();
		teste.sendKeys("GM-Carlos").build().perform();
		Duration tempo = Duration.ofSeconds(2);
		teste.pause(tempo);
		teste.sendKeys(Keys.TAB).build().perform();
	}
	/**
	 * Click Button Application Rules in Register Question
	 */
	protected void clickButtonApplicationRules(){
		driver.findElement(By.id("SurveyApplyRulesOpenModal")).click();
	}
	
	/**
	 * Click Button Salve in Forms For Add Applicaiton Rules Or Questions
	 */
	protected void clickButtonSAVE(){
		driver.findElement(By.id("LinkFormSaveButton")).click();	
	}
	
	/**
	 * Fill Fild Title
	 */
	protected void fillFildTitle(){
		driver.findElement(By.id("HeaderQuestionTitle")).sendKeys("Titulo Questionario de Perguntas");
	}
	/**
	 * Click Button ADD QUESTION
	 */
	protected void clickButtonAddQuestion(){
		driver.findElement(By.name("btn_question")).click();
	}
	/**
	 * Click in Any Question for ADD QUESTION
	 */
	protected void clickInAnyQuestion(){
		driver.findElement(By.cssSelector("#SurveyLinkForm > div:nth-child(1) > div > ul > li:nth-child(3)")).click();
	}
	
	/**
	 * Fukk Required Filds in ADD QUESTION 
	 */
	protected void fillRequiredFildsQuestions(){
		driver.findElement(By.id("QuestionDescription")).sendKeys("Questions description");
		clickButtonSAVE();
	}
	/**
	 * Click in Button Save For Save Question
	 */
	protected void clickButtonSaveQuestion(){
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Survey_btn_new_save")));
		driver.findElement(By.id("Survey_btn_new_save")).click();
	}
	
	/**
	 * Verify any Item Registration in Grid  
	 * @param nameItem
	 */
	protected void verifyRegisterQuestion(String nameItem){
		waitButtonNEW();
		String attribute = driver.findElement(By.xpath("//*[@id='form_and_grid']/form/div[3]/div[2]/div[2]/div[5]/div[3]/div")).getAttribute("innerHTML");
		
		boolean cadastrouQuestionario = attribute.contains(nameItem);
		Assert.assertEquals(true, cadastrouQuestionario);
		System.out.println(attribute);
	}

	/**
	 * Register Item Question
	 * 
	 * @param nameDescription name For Fild Description
	 * @throws InterruptedException
	 */
	protected void registerItemQuestion(String nameDescription) throws InterruptedException{
		waitButtonNEW();
		clickButtonNEW();
		fillFildsDescriptionAndOrganization(nameDescription);
		clickButtonApplicationRules();
		clickButtonSAVE();
		fillFildTitle();
		clickButtonAddQuestion();
		clickInAnyQuestion();
		fillRequiredFildsQuestions();
		clickButtonSaveQuestion();
		
	}
	
	/**
	 * Fill Filds Description And Organization
	 * @param nameDescription name for Fild Description
	 * @throws InterruptedException
	 */
	protected void fillFildsDescriptionAndOrganization(String nameDescription) throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("SurveyDescriptionFilter")));
		driver.findElement(By.id("SurveyDescriptionFilter")).sendKeys(nameDescription);
		
		Actions teste = new Actions(driver);
		teste.sendKeys(Keys.TAB).build().perform();
		teste.sendKeys("GM-Carlos").build().perform();
		Duration tempo = Duration.ofSeconds(4);
		teste.pause(tempo);
		teste.sendKeys(Keys.TAB).build().perform();
	}
	/**
	 * Find for Registered Item
	 * @param nameItem name item For Find
	 */
	protected void findForRegisteredItem(String nameItem){
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='Survey_description']/input")));
		
		driver.findElement(By.xpath("//*[@id='Survey_description']/input")).sendKeys(nameItem);
		//Click in Filter
		driver.findElement(By.xpath("//*[@id='form_and_grid']/form/div[3]/div[2]/div[1]/div[2]/div[4]/input[1]")).click();
		Actions teste = new Actions(driver);
		Duration tempo = Duration.ofSeconds(3);
		teste.pause(tempo);
		//Click in Register
		driver.findElement(By.xpath("//*[@id='form_and_grid']/form/div[3]/div[2]/div[2]/div[5]/div[3]/div/div[1]/div[1]")).click();
	}
	
	/**
	 * Click Button DELETE SELECTED
	 */
	protected void clickButtonDeleteSelected(){
		Actions teste = new Actions(driver);
		Duration tempo = Duration.ofSeconds(3);
		teste.pause(tempo);
		
		driver.findElement(By.id("buttonEventCheckBox")).click();
		
		teste.pause(tempo);
		
		Alert javascriptAlert = driver.switchTo().alert();
		System.out.println(javascriptAlert.getText()); // Get text on alert box
		javascriptAlert.accept();
	}
	
	/**
	 * Verify item Deleted
	 */
	protected void verifyRegisterQuestionDeleted(){
		waitButtonNEW();
		Actions teste = new Actions(driver);
		Duration tempo = Duration.ofSeconds(3);
		teste.pause(tempo);
		String attribute = driver.findElement(By.xpath("//*[@id='form_and_grid']/form/div[3]/div[2]/div[2]/div[5]/div[3]/div/div[1]/div[1]")).getAttribute("innerHTML");
		boolean verifyRegister = true;
		if (attribute == null || attribute.isEmpty()) {
			verifyRegister = false;
		}
		System.out.println(attribute);
		Assert.assertEquals(true, verifyRegister);
		System.out.println(attribute);
	}
	
	/**
	 * Verify Message Erro in Mandatory Fild
	 */
	protected void verifyMessageErroMandatoryFild(){
		Actions teste = new Actions(driver);
		Duration tempo = Duration.ofSeconds(3);
		teste.pause(tempo);
		String message = driver.findElement(By.xpath("//*[@id='form_and_grid']/form/div[1]/div")).getAttribute("innerHTML");
		
		boolean validDescription = message.contains("Description is mandatory");
		boolean validOrganization = message.contains("Organization is mandatory");
		boolean validTitle = message.contains("Section Title is mandatory");
		boolean validQuestions = message.contains("Section Questions are mandatory");
		boolean validApplicationRule = message.contains("It is mandatory to add at least one Application Rule");
				
		Assert.assertEquals(true, validDescription);
		Assert.assertEquals(true, validOrganization);
		Assert.assertEquals(true, validTitle);
		Assert.assertEquals(true, validQuestions);
		Assert.assertEquals(true, validApplicationRule);
		
		System.out.println(message);
		
	}
	
}
