package application;

import controller.FinanceController;
import entities.Card;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws Exception {

        Locale.setDefault(Locale.US);
        Scanner key = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        FinanceController financeController = new FinanceController();

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
                key.nextLine();
                System.out.print("Enter card description: ");
                String description = key.nextLine();

                System.out.print("Enter flag description: ");
                String flag = key.nextLine();

                System.out.print("Enter limit card: ");
                Double limitCard = key.nextDouble();

                System.out.print("Enter closing day (dd/mm/yyyy): ");
                Date closingDay = sdf.parse(key.next());

                System.out.print("Enter payment day: (dd/mm/yyyy): ");
                Date paymentDay = sdf.parse(key.next());

                Card card = new Card(description, flag, limitCard, closingDay, paymentDay);

                financeController.addCard(card);

            } else if (response == 2) {
                System.out.print("Enter id to change: ");
                int id = key.nextInt();

                Card card = financeController.checkCard(id);

                if (card != null) {
                    key.nextLine();
                    System.out.print("Enter new card description: ");
                    String description = key.nextLine();

                    System.out.print("Enter new flag description: ");
                    String flag = key.nextLine();

                    System.out.print("Enter new limit card: ");
                    Double limitCard = key.nextDouble();

                    System.out.print("Enter new closing day (dd/mm/yyyy): ");
                    Date closingDay = sdf.parse(key.next());

                    System.out.print("Enter new payment day: (dd/mm/yyyy): ");
                    Date paymentDay = sdf.parse(key.next());

                    card = new Card(id, description, flag, limitCard, closingDay, paymentDay);

                    financeController.changeCard(card);
                }


            } else if (response == 3) {

                System.out.print("Enter id to delete: ");
                int id = key.nextInt();

                Card card = financeController.checkCard(id);

                if (card != null) {
                    financeController.deleteCard(id);
                }

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
