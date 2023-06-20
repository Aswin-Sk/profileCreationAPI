package Profiles.demo.controller;

import Profiles.demo.models.userProfile;
import Profiles.demo.services.profileServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/profile")
public class profilesController {
    @Autowired
    profileServices profileService;
    public profilesController(profileServices service){
        this.profileService=service;
    }
    @GetMapping("/{id}")
    public ResponseEntity<userProfile> getProfile(@PathVariable("id") String id) {
        Optional<userProfile> profile = profileService.getProfile(id);

        if (profile.isPresent()) {
            return ResponseEntity.ok(profile.get());
        } else {
            throw new throwException("Profile not found with id: " + id);
        }
    }

    @GetMapping()
    public List<userProfile> getAll() {
        List<userProfile> profiles = profileService.getAllProfiles();

        if (profiles.isEmpty()) {
            throw new throwException("No profiles found.");
        }

        return profiles;
    }

    @PostMapping()
    public String postProfile(@RequestBody userProfile profile) {
        Optional<userProfile> existingProfile = profileService.getProfile(profile.getId());
        if (existingProfile.isPresent()) {
            throw new throwException("ID already exists: " + profile.getId());
        } else {
            profileService.createProfile(profile);
            return "Profile is created";
        }
    }

    @PutMapping
    public String putProfile(@RequestBody userProfile profile) {
        Optional<userProfile> existingProfile = profileService.getProfile(profile.getId());
        if (existingProfile.isPresent()) {
            profileService.createProfile(profile);
            return "Profile is updated";
        } else {
            throw new throwException("ID does not exist: " + profile.getId());
        }
    }

    @DeleteMapping("/{id}")
    public String deleteProfile(@PathVariable("id") String id) {
        profileService.deleteProfile(id);
        return "Profile is deleted";
    }
    @DeleteMapping()
    public String deleteAll(){
        List<userProfile> profiles = profileService.getAllProfiles();
        for(userProfile a:profiles){
            profileService.deleteProfile(a.getId());
        }
        return "All entries deleted";
    }

    @ExceptionHandler(throwException.class)
    public ResponseEntity<String> handleThrowException(throwException ex) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(ex.getMessage());
    }
}
