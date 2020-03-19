package com.nextag.lru;

import java.util.Comparator;


public class LRComparator implements Comparator<LRPage> {

    public int compare(LRPage page1, LRPage page2){

        if(page1.getLastModified() > page2.getLastModified())
            return 1;
        else if(page1.getLastModified() < page2.getLastModified())
            return -1;
        
        return 0;

    }
}

