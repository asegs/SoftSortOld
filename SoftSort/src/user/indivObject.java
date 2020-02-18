package user;

import java.util.ArrayList;

public class indivObject {
    private ArrayList<String> items;
    private double score;

    public indivObject(){
        this.items= new ArrayList<>();
        this.score=0;
    }


    public double getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public ArrayList<String> getItems() {
        return items;
    }

    public void addItems(String item) {
        this.items.add(item);
    }
}
