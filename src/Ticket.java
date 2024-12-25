import java.util.HashMap;
import java.util.UUID;

public class Ticket {
    private Vehicle vehicle;
    private Gate gate;
    private Slot slot;
    private String entryTime;
    private String ticketNumber;

    public Ticket(Vehicle vehicle, Slot slot, String entryTime, Gate gate){
        this.vehicle = vehicle;
        this.slot = slot;
        this.entryTime = entryTime;
        this.gate = gate;
        this.ticketNumber = UUID.randomUUID().toString();
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public String getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public HashMap<String, String> generate(){
        HashMap<String, String> ticketDetails = new HashMap<String, String>();

        ticketDetails.put("Ticket Number", this.ticketNumber);
        ticketDetails.put("Vehicle Number", this.getVehicle().regNo);
        ticketDetails.put("Entry Time", this.entryTime);
        ticketDetails.put("Gate", this.getGate().getName());
        ticketDetails.put("Slot", this.getSlot().getSlotNumber().toString());

        return ticketDetails;
    }
}
