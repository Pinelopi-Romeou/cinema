package com.example.democinema.service;

import com.example.democinema.dto.UpdatePasswordDTO;
import com.example.democinema.dto.UserDTO;
import com.example.democinema.dto.UserInsertDTO;
import com.example.democinema.service.exceptions.EntityAlreadyExistsException;
import com.example.democinema.service.exceptions.EntityNotFoundException;

import java.util.List;

public interface UserService {

    void insertUser(UserInsertDTO dto) throws EntityAlreadyExistsException;

    UserDTO getUserByUsername(String username)throws EntityNotFoundException;

    List<UserDTO> getAllUsers();

    void likeShow(String username, Long showId) throws EntityNotFoundException;

    void updatePassword(String username, UpdatePasswordDTO dto) throws EntityNotFoundException;
}
