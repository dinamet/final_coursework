import java.io.*;
import java.util.*;

class Destination {
    private String location;
    private String accommodation;
    private double cost;
    private String climate;
    private String safety;
    private String attractions;

    public Destination(String location, String accommodation, double cost, String climate, String safety, String attractions) {
        this.location = location;
        this.accommodation = accommodation;
        this.cost = cost;
        this.climate = climate;
        this.safety = safety;
        this.attractions = attractions;
    }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public String getAccommodation() { return accommodation; }
    public void setAccommodation(String accommodation) { this.accommodation = accommodation; }
    public double getCost() { return cost; }
    public void setCost(double cost) { this.cost = cost; }
    public String getClimate() { return climate; }
    public void setClimate(String climate) { this.climate = climate; }
    public String getSafety() { return safety; }
    public void setSafety(String safety) { this.safety = safety; }
    public String getAttractions() { return attractions; }
    public void setAttractions(String attractions) { this.attractions = attractions; }

    public String toCSV() {
        return location + ", " + accommodation + ", " + cost + ", " + climate + ", " + safety + ", " + attractions;
    }

    public static Destination fromCSV(String line) {
        String[] parts = line.split(", ", 6);
        if (parts.length < 6) return null;
        try {
            String location = parts[0];
            String accommodation = parts[1];
            double cost = Double.parseDouble(parts[2]);
            String climate = parts[3];
            String safety = parts[4];
            String attractions = parts[5];
            return new Destination(location, accommodation, cost, climate, safety, attractions);
        } catch (Exception e) {
            return null;
        }
    }
}

public class TouristCatalog {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Destination> destinations = new ArrayList<>();
    private static final String FILE_NAME = "destinations.csv";

    private static int addCount = 0;
    private static int viewCount = 0;
    private static int updateCount = 0;
    private static int deleteCount = 0;
    private static int saveCount = 0;
    private static final List<String> activityLog = new ArrayList<>();

    public static void main(String[] args) {
        loadFromFile();

        boolean running = true;
        while (running) {
            System.out.println("\nTourist Destination Catalog");
            System.out.println("1. Add Destination");
            System.out.println("2. View Destinations");
            System.out.println("3. Update Destination");
            System.out.println("4. Delete Destination");
            System.out.println("5. Save to File");
            System.out.println("6. Exit");
            System.out.println("7. Show Report");
            System.out.println("8. Search destination by location");
            System.out.println("9. Sort destinations by cost");
            System.out.print("Select an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    addDestination();
                    addCount++;
                    logActivity("Added new destination");
                }
                case "2" -> {
                    viewDestinations();
                    viewCount++;
                    logActivity("Viewed all destinations");
                }
                case "3" -> {
                    updateDestination();
                    updateCount++;
                }
                case "4" -> {
                    deleteDestination();
                    deleteCount++;
                }
                case "5" -> {
                    saveToFile();
                    saveCount++;
                }
                case "6" -> {
                    logActivity("Exited program");
                    System.out.println("Exiting program.");
                    running = false;
                }
                case "7" -> showReport();
                default -> System.out.println("Invalid option. Try again.");
                case "8" -> {
                    System.out.print("Enter keyword to search: ");
                    String keyword = scanner.nextLine();
                    searchDestinationByLocation(keyword);
                    logActivity("Searched for location: " + keyword);
                }
                case "9" -> {
                    System.out.print("Sort ascending? (true/false): ");
                    boolean ascending = Boolean.parseBoolean(scanner.nextLine());
                    sortDestinationsByCost(ascending);
                    logActivity("Sorted destinations by cost (" + (ascending ? "ascending" : "descending") + ")");
                }

            }
        }
    }

    private static void addDestination() {
        String location = promptNonEmpty("Enter location: ");
        String accommodation = promptNonEmpty("Enter accommodation: ");

        double cost = 0;
        while (true) {
            try {
                System.out.print("Enter cost: ");
                String costStr = scanner.nextLine();
                if (costStr.isEmpty()) throw new IllegalArgumentException("Cost cannot be empty");
                cost = Double.parseDouble(costStr);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid cost. Please enter a number.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        String climate = promptNonEmpty("Enter climate: ");
        String safety = promptNonEmpty("Enter safety info: ");
        String attractions = promptNonEmpty("Enter attractions (comma separated): ");

        destinations.add(new Destination(location, accommodation, cost, climate, safety, attractions));
        System.out.println("Destination added successfully.");
    }

    private static String promptNonEmpty(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            if (!input.trim().isEmpty()) return input;
            System.out.println("Input cannot be empty. Please try again.");
        }
    }

    private static void viewDestinations() {
        if (destinations.isEmpty()) {
            System.out.println("No destinations available.");
            return;
        }

        System.out.println("\nList of Destinations:");
        int index = 1;
        for (Destination d : destinations) {
            System.out.println("№" + index++ + ": " + d.toCSV());
        }
    }

    private static void updateDestination() {
        viewDestinations();
        System.out.print("Enter destination number to update: ");
        try {
            int index = Integer.parseInt(scanner.nextLine()) - 1;

            if (index < 0 || index >= destinations.size()) {
                System.out.println("Invalid index.");
                return;
            }

            Destination d = destinations.get(index);

            System.out.print("Enter new location (current: " + d.getLocation() + "): ");
            String location = scanner.nextLine();
            if (!location.isEmpty()) d.setLocation(location);

            System.out.print("Enter new accommodation (current: " + d.getAccommodation() + "): ");
            String accommodation = scanner.nextLine();
            if (!accommodation.isEmpty()) d.setAccommodation(accommodation);

            System.out.print("Enter new cost (current: " + d.getCost() + "): ");
            String costStr = scanner.nextLine();
            if (!costStr.isEmpty()) {
                try {
                    d.setCost(Double.parseDouble(costStr));
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number. Cost not updated.");
                }
            }

            System.out.print("Enter new climate (current: " + d.getClimate() + "): ");
            String climate = scanner.nextLine();
            if (!climate.isEmpty()) d.setClimate(climate);

            System.out.print("Enter new safety info (current: " + d.getSafety() + "): ");
            String safety = scanner.nextLine();
            if (!safety.isEmpty()) d.setSafety(safety);

            System.out.print("Enter new attractions (current: " + d.getAttractions() + "): ");
            String attractions = scanner.nextLine();
            if (!attractions.isEmpty()) d.setAttractions(attractions);

            logActivity("Updated destination №" + (index + 1));
            System.out.println("Destination updated successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Update cancelled.");
        }
    }

    private static void deleteDestination() {
        viewDestinations();
        System.out.print("Enter destination number to delete: ");
        try {
            int index = Integer.parseInt(scanner.nextLine()) - 1;

            if (index < 0 || index >= destinations.size()) {
                System.out.println("Invalid index.");
                return;
            }

            destinations.remove(index);
            logActivity("Deleted destination №" + (index + 1));
            System.out.println("Destination deleted.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Deletion cancelled.");
        }
    }

    private static void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            writer.println("№, Location, Accommodation, Cost (USD), Climate, Safety, Attractions");

            int index = 1;
            for (Destination d : destinations) {
                writer.println(index++ + ", " + d.toCSV());
            }

            System.out.println("Destinations saved to " + FILE_NAME);
            logActivity("Saved destinations to file");
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }

    private static void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            reader.readLine(); // Skip header
            while ((line = reader.readLine()) != null) {
                String[] splitLine = line.split(", ", 2);
                if (splitLine.length == 2) {
                    Destination d = Destination.fromCSV(splitLine[1]);
                    if (d != null) destinations.add(d);
                }
            }
            logActivity("Loaded destinations from file");
        } catch (IOException e) {
            System.out.println("No previous data to load or error reading file.");
        }
    }

    private static void showReport() {
        System.out.println("\n=== Summary Report ===");
        System.out.println("Total destinations: " + destinations.size());
        System.out.println("Add operations: " + addCount);
        System.out.println("View operations: " + viewCount);
        System.out.println("Update operations: " + updateCount);
        System.out.println("Delete operations: " + deleteCount);
        System.out.println("Save operations: " + saveCount);
        System.out.println("\n--- Activity Log ---");
        for (String log : activityLog) {
            System.out.println(log);
        }
    }

    private static void logActivity(String message) {
        activityLog.add(message + " [" + new Date() + "]");
    }

    private static void searchDestinationByLocation(String keyword) {
        boolean found = false;
        for (Destination d : destinations) {
            if (d.getLocation().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(d.toCSV());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No destinations found with keyword: " + keyword);
        }
    }

    private static void sortDestinationsByCost(boolean ascending) {
        destinations.sort((d1, d2) -> {
            if (ascending) {
                return Double.compare(d1.getCost(), d2.getCost());
            } else {
                return Double.compare(d2.getCost(), d1.getCost());
            }
        });

        System.out.println("Destinations sorted by cost (" + (ascending ? "ascending" : "descending") + "):");
        for (Destination d : destinations) {
            System.out.println(d.toCSV());
        }
    }
}
