public class Hotel{
    int Floors;
    int RoomsPerFloor;
    Room[][] rooms;

    Hotel(int Floors, int RoomsPerFloor) {

        this.SetFloors(Floors);
        this.SetRoomsPerFloor(RoomsPerFloor);
        rooms = new Room[Floors][RoomsPerFloor];
        for(int i=0;i< Floors;i++){
            for(int j=0;j< RoomsPerFloor;j++){
                rooms[i][j] = (new Room((((i+1)*100)+(j+1))));
            }
        }
    }
    void SetFloors(int Floors){
        this.Floors = Floors;
    }
    void SetRoomsPerFloor(int RoomsPerFloor){
        this.RoomsPerFloor = RoomsPerFloor;
    }
    void ShowAllRooms(){
        for(Room[] m:rooms) {
            for (Room k : m) {
                k.PrintRoomInfo();
            }
        }
    }
    void ShowAvailableRooms(){

        for(Room[] m:rooms) {

            for (Room k : m) {

                if(!k.Booked)
                    k.PrintRoomInfo();

            }

        }
    }
    void ShowBookedRooms(){
        for(Room[] m:rooms) {

            for (Room k : m) {

                if(k.Booked)
                    k.PrintRoomInfo();

            }

        }
    }
    void SearchByNumOfBeds(int NumOfBeds){
        for(Room[] m:rooms) {

            for (Room k : m) {

                if(k.NumOfBeds == NumOfBeds)
                    k.PrintRoomInfo();

            }

        }
    }
    void Reservation(int RoomID){
        for(Room[] m:rooms) {

            for (Room k : m) {

                if(k.ID == RoomID){
                    k.Reservation();
                    break;
                }
            }

        }
    }
}