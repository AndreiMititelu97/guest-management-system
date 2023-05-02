package src;
import java.util.ArrayList;
import java.util.Scanner;
public class GuestsList {
    private int guestsCapacity;
    private ArrayList<Guest> guestsList;
    private ArrayList<Guest> waitingList;

    public GuestsList(int guestsCapacity){
        this.guestsCapacity = guestsCapacity;
        guestsList = new ArrayList<Guest>(guestsCapacity * 2);
    }

    private boolean isOnTheListAlready(Guest g) {
        for(int i = 0; i < this.guestsList.size(); i++){
            if(this.guestsList.equals(g)){
                return true;
            }
        }
        return false;
    }

    public int add(Guest g){
        //Check if the guests is already registered
        if(isOnTheListAlready(g)){
            return -1;
        }

        if(this.guestsList.size() < this.guestsCapacity){
            this.guestsList.add(g);
            System.out.format("Felicitari! Locul tau la eveniment este confirmat. Te asteptam!\n\n");
            return 0;
        }else{
            this.guestsList.add(g);
            System.out.format("Te-ai inscris cu succes in lista de asteptare si ai primit numarul de ordine %d. Te vom notifica daca un loc devine disponibil\n\n", this.guestsList.indexOf(g) - 1);
            return this.guestsList.indexOf(g);
        }
    }

    public int indexOfGuestByName(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Write the last name of the guest: ");
        String lastName = scan.next();

        System.out.print("Write the first name of the guest: ");
        String firstName = scan.next();
        System.out.println();

        //Find the guest by last name and first name in the guests list
        for(int i = 0; i < guestsList.size(); i++){
            if(guestsList.get(i).getLastName().equals(lastName) && guestsList.get(i).getFirstName().equals(firstName)){
                if(i >= this.guestsCapacity){
                    System.out.println("Guest is on the waiting list\n");
                    return i;
                }
                System.out.println("Guest is on the guests list\n");
                return i;
            }
        }

        //If no guest found
        System.out.println("Guest is not on our lists.");
        return -2;
    }

    public int indexOfGuestByEmail(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Write the email address of the guest: ");
        String email = scan.next();
        System.out.println();

        //Find the guest by email in the guests list
        for(int i = 0; i < guestsList.size(); i++){
            if(guestsList.get(i).getEmail().equals(email)){
                if(i >= this.guestsCapacity){
                    System.out.println("Guest is on the waiting list\n");
                    return i;
                }
                System.out.println("Guest is on the guests list\n");
                return i;
            }
        }

        //If no guest found
        System.out.println("Guest is not on our lists.");
        return -2;
    }

    public int indexOfGuestByPhoneNumber(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Write the phone number of the guest: ");
        String phoneNumber = scan.next();
        System.out.println();

        //Find the guest by phone number in the guests list
        for(int i = 0; i < guestsList.size(); i++){
            if(guestsList.get(i).getPhoneNumber().equals(phoneNumber)){
                if(i >= this.guestsCapacity){
                    System.out.println("Guest is on the waiting list\n");
                    return i;
                }
                System.out.println("Guest is on the guests list\n");
                return i;
            }
        }

        //If no guest found
        System.out.println("Guest is not on our lists.");
        return -2;
    }

    public int indexOfGuest(){
        Scanner scan = new Scanner(System.in);
        int addChoice = 0;
        boolean optionSelected = false;
        int index = -2;

        while(!optionSelected){
            System.out.format("Please select a method to search for the guest:\n" +
                    "1. Last Name & First Name\n" +
                    "2. Email\n" +
                    "3. Phone Number\n" +
                    "Choice: ");

            addChoice = scan.nextInt();
            System.out.println();

            switch(addChoice){
                case 1:
                    int temporaryIndex = indexOfGuestByName();
                    if(temporaryIndex >= 0){
                        index =  temporaryIndex;
                    }
                    optionSelected = true;
                    break;
                case 2:
                    temporaryIndex = indexOfGuestByEmail();
                    if(temporaryIndex >= 0){
                        index =  temporaryIndex;
                    }
                    optionSelected = true;
                    break;
                case 3:
                    temporaryIndex = indexOfGuestByPhoneNumber();
                    if(temporaryIndex >= 0){
                        index =  temporaryIndex;
                    }
                    optionSelected = true;
                    break;
                default:
                    System.out.format("Incorrect choice, please try again\n\n");
                    break;
            }
        }
        return index;
    }

    public boolean removeGuest(){
        int indexOfGuest = indexOfGuest();
        if(indexOfGuest < 0){
            return false;
        }
        if(indexOfGuest < this.guestsCapacity){

            this.guestsList.remove(indexOfGuest);
            System.out.println("Guest has been removed");
            if(this.guestsList.size() > 0){
                System.out.format("Felicitari! Locul tau la eveniment este confirmat. Te asteptam!\n\n");
            }
        }else{
            this.guestsList.remove(indexOfGuest);
            System.out.println("Guest has been removed");
        }
        return true;
    }

    public Guest search(String firstName, String lastName){
        //Find the guest by last name and first name in the guests list
        for(int i = 0; i < this.guestsList.size(); i++){
            if(this.guestsList.get(i).getLastName().equals(lastName) && this.guestsList.get(i).getFirstName().equals(firstName)){
                System.out.println("Guest is on the guests list\n");
                return this.guestsList.get(i);
            }
        }
        //If no guest found
        System.out.println("Guest is not on our lists.");
        return null;
    }



}
