package saavedraj_martinezm_observerpractica;

import saavedraj_martinezm_observerpractica.controlador.OrdenController;
import saavedraj_martinezm_observerpractica.vista.OrdenVista;

public class Main {

    public static void main(String[] args) {
        OrdenVista oV = new OrdenVista();
        OrdenController oC = new OrdenController(oV);
    }

}
