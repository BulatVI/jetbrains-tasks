package banking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Main {

    static Connection connection = null;

    static private void createConnection(String url) {
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    static private void createNewTable() throws SQLException {
        String createNewTable = "CREATE TABLE IF NOT EXISTS card\n" +
                "(\n" +
                "    id      INTEGER PRIMARY KEY autoincrement, -- autimaticly create new id\n" +
                "    number  TEXT,                -- don't write VARCHAR its mistake! \n" +
                "    pin     TEXT,\n" +
                "    balance INTEGER DEFAULT 0\n" +
                ");";
        PreparedStatement pstmt = connection.prepareStatement(createNewTable);
        pstmt.executeUpdate();
        pstmt.close();
    }

    static private void addCard(String number, String pin) throws SQLException {
        String addCard = "insert into card (id, number, pin, balance) VALUES (null,?,?,?)";
        PreparedStatement pstmt = connection.prepareStatement(addCard);
        pstmt.setString(1, number);
        pstmt.setString(2, pin);
        pstmt.setInt(3, 0);
        pstmt.executeUpdate();
        pstmt.close();
    }

    static private boolean findCard(String number, String pin) throws SQLException {
        String selectCard = "select balance from card where number = ? and pin = ?";
        try (PreparedStatement statement = connection.prepareStatement(selectCard)) {
            statement.setString(1, number);
            statement.setString(2, pin);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        }
    }

    static private boolean findCard(String number) throws SQLException {
        String selectCard = "select balance from card where number = ?";
        try (PreparedStatement statement = connection.prepareStatement(selectCard)) {
            statement.setString(1, number);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        }
    }

    static private int selectBalace(String number, String pin) throws SQLException {
        String selectBalace = "select balance from card where number = ? and pin = ?";
        int balance = 0;
        try (PreparedStatement statement = connection.prepareStatement(selectBalace)) {
            statement.setString(1, number);
            statement.setString(2, pin);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                balance = resultSet.getInt("balance");
            }
            return balance;
        }
    }

    static private void addIncome(String number, String pin, int balance) throws SQLException {
        String addIncome = "update card set balance = card.balance + ? where number = ?  and pin = ?";
        try (PreparedStatement statement = connection.prepareStatement(addIncome)) {
            statement.setInt(1, balance);
            statement.setString(2, number);
            statement.setString(3, pin);
            statement.executeUpdate();
        }
    }

    static private void deletAcount(String number, String pin) throws SQLException {
        String deletAcount = "delete from card where number = ?  and pin = ?";
        try (PreparedStatement statement = connection.prepareStatement(deletAcount)) {
            statement.setString(1, number);
            statement.setString(2, pin);
            statement.executeUpdate();
        }
    }

    static private void trancferMoney(String fromCard, String toCard, int balance) throws SQLException {
        String trancferMoney = "update card set balance = card.balance + ? where number = ?;";
        try (PreparedStatement statement1 = connection.prepareStatement(trancferMoney);
             PreparedStatement statement2 = connection.prepareStatement(trancferMoney)) {
            statement1.setInt(1, -balance);
            statement1.setString(2, fromCard);
            statement2.setInt(1, balance);
            statement2.setString(2, toCard);
            statement1.executeUpdate();
            statement2.executeUpdate();
        }
    }


    public static void main(String[] args) throws IOException, SQLException {
        String url = "jdbc:sqlite:" + args[1]; // for creating DB

        createConnection(url);
        createNewTable();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
//            Map<String, String> cards = new HashMap<>();

            boolean b = true;
            while (b) {
                System.out.println("1. Create an account\n" +
                        "2. Log into account\n" +
                        "0. Exit");
                String str = (br.readLine());
                System.out.println();
                switch (str) {
                    case "1": {
                        String bin = "400000";
                        String accountNumber = String.format("%09d", (int) (Math.random() * 1000_000_000));
                        int checksum = addLunaNumber(bin + accountNumber);
                        String cardNumber = bin + accountNumber + checksum;
                        String pin = String.format("%04d", (int) (Math.random() * 10000));
                        System.out.println("Your card has been created\n" +
                                "Your card number:\n" +
                                cardNumber + "\n" +
                                "Your card PIN:\n" + pin + "\n");
//                        cards.put(cardNumber, pin + "");
                        addCard(cardNumber, pin);
                        break;
                    }
                    case "2": {
                        System.out.println("Enter your card number:");
                        String cardNumber = br.readLine();
                        System.out.println("Enter your PIN:");
                        String pin = br.readLine();
                        if (findCard(cardNumber, pin))
//                        if (cards.containsKey(cardNumber) && cards.get(cardNumber).equals(pin))
                        {
                            System.out.println("\nYou have successfully logged in!\n");
                            boolean b1 = true;
                            while (b1) {
                                System.out.println("1. Balance\n" +
                                        "2. Add income\n" +
                                        "3. Do transfer\n" +
                                        "4. Close account\n" +
                                        "5. Log out\n" +
                                        "0. Exit");
                                String s = br.readLine();
                                System.out.println();
                                switch (s) {
                                    case "1": {
                                        System.out.println("Balance: " + selectBalace(cardNumber, pin) + "\n");
                                        break;
                                    }
                                    case "2": {//Add income
                                        System.out.println("Enter income:");
                                        int sum = Integer.parseInt(br.readLine());
                                        addIncome(cardNumber, pin, sum);
                                        System.out.println("Income was added!");
                                        break;
                                    }
                                    case "3": {//Do transfer
                                        System.out.println("Transfer\n" +
                                                "Enter card number:");
                                        String trancferCard = br.readLine();
                                        if (!checLuna(trancferCard)) {
                                            System.out.println("Probably you made a mistake in the card number. Please try again!\n");
                                            break;
                                        }
                                        if (!findCard(trancferCard)) {
                                            System.out.println("Such a card does not exist.\n");
                                            break;
                                        }
                                        System.out.println("Enter how much money you want to transfer:");
                                        int howMuchMoney = Integer.parseInt(br.readLine());
                                        int balance = selectBalace(cardNumber, pin);
                                        if (balance <= howMuchMoney) {
                                            System.out.println("Not enough money!\n");
                                            break;
                                        }
                                        trancferMoney(cardNumber, trancferCard, howMuchMoney);
                                        System.out.println("Success!\n");
                                        break;
                                    }
                                    case "4": {//Close account
                                        deletAcount(cardNumber, pin);
                                        System.out.println("The account has been closed!\n");
                                        break;
                                    }
                                    case "5": {
                                        b1 = false;
                                        break;
                                    }
                                    case "0": {
                                        System.out.println("Bye!");
                                        b = false;
                                        b1 = false;
                                        break;
                                    }
                                }
                            }
                        } else System.out.println("Wrong card number or PIN!\n");
                        break;
                    }
                    case "0": {
                        System.out.println("Bye!");
                        b = false;
                        break;
                    }
                }
            }
        }
        connection.close();
    }

    private static int addLunaNumber(String number) {
        List<Integer> list = new ArrayList<>();
        for (int j = number.length() - 1; j >= 0; j--) {
            list.add(Integer.parseInt(String.valueOf(number.trim().charAt(j))));
        }

        int sum1 = IntStream.range(0, list.size())
                .filter(index -> index % 2 == 0)
                .map(i -> list.get(i) * 2)
                .map(x -> {
                    if (x > 9) {
                        x = x - 9;
                    }
                    return x;
                })
                .sum();

        int sum2 = IntStream.range(0, list.size())
                .filter(index -> index % 2 == 1)
                .map(list::get)
                .sum();
        int summ = sum1 + sum2;
        return (10 - summ % 10) % 10;
    }

    private static boolean checLuna(String number) {
        return (addLunaNumber(number.substring(0, number.length() - 1)) + "")
                .equals(number.substring(number.length() - 1));
    }
}