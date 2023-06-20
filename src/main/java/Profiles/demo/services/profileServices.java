package Profiles.demo.services;
import Profiles.demo.models.userProfile;

import java.util.List;
import java.util.Optional;

public interface profileServices {
    String createProfile(userProfile profile);
    String updateProfile(userProfile profile);
    String deleteProfile(String id);
    Optional<userProfile> getProfile(String id);
    List<userProfile> getAllProfiles();
}
