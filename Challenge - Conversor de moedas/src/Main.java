import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        float valorDigitadoPeloUsuario;
        String moedaOrigem;
        String moedaDestino;
        int opcaoDoUsuario;
        Scanner leitura = new Scanner(System.in);

        ConversaoDeMoeda conversaoDeMoeda = new ConversaoDeMoeda();

        while (true) {

            try {

                System.out.println();

                System.out.println("**************************************");
                System.out.println("Seja bem vindo ao conversor de moedas \n");

                System.out.println("1 - Dólar >>> Peso argentino");
                System.out.println("2 = Peso argentino >>> Dólar");
                System.out.println("3 - Dólar >>> Real brasileiro");
                System.out.println("4 - Real brasileiro >>> Dólar");
                System.out.println("5 - Dólar >>> Peso colombiano");
                System.out.println("6 - Peso colombiano >>> Dólar");
                System.out.println("7 - Sair");
                System.out.println("Escolha uma opção válida");
                System.out.println("**************************************\n");

                while (true) {
                    opcaoDoUsuario = leitura.nextInt();
                    if (opcaoDoUsuario >= 1 && opcaoDoUsuario <= 7) {
                        break;
                    } else {
                        System.out.println("\nValor invalido, tente novamente.");
                    }
                }

                if (opcaoDoUsuario == 7) {
                    break;
                }

                if (opcaoDoUsuario == 1) {
                    moedaOrigem = "USD";
                    moedaDestino = "ARS";
                } else if (opcaoDoUsuario == 2) {
                    moedaOrigem = "ARS";
                    moedaDestino = "USD";
                } else if (opcaoDoUsuario == 3) {
                    moedaOrigem = "USD";
                    moedaDestino = "BRL";
                } else if (opcaoDoUsuario == 4) {
                    moedaOrigem = "BRL";
                    moedaDestino = "USD";
                } else if (opcaoDoUsuario == 5) {
                    moedaOrigem = "USD";
                    moedaDestino = "COP";
                } else {
                    moedaOrigem = "COP";
                    moedaDestino = "USD";
                }

                    System.out.println("\nDigite um valor que deseja converter: \n");
                    valorDigitadoPeloUsuario = leitura.nextFloat();

                conversaoDeMoeda.converter(moedaOrigem, moedaDestino, valorDigitadoPeloUsuario);

            } catch (InputMismatchException e) {
                System.out.println("\nValor invalido, tente novamente.");
                leitura.next();
            }
        }
        leitura.close();
    }
}