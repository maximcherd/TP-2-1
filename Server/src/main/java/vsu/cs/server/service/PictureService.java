package vsu.cs.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vsu.cs.server.model.Picture;
import vsu.cs.server.repository.PictureRepository;

import java.util.List;

@Service
public class PictureService {

    private final PictureRepository pictureRepository;

    @Autowired
    public PictureService(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    public void add(Picture value) {
        this.pictureRepository.save(value);
    }

    public void remove(Picture value) {
        this.pictureRepository.delete(value);
    }

    public List<Picture> getAll() {
        return this.pictureRepository.findAll();
    }

    public Picture getById(Long id) {
        return this.pictureRepository.getById(id);
    }
}
