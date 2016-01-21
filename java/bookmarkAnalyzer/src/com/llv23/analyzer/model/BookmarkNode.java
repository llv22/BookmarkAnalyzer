package com.llv23.analyzer.model;

import java.net.URL;

/**
 * Bookmark, use to store one bookmark (href, add_date - creationTime, icon, name)
 *
 * @author Orlando, Ding
 * @version 1.0
 * @since Dec 16th, 2015
 */
public class BookmarkNode extends GenericMarkNode{
    /**
     * this section is required for one bookmark
     */
    private URL href;
    private String icon;

    /**
     * bookmark node for current bookmark node
     */
    private BookmarkFolderNode bookmarkFolderNode;

    /**
     * default ctor
     * @param name
     * @param createTime
     * @param href
     * @param icon
     * @param bookmarkFolderNode
     */
    public BookmarkNode(String name, long createTime, URL href, String icon, BookmarkFolderNode bookmarkFolderNode) {
        super(name, createTime);
        this.href = href;
        this.creationTime = createTime;
        this.icon = icon;
        this.name = name;
        this.bookmarkFolderNode = bookmarkFolderNode;
    }

    /**
     * return bookmark URL
     * @return
     */
    public URL getHref() {
        return href;
    }

    /**
     * return Icon
     * @return
     */
    public String getIcon() {
        return icon;
    }

    /**
     * return the current setting bookmark folder
     * @return
     */
    public BookmarkFolderNode getBookmarkFolderNode() {
        return bookmarkFolderNode;
    }
}
