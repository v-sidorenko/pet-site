package models;

public class User
{

    final int id;
    final String email;
    final String name;

    public User(int id, String email, String name)
    {
        this.id = id;
        this.email = email;
        this.name = name;
    }

    public int getId()
    {
        return id;
    }

    public String getEmail()
    {
        return email;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public String toString()
    {
        return "[" + String.join("; ", String.valueOf(id), email, name) + "]";
    }
}
