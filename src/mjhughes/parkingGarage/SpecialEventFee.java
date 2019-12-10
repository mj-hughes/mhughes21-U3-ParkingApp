package mjhughes.parkingGarage;

/**
 * SpecialEventFee
 */
public class SpecialEventFee implements FeeStrategy {
    private double flatFee;

    /**
     * SpecialEventFee constructor
     * @param flatFee double
     */
    public SpecialEventFee(double flatFee) {
        this.flatFee = flatFee;
    }

    /**
     * calcFeeAmount
     * @return double
     */
    @Override
    public double calcFeeAmount() {
        return flatFee;
    }
}
