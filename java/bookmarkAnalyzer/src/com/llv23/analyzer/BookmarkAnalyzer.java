package com.llv23.analyzer;

import com.llv23.analyzer.controller.DuplicateAnalysisController;
import com.llv23.analyzer.model.BookmarkNode;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * This program is used to analyze exported bookmark of safaris and optimize bookmark organization.
 * 1) avoid duplication for both bookmark and category(bookmark folder)
 * 2) optimize logic of organization, such as
 *    1, similar topic merging
 *    2, minimal folder hierarchy
 *    3, favoriate bookbmark with most frequent visit, placed in top
 *  etc.
 * Now I focus on 1).
 *
 * @author Orlando, Ding
 * @version 1.0
 * @since Dec 16th, 2015
 */
public class BookmarkAnalyzer {

    static final Logger LOG = Logger.getLogger(BookmarkAnalyzer.class.getName());

    /**
     * args could accept two arguments:
     *  1) command name - analysis
     *  2) bookmark file location
     * @param args
     */
    public static void main(String[] args) {
        if (args == null || args.length != 2) {
            System.err.println("Program BookmarkAnalyzer is used to optimize your bookmark.");
            System.err.println("\tBookmarkAnalyzer <Command name> <Bookmark file location>");
            System.err.println("\tSupported command name: analysis, short for -a");
            System.exit(-1);
        }
        //see: check command option and file location
        String command = args[0].toLowerCase();
        if (!command.contentEquals("analysis") && !command.equalsIgnoreCase("-a")) {
            System.err.println("Invalid command name, please enter \"analysis\" or \"-a\"");
            System.exit(-1);
        }
        Path file = Paths.get(args[2]);
        if (!Files.exists(file)) {
            System.err.println("Invalid bookmark file, please select valid one or use chrome to export html bookmark file");
            System.exit(-1);
        }
        DuplicateAnalysisController proxy = new DuplicateAnalysisController(file.toFile());
        Map<String, List<BookmarkNode>> conflicts = proxy.analyzeBookmarks();
        for (Map.Entry<String, List<BookmarkNode>> pair : conflicts.entrySet()) {
            System.out.printf("Conflicted bookmark Node - %s, with node conflicts as follow\n", pair.getKey());
            int count = 1;
            for(BookmarkNode node : pair.getValue()) {
                System.out.printf("\tposition %d - %s\n", count++, node.getBookmarkFolderNode());
            }
        }
    }

}
