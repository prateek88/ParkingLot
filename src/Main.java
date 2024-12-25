public class Main {
    public static void main(String[] args) {
        // Create Parking Lot
        ParkingLot parkingLot = new ParkingLot("SDR");

        // Create Gates
        Gate gate1 = new Gate(parkingLot, GateType.ENTRY, "gate1");
        Gate gate2 = new Gate(parkingLot, GateType.EXIT, "gate2");

        // Create Floors
        Floor floor1 = new Floor(1, 5);
        Floor floor2 = new Floor(2, 5);

        // Add Gates to parking lot
        parkingLot.addGate(gate1);
        parkingLot.addGate(gate2);

        parkingLot.addFloor(floor1);
        parkingLot.addFloor(floor2);

        floor1.addSlot(new Slot(VehicleType.FOUR_WHEELER,  1));
        floor1.addSlot(new Slot(VehicleType.FOUR_WHEELER,  2));
        floor1.addSlot(new Slot(VehicleType.FOUR_WHEELER,  3));
        floor1.addSlot(new Slot(VehicleType.TWO_WHEELER,  4));
        floor1.addSlot(new Slot(VehicleType.TWO_WHEELER,  5));

        floor2.addSlot(new Slot(VehicleType.FOUR_WHEELER,  1));
        floor2.addSlot(new Slot(VehicleType.FOUR_WHEELER,  2));
        floor2.addSlot(new Slot(VehicleType.FOUR_WHEELER,  3));
        floor2.addSlot(new Slot(VehicleType.TWO_WHEELER,  4));
        floor2.addSlot(new Slot(VehicleType.TWO_WHEELER,  5));
        floor2.addSlot(new Slot(VehicleType.TWO_WHEELER,  6));

        Vehicle car1 = new Vehicle("1234", VehicleType.FOUR_WHEELER);
        Ticket ticket1 = gate1.printTicket(car1);

        Vehicle car2 = new Vehicle("1236", VehicleType.FOUR_WHEELER);
        Ticket ticket2 = gate1.printTicket(car2);

        Bill bill1 = gate2.printBill(ticket1);
        Bill bill2 = gate2.printBill(ticket2);
    }

}
