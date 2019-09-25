package springxml;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import springxml.beans.Movie;

public class SpringApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        springxml.beans.Movie theMovie = context.getBean("myMovie", Movie.class);

        System.out.println(theMovie.getmName());
        System.out.println(theMovie.getOverview());

        System.out.println(theMovie.logChange());

        context.close();
    }
}
