package peaksoft;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import peaksoft.dao.UserDaoHibernateImpl;
import peaksoft.dao.UserDaoJdbcImpl;
import peaksoft.model.User;
import peaksoft.util.Util;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        // реализуйте алгоритм здесь

        //UserDaoJdbcImpl userDaoJdbc = new UserDaoJdbcImpl();
         //userDaoJdbc.createUsersTable();
        //userDaoJdbc.dropUsersTable();

//        userDaoJdbc.saveUser("Leo","Messi", (byte) 35);
//        userDaoJdbc.saveUser("Cristiano","Ronaldo", (byte) 37);
//        userDaoJdbc.saveUser("Andres","Iniesta", (byte) 36);
//        userDaoJdbc.saveUser("Carles","Puiol", (byte) 42);

//        userDaoJdbc.removeUserById(1);
//        userDaoJdbc.getAllUsers().forEach(System.out::println);
//        userDaoJdbc.cleanUsersTable();

        //boolean sa = userDaoJdbc.existsByFirstName("Leo");
        //System.out.println(sa);

        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();

        //userDaoHibernate.saveUser("Seit","Narynbaev",(byte)32);
        //userDaoHibernate.saveUser("Azat","Ibraev",(byte)32);

        //userDaoHibernate.removeUserById(1);
        //userDaoHibernate.getAllUsers().forEach(System.out::println);
        //userDaoHibernate.cleanUsersTable();

        System.out.println(userDaoHibernate.existsByFirstName("Seit"));



    }
}
