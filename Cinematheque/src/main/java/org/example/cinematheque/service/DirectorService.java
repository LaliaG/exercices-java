package org.example.cinematheque.service;

import org.example.cinematheque.dto.DirectorDtoGet;
import org.example.cinematheque.dto.DirectorDtoPost;
import org.example.cinematheque.entity.Director;
import org.example.cinematheque.exception.NotFoundException;
import org.example.cinematheque.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DirectorService {
    @Autowired
    private DirectorRepository directorRepository;

    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public DirectorDtoGet getById(Long id) {
        return directorToDirectorDtoGet(findById(id));
    }

    public List<DirectorDtoGet> findAll() {
        return directorListToDirectorDtoGetList((List<Director>) directorRepository.findAll());
    }

    public DirectorDtoGet create(DirectorDtoPost directorDtoPost) {
        Director director = Director.builder()
                .firstName(directorDtoPost.getFirstName())
                .lastName(directorDtoPost.getLastName())
                .birthDate(LocalDate.parse(directorDtoPost.getBirthDate(), dateFormatter))
                .nationality(directorDtoPost.getNationality())
                .build();

        directorRepository.save(director);
        return directorToDirectorDtoGet(director);
    }

    public DirectorDtoGet update(Long id, DirectorDtoPost directorDtoPost) {
        Director director = findById(id);
        director.setFirstName(directorDtoPost.getFirstName());
        director.setLastName(directorDtoPost.getLastName());
        director.setBirthDate(LocalDate.parse(directorDtoPost.getBirthDate(), dateFormatter));
        director.setNationality(directorDtoPost.getNationality());

        directorRepository.save(director);
        return directorToDirectorDtoGet(director);
    }

    public boolean delete(Long id) {
        Director director = findById(id);
        directorRepository.delete(director);
        return true;
    }

    private Director findById(Long id) {
        return directorRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    private DirectorDtoGet directorToDirectorDtoGet(Director director) {
        return DirectorDtoGet.builder()
                .id(director.getId())
                .firstName(director.getFirstName())
                .lastName(director.getLastName())
                .birthDate(director.getBirthDate())
                .nationality(director.getNationality())
                .build();
    }

    private List<DirectorDtoGet> directorListToDirectorDtoGetList(List<Director> directorList) {
        return directorList.stream().map(this::directorToDirectorDtoGet).collect(Collectors.toList());
    }
}
