package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservasion {

    private Integer roomNumber;
    private Date checkIn;
    private Date checkout;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservasion(Integer roomNumber, Date checkout, Date checkIn) {
        this.roomNumber = roomNumber;
        this.checkout = checkout;
        this.checkIn = checkIn;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckout() {
        return checkout;
    }

    public long duration() {
        long diff =  checkout.getTime() - checkIn.getTime() ;
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public String updateDates(Date checkIn, Date checkOut) {

        Date now = new Date();
        if (checkIn.before(now) || checkOut.before(now)) {
            return "Reservation dates for update must be future dates";
        }
        if (!checkOut.after(checkIn)) {
            return "Check-out date  must be after check-in date";
    }
        this.checkIn = checkIn;
        this.checkout = checkOut;
        return null;
    }

    @Override
    public String toString() {
        return "Room "
                + roomNumber
                + ", check-in "
                + sdf.format(checkIn)
                +", check-out "
                +sdf.format(checkout)
                +", "
                + duration()
                + " nigths";
    }
}
