package com.tmjonker.burgerbonanza.controllers;

import com.tmjonker.burgerbonanza.entities.menu.MenuItem;
import com.tmjonker.burgerbonanza.services.MenuService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MenuController {

    MenuService menuService;

    public MenuController(MenuService menuService) {

        this.menuService = menuService;
    }

    @GetMapping("/api/menu")
    public List<MenuItem> getAllMenuItems() {

        return menuService.getAllMenuItems();
    }

    @GetMapping("/api/menu/name/{name}")
    public MenuItem getMenuItemByName(@PathVariable String name) {

        return menuService.getMenuItemByName(name);
    }

    @GetMapping("/api/menu/id/{id}")
    public MenuItem getMenuItemById(@PathVariable Integer id) {

        return menuService.getMenuItemById(id);
    }

    @GetMapping("/api/menu/category/{category}")
    public List<MenuItem> getMenuItemsByCategory(@PathVariable String category) {

        return menuService.getMenuItemsByCategory(category);
    }

    @PostMapping(value = "/api/menu/{id}")
    public MenuItem addMenuItem(@RequestBody MenuItem menuItem) {

        return menuService.addMenuItem(menuItem);
    }

    @DeleteMapping("/menu/{id}")
    public void deleteMenuItem(@PathVariable Integer id) {

        menuService.deleteMenuItem(id);
    }
}
