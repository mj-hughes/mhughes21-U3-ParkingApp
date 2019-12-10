package mjhughes.parkingGarage;

/**
 * MinMaxFee
 */
public class MinMaxFee implements FeeStrategy {
    private double minFee;
    private double maxFee;
    private double hourlyRate;
    private int minHours;
    private int hoursStayed;

    /**
     * MinMaxFee constructor
     * @param minFee double
     * @param maxFee double
     * @param hourlyRate double
     * @param minHours int
     * @param hoursStayed int
     */
    public MinMaxFee(double minFee, double maxFee, double hourlyRate, int minHours, int hoursStayed) {
        this.minFee = minFee;
        this.maxFee = maxFee;
        this.hourlyRate = hourlyRate;
        this.minHours = minHours;
        this.hoursStayed = hoursStayed;
    }

    /**
     * calcFeeAmount
     * @return double
     */
    @Override
    public double calcFeeAmount() {
        double fee=minFee;
        if (hoursStayed> minHours) {
            fee+=((hoursStayed-minHours)*hourlyRate);
        }
        fee=fee> maxFee ? maxFee : fee;
        return fee;
    }

}
