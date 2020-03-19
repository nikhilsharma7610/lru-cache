package com.nextag.lru;


public class LRPage {

    private String pageName;
    private long lastModified;

    public LRPage(String pageName){
        this.pageName = pageName;
        this.lastModified = System.currentTimeMillis();
    }

    public String getPageName(){
        return pageName;
    }

    public long getLastModified(){
        return lastModified;
    }

    public void setLastModified(long timeInMs){
        this.lastModified = timeInMs;
    }


    @Override
    public String toString(){
        return "Page : "+ getPageName() + " , Lastmodified : "+ getLastModified();
    }
    

}

