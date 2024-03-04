import java.util.Random;
import java.util.Scanner;

public class Room {
    int ID,NumOfBeds;
    double Price;
    boolean Booked;
    int nights;
    Room(int ID){
        this.ID = ID;

        this.Booked = new Random().nextBoolean();

        this.NumOfBeds = new Random().nextInt(1,4);

        if(this.Booked)
            this.nights = new Random().nextInt(1,5);
        else
            this.nights =0;

        this.Price = NumOfBeds*150;//150 is the base price for 1 night
    }
    void PrintRoomInfo(){
        System.out.println("Room " + this.ID+", Status: "+(this.Booked? "Booked\n":"Available\n")+
                this.NumOfBeds+" beds\n" +
                "Price per night: "+this.Price+(this.Booked? "\nBooked for: "+this.nights+" night(s)":""));
        System.out.println("____________________________________________________");
    }
    void Reservation(){
        Scanner X = new Scanner(System.in);
        System.out.print("Enter number of nights you want to stay: ");
        int nights;
        nights = X.nextInt();
        if(this.nights != 0){
            System.out.println("Are you sure you want to reserve this room?\nIt will be a reservation for "+this.nights+" days from now");
        }
        else
            this.nights+=nights;
    }
}
