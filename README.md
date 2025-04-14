# final_coursework

"Tourist Destination Catalog"
Catalogs tourists destinations, providing information about attractions, accomodations and activities for travellers.
Ametov Nurdin EEAIR-24

Description:
This project is a console-based Tourist Destination Catalog that allows users to add, view, update, delete, save tourist destination data, generates reports, provides search and sort functionalities.

Objectives:
Help users manage a list of travel destinations. Allow basic CRUD operations with data validation. Enable report generation and activity tracking.

Documentation:
This project implements a simple tourist destination catalog with CRUD operations (Create, Read, Update, Delete) using Java. The core data structure used is an ArrayList to store Destination objects, each containing information such as location, accommodation, cost, climate, safety, and attractions.

Data Structures:
ArrayList, Scanner, File I/O.

Methods:
addDestination, viewDestinations, updateDestination, deleteDestination, saveToFile, loadFromFile, showReport.

Challenges:
To be honest, this coursework was very difficult for me because I don't understand this programming language properly. I realized again that I can't write all the code myself, so it's sad.


Sample (Input and Output are also here):

Tourist Destination Catalog
1. Add Destination
2. View Destinations
3. Update Destination
4. Delete Destination
5. Save to File
6. Exit
7. Show Report
8. Search destination by location
9. Sort destinations by cost
Select an option: 1
Enter location: France
Enter accommodation: apartment
Enter cost: 69.9
Enter climate: dull
Enter safety info: not very safe
Enter attractions (comma separated): visit the Louvre, climb the Eiffel Tower
Destination added successfully.

Tourist Destination Catalog
1. Add Destination
2. View Destinations
3. Update Destination
4. Delete Destination
5. Save to File
6. Exit
7. Show Report
8. Search destination by location
9. Sort destinations by cost
Select an option: 1
Enter location: Italy
Enter accommodation: house
Enter cost: 49.9

Enter climate: Input cannot be empty. Please try again.
Enter climate: sunny
Enter safety info: above average
Enter attractions (comma separated): visit the Colosseum, go shopping in Milan
Destination added successfully.

Tourist Destination Catalog
1. Add Destination
2. View Destinations
3. Update Destination
4. Delete Destination
5. Save to File
6. Exit
7. Show Report
8. Search destination by location
9. Sort destinations by cost
Select an option: 2

List of Destinations:
№1: France, apartment, 69.9, dull, not very safe, visit the Louvre, climb the Eiffel Tower
№2: Italy, house, 49.9, sunny, above average, visit the Colosseum, go shopping in Milan

Tourist Destination Catalog
1. Add Destination
2. View Destinations
3. Update Destination
4. Delete Destination
5. Save to File
6. Exit
7. Show Report
8. Search destination by location
9. Sort destinations by cost
Select an option: 3

List of Destinations:
№1: France, apartment, 69.9, dull, not very safe, visit the Louvre, climb the Eiffel Tower
№2: Italy, house, 49.9, sunny, above average, visit the Colosseum, go shopping in Milan
Enter destination number to update: 1
Enter new location (current: France): 
Enter new accommodation (current: apartment): 
Enter new cost (current: 69.9): 
Enter new climate (current: dull): rainy
Enter new safety info (current: not very safe): 
Enter new attractions (current: visit the Louvre, climb the Eiffel Tower): 
Destination updated successfully.

Tourist Destination Catalog
1. Add Destination
2. View Destinations
3. Update Destination
4. Delete Destination
5. Save to File
6. Exit
7. Show Report
8. Search destination by location
9. Sort destinations by cost
Select an option: 1
Enter location: Spain
Enter accommodation: apartment
Enter cost: 39.9
Enter climate: sunny
Enter safety info: not safe
Enter attractions (comma separated): watch opera and dance
Destination added successfully.

Tourist Destination Catalog
1. Add Destination
2. View Destinations
3. Update Destination
4. Delete Destination
5. Save to File
6. Exit
7. Show Report
8. Search destination by location
9. Sort destinations by cost
Select an option: 4

List of Destinations:
№1: France, apartment, 69.9, rainy, not very safe, visit the Louvre, climb the Eiffel Tower
№2: Italy, house, 49.9, sunny, above average, visit the Colosseum, go shopping in Milan
№3: Spain, apartment, 39.9, sunny, not safe, watch opera and dance
Enter destination number to delete: 3
Destination deleted.

Tourist Destination Catalog
1. Add Destination
2. View Destinations
3. Update Destination
4. Delete Destination
5. Save to File
6. Exit
7. Show Report
8. Search destination by location
9. Sort destinations by cost
Select an option: 1
Enter location: Italy

Enter accommodation: Input cannot be empty. Please try again.
Enter accommodation: apartment
Enter cost: 59.9
Enter climate: nice
Enter safety info: safe
Enter attractions (comma separated): look at architectural and artistic works
Destination added successfully.

Tourist Destination Catalog
1. Add Destination
2. View Destinations
3. Update Destination
4. Delete Destination
5. Save to File
6. Exit
7. Show Report
8. Search destination by location
9. Sort destinations by cost
Select an option: 8
Enter keyword to search: Italy
Italy, house, 49.9, sunny, above average, visit the Colosseum, go shopping in Milan
Italy, apartment, 59.9, nice, safe, look at architectural and artistic works

Tourist Destination Catalog
1. Add Destination
2. View Destinations
3. Update Destination
4. Delete Destination
5. Save to File
6. Exit
7. Show Report
8. Search destination by location
9. Sort destinations by cost
Select an option: 9
Sort ascending? (true/false): true
Destinations sorted by cost (ascending):
Italy, house, 49.9, sunny, above average, visit the Colosseum, go shopping in Milan
Italy, apartment, 59.9, nice, safe, look at architectural and artistic works
France, apartment, 69.9, rainy, not very safe, visit the Louvre, climb the Eiffel Tower

Tourist Destination Catalog
1. Add Destination
2. View Destinations
3. Update Destination
4. Delete Destination
5. Save to File
6. Exit
7. Show Report
8. Search destination by location
9. Sort destinations by cost
Select an option: 7

=== Summary Report ===
Total destinations: 3
Add operations: 4
View operations: 1
Update operations: 1
Delete operations: 1
Save operations: 0

--- Activity Log ---
Loaded destinations from file [Tue Apr 15 00:20:50 GMT+06:00 2025]
Added new destination [Tue Apr 15 00:31:47 GMT+06:00 2025]
Added new destination [Tue Apr 15 00:35:56 GMT+06:00 2025]
Viewed all destinations [Tue Apr 15 00:36:07 GMT+06:00 2025]
Updated destination №1 [Tue Apr 15 00:37:52 GMT+06:00 2025]
Added new destination [Tue Apr 15 00:39:57 GMT+06:00 2025]
Deleted destination №3 [Tue Apr 15 00:40:01 GMT+06:00 2025]
Added new destination [Tue Apr 15 00:43:11 GMT+06:00 2025]
Searched for location: Italy [Tue Apr 15 00:43:30 GMT+06:00 2025]
Sorted destinations by cost (ascending) [Tue Apr 15 00:43:58 GMT+06:00 2025]

Tourist Destination Catalog
1. Add Destination
2. View Destinations
3. Update Destination
4. Delete Destination
5. Save to File
6. Exit
7. Show Report
8. Search destination by location
9. Sort destinations by cost
Select an option: 5

Destinations saved to destinations.csv

Tourist Destination Catalog
1. Add Destination
2. View Destinations
3. Update Destination
4. Delete Destination
5. Save to File
6. Exit
7. Show Report
8. Search destination by location
9. Sort destinations by cost
Select an option: Invalid option. Try again.

Tourist Destination Catalog
1. Add Destination
2. View Destinations
3. Update Destination
4. Delete Destination
5. Save to File
6. Exit
7. Show Report
8. Search destination by location
9. Sort destinations by cost
Select an option: 6
Exiting program.

Process finished with exit code 0


Presentation:

