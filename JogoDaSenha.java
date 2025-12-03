import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class JogoDaSenha {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();

        final int senhaTamanho = 4;
        final int tentativaMax = 10;
        
        int[] senha = new int[senhaTamanho];
        int[] tentativa = new int[senhaTamanho];
        
        boolean venceu = false;
        
        for (int i = 0; i < senhaTamanho; i++) {

            senha[i] = rd.nextInt(6) + 1; 
        }

        System.out.println("-------==== JOGO DA SENHA - MasterMind ====-------");
        System.out.println("\nQuatro Numeros Aleatorios Entre 1 e 6 foi Gerado!");
        System.out.println("\nTente Advinhar a Senha Gerada!");
        System.out.println("\nDIGITE UM NÚMERO DE CADA VEZ!");
        System.out.println("\n--------------------------------------------------");

        System.out.println("\nSenha Correta: " + java.util.Arrays.toString(senha));

        for (int rodada = 1; rodada <= tentativaMax; rodada++) {
            System.out.printf("\nTentativa %d de %d: \n", rodada, tentativaMax);

            for (int i = 0; i < senhaTamanho; i++) {

                if (sc.hasNextInt()) {

                    tentativa[i] = sc.nextInt();
                } else {

                    System.out.println("Algo Deu Errado. Tente Novamente!");
                    sc.next();
                    i--;
                }
            }

            int[] copiaSenha = senha.clone();
            int[] copiaTentativa = tentativa.clone();

            int digitosCorretos = 0;
            int digitosDeslocados = 0;

            for (int i = 0; i < senhaTamanho; i++) {
                if (copiaSenha[i] == copiaTentativa[i]) {
                    
                    digitosCorretos++;

                    copiaSenha[i] = -1;      
                    copiaTentativa[i] = -1;  
                }
            }

            if (digitosCorretos == senhaTamanho) {
                venceu = true;

                break;
            }

            for (int i = 0; i < senhaTamanho; i++) {
                

                if (copiaTentativa[i] != -1) {
                    
                    for (int j = 0; j < senhaTamanho; j++) {

                        if (copiaSenha[j] != -1 && copiaSenha[j] == copiaTentativa[i]) {

                            digitosDeslocados++;

                            copiaSenha[j] = -1; 

                            break; 
                        }
                    }
                }
            }

            System.out.println("Digitos Corretos: " + digitosCorretos);
            System.out.println("Digitos Deslocados: " + digitosDeslocados);
        }

        System.out.println("\n--------------------------------------------------");
        if (venceu) {
            System.out.println("\nPARABÉNS! VOCÊ GANHOU!");
        } else {
            System.out.println("\nSuas tentativas acabaram.");
            System.out.println("A senha correta era: " + java.util.Arrays.toString(senha));
        }
        
        sc.close();
    }
}