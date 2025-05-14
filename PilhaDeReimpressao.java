/*
 _________________________________________
/                                         \
| Bruno Nogueira Asevedo Souza | 23.00313-8|
| Henrique Nalin de Oliveira   | 24.01883-0|
| Leonardo Tedeschi Belo       | 24.00262-3|
| Vítor Porto Vincenzi         | 24.00431-6|
\__________________________________________/
 
 */
public class PilhaDeReimpressao {
    Arquivo[] arquivos;
    int topo;
    int capacidade;
    
    public PilhaDeReimpressao(int capacidade){
        this.capacidade = capacidade;
        this.topo = -1;
        this.arquivos = new Arquivo[capacidade];
    }

    public int getCapacidade(){
        return capacidade;
    }

    public int getTamanho(){
        return topo + 1;
    }

    public boolean estaCheia(){
        return topo == capacidade - 1;
    }

    public boolean estaVazia(){
        return topo == -1;
    }

    public Arquivo consulta(String nomeArquivo){
         if(estaVazia()) throw new RuntimeException("FALHA: Não foi possível encontrar o arquivo pois a pilha se encontra vazia.\n");
        else{
            for(int i = topo; i >= 0; i--){
                if(arquivos[i].getNomeArquivo().equals(nomeArquivo)){
                    System.out.println("Arquivo '" + nomeArquivo + "' encontrado:\n\t-Posição: " + (topo - i + 1) + "°\n\t-Horário de Solicitação: " + arquivos[i].getHorarioSolicitacaoFormatado() + "\n");
                    return arquivos[i];
                }
            }
            throw new RuntimeException("FALHA: Não foi possível encontrar '" + nomeArquivo + "' na pilha de reimpressão.\n");
        }
    }
    
    public Arquivo reimprimir(){
        if(estaVazia()) throw new RuntimeException("FALHA: Não foi possível reimprimir pois a pilha se encontra vazia.\n");
        else{
            Arquivo a = arquivos[topo];
            topo--;

            System.out.println("Reimprimindo " + a.toString());
            System.out.println("\t-Tempo decorrido desde solicitação inicial: " + a.getTempoDesdeSolicitacao() + "\n");
            return a;
        }
    }
    
    public void adicionar(Arquivo arquivo){
        if(estaCheia()) throw new RuntimeException("FALHA: Não foi possível adicionar o arquivo pois a pilha se encontra cheia.\n");
        else{
            topo++;
            arquivos[topo] = arquivo;
        }
    }

    @Override
    public String toString(){
        if(estaVazia()) return "Pilha de Reimpressão Emergencial:\n[\n\n]";
        String s = "Pilha de Reimpressão Emergencial:\n[\n";
        for(int i = topo; i >= 0; i --){
            s += "(" + (topo - i + 1) + "/" + getTamanho() + ") Arquivo " + arquivos[i].toString();
            if (i > 0) s += "\n\n";
        }
        return s + "\n]";
    }

}