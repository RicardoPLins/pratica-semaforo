class Vermelho implements StateSemaforo {
    @Override
    public void efetuarTransicao(Semaforo semaforo) {
        semaforo.setEstado("VERDE");
    }

    @Override
    public void showVisorRegressivo(Semaforo semaforo) {
        semaforo.showVisorRegressivo("VERMELHO");
    }
}