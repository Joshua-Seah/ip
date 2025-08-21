public class Task {
    // Fields
    protected String name;
    protected boolean done;
    protected int type;
    protected String deadline;
    protected String startTime;

    static final int TODO=0, DEADLINE=1, EVENT=2;


    // constructor
    public Task(String name, int type) {
        this.name = name;
        this.done = false;
        this.type = type;
    }

    public Task(String name, int type, String deadline) {
        this.name = name;
        this.done = false;
        this.type = type;
        this.deadline = deadline;
    }

    public Task(String name, int type, String startTime, String endTime) {
        this.name = name;
        this.done = false;
        this.type = type;
        this.startTime = startTime;
        this.deadline = endTime;
    }



    // methods
    public void markDone() {
        this.done = true;
    }

    public void markUndone() {
        this.done = false;
    }

    public String toString() {
        String t = "";
        String suffix = "";
        boolean sNeeded = false;
        switch (type) {
            case TODO:
                t = "T";
                break;
            case DEADLINE:
                t = "D";
                sNeeded = true;
                suffix = "by: " + this.deadline;
                break;
            case EVENT:
                t = "E";
                sNeeded = true;
                suffix = "from: " + this.startTime + " to: " + this.deadline;
                break;
            default:
                t ="err";
                break;
        }
        return  "[ " + t + " ]" +
                (done ? "[X]" : "[ ]") + " " +
                name +
                (sNeeded ? "(" + suffix + ")" : "");
    }
}
