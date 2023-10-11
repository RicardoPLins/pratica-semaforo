public class Amarelo implements StateSemaforo{
    
    @Override
    public void efetuarTransicao(Semaforo semaforo) {
        semaforo.setEstado("VERMELHO");
    }

    @Override
    public void showVisorRegressivo(Semaforo semaforo) {
        semaforo.showVisorRegressivo("AMARELO");
    }
}
