package services;

import java.nio.file.*;
import java.sql.*;
import models.*;

public class DbService
{

    // получить соединение с БД
    public static Connection getConnection()
            throws SQLException
    {
        return DriverManager.getConnection(Db.DB_URL);
    }

    // удалить файл БД
    public static boolean deleteDbFile()
    {
        try
        {
            Files.deleteIfExists(Path.of(Db.DB_FILE_PATH));
            return true;
        } catch(Exception e)
        {
            return false;
        }
    }

    //создать таблицы БД
    public static void createTables()
    {
        UserService.createTable();
    }

    //создать БД с тестовыми данными
    public static void makeSamples()
    {
        UserService.makeSamples();
    }
}
