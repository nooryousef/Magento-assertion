package MagentoCases;

import java.security.SecureRandom;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Parameter {
	
	static WebDriver driver= new ChromeDriver();
	static String Website="https://magento.softwaretestingboard.com/" ;
	static String signUp="https://magento.softwaretestingboard.com/customer/account/create/";
	
	static String [] Fname= {"sami","hani","lana"};
	static String [] Lname= {"Ody","Yousef","Hassan"};
	static String password="ASDasd123456789*!";
	
	static String logout= "https://magento.softwaretestingboard.com/customer/account/logout/ " ; 
	
	static String login="https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS9jdXN0b21lci9hY2NvdW50L2xvZ291dFN1Y2Nlc3Mv/";	Random rand=new Random();
	int IndexName=rand.nextInt(3);
	String firstname=Fname[IndexName];
	String lastname=Lname[IndexName];
	int emailNO=rand.nextInt(1000);
	String mail=firstname+lastname+emailNO+"@gmail.com";
	
	


}
