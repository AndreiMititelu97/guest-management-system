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

    public boolean isOnTheListAlready(Guest g) {
        for(int i = 0; i < this.guestsList.size(); i++){
            if(this.guestsList.get(i).hashCode() == g.hashCode()){
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

//    public int indexOfGuestByName(){
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
//                if(i >= this.guestsCapacity){
//                    System.out.println("Guest is on the waiting list\n");
//                    return i;
//                }
//                System.out.println("Guest is on the guests list\n");
//                return i;
//            }
//        }
//
//        //If no guest found
//        System.out.println("Guest is not on our lists.");
//        return -2;
//    }
//
//    public int indexOfGuestByEmail(){
//        Scanner scan = new Scanner(System.in);
//        System.out.print("Write the email address of the guest: ");
//        String email = scan.next();
//        System.out.println();
//
//        //Find the guest by email in the guests list
//        for(int i = 0; i < guestsList.size(); i++){
//            if(guestsList.get(i).getEmail().equals(email)){
//                if(i >= this.guestsCapacity){
//                    System.out.println("Guest is on the waiting list\n");
//                    return i;
//                }
//                System.out.println("Guest is on the guests list\n");
//                return i;
//            }
//        }
//
//        //If no guest found
//        System.out.println("Guest is not on our lists.");
//        return -2;
//    }
//
//    public int indexOfGuestByPhoneNumber(){
//        Scanner scan = new Scanner(System.in);
//        System.out.print("Write the phone number of the guest: ");
//        String phoneNumber = scan.next();
//        System.out.println();
//
//        //Find the guest by phone number in the guests list
//        for(int i = 0; i < guestsList.size(); i++){
//            if(guestsList.get(i).getPhoneNumber().equals(phoneNumber)){
//                if(i >= this.guestsCapacity){
//                    System.out.println("Guest is on the waiting list\n");
//                    return i;
//                }
//                System.out.println("Guest is on the guests list\n");
//                return i;
//            }
//        }
//
//        //If no guest found
//        System.out.println("Guest is not on our lists.");
//        return -2;
//    }
//
//    public int indexOfGuest(){
//        Scanner scan = new Scanner(System.in);
//        int addChoice = 0;
//        boolean optionSelected = false;
//        int index = -2;
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
//                    int temporaryIndex = indexOfGuestByName();
//                    if(temporaryIndex >= 0){
//                        index =  temporaryIndex;
//                    }
//                    optionSelected = true;
//                    break;
//                case 2:
//                    temporaryIndex = indexOfGuestByEmail();
//                    if(temporaryIndex >= 0){
//                        index =  temporaryIndex;
//                    }
//                    optionSelected = true;
//                    break;
//                case 3:
//                    temporaryIndex = indexOfGuestByPhoneNumber();
//                    if(temporaryIndex >= 0){
//                        index =  temporaryIndex;
//                    }
//                    optionSelected = true;
//                    break;
//                default:
//                    System.out.format("Incorrect choice, please try again\n\n");
//                    break;
//            }
//        }
//        return index;
//    }

    public Guest search(String firstName, String lastName){
        //Find the guest by last name and first name in the guests list
        for(int i = 0; i < this.guestsList.size(); i++){
            if(this.guestsList.get(i).getLastName().equals(lastName) && this.guestsList.get(i).getFirstName().equals(firstName)){
                return this.guestsList.get(i);
            }
        }
        //If no guest found
        return null;
    }

    public Guest search(int opt, String match){
        switch(opt){
            case 2://Search for email
                for(int i = 0; i < this.guestsList.size(); i++){
                    if(this.guestsList.get(i).getEmail().equals(match)){
                        return this.guestsList.get(i);
                    }
                }
                break;

            case 3://Search for phone number
                for(int i = 0; i < this.guestsList.size(); i++){
                    if(this.guestsList.get(i).getPhoneNumber().equals(match)){
                        return this.guestsList.get(i);
                    }
                }
                break;
        }
        //If no guest found
        return null;
    }

    public boolean remove(String firstName, String lastName) {
        Guest guestToRemove = search(firstName, lastName);

        if (guestToRemove != null) {
            this.guestsList.remove(guestToRemove);
            if(this.guestsList.size() > 0){
                System.out.format("Felicitari! Locul tau la eveniment este confirmat. Te asteptam!\n\n");
            }
            return true;
        }
        return false;
    }

    public boolean remove(int opt, String match){
        Guest guestToRemove = search(opt, match);

        if(guestToRemove != null){
            this.guestsList.remove(guestToRemove);
            if(this.guestsList.size() > 0){
                System.out.format("Felicitari! Locul tau la eveniment este confirmat. Te asteptam!\n\n");
            }
            return true;
        }
        return false;
    }

    public void showGuestsList(){
        for(int i = 0; i < this.guestsList.size(); i++){
            if(i == this.guestsCapacity){
                break;
            }
            System.out.format("%s %s\n", this.guestsList.get(i).getFirstName(), this.guestsList.get(i).getLastName());
        }
        System.out.println();
    }

    public void showWaitingList(){
        for(int i = this.guestsCapacity; i < this.guestsList.size(); i++){
            System.out.format("%s %s\n", this.guestsList.get(i).getFirstName(), this.guestsList.get(i).getLastName());
        }
        System.out.println();
    }

    public int numberOfAvailableSpots(){
        int count = 0;
        for(int i = 0; i < this.guestsList.size(); i++){
            if(i == this.guestsCapacity){
                break;
            }
            count++;
        }
        return this.guestsCapacity - count;
    }

    public int numberOfGuests(){
        int count = 0;
        for(int i = 0; i < this.guestsList.size(); i++){
            if(i == this.guestsCapacity){
                break;
            }
            count++;
        }
        return count;
    }

    public int numberOfPeopleWaiting(){
        int count = 0;
        for(int i = this.guestsCapacity; i < this.guestsList.size(); i++){
            count++;
        }
        return count;
    }

    public int numberOfPeopleTotal(){
        return this.guestsList.size();
    }



}
