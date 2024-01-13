/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.layered.service.custom.impl;

import edu.ijse.layered.dao.DaoFactory;
import edu.ijse.layered.dao.custom.ItemDao;
import edu.ijse.layered.dto.ItemDto;
import edu.ijse.layered.entity.ItemEntity;
import edu.ijse.layered.service.custom.ItemService;
import java.util.List;

/**
 *
 * @author anjanathrishakya
 */
public class ItemServiceImpl implements ItemService{
    
    private ItemDao itemDao = (ItemDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ITEM);

    @Override
    public String saveItem(ItemDto dto) throws Exception {
        ItemEntity itemEntity = new ItemEntity(dto.getItemCode(), dto.getDescription(), 
                dto.getPack(), dto.getUntPrice(), dto.getQoh());
        if(itemDao.add(itemEntity)){
            return "Successfully Saved";
        } else{
            return "Fail";
        }
    }

    @Override
    public String UpdateItem(ItemDto itemDto) throws Exception {
        return null;

    }

    @Override
    public String deleteItem(String itemCode) throws Exception {

        return null;
    }

    @Override
    public ItemDto getItem(String itemCode) throws Exception {
        return null;
    }

    @Override
    public List<ItemDto> getAll() throws Exception {
        return null;
    }
    
}
