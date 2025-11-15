package saavedraj_martinezm_decorador.modelo;

public class DecVinagreta extends DecoradorEnsalada{

    public DecVinagreta(Producto ensalada) {
        super(ensalada);
    }

    @Override
    public double getCosto() {
        return super.getCosto() + 0.5; 
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " + Vinagreta"; 
    }
}
