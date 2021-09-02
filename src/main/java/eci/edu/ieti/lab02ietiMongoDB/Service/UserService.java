package eci.edu.ieti.lab02ietiMongoDB.Service;

import eci.edu.ieti.lab02ietiMongoDB.dto.UserDto;
import eci.edu.ieti.lab02ietiMongoDB.model.User;

import java.util.List;

public interface UserService
{
    User create(User user );

    User findById( String id );

    List<User> all();

    boolean deleteById( String id );

    User update(UserDto userDto, String id );
}