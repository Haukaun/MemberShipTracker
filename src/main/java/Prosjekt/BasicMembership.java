package Prosjekt;

public class BasicMembership extends Membership {



    public BasicMembership()
    {

    }

    @Override
    public int registerPoints(int bonusPointBalance, int newPoints){
        return newPoints + bonusPointBalance;
    }

    @Override
    public String getMembershipname(){
        return "Basic";
    }

}
