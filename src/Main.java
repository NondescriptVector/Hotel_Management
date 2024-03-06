import java.util.*;

public class Main {
    static Scanner X = new Scanner(System.in);
    static staff staff1 = new staff("Mohamed Essam", "123abc");
    static staff staff2 = new staff("Akram Ahmed", "456def");
    static staff staff3 = new staff("Ziad Ahmed", "789ghi");
    static staff staff4 = new staff("Youssef Mamdouh", "101jkl");
    static staff staff5 = new staff("Abdallah Nagah","112mno");
    static Hotel OurHotel = new Hotel(3, 5);
    static staff[] staff = {staff1,staff2,staff3,staff4,staff5};

    public static void main(String[] args) {
        boolean auth = Login();
        int in;
        if(auth){
            System.out.println("Welcome to the hotel management system!");
            while(auth){
                System.out.println("""
                    Please choose what you want to do
                    1) Show all rooms.
                    2) Show all available rooms.
                    3) Show all booked rooms.
                    4) Make a reservation.
                    0) To Logout.""");
                in = X.nextInt();
                X.nextLine();
                switch(in) {
                    case 0:
                        auth = false;
                        break;
                    case 1:
                        OurHotel.ShowAllRooms();
                        break;
                    case 2:
                        OurHotel.ShowAvailableRooms();
                        break;
                    case 3:
                        OurHotel.ShowBookedRooms();
                        break;
                    case 4:
                        Reservation();
                        break;
                    default:
                        System.out.println("Please enter a valid number!");
                }
            }
        }
    }

    static boolean Login() {
        String staffiD, password;
        while (true) {
            System.out.print("Enter your staff ID: ");
            staffiD = X.next();
            for (int i=0; i < staff.length; i++) {
                if (staffiD.equalsIgnoreCase(staff[i].staffiD)) {
                    System.out.print("Enter your password: ");
                    password=X.next();
                    if(password.equals(staff[i].password)){
                        return true;
                    }
                }
            }
            System.out.println("Incorrect username or password!");
        }
    }
    static void Reservation(){
        int in;

        System.out.print("Enter the number of beds you need in the room: ");
        in = X.nextInt();
        X.nextLine();

        OurHotel.SearchByNumOfBeds(in);

        System.out.print("Choose the room you want to reserve(Enter room number): ");
        in = X.nextInt();
        X.nextLine();

        OurHotel.Reservation(in);

        System.out.println("Reservation complete!");
    }
}