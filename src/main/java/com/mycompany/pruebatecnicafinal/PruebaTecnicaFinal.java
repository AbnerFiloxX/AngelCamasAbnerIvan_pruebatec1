
package com.mycompany.pruebatecnicafinal;



import logica.Empleado;

import java.util.Scanner;

import java.util.List;
import persistencia.ControladoraPersistencia;


public class PruebaTecnicaFinal {

    public static void main(String[] args) {
        // es lo que crea el controlador de empleados
        ControladoraPersistencia controlador = new ControladoraPersistencia();
        //EmpleadoJpaController controlador = new EmpleadoJpaController();
        Scanner scanner = new Scanner(System.in);
        int opcion;
        
        do {
           
            System.out.println("****************************************");
            System.out.println("           Menú de Gestión de Empleados");
            System.out.println("****************************************");
            System.out.println("1) Alta");
            System.out.println("2) Baja");
            System.out.println("3) Consulta");
            System.out.println("4) Modificacion");
            System.out.println("5) Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:// Alta de empleado
                    System.out.print("Nombre: ");
                    String nombre = scanner.next();
                    System.out.print("Apellido: ");
                    String apellido = scanner.next();
                    System.out.print("Cargo: ");
                    String cargo = scanner.next();
                    System.out.print("Salario: ");
                    double salario = scanner.nextDouble();
                    
                    
                    Empleado nuevoEmpleado = new Empleado(nombre, apellido, cargo, salario);
                    try {
                        controlador.crearEmpleado(nuevoEmpleado);  // Llamada que puede lanzar Exception
                        System.out.println("Empleado agregado correctamente.");
                    } catch (Exception e) {
                        System.out.println("Error al agregar el empleado: " + e.getMessage());
                    }
                    break;
                case 2:// Baja de empleado
                    System.out.print("ID del empleado a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    try {
                        controlador.borrarEmpleado(idEliminar);  // Llamada que puede lanzar Exception
                        System.out.println("Empleado eliminado correctamente.");
                    } catch (Exception e) {
                        System.out.println("Error al eliminar el empleado: " + e.getMessage());
                    }
                    break;
                case 3:// Consulta de empleados
                    List<Empleado> empleados = controlador.traerEmpleados();
                    for (Empleado emp : empleados) {
                        System.out.println(emp.toString());  // Imprimir información de cada empleado
                    }
                    break;
                case 4:// Modificación de empleado
                    System.out.print("ID del empleado a modificar: ");
                    int idModificar = scanner.nextInt();
                    try {
                        Empleado empleadoModificar = controlador.traerEmpleado(idModificar);
                        if (empleadoModificar != null) {
                            System.out.print("Nuevo nombre: ");
                            empleadoModificar.setNombre(scanner.next());
                            System.out.print("Nuevo apellido: ");
                            empleadoModificar.setApellido(scanner.next());
                            System.out.print("Nuevo cargo: ");
                            empleadoModificar.setCargo(scanner.next());
                            System.out.print("Nuevo salario: ");
                            empleadoModificar.setSalario(scanner.nextDouble());
                            
                            controlador.modificarEmpleado(empleadoModificar);  // Llamada que puede lanzar Exception
                            System.out.println("Empleado modificado correctamente.");
                        } else {
                            System.out.println("Empleado no encontrado.");
                        }
                    } catch (Exception e) {
                        System.out.println("Error al modificar el empleado: " + e.getMessage());
                    }
                    break;
                case 5://pues salir 
                    System.out.println("Saliendo de la aplicacion...");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}
