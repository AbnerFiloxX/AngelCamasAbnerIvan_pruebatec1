/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Empleado;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author satel
 */
public class ControladoraPersistencia {
    EmpleadoJpaController empleadoJpa = new EmpleadoJpaController();
    
     public void crearEmpleado(Empleado emple) {
        empleadoJpa.create(emple);
    }
      
       
    public Empleado traerEmpleado(int id) {
        return empleadoJpa.findEmpleado(id);
    }
    
    public List<Empleado> traerEmpleados() {
        return empleadoJpa.findEmpleadoEntities();
    }
    
    public void modificarEmpleado(Empleado emple) {
        try {
            empleadoJpa.edit(emple);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Borrar empleado (D)
    public void borrarEmpleado(int id) {
        try {
            empleadoJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
