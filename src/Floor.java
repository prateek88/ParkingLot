import java.util.ArrayList;
import java.util.List;

public class Floor {
    private Integer level;
    private List<Slot> slots = new ArrayList<>();
    private Boolean isFull = true;
    private Integer capacity;

    public Floor(Integer level, Integer capacity){
        this.level = level;
        this.capacity = capacity;
    }

    //Getters
    public List<Slot> getSlots(){
        return this.slots;
    }

    public Integer getLevel(){
        return this.level;
    }

    public Integer getCapacity(){
        return this.capacity;
    }

    // Setters
    public Boolean addSlot(Slot slot){
        if (this.slots.size() == this.capacity){
            return false;
        }
        this.slots.add(slot);
        return true;
    }
}
