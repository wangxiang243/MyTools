package com.tree;

import com.tree.Menu;
import com.tree.MenuUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack on 14-4-3.
 */
public class TestMenuUtils {

    MenuUtils menuUtils = new MenuUtils();

    @Test
    public void testgetRootIdById(){
        Menu menu = menuUtils.getRootIdById(4);
        System.out.println(menu.getId()+","+menu.getPid()+","+menu.getName());
    }

    @Test
    public void testgetAllChildrenById(){
        List<Menu> allChildrenList = new ArrayList<Menu>();
        menuUtils.getAllChildrenById(allChildrenList,2);
        System.out.println(allChildrenList);
    }

    @Test
    public void testgetAllPid(){
        List<Menu> allParentMenuList = new ArrayList<Menu>();
        menuUtils.getAllPid(allParentMenuList,4);
        System.out.println(allParentMenuList);
    }

    @Test
    public void testGetTreeDirectory(){
        List<Menu> treeList = menuUtils.getTreeDirectory(menuUtils.initMenu(),0);
        System.out.println(treeList);
    }

    @Test
    public void testSyso(){
        System.out.println("abc");
    }
}
