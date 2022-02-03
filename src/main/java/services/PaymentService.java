/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.TradeDB;

/**
 *
 * @author 845593
 */
public class PaymentService {

    private TradeDB tradeDB = TradeDB.getInstance();

    public final boolean paySellerTicket() {
        return false;

    }

    public final boolean payBuyerTicket() {
        return false;

    }

    public final boolean payStorageFee() {
        return false;

    }

    public final boolean payBike() {
        return false;

    }
}
