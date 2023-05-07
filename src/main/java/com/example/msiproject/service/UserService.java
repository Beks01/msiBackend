package com.example.msiproject.service;

import com.example.msiproject.dto.UserDTO;
import com.example.msiproject.dto.UserValidationDTO;
import com.example.msiproject.exception.UserNotFoundException;
import com.example.msiproject.model.User;
import com.example.msiproject.model.enums.Roles;
import com.example.msiproject.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {


    private final UserRepository repository;


    private final ModelMapper mapper;

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.repository = userRepository;
        this.mapper = modelMapper;
    }
//    public Optional<User> findByUsername(String username) {
//        return repository.findByUsername(username);
//    }


//    public RegistrationDTO registerDoctor(RegistrationDTO registrationDTO) {
//
//        User user = mapper.map(registrationDTO, User.class);
//        //Doctor doctor = mapper.map(user, Doctor.class);
//        user.getRoles().forEach(x -> x.setName(Roles.DOCTOR));
//        //user.setDoctor(doctor);
//
//        // user.setRoles(Collections.singleton(Roles.DOCTOR));
//
//        repository.save(user);
//        return  registrationDTO;
//    }


//    public RegistrationDTO registerPatient(RegistrationDTO registrationDTO) {
//        Patient patient = mapper.map(registrationDTO, Patient.class);
//        User user = mapper.map(registrationDTO, User.class);
//
//        // user.setRoles(Collections.singleton(Roles.DOCTOR));
//        user.getRoles().forEach(x -> x.setName(Roles.PATIENT));
//        user.setPatient(patient);
//        repository.save(user);
//
//        return  registrationDTO;
//    }


    public UserDTO getUserById(Long id) {
        User user = repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        return mapper.map(user, UserDTO.class);
    }

    private String decodePassword(String key, String encodedPassword) {

        // Decode the encoded password string from Base64
        byte[] decodedBytes = Base64.getDecoder().decode(encodedPassword.getBytes());

        // Convert the decoded bytes to a string and split the key and password
        String decoded = new String(decodedBytes);
        String[] parts = decoded.split(":", 2);

        // Verify that the key matches the one used to encode the password
        if (!key.equals(parts[0])) {
            throw new IllegalArgumentException("Invalid key for encoded password");
        }

        // Return the decoded password
        return parts[1];
    }

    public static String encodePassword(String key, String password) {
        // Concatenate the key and password with a separator
        String combined = key + ":" + password;

        // Encode the combined string using Base64
        byte[] encodedBytes = Base64.getEncoder().encode(combined.getBytes());

        // Convert the encoded bytes to a string and return it
        return new String(encodedBytes);
    }



    // This Fucking code takes three parameters and return
    // if there is the account based on the information that i provided.
    public UserDTO validateUser(UserValidationDTO validUser) {
        for (UserValidationDTO user1 : getAllValidUsers()) {
            if (validUser.getLogin() != null
                    && validUser.getLogin().equals(user1.getLogin())
                    && decodePassword(user1.getLogin(), user1.getPassword()).equals(validUser.getPassword())
                    && user1.getRole().equals(validUser.getRole())) {
                return mapper.map(validUser, UserDTO.class);
            }
        }
        return null;
    }

    public UserDTO createUser(UserDTO userDTO) {
        String encodedPassword = encodePassword(userDTO.getLogin(),userDTO.getPassword());
        userDTO.setPassword(encodedPassword);
        User user = mapper.map(userDTO, User.class);
        user = repository.save(user);
        return mapper.map(user, UserDTO.class);
    }

    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User userToUpdate = repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        User updateUser = mapper.map(userDTO, User.class);

        updateUser.setId(userToUpdate.getId());

        return mapper.map(repository.save(updateUser), UserDTO.class);

    }

    public void deleteUser(Long id) {
        User user = repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        repository.delete(user);
    }

    public List<UserDTO> getAllUsers() {
        List<User> users = repository.findAll();
        return users.stream().map(user -> mapper.map(user, UserDTO.class)).collect(Collectors.toList());
    }
    public List<UserValidationDTO> getAllValidUsers() {
        List<User> users = repository.findAll();
        return users.stream().map(user -> mapper.map(user, UserValidationDTO.class)).collect(Collectors.toList());
    }
}
