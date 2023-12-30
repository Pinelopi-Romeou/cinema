package com.example.democinema.service;

import com.example.democinema.dto.*;
import com.example.democinema.model.*;
import com.example.democinema.repository.ShowRepository;
import com.example.democinema.repository.UserRepository;
import com.example.democinema.service.exceptions.EntityAlreadyExistsException;
import com.example.democinema.service.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final ShowRepository showRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ShowRepository showRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Creates a new user
     * @param dto the user
     * @throws EntityAlreadyExistsException if the username of the user being inserted already exists
     */
    @Transactional
    @Override
    public void insertUser(UserInsertDTO dto) throws EntityAlreadyExistsException {
        User u = userRepository.getByUsername(dto.getUsername());
        if (u != null) {
            throw new EntityAlreadyExistsException(User.class, u.getUsername());
        }

        User user = map(dto);
        user.setRole(UserRole.USER);
        userRepository.save(user);
    }

    /**
     * Updates the password of the user
     * @param username the username of the user being updated
     * @param dto the user
     * @throws EntityNotFoundException if user is not found
     */
    @Transactional
    @Override
    public void updatePassword(String username, UpdatePasswordDTO dto) throws EntityNotFoundException {
        User user = userRepository.getByUsername(username);
        if (user == null) {
            throw new EntityNotFoundException(User.class, username);
        }
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
    }

    /**
     * Finds and returns a user based on their username
     * @param username the username
     * @return the user
     * @throws EntityNotFoundException if user is not found
     */
    @Override
    public UserDTO getUserByUsername(String username) throws EntityNotFoundException {
        User user = userRepository.getByUsername(username);
        if (user != null) {
            return map(user);
        } else {
            throw new EntityNotFoundException(User.class, username);
        }
    }

    /**
     * Finds and returns a list of all users
     * @return all users
     */
    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOS = new ArrayList<>();
        for (User u : users) {
            userDTOS.add(map(u));
        }
        return userDTOS;
    }

    /**
     * Adds a show to the selected user
     * @param username the username used to find the user
     * @param showId the ID of the show used to find the show
     * @throws EntityNotFoundException if the user or the show is not found
     */
    @Transactional
    @Override
    public void likeShow(String username, Long showId) throws EntityNotFoundException {
        User user = userRepository.getByUsername(username);
        if (user == null) {
            throw new EntityNotFoundException(User.class, username);
        }
        Optional<Show> show = showRepository.findById(showId);
        if (show.isEmpty()) {
            throw new EntityNotFoundException(Show.class, showId);
        }
        user.likeShow(show.get());
    }

    private User map(UserInsertDTO dto) {
        return new User(null, dto.getFirstname(), dto.getLastname(), dto.getUsername(), dto.getEmail(), passwordEncoder.encode(dto.getPassword()));
    }

    private UserDTO map(User user) {
        UserDTO userDTO = new UserDTO(user.getId(), user.getFirstname(), user.getLastname(), user.getUsername(), user.getEmail());
        List<ShowDTO> shows = new ArrayList<>();
        for (Show s : user.getLikedShows()) {
            shows.add(map(s));
        }
        userDTO.setLikedShows(shows);

        List<ScreeningDTO> reservations = new ArrayList<>();
        for (Reservation r : user.getReservations()) {
            reservations.add(map(r.getScreening()));
        }
        userDTO.setReservations(reservations);

        return userDTO;
    }

    private ScreeningDTO map(Screening screening) {
        return new ScreeningDTO(screening.getId(), screening.getDateTime(), screening.getPrice(), map(screening.getShow()));
    }

    private ShowDTO map(Show show) {
        return new ShowDTO(show.getId(), show.getTitle(), show.getDescription(), show.getDuration(), show.getDirector(), show.getGenre(), show.getLanguage(), show.getImageName());
    }
}
