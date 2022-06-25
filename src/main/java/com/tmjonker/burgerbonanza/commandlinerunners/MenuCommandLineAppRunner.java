package com.tmjonker.burgerbonanza.commandlinerunners;

import com.tmjonker.burgerbonanza.entities.menu.MenuItem;
import com.tmjonker.burgerbonanza.services.MenuService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MenuCommandLineAppRunner implements CommandLineRunner {

    MenuService menuService;

    public MenuCommandLineAppRunner(MenuService menuService) {

        this.menuService = menuService;
    }

    @Override
    public void run(String... args) throws Exception {

        MenuItem menuItem1 = new MenuItem(10, "Appetizer", "Boneless Wings", "Boneless Wings with your choice of Ranch" +
                "or Bleu Cheese.", 8.99, "https://dinnerthendessert.com/wp-content/uploads/2018/08/Boneless-Buffalo-Wings-3.jpg");
        MenuItem menuItem2 = new MenuItem(10, "Appetizer", "Boneless Wings", "Boneless Wings with your choice of Ranch" +
                "or Bleu Cheese.", 8.99, "https://dinnerthendessert.com/wp-content/uploads/2018/08/Boneless-Buffalo-Wings-3.jpg");
    }
}
