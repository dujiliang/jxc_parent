package com.jxc.common.entity;

import java.util.ArrayList;
import java.util.List;

public class AreaNode extends Area{

    private List<AreaNode> children = new ArrayList<AreaNode>();

    public List<AreaNode> getChildren() {
        return children;
    }

    public void setChildren(List<AreaNode> children) {
        this.children = children;
    }
}
