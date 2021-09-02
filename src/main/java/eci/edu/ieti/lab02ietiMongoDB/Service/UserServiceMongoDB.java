package eci.edu.ieti.lab02ietiMongoDB.Service;

import eci.edu.ieti.lab02ietiMongoDB.document.UserDocument;
import eci.edu.ieti.lab02ietiMongoDB.dto.UserDto;
import eci.edu.ieti.lab02ietiMongoDB.model.User;
import eci.edu.ieti.lab02ietiMongoDB.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceMongoDB implements UserService {
    private final UserRepository userRepository;

    public UserServiceMongoDB(@Autowired UserRepository userRepository )
    {
        this.userRepository = userRepository;
    }
    @Override
    public User create(User user )
    {
        try{
            userRepository.save(new UserDocument(user.getId(),user.getName(),user.getLastName(),user.getEmail(),user.getCreatedAt()));
            return user;
        }catch (Exception e){
            System.out.println(e.getStackTrace()[0]);
        }
        return null;
    }
    @Override
    public User findById( String id ) {
        UserDocument userDocument=null;
        User user=null;
        try {
            userDocument = userRepository.findById(id).orElseThrow(() -> new Exception("Usuario no encontrado"));
            user=new User(userDocument.getId(),userDocument.getName(),userDocument.getEmail(),userDocument.getLastName(),userDocument.getCreatedAt());
        }catch (Exception e){
            System.out.println("No se encontro usuario");
        }
        return user;
    }
    @Override
    public List<User> all()
    {
        List<UserDocument> usersDocument=userRepository.findAll();
        ArrayList<User> users=new ArrayList<User>();
        for(int i=0;i<usersDocument.size();i++){
            users.add(new User(usersDocument.get(i).getId(),usersDocument.get(i).getName(),usersDocument.get(i).getEmail(),usersDocument.get(i).getLastName(),usersDocument.get(i).getCreatedAt()));
        }
        return users;
    }
    @Override
    public boolean deleteById( String id ) {
        if(userRepository.findById(id)!=null){
            userRepository.deleteById(id);
            return true;
        }else{
            return false;
        }

    }
    @Override
    public User update(UserDto userDto, String id ) {
        if(userRepository.findById(id)!=null){
            User user=new User(userDto);
            UserDocument userDocument=new UserDocument(user.getId(),user.getName(),user.getLastName(),user.getEmail(),user.getCreatedAt());
            userRepository.deleteById(id);
            userRepository.save(userDocument);
            return user;
        }else{
            return null;
        }
    }
}