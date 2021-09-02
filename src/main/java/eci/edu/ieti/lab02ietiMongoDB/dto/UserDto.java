package eci.edu.ieti.lab02ietiMongoDB.dto;

public class UserDto
{
    String name;

    String email;

    String lastName;

    public UserDto()
    {
    }

    public UserDto(String name, String email, String lastName) {
        this.name = name;
        this.email = email;
        this.lastName = lastName;
    }

    public String getName()
    {
        return name;
    }

    public String getEmail()
    {
        return email;
    }

    public String getLastName()
    {
        return lastName;
    }
}