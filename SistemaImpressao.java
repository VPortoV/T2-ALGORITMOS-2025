/*
 _________________________________________
/                                         \
| Bruno Nogueira Asevedo Souza | 23.00313-8|
| Henrique Nalin de Oliveira   | 24.01883-0|
| Leonardo Tedeschi Belo       | 24.00262-3|
| Vítor Porto Vincenzi         | 24.00431-6|
\__________________________________________/
 
 */
public class SistemaImpressao{

    FilaDeImpressao filaImpressao;
    PilhaDeReimpressao pilhaReimpressao;

    public SistemaImpressao(int capacidadeFila, int capacidadePilha){
        this.filaImpressao = new FilaDeImpressao(capacidadeFila);
        this.pilhaReimpressao= new PilhaDeReimpressao(capacidadePilha);
        System.out.println("Sistema inicializado.\n>Capacidade da fila de impressão: " + capacidadeFila + "\n>Capacidade da pilha de reimpressão emergencial: " + capacidadePilha + "\n");
    }

    public SistemaImpressao(){
        this(15, 10);
    }

    public void iniciarImpressoes(){
        System.out.println("Iniciando impressões...");
        while(!filaImpressao.estaVazia()){
            try{
                filaImpressao.imprimir();
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        while(!pilhaReimpressao.estaVazia()){
            pilhaReimpressao.reimprimir();
        }
    }

    public void adicionar(Arquivo a){
        try{
            filaImpressao.enfileira(a);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("Adicionando '" + a.getNomeArquivo() + "' à pilha de reimpressão emergencial...\n");
            pilhaReimpressao.adicionar(a);
        }
    }

    public void busca(String nomeArquivo){
        if (!tentaBuscar(() -> filaImpressao.busca(nomeArquivo)) && !tentaBuscar(() -> pilhaReimpressao.consulta(nomeArquivo))) {
            System.out.println("FALHA: O arquivo '" + nomeArquivo + "' não se encontra no sistema.");
        }
    }

    private boolean tentaBuscar(Runnable metodo){
        try{
            metodo.run();
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public String toString(){
        return filaImpressao.toString() + "\n\n" + pilhaReimpressao.toString();
    }
}