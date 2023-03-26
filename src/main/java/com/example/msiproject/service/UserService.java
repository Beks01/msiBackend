package com.example.msiproject.service;

import com.example.msiproject.dto.ScheduleDTO;
import com.example.msiproject.dto.UserDTO;
import com.example.msiproject.exception.UserNotFoundException;
import com.example.msiproject.model.Schedule;
import com.example.msiproject.model.User;
import com.example.msiproject.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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

    public UserDTO getUserById(Long id) {
        User user = repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        return mapper.map(user, UserDTO.class);
    }

    public UserDTO createUser(UserDTO userDTO) {
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
}
