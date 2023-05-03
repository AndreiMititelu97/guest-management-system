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
                list.search(lastName, firstName);
                break;
            case 2:
                String match = sc.next();
                list.search(2, match);
                break;
            case 3:
                match = sc.next();
                list.search(3, match);
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
        int option = sc.nextInt();

        switch(option){
            case 1:
                String lastName = sc.next();
                String firstName = sc.next();
                list.edit(lastName, firstName);
                break;
            case 2:
                String match = sc.next();
                list.edit(2, match);
                break;
            case 3:
                match = sc.next();
                list.edit(3, match);
                break;
        }
    }

    private static void searchList(Scanner sc, GuestsList list) {
       String str = sc.next();
       list.partialSearch(str);
    }

    public static void main(String[] args){
    }
}
