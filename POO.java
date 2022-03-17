/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poo;

import javax.swing.JOptionPane;
import poo.Empleado;

/**
 *
 * @author pablo
 */
public class POO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // saber con cuantos empleados voy a trabajar
        int numDeEmpleados;
        int menu;

        //declaracion de variables para mi objeto
        String nombre, sexo, departamento;
        int edad, tiempoTrabajado;
        //ingresamos el numero de empleados con los que vamos a trabajar
        do {
            numDeEmpleados = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero de empleados (MAYOR A CERO)"));
        } while ((1 > numDeEmpleados));

        //Creamos un array de objetos de la clase empleados
        Empleado[] arrayEmpleados = new Empleado[numDeEmpleados];
        do {
            //mostramos el menu
            menu = Integer.parseInt(JOptionPane.showInputDialog(null, "Elija la opcion\n"
                    + "1.Agregar datos a los empleados\n"
                    + "2.Eliminar informacion del empleado\n"
                    + "3.Promedio de edad por sexo\n"
                    + "4.Promedio de antiguedad de acuerdo a cierto número de años\n"
                    + "5.Empleado con mayor antiguedad\n"
                    + "6.Porcentaje por area\n"
                    + "7.Mostrar todos los empleados\n"
                    + "8.Salir"));

            switch (menu) {
                case 1:
                    //+ "1.Agregar datos a los empleados\n"
                    for (int i = 0; i < arrayEmpleados.length; i++) {
                        nombre = JOptionPane.showInputDialog("Ingresa el nombre del empleado No " + (i + 1));

                        Object sexoSeleccionar = JOptionPane.showInputDialog(null, "Seleccione el sexo",
                                "Sexo", JOptionPane.QUESTION_MESSAGE, null,
                                new Object[]{"Hombre", "Mujer"}, "Seleccione");
                        sexo = sexoSeleccionar.toString();

                        Object departamentoSeleccionar = JOptionPane.showInputDialog(null, "Seleccione el departamento",
                                "Departamendo", JOptionPane.QUESTION_MESSAGE, null,
                                new Object[]{"Compras", "Contabilidad", "Control de calidad", "Ingenieria"}, "Seleccione");
                        departamento = departamentoSeleccionar.toString();

                        do {
                            edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad (mayor a 17 y menor a 51)"));
                        } while (!(edad >= 18 && edad <= 50));

                        do {
                            tiempoTrabajado = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la antiguedad (mayor o igual a cero)"));
                        } while ((0 >= tiempoTrabajado));

                        arrayEmpleados[i] = new Empleado(nombre, sexo, departamento, edad, tiempoTrabajado);
                    }
                    break;
                case 2:
                    //+ "2.Eliminar informacion del empleado\n"
                    int empleadoABorrar;
                    empleadoABorrar = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el número de empleado a borrar"));
                    JOptionPane.showMessageDialog(null, "Usted va a borrar la informacion del empleado \n" + arrayEmpleados[empleadoABorrar].toString());
                    arrayEmpleados[empleadoABorrar].borrarInformacionDelEmpleado();
                    break;
                case 3:
                    //"3.Promedio de edad por sexo\n"
                    double promedioEdadHombres = 0;
                    double promedioEdadMujeres = 0;
                    int cantidadDeHombres = 0,
                     cantidadDeMujeres = 0;
                    Object sexoSeleccionar = JOptionPane.showInputDialog(null, "Seleccione el sexo a consultar promedio",
                            "Sexo", JOptionPane.QUESTION_MESSAGE, null,
                            new Object[]{"Hombre", "Mujer"}, "Seleccione");
                    if (sexoSeleccionar.toString() == "Hombre") {
                        for (int i = 0; i < arrayEmpleados.length; i++) {
                            if (arrayEmpleados[i].getSexo() == "Hombre") {
                                promedioEdadHombres = promedioEdadHombres + arrayEmpleados[i].getEdad();
                                cantidadDeHombres++;
                            }
                        }
                        promedioEdadHombres = promedioEdadHombres / cantidadDeHombres;
                        JOptionPane.showMessageDialog(null, "El promedio de la edad de los hombres es " + promedioEdadHombres);
                    } else {
                        for (int i = 0; i < arrayEmpleados.length; i++) {
                            if (arrayEmpleados[i].getSexo() == "Mujer") {
                                promedioEdadMujeres = promedioEdadMujeres + arrayEmpleados[i].getEdad();
                                cantidadDeMujeres++;
                            }
                        }
                        promedioEdadMujeres = promedioEdadMujeres / cantidadDeMujeres;
                        JOptionPane.showMessageDialog(null, "El promedio de la edad de las mujeres es " + promedioEdadMujeres);
                    }
                    break;
                case 4:
                    //"4.Promedio de antiguedad de acuerdo a cierto número de años\n"
                    double promedioTiempoTrabajado = 0;
                    int contadorEmpleados = 0;
                    do {
                        tiempoTrabajado = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la antiguedad (mayor o igual a cero) para obtener el promedio de esta en la empresa"));
                    } while ((0 >= tiempoTrabajado));
                    for (int i = 0; i < arrayEmpleados.length; i++) {
                        if (arrayEmpleados[i].getTiempoTrabajado() >= tiempoTrabajado) {
                            promedioTiempoTrabajado = promedioTiempoTrabajado + arrayEmpleados[i].getTiempoTrabajado();
                            contadorEmpleados++;
                        }
                    }
                    promedioTiempoTrabajado = promedioTiempoTrabajado / contadorEmpleados;
                    JOptionPane.showMessageDialog(null, "EL PROMEDIO DE ANTIGUEDAD MAYOR  O IGUAL A " + tiempoTrabajado + " es de " + promedioTiempoTrabajado);
                    break;
                case 5:
                    //+ "5.Empleado con mayor antiguedad\n"
                    int mayorAntiguedad = arrayEmpleados[0].getTiempoTrabajado();
                    int indiceDeMayorAntiguedad = 0;
                    for (int i = 0; i < arrayEmpleados.length; i++) {
                        if (mayorAntiguedad <= arrayEmpleados[i].getTiempoTrabajado()) {
                            mayorAntiguedad=arrayEmpleados[i].getTiempoTrabajado();
                            indiceDeMayorAntiguedad = i;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "DATOS DEL EMPELADO CON MAYOR ANTIGUEDAD\n"
                            + "NOMBRE " + arrayEmpleados[indiceDeMayorAntiguedad].getNombre() + "\n"
                            + "EDAD " + arrayEmpleados[indiceDeMayorAntiguedad].getEdad() + "\n"
                            + "ANTIGUEDAD " + arrayEmpleados[indiceDeMayorAntiguedad].getTiempoTrabajado());
                    break;
                case 6:
                    //+ "6.Porcentaje por area\n"
                    double cantidadEmpleadosCompras = 0;
                    double cantidadEmpleadosContabilidad = 0;
                    double cantidadEmpleadosControl = 0;
                    double cantidadEmpleadosIngenieria = 0;
                    for (int i = 0; i < arrayEmpleados.length; i++) {
                        if (arrayEmpleados[i].getDepartamento() == "Compras") {
                            cantidadEmpleadosCompras++;
                        } else if (arrayEmpleados[i].getDepartamento() == "Contabilidad") {
                            cantidadEmpleadosContabilidad++;
                        } else if (arrayEmpleados[i].getDepartamento() == "Control") {
                            cantidadEmpleadosControl++;
                        } else //ingenieria
                        {
                            cantidadEmpleadosIngenieria++;
                        }
                    }
                    //calculando porcentaje
                    cantidadEmpleadosCompras = (100 / arrayEmpleados.length) * cantidadEmpleadosCompras;
                    cantidadEmpleadosContabilidad = (100 / arrayEmpleados.length) * cantidadEmpleadosContabilidad;
                    cantidadEmpleadosControl = (100 / arrayEmpleados.length) * cantidadEmpleadosControl;
                    cantidadEmpleadosIngenieria = (100 / arrayEmpleados.length) * cantidadEmpleadosIngenieria;

                    JOptionPane.showMessageDialog(null, "PORCENTAJE DE EMPLEADOS EN COMPRAS " + cantidadEmpleadosCompras + "\n"
                            + "PORCENTAJE DE EMPLEADOS EN CONTABILIDAD " + cantidadEmpleadosContabilidad + "\n"
                            + "PORCENTAJE DE EMPLEADOS EN CONTROL " + cantidadEmpleadosControl + "\n"
                            + "PORCENTAJE DE EMPLEADOS EN INGENIERIA " + cantidadEmpleadosIngenieria);
                    break;
                case 7:
                    //+ "7.Mostrar todos los empleados\n"
                    String salidaDeDatos = "";
                    for (int i = 0; i < arrayEmpleados.length; i++) {
                        salidaDeDatos = salidaDeDatos + arrayEmpleados[i].toString() + "\n";
                    }
                    JOptionPane.showMessageDialog(null, salidaDeDatos);
                    break;
                default:
                    break;
            }
        } while (menu != 8);
    }

}
