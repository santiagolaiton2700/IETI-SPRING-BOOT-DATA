package eci.edu.ieti.lab02ietiMongoDB.controller;

import eci.edu.ieti.lab02ietiMongoDB.Service.UserService;
import eci.edu.ieti.lab02ietiMongoDB.dto.UserDto;
import eci.edu.ieti.lab02ietiMongoDB.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping( "/v1/user" )
public class UserController
{

    @Autowired
    UserService userService;
    /**
    public UserController( @Autowired UserService userService )
    {
        this.userService = userService;
    }
    **/

    @GetMapping
    public ResponseEntity<List<User>> all()
    {
        return ResponseEntity.ok( userService.all() );
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<User> findById(@PathVariable String id )
    {
        return ResponseEntity.ok( userService.findById( id ) );
    }


    @PostMapping
    public ResponseEntity<User> create( @RequestBody UserDto userDto )
    {
        return ResponseEntity.ok( userService.create( new User( userDto ) ) );
    }

    @PutMapping( "/{id}" )
    public ResponseEntity<User> update(@RequestBody UserDto userDto, @PathVariable String id )
    {
        return ResponseEntity.ok( userService.update( userDto, id ) );
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<Boolean> delete( @PathVariable String id )
    {
        return ResponseEntity.ok( userService.deleteById( id ) );
    }

}

