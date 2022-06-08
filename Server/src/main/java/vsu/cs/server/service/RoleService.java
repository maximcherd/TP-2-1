package vsu.cs.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vsu.cs.server.model.Role;
import vsu.cs.server.repository.RoleRepository;

import java.util.List;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository userRoleRepository) {
        this.roleRepository = userRoleRepository;
    }

    public void add(Role value) {
        this.roleRepository.save(value);
    }

    public void remove(Role value) {
        this.roleRepository.delete(value);
    }

    public List<Role> getAll() {
        return this.roleRepository.findAll();
    }
}
