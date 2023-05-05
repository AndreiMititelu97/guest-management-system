import src.GuestsList;
import java.util.Scanner;
import src.Guest;
public class Main {
    private static void showCommands() {
        System.out.println("add          - Add a new guest");
        System.out.println("check        - Check if a person is booked to this event");
        System.out.println("remove       - Remove a guest from the list");
        System.out.println("update       - Edit guest information");
        System.out.println("guests       - List of booked guests");
        System.out.println("waitlist     - List of people in the waiting list");
        System.out.println("available    - Number of free seats");
        System.out.println("guests_no    - Number of booked guests");
        System.out.println("waitlist_no  - Number of people in the waiting list");
        System.out.println("subscribe_no - Total number of people enrolled");
        System.out.println("search       - Search a person using a string");
        System.out.println("quit         - Close the app");
    }

    private static void addNewGuest(Scanner sc, GuestsList list) {
        System.out.print("Insert the last name of the guest: ");
        String lastName = sc.next();

        System.out.print("Insert the first name of the guest: ");
        String firstName = sc.next();

        System.out.print("Insert the email of the guest: ");
        String email = sc.next();

        System.out.print("Insert the phone number of the guest: ");
        String phoneNumber = sc.next();
        sc.nextLine();

        list.add(new Guest(lastName, firstName, email, phoneNumber));
    }

    private static void checkGuest(Scanner sc, GuestsList list) {
        System.out.format("How would you like to search for the person?\n" +
                "1. Last name and first name\n" +
                "2. Email address\n" +
                "3. Phone number\n" +
                "Choice: ");
        int option = sc.nextInt();

        switch(option){
            case 1:
                System.out.print("Insert the last name of the person: ");
                String lastName = sc.next();

                System.out.print("Insert the first name of the person: ");
                String firstName = sc.next();

                Guest guestToSearch = list.search(lastName, firstName);
                if(guestToSearch == null){
                    System.out.println("No person found with this information");
                }else{
                    System.out.println(guestToSearch);
                }
                sc.nextLine();
                break;
            case 2:
                System.out.print("Insert the email address of the person: ");
                String match = sc.next();

                guestToSearch = list.search(2, match);
                if(guestToSearch == null){
                    System.out.println("No person found with this information");
                }else{
                    System.out.println(guestToSearch);
                }
                sc.nextLine();
                break;
            case 3:
                System.out.print("Insert the phone number of the person: ");
                match = sc.next();

                guestToSearch = list.search(3, match);
                if(guestToSearch == null){
                    System.out.println("No person found with this information");
                }else{
                    System.out.println(guestToSearch);
                }
                sc.nextLine();
                break;
        }
    }

    private static void removeGuest(Scanner sc, GuestsList list) {
        System.out.format("How would you like to search for the person?\n" +
                "1. Last name and first name\n" +
                "2. Email address\n" +
                "3. Phone number\n" +
                "Choice: ");
        int option = sc.nextInt();

        switch(option){
            case 1:
                System.out.print("Insert the last name of the person: ");
                String lastName = sc.next();

                System.out.print("Insert the first name of the person: ");
                String firstName = sc.next();

                boolean isGuestRemoved = list.remove(lastName, firstName);
                if(isGuestRemoved){
                    System.out.println("Person has been removed");
                }else{
                    System.out.println("Can not remove that person");
                }

                sc.nextLine();
                break;
            case 2:
                System.out.print("Insert the email address of the person: ");
                String match = sc.next();

                isGuestRemoved = list.remove(2, match);
                if(isGuestRemoved){
                    System.out.println("Person has been removed");
                }else{
                    System.out.println("Can not remove that person");
                }

                sc.nextLine();
                break;
            case 3:
                System.out.print("Insert the phone number of the person: ");
                match = sc.next();

                isGuestRemoved = list.remove(3, match);
                if(isGuestRemoved){
                    System.out.println("Person has been removed");
                }else{
                    System.out.println("Can not remove that person");
                }

                sc.nextLine();
                break;
        }
    }

    private static void updateGuest(Scanner sc, GuestsList list) {
        System.out.format("How would you like to search for the person?\n" +
                "1. Last name and first name\n" +
                "2. Email address\n" +
                "3. Phone number\n" +
                "Choice: ");
        int auth = sc.nextInt();

        Guest guestToEdit = null;
        switch(auth){
            case 1:
                System.out.print("Insert the last name of the person: ");
                String lastName = sc.next();

                System.out.print("Insert the first name of the person: ");
                String firstName = sc.next();


                guestToEdit = list.search(lastName, firstName);
                if(guestToEdit == null){
                    System.out.println("No person found with this information");
                    sc.nextLine();
                    return;
                }

                System.out.println(guestToEdit);
                sc.nextLine();
                break;
            case 2:
                System.out.print("Insert the email address of the person: ");
                String match = sc.next();

                guestToEdit = list.search(2, match);
                if(guestToEdit == null) {
                    System.out.println("No person found with this information");
                    sc.nextLine();
                    return;
                }
                System.out.println(guestToEdit);
                sc.nextLine();
                break;
            case 3:
                System.out.print("Insert the phone number of the person: ");
                match = sc.next();

                guestToEdit = list.search(3, match);
                if(guestToEdit == null){
                    System.out.println("No person found with this information");
                    sc.nextLine();
                    return;
                }

                System.out.println(guestToEdit);
                sc.nextLine();
                break;
        }

        System.out.format("Which field would you like to edit?\n" +
                "1. Last name\n" +
                "2. First name\n" +
                "3. Email address\n" +
                "4. Phone number\n" +
                "Choice: ");
        int fieldToEdit = sc.nextInt();

        switch(fieldToEdit){
            case 1:
                System.out.println("Insert new last name: ");
                String lastName = sc.next();

                list.edit(1, lastName, guestToEdit);
                sc.nextLine();
                System.out.println("Changes are done.");
                break;
            case 2:
                System.out.println("Insert new first name: ");
                String firstName = sc.next();

                list.edit(2, firstName, guestToEdit);
                sc.nextLine();
                System.out.println("Changes are done.");
                break;
            case 3:
                System.out.println("Insert new email address: ");
                String email = sc.next();

                list.edit(3, email, guestToEdit);
                sc.nextLine();
                System.out.println("Changes are done.");
                break;
            case 4:
                System.out.println("Insert new phone number: ");
                String phoneNumber = sc.next();

                list.edit(4, phoneNumber, guestToEdit);
                sc.nextLine();
                System.out.println("Changes are done.");
                break;
        }
    }

    private static void searchList(Scanner sc, GuestsList list) {
       String str = sc.next();
       list.partialSearch(str);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Insert the size of the guests list: ");
        int size = scanner.nextInt();
        scanner.nextLine();
        System.out.println();

        GuestsList list = new GuestsList(size);

        boolean exit = false;
        while (!exit) {
            showCommands();

            System.out.print("\nInsert a command: ");
            String command = scanner.nextLine();
            System.out.println();

            switch (command) {
                case "add":
                    addNewGuest(scanner, list);
                    System.out.println();
                    break;
                case "check":
                    checkGuest(scanner, list);
                    System.out.println();
                    break;
                case "remove":
                    removeGuest(scanner, list);
                    System.out.println();
                    break;
                case "update":
                    updateGuest(scanner, list);
                    System.out.println();
                    break;
                case "guests":
                    list.showGuestsList();
                    System.out.println();
                    break;
                case "waitlist":
                    list.showWaitingList();
                    System.out.println();
                    break;
                case "available":
                    System.out.println("Number of empty seats: " + list.numberOfAvailableSpots());
                    System.out.println();
                    break;
                case "guests_no":
                    System.out.println("Number of guests: " + list.numberOfGuests());
                    System.out.println();
                    break;
                case "waitlist_no":
                    System.out.println("Waiting list size: " + list.numberOfPeopleWaiting());
                    System.out.println();
                    break;
                case "subscribe_no":
                    System.out.println("Total persons: " + list.numberOfPeopleTotal());
                    System.out.println();
                    break;
                case "search":
                    searchList(scanner, list);
                    System.out.println();
                    break;
                case "quit":
                    System.out.println("Goodbye!");
                    scanner.close();
                    exit = true;
                    break;
                default:
                    System.out.println("Command is invalid, please try again\n");
                    break;
            }
        }
    }
}
