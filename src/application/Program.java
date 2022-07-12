package application;

import controller.FinanceController;
import entities.Card;

import javax.swing.*;
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

        String[] menu = {"1) Add Card", "2) Change Card Data", "3) Delete Card", "4) Show All Registered Cards", "5) Exit"};


        int option = Integer.parseInt(JOptionPane.showInputDialog(menu));

        int response = option;

        while (response != 5) {
            if (response == 1) {
                String description = JOptionPane.showInputDialog("Enter card description: ");

                String flag = JOptionPane.showInputDialog("Enter flag description: ");

                Double limitCard = Double.parseDouble(JOptionPane.showInputDialog("Enter limit card: "));

                Date closingDay = sdf.parse(JOptionPane.showInputDialog("Enter closing day (dd/mm/yyyy): "));

                Date paymentDay = sdf.parse(JOptionPane.showInputDialog("Enter payment day: (dd/mm/yyyy): "));

                Card card = new Card(description, flag, limitCard, closingDay, paymentDay);

                financeController.addCard(card);

            } else if (response == 2) {

                int id = Integer.parseInt(JOptionPane.showInputDialog("Enter id to change: "));

                Card card = financeController.checkCard(id);

                if (card != null) {
                    String description = JOptionPane.showInputDialog("Enter card description: ");

                    String flag = JOptionPane.showInputDialog("Enter flag description: ");

                    Double limitCard = Double.parseDouble(JOptionPane.showInputDialog("Enter limit card: "));

                    Date closingDay = sdf.parse(JOptionPane.showInputDialog("Enter closing day (dd/mm/yyyy): "));

                    Date paymentDay = sdf.parse(JOptionPane.showInputDialog("Enter payment day: (dd/mm/yyyy): "));

                    card = new Card(id, description, flag, limitCard, closingDay, paymentDay);

                    financeController.changeCard(card);


                }


            } else if (response == 3) {

                int id = Integer.parseInt(JOptionPane.showInputDialog("Enter id to delete: "));

                Card card = financeController.checkCard(id);

                if (card != null) {
                    financeController.deleteCard(id);
                }

            } else if (response == 4) {
                System.out.println("Show All Registered Cards");
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Option", "ERROR", JOptionPane.ERROR_MESSAGE);

            }

            option = Integer.parseInt(JOptionPane.showInputDialog(menu));
            response = option;
        }
    }
}
