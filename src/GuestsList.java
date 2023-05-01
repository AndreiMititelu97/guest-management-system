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

    public int addGuest(String lastName, String firstName, String email, String phoneNumber, Scanner scan) {
        //Check if the guest is already registered
        System.out.format("First, we will check if the person already has a reservation.\n" +
                "Please select a method to search for the guest:\n" +
                "1. Last Name & First Name\n" +
                "2. Email\n" +
                "3. Phone Number\n");

        int addChoice = scan.nextInt();
        switch(addChoice){
            case 1:
                if(checkReservationByName(lastName, firstName)){
                    return -1;
                }
                break;
            case 2:
                if(checkReservationByEmail(email)){
                    return -1;
                }
                break;
            case 3:
                if(checkReservationByPhoneNumber(phoneNumber)){
                    return -1;
                }
                break;
            default:
                System.out.format("Incorrect choice, please try again");
                return -2;
        }

        //If the guestList is full, add the guest to the waiting list
        Guest guest = new Guest(lastName, firstName, email, phoneNumber);
        if(guestsList.size() >= this.availableSeats){
            this.waitingList.add(guest);
            System.out.format("Te-ai inscris cu succes in lista de asteptare si ai primit numarul de ordine %d. Te vom notifica daca un loc devine disponibil", this.waitingList.indexOf(guest));
            return this.waitingList.indexOf(guest);
        }else{
            //If the guest list is not full, add the guest to it.
            this.guestsList.add(guest);
            System.out.format("Felicitari! Locul tau la eveniment este confirmat. Te asteptam!");
            return 0;
        }
    }

    private boolean checkReservationByName(String lastName, String firstName){
        return false;
    }

    private boolean checkReservationByEmail(String email){
        return false;
    }

    private boolean checkReservationByPhoneNumber(String phoneNumber){
        return false;
    }


}
