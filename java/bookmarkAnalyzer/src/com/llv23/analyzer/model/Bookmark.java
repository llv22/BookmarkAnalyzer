package com.llv23.analyzer.model;

import java.net.URL;

/**
 * Bookmark, use to store one bookmark (href, add_date - creationTime, icon, name)
 *
 * @author Orlando, Ding
 * @version 1.0
 * @since Dec 16th, 2015
 */
public class Bookmark {
    /**
     * this section is required for one bookmark
     */
    private URL href;
    private long createTime;
    private String icon;
    private String name;

    /**
     * this section is used to store which category belong to
     */
    private Category category;
}
