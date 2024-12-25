import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Bill {
    private Ticket ticket;
    private String exitTime;

    public Bill(Ticket ticket, String exitTime) {
        this.ticket = ticket;
        this.exitTime = exitTime;
    }

    private long getAmount(){
        long amount = 0;
        // calculate amount of bill based on entryTime and type of Vehicle
        VehicleType vehicleType = this.ticket.getVehicle().getType();
        String entryTime = this.ticket.getEntryTime();

        long two_wheeler_hourly_price = 20;
        long four_wheeler_hourly_price = 40;

        // We should get time in hours e.g. if entry time is 2:35 and exit time is 3:40. it should be counted as 2 hours
        // and if entry time is 2:35 and exit time is 3:15, it should be counted as 1 hour

        // Calculate hour difference between the times and add 1
        // convert String time to LocalDateTime object
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS");
        LocalDateTime entry_time = LocalDateTime.parse(entryTime, formatter);
        LocalDateTime exit_time = LocalDateTime.parse(exitTime, formatter);

        Duration duration = Duration.between(entry_time, exit_time);

        long hourDifference = duration.toHours() + 1;

        if (vehicleType == VehicleType.TWO_WHEELER){
            amount = two_wheeler_hourly_price * hourDifference;
        }
        if (vehicleType == VehicleType.FOUR_WHEELER){
            amount = four_wheeler_hourly_price * hourDifference;
        }
        return amount;
    }

    public HashMap<String, String> generate(){
        HashMap<String, String> billDetails = new HashMap<String, String>();

        billDetails.put("Ticket number", this.ticket.getTicketNumber());
        billDetails.put("Entry Time", this.ticket.getEntryTime());
        billDetails.put("Exit Time", this.exitTime);
        billDetails.put("Amount", Long.toString(this.getAmount()));

        return billDetails;
    }
}
