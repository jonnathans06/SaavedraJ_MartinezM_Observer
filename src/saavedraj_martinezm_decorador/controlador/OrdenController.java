package saavedraj_martinezm_decorador.controlador;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import saavedraj_martinezm_decorador.modelo.Cafe;
import saavedraj_martinezm_decorador.modelo.DecAzucar;
import saavedraj_martinezm_decorador.modelo.DecCrema;
import saavedraj_martinezm_decorador.modelo.DecPollo;
import saavedraj_martinezm_decorador.modelo.DecTomate;
import saavedraj_martinezm_decorador.modelo.DecVinagreta;
import saavedraj_martinezm_decorador.modelo.Ensalada;
import saavedraj_martinezm_decorador.modelo.Producto;
import saavedraj_martinezm_decorador.vista.OrdenVista;

public class OrdenController {
    private final OrdenVista oV;
    private List<Producto> listaProductos;
    private Producto cafe;
    private Producto ensalada;
    private boolean tieneAzucar = false;
    private boolean tieneCrema = false;
    private boolean tieneTomate = false;
    private boolean tieneVinagreta = false;
    private boolean tienePollo = false;
    private List adCafe;
    private List adEnsalada;
    private double subTotal = 0;

    public OrdenController(OrdenVista oV) {
        this.oV = oV;
        this.listaProductos = new ArrayList<>();
        this.adCafe = new ArrayList();
        this.adEnsalada = new ArrayList();
        setColorBotonesDescativados();
        controlarBotonesCafe();
        controlarBotonesEnsalada();
        controlarBotonesFactura();
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
        
        // Poner Crema
        oV.getBtnCrema().addActionListener((e) -> {
            añadirCrema();
        });
        
    }
    
    public void controlarBotonesEnsalada() {
        // Crear Ensalada
        oV.getBtnEnsalada().addActionListener((e) -> {
            crearEnsalada();
            adicionalesEnsalada();
        });
        
        // Poner Tomate
        oV.getBtnTomate().addActionListener((e) -> {
            añadirTomate();
        });
        
        // Poner Vinagreta
        oV.getBtnVinagreta().addActionListener((e) -> {
            añadirVinagreta();
        });
        
        // Poner Pollo
        oV.getBtnPollo().addActionListener((e) -> {
            añadirPollo();
        });
    }
    
    public void controlarBotonesFactura(){
        oV.getBtnAñadirCafe().addActionListener((e) -> {
            añadirCafeFactura();
            oV.getBtnAñadirCafe().setEnabled(false);
            setColorBotonesDescativados();
        });
        
        oV.getBtnAñadirEnsalada().addActionListener((e) -> {
            añadirEnsaladaFactura();
            oV.getBtnAñadirEnsalada().setEnabled(false);
            setColorBotonesDescativados();
        });
    }
    
    public void crearCafe(){
        int opcion = JOptionPane.showConfirmDialog(oV, "¿Desea añadir a la su orden un café?", 
                                                        "Confirmación", JOptionPane.YES_NO_OPTION);
        
        if (opcion == JOptionPane.YES_OPTION) {
            cafe = new Cafe();
            System.out.println("Bebida: " + cafe.getDescripcion() + " | Costo: " + cafe.getCosto());
        }
    }
    
    public void añadirAzucar() {
        
        if (tieneAzucar) {
            JOptionPane.showMessageDialog(oV, "Ya se añadió azúcar a este café");
        } else {
            int opcion = JOptionPane.showConfirmDialog(oV, "¿Desea añadir azúcar a este café?", 
                                                            "Confirmación", JOptionPane.YES_NO_OPTION);

            if (opcion == JOptionPane.YES_OPTION) {
                cafe = new DecAzucar(cafe);
                adCafe.add("Azucar");
                tieneAzucar = true;
                System.out.println("Bebida: " + cafe.getDescripcion() + " | Costo: " + cafe.getCosto());
            }
        }
    }
    
    public void añadirCrema() {
        if (tieneCrema) {
            JOptionPane.showMessageDialog(oV, "Ya se añadió crema a este café");
        } else {
            int opcion = JOptionPane.showConfirmDialog(oV, "¿Desea añadir crema a este café?", 
                                                            "Confirmación", JOptionPane.YES_NO_OPTION
            );

            if (opcion == JOptionPane.YES_OPTION) {
                cafe = new DecCrema(cafe);
                adCafe.add("Crema");
                tieneCrema = true;
                System.out.println("Bebida: " + cafe.getDescripcion() + " | Costo: " + cafe.getCosto());
            }
        }
    }
    
    public void añadirCafeFactura(){
        try {
            listaProductos.add(cafe);
            subTotal = subTotal + cafe.getCosto();
            DefaultTableModel modelo = (DefaultTableModel) oV.getTblFactura().getModel();
            String adicionales;
        
            if (adCafe.isEmpty()) {
                adicionales = "No";
            } else {
                adicionales = adCafe.toString();
            }
            
            Object[] fila = {
                "Cafe",
                adicionales,
                String.format("%.2f", cafe.getCosto()),
                String.format("%.2f", subTotal)
            };
            modelo.addRow(fila);
            
            oV.getTxtPrecio().setText("Total a pagar: " + subTotal + "$");
        
            cafe = null;
            tieneAzucar = false;
            tieneCrema = false;
            adCafe.clear();
            adicionales = adCafe.toString();
            bloquearTodosAdicionales();
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(oV, "No ha seleccionado nada aún");
        } 
    }
    
    public void adicionalesCafe() {
        Color verde = new Color (95, 203, 113);
        
        oV.getBtnAñadirCafe().setEnabled(true);
        oV.getBtnAñadirCafe().setBackground(verde);
        oV.getBtnAzucar().setEnabled(true);
        oV.getBtnCrema().setEnabled(true);
        oV.getBtnEnsalada().setEnabled(false);
        oV.getBtnPeperoni().setEnabled(false);
        oV.getBtnPizza().setEnabled(false);
        oV.getBtnPollo().setEnabled(false);
        oV.getBtnQueso().setEnabled(false);
        oV.getBtnSalami().setEnabled(false);
        oV.getBtnVinagreta().setEnabled(false);
    }
    
    public void crearEnsalada() {
        int opcion = JOptionPane.showConfirmDialog(oV, "¿Desea añadir a su orden una ensalada?",
                                                        "Confirmación",JOptionPane.YES_NO_OPTION
        );

        if (opcion == JOptionPane.YES_OPTION) {
            ensalada = new Ensalada();
            System.out.println("Ensalada: " + ensalada.getDescripcion() + " | Costo: " + ensalada.getCosto());
        }
    }
    
    public void añadirTomate() {
        if (tieneTomate) {
            JOptionPane.showMessageDialog(oV, "Ya se añadió tomate a esta ensalada");
        } else {
            int opcion = JOptionPane.showConfirmDialog(oV, "¿Desea añadir tomate a esta ensalada?", 
                                                            "Confirmación", JOptionPane.YES_NO_OPTION);

            if (opcion == JOptionPane.YES_OPTION) {
                ensalada = new DecTomate(ensalada);
                adEnsalada.add("Tomate");
                tieneTomate = true;
                System.out.println("Ensalda: " + ensalada.getDescripcion() + " | Costo: " + ensalada.getCosto());
            }
        }
    }
    
    public void añadirVinagreta() {
        if (tieneVinagreta) {
            JOptionPane.showMessageDialog(oV, "Ya se añadió vinagreta a esta ensalada");
        } else {
            int opcion = JOptionPane.showConfirmDialog(oV, "¿Desea añadir vinagreta a esta ensalada?", 
                                                            "Confirmación", JOptionPane.YES_NO_OPTION);

            if (opcion == JOptionPane.YES_OPTION) {
                ensalada = new DecVinagreta(ensalada);
                adEnsalada.add("Vinagreta");
                tieneVinagreta = true;
                System.out.println("Ensalada: " + ensalada.getDescripcion() + " | Costo: " + ensalada.getCosto());
            }
        }
    }
    
    public void añadirPollo() {
        if (tienePollo) {
            JOptionPane.showMessageDialog(oV, "Ya se añadió pollo a esta ensalada");
        } else {
            int opcion = JOptionPane.showConfirmDialog(oV, "¿Desea añadir pollo a esta ensalada?", 
                                                            "Confirmación", JOptionPane.YES_NO_OPTION);

            if (opcion == JOptionPane.YES_OPTION) {
                ensalada = new DecPollo(ensalada);
                adEnsalada.add("Pollo");
                tienePollo = true;
                System.out.println("Ensalada: " + ensalada.getDescripcion() + " | Costo: " + ensalada.getCosto());
            }
        }
    }
    
    public void añadirEnsaladaFactura() {
        try {
            listaProductos.add(ensalada);
            subTotal = subTotal + ensalada.getCosto();
            DefaultTableModel modelo = (DefaultTableModel) oV.getTblFactura().getModel();
            String adicionales;
        
            if (adEnsalada.isEmpty()) {
                adicionales = "No";
            } else {
                adicionales = adEnsalada.toString();
            }
            
            Object[] fila = {
                "Ensalada",
                adicionales,
                String.format("%.2f", ensalada.getCosto()),
                String.format("%.2f", subTotal)
            };
            modelo.addRow(fila);
            
            oV.getTxtPrecio().setText("Total a pagar: " + subTotal + "$");
        
            ensalada = null;
            tieneTomate = false;
            tieneVinagreta = false;
            tienePollo = false;
            adEnsalada.clear();
            adicionales = adEnsalada.toString();
            bloquearTodosAdicionales();
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(oV, "No ha seleccionado nada aún");
        }
    }
    
    public void adicionalesEnsalada() {
        Color verde = new Color (95, 203, 113);
        oV.getBtnAñadirEnsalada().setBackground(verde);
        oV.getBtnAñadirEnsalada().setEnabled(true);
        
        oV.getBtnAñadirCafe().setEnabled(false);
        oV.getBtnCafe().setEnabled(false);
        oV.getBtnAzucar().setEnabled(false);
        oV.getBtnCrema().setEnabled(false);
        oV.getBtnPeperoni().setEnabled(false);
        oV.getBtnPizza().setEnabled(false);
        oV.getBtnPollo().setEnabled(true);
        oV.getBtnTomate().setEnabled(true);
        oV.getBtnQueso().setEnabled(false);
        oV.getBtnSalami().setEnabled(false);
        oV.getBtnVinagreta().setEnabled(true);
    }

    public void bloquearTodosAdicionales() {
        oV.getBtnCafe().setEnabled(true);
        oV.getBtnAzucar().setEnabled(false);
        oV.getBtnCrema().setEnabled(false);
        oV.getBtnEnsalada().setEnabled(true);
        oV.getBtnPeperoni().setEnabled(false);
        oV.getBtnPizza().setEnabled(true);
        oV.getBtnPollo().setEnabled(false);
        oV.getBtnQueso().setEnabled(false);
        oV.getBtnSalami().setEnabled(false);
        oV.getBtnVinagreta().setEnabled(false);
        oV.getBtnTomate().setEnabled(false);
    }
    
    public void setColorBotonesDescativados() {
        Color gris = new Color (178, 178, 178);
        oV.getBtnAñadirCafe().setBackground(gris);
        oV.getBtnAñadirPizza().setBackground(gris);
        oV.getBtnAñadirEnsalada().setBackground(gris);
    }

}