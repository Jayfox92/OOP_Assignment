package house;

import alarmcomponents.SmokeDetector;
import alarmcomponents.Sprinklers;

import java.util.ArrayList;
import java.util.List;

public class House {
    private String houseName;
    private List<Room> rooms;
    private  List<SmokeDetector> listOfSmokeDetectors;
    private  List<Sprinklers> listOfSprinklers;
    public House(String houseName){
        this.houseName = houseName;
        rooms = new ArrayList<>();
        listOfSmokeDetectors = new ArrayList<>();
        listOfSprinklers = new ArrayList<>();
    }
    public void addRoom(Room room){
        rooms.add(room);
    }
    public List<Room> getRooms(){
        return rooms;
    }
    public String getHouseName(){
        return houseName;
    }

    public List<SmokeDetector> getListOfSmokeDetectors() {
        return listOfSmokeDetectors;
    }

    public void addSmokeDetectors(SmokeDetector smokeDetector) {listOfSmokeDetectors.add(smokeDetector);
    }

    public List<Sprinklers> getListOfSprinklers() {
        return listOfSprinklers;
    }

    public void addSprinklers(Sprinklers sprinkler) {listOfSprinklers.add(sprinkler);
    }
}
