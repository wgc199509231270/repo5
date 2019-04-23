package com.OuSoft.system.service.Menu.impl;


import com.OuSoft.system.dao.Menu.MenuDao;
import com.OuSoft.system.entity.Menu;
import com.OuSoft.system.entity.TreeMenu;
import com.OuSoft.system.service.Menu.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuDao menu;
    @Override
    public List getMenu() {

        List<Menu> list = menu.getMenu();
        for(Menu m:list){
            System.out.println(m.toString());
        }
        List<TreeMenu> treeMenus = sortMenu(list);
        return treeMenus;
    }

    public List<TreeMenu> sortMenu(List<Menu> list){
        List list1 = new ArrayList<TreeMenu>();
        for(Menu menu : list){
            ArrayList<Menu> menus = new ArrayList<Menu>();
            TreeMenu treeMenu = new TreeMenu();
            String pid = menu.getPid();
            System.out.println(pid);
            if(pid.equals("0")){
                treeMenu.setMenu(menu);
                for(Menu menu1 :list){
                    if(menu1.getPid().equals(menu.getId())){
                        menus.add(menu1);
                    }
                }
                treeMenu.setMenu2(menus);
                list1.add(treeMenu);
            }
        }
        return  list1;
    }


}
