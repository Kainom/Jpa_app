package consulta;

import infra.Dao;
import many_to_many.Ator;
import many_to_many.Movie;

import java.util.List;

public class GetMovies {
    public static void main(String[] args) {
        Dao<Movie> dao = new Dao<>(Movie.class);
        List<Movie> movies = dao.consultar("moviesWithBetterScore","nota",8.5);

        movies.stream().map(Movie::getNome).forEach(System.out::println);
        movies.stream().map(Movie::getAtores).forEach(e -> e.stream().map(Ator::getNome).forEach(System.out::println));
    }
}
