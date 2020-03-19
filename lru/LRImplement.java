package com.nextag.lru;

import java.util.Iterator;
import java.util.PriorityQueue;


public class LRImplement {

    private static PriorityQueue<LRPage> lrQ = new PriorityQueue<LRPage>(3, new LRComparator());
    static LRImplement lrImp;
    
    public static void main(String args[]){

        String[] pages = {"1","2","3","1","2","4","2","5"};
        lrImp = new LRImplement();
        
        System.out.println("Initial Q : ");
        lrImp.showQ();

        for(int i=0;i<pages.length ;i++){

        	System.out.println();
        	lrImp.addToQueue(pages[i]) ;
            try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
            lrImp.showQ();

        }


    }


    public void addToQueue(String page){


        System.out.println("addToQueue : Item to add : "+ page);

        LRPage itemToAdd = new LRPage(page);
        if(lrImp.containsItem(itemToAdd)) {
            System.out.println("Element already in queue, updating last modified");
        }
        else{

            if(lrQ.size() < 3){
                lrQ.add(itemToAdd);
            }
            else{
            	
            	System.out.println("Page Fault, removing LRU page....");
            	
                LRPage lrHead = lrQ.poll();
                if(lrHead==null){
                    System.out.println("Element cannot be polled");
                }
                else{
                    lrQ.add(itemToAdd);
                }
            }


        }



    }



    public void showQ(){
        Iterator iterator = lrQ.iterator();
        while(iterator.hasNext()){
            LRPage page = (LRPage) iterator.next();
            System.out.println(page);
        }
        
        System.out.println();
    }
    
    public boolean containsItem(LRPage pageItem){
    	for(LRPage page : lrQ){
    		if(page.getPageName()==pageItem.getPageName()){
    			//page.setLastModified(System.currentTimeMillis());
    			/* Above will simply remove element from front & not based on LRU
    			 */
    			System.out.println("Removing element, updating last modified, inserting again....");
    			lrQ.remove(page);
    			lrQ.add(new LRPage(page.getPageName()));
    			return true;
    		}
    	}
    	return false;
    }


}
