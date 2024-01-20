/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.layered.service.custom.impl;

import edu.ijse.layered.dao.DaoFactory;
import edu.ijse.layered.dao.custom.CustomerDao;
import edu.ijse.layered.dto.CustomerDto;
import edu.ijse.layered.entity.CustomerEntity;
import edu.ijse.layered.service.custom.CustomerService;

/**
 *
 * @author anjanathrishakya
 */
public class CustomerServiceImpl implements CustomerService{
    
    private CustomerDao customerDao = (CustomerDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.CUSTOMER);

    @Override
    public CustomerDto getCustomer(String id) throws Exception {
        CustomerEntity e = customerDao.get(id);
        if(e != null){
            CustomerDto dto = new CustomerDto(e.getCustId(),
                    e.getTitle(), e.getName(),
                    e.getDob(), e.getSalary(), e.getAddress(), e.getCity(),
                    e.getProvince(),e.getZip());
            
            return dto;
        }
        return null;
    }
    
}
