import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    public String name;
    public List<Floor> floors = new ArrayList<>();
    public List<Gate> gates = new ArrayList<>();

    public ParkingLot(String name){
        this.name = name;
    }

    //Getters
    public List<Gate> getGates(){
        return this.gates;
    }

    public List<Floor> getFloors(){
        return this.floors;
    }

    // Setters
    public void addGate(Gate gate){
        this.gates.add(gate);
    }

    public void addFloor(Floor floor){
        this.floors.add(floor);
    }

    public void removeGate(Gate gate){
        Integer indexOfGate = this.gates.indexOf(gate);
        this.gates.remove(indexOfGate);
    }

    public void removeFloor(Floor floor){
        Integer indexOfFloor = this.floors.indexOf(floor);
        this.floors.remove(indexOfFloor);
    }
}
