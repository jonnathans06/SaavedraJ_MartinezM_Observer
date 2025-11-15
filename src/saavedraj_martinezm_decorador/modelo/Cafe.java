package saavedraj_martinezm_decorador.modelo;

public class Cafe implements Producto{
    String descripcion;
    double costo;

    public Cafe() {
        this.descripcion = "Café";
        this.costo = 2.20;
    }

    @Override
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public double getCosto() {
        return costo;
    }
}
