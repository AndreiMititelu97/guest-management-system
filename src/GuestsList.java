package src;
import java.util.ArrayList;
import java.util.Scanner;
public class GuestsList {
    private int availableSeats;
    private ArrayList<Guest> guestsList;
    private ArrayList<Guest> waitingList;

    public GuestsList(int availableSeats){
        this.availableSeats = availableSeats;
        guestsList = new ArrayList<Guest>(availableSeats);
        waitingList = new ArrayList<Guest>(availableSeats * 2);
    }

    public int addGuest() {
        Scanner scan = new Scanner(System.in);

        //Check if the guests is already registered
        System.out.format("First, we will check if the person already has a reservation.\n" +
                "Please select a method to search for the guest:\n" +
                "1. Last Name & First Name\n" +
                "2. Email\n" +
                "3. Phone Number\n" +
                "Choice: ");

        int addChoice = scan.nextInt();
        System.out.println();
        switch(addChoice){
            case 1:
                if(checkReservationByName()){
                    return -1;
                }
                break;
            case 2:
                if(checkReservationByEmail()){
                    return -1;
                }
                break;
            case 3:
                if(checkReservationByPhoneNumber()){
                    return -1;
                }
                break;
            default:
                System.out.format("Incorrect choice, please try again\n\n");
                return -2;
        }

        //Create guest
        System.out.println("Guest is not on our lists.");
        System.out.print("New guest last name: ");
        String lastName = scan.next();

        System.out.print("New guest first name: ");
        String firstName = scan.next();

        System.out.print("New guest email: ");
        String email = scan.next();

        System.out.print("New guest phone number: ");
        String phoneNumber = scan.next();
        System.out.println();

        Guest guest = new Guest(lastName, firstName, email, phoneNumber);

        //If the guests list is full, add the guest to the waiting list
        if(guestsList.size() >= this.availableSeats){
            this.waitingList.add(guest);
            System.out.format("Te-ai inscris cu succes in lista de asteptare si ai primit numarul de ordine %d. Te vom notifica daca un loc devine disponibil\n\n", this.waitingList.indexOf(guest));
            return this.waitingList.indexOf(guest);
        }else{
            //If the guests list is not full, add the guest to it.
            this.guestsList.add(guest);
            System.out.format("Felicitari! Locul tau la eveniment este confirmat. Te asteptam!\n\n");
            return 0;
        }
    }

    private boolean checkReservationByName(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Write the last name of the guest: ");
        String lastName = scan.next();

        System.out.print("Write the first name of the guest: ");
        String firstName = scan.next();
        System.out.println();

        //Find the guest by last name and first name in the guests list
        for(int i = 0; i < guestsList.size(); i++){
            if(guestsList.get(i).getLastName().equals(lastName) && guestsList.get(i).getFirstName().equals(firstName)){
                System.out.println("Guest is already on the guests list");
                return true;
            }
        }

        //Find the guest by last name and first name in the waiting list
        for(int i = 0; i < waitingList.size(); i++){
            if(waitingList.get(i).getLastName().equals(lastName) && waitingList.get(i).getFirstName().equals(firstName)){
                System.out.println("Guest is already on the waiting list");
                return true;
            }
        }

        //If no guest found
        return false;
    }

    private boolean checkReservationByEmail(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Write the email address of the guest: ");
        String email = scan.next();
        System.out.println();

        //Find the guest by email in the guests list
        for(int i = 0; i < guestsList.size(); i++){
            if(guestsList.get(i).getEmail().equals(email)){
                System.out.println("Guest is already on the guests list");
                return true;
            }
        }

        //Find the guest by email in the waiting list
        for(int i = 0; i < waitingList.size(); i++){
            if(waitingList.get(i).getEmail().equals(email)){
                System.out.println("Guest is already on the waiting list");
                return true;
            }
        }

        //If no guest found
        return false;
    }

    private boolean checkReservationByPhoneNumber(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Write the phone number of the guest: ");
        String phoneNumber = scan.next();
        System.out.println();

        //Find the guest by phone number in the guests list
        for(int i = 0; i < guestsList.size(); i++){
            if(guestsList.get(i).getPhoneNumber().equals(phoneNumber)){
                System.out.println("Guest is already on the guests list");
                return true;
            }
        }

        //Find the guest by phone number in the waiting list
        for(int i = 0; i < waitingList.size(); i++){
            if(waitingList.get(i).getPhoneNumber().equals(phoneNumber)){
                System.out.println("Guest is already on the waiting list");
                return true;
            }
        }

        //If no guest found
        return false;
    }


}
