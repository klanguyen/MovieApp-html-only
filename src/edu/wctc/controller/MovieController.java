package edu.wctc.controller;

import edu.wctc.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import edu.wctc.service.GenreService;
import edu.wctc.service.MovieService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @Autowired
    private GenreService genreService;

    @RequestMapping("/list")
    public String listMovies(Model theModel) {
        List<Movie> theList = movieService.getMovies();

        theModel.addAttribute("movies", theList);

        return "list-movies";
    }

    @GetMapping("/search")
    public String search(@RequestParam("searchTerm") String theSearchTerm,
                         Model theModel) {
        List<Movie> theList = movieService.getMoviesByName(theSearchTerm);

        theModel.addAttribute("movies", theList);

        return "/list-movies";
    }

    @GetMapping("/delete")
    public String deleteMovie(@RequestParam("movieId") int theId) {
        movieService.deleteMovie(theId);

        return "redirect:/movie/list";
    }

    @RequestMapping("/showUpdateMovieForm")
    public String showUpdateMovieForm(@RequestParam("movieId") int theId,
                                      Model theModel) {
        Movie existingMovie = movieService.getMovie(theId);

        theModel.addAttribute("aMovie", existingMovie);
        theModel.addAttribute("genres", genreService.getGenres());

        return "/add-movie-form";
    }

    @GetMapping("/showAddMovieForm")
    public String showAddMovieForm(Model theModel) {
        Movie newMovie = new Movie();

        theModel.addAttribute("aMovie", newMovie);
        theModel.addAttribute("genres", genreService.getGenres());

        return "/add-movie-form";
    }

    @PostMapping("/save")
    public String saveMovie(@Valid @ModelAttribute(name = "aMovie") Movie theMovie,
                            BindingResult bindingResult,
                            Model theModel) {
                            //HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult);
            theModel.addAttribute("genres", genreService.getGenres());

            return "/add-movie-form";
        }

        movieService.saveMovie(theMovie);

        return "redirect:/movie/list";
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor ste = new StringTrimmerEditor(true);

        webDataBinder.registerCustomEditor(String.class, ste);
    }
}
