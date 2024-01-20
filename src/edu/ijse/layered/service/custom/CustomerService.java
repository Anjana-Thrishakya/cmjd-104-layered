/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ijse.layered.service.custom;

import edu.ijse.layered.dto.CustomerDto;
import edu.ijse.layered.service.SuperService;

/**
 *
 * @author anjanathrishakya
 */
public interface CustomerService extends SuperService{
    
    CustomerDto getCustomer(String id) throws Exception;
    
}
