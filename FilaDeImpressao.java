/*
 _________________________________________
/                                         \
| Bruno Nogueira Asevedo Souza | 23.00313-8|
| Henrique Nalin de Oliveira   | 24.01883-0|
| Leonardo Tedeschi Belo       | 24.00262-3|
| Vítor Porto Vincenzi         | 24.00431-6|
\__________________________________________/
 
 */
public class FilaDeImpressao {
    Arquivo[] dados;
    int primeiro, ultimo, ocupacao;
    public FilaDeImpressao (int capacidade) {
        primeiro = 0;
        ultimo = 0;
        ocupacao = 0;
        dados = new Arquivo[capacidade];
    }

    public boolean estaVazia() {
        return ocupacao == 0;
    }
    public boolean estaCheia() {
        return ocupacao == dados.length;
    }
    private int proximaPosicao (int posicao) {
        return (posicao + 1) % dados.length;
    }
    public void enfileira (Arquivo a) {
        if (estaCheia()) throw new RuntimeException("FALHA: Não foi possível inserir o arquivo na fila pois ela se encontra cheia.");
        dados[ultimo] = a;
        ultimo = proximaPosicao(ultimo);
        ocupacao++;
    }
    public Arquivo imprimir() {
        if (estaVazia()) throw new RuntimeException("FALHA: Não foi possível imprimir o arquivo da fila pois ela está vazia.");
        Arquivo a = dados[primeiro];
        primeiro = proximaPosicao(primeiro);
        ocupacao--;
        System.out.println("Imprimindo " + a.toString() + "\n");
        return a;
    }
    @Override
    public String toString() {
        if (estaVazia()) return "Fila de Impressão:\n[\n\n]";
        String s = "Fila de Impressão:\n[\n";
        for (int i=primeiro, cont=0; cont<ocupacao; i=proximaPosicao(i), cont++) {
            s += "(" + (cont + 1) + "/" + ocupacao + ") Arquivo " + dados[i];
            if (cont < ocupacao - 1) s += "\n\n";
        }
        return s + "\n]";
    }
}