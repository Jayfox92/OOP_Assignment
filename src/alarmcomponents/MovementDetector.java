package alarmcomponents;

public class MovementDetector extends AlarmDetectors {
    public MovementDetector(String name){
        super.name = name;
    }



    public void triggerAlarm(){
        if (super.alarmStatus) {
            super.detector = true;
            System.out.println("Movement has been detected!");
        }
        else System.out.println("Larm disabled, nothing happens");
    }
    public void simulateYardMovement(MovementDetector movementDetector){
        if (super.alarmStatus == true){
            super.detector = true;
            System.out.println("Movement in the yard has been detected!");
        }
        else System.out.println("Larm disabled, nothing happens");
    }
}
