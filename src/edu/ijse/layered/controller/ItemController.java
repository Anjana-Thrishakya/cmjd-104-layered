/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.layered.controller;

import edu.ijse.layered.dto.ItemDto;
import edu.ijse.layered.service.ServiceFactory;
import edu.ijse.layered.service.custom.ItemService;
import java.util.List;

/**
 *
 * @author anjanathrishakya
 */
public class ItemController {
    
    private ItemService itemService = (ItemService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.ITEM);

    public String save(ItemDto itemDto) throws Exception{
        return itemService.saveItem(itemDto);
    }
    
    public String update(ItemDto itemDto) throws Exception{
        return itemService.UpdateItem(itemDto);
    }
    
    public String delete(String itemId) throws Exception{
        return itemService.deleteItem(itemId);
    }
    
    public ItemDto get(String itemId) throws Exception{
        return itemService.getItem(itemId);
    }
    
    public List<ItemDto> getAll() throws Exception{
        return itemService.getAll();
    }
    
}
