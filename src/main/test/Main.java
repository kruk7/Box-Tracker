import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

public class Main
{
    @PersistenceUnit(name = "DB-BoxTracker-pers-unit")
    static EntityManagerFactory emf;


    public static void main(String[] args)
    {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        tx.commit();
        em.close();

    }
}
