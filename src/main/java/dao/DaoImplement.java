package dao;

import model.Box;
import model.Coordinates;
import model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

public class DaoImplement implements DaoInterface
{
    @PersistenceUnit(name = "DB-BoxTracker-pers-unit")
    static EntityManagerFactory emf;

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

}
