package com.llv23.analyzer.controller;

import com.llv23.analyzer.model.BookmarkFolderNode;
import com.llv23.analyzer.model.BookmarkNode;
import javafx.util.Pair;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * Controller of analysis for bookmark duplication
 *
 * @author Orlando, Ding
 * @version 1.0
 * @since Dec 16th, 2015
 */
public class DuplicateAnalysisController {

    /**
     * root folders for safari bookmark
     */
    private List<BookmarkFolderNode> root;

    /**
     * default ctor to generate bookmark tree
     * @param bookmarksFile
     */
    public DuplicateAnalysisController(File bookmarksFile) {
        this.root = constructBookmarksTree(bookmarksFile);
    }

    /**
     * generate the whole bookmarks tree with bookmarks and relevant bookmark folders
     * @param bookmarksFile
     * @return
     */
    private List<BookmarkFolderNode> constructBookmarksTree(File bookmarksFile) {
        throw new NotImplementedException();
    }

    /**
     * do bookmark analyze to export bookmarkNodes
     * @return
     */
    public Map<String, List<BookmarkNode>> analyzeBookmarks() {
        throw new NotImplementedException();
    }

}
