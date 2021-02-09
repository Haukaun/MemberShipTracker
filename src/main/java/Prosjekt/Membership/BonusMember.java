package Prosjekt.Membership;


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

    public BonusMember(int memberNumber, LocalDate enrolledDate, int bonusPointsBalance , String name, String eMailAddress){
        this.memberNumber = memberNumber;
        this.enrolledDate = enrolledDate;
        this.name = name;
        this.bonusPointsBalance = bonusPointsBalance;
        this.eMailAddress = eMailAddress;
        this.password = "";
        checkAndSetMembership();

    }


    public int getMemberNumber(){
        return memberNumber;

    }

    public String getMembership(){
        return membership.getMembershipname();
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

    /**
     * Give you the local time date.
     * @return
     */
    public LocalDate getDate(){
        return LocalDate.now();
    }

    /**
     * Checks password if its written correctly.
     * @param password Grabs the password and checks it.
     * @return
     */
    public boolean checkPassword(String password){
        boolean checkPassword = false;

        if(getPassword().equals(password)){
            checkPassword = true;
        }
        return checkPassword;
    }

    /**
     * Takes old points and adds newpoints to the balance.
     * @param newPoints Adds the number of points.
     */
    public void registerBonusPoints(int newPoints){
        bonusPointsBalance = membership.registerPoints(this.bonusPointsBalance, newPoints);
        checkAndSetMembership();
    }

    /**
     * Checks point and which membership they belong too.
     */
    public void checkAndSetMembership(){
            if(getBonusPointsBalance() < SILVER_LIMIT) {
                 this.membership = new BasicMembership();

            }
            if (getBonusPointsBalance() >= SILVER_LIMIT){
                this.membership = new SilverMembership();

            }
            if(getBonusPointsBalance() >= GOLD_LIMIT){
                this.membership = new GoldMembership();
            }


    }

    /**
     * Simpel Client setup that shows you how the program works.
     * @param args
     */
    public static void main(String[] args) {
        BonusMember bonusMember = new BonusMember(1, LocalDate.now(), 15000, "Håkon", "haakonfgs@hotmail.com");
        System.out.println("MemberNumber: " + bonusMember.getMemberNumber() + " | Membername: " + bonusMember.getName() +" | BonusPoints: " + bonusMember.getBonusPointsBalance() +" | Membership: " + bonusMember.getMembership() + " | Date: " + bonusMember.getDate());
        bonusMember.registerBonusPoints(10000);
        System.out.println(bonusMember.bonusPointsBalance);
        System.out.println("MemberNumber: " + bonusMember.getMemberNumber() + " | Membername: " + bonusMember.getName() +" | BonusPoints: " + bonusMember.getBonusPointsBalance() +" | Membership: " + bonusMember.getMembership() + " | Date: " + bonusMember.getDate());



    }



}
