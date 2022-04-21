package peaksoft;

import peaksoft.dao.UserDaoJdbcImpl;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        // реализуйте алгоритм здесь

         UserDaoJdbcImpl userDaoJdbc = new UserDaoJdbcImpl();
         //userDaoJdbc.createUsersTable();
        //userDaoJdbc.dropUsersTable();

//        userDaoJdbc.saveUser("Leo","Messi", (byte) 35);
//        userDaoJdbc.saveUser("Cristiano","Ronaldo", (byte) 37);
//        userDaoJdbc.saveUser("Andres","Iniesta", (byte) 36);
//        userDaoJdbc.saveUser("Carles","Puiol", (byte) 42);

//        userDaoJdbc.removeUserById(1);
//        userDaoJdbc.getAllUsers().forEach(System.out::println);
//        userDaoJdbc.cleanUsersTable();

        boolean sa = userDaoJdbc.existsByFirstName("Leo");
        System.out.println(sa);

    }
}
