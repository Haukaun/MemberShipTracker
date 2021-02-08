package Prosjekt;

public class SilverMembership extends Membership {
    private final float POINTS_SCALING_FACTOR = (float) 1.2;

    public SilverMembership(){

//TEsting
    }

    @Override
    public int registerPoints(int bonusPointBalance, int newPoints){
        return Math.round(newPoints * POINTS_SCALING_FACTOR) + bonusPointBalance;
    }

    @Override
    public String getMembershipname(){
        return "Silver";
    }
}
