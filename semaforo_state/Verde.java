public class Verde implements StateSemaforo{
    
    @Override
    public void efetuarTransicao(Semaforo semaforo) {
        semaforo.setEstado("AMARELO");
    }

    @Override
    public void showVisorRegressivo(Semaforo semaforo) {
        semaforo.showVisorRegressivo("VERDE");
    }
}
