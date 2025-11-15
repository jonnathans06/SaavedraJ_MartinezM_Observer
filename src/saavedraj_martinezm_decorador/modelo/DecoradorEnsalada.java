package saavedraj_martinezm_decorador.modelo;

public abstract class DecoradorEnsalada implements Producto{
    private Producto ensalada;

    public DecoradorEnsalada(Producto ensalada) {
        this.ensalada = ensalada;
    }
    
    @Override
    public String getDescripcion() {
        return ensalada.getDescripcion();
    }

    @Override
    public double getCosto() {
        return ensalada.getCosto();
    }
}
