package saavedraj_martinezm_decorador;

import saavedraj_martinezm_decorador.controlador.OrdenController;
import saavedraj_martinezm_decorador.vista.OrdenVista;

public class Main {

    public static void main(String[] args) {
        OrdenVista oV = new OrdenVista();
        OrdenController oC = new OrdenController(oV);
    }

}
