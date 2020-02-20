package Cryptage;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntUnaryOperator;

/*dans ce programme j'essayerai de créer un système de cryptage using streams */

/* les char sont de 97 à 122 : 26 caracter! */
public class Cryptage  {
	
	private int frequence ;
	
		
	private Cryptage(int frequence ) {
		this.frequence = frequence;
	}
	
	public int getFrequence() {
		return frequence;
	}
	
	public void decrypting(List<String> crypted) { // cette méthode print le message aprrès avoir décrypter la lste des mots
		
		IntUnaryOperator trait = i->{ return (i-frequence)  ;};
		
		Consumer<String> decrypte = mot -> {mot.chars().map(trait).forEach(x->System.out.print((char)x));
											System.out.print(" ");};
		crypted.forEach(decrypte);
		
	
	}
	
	
	public List<String> crypted(String line) { // cette méthode retourne la liste des mots après le cryptage.
		
		List<String> cryptedList = new ArrayList();
		for(String name : line.split(" ")) {
			StringBuilder nameCrypted = new StringBuilder();
			IntUnaryOperator trait = i->{ return (i+ frequence);};
			name.chars().map(trait).forEach(x->nameCrypted.append((char)x));
			cryptedList.add(nameCrypted.toString());
		}
		
		return cryptedList;
		
	}
	
	//cette methode qui va instancier l'objet!
	static Cryptage define() {
		System.out.print("Ce programme sert a crypter/decrypter vos messages selon votre frequence choisit !\n\n");
		return (new Cryptage(90));
		
	}
	


	
		
		
		
		
		
		
		
}
	
		
	

