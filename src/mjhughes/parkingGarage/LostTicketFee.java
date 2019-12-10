package mjhughes.parkingGarage;

/**
 * LostTicketFee
 */
public class LostTicketFee implements FeeStrategy {
    private double flatFee;

    /**
     * LostTicketFee constructor
     * @param flatFee double
     */
    public LostTicketFee(double flatFee) {
        this.flatFee = flatFee;
    }

    /**
     * calcFeeAmount
     * @return doubles
     */
    @Override
    public double calcFeeAmount() {
        return flatFee;
    }

}
