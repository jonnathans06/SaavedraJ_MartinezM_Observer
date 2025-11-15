package saavedraj_martinezm_decorador.modelo;

public class DecTomate extends DecoradorEnsalada{

    public DecTomate(Producto ensalada) {
        super(ensalada);
    }

    @Override
    public double getCosto() {
        return super.getCosto() + 1.10;
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " + Tomate";
    }
}
