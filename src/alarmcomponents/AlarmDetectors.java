package alarmcomponents;

public abstract class AlarmDetectors {
    protected String name;
    protected boolean detector;
    protected boolean alarmStatus;

    public void enableAlarm() {
        this.alarmStatus = true;
    }

    public void disableAlarm() {
        this.alarmStatus = false;
    }

    public void restoreAlarm() {
        this.detector = false;
    }

    public abstract void triggerAlarm();

    public boolean isAlarmTriggered() {
        return detector;
    }
}

