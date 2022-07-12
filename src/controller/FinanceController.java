package controller;

import entities.Card;
import util.ConnectionDB;


import javax.swing.*;
import java.sql.*;

public class FinanceController {

    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet;

    public void addCard(Card card) {
        String sql = "INSERT INTO card (DESCRIPTION, FLAG, LIMIT_CARD, CLOSING_DAY, PAYMENT_DAY) VALUES(?, ?, ?, ?, ?)";

        try {
            connection = ConnectionDB.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, card.getDescription());
            statement.setString(2, card.getFlag());
            statement.setDouble(3, card.getLimitCard());
            statement.setDate(4, new Date(card.getClosingDay().getTime()));
            statement.setDate(5, new Date(card.getPaymentDay().getTime()));
            statement.execute();
            statement.close();

            JOptionPane.showMessageDialog(null, "### Card added successfully ###");


        } catch (SQLException e) {
            throw new RuntimeException("Error add card " + e.getMessage());
        } finally {
            ConnectionDB.closeConnection(connection, statement);
        }
    }


    public void changeCard(Card card) {
        String sql = "UPDATE card SET DESCRIPTION = ?, FLAG = ?, LIMIT_CARD = ?, CLOSING_DAY = ?, PAYMENT_DAY = ? WHERE id = ?";

        try {
            connection = ConnectionDB.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, card.getDescription());
            statement.setString(2, card.getFlag());
            statement.setDouble(3, card.getLimitCard());
            statement.setDate(4, new Date(card.getClosingDay().getTime()));
            statement.setDate(5, new Date(card.getPaymentDay().getTime()));
            statement.setInt(6, card.getId());
            statement.execute();
            statement.close();

            JOptionPane.showMessageDialog(null,"### Card changed successfully ###");


        } catch (SQLException e) {
            throw new RuntimeException("Error change card " + e.getMessage());
        }

    }

    public void deleteCard(int id) throws Exception{
        String sql = "DELETE FROM card WHERE id = ?";
        connection = ConnectionDB.getConnection();
        statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.execute();
        statement.close();

        JOptionPane.showMessageDialog(null,"### Card deleted successfully ###\"");

    }

    public Card checkCard(int id) throws Exception {
        String sql = "SELECT * FROM card WHERE id = ?";
        connection = ConnectionDB.getConnection();
        statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        resultSet = statement.executeQuery();
        Card card = null;

        if (resultSet.next()) {
            card = new Card();
        } else {
            JOptionPane.showMessageDialog(null,"Register not found");
        }
        return card;
    }


}