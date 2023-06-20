package Profiles.demo.repository;

import Profiles.demo.models.userProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface repo extends MongoRepository<userProfile,String> {
}
