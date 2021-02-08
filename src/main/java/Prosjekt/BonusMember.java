package Prosjekt;

import java.time.LocalDate;

public class BonusMember {

    private int memberNumber;
    private LocalDate enrolledDate;
    private int bonusPointsBalance = 0;
    private String name;
    private String eMailAddress;
    private String password;
    private Membership membership;

    private static final int SILVER_LIMIT = 25000;
    private static final int GOLD_LIMIT = 75000;

    public BonusMember(int memberNumber, LocalDate enrolledDate, String name, String eMailAddress, String password, Membership membership){
        this.memberNumber = memberNumber;
        this.enrolledDate = enrolledDate;
        this.name = name;
        this.bonusPointsBalance = 0;
        this.eMailAddress = eMailAddress;
        this.password = password;
        this.membership = membership;
    }

    public int getMemberNumber(){
        return memberNumber;

    }

    public int getBonusPointsBalance(){
        return bonusPointsBalance;

    }

    public String getName(){
        return name;
    }

    public String geteMailAddress(){
        return eMailAddress;

    }

    public String getPassword(){
        return password;
    }



    public boolean checkPassword(String password){
        boolean checkPassword = false;

        if(getPassword().equals(password)){
            checkPassword = true;
        }
        return checkPassword;
    }

    public void registerBonusPoints(int newPoints){

    }

    public void checkAndSetMembership(){
            if(getBonusPointsBalance() < 25000) {
                 this.membership = new BasicMembership();

            } else if (getBonusPointsBalance() >= 25000){
                this.membership = new SilverMembership();

            } else if(getBonusPointsBalance() <= 75000){
                this.membership = new GoldMembership();
            }


    }


}
