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
        //add to guest list
        if(this.guestsList.size() < this.guestsCapacity){
            this.guestsList.add(g);
            System.out.format("[%s %s] Felicitari! Locul tau la eveniment este confirmat. Te asteptam!\n", g.getLastName(), g.getFirstName());
            return 0;
        }else{//add to waiting list
            this.guestsList.add(g);
            System.out.format("[%s %s] Te-ai inscris cu succes in lista de asteptare si ai primit numarul de ordine %d. Te vom notifica daca un loc devine disponibil.\n", g.getLastName(), g.getFirstName(),this.guestsList.indexOf(g) - 2);
            return this.guestsList.indexOf(g);
        }
    }

    public Guest search(String lastName, String firstName){
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

    public boolean remove(String lastName, String firstName) {
        Guest guestToRemove = search(lastName, firstName);

        if (guestToRemove != null) {
            this.guestsList.remove(guestToRemove);
            if(this.guestsList.size() > 0){
                System.out.format("Felicitari %s %s! Locul tau la eveniment este confirmat. Te asteptam!\n",
                        this.guestsList.get(this.guestsCapacity - 1).getLastName(),
                        this.guestsList.get(this.guestsCapacity - 1).getFirstName());
            }
            return true;
        }
        //If no guest found
        return false;
    }

    public boolean remove(int opt, String match){
        Guest guestToRemove = search(opt, match);

        if(guestToRemove != null){
            this.guestsList.remove(guestToRemove);
            if(this.guestsList.size() > 0){
                System.out.format("Felicitari %s %s! Locul tau la eveniment este confirmat. Te asteptam!\n",
                        this.guestsList.get(this.guestsCapacity - 1).getLastName(),
                        this.guestsList.get(this.guestsCapacity - 1).getFirstName());
            }
            return true;
        }
        //If no guest found
        return false;
    }

    public void showGuestsList(){// Show the list of guests.
        int count = 0;
        for(int i = 0; i < this.guestsList.size(); i++){
            if(i == this.guestsCapacity){
                break;
            }
            System.out.format("%d. Nume: %s %s, Email: %s, Telefon: %s\n", (i + 1),
                    this.guestsList.get(i).getLastName(), this.guestsList.get(i).getFirstName(),
                    this.guestsList.get(i).getEmail(), this.guestsList.get(i).getPhoneNumber());
            count++;
        }
        if(count == 0){
           System.out.println("Niciun participant inscris…");
        }
    }

    public void showWaitingList(){//Show the people on the waiting list.
        int count = 0;
        for(int i = this.guestsCapacity; i < this.guestsList.size(); i++){
            System.out.format("%d. Nume: %s %s, Email: %s, Telefon: %s\n", (i - this.guestsCapacity + 1),
                    this.guestsList.get(i).getLastName(), this.guestsList.get(i).getFirstName(),
                    this.guestsList.get(i).getEmail(), this.guestsList.get(i).getPhoneNumber());
            count++;
        }
        if(count == 0){
            System.out.println("Lista de asteptare este goala...");
        }
    }

    public int numberOfAvailableSpots(){//Show how many free spots are left.
        int count = 0;
        for(int i = 0; i < this.guestsList.size(); i++){
            if(i == this.guestsCapacity){
                break;
            }
            count++;
        }
        return this.guestsCapacity - count;
    }

    public int numberOfGuests(){//Show how many guests there are.
        int count = 0;
        for(int i = 0; i < this.guestsList.size(); i++){
            if(i == this.guestsCapacity){
                break;
            }
            count++;
        }
        return count;
    }

    public int numberOfPeopleWaiting(){//Show how many people are on the waiting
        int count = 0;
        for(int i = this.guestsCapacity; i < this.guestsList.size(); i++){
            count++;
        }
        return count;
    }

    public int numberOfPeopleTotal(){//Show how many people there are in total, including guests.
        return this.guestsList.size();
    }
    public boolean edit(int fieldToEdit, String match, Guest guestToEdit){
        if(guestToEdit != null) {
            switch (fieldToEdit) {
                case 1:
                    guestToEdit.setLastName(match);
                    return true;
                case 2:
                    guestToEdit.setFirstName(match);
                    return true;
                case 3:
                    guestToEdit.setEmail(match);
                    return true;
                case 4:
                    guestToEdit.setPhoneNumber(match);
                    return true;
            }
        }
        //If no guest found
        return false;
    }

    public void partialSearch(String str){
        int count = 0;
        for(int i = 0; i < this.guestsList.size(); i++){
            if(this.guestsList.get(i).getLastName().contains(str) ||
                    this.guestsList.get(i).getFirstName().contains(str) ||
                    this.guestsList.get(i).getEmail().contains(str) ||
                    this.guestsList.get(i).getPhoneNumber().contains(str)){
                count++;
                System.out.format("Nume: %s %s, Email: %s, Telefon: %s\n",
                        this.guestsList.get(i).getLastName(), this.guestsList.get(i).getFirstName(),
                        this.guestsList.get(i).getEmail(), this.guestsList.get(i).getPhoneNumber());
            }
        }
        if(count == 0){
            System.out.println("Nothing found");
        }
    }

    public String toString() {
        return String.format("%s", this.guestsCapacity);
    }
}
