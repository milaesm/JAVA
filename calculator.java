
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GuestUser
 */
public class Calculator {
    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {

     Scanner input=new Scanner(System.in);    //Calling an inputs from the computer//
		
		int fnum,snum,ans;
		char sign;  //Assigning a variable character + - * / //
		char resp;
                        
                do { 
                        
		// Introduction to the program //
		System.out.println("Salam dooet e man! This is a Java Calculator by Mila, Azdidane shoma khoshhalam!");
		
		System.out.print("Please Enter your first number: "); 
		
		fnum=input.nextInt(); /*Receiving an input from user, the first number*/
		
		System.out.print("Enter the second number: ");
		snum=input.nextInt();
		/*Receiving an input from user, the second number*/
		
		System.out.print("Enter the operator you want to use: "); //Ask the user to input the arithmetical operator to be used
		sign=input.next().charAt(0); //Receive input from user
        switch (sign) {
        /*making use of if statement to declare the addition sign*/
            case '+':
                ans=fnum + snum;
                System.out.println(fnum +" "+sign+" "+snum +"= "+" "+ ans );
                break;
        /* else if statement for minus sign*/
            case '-':
                ans=fnum-snum;
                System.out.println(fnum +" "+sign+" "+snum +"= "+" "+ ans );
                break;
                /*if statement for division*/
            case '/':
                ans=fnum/snum;
                System.out.println(fnum +" "+sign +" "+snum +"= "+" "+ ans );
                break;
                /*if statement for multiplication*/
            case '*':
                ans=fnum*snum;
                System.out.println(fnum +" "+sign +" "+snum +"= "+" "+ ans );
                break;
            default:
                System.out.println("Your Input is not correct,please check it for any error(s).");
                break;
        }
         System.out.println("I'm great at addition!");
         System.out.print("Play again [Y/N]?:  ");
         resp = input.next().charAt(0);
		
                } while(resp=='Y');	
				System.out.println("Bye Bye!");
				
			
	}

    
    
    
    
}
