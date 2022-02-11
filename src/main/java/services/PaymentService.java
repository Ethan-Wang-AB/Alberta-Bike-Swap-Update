/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.TradeDB;
import dataaccess.Trade_DescDB;
import dataaccess.Trade_OthersDB;
import java.util.Date;
import models.Bike;
import models.Trade;
import models.TradeOthers;
import models.User;

/**
 *
 * @author 845593
 */
public class PaymentService {

    private TradeDB tradeDB = TradeDB.getInstance();
    private Trade_DescDB tradeDescDB=Trade_DescDB.getInstance(); 
    private Trade_OthersDB tradeOthersDB=Trade_OthersDB.getInstance();
    private final int SELLER_TICKET=1;
     private final int STORAGE_FEE=2;
      private final int BUYER_TICKET=3;

    public final boolean paySellerTicket(User user) {
        
        TradeOthers tradeOther=new TradeOthers();
        tradeOther.setUserId(user);
        tradeOther.setDescId(tradeDescDB.getTradeDesc(SELLER_TICKET));
        return tradeOthersDB.add(tradeOther);

    }

    public final boolean payBuyerTicket(User user) {
            TradeOthers tradeOther=new TradeOthers();
        tradeOther.setUserId(user);
        tradeOther.setDescId(tradeDescDB.getTradeDesc(BUYER_TICKET));
        return tradeOthersDB.add(tradeOther);

    }

    public final boolean payStorageFee(User user) {
          TradeOthers tradeOther=new TradeOthers();
        tradeOther.setUserId(user);
        tradeOther.setDescId(tradeDescDB.getTradeDesc(STORAGE_FEE));
        return tradeOthersDB.add(tradeOther);

    }

    public final boolean payBike(User buyer,Bike bike) {
      
        Trade trade=new Trade();
        trade.setBuyerId(buyer);
        trade.setBikeId(bike);
        trade.setTransDate(new Date());
        
        return tradeDB.add(trade);
        
        
    }
}
