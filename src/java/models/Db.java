package models;

public class Db
{
    // путь до файла БД
    public static final String DB_FILE_PATH = "db.db";
    // строка подключения БД
    public static final String DB_URL = String.format("jdbc:sqlite:%s", DB_FILE_PATH);
}
