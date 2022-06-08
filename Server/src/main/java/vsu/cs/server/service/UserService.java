package vsu.cs.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import vsu.cs.server.config.WebSecurityConfig;
import vsu.cs.server.model.Role;
import vsu.cs.server.model.User;
import vsu.cs.server.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = getByLogin(login);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }

    public void add(User value) {
        this.userRepository.save(value);
    }

    public boolean addNew(User value) {
        User userFromDB = getByLogin(value.getUsername());
        if (userFromDB != null) {
            return false;
        }
        value.setRole(new Role(WebSecurityConfig.C_ROLE_USER_ID, WebSecurityConfig.C_ROLE_USER));
        value.setPassword(bCryptPasswordEncoder.encode(value.getPassword()));
        userRepository.save(value);
        return true;
    }

    public void remove(User value) {
        this.userRepository.delete(value);
    }

    public List<User> getAll() {
        return this.userRepository.findAll();
    }

    public List<User> getAllByRole(Role role) {
        List<User> list = new ArrayList<>();
        for (User user : this.userRepository.findAll()) {
            if (user.getRole().getName().equals(role.getName())) {
                list.add(user);
            }
        }
        return list;
    }

    public User getById(Long id) {
        return this.userRepository.getById(id);
    }

    public User getByLogin(String login) {
        List<User> list = this.userRepository.findAll();
        for (User u : list) {
            if (u.getLogin().equals(login)) {
                return u;
            }
        }
        return null;
    }
}
