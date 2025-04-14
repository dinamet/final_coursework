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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(String accommodation) {
        this.accommodation = accommodation;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getSafety() {
        return safety;
    }

    public void setSafety(String safety) {
        this.safety = safety;
    }

    public String getAttractions() {
        return attractions;
    }

    public void setAttractions(String attractions) {
        this.attractions = attractions;
    }

    public String toCSV() {
        return location + ", " + accommodation + ", " + cost + ", " + climate + ", " + safety + ", " + attractions;
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
            }
        }
    }

    private static void addDestination() {
        System.out.print("Enter location: ");
        String location = scanner.nextLine();

        System.out.print("Enter accommodation: ");
        String accommodation = scanner.nextLine();

        double cost = 0;
        while (true) {
            try {
                System.out.print("Enter cost: ");
                cost = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid cost. Please enter a number.");
            }
        }

        System.out.print("Enter climate: ");
        String climate = scanner.nextLine();

        System.out.print("Enter safety info: ");
        String safety = scanner.nextLine();

        System.out.print("Enter attractions (comma separated): ");
        String attractions = scanner.nextLine();

        destinations.add(new Destination(location, accommodation, cost, climate, safety, attractions));
        System.out.println("Destination added successfully.");
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
        if (!costStr.isEmpty()) d.setCost(Double.parseDouble(costStr));

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
    }

    private static void deleteDestination() {
        viewDestinations();
        System.out.print("Enter destination number to delete: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;

        if (index < 0 || index >= destinations.size()) {
            System.out.println("Invalid index.");
            return;
        }

        destinations.remove(index);
        logActivity("Deleted destination №" + (index + 1));
        System.out.println("Destination deleted.");
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
}
