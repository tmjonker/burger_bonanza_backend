package com.tmjonker.burgerbonanza.controllers;

import com.tmjonker.burgerbonanza.exceptions.MenuItemNotFoundException;
import com.tmjonker.burgerbonanza.menu.MenuItem;
import com.tmjonker.burgerbonanza.menu.MenuItemRepository;
import org.springframework.data.util.Streamable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class MenuController {

    MenuItemRepository menuItemRepository;

    public MenuController(MenuItemRepository menuRepository) {

        this.menuItemRepository = menuRepository;
    }

    @GetMapping("/api/menu")
    public List<MenuItem> getAllMenuItems() {

        return Streamable.of(menuItemRepository.findAll()).toList();
    }

    @GetMapping("/api/menu/name/{name}")
    public MenuItem getMenuItemByName(@PathVariable String name) {

        return menuItemRepository.findByName(name).orElseThrow(() -> new MenuItemNotFoundException(name));
    }

    @GetMapping("/api/menu/id/{id}")
    public MenuItem getMenuItemByName(@PathVariable Integer id) {

        return menuItemRepository.findById(id).orElseThrow(() -> new MenuItemNotFoundException(id));
    }

    @GetMapping("/api/menu/category/{category}")
    public List<MenuItem> getMenuItemsByCategory(@PathVariable String category) {

        return menuItemRepository.findAllByCategory(category).orElseThrow(() -> new MenuItemNotFoundException(category));
    }

    @PostMapping(value = "/api/menu/{id}")
    public MenuItem addMenuItem(@RequestBody Map<String, Object> payload, Integer id) {

        MenuItem menuItem = new MenuItem(Integer.parseInt((String)payload.get("id")), (String) payload.get("category"), (String) payload.get("name"),
                (String) payload.get("description"), Double.parseDouble((String)payload.get("price")), (String) payload.get("imgPath"));

        return menuItemRepository.save(menuItem);
    }

    @DeleteMapping("/menu/{id}")
    public void deleteMenuItem(@PathVariable Integer id) {

        menuItemRepository.deleteById(id);
    }
}
