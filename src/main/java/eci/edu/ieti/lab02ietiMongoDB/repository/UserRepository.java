package eci.edu.ieti.lab02ietiMongoDB.repository;

import eci.edu.ieti.lab02ietiMongoDB.document.UserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public   interface   UserRepository  extends MongoRepository<UserDocument, String > {
}