/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.layered.entity;

/**
 *
 * @author anjanathrishakya
 */
public class ItemEntity {
    private String itemCode;
    private String description;
    private String pack;
    private Double unitPrice;
    private Integer qoh;

    public ItemEntity() {
    }

    public ItemEntity(String itemCode, String description, String pack, Double unitPrice, Integer qoh) {
        this.itemCode = itemCode;
        this.description = description;
        this.pack = pack;
        this.unitPrice = unitPrice;
        this.qoh = qoh;
    }

    /**
     * @return the itemCode
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * @param itemCode the itemCode to set
     */
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the pack
     */
    public String getPack() {
        return pack;
    }

    /**
     * @param pack the pack to set
     */
    public void setPack(String pack) {
        this.pack = pack;
    }

    /**
     * @return the unitPrice
     */
    public Double getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice the unitPrice to set
     */
    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * @return the qoh
     */
    public Integer getQoh() {
        return qoh;
    }

    /**
     * @param qoh the qoh to set
     */
    public void setQoh(Integer qoh) {
        this.qoh = qoh;
    }

    @Override
    public String toString() {
        return "ItemEntity{" + "itemCode=" + itemCode + ", description=" + description + ", pack=" + pack + ", unitPrice=" + unitPrice + ", qoh=" + qoh + '}';
    }
    
    
}
