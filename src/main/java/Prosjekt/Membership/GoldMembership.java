package Prosjekt.Membership;

public class GoldMembership extends Membership {

    private final float POINTS_SCALING_FACTOR_LEVEL_1 = (float) 1.3;
    private final float POINTS_SCALING_FACTOR_LEVEL_2 = (float) 1.5;

    public GoldMembership(){


    }

    @Override
    public int registerPoints(int bonusPointBalance, int newPoints)
    {
        int pointsToBeAdded;
        if(bonusPointBalance < 90000)
        {
            pointsToBeAdded = Math.round(newPoints * POINTS_SCALING_FACTOR_LEVEL_1) + bonusPointBalance;
        }
        else
        {
            pointsToBeAdded = Math.round(newPoints * POINTS_SCALING_FACTOR_LEVEL_2) + bonusPointBalance;
        }
        return pointsToBeAdded;
    }

    @Override
    public String getMembershipname(){
        return "Gold";
    }


}
