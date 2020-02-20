package Cryptage;
import java.util.Arrays;
import java.util.List;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;


public class Main {
	
	 
	static Cryptage line = Cryptage.define();
	
	
	
	static void crypter(BufferedReader reader)  throws IOException{
		System.out.println("\nmessage est : \t");
		List<String> code = line.crypted(reader.readLine());
		System.out.print("\n code : \t");
		
		
		Consumer<String> print = crypted_mot -> System.out.print(crypted_mot + " "); 
		code.forEach(print);
		System.out.println();
		
		
	}
	
	static void decrypter(BufferedReader reader) throws IOException  {
		System.out.println("\nvotre code à decrypter est : ");
		
		String[] code = reader.readLine().split(" ");
		System.out.print("message reçu est:\t");
		line.decrypting(Arrays.asList(code));
	}
	
	
	public static void main(String args[])  {
		
			try (BufferedReader reader1= new BufferedReader(new InputStreamReader(System.in))){
				while(true) {
					crypter(reader1);
					decrypter(reader1);
				}
			}catch(IOException exp) {
				System.err.print("an error has occured " + exp.getMessage());
				System.exit(-1);
			}
		
		
	
			
		
		
		
		
	}

}
