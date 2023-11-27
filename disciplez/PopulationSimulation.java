package disciplez;

import java.util.Arrays;

public class PopulationSimulation {

    public static final long INITIAL_POPULATION = 7700000000L;
    public static final int INITIAL_DISCIPLES = 13;
    public static final int MAX_AGE = 100; // Extended lifespan for better simulation
    public static final int AGE_OF_APPRENTICESHIP = 18;
    public static final int AGE_OF_GIVING_BIRTH = 30;
    public static final int TRAINING_PERIOD = 3;
    public static final int DISCIPLES_PER_TRAINER = 2;
    public static final double REPRODUCTION_RATE = 2.3; // Average global reproduction rate
    public static final int AVERAGE_LIFETIME = 72; // Average global lifetime

    public static void main(String[] args) {
        long year = 0;
        long currentDisciples = INITIAL_DISCIPLES;
        long[] peopleAgeDistribution = new long[MAX_AGE + 1];
        Arrays.fill(peopleAgeDistribution, 0);
        peopleAgeDistribution[AGE_OF_GIVING_BIRTH] = INITIAL_DISCIPLES;

        // Track total population including births during the simulation
        long totalPopulation = INITIAL_POPULATION;

        while (currentDisciples < totalPopulation) {
            year++;
            long trainers = 0;
            long births = 0;

            for (int age = MAX_AGE; age >= 0; age--) {
                long countAtAge = peopleAgeDistribution[age];
                peopleAgeDistribution[age] = 0;

                if (age < MAX_AGE) {
                    peopleAgeDistribution[age + 1] = countAtAge;
                }

                if (age >= AGE_OF_APPRENTICESHIP && (age - AGE_OF_APPRENTICESHIP) % TRAINING_PERIOD == 0) {
                    trainers += countAtAge;
                }

                if (age == AGE_OF_GIVING_BIRTH) {
                    births += (countAtAge / 2) * REPRODUCTION_RATE; // Adjusted for reproduction rate
                }
            }

            // Introduce realistic mortality rate based on age
            double mortalityRate = 1.0 / AVERAGE_LIFETIME;
            for (int age = 0; age <= MAX_AGE; age++) {
                peopleAgeDistribution[age] = (long) (peopleAgeDistribution[age] * (1 - mortalityRate));
            }

            // Add new disciples who have been trained this year
            long newDisciples = Math.min(trainers * DISCIPLES_PER_TRAINER, totalPopulation - currentDisciples);
            currentDisciples += newDisciples;
            peopleAgeDistribution[AGE_OF_APPRENTICESHIP] += newDisciples;

            // Simulate births for the year
            births = Math.min(births, totalPopulation - currentDisciples);
            totalPopulation += births; // Update the total population with new births
            peopleAgeDistribution[0] += births;

            System.out.println("Year " + year + ": Current population of disciples is " + currentDisciples + " out of " + totalPopulation);

            if (currentDisciples >= totalPopulation) {
                break;
            }
        }

        System.out.println("It took " + year + " years for the disciples to train the entire population (current and those born during the process) of " + totalPopulation + " people.");
    }
}

