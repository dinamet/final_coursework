import java.io.*;
import java.util.*;

public class TouristDestinationCatalog {

    static class Destination {
        private String name;
        private String location;
        private String accommodation;
        private double cost;
        private String activities;

        public Destination(String name, String location, String accommodation, double cost, String activities) {
            this.name = name;
            this.location = location;
            this.accommodation = accommodation;
            this.cost = cost;
            this.activities = activities;
        }

        public String toCSV() {
            return name + "," + location + "," + accommodation + "," + cost + "," + activities;
        }

        @Override
        public String toString() {
            return "Destination: " + name + "\n" +
                    "Location: " + location + "\n" +
                    "Accommodation: " + accommodation + "\n" +
                    "Cost: $" + cost + "\n" +
                    "Activities: " + activities + "\n";
        }
    }

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Destination> destinations = new ArrayList<>();
    private static final String FILE_NAME = "destinations.csv";

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = getIntInput("Choose an option: ");
            switch (choice) {
                case 1 -> addDestination();
                case 2 -> displayDestinations();
                case 3 -> saveToFile();
                case 4 -> {
                    System.out.println("Exiting program.");
                    running = false;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n=== Tourist Destination Catalog ===");
        System.out.println("1. Add Destination");
        System.out.println("2. View All Destinations");
        System.out.println("3. Save to CSV File");
        System.out.println("4. Exit");
    }

    private static void addDestination() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter location: ");
        String location = scanner.nextLine();

        System.out.print("Enter accommodation: ");
        String accommodation = scanner.nextLine();

        double cost = getDoubleInput("Enter estimated cost (USD): ");

        System.out.print("Enter activities: ");
        String activities = scanner.nextLine();

        Destination d = new Destination(name, location, accommodation, cost, activities);
        destinations.add(d);
        System.out.println("Destination added!");
    }

    private static void displayDestinations() {
        if (destinations.isEmpty()) {
            System.out.println("No destinations available.");
            return;
        }

        for (Destination d : destinations) {
            System.out.println("-------------------------------");
            System.out.println(d);
        }
    }

    private static void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Destination d : destinations) {
                writer.println(d.toCSV());
            }
            System.out.println("Destinations saved to " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }

    private static int getIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }

    private static double getDoubleInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                return Double.parseDouble(input.trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }
}
