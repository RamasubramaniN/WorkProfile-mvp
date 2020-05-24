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
  
Add Records in the table
----------------------------
INSERT INTO user_profile (id, firstname, lastname, about) 
VALUES (9a0735fb-fb2b-41c3-9edb-0b1334fbe6b6, 'Ramasubramani', 'N','Passionate Programmer');

UPDATE user_profile SET publication = publication + [{'title':'Publication1','content':'Content1','year':'2015'},{'title':'Publication2','content':'Content2','year':'2020'}] WHERE id = 9a0735fb-fb2b-41c3-9edb-0b1334fbe6b6;

UPDATE user_profile SET education_history = education_history + [{'fromYear':'2006','toYear':'2010','obtainedGrade':'8.79','totalGrade':'10.0','location':'Coimbatore','institutionName':'PSG','degreeName':'Engineering'},{'fromYear':'2013','toYear':'2015','obtainedGrade':'8.63','totalGrade':'10.0','location':'Pilani','institutionName':'BITS','degreeName':'Masters'}] WHERE id = 9a0735fb-fb2b-41c3-9edb-0b1334fbe6b6;


UPDATE user_profile SET job_history = job_history + [{'fromYear':'2010','toYear':'2013','designation':'Trainee','companyName':'Subex','location':'Bangalore'},{'fromYear':'2013','toYear':'2017','designation':'Senior Staff','companyName':'Fiberlink','location':'Bangalore'},{'fromYear':'2017','toYear':'2020','designation':'Senior Software Engineer','companyName':'Intuit','location':'Bangalore'}] WHERE id = 9a0735fb-fb2b-41c3-9edb-0b1334fbe6b6;

UPDATE user_profile SET language_known = language_known + ['Tamil','English'] WHERE id = 9a0735fb-fb2b-41c3-9edb-0b1334fbe6b6;

