import java.util.*;
public class mila
{
	
	
	public static void main(String[] args)
	
	{
		
		String encrypedText;
		String decrypedText="";
		
		system.out.println("Enter the message"+ "to be decryped");
		encrypedText = s.nextLine();
		
		system.out.println("Encryped message" + encrypedText);
		for (int key =1; key <100; key ++)
		{
			
			for (int index = 0; index < encrypedText.lenght();index++)
			{ char encrypedchar = encrypedText.charAt(index);
		
		char decrypedChar;
		if(((int) encrypedchat+127-32)>126)
		{
			
			decrypedChar=(char)
			((encrypedchar-key+127)-32);
			
		}
		
		else
			
		decrypedChar=(char)
		(encrypedchar-key);
		
		}
		 decrypedText+=decrypedChar;
		 system.out.println("Decryped Message at key" + key+"is"+ decrypedText);
		 decrypedText="";
		 }
	}
}
