# final_coursework

# Tourist Destination Catalog

Catalogs tourists destinations, providing information about attractions, accomodations and activities for travellers.

Made by Ametov Nurdin 

Group: EEAIR-24

# Description:
This project is a console-based Tourist Destination Catalog. It allows users to:

- Add, view, update, and delete tourist destination data

- Save and load data from a file

- Search destinations by location

- Sort destinations by cost

- Generate activity reports and view action history

# Objectives:
- Help users manage a list of travel destinations. 

- Allow basic CRUD operations with data validation. 

- Enable report generation and activity tracking.

# Documentation:
The project uses basic object-oriented programming in Java and implements a tourist catalog using the following core features:

- Data structure: ArrayList to store destination entries

- File handling: Read/write to .csv file for data persistence

- Console input: Scanner for user interaction

- Validation: Ensures data correctness (e.g., cost must be a valid number)

- Reporting: Counts user actions and logs activity with timestamps

# Data Structures:
ArrayList, Scanner, File I/O, Comparator (for sorting), Simple menu system

# Methods:
- addDestination() – Adds a new destination with user input and validation

- viewDestinations() – Displays all saved destinations

- updateDestination() – Edits existing destination data

- deleteDestination() – Removes a destination from the list

- saveToFile() – Saves the list to a .csv file

- loadFromFile() – Loads data from a .csv file

- showReport() – Shows activity summary and log

- searchDestinationByLocation() – Searches for destinations by keyword

- sortDestinationsByCost() – Sorts destinations by cost (ascending/descending)

# Challenges:
To be honest, this coursework was very difficult for me because I don't understand this programming language properly. I realized again that I can't write all the code myself, so it's sad.


# Sample (Input and Output are also here):

![image](https://github.com/user-attachments/assets/5cf37776-770c-4e0d-b4d0-6bb048c9c9f8)

![image](https://github.com/user-attachments/assets/627ea5da-9d48-4380-8f83-f2edebef609d)

![image](https://github.com/user-attachments/assets/dfa1c99b-1b9f-4402-9d8e-8a8087471c2b)

![image](https://github.com/user-attachments/assets/c46d4dd6-349b-4494-b2af-7809b629b3f4)

![image](https://github.com/user-attachments/assets/b6ac6a1a-21d1-4e3d-a4b8-e21c59c1fc48)

![image](https://github.com/user-attachments/assets/93ebe48f-a6a7-4602-842f-09b0b7f18c7b)

![image](https://github.com/user-attachments/assets/44c39ddb-ab4f-4ac0-a0f7-2378e0bd3784)

![image](https://github.com/user-attachments/assets/a9ea09d3-ad48-407f-9392-27ba1ec15210)

![image](https://github.com/user-attachments/assets/65e2299b-642f-4c21-acd3-cbc2f85e8fe0)

![image](https://github.com/user-attachments/assets/f3b147b1-3c42-4cd5-845f-985b1565ce08)

![image](https://github.com/user-attachments/assets/4a9a13fa-4ef9-4511-ab6f-60725c7ce3cc)



# Presentation:

The project consists of two classes: 

Destination (Represents one tourist point. Contains the fields: location, accommodation, cost, climate, safety, attractions. Methods for getting/setting data, as well as converting to/from CSV format);

TouristCatalog (The main class containing the program logic and the main() method. Stores a list of destinations (List<Destination>), operation counters and an activity log. Works through a menu with user input, allowing you to perform all actions).


# Implementation and main features:
- Adding a destination (Requests all fields from the user. Validation for empty input and correctness of numbers (cost) ).

- View (Shows all saved directions in a readable format).

- Editing (The user selects the direction number. You can update any field (if left empty, the field will not change) ).

- Delete (Deletes the selected direction by number in the list).

- Save and Load (Saves directions to the destinations.csv file with a header. When launched, automatically loads data from the file).

- Search (Allows you to find directions by a substring in the location name).

- Sorting (Sorting by cost (ascending or descending) ).

- Report (Shows the number of completed operations. Displays a log of actions with timestamps).



# Project supports Data Export and Import:

![image](https://github.com/user-attachments/assets/503a18e7-2460-4c8a-9be6-b44ea952531e)

This catalog is simple but functional. It demonstrates how real-world features like storage, sorting, and searching can be implemented with basic Java tools. It is a good practice project for beginners.
