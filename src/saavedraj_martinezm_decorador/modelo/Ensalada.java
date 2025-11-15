package saavedraj_martinezm_decorador.modelo;

public class Ensalada implements Producto{
    String descripcion;
    double costo;

    public Ensalada() {
        this.descripcion = "Ensalada";
        this.costo = 3;
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
