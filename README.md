This Application has 2 layers.
1. Node JS + Apollo Server Middleware
2. REST + Spring Boot + Cassandra Backend.


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

1. User Profile
-----------------
CREATE TABLE user_profile
( 
id uuid, 
firstname text, 
lastname text,
email text,
about text,
PRIMARY KEY(id) 
);


  
2. Find Publication by email
------------------------------
CREATE TABLE publication
( 
id int,
email text,
title text,
content text,
year int,
PRIMARY KEY(email, id) 
);



3. Find Job History by email
-----------------------------
CREATE TABLE job_history
(
id int,
email text,
from_year int,
to_year int,
designation text,
employer_name text,
location text,
PRIMARY KEY(email, id)
);



4. Find Education by email
---------------------------
CREATE table education
(
id int,
email text,
from_year int,
to_year int,
total_grade float,
obtained_grade float,
location text,
institution_name text,
degree_name text,
PRIMARY KEY(email, id)
);






Add Records in the table
----------------------------
INSERT INTO user_profile (id, firstname, lastname, about, email) 
VALUES (9a0735fb-fb2b-41c3-9edb-0b1334fbe6b6, 'Ramasubramani', 'N','Passionate Programmer', 'noname@noname.com');


INSERT INTO publication(id, title, year, content, email) VALUES(1, 'Publication1', 2015, 'Content1', 'noname@noname.com');


INSERT INTO publication(id, title, year, content, email) VALUES(2, 'Publication2', 2020, 'Content2', 'noname@noname.com');


INSERT INTO education(id, email, from_year, to_year, total_grade, obtained_grade, location, institution_name, degree_name)
VALUES(1, 'noname@noname.com', 2006, 2010, 10.0, 8.79, 'Coimbatore', 'PSG', 'Engineering');


INSERT INTO education(id, email, from_year, to_year, total_grade, obtained_grade, location, institution_name, degree_name)
VALUES(2, 'noname@noname.com', 2013, 2015, 10.0, 8.63, 'Pilani', 'BITS', 'Masters');


INSERT INTO job_history (id, email, from_year, to_year, location, employer_name, designation)
VALUES(1, 'noname@noname.com', 2010, 2013, 'Bangalore', 'Subex India Private Limited', 'Software Engineer');


INSERT INTO job_history (id, email, from_year, to_year, location, employer_name, designation)
VALUES(2, 'noname@noname.com', 2013, 2017, 'Bangalore', 'Fiberlink India Private Limited', 'Staff Software Engineer');


INSERT INTO job_history (id, email, from_year, to_year, location, employer_name, designation)
VALUES(3, 'noname@noname.com', 2017, 2020, 'Bangalore', 'Intuit India Private Limited', 'Senior Software Engineer');


If we maintain other details in user_profile table
---------------------------------------------------------
UPDATE user_profile SET publication = publication + [{'title':'Publication1','content':'Content1','year':'2015'},{'title':'Publication2','content':'Content2','year':'2020'}] WHERE id = 9a0735fb-fb2b-41c3-9edb-0b1334fbe6b6;

UPDATE user_profile SET education_history = education_history + [{'fromYear':'2006','toYear':'2010','obtainedGrade':'8.79','totalGrade':'10.0','location':'Coimbatore','institutionName':'PSG','degreeName':'Engineering'},{'fromYear':'2013','toYear':'2015','obtainedGrade':'8.63','totalGrade':'10.0','location':'Pilani','institutionName':'BITS','degreeName':'Masters'}] WHERE id = 9a0735fb-fb2b-41c3-9edb-0b1334fbe6b6;


UPDATE user_profile SET job_history = job_history + [{'fromYear':'2010','toYear':'2013','designation':'Trainee','companyName':'Subex','location':'Bangalore'},{'fromYear':'2013','toYear':'2017','designation':'Senior Staff','companyName':'Fiberlink','location':'Bangalore'},{'fromYear':'2017','toYear':'2020','designation':'Senior Software Engineer','companyName':'Intuit','location':'Bangalore'}] WHERE id = 9a0735fb-fb2b-41c3-9edb-0b1334fbe6b6;

UPDATE user_profile SET language_known = language_known + ['Tamil','English'] WHERE id = 9a0735fb-fb2b-41c3-9edb-0b1334fbe6b6;

UPDATE user_profile SET dob = '2000-01-01' WHERE id = 9a0735fb-fb2b-41c3-9edb-0b1334fbe6b6;
