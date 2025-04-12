// Tourist Destination Catalog
// Catalogs tourist destinations, providing information about attractions, accommodations and activities for travelers

import java.io.*;
import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Destination> destinations = new ArrayList<>();
    private static final String FILE_NAME = "destinations.csv";

    public static void main(String[] args) {
        loadDestinations();
        boolean exit = false;
        while (!exit) {
            System.out.println("\n=== Tourist Destination Catalog ===");
            System.out.println("1. Add destination");
            System.out.println("2. View destinations");
            System.out.println("3. Update destination");
            System.out.println("4. Delete destination");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> addDestination();
                case "2" -> viewDestinations();
                case "3" -> updateDestination();
                case "4" -> deleteDestination();
                case "5" -> exit = true;
                default -> System.out.println("Invalid option.");
            }
        }
        saveDestinations();
        System.out.println("Goodbye!");
    }

    private static void addDestination() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter country: ");
        String country = scanner.nextLine();
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        System.out.print("Enter accommodation: ");
        String accommodation = scanner.nextLine();
        System.out.print("Enter activity: ");
        String activity = scanner.nextLine();

        Destination dest = new Destination(name, country, description, accommodation, activity);
        destinations.add(dest);
        System.out.println("Destination added.");
    }

    private static void viewDestinations() {
        if (destinations.isEmpty()) {
            System.out.println("No destinations found.");
        } else {
            for (int i = 0; i < destinations.size(); i++) {
                System.out.println((i + 1) + ". " + destinations.get(i));
            }
        }
    }

    private static void updateDestination() {
        viewDestinations();
        if (destinations.isEmpty()) return;
        System.out.print("Enter number to update: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        if (index < 0 || index >= destinations.size()) {
            System.out.println("Invalid number.");
            return;
        }

        Destination dest = destinations.get(index);
        System.out.print("Enter new description: ");
        dest.setDescription(scanner.nextLine());
        System.out.print("Enter new accommodation: ");
        dest.setAccommodation(scanner.nextLine());
        System.out.print("Enter new activity: ");
        dest.setActivity(scanner.nextLine());
        System.out.println("Destination updated.");
    }

    private static void deleteDestination() {
        viewDestinations();
        if (destinations.isEmpty()) return;
        System.out.print("Enter number to delete: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        if (index < 0 || index >= destinations.size()) {
            System.out.println("Invalid number.");
            return;
        }
        destinations.remove(index);
        System.out.println("Destination deleted.");
    }

    private static void saveDestinations() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Destination d : destinations) {
                writer.write(String.join(",",
                        escape(d.getName()),
                        escape(d.getCountry()),
                        escape(d.getDescription()),
                        escape(d.getAccommodation()),
                        escape(d.getActivity())
                ));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving destinations: " + e.getMessage());
        }
    }

    private static void loadDestinations() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", -1);
                if (parts.length == 5) {
                    Destination d = new Destination(unescape(parts[0]), unescape(parts[1]), unescape(parts[2]), unescape(parts[3]), unescape(parts[4]));
                    destinations.add(d);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading destinations: " + e.getMessage());
        }
    }

    // Обработка запятых в CSV
    private static String escape(String text) {
        if (text.contains(",") || text.contains("\"")) {
            text = text.replace("\"", "\"\"");
            return "\"" + text + "\"";
        }
        return text;
    }

    private static String unescape(String text) {
        if (text.startsWith("\"") && text.endsWith("\"")) {
            text = text.substring(1, text.length() - 1);
            return text.replace("\"\"", "\"");
        }
        return text;
    }
}

class Destination {
    private String name;
    private String country;
    private String description;
    private String accommodation;
    private String activity;

    public Destination(String name, String country, String description, String accommodation, String activity) {
        this.name = name;
        this.country = country;
        this.description = description;
        this.accommodation = accommodation;
        this.activity = activity;
    }

    public String getName() { return name; }
    public String getCountry() { return country; }
    public String getDescription() { return description; }
    public String getAccommodation() { return accommodation; }
    public String getActivity() { return activity; }

    public void setDescription(String description) { this.description = description; }
    public void setAccommodation(String accommodation) { this.accommodation = accommodation; }
    public void setActivity(String activity) { this.activity = activity; }

    @Override
    public String toString() {
        return name + ", " + country + ": " + description + ". Stay at " + accommodation + ". Activities: " + activity;
    }
}
