package model.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ParseException {

        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int number = scanner.nextInt();
        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date checkin = sdf.parse(scanner.next());
        System.out.print("Check-out date (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(scanner.next());

        if (!checkOut.after(checkin)) {
            System.out.println("Error in reservation: Check-out date  must be after check-in date");
        } else {
            Reservasion reservasion = new Reservasion(number, checkin, checkOut);
            System.out.println("Reservation: " + reservasion);

            System.out.println();
            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkin = sdf.parse(scanner.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(scanner.next());

            Date now = new Date();
            if (checkin.before(now) || checkOut.before(now)) {
                System.out.println("Error in reservation: Reservation dates for update must be future dates");
            } else if (!checkOut.after(checkin)) {
                System.out.println("Error in reservation: Check-out date  must be after check-in date");

            } else {
                reservasion.updateDates(checkin, checkOut);
                System.out.println("Reservation: " + reservasion);
            }

        }

        scanner.close();
    }
}