import src.GuestsList;
import java.util.Scanner;
import src.Guest;
public class Main {
    private static void showCommands() {
        System.out.println("help         - Afiseaza aceasta lista de comenzi");
        System.out.println("add          - Adauga o noua persoana (inscriere)");
        System.out.println("check        - Verifica daca o persoana este inscrisa la eveniment");
        System.out.println("remove       - Sterge o persoana existenta din lista");
        System.out.println("update       - Actualizeaza detaliile unei persoane");
        System.out.println("guests       - Lista de persoane care participa la eveniment");
        System.out.println("waitlist     - Persoanele din lista de asteptare");
        System.out.println("available    - Numarul de locuri libere");
        System.out.println("guests_no    - Numarul de persoane care participa la eveniment");
        System.out.println("waitlist_no  - Numarul de persoane din lista de asteptare");
        System.out.println("subscribe_no - Numarul total de persoane inscrise");
        System.out.println("search       - Cauta toti invitatii conform sirului de caractere introdus");
        System.out.println("save         - Salveaza lista cu invitati");
        System.out.println("restore      - Completeaza lista cu informatii salvate anterior");
        System.out.println("reset        - Sterge informatiile salvate despre invitati");
        System.out.println("quit         - Inchide aplicatia");
    }

    private static void addNewGuest(Scanner sc, GuestsList list) {
        String lastName = sc.next();
        String firstName = sc.next();
        String email = sc.next();
        String phoneNumber = sc.next();
        list.add(new Guest(lastName, firstName, email, phoneNumber));
    }

    private static void checkGuest(Scanner sc, GuestsList list) {
        int option = sc.nextInt();

        switch(option){
            case 1:
                String lastName = sc.next();
                String firstName = sc.next();
                System.out.println(list.search(lastName, firstName));
                break;
            case 2:
                String match = sc.next();
                System.out.println(list.search(2, match));
                break;
            case 3:
                match = sc.next();
                System.out.println(list.search(3, match));
                break;
        }
    }

    private static void removeGuest(Scanner sc, GuestsList list) {
        int option = sc.nextInt();

        switch(option){
            case 1:
                String lastName = sc.next();
                String firstName = sc.next();
                list.remove(lastName, firstName);
                break;
            case 2:
                String match = sc.next();
                list.remove(2, match);
                break;
            case 3:
                match = sc.next();
                list.remove(3, match);
                break;
        }
    }

    private static void updateGuest(Scanner sc, GuestsList list) {
        int auth = sc.nextInt();
        Guest myGuest = null;
        switch(auth){
            case 1:
                String lastName = sc.next();
                String firstName = sc.next();
                myGuest = list.search(lastName, firstName);
                break;
            case 2:
                String match = sc.next();
                myGuest = list.search(2, match);
                break;
            case 3:
                match = sc.next();
                myGuest = list.search(3, match);
                break;
        }
        int fieldToEdit = sc.nextInt();
        switch(fieldToEdit){
            case 1:
                String lastName = sc.next();
                list.edit(1, lastName, myGuest);
                break;
            case 2:
                String firstName = sc.next();
                list.edit(2, firstName, myGuest);
                break;
            case 3:
                String email = sc.next();
                list.edit(3, email, myGuest);
                break;
            case 4:
                String phoneNumber = sc.next();
                list.edit(4, phoneNumber, myGuest);
                break;
        }
    }

    private static void searchList(Scanner sc, GuestsList list) {
       String str = sc.next();
       list.partialSearch(str);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        scanner.nextLine();

        GuestsList list = new GuestsList(size);

        boolean running = true;
        while (running) {
            String command = scanner.nextLine();

            switch (command) {
                case "help":
                    showCommands();
                    break;
                case "add":
                    addNewGuest(scanner, list);
                    break;
                case "check":
                    checkGuest(scanner, list);
                    break;
                case "remove":
                    removeGuest(scanner, list);
                    break;
                case "update":
                    updateGuest(scanner, list);
                    break;
                case "guests":
                    list.showGuestsList();
                    break;
                case "waitlist":
                    list.showWaitingList();
                    break;
                case "available":
                    System.out.println("Numarul de locuri ramase: " + list.numberOfAvailableSpots());
                    break;
                case "guests_no":
                    System.out.println("Numarul de participanti: " + list.numberOfGuests());
                    break;
                case "waitlist_no":
                    System.out.println("Dimensiunea listei de asteptare: " + list.numberOfPeopleWaiting());
                    break;
                case "subscribe_no":
                    System.out.println("Numarul total de persoane: " + list.numberOfPeopleTotal());
                    break;
                case "search":
                    searchList(scanner, list);
                    break;
                case "quit":
                    System.out.println("Aplicatia se inchide...");
                    scanner.close();
                    running = false;
                    break;
            }
        }
    }

}
