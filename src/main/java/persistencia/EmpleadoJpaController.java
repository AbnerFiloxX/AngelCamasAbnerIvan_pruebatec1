
package persistencia;

import java.io.Serializable;




import logica.Empleado;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import java.util.List;

public class EmpleadoJpaController implements Serializable {

    private EntityManagerFactory emf;

    public EmpleadoJpaController() {
        emf = Persistence.createEntityManagerFactory("pruebatecnicafinalPU");
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Empleado empleado) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(empleado);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void edit(Empleado empleado) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            empleado = em.merge(empleado);
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception("Error al editar empleado", ex);
        } finally {
            em.close();
        }
    }

    public void destroy(int id) throws EntityNotFoundException {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Empleado empleado;
            try {
                empleado = em.getReference(Empleado.class, id);
                empleado.getId();  // Verifica si existe el empleado,ignoren mis comentarios por ahora
            } catch (EntityNotFoundException enfe) {
                throw new EntityNotFoundException("El empleado con ID " + id + " no se encuentra.");
            }
            em.remove(empleado);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public List<Empleado> findEmpleadoEntities() {
        return findEmpleadoEntities(true, -1, -1);
    }

    public List<Empleado> findEmpleadoEntities(int maxResults, int firstResult) {
        return findEmpleadoEntities(false, maxResults, firstResult);
    }

    private List<Empleado> findEmpleadoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT e FROM Empleado e");
            if (!all) {
                query.setMaxResults(maxResults);
                query.setFirstResult(firstResult);
            }
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public Empleado findEmpleado(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Empleado.class, id);
        } finally {
            em.close();
        }
    }

    public int getEmpleadoCount() {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT COUNT(e) FROM Empleado e");
            return ((Long) query.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
