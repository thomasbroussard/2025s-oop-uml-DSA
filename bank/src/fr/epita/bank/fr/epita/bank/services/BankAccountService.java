package fr.epita.bank.fr.epita.bank.services;

import fr.epita.bank.datamodel.InvestmentAccount;
import fr.epita.bank.datamodel.SavingsAccount;
import fr.epita.bank.datamodel.Stock;
import fr.epita.bank.datamodel.StockOrder;

public class BankAccountService {

    private static final double COMMISSION_RATE = 0.03;

    public static double calculateInterests(SavingsAccount savingsAccount) {
        return savingsAccount.getBalance() * savingsAccount.getInterestRate();
    }

    public static StockOrder buyStock(InvestmentAccount investmentAccount, Stock gold, int quantity) {
        StockOrder stockOrder = new StockOrder();
        stockOrder.setInvestmentAccount(investmentAccount);
        stockOrder.setStock(gold);
        stockOrder.setQuantity(quantity);
        stockOrder.setUnitPrice(gold.getCurrentPrice());
        double totalPrice = stockOrder.getUnitPrice() * stockOrder.getQuantity();
        double commissionRate = COMMISSION_RATE;
        stockOrder.setCommission(commissionRate);
        investmentAccount.setBalance(investmentAccount.getBalance() - (totalPrice * ( 1 + commissionRate )));
        return stockOrder;
    }

}
