package org.example;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int movie_durations[] ;
        int flight_duration;

        Random random1 = new Random();
        movie_durations = random1.ints(1000, 50, 150).toArray();
        flight_duration = random1.ints(1, 60, 1000).sum();

        int result[] = number_of_movies(movie_durations,flight_duration);
        System.out.println(String.format("Movies chosen: [%d, %d]", result[0], result[1]));
    }

    private static int[] number_of_movies(int[] movieDurations, int flightDuration) {
        int remaining_flight = flightDuration - 30;
        int movie1 = 0;
        int movie2 = 0;
        int previous_max_duration = 0;
        int max_duration_of_movies = 0;

        for (int i=0;i<movieDurations.length;i++){
            for (int j=movieDurations.length-1;j>i;j--){
                max_duration_of_movies = movieDurations[i]+movieDurations[j];
                if(max_duration_of_movies < remaining_flight && previous_max_duration < max_duration_of_movies ){
                    previous_max_duration = max_duration_of_movies;
                    movie1=i;
                    movie2=j;
                }
            }
        }
        return new int[]{movie1,movie2};
    }
}



