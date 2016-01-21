package com.llv23.analyzer.model;

/**
 * Created by I058959 on 1/21/2016.
 */
public class GenericMarkNode{
    /**
     * node name
     */
     String name;

    /**
     * creation time of mark node
     */
    protected long creationTime;

    /**
     * default ctor for name and creation time of mark node
     * @param name
     * @param creationTime
     */
    public GenericMarkNode(String name, long creationTime) {
        this.name = name;
        this.creationTime = creationTime;
    }

    /**
     * getName
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * getCreationTime
     * @return
     */
    public long getCreationTime() {
        return creationTime;
    }
}
