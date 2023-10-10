package alarmcomponents;

import house.Room;

public class SmokeDetector {
    private String name;
    private boolean detector;
    private Room room;

    public SmokeDetector(String name, Room room){
        this.name = name;
        this.room = room;
    }

    public String getName() {
        return name;
    }

    public Room getRoom(){
        return room;
    }

    public boolean isDetector() {
        return detector;
    }
    public void setDetector(boolean detector){this.detector = detector;}

    public void simulateFire(Room room){
        System.out.println("Smoke detected in "+room.getRoomName());
        triggerAlarm(room);
    }

    public void triggerAlarm(Room room){
        detector = true;
        System.out.println("The detector in "+room.getRoomName()+" gives off a series of high pitched beeps waking everybody up");

    }


}
