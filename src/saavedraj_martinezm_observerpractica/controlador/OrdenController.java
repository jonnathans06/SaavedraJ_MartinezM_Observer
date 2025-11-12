package saavedraj_martinezm_observerpractica.controlador;

import saavedraj_martinezm_observerpractica.vista.OrdenVista;

public class OrdenController {
    private final OrdenVista oV;

    public OrdenController(OrdenVista oV) {
        this.oV = oV;
        mostrarDetalle();
        cargarCantidadDetalle();
    }
    
    public void mostrarDetalle(){
        
        // Mostrar Ensala en TextArea
        oV.getBtnEnsalada().addActionListener((e) -> {
            oV.cargarDetalle("Ensalada");
        });
        
        // Mostrar Hamburguesa en TextArea
        oV.getBtnHamburguesa().addActionListener((e) -> {
            oV.cargarDetalle("Hamburguesa");
        });
        
        // Mostrar Papas en TextArea
        oV.getBtnPapas().addActionListener((e) -> {
            oV.cargarDetalle("Papas");
        });
    }
    
    public void cargarCantidadDetalle(){
        oV.getBtnEnter().addActionListener((e) -> {
            String textoNuevo = " Cantidad: " + oV.getTxtCantidad().getText();
            oV.getTxtDetalle().append(textoNuevo + "\n");
            oV.getTxtDetalle().append("-". repeat(100) + "\n");
            oV.getTxtCantidad().setText("");
        });
    }
}
