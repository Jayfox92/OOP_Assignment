package alarmcomponents;

public class WindowDetector extends AlarmDetectors {
    public WindowDetector(String name){
        super.name = name;
    }

    @Override
    public void triggerAlarm(){
        if (super.alarmStatus == true) {
            super.detector = true;
            System.out.println("Someone broke through a window!");
        }
        else System.out.println("Larm disabled, nothing happens");
    }

    @Override
    public boolean isAlarmTriggered() {
        return super.isAlarmTriggered();
    }
}
