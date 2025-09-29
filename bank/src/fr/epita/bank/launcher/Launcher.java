package fr.epita.bank.launcher;

import fr.epita.bank.datamodel.*;
import fr.epita.bank.services.BankAccountService;

import java.util.Scanner;

public class Launcher {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Customer customer = new Customer();
        System.out.println("Customer Creation, enter a customer name:");
        customer.setName( scanner.nextLine() );
        System.out.println("Customer Creation, enter an address:");
        customer.setAddress(scanner.nextLine());

        System.out.println(customer);






        //1. simulate the creation of 2 accounts, 1 savings, 1 invest.
        SavingsAccount savingsAccount = new SavingsAccount();
        InvestmentAccount investmentAccount = new InvestmentAccount();
        System.out.println("Enter the initial balance of the investment account: ");
        investmentAccount.setBalance(getDecimalValue("Enter the initial balance of the investment account: ", scanner));
        savingsAccount.setAccountId("s123");
        savingsAccount.setInterestRate(getDecimalValue("enter the interestRate", scanner));
        savingsAccount.setBalance(300.0);


        //2. from the investment account, create stock orders (pay attention to the balance)
        Stock gold = new Stock();
        gold.setCurrentPrice(30.0);
        //to be completed
        StockOrder stockOrder = BankAccountService.buyStock(investmentAccount, gold, 3);

        System.out.println(stockOrder);
        //3. compute savings interest over the past month (take in account the current balance).
        double interests = BankAccountService.calculateInterests(savingsAccount); //this is the interests calculation


        scanner.close();

    }

    private static double getDecimalValue(String prompt,Scanner scanner) {
        System.out.println(prompt);
        String line = scanner.nextLine();
        double decimalValue = Double.parseDouble(line);
        return decimalValue;
    }


}
