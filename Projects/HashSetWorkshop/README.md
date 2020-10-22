# Set (Abstract data structure)

Sets are a type of abstract data type that allows you to store a list of **non-repeated (unique) values**. Their name derives from the mathematical concept of finite sets.

You can think about sets as a room full of people you know. They can move around the room, changing order, without altering the set of people in that room. Plus, there are no duplicate people (no twins, sorry!).

### Characteristics of Sets:

- Unordered
- Unindexed
- Does not contain duplicate values

Sets have four basic operations:

Name       | Functionality
-----------|----------
 add(e)    | Adds *e* to the set
 remove(e) | Removes *e* from the set
 size()    | Returns the size of the set
 contains()| Returns whether the set contains *e*

As we will soon see, hash tables and sets are very related. In fact, Sets in Java are implemented using Map.

# Map (Hash Tables)

Hash tables are implemented by using an array of fixed size. To insert a key/value pair, the key is first ***hashed***. Since hashes are just large integers, the hash is then taken modulo the size of the array, yielding an index (index = hash % size). The key/value pair is then inserted into a *bucket* at that index.

![picture](images/map-insertion.gif)

***Buckets*** are required because hash collisions are inevitable; so instead of each index storing a single key/value pair, it stores a bucket of pairs. In the most basic implementation, buckets are implemented by using linked lists.

Notice that the size of the bucket array doesn't limit the number of key/value pairs that can be stored in the hash table. In the above animation, the bucket array is of length 6, but 8 key/value pairs are inserted. This ratio of the number of pairs to the number of buckets is called the ***load factor***.

The load factor is equal to the number of pairs divided by the number of buckets. If the load factor goes beyond a predefined *threshold*, the whole array of buckets is resized, recalculating the hash for each value.

As the load factor increases, collisions are more likely to occur. As more and more collisions occur, performance degrades. In the absolute worst case, a hash table with only 1 bucket, the hash table behaves like a linked list with O(n) search, insertion, and deletion times.

![picture](images/hash-table-linked-list.png)

### Asymptotic Complexity

Operation | Average | Worst
----------|----------|---------
Searching | O(1)     | O(n)
Insertion | O(1)     | O(n)
Deletetion| O(1)     | O(n)

#### The task (this workshop is optional)

1. Write unit tests with 90%+ coverage on the given implementation.
3. Name your tests and commits properly.

##### Tasks for exercise (optional):

- [Jewels and Stones](https://leetcode.com/problems/jewels-and-stones/)
- [Set Mismatch](https://leetcode.com/problems/set-mismatch/)
- [Unique Number of Occurrences](https://leetcode.com/problems/unique-number-of-occurrences/)

##### Additional tasks (optional):

- [Isomorphic Strings](https://leetcode.com/problems/isomorphic-strings/ )
- [Find the Difference](https://leetcode.com/problems/find-the-difference/)
- [Happy Number](https://leetcode.com/problems/happy-number/)
- [Uncommon Words](https://leetcode.com/problems/uncommon-words-from-two-sentences/)


###### Java HashSet class explained
 - [Java HashSet](https://howtodoinjava.com/java/collections/java-hashset/)
