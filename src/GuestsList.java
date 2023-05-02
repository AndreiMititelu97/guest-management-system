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

    public int addGuest() {
        Scanner scan = new Scanner(System.in);

        //Check if the guests is already registered
            if(indexOfGuest() >= 0){
                return -1;
            }

        //Create guest
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


        //If the guests list is not full, add the guest to it.
        if(guestsList.size() < this.guestsCapacity){
            guestsList.add(guest);
            System.out.format("Felicitari! Locul tau la eveniment este confirmat. Te asteptam!\n\n");
            return 0;
        }else{//If the guests list is full, add the guest to the waiting list
            this.guestsList.add(guest);
            System.out.format("Te-ai inscris cu succes in lista de asteptare si ai primit numarul de ordine %d. Te vom notifica daca un loc devine disponibil\n\n", this.guestsList.indexOf(guest) - 1);
            return this.guestsList.indexOf(guest);
        }
    }

//    private boolean containsGuestByName(){
//        Scanner scan = new Scanner(System.in);
//        System.out.print("Write the last name of the guest: ");
//        String lastName = scan.next();
//
//        System.out.print("Write the first name of the guest: ");
//        String firstName = scan.next();
//        System.out.println();
//
//        //Find the guest by last name and first name in the guests list
//        for(int i = 0; i < guestsList.size(); i++){
//            if(guestsList.get(i).getLastName().equals(lastName) && guestsList.get(i).getFirstName().equals(firstName)){
//                System.out.println("Guest is on the guests list\n");
//                return true;
//            }
//        }
//
//        //Find the guest by last name and first name in the waiting list
//        for(int i = 0; i < waitingList.size(); i++){
//            if(waitingList.get(i).getLastName().equals(lastName) && waitingList.get(i).getFirstName().equals(firstName)){
//                System.out.println("Guest is on the waiting list\n");
//                return true;
//            }
//        }
//
//        //If no guest found
//        System.out.println("Guest is not on our lists.");
//        return false;
//    }
//
//    private boolean containsGuestByEmail(){
//        Scanner scan = new Scanner(System.in);
//        System.out.print("Write the email address of the guest: ");
//        String email = scan.next();
//        System.out.println();
//
//        //Find the guest by email in the guests list
//        for(int i = 0; i < guestsList.size(); i++){
//            if(guestsList.get(i).getEmail().equals(email)){
//                System.out.println("Guest is on the guests list\n");
//                return true;
//            }
//        }
//
//        //Find the guest by email in the waiting list
//        for(int i = 0; i < waitingList.size(); i++){
//            if(waitingList.get(i).getEmail().equals(email)){
//                System.out.println("Guest is on the waiting list\n");
//                return true;
//            }
//        }
//
//        //If no guest found
//        System.out.println("Guest is not on our lists.");
//        return false;
//    }
//
//    private boolean containsGuestByPhoneNumber(){
//        Scanner scan = new Scanner(System.in);
//        System.out.print("Write the phone number of the guest: ");
//        String phoneNumber = scan.next();
//        System.out.println();
//
//        //Find the guest by phone number in the guests list
//        for(int i = 0; i < guestsList.size(); i++){
//            if(guestsList.get(i).getPhoneNumber().equals(phoneNumber)){
//                System.out.println("Guest is on the guests list\n");
//                return true;
//            }
//        }
//
//        //Find the guest by phone number in the waiting list
//        for(int i = 0; i < waitingList.size(); i++){
//            if(waitingList.get(i).getPhoneNumber().equals(phoneNumber)){
//                System.out.println("Guest is on the waiting list\n");
//                return true;
//            }
//        }
//
//        //If no guest found
//        System.out.println("Guest is not on our lists.");
//        return false;
//    }
//
//    public boolean containsGuest(){
//        Scanner scan = new Scanner(System.in);
//        int addChoice = 0;
//        boolean optionSelected = false;
//
//        while(!optionSelected){
//            System.out.format("Please select a method to search for the guest:\n" +
//                    "1. Last Name & First Name\n" +
//                    "2. Email\n" +
//                    "3. Phone Number\n" +
//                    "Choice: ");
//
//            addChoice = scan.nextInt();
//            System.out.println();
//
//            switch(addChoice){
//                case 1:
//                    if(containsGuestByName()){
//                        return true;
//                    }
//                    optionSelected = true;
//                    break;
//                case 2:
//                    if(containsGuestByEmail()){
//                        return true;
//                    }
//                    optionSelected = true;
//                    break;
//                case 3:
//                    if(containsGuestByPhoneNumber()){
//                        return true;
//                    }
//                    optionSelected = true;
//                    break;
//                default:
//                    System.out.format("Incorrect choice, please try again\n\n");
//                    break;
//            }
//        }
//        return false;
//    }

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



}
