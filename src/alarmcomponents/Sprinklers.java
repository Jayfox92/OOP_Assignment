package alarmcomponents;

import house.Room;

public class Sprinklers {
    private String name;
    private boolean activateSprinkler;
    private Room room;
    private SmokeDetector smokeDetector;

    public Sprinklers(String name, Room room, SmokeDetector smokeDetector){
        this.name = name;
        this.room = room;
        this.smokeDetector = smokeDetector;
        this.activateSprinkler = false;
    }

    public Room getRoom() {
        return room;
    }

    public SmokeDetector getSmokeDetector(){
        return smokeDetector;
    }

    public void listenToSmokeDetector(SmokeDetector smokeDetector){
        if (smokeDetector.isDetector()){
            activateSprinkler = true;
            System.out.println("The sprinkler receives a signal from "+smokeDetector.getName());
            sprinklerRain(smokeDetector);
        }
        else System.out.println(smokeDetector.getName()+" returned value "+smokeDetector.isDetector()+" sprinkler doesn't activate");
    }
    public void sprinklerRain(SmokeDetector smokeDetector){

        System.out.println(this.name+" starts and showers "+room.getRoomName()+" with water, which extinguishes the fire");
        smokeDetector.setDetector(false);
        this.activateSprinkler = false;
    }
}
