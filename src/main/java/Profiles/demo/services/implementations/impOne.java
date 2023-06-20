package Profiles.demo.services.implementations;
import Profiles.demo.models.userProfile;
import Profiles.demo.services.profileServices;
import Profiles.demo.repository.repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class impOne implements profileServices{
    @Autowired
    private repo repo;
    @Override
    public String createProfile(userProfile profile) {
        try{
            repo.save(profile);
        }
        finally {
            return "Successfully created profile";
        }
    }

    @Override
    public String updateProfile(userProfile profile) {
        try{
            repo.save(profile);
        }
        finally {
            return "Successfully updated profile";
        }
    }

    @Override
    public String deleteProfile(String id) {
        try{
            repo.deleteById(id);
        }
        finally {
            return "Successfully deleted profile";
        }
    }

    @Override
    public Optional<userProfile> getProfile(String id) {
            return repo.findById(id);
    }

    @Override
    public List<userProfile> getAllProfiles() {
        return repo.findAll();
    }
}
