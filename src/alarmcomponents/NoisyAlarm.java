package alarmcomponents;

import java.util.ArrayList;
import java.util.List;

public class NoisyAlarm {
    private String alarmName;
    public NoisyAlarm(String alarmName){
        this.alarmName = alarmName;
    }
    private List<DoorDetector> listOfDoorDetectors = new ArrayList<>();
    private List<WindowDetector> listOfWindowDetectors = new ArrayList<>();
    private List<MovementDetector> listOfMovementDetectors = new ArrayList<>();

    public void checkAlarmStatus(){
        for (DoorDetector doorDetector : listOfDoorDetectors) {
            if (doorDetector.isAlarmTriggered()) {
                triggerAlarm();
                return;
            }
        }

        for (MovementDetector movementDetector : listOfMovementDetectors) {
            if (movementDetector.isAlarmTriggered()) {
                triggerAlarm();
                return;
            }
        }

        for (WindowDetector windowDetector : listOfWindowDetectors) {
            if (windowDetector.isAlarmTriggered()) {
                triggerAlarm();
                return;
            }
        }

    }
    public void triggerAlarm(){
        System.out.println("The alarm sounds with a terrible noise");
    }

    public List<DoorDetector> getListOfDoorDetectors() {
        return listOfDoorDetectors;
    }

    public List<WindowDetector> getListOfWindowDetectors() {
        return listOfWindowDetectors;
    }

    public List<MovementDetector> getListOfMovementDetectors() {
        return listOfMovementDetectors;
    }
}
