package com.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jack on 14-4-3.
 */
public class MenuUtils {

    private static final Integer ROOT_ID = 0;

    /**
     * 初始化菜单数据
     * @return
     */
    public List<Menu> initMenu(){
        Menu m1 = new Menu(1,0,"一级菜单",false);
        Menu m2 = new Menu(2,1,"二级菜单",false);
        Menu m3 = new Menu(3,2,"三级菜单",true);
        Menu m4 = new Menu(4,2,"三级菜单",true);
        List<Menu> list = Arrays.asList(m1, m2, m3, m4);
        return list;
    }

    /**
     * 根据菜单编码获取菜单对象
     * @param id
     * @return
     */
    public Menu getMenuById(Integer id){
        List<Menu> menuList = initMenu();
        for(Menu m : menuList){
            if(m.getId() == id){
                return m;
            }
        }
        return null;
    }

    /**
     * 根据id查找根菜单
     * @param id
     * @return
     */
    public Menu getRootIdById(Integer id){
        List<Menu> menuList = initMenu();
        Menu menu = getMenuById(id);
        if(menu.getPid() != ROOT_ID){
            menu = getRootIdById(menu.getPid());
        }
        return menu;
    }

    /**
     * 根据当前节点查找子菜单
     * @param id
     * @return
     */
    public List<Menu> getChildrenList(Integer id){
        List<Menu> childrenList = new ArrayList<Menu>();
        List<Menu> menuList = initMenu();
        for(Menu m : menuList){
            if (m.getPid()==id){
                childrenList.add(m);
            }
        }
        return childrenList;
    }

    /**
     * 根据当前id查找所有子菜单
     * @param id
     * @return
     */
    public void getAllChildrenById(List<Menu> allChildrenList ,Integer id){
        List<Menu> childrenList = getChildrenList(id);
        for(Menu m : childrenList){
            allChildrenList.add(m);
            getAllChildrenById(allChildrenList,m.getId());
        }
    }

    /**
     * 根据当前id获取所有父id
     * @param id
     */
    public void getAllPid(List<Menu> allParentMenuList,Integer id){
        Menu menu = this.getMenuById(id);
        Menu pmenu = this.getMenuById(menu.getPid());
        if(pmenu!=null){
            allParentMenuList.add(pmenu);
            getAllPid(allParentMenuList,menu.getPid());
        }
    }

    /**
     * 获取整个菜单的目录树结构
     * @param allMenuList
     * @param pid
     * @return
     */
    public List<Menu> getTreeDirectory(List<Menu> allMenuList,Integer pid){
        List<Menu> childMenuList = new ArrayList<Menu>();
        for(Menu m:allMenuList){
            if(m.getPid()==pid){
                childMenuList.add(m);
                List<Menu> cchildMenuList = getTreeDirectory(allMenuList, m.getId());
                m.setChildrenList(cchildMenuList);
                m.setIsLeaf(cchildMenuList==null || cchildMenuList.size()==0);
            }
        }
        return childMenuList;
    }
}
