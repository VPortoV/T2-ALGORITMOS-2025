/*
 _________________________________________
/                                         \
| Bruno Nogueira Asevedo Souza | 23.00313-8|
| Henrique Nalin de Oliveira   | 24.01883-0|
| Leonardo Tedeschi Belo       | 24.00262-3|
| Vítor Porto Vincenzi         | 24.00431-6|
\__________________________________________/
 
 */
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;

public class Arquivo{
    private String nomeArquivo;
    private String nomeUsuario;

    private LocalDateTime horarioSolicitacao; 

    public Arquivo(String nomeArquivo, String nomeUsuario){
        this.nomeArquivo = nomeArquivo;
        this.nomeUsuario = nomeUsuario;
        this.horarioSolicitacao = LocalDateTime.now();
    }
    
    public Arquivo(String nomeArquivo, String nomeUsuario, LocalDateTime horarioSolicitacao){
        this.nomeArquivo = nomeArquivo;
        this.nomeUsuario = nomeUsuario;
        this.horarioSolicitacao= horarioSolicitacao;
    }

    public String getNomeArquivo(){
        return nomeArquivo;
    }

    public String getNomeUsuario(){
        return nomeUsuario;
    }

    public LocalDateTime getHorarioSolicitacao(){
        return horarioSolicitacao;
    }

    public String getHorarioSolicitacaoFormatado(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss:SSS - dd/MM/yyyy");
        return horarioSolicitacao.format(formatter);
    }

    public String getTempoDesdeSolicitacao(){
        Duration d = Duration.between(horarioSolicitacao, LocalDateTime.now());
    
        return String.format("%02d:%02d:%02d:%02d", d.toHours(), d.toMinutes()%60, d.toSeconds()% 60, d.toMillis()%1000);
    }

    @Override
    public String toString(){
        return "'" + nomeArquivo + "':\n\t-Usuário: " + nomeUsuario + "\n\t-Horário de Solicitação: " + getHorarioSolicitacaoFormatado();
    }
}