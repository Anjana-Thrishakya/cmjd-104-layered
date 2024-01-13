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
import java.util.ArrayList;
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
        ItemEntity itemEntity = new ItemEntity(itemDto.getItemCode(), itemDto.getDescription(), 
                itemDto.getPack(), itemDto.getUntPrice(), itemDto.getQoh());
        if(itemDao.update(itemEntity)){
            return "Successfully Updated";
        } else{
            return "Fail";
        }

    }

    @Override
    public String deleteItem(String itemCode) throws Exception {
        if(itemDao.delete(itemCode)){
           return "Successfully Deleted";
        } else{
            return "Fail";
        }
    }

    @Override
    public ItemDto getItem(String itemCode) throws Exception {
        ItemEntity itemEntity = itemDao.get(itemCode);
        return new ItemDto(itemEntity.getItemCode(),
                itemEntity.getDescription(),
                itemEntity.getPack(),
                itemEntity.getUnitPrice(),
                itemEntity.getQoh());
    }

    @Override
    public List<ItemDto> getAll() throws Exception {
        ArrayList<ItemEntity> itemEntities = itemDao.getAll();
        
        List<ItemDto> itemDtos = new ArrayList<>();
        
        for (ItemEntity itemEntity : itemEntities) {
            itemDtos.add(new ItemDto(itemEntity.getItemCode(),
                itemEntity.getDescription(),
                itemEntity.getPack(),
                itemEntity.getUnitPrice(),
                itemEntity.getQoh()));
        }
        return itemDtos;
    }
    
}
