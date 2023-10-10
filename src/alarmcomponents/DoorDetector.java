package alarmcomponents;

public class DoorDetector extends AlarmDetectors {
    public DoorDetector(String name){
        super.name = name;
    }

    @Override
    public void triggerAlarm() {
        if (alarmStatus) {
            super.detector = true;
            System.out.println("An intrusion has happened!");
        }
        else System.out.println("Larm system disabled, nothing happens");
    }
}
