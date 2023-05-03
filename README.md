# Guest Management System

This project implements a back-end system for managing a guest list for various educational events, such as "International Conference on Education". The application consists of three main components: the Guest class for representing a guest, the GuestsList class for managing the guest list, and the Main class as the main engine of the application.

## Specifications

### Guest class
A guest is defined in the system by the following fields:

- Last name
- First name
- Email
- Phone number

The Guest class provides methods for managing the guest's data.

### GuestsList class
The GuestsList class manages the guest list for an event. It contains the following details:

- Number of available seats at the event
- List of confirmed guests and of guests on the waiting list

The GuestsList class provides methods for managing the guest list, including adding, removing, searching and updating guests.

## Usage
The Main class provides a command-line interface for the user to interact with the guest list. The following commands are available:

- add - adds a new guest to the list
- search - searches for a guest in the guests list and waiting list
- update - updates a guest's details in the lists
- remove - removes a guest from the lists
- check - checks if the guest is on the guests list
- available - returns the number of free seats
- guests_no - returns the number of guests
- waitlist_no - returns the number of persons on the waiting list
- subscribe_no - returns the total number of people that signed up
- exit - exits the application
