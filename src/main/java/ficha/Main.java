package ficha;
import java.util.Scanner;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics();

        System.out.println("Enter numbers separated by space:");
        String input = scanner.nextLine();
        String[] tokens = input.split("\\s+");
        for (String token : tokens) {
            try {
                double value = Double.parseDouble(token);
                descriptiveStatistics.addValue(value);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number: " + token);
            }
        }

        double mean = descriptiveStatistics.getMean();
        double median = descriptiveStatistics.getPercentile(50);
        double standardDeviation = descriptiveStatistics.getStandardDeviation();

        System.out.println("Mean: " + mean);
        System.out.println("Median: " + median);
        System.out.println("Standard Deviation: " + standardDeviation);
    }
}