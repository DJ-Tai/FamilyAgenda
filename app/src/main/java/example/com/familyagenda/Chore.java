package example.com.familyagenda;

/**
 * Created by Alex on 4/17/2018.
 */

public class Chore {
    private String name;

    private int year;
    private int month;
    private int dayOfMonth;

    private boolean complete = false;
    private boolean repeat = false;

    public Chore(String name, int year, int month, int dayOfMonth, boolean repeat) {
        this.name = name;
        this.year = year;
        this.month = month;
        this.dayOfMonth = dayOfMonth;
        this.repeat = repeat;
    }

    public String getName() {
        return name;
    }

    public boolean getComplete() {
        return complete;
    }

    public void setName(String n) {
        name = n;
    }

    public void setComplete(int c) {
        if (c == 1) {
            complete = true;
        }else {
            complete = false;
        }
    }



}
