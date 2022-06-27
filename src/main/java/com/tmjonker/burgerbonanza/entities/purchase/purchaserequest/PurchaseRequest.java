package com.tmjonker.burgerbonanza.entities.purchase.purchaserequest;

import com.tmjonker.burgerbonanza.entities.menu.MenuItem;

import java.util.List;

public class PurchaseRequest {

    private List<MenuItem> menuItems;
    private double totalPrice;
    private String username;

    public PurchaseRequest(List<MenuItem> menuItems, double totalPrice, String username) {
        this.menuItems = menuItems;
        this.totalPrice = totalPrice;
        this.username = username;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
