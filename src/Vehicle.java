public class Vehicle {
    public String regNo;
    public VehicleType vehicleType;

    public Vehicle(String regNo, VehicleType vehicleType){
        this.regNo = regNo;
        this.vehicleType = vehicleType;
    }

    // Getters
    public VehicleType getType(){
        return this.vehicleType;
    }
}
