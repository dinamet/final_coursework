import java.io.*;
import java.util.*;

public class TouristDestinationCatalog {

    static class Destination {
        private String name;
        private String location;
        private String accommodation;
        private double cost;
        private String climate;
        private String safety;
        private String attractions;

        public Destination(String name, String location, String accommodation, double cost, String climate, String safety, String attractions) {
            this.name = name;
            this.location = location;
            this.accommodation = accommodation;
            this.cost = cost;
            this.climate = climate;
            this.safety = safety;
            this.attractions = attractions;
        }

        public String toCSV() {
            return name + "," + location + "," + accommodation + "," + cost + "," + climate + "," + safety + "," + attractions;
        }

        @Override
        public String toString() {
            return "Name: " + name + "\n" +
                    "Location: " + location + "\n" +
                    "Accommodation: " + accommodation + "\n" +
                    "Cost: $" + cost + "\n" +
                    "Climate: " + climate + "\n" +
                    "Safety: " + safety + "\n" +
                    "Attractions: " + attractions;
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
                case 2 -> viewDestinations();
                case 3 -> updateDestination();
                case 4 -> deleteDestination();
                case 5 -> saveToFile();
                case 6 -> {
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
        System.out.println("3. Update Destination");
        System.out.println("4. Delete Destination");
        System.out.println("5. Save to CSV File");
        System.out.println("6. Exit");
    }

    // method
    private static void addDestination() {
        System.out.println("\n--- Add New Destination ---");
        String name = input("Name: ");
        String location = input("Location: ");
        String accommodation = input("Accommodation: ");
        double cost = getDoubleInput("Cost (USD): ");
        String climate = input("Climate: ");
        String safety = input("Safety: ");
        String attractions = input("Attractions: ");

        Destination d = new Destination(name, location, accommodation, cost, climate, safety, attractions);
        destinations.add(d);
        System.out.println("Destination added!");
    }

    // method
    private static void viewDestinations() {
        System.out.println("\n--- All Destinations ---");
        if (destinations.isEmpty()) {
            System.out.println("No destinations available.");
            return;
        }

        for (int i = 0; i < destinations.size(); i++) {
            System.out.println("\n[" + (i + 1) + "]");
            System.out.println(destinations.get(i));
        }
    }

    // method
    private static void updateDestination() {
        viewDestinations();
        if (destinations.isEmpty()) return;

        int index = getIntInput("Enter destination number to update: ") - 1;
        if (index < 0 || index >= destinations.size()) {
            System.out.println("Invalid index.");
            return;
        }

        System.out.println("--- Enter new data (leave blank to keep current) ---");
        Destination d = destinations.get(index);

        String name = inputOrDefault("Name (" + d.name + "): ", d.name);
        String location = inputOrDefault("Location (" + d.location + "): ", d.location);
        String accommodation = inputOrDefault("Accommodation (" + d.accommodation + "): ", d.accommodation);
        String costStr = input("Cost (" + d.cost + "): ");
        double cost = costStr.isEmpty() ? d.cost : Double.parseDouble(costStr);
        String climate = inputOrDefault("Climate (" + d.climate + "): ", d.climate);
        String safety = inputOrDefault("Safety (" + d.safety + "): ", d.safety);
        String attractions = inputOrDefault("Attractions (" + d.attractions + "): ", d.attractions);

        destinations.set(index, new Destination(name, location, accommodation, cost, climate, safety, attractions));
        System.out.println("Destination updated!");
    }

    // method
    private static void deleteDestination() {
        viewDestinations();
        if (destinations.isEmpty()) return;

        int index = getIntInput("Enter destination number to delete: ") - 1;
        if (index < 0 || index >= destinations.size()) {
            System.out.println("Invalid index.");
            return;
        }

        destinations.remove(index);
        System.out.println("Destination deleted!");
    }

    // method
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

    // --- Utility Methods ---
    private static String input(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static String inputOrDefault(String prompt, String defaultValue) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();
        return input.isEmpty() ? defaultValue : input;
    }

    private static int getIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }

    private static double getDoubleInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }
}
