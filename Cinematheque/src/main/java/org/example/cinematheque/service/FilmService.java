package org.example.cinematheque.service;

import org.example.cinematheque.dto.DirectorDtoGet;
import org.example.cinematheque.dto.FilmDtoGet;
import org.example.cinematheque.dto.FilmDtoPost;
import org.example.cinematheque.entity.Director;
import org.example.cinematheque.entity.Film;
import org.example.cinematheque.repository.DirectorRepository;
import org.example.cinematheque.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmService {
    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private DirectorRepository directorRepository;

    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public FilmDtoGet getById(Long id) {
        return filmToFilmDtoGet(findById(id));
    }

    public List<FilmDtoGet> findAll() {
        return filmListToFilmDtoGetList((List<Film>) filmRepository.findAll());
    }

    public FilmDtoGet create(FilmDtoPost filmDtoPost) {
        Director director = directorRepository.findById(filmDtoPost.getDirectorId())
                .orElseThrow(NotFoundException::new);

        Film film = Film.builder()
                .name(filmDtoPost.getName())
                .releaseDate(LocalDate.parse(filmDtoPost.getReleaseDate(), dateFormatter))
                .description(filmDtoPost.getDescription())
                .duration(filmDtoPost.getDuration())
                .genre(filmDtoPost.getGenre())
                .director(director)
                .build();

        filmRepository.save(film);
        return filmToFilmDtoGet(film);
    }

    public FilmDtoGet update(Long id, FilmDtoPost filmDtoPost) {
        Film film = findById((id));
        Director director = directorRepository.findById(filmDtoPost.getDirectorId())
                .orElseThrow(NotFoundException::new);

        film.setName(filmDtoPost.getName());
        film.setReleaseDate(LocalDate.parse(filmDtoPost.getReleaseDate(), dateFormatter));
        film.setDescription(filmDtoPost.getDescription());
        film.setDuration(filmDtoPost.getDuration());
        film.setGenre(filmDtoPost.getGenre());
        film.setDirector(director);

        filmRepository.save(film);
        return filmToFilmDtoGet(film);
    }

    public boolean delete(Long id) {
        Film film = findById((id));
        filmRepository.delete(film);
        return true;
    }

    public List<FilmDtoGet> findByDirectorId(Long directorId) {
        List<Film> films = filmRepository.findByDirectorId(directorId);
        return filmListToFilmDtoGetList(films);
    }

    private Film findById(Long id) {
        return filmRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    private FilmDtoGet filmToFilmDtoGet(Film film) {
        return FilmDtoGet.builder()
                .id(film.getId())
                .name(film.getName())
                .releaseDate(film.getReleaseDate())
                .description(film.getDescription())
                .duration(film.getDuration())
                .genre(film.getGenre())
                .director(directorToDirectorDtoGet(film.getDirector()))
                .build();
    }

    private List<FilmDtoGet> filmListToFilmDtoGetList(List<Film> filmList) {
        return filmList.stream().map(this::filmToFilmDtoGet).collect(Collectors.toList());
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
}
