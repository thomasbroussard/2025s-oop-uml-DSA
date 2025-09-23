package fr.epita.bank.launcher;

import fr.epita.bank.datamodel.*;

public class Launcher {

    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setName( "test");
        customer.setAddress("Paris");

        System.out.println(customer);

        //1. simulate the creation of 2 accounts, 1 savings, 1 invest.
        SavingsAccount savingsAccount = new SavingsAccount();
        InvestmentAccount investmentAccount = new InvestmentAccount();
        investmentAccount.setBalance(300.0);
        savingsAccount.setAccountId("s123");
        savingsAccount.setInterestRate(0.0325);
        savingsAccount.setBalance(300.0);


        //2. from the investment account, create stock orders (pay attention to the balance)
        Stock gold = new Stock();
        gold.setCurrentPrice(30.0);
        //to be completed
        StockOrder stockOrder = new StockOrder();
        stockOrder.setInvestmentAccount(investmentAccount);
        stockOrder.setStock(gold);
        stockOrder.setQuantity(3);
        stockOrder.setUnitPrice(gold.getCurrentPrice());
        stockOrder.setCommission(0.0); //TODO find out the formula to calculate commission


        //3. compute savings interest over the past month (take in account the current balance).
        double interests = savingsAccount.getBalance() * savingsAccount.getInterestRate(); //this is the interests calculation

        //this is to be completed
    }


}
