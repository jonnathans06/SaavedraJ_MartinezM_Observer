package saavedraj_martinezm_decorador.controlador;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import saavedraj_martinezm_decorador.modelo.Cafe;
import saavedraj_martinezm_decorador.modelo.DecAzucar;
import saavedraj_martinezm_decorador.modelo.DecCrema;
import saavedraj_martinezm_decorador.modelo.Producto;
import saavedraj_martinezm_decorador.vista.OrdenVista;

public class OrdenController {
    private final OrdenVista oV;
    private List<Producto> listaProductos;
    private Producto cafe;

    public OrdenController(OrdenVista oV) {
        this.oV = oV;
        this.listaProductos = new ArrayList<>();
        controlarBotonesCafe();
    }
    
    public void controlarBotonesCafe() {
        // Crear café
        oV.getBtnCafe().addActionListener((e) -> {
            crearCafe();
            adicionalesCafe();
        });
        
        // Poner Azucar
        oV.getBtnAzucar().addActionListener((e) -> {
            añadirAzucar();
        });
    }
    
    public void crearCafe(){
        cafe = new Cafe();
        System.out.println("Bebida: " + cafe.getDescripcion() + " | Costo: " + cafe.getCosto());
    }
    
    public void añadirAzucar() {
        cafe = new DecAzucar(cafe);
        System.out.println("Bebida: " + cafe.getDescripcion() + " | Costo: " + cafe.getCosto());
    }
    
    public void añadirCrema (){
        
    }
    
    private void adicionalesCafe() {
        oV.getBtnAzucar().setEnabled(true);
        oV.getBtnCrema().setEnabled(true);
    }
    
    public void mostrarDetalleFactura(Producto producto) {
        DefaultTableModel modelo = (DefaultTableModel) oV.getTblFactura().getModel();
        
        Object[] fila = {
            producto.getDescripcion(),
            
        
        };
        
    }

}
