package vsu.cs.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vsu.cs.server.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
