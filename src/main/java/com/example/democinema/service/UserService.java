package com.example.democinema.service;

import com.example.democinema.dto.UpdatePasswordDTO;
import com.example.democinema.dto.UserDTO;
import com.example.democinema.dto.UserInsertDTO;
import com.example.democinema.service.exceptions.EntityAlreadyExistsException;
import com.example.democinema.service.exceptions.EntityNotFoundException;

import java.util.List;

public interface UserService {

    UserDTO insertUser(UserInsertDTO dto);
    void deleteUser(Long id) throws EntityNotFoundException;
    UserDTO getUserByUsername(String username)throws EntityNotFoundException;
    UserDTO getUserById(Long id) throws EntityNotFoundException;
    List<UserDTO> getAllUsers();
    void likeShow(String username, Long showId) throws EntityNotFoundException;
    void updatePassword(String username, UpdatePasswordDTO dto) throws EntityNotFoundException;
}
