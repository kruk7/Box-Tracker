package dao;

import model.Box;
import model.Coordinates;
import model.User;

import javax.persistence.*;
import java.util.List;

public class DaoImplement implements DaoInterface
{
    @PersistenceUnit(name = "DB-BoxTracker-pers-unit")
    static EntityManagerFactory emf;
    private EntityManager em;

    @Override
    public void addUser(User user)
    {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(user);
        tx.commit();
        em.close();
    }

    @Override
    public void addBox(Box box)
    {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(box);
        tx.commit();
        em.close();
    }

    @Override
    public void addCoordinates(Coordinates coordinates)
    {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(coordinates);
        tx.commit();
        em.close();
    }

    @Override
    public void addCoordinatesToBox(Long BoxId, Coordinates coordinates)
    {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        Box box = em.find(Box.class, BoxId);
        tx.begin();
        box.getCoordinates().add(coordinates);
        tx.commit();
        em.close();
    }

    @Override
    public void addBoxToUser(Long UserId, Box box)
    {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        User user = em.find(User.class, UserId);
        tx.begin();
        user.getBoxes().add(box);
        tx.commit();
        em.close();
    }

    @Override
    public User getUser(Long UserId)
    {
        EntityManager em = emf.createEntityManager();
        User userFromDB = em.find(User.class, UserId);
        em.close();
        return userFromDB;
    }

    @Override
    public Box getBox(Long BoxId)
    {
        EntityManager em = emf.createEntityManager();
        Box boxfromDB = em.find(Box.class, BoxId);
        em.close();
        return boxfromDB;
    }

    @Override
    public Coordinates getCoordinates(Long CoordinatesId)
    {
        EntityManager em = emf.createEntityManager();
        Coordinates coordinatesFromDB = em.find(Coordinates.class, CoordinatesId);
        em.close();
        return coordinatesFromDB;
    }

    @Override
    public User getUserByLogin(String login)
    {
        List<User> results = null;
        EntityManager em = emf.createEntityManager();
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.login = :login", User.class);
        query.setParameter("login", login);
        query.setMaxResults(1);
        results = query.getResultList();
        if (results.isEmpty()) return null;
        else if (results.size() != 0)
            return results.get(0);
        throw new NonUniqueResultException();
    }

    @Override
    public boolean ifUserExists(String login)
    {
        User user = getUserByLogin(login);
        if (user == null)
            return false;
        else
            return true;
    }
}
