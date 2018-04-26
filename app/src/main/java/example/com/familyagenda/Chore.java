package example.com.familyagenda;

/**
 * Created by Alex on 4/17/2018.
 */

public class Chore {
    private String name;

    private boolean complete = false;


    public Chore(String name) {
        this.name = name;
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
