# Description
This project is about creating an in-memory store for recently played songs but the memory size is fixed.
And the store must have the capability to store the song in "song-user" pair.Wherein each song is linked with the user.
it should also be able to fetch recently played song based on user and eliminate the least recently used song when the storage becomes full.

# Dependencies
Here i have used Eclipse tool for writing java program
The version of Java used is "17.0.7+7"
windows=11

# Data Structure used for writing program
As mentioned in the description the size of the memory is fixed, so whenever we need to add new song into the storage the old(least recently used) song
should be removed and make place for the new one.And the song should be in terms of "song-user" pair.So the right data structure which matches this scenario is LRU cache i.e, "Least Recently Used".
Mainly LRU used with combined concept of "LinkedList" and "HashMap". Where Hashmap is a class which implements Map interface which
accepts data in "key-value" pair. LinkedList is a class which implements Dequeue interface. it removes LRU data from the node.

# Expected Output from the Program as given in the assignment
playlist initially----> S1,S2,S3.
when s4 song played----->S2,S3,S4.
when s2 song played----->S3,S4,S2.
when s1 song played----->S4,S2,S1.

# Program Explanation
1. Firstly I created 2 classes into a single package name HashMapCache and LeastRecentlyUsed.
2. HashMapCache along with its constructor for initializing the variables using "this" keyword.
3. In LeastRecentlyUsed class i have upcasted Linkedlist class for its interface Deque which takes key as parameter.
4. Upcasted Hashmap class for Map interface which takes "key-value" as parameter.
5. created 2 methods inside it for gettingElementFromCache() and PutElementToCache()
6. initialized capacity of cache to 3.
7. For gettingElementFromCache() which takes key as arguement, i will firstly check
   7.1----->If cache has that particular key or not using--map.containsKey(key) and if found then i remove that key from LinkedList and add it near head of LinkedList.
  7.2----> If key not found in cache then i return "song not exsist".
   
8. For PuttingElementToCache() which takes "key-value" as arguement, i will firstly check

   8.1------->If cache has that particular key or not using --map.containsKey(key) and if found then i remove that key from LinkedList using q.remove(current.key)  OR
   
   8.2-------->If the size of linkedlist= cache size(capacity) then the LRU key is removed from LinkedList and from HashMap using temp=q.removelast() and map.remove(temp).This operation
                is for making space for newItem.
   
   8.3-------->If the key is not found in cache and the capacity also not full then newItem is added into cache which is of the type HashMapCache.
                           HashMapCache newItem=new HashMapCache(key,value).and it is added next to head of LinkedList i.e, q.addFirst(newItem.key).Then added to cache(HashMap) also using
                       map.put(key,newItem).
9. Now all the required methods are called in main() class by using class reference and by passing the arguements.

    # Author
   Harshini BS
   Harshinibs04@gmail.com
   
    
   



      
      
          


