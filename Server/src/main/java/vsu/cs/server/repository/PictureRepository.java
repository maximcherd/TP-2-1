package vsu.cs.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vsu.cs.server.model.Picture;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Long> {
}
