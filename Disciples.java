package growth;

public class Disciples {

	    // Function to calculate years required to reach 7.7 billion disciples
	    public static int calculateYears() {
	        long currentDisciples = 13;
	        long totalHumans = 7700000000L;
	        int years = 0;

	        while (currentDisciples < totalHumans) {
	            currentDisciples *= 2;  // each disciple trains 2 new disciples
	            years += 3;  // this doubling happens every 3 years
	        }

	        return years;
	    }

	    // Function to find out how many disciples should start with to cover 7.7 billion in 50 years
	    public static long disciplesForFiftyYears() {
	        long initialDisciples = 1;  // Starting with a hypothetical number
	        long totalHumans = 7700000000L;
	        int maxYears = 50;

	        while (true) {
	            long currentDisciples = initialDisciples;
	            int years = 0;

	            while (years < maxYears) {
	                currentDisciples *= 2;  // each disciple trains 2 new disciples
	                years += 3;  // this doubling happens every 3 years
	            }

	            if (currentDisciples >= totalHumans) {
	                break;
	            }

	            initialDisciples++;  // increase the hypothetical number of initial disciples and try again
	        }

	        return initialDisciples;
	    }

	    public static void main(String[] args) {
	        int yearsRequired = calculateYears();
	        System.out.println("Years required to convert all humans to disciples: " + yearsRequired + " years");

	        long initialDisciplesRequired = disciplesForFiftyYears();
	        System.out.println("Number of disciples required to make it happen in 50 years: " + initialDisciplesRequired);
	    }
	}

