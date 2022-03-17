/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo;

import javax.swing.JOptionPane;

/**
 *
 * @author pablo
 */
public class Empleado {
    private String nombre;
    private String sexo;
    private String departamento;
    private int edad;
    private int tiempoTrabajado;

    public Empleado(String nombre, String sexo, String departamento, int edad, int tiempoTrabajado) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.departamento = departamento;
        this.edad = edad;
        this.tiempoTrabajado = tiempoTrabajado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getTiempoTrabajado() {
        return tiempoTrabajado;
    }

    public void setTiempoTrabajado(int tiempoTrabajado) {
        this.tiempoTrabajado = tiempoTrabajado;
    }
     public void borrarInformacionDelEmpleado()
     {
         this.nombre="";
         this.sexo="";
         this.departamento="";
         this.edad=0;
         this.tiempoTrabajado=0;
     }
    public void agregarInformacion(Empleado arrayEmpleados[])
    {
        for (int i = 0; i < arrayEmpleados.length; i++)
                {
                    nombre=JOptionPane.showInputDialog("Ingresa el nombre del empleado No "+(i+1));
                    
                    Object sexoSeleccionar = JOptionPane.showInputDialog(null, "Seleccione el sexo",
                            "Sexo", JOptionPane.QUESTION_MESSAGE, null,
                            new Object[]{"Hombre", "Mujer"}, "Seleccione");
                        sexo=sexoSeleccionar.toString();
                        
                    Object departamentoSeleccionar = JOptionPane.showInputDialog(null, "Seleccione el departamento",
                            "Sexo", JOptionPane.QUESTION_MESSAGE, null,
                            new Object[]{"Compras", "Contabilidad","Control de calidad","Ingenieria"}, "Seleccione");
                        departamento=departamentoSeleccionar.toString();
                        
                    do {                            
                        edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad (mayor a 17 y menor a 51)"));
                        } while (!(edad>=18 && edad<=50));
                    
                    do {                            
                        tiempoTrabajado = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la antiguedad (mayor o igual a cero)"));
                        } while ((0>=tiempoTrabajado));
                    
                    
                    arrayEmpleados[i] = new Empleado(nombre, sexo, departamento, edad, tiempoTrabajado);
                }
    }

    @Override
    public String toString() {
        return "Empleado{" + "nombre=" + nombre + ", sexo=" + sexo + ", departamento=" + departamento + ", edad=" + edad + ", tiempoTrabajado=" + tiempoTrabajado + '}';
    }
    
    
}
