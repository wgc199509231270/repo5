package com.OuSoft.system.controller.Menu;

import com.OuSoft.system.entity.Menu;
import com.OuSoft.system.entity.TreeMenu;
import com.OuSoft.system.service.Menu.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class MenuController {
    @Autowired
    MenuService menuService;
    @RequestMapping("/getMenu")
    public List getMenu(){
        List<TreeMenu> menu = menuService.getMenu();

        return menu;
    }

}
