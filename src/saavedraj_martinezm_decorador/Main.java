package saavedraj_martinezm_decorador;

import saavedraj_martinezm_decorador.controlador.OrdenController;
import saavedraj_martinezm_decorador.modelo.Cafe;
import saavedraj_martinezm_decorador.modelo.DecCrema;
import saavedraj_martinezm_decorador.vista.OrdenVista;
import saavedraj_martinezm_decorador.modelo.Producto;

public class Main {

    public static void main(String[] args) {
        OrdenVista oV = new OrdenVista();
        OrdenController oC = new OrdenController(oV);
    }

}
