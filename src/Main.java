import java.util.*;

public class Main {
    static Scanner X = new Scanner(System.in);
    static User user1 = new User("Monke1", "shit1shit1");
    static User user2 = new User("Monke2", "shit2shit2");
    static Hotel hotel1 = new Hotel(3, 5);
    static ArrayList<User> Users = new ArrayList<>();

    public static void main(String[] args) {
        Users.add(user1);
        Users.add(user2);
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
                        hotel1.ShowAllRooms();
                        break;
                    case 2:
                        hotel1.ShowAvailableRooms();
                        break;
                    case 3:
                        hotel1.ShowBookedRooms();
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
        String in;
        while (true) {
            System.out.println("Hotel management System(Made by SAFWA MONKE)");
            System.out.print("Enter your Staff ID: ");
            in = X.next();
            for (User M : Users) {
                if (M.StaffID.equalsIgnoreCase(in)) {
                    System.out.print("Enter your password: ");
                    in = X.next();
                    if(M.Password.equals(in))
                        return true;
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

        hotel1.SearchByNumOfBeds(in);

        System.out.print("Choose the room you want to reserve(Enter room number): ");
        in = X.nextInt();
        X.nextLine();

        hotel1.Reservation(in);

        System.out.println("Reservation complete!");
    }
}