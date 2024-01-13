/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.layered.dao.custom.impl;

import edu.ijse.layered.dao.CrudUtil;
import edu.ijse.layered.dao.custom.ItemDao;
import edu.ijse.layered.entity.ItemEntity;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author anjanathrishakya
 */
public class ItemDaoImpl implements ItemDao {

    @Override
    public boolean add(ItemEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO ITEM VALUES(?,?,?,?,?)", 
                t.getItemCode(),
                t.getDescription(),
                t.getPack(),
                t.getUnitPrice(),
                t.getQoh());
    }

    @Override
    public boolean update(ItemEntity t) throws Exception {
        return CrudUtil.executeUpdate("UPDATE Item SET Description=?, PackSize=?, UnitPrice=?, QtyOnHand=? WHERE ItemCode=?", 
                t.getDescription(),
                t.getPack(),
                t.getUnitPrice(),
                t.getQoh(),
                t.getItemCode());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM item WHERE ItemCode=?", id);
    }

    @Override
    public ItemEntity get(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Item WHERE ItemCode=?", id);
        while (rst.next()) {            
            return new ItemEntity(rst.getString("ItemCode"), 
                    rst.getString("Description"), 
                    rst.getString("PackSize"), 
                    rst.getDouble("UnitPrice"), 
                    rst.getInt("QtyOnHand"));
        }
        return null;
    }

    @Override
    public ArrayList<ItemEntity> getAll() throws Exception {
        ArrayList<ItemEntity> itemEntities = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Item");
        while (rst.next()) {            
            itemEntities.add( new ItemEntity(rst.getString("ItemCode"), 
                    rst.getString("Description"), 
                    rst.getString("PackSize"), 
                    rst.getDouble("UnitPrice"), 
                    rst.getInt("QtyOnHand")));
        }
        return itemEntities;
    }

}
