package eci.edu.ieti.lab02ietiMongoDB.model;

import eci.edu.ieti.lab02ietiMongoDB.dto.UserDto;

import java.util.Date;
import java.util.UUID;

public class User

{
    String id;
    String name;
    String email;
    String lastName;
    Date createdAt;

    public User(String id, String name, String email, String lastName, Date createdAt) {
        this.id=id;
        this.name=name;
        this.email=email;
        this.lastName=lastName;
        this.createdAt=createdAt;
    }
    public User(){

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }



    public User( UserDto userDto )
    {
        id = UUID.randomUUID().toString();
        name = userDto.getName();
        lastName = userDto.getLastName();
        email = userDto.getEmail();
        createdAt = new Date();
    }

    public String getName()
    {
        return name;
    }

    public String getId()
    {
        return id;
    }

    public void update( UserDto userDto )
    {
        name = userDto.getName();
        lastName = userDto.getLastName();
        email = userDto.getEmail();
    }
}

