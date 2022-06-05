package ChallengeOne.Classes;

public class FuelPump {
    private double fuelPrice;
    private double fuelQuantity;

    public FuelPump(double fuelPrice, double fuelQuantity) {
        this.fuelPrice = fuelPrice;
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelPrice() {
        return fuelPrice;
    }

    public void setFuelPrice(double fuelPrice) {
        this.fuelPrice = fuelPrice;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double fillWithPrice(double price){
        if(this.getFuelPrice() != 0 && this.getFuelQuantity()>=(price/this.getFuelPrice())){
            this.setQuantity(this.getFuelQuantity()-(price/this.getFuelPrice()));
            return price/this.getFuelPrice();
        }else{
            return 0;
        }
    }

    public double fillWithLiters(double liters){
        if(this.getFuelPrice() !=0 && this.getFuelQuantity()>=liters){
            this.setQuantity(this.getFuelQuantity()-liters);
            return liters*this.getFuelPrice();
        }else{
            return 0;
        }
    }

    public void setPrice(double price){
        if(price>=0)
        this.setFuelPrice(price);
        else System.out.println("Price can never be negative");
    }

    public void setQuantity(double quantity){
        if(quantity>=0)
        this.setFuelQuantity(quantity);
        else System.out.println("Quantity can never be negative");
    }

}
