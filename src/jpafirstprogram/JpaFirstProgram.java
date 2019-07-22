package jpafirstprogram;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class JpaFirstProgram {

    public static void main(String[] args) {

        Person p = new Person("gp", "address", "1234");
        Person p2 = new Person("gkp", "address2", "5678");

        JpaFirstProgram jpa = new JpaFirstProgram();
        //jpa.persist(p);
        //jpa.persist(p2);
        jpa.updatePersonNameById(1,"George");
    }

    public void persist(Person p) {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("JpaFirstProgramPU");
        EntityManager em = emf.createEntityManager();
        //create transtaction
        //begin.transaction
        em.getTransaction().begin();
        try {
            em.persist(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
            //end transtaction
        }
        
    }
    public void updatePersonNameById(long id, String name){
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("JpaFirstProgramPU");
        EntityManager em = emf.createEntityManager();
        
        Person p = em.find(jpafirstprogram.Person.class, id);
        p.setName(name);
        em.getTransaction().begin();
        try {
            em.persist(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
            //end transtaction
        }
    }
    
    public void DeletePersonNameById(long id, String name){
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("JpaFirstProgramPU");
        EntityManager em = emf.createEntityManager();
        
        Person p = em.find(jpafirstprogram.Person.class, id);
        em.remove(p);
        em.getTransaction().begin();
        try {
            em.persist(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
            //end transtaction
        }
    }

}
