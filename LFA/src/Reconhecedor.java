import java.util.Scanner;

public class Reconhecedor {

	public static void main(String[] args) {
		String reservadas;
		//inserção de dados 
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Digite o texto a ser reconhecido: ");
		String text = scan.nextLine();
		
		//Split
		String[] palavras = text.split(" ");
		
		//palavras reservadas(comandos)
		String [] comandos = { "if", "try","system.out.println","String","float","int","felipe","taioque" };
		
		//comparação de vetores
		
		for(int i = 0; i < palavras.length; i++) {
			int cont = 0;
			int cont2 = 0;
			int cont3 = 0;
			if ((palavras[i].charAt(0) == '\"') || (palavras[i].charAt(0) == '\'')) { //verificar se é um literal
				for(int p = 0; p < palavras[i].length(); p++) {
					if((palavras[i].charAt(p) == '\"') || (palavras[i].charAt(p) == '\'') ) {
						cont3++;
					}
				}
				if(cont3 == 2) {
					System.out.println(palavras[i] + " = Literal ");
				}else {
					System.out.println(palavras[i] + " = Nome ");
				}
			}else if(Character.isDigit(palavras[i].charAt(0))) { //verificar se é um numero
				for(int l = 0; l < palavras[i].length(); l++) {	
					if ((palavras[i].charAt(l) == '.') || (palavras[i].charAt(l) == ',')) {
						cont2++;
					}	
				}
				if(cont2 == 0) {				
					System.out.println(palavras[i] + " = Numero Inteiro ");
				}else {
					System.out.println(palavras[i] + " = Numero Real ");
				}
			}else { //verifica se é uma palavra
				for(int j = 0; j < comandos.length; j++) {
					if(palavras[i].equals(comandos[j])) {
						cont++; 
					}
				}
				if(cont == 1) {				
					System.out.println(palavras[i] + " = Palavra Reservada ");
				}else {
					System.out.println(palavras[i] + " = Nome ");
				}
			}		
		}
		scan.close();
	}
	
}
