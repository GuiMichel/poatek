package ChallengeOne.Classes;

public class ChallengeOneClasses {
    public static void main(String[] args) {

        FuelPump pumpOne = new FuelPump(5.2,500.0);

        System.out.println(pumpOne.fillWithPrice(10.4));
        System.out.println(pumpOne.fillWithLiters(20));
        System.out.println(pumpOne.getFuelPrice());
        System.out.println(pumpOne.getFuelQuantity());
    }
}
