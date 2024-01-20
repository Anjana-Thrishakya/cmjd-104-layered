/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.layered.dao;

import edu.ijse.layered.dao.custom.impl.CustomerDaoImpl;
import edu.ijse.layered.dao.custom.impl.ItemDaoImpl;
import edu.ijse.layered.dao.custom.impl.OrderDaoImpl;
import edu.ijse.layered.dao.custom.impl.OrderDetaiDaoImpl;

/**
 *
 * @author anjanathrishakya
 */
public class DaoFactory {

    private static DaoFactory daoFactory;

    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        if (daoFactory == null) {
            daoFactory = new DaoFactory();
        }
        return daoFactory;
    }

    public SuperDao getDao(DaoTypes type) {
        switch (type) {
            case ITEM:
                return new ItemDaoImpl();
            case ORDER:
                return new OrderDaoImpl();
            case ORDER_DETAIL:
                return new OrderDetaiDaoImpl();
            case CUSTOMER:
                return new CustomerDaoImpl();
            default:
                return null;
        }
    }

    public enum DaoTypes {
        ITEM, ORDER, ORDER_DETAIL, CUSTOMER
    }
}
