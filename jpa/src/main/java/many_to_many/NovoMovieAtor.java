package many_to_many;

import infra.Dao;

import java.util.Date;

public class NovoMovieAtor {
    public static void main(String[] args) {
        Movie movie = new Movie("The Hobbit",10.0d,new Date());
        Movie movieb = new Movie("Lord of rings",9.8d,new Date());

        Ator ator = new Ator("John Tolkien");
        Ator atriz = new Ator("Galadriel");

        movie.addAtor(ator);
        movie.addAtor(atriz);

        movieb.addAtor(ator);

        Dao<Movie> dao = new Dao<>();
        dao.includeAtomic(movie);
        dao.close();


    }
}
