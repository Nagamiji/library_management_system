package net.javaguides.lms.service;

import net.javaguides.lms.entity.User;
import net.javaguides.lms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User userDetails) {
        Optional<User> userData = userRepository.findById(id);
        if (userData.isPresent()) {
            User user = userData.get();
            user.setUserName(userDetails.getUserName());
            user.setMajor(userDetails.getMajor());
            user.setTelephoneNumber(userDetails.getTelephoneNumber());
            return userRepository.save(user);
        }
        return null;
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
