public class AlarmClock {
    // attribute
    // added private int time as correction
    private boolean onOff = false;
    private int time;

    // instance method
    // added addition of machine state by Taylor Ayoub
    public void machineState(){
        System.out.println("Alarm clock is set: "+getState());
    }

    public boolean getState() {
        return onOff;
    }

    public void setState(boolean onOff) {
        this.onOff = onOff;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public AlarmClock(int time) {
        this.time = time;
    }

    // main method
    public static void main(String[] args){
        // instance class
        //added addition by Taylor Ayoub
        AlarmClock clock = new AlarmClock(7);
        AlarmClock instance = new AlarmClock(7);

        // change state
        instance.setState(true);

        // calling instance method and value is changed to be true
        instance.machineState();
        //added addition by Taylor Ayoub
        System.out.println("Your alarm is set for "+clock.getTime());
    }
}
