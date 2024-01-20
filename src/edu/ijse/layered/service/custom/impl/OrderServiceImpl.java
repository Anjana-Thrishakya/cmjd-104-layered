/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.layered.service.custom.impl;

import edu.ijse.layered.dao.DaoFactory;
import edu.ijse.layered.dao.custom.ItemDao;
import edu.ijse.layered.dao.custom.OrderDao;
import edu.ijse.layered.dao.custom.OrderDetailDao;
import edu.ijse.layered.db.DBConnection;
import edu.ijse.layered.dto.OrderDetailDto;
import edu.ijse.layered.dto.OrderDto;
import edu.ijse.layered.entity.ItemEntity;
import edu.ijse.layered.entity.OrderDetailEntity;
import edu.ijse.layered.entity.OrderEntity;
import edu.ijse.layered.service.custom.OrderService;
import java.sql.Connection;

/**
 *
 * @author anjanathrishakya
 */
public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao = (OrderDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ORDER);
    private OrderDetailDao orderDetaiDao = (OrderDetailDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ORDER_DETAIL);
    private ItemDao itemDao = (ItemDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ITEM);

    @Override
    public String placeOrder(OrderDto dto) throws Exception {
        Connection connection = DBConnection.getInstance().getCOnnection();

        try {
            connection.setAutoCommit(false);

            OrderEntity orderEntity = new OrderEntity(dto.getOrderId(), dto.getDate(), dto.getCustId());
            if (orderDao.add(orderEntity)) {

                boolean isOrderDetailsSaved = true;

                for (OrderDetailDto odd : dto.getOrderDetailDtos()) {
                    if (!orderDetaiDao.add(new OrderDetailEntity(dto.getOrderId(), odd.getItemId(), odd.getQty(), odd.getDiscount()))) {
                        isOrderDetailsSaved = false;
                    }
                }

                if (isOrderDetailsSaved) {

                    boolean isItemUpdated = true;

                    for (OrderDetailDto odd : dto.getOrderDetailDtos()) {
                        ItemEntity itemEntity = itemDao.get(odd.getItemId());
                        if(itemEntity != null){
                            itemEntity.setQoh(itemEntity.getQoh() - odd.getQty());
                            if(!itemDao.update(itemEntity)){
                                isItemUpdated = false;
                            }
                        }
                    }
                    
                    if(isItemUpdated){
                        connection.commit();
                        return "Success";
                    } else{
                        connection.rollback();
                        return "Item update Error";
                    }

                } else {
                    connection.rollback();
                    return "Order Detail Save Error";
                }

            } else {
                connection.rollback();
                return "Order Save Error";
            }

        } catch (Exception e) {
            connection.rollback();
            e.printStackTrace();
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }
    }

}
