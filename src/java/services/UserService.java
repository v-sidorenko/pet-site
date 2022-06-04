package services;

import java.sql.*;
import java.util.*;
import models.*;

public class UserService
{

    // создать таблицу БД
    public static boolean createTable()
    {
        try( Connection connection = DbService.getConnection();
             Statement statement = connection.createStatement();)
        {
            String sql = """
                         CREATE TABLE IF NOT EXISTS users (
                         	id INTEGER PRIMARY KEY AUTOINCREMENT,
                         	email TEXT NOT NULL,
                         	name TEXT
                         );
                         """;
            statement.executeUpdate(sql);
            return true;
        } catch(Exception e)
        {
            return false;
        }
    }

    //вставить тестовые данные
    public static boolean makeSamples()
    {
        try
        {
            add("test1@test.ru", "test1");
            add("test2@test.ru", "test2");
            return true;
        } catch(Exception e)
        {
            return false;
        }
    }

    // найти всех пользователей
    public static List<User> findAll()
            throws SQLException
    {
        try( Connection connection = DbService.getConnection();
             Statement statement = connection.createStatement();)
        {
            String sql = "SELECT * FROM users";                                 // текст запроса
            ResultSet result = statement.executeQuery(sql);                     // выполнить запрос
            return makeUsersList(result);                                       // создать список пользователей
        }
    }

    // найти пользователей по email
    public static List<User> findByEmail(String email)
            throws SQLException
    {
        try( Connection connection = DbService.getConnection();
             Statement statement = connection.createStatement();)
        {
            String sql = String.format("""
                SELECT *
                FROM users
                WHERE email = %s
            """, email);                                                        // текст запроса
            ResultSet result = statement.executeQuery(sql);                     // выполнить запрос
            return makeUsersList(result);                                       // создать список пользователей
        }
    }

    // добавить пользователя
    public static User add(String email, String name)
            throws SQLException
    {
        try( Connection connection = DbService.getConnection();
             Statement statement = connection.createStatement();)
        {
            String sql = String.format("""
                INSERT INTO users(email, name)
                VALUES ("%s", "%s")
                RETURNING *
            """, email, name);                                                  // создать пользвателя по email и name
            ResultSet result = statement.executeQuery(sql);                     // выполнить запрос
            int id = result.getInt("id");                                       // id из БД
            String e = result.getString("email");                               // email из БД
            String n = result.getString("name");                                // name из БД
            return new User(id, e, n);
        }
    }

    // изменить пользователя
    public static boolean update(String id, String email, String name)
    {
        try( Connection connection = DbService.getConnection();
             Statement statement = connection.createStatement();)
        {
            String sql = String.format("""
                UPDATE users
                SET email = "%s", name = "%s"
                WHERE id = "%s"
            """, email, name, id);
            statement.executeUpdate(sql);
            return true;
        } catch(Exception e)
        {
            return false;
        }
    }

    // удалить пользователя по id
    public static boolean delete(String id)
    {
        try( Connection connection = DbService.getConnection();
             Statement statement = connection.createStatement();)
        {
            String sql = String.format("""
                DELETE FROM users
                WHERE id = %s
            """, id);                                                           // удалить пользователя по id
            int result = statement.executeUpdate(sql);                          // выполнить запрос
            return result > 0;                                                  // false если удалено 0 строк
        } catch(Exception e)
        {
            return false;                                                       // false при любых других ошибках
        }
    }

    // создать список пользователей из результата запроса
    private static List<User> makeUsersList(ResultSet result)
            throws SQLException
    {
        List<User> usersList = new ArrayList<>();                               // создать новый список пользователей
        while(result.next())                                                    // цикл проверки всех пользователей из БД
        {
            int id = result.getInt("id");                                       // получить id
            String email = result.getString("email");                           // получить email
            String name = result.getString("name");                             // получить name
            User u = new User(id, email, name);                                 // создать объект пользователя
            usersList.add(u);                                                    // добавить пользователя в список
        }
        return (usersList);                                                      // вернуть список пользователей
    }

}
