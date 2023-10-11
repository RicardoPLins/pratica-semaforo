import java.util.HashMap;
import java.util.Map;

public class Semaforo {
    private StateSemaforo estadoAtual;
    private String numTombamento;
    private Map<String, Integer> transicao = new HashMap<>();

    public Semaforo(String numTombamento) {
        this.numTombamento = numTombamento;
        // tempo de transicao em segundos
        transicao.put("VERMELHO", 3);
        transicao.put("AMARELO", 1);
        transicao.put("VERDE", 5);
        estadoAtual = new Vermelho();
    }
    public String getNumTombamento() {
        return numTombamento;
    }

    public void setNumTombamento(String numTombamento) {
        this.numTombamento = numTombamento;
    }

    public void setEstado(String estado) {
        switch (estado) {
            case "VERMELHO":
                estadoAtual = new Vermelho();
                break;
            case "AMARELO":
                estadoAtual = new Amarelo();
                break;
            case "VERDE":
                estadoAtual = new Verde();
                break;
            default:
                throw new IllegalArgumentException("Estado inválido do semáforo");
        }
    }

    public void efetuarTransicao() {
        estadoAtual.efetuarTransicao(this);
    }

    public void showVisorRegressivo(String string) {
        for (int i = transicao.get(string); i > 0; i--) {
            System.out.println(i + " segundo(s)");
            try {
                Thread.sleep(1000); // 1000 milissegundos equivale a 1 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void start(int time_in_seconds) {
        while (time_in_seconds > 0) {
            System.out.println("Tempo restante da simulacao: " + time_in_seconds + " segundos");
            System.out.println(getEstadoAtual() + " : " + transicao.get(getEstadoAtual()) + " segundos.");
            efetuarTransicao();
            showVisorRegressivo(getEstadoAtual());
            time_in_seconds -= transicao.get(getEstadoAtual());
            System.out.println();
        }
    }

    public String getEstadoAtual() {
        if (estadoAtual instanceof Vermelho) {
            return "VERMELHO";
        } else if (estadoAtual instanceof Amarelo) {
            return "AMARELO";
        } else {
            return "VERDE";
        }
    }
    

    public String toString() {
        String s = "";
        s += "Numero Tombamento: " + numTombamento + "\n";
        s += "Tempo de permanencia em cada estagio:\n";
        s += "VERMELHO : " + transicao.get("VERMELHO") + " segundos\n";
        s += "AMARELO  : " + transicao.get("AMARELO") + " segundos\n";
        s += "VERDE    : " + transicao.get("VERDE") + " segundos\n";
        return s;
    }
    
}