package peaksoft.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import peaksoft.model.User;
import peaksoft.util.Util;

import javax.crypto.spec.PSource;
import java.util.List;
import java.util.Queue;

public class UserDaoHibernateImpl implements UserDao {

    EntityManagerFactory entityManagerFactory = Util.createEntityManagerFactory();



    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
    }

    @Override
    public void dropUsersTable() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createNativeQuery("drop table User ").executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        User user = new User(name,lastName,age);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public void removeUserById(long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(User.class,id));
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public List<User> getAllUsers() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<User> userList = entityManager.createQuery("select u from User u", User.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return userList;
    }

    @Override
    public void cleanUsersTable() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createQuery("delete from User u").executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public boolean existsByFirstName(String firstName) {
        // eger databasede parametrine kelgen firstnamege okshosh adam bar bolso
        // anda true kaitarsyn
        // jok bolso anda false kaitarsyn.
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select case when count(u)>0 then true else false end from User u where u.name= ?1", Boolean.class);
        query.setParameter(1, firstName);
        Boolean singleResult = (Boolean) query.getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return singleResult;
    }
}
