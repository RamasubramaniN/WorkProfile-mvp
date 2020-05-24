Setup Cassandra in Local
----------------------------------
Start Cassandra server : ./cassandra

Start Cassandra Client : ./cqlsh

BANXXXXXXe:bin ram$ ./cqlsh

Connected to Test Cluster at 127.0.0.1:9042.

[cqlsh 5.0.1 | Cassandra 3.0.20 | CQL spec 3.4.0 | Native protocol v4]

Create Keyspace
-----------------
cqlsh> CREATE KEYSPACE linkedinkeyspace WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 3};

cqlsh> USE linkedinkeyspace;

Create tables
---------------------------
CREATE TABLE user_profile
( 
id uuid, 
firstname text, 
lastname text,
dob timestamp, 
email text,
about text,
publication list<frozen<map<text, text>>>,
education_history list<frozen<map<text, text>>>,
job_history list<frozen<map<text, text>>>,
language_known list<text>,
PRIMARY KEY(id) 
);
