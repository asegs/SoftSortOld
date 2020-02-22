package user;

public class Passer {
    private indivObject object;
    private double maxScore;

    public Passer(indivObject object,double maxScore){
        this.object=object;
        this.maxScore=maxScore;
    }


    public indivObject getObject() {
        return object;
    }

    public void setObject(indivObject object) {
        this.object = object;
    }

    public double getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(double maxScore) {
        this.maxScore = maxScore;
    }
}
