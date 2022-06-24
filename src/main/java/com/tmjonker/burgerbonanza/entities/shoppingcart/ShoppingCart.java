package com.tmjonker.burgerbonanza.entities.shoppingcart;

import com.tmjonker.burgerbonanza.entities.menu.MenuItem;

import javax.persistence.*;
import java.util.List;

@Entity
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "num_items", nullable = false)
    private int numItems;

    @ManyToMany
    @JoinTable(
            name = "cart_items",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "menu_id")
    )
    private List<MenuItem> menuItems;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
