public class Slot {
    public VehicleType slotType;
    public Floor floor;
    public Boolean isFree = true;
    public Integer slotNumber;

    public Slot(VehicleType slotType, Integer slotNumber){
        this.slotType = slotType;
        this.slotNumber = slotNumber;
    }

    // Getters
    public VehicleType getType(){
        return this.slotType;
    }

    public Boolean getStatus(){
        return this.isFree;
    }

    public Integer getSlotNumber(){
        return slotNumber;
    }

    // Setters
    public void setType(VehicleType slotType){
        this.slotType = slotType;
    }

    public void freeUpSlot(){
        this.isFree = true;
    }

    public void fillSlot(){
        this.isFree = false;
    }
}
