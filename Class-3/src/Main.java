import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Student implements Comparable<Student>{
    int marks;

    public Student(int marks) {
        this.marks = marks;
    }


    @Override
    public int compareTo(Student o) {
        return this.marks - o.marks;
    }
};

//class Movie implements Comparable<Movie>{
class Movie {
    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    private double rating;
    private String name;
    private int year;

    public Movie(double rating, String name, int year) {
        this.rating = rating;
        this.name = name;
        this.year = year;
    }

//    @Override
//    public int compareTo(Movie o) {
////        System.out.println(this.toString() + " : " + o.toString());
//        return (int) (this.rating - o.rating);
//    }

    @Override
    public String toString() {
        return this.getName() + " " +
                this.getRating() + " " +
                this.getYear();
    }

}

class YearCompare implements Comparator<Movie> {

    @Override
    public int compare(Movie m1, Movie m2) {
        if(m1.getYear() > m2.getYear()) {
            return 1;
        }
        if(m1.getYear() < m2.getYear()) {
            return -1;
        }
        return 0;
    }
}



public class Main {



    public static void main(String[] args) {

        /*
            Comparable vs Comparator

         */

        /*
            Comparable vs Comparator

                Comparable object ->
                    - It is capable of comparing itself with another object
                    - We need to implement Comparable Interface
                    - Internal to the class


         */

        /*

                Comparator object ->
                    - external to the object we are comparing, separate class
                    - Collections.sort(<Collection>, Comparator)

    If the sorting needs to be done on attributes of diff objects -> comparator

         */


        Student student1 = new Student(100);

        Student student2 = new Student(90);

        System.out.println(student1.compareTo(student2));


        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie(8.5, "Breaking Bad", 2016));
        movies.add(new Movie(8.25, "Star WARS", 2015));
        movies.add(new Movie(9.9, "Spiderman", 2017));


        YearCompare yearCompare = new YearCompare();

        // TODO = write lambda expression for comparator

        Collections.sort(movies, yearCompare);

        for(Movie movie : movies) {
            System.out.println(movie.toString());
        }

    }
}