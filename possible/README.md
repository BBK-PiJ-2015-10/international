
Notes on Solution

 By reading the statement "Oldest is defined as:
 The least used item in the cache" , I thought the oldest
 was the least accessed item. However, based on conversation
 during interview, it seems that it is meant to be the
 item that has been not been updated or get the longest
 amount of time. Hence, my solution on the oldest uses this 
 assumption.



Problem
  
 To execute Java, please define "static void main" on a class
 named Solution.

 If you need more classes, simply define them inline.


 put(key, value)
 get(key)

 Constraints:
 Number of items is limited to N

 when you reach Size = N
 put(key, value) ---> remove the oldest item in the cache to make room

 Oldest is defined as:
 The least used item in the cache.

 Cache:                            Youngest Item in the cache      Oldest
 put("key1", "value1") ....        key1                            key1
 put("key2", "value2")             key2                            key1
 get("key1")                       key1                            key2



 old ---> key1 key2 key3 key4 <--- y


 get(key3)
 oldest ---> key1 key2 key4 key3 <--- youngest

 get(key1)
 oldest ---> key2 key4 key3 key1 <--- youngest

 N = 4

 put(key5, value5)
 oldest ---> key2 key4 key3 key1 <--- youngest

 remove key2 to make room
 oldest ---> key4 key3 key1 key5 <--- youngest

 prasad@possiblefinance.com




