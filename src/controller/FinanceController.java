package controller;

import entities.Card;
import util.ConnectionDB;

public class FinanceController extends ConnectionDB {

    ConnectionDB connectionDB = new ConnectionDB();

    public void addCard(Card card) throws Exception{
        open();
        String sql = "INSERT INTO card VALUES(?, ?, ?, ?, ?)";

    }

}
