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
public class BookmarkFolderNode extends GenericMarkNode{
    private long lastModificationTime;

    /**
     * parent folder contained current folder node
     */
    private BookmarkFolderNode parent;
    /**
     * children folder, which belong to current folder node
     */
    private List<BookmarkFolderNode> childs;

    /**
     * should be initialize childs List<Category> inside to avoid null pointer
     * @param _name
     * @param _creationTime
     * @param _lastModificationTime
     * @param _parent
     */
    public BookmarkFolderNode(String _name, long _creationTime, Optional<Long> _lastModificationTime, Optional<BookmarkFolderNode> _parent) {
        super(_name, _creationTime);
        if (_lastModificationTime.isPresent()) {
            this.lastModificationTime = _lastModificationTime.get();
        }
        else {
            this.lastModificationTime = _creationTime;
        }
        if(_parent.isPresent()) {
            this.parent = _parent.get();
        }
        this.childs = new ArrayList<BookmarkFolderNode>();
    }

    public long getLastModificationTime() {
        return lastModificationTime;
    }

    public String getName() {
        return name;
    }

    public BookmarkFolderNode getParent() {
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
    public final List<BookmarkFolderNode> getChilds() {
        return childs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookmarkFolderNode)) return false;

        BookmarkFolderNode bookmarkFolderNode = (BookmarkFolderNode) o;

        if (creationTime != bookmarkFolderNode.creationTime) return false;
        if (lastModificationTime != bookmarkFolderNode.lastModificationTime) return false;
        if (!name.equals(bookmarkFolderNode.name)) return false;
        //TODO: recursive to do equalization checkup for parent, is it costy?
        return parent.equals(bookmarkFolderNode.parent);
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
     * @param _bookmarkFolderNode
     * @return
     */
    public boolean addToChilds(BookmarkFolderNode _bookmarkFolderNode) {
        if (!this.childs.contains(_bookmarkFolderNode)) {
            return this.childs.add(_bookmarkFolderNode);
        }
        return false;
    }

    /**
     * remove category from childs list, if it exits;
     * otherwise, return false
     * @param _bookmarkFolderNode
     * @return
     */
    public boolean removeFromChilds(BookmarkFolderNode _bookmarkFolderNode) {
        if (this.childs.contains(_bookmarkFolderNode)) {
            return this.childs.remove(_bookmarkFolderNode);
        }
        return  false;
    }

}
