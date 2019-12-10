package mjhughes.parkingGarage;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Ticket - serializable for outputting to file
 */
public class Ticket implements Serializable {
    private static int ticketSequence=0;
    private LocalDateTime timeIn;
    private LocalDateTime timeOut;
    private int ticketNum;
    private double fee;
    private String FeeType;

    /**
     * Ticket constructor
     */
    public Ticket() {
        this.ticketNum = ++ticketSequence;
    }

    /**
     * Ticket constructor full
     * @param timeIn LocalDateTime
     * @param timeOut LocalDateTime
     * @param ticketNum int
     * @param feeType string
     */
    public Ticket(LocalDateTime timeIn, LocalDateTime timeOut, int ticketNum, String feeType) {
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.ticketNum = ticketNum;
        FeeType = feeType;
    }

    /**
     * getTimeIn
     * @return LocalDateTime
     */
    public LocalDateTime getTimeIn() {
        return timeIn;
    }

    /**
     * setTimeIn
     * @param timeIn LocalDateTime
     */
    public void setTimeIn(LocalDateTime timeIn) {
        this.timeIn = timeIn;
    }

    /**
     * getTimeOut
     * @return LocalDateTime
     */
    public LocalDateTime getTimeOut() {
        return timeOut;
    }

    /**
     * setTimeOut
     * @param timeOut LocalDateTime
     */
    public void setTimeOut(LocalDateTime timeOut) {
        this.timeOut = timeOut;
    }

    /**
     * getTicketNum
     * @return int
     */
    public int getTicketNum() {
        return ticketNum;
    }

    /**
     * setTicketNum
     * @param ticketNum int
     */
    public void setTicketNum(int ticketNum) {
        this.ticketNum = ticketNum;
    }

    /**
     * getFee
     * @return double
     */
    public double getFee() {
        return fee;
    }

    /**
     * setFee
     * @param fee double
     */
    public void setFee(double fee) {
        this.fee = fee;
    }

    /**
     * getFeeType
     * @return string
     */
    public String getFeeType() {
        return FeeType;
    }

    /**
     * setFeeType
     * @param FeeType string
     */
    public void setFeeType(String FeeType) {
        this.FeeType = FeeType;
    }

    /**
     * toString
     * @return string with ticket information
     */
    @Override
    public String toString() {
        return "Ticket{" +
                "timeIn=" + timeIn +
                ", timeOut=" + timeOut +
                ", ticketNum=" + ticketNum +
                ", fee=" + fee +
                ", FeeType=" + FeeType +
                '}';
    }
}
