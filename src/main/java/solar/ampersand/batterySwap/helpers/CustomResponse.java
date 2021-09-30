package solar.ampersand.batterySwap.helpers;

public class CustomResponse extends GenericResponse{
    private double priceToPay;

    public double getPriceToPay() {
        return priceToPay;
    }

    public void setPriceToPay(double priceToPay) {

        double PRICE_PER_MILE = 2.3; // ASSUMPTION
        this.priceToPay = priceToPay * PRICE_PER_MILE;
    }


    public CustomResponse(String message, Object data, double priceToPay) {
        super(message, data);
        this.priceToPay = priceToPay;
    }
}
