public class Main {

    public static void main(String[] args) {
        Semaforo epitacio = new Semaforo("12356");

        System.out.println("Estado Atual: " + epitacio.getEstadoAtual());
        System.out.println("Significado : " + getAcao(epitacio.getEstadoAtual()));
        //epitacio.exibir();

        epitacio.start(10);

        System.out.println("Fim da simulação.");

        System.out.println(epitacio);
    }

    public static String getAcao(String estado) {
        switch (estado) {
            case "VERMELHO":
                return "Pare";
            case "AMARELO":
                return "Atenção";
            case "VERDE":
                return "Siga";
            default:
                throw new IllegalArgumentException("Estado inválido do semáforo");
        }
    }
}
