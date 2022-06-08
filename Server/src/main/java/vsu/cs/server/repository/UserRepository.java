package vsu.cs.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vsu.cs.server.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
