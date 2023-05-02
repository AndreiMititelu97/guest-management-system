import src.GuestsList;
public class Main {
    GuestsList myGuestList;

    public static void main(String[] args){
        Main test = new Main();
        test.myGuestList = new GuestsList(1);
        test.myGuestList.addGuest();
        test.myGuestList.addGuest();
        test.myGuestList.addGuest();
    }
}
