import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Gate {
    public GateType type;
    public String attendant;
    public ParkingLot parkingLot;
    private String name;

    public Gate(ParkingLot parkingLot, GateType type, String name){
        this.parkingLot = parkingLot;
        this.type = type;
        this.name = name;
    }

    // Getters
    public String getAttendant(){
        return this.attendant;
    }

    public String getName() {
        return this.name;
    }

    public Slot findSlot(Vehicle vehicle){
        // How to find the emptySlot
        // To find it, it should be aware of floors in parking lot
        List<Floor> floors = parkingLot.getFloors();

        // iterate through each floor and find the first slot available
        // for this type of vehicle
        for (Floor floor: floors){
            List<Slot> slotsOnThisFloor = floor.getSlots();
            for (Slot slot: slotsOnThisFloor){
                if (slot.getType() == vehicle.getType() && slot.isFree){
                    slot.fillSlot();
                    return slot;
                }
            }
        }
        return null;
    }

    public Ticket printTicket(Vehicle vehicle){
        Slot slot = findSlot(vehicle);
        String entryTime = LocalDateTime.now().toString();
        Ticket ticket = new Ticket(vehicle, slot, entryTime, this);

        HashMap<String, String> ticketDetails = ticket.generate();
        // iterate over hashtable and print the ticket
        System.out.println("########Ticket Details########");
        for (Map.Entry<String, String> e: ticketDetails.entrySet()){
            System.out.println(e.getKey() + ": " + e.getValue());
        }
        System.out.println("############################");

        return ticket;
    }

    public Bill printBill(Ticket ticket){
        String exitTime = LocalDateTime.now().toString();
        Bill bill = new Bill(ticket, exitTime);

        HashMap<String, String> billDetails = bill.generate();
        System.out.println("########Bill Details########");
        for (Map.Entry<String, String> e: billDetails.entrySet()){
            System.out.println(e.getKey() + ": " + e.getValue());
        }
        System.out.println("############################");

        ticket.getSlot().freeUpSlot();
        return bill;
    }

    // Setters
    public void setAttendant(String name){
        this.attendant = name;
    }
}
