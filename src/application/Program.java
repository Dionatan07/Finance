package application;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner key = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("### FINANCE ###");
        System.out.println("1) Add Card");
        System.out.println("2) Change Card Data");
        System.out.println("3) Delete Card");
        System.out.println("4) Show All Registered Cards");
        System.out.println("5) Exit");
        System.out.print("Enter option: ");
        int response = key.nextInt();

        while (response != 5) {
            if (response == 1) {
                System.out.println("Add Card");
            } else if (response == 2) {
                System.out.println("Change Card Data");
            } else if (response == 3) {
                System.out.println("Delete Card");
            } else if (response == 4) {
                System.out.println("Show All Registered Cards");
            } else {
                System.out.println("Invalid Option");
            }
            System.out.println();
            System.out.println("### FINANCE ###");
            System.out.println("1) Add Card");
            System.out.println("2) Change Card Data");
            System.out.println("3) Delete Card");
            System.out.println("4) Show All Registered Cards");
            System.out.println("5) Exit");
            System.out.print("Enter option: ");
            response = key.nextInt();
        }
    }
}
