package nl.saxion.concurrency.assignment1;

import javax.sound.midi.SysexMessage;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        System.out.println("Starting the application!");

        Scanner scanner = new Scanner(System.in);
        System.out.println("How many numbers do you wish to sort?");
        System.out.print("Amount: ");
        int amountToSort = scanner.nextInt();
        System.out.println("How many times do you wish tot run it?");
        System.out.print("Times: ");
        int timesToRun = scanner.nextInt();
        int[] durations = new int[timesToRun];

        for (int i = 0; i < timesToRun; i++) {
            int[] randomNumbers = new int[amountToSort];
            Random random = new Random();
            for (int j = 0; j < amountToSort; j++) {
                randomNumbers[j] = (random.nextInt());
            }

            //start timer
            Instant start = Instant.now();

            //sort numbers
            Sort.bubbleSort(randomNumbers);

            int durationInMilliSeconds = (int) Duration.between(start, Instant.now()).toMillis();
            System.out.println("("+(i+1)+"/"+timesToRun+") The sorting took: " + durationInMilliSeconds +
                    " ms for " + amountToSort + " numbers!");
            durations[i] = durationInMilliSeconds;
        }

        Sort.bubbleSort(durations);
        if(Sort.isSorted(durations)){
            int totalDuration = 0;
            //skip first and last
            for (int i = 1; i < durations.length -1; i++) {
                totalDuration += durations[i];
            }
            int average = totalDuration / (durations.length-2);
            System.out.println("It took " + average + " ms in average to sort " + amountToSort + " random numbers");
        }
        else{
            System.out.println("Failed to sort the average durations");
        }
    }
}
