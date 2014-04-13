package com.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack on 14-4-3.
 */
public class Menu {

    private Integer id;
    private Integer pid;
    private String name;
    private Boolean isLeaf;
    private List<Menu> childrenList = new ArrayList<Menu>();

    public Menu(){}

    public Menu(Integer id, Integer pid, String name, Boolean isLeaf) {
        super();
        this.id = id;
        this.pid = pid;
        this.name = name;
        this.isLeaf = isLeaf;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getPid() {
        return pid;
    }
    public void setPid(Integer pid) {
        this.pid = pid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Boolean getIsLeaf() {
        return isLeaf;
    }
    public void setIsLeaf(Boolean isLeaf) {
        this.isLeaf = isLeaf;
    }
    public List<Menu> getChildrenList() {
        return childrenList;
    }
    public void setChildrenList(List<Menu> childrenList) {
        this.childrenList = childrenList;
    }

    @Override
    public String toString() {
        return "[id=" + id + ", pid=" + pid + ", name=" + name
                + ", isLeaf=" + isLeaf + ", childrenList=" + childrenList + "]";
    }

}
