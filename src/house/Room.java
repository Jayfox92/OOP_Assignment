package house;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private String roomName;
    private List<String> doors = new ArrayList<>();
    private List<String> windows = new ArrayList<>();

    public Room(String roomName){
        this.roomName = roomName;
    }
    public Room(String roomName, String window){
        this.roomName = roomName;
        windows.add(window);
    }
    public Room(String roomName, String door, String window){
        this.roomName = roomName;
        doors.add(door);
        windows.add(window);
    }
    public Room(String roomName, String door, String window, String window2){
        this.roomName = roomName;
        doors.add(door);
        windows.add(window);
        windows.add(window2);
    }
    public void setRoomName(String roomName){
        this.roomName = roomName;
    }
    public String getRoomName(){
        return roomName;
    }

    public List<String> getDoors() {
        return doors;
    }

    public List<String> getWindows() {
        return windows;
    }

}
