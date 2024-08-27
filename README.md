Advantages of PreparedStatement
 =============================
1.  Performance is very high compared to Statement approach becoz  query will be 
compiled only once.
 2.  Since we don't send the query multiple times b/w java application and database 
traffic will be reduced.
 3.  inputs to the query need not be supplied at the begining dynamically we can 
supply the inputs.
 4.  inputs to the query can be supplied just like java style, no need to perform 
formatting as per the DB specification.
 5.  Best suitable for inserting Date values.
 6.  Best sutiable for insertion of BLOB's and CLOB's (image and pdf files).
 7.  It prevents SQLInjection Attack.

 Note: 
Simple Statement object can be used for static queries, where as Preparedstatement 
object can be used for static queries 
and dynamic queries also
