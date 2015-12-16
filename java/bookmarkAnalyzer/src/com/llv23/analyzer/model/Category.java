package com.llv23.analyzer.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Category is used to store information of folder in safari
 *
 * @author Orlando, Ding
 * @version 1.0
 * @since Dec 16th, 2015
 */
public class Category {
    /**
     * this section is required for one category itself
     */
    private long creationTime;
    private long lastModificationTime;
    private String name;

    /**
     * this section is required for category organization
     */
    private Category parent;
    private List<Category> childs;

    /**
     * should be initialize childs List<Category> inside to avoid null pointer
     * @param _name
     * @param _creationTime
     * @param _lastModificationTime
     * @param _parent
     */
    public Category(String _name, long _creationTime, Optional<Long> _lastModificationTime, Optional<Category> _parent) {
        this.name = _name;
        this.creationTime = _creationTime;
        if (_lastModificationTime.isPresent()) {
            this.lastModificationTime = _lastModificationTime.get();
        }
        else {
            this.lastModificationTime = this.creationTime;
        }
        if(_parent.isPresent()) {
            this.parent = _parent.get();
        }
        this.childs = new ArrayList<Category>();
    }

    public long getCreationTime() {
        return creationTime;
    }

    public long getLastModificationTime() {
        return lastModificationTime;
    }

    public String getName() {
        return name;
    }

    public Category getParent() {
        return parent;
    }

    /**
     * root node of bookmark don't have parent
     * @return
     */
    public boolean isRootCategory() {
        return this.parent == null;
    }

    /**
     * don't allow change list outside of class
     * @return
     */
    public final List<Category> getChilds() {
        return childs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;

        Category category = (Category) o;

        if (creationTime != category.creationTime) return false;
        if (lastModificationTime != category.lastModificationTime) return false;
        if (!name.equals(category.name)) return false;
        //TODO: recursive to do equalization checkup for parent, is it costy?
        return parent.equals(category.parent);
    }

    @Override
    public int hashCode() {
        int result = (int) (creationTime ^ (creationTime >>> 32));
        result = 31 * result + (int) (lastModificationTime ^ (lastModificationTime >>> 32));
        result = 31 * result + name.hashCode();
        result = 31 * result + parent.hashCode();
        return result;
    }

    /**
     * check if category already exists in childs list, if not, add and return true;
     * otherwise, return false
     * @param _category
     * @return
     */
    public boolean addToChilds(Category _category) {
        if (!this.childs.contains(_category)) {
            return this.childs.add(_category);
        }
        return false;
    }

    /**
     * remove category from childs list, if it exits;
     * otherwise, return false
     * @param _category
     * @return
     */
    public boolean removeFromChilds(Category _category) {
        if (this.childs.contains(_category)) {
            return this.childs.remove(_category);
        }
        return  false;
    }

}
