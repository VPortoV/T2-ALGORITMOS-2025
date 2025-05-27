/*
 _________________________________________
/                                         \
| Bruno Nogueira Asevedo Souza | 23.00313-8|
| Henrique Nalin de Oliveira   | 24.01883-0|
| Leonardo Tedeschi Belo       | 24.00262-3|
| Vítor Porto Vincenzi         | 24.00431-6|
\__________________________________________/
 
 */
import java.io.File;
import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        SistemaImpressao sistema = new SistemaImpressao();

        try {
            Scanner scanner = new Scanner(new File("entrada.txt"));

            while (scanner.hasNextLine()) {
                String l = scanner.nextLine().trim();
                
                String[] partes = l.split(";", 2);
                
                Arquivo temp = new Arquivo(partes[0], partes[1]);

                sistema.adicionar(temp);
            }

            sistema.busca("Boletim.pdf");
            sistema.busca("Inexistente.fake");
            
            System.out.println(sistema.toString());
            scanner.close();
            
            sistema.iniciarImpressoes();
            
            System.out.println(sistema.toString());
            
            sistema.busca("Boletim.pdf");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
