package org.example;

import org.example.model.Director;
import org.example.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {

        Configuration configuration = new Configuration().addAnnotatedClass(Director.class).addAnnotatedClass(Movie.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Director directorTimur = session.get(Director.class,7);
            Movie movie = directorTimur.getMovieList().stream().filter(x->x.getId()==12).findAny().orElse(null);

            session.remove(movie);

            session.getTransaction().commit();
        }
        finally {
            sessionFactory.close();
        }

    }
}
