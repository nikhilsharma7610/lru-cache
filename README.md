# lru-cache
LRU Cache implementation


Here is my implementation for LRU. I have used PriorityQueue, which basically works as FIFO and not threadsafe. Used Comparator based on the page time creation and based on the performs the ordering of the pages for the least recently used time.
Pages for consideration : 2, 1, 0, 2, 8, 2, 4

Page added into cache is : 2
Page added into cache is : 1
Page added into cache is : 0
Page: 2 already exisit in cache. Last accessed time updated
Page Fault, PAGE: 1, Replaced with PAGE: 8
Page added into cache is : 8
Page: 2 already exisit in cache. Last accessed time updated
Page Fault, PAGE: 0, Replaced with PAGE: 4
Page added into cache is : 4

OUTPUT

LRUCache Pages
-------------
PageName: 8, PageCreationTime: 1365957019974
PageName: 2, PageCreationTime: 1365957020074
PageName: 4, PageCreationTime: 1365957020174
