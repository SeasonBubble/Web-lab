package webadv.s99201105.p02;

/**
 * Hello world!
 *
 */
import org.apache.commons.codec.digest.DigestUtils;
import java.io.*;
import java.util.Scanner;
public class App {
    public static void main(String[] args) throws IOException {
    //预存账号和密码至创建的密码文件里     
	 FileWriter fw= new FileWriter("password.txt");
	  BufferedWriter osw= new BufferedWriter(fw);
	  osw.write("17201102\n");//id
	  osw.write(sha256hex("12317201102"));//password
	  osw.close();
	  fw.close();
    
	//输入密码和账号
	 String inputID="";
	 String inputpassword="";
	 Scanner input=new Scanner(System.in);
	System.out.println("Please enter your ID!");
	 inputID=input.nextLine();
	System.out.println("Please enter your password!");
	 inputpassword=input.nextLine();
	 
	 //读取文件
	 FileReader fr=new FileReader("password.txt");
	 BufferedReader bf=new BufferedReader(fr);
	 String savedID=bf.readLine();
	 System.out.println("The ID you input is: "+savedID);
	  String savedPassword=bf.readLine();
	 System.out.println("The Password you input is: "+savedPassword);
	 
	 bf.close();
	 fr.close();
	
	  if (inputID.equals(savedID)&&sha256hex(inputpassword).equals(savedPassword)){
		  	 System.out.println("Correct!logined!");
		  
	  }else{
		  	 System.out.println("Faile to login!");
	}
   
}
 public static String sha256hex(String input) {
        return DigestUtils.sha256Hex(input);
    }
}

