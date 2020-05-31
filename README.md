Application Layers
-------------------
Check this link https://www.howtographql.com/basics/1-graphql-is-the-better-rest/ to understand the importance of GraphQL.

This Application has 3 sub projects.

1. React + Apollo Client - Front End - Yet to build.

2. Node JS + Apollo Server - Middleware - https://github.com/RamasubramaniN/Linkedin-mvp/tree/master/linkedin-apolloserver-middleware

3. REST + Spring Boot + Cassandra - Backend - https://github.com/RamasubramaniN/Linkedin-mvp/tree/master/linkedin-rest-backend

Architecture
--------------
We build separate versions of APIs for Mobile & Web. This is because we may not require complete response for Mobile (bandwidth constraint) but Web will require all data.

Here, Linkedin app can have multple versions.

1. Mobile Version - Displays firstname, lastname, email & jobHistory.

2. Web version - Displays firstname, lastname, email jobHistory, educationHistory & publication history.

3. Mobile app lite - Displays firstname, lastname & email, current job.

We will be able to use same API for both versions of the app with GraphQL.

1. Apollo Client in React UI makes GraphQL call to middleware.

2. Apollo Server middleware acts like orchestrator layer. It understands GraphQL request & route the request to appropriate backend microservice. This is done using Apollo Server RestDatasource module.

3. Spring boot backend app provides REST response. Apollo server converts this response to GraphQL response & send it back to front end.

2.Node JS + Apollo Server - Middleware
----------------------------------------

This layer is a NodeJs application & this is orchestrator layer. Apollo Server serves GraphQL requests. Node JS cannot scale, So, this layer uses REST layer as datasource, This layer does the routing to appropriate microservices based on GraphQL entity & mapping the responses from REST to GraphQL. With this technique, you can convert your legacy REST APIs to provide GraphQL capability. 

Steps to setup
---------------
1) Install Node in local.

2) Install apollo-server, graphql, Rest Datasource libraries using following commands.

```
   npm install apollo-server

   npm install apollo-datasource-rest

   npm install graphql-import
```

3) Start the application by following command.

```
   npm start
```

4) Go to Chrome GraphQL playground. Lets execute query for mobile version.

Request
--------

```query{
  user (id:"9a0735fb-fb2b-41c3-9edb-0b1334fbe6b6"){
    firstname,
    lastname,
    email,
    jobHistory {
      designation
      employerName
    }
  }
}
```

Response
---------

```
{
  "data": {
    "user": {
      "firstname": "Ramasubramani",
      "lastname": "N",
      "email": "noname@noname.com",
      "jobHistory": [
        {
          "designation": "Software Engineer",
          "employerName": "Subex India Private Limited"
        },
        {
          "designation": "Staff Software Engineer",
          "employerName": "Fiberlink India Private Limited"
        },
        {
          "designation": "Senior Software Engineer",
          "employerName": "Intuit India Private Limited"
        }
      ]
    }
  }
}
```

One more lighter version of the request. 

Request
----------

```
query{
  user (id:"9a0735fb-fb2b-41c3-9edb-0b1334fbe6b6"){
    firstname,
    lastname,
    email,
    jobHistory {
      designation
      employerName
    }
    educationHistory{
      institutionName
    }
    publicationHistory{
      title
    }
  }
}
```

Response
----------

```
{
  "data": {
    "user": {
      "firstname": "Ramasubramani",
      "lastname": "N",
      "email": "noname@noname.com",
      "jobHistory": [
        {
          "designation": "Software Engineer",
          "employerName": "Subex India Private Limited"
        },
        {
          "designation": "Staff Software Engineer",
          "employerName": "Fiberlink India Private Limited"
        },
        {
          "designation": "Senior Software Engineer",
          "employerName": "Intuit India Private Limited"
        }
      ],
      "educationHistory": [
        {
          "institutionName": "PSG"
        },
        {
          "institutionName": "BITS"
        }
      ],
      "publicationHistory": [
        {
          "title": "Publication1"
        },
        {
          "title": "Publication2"
        }
      ]
    }
  }
}
```

For Web version, Client will request all the fields. Sample Response below.
```
{
    "userId": "9a0735fb-fb2b-41c3-9edb-0b1334fbe6b6",
    "firstname": "Ramasubramani",
    "lastname": "N",
    "email": "noname@noname.com",
    "about": "Passionate Programmer",
    "jobHistory": [
        {
            "fromYear": 2010,
            "toYear": 2013,
            "designation": "Software Engineer",
            "employerName": "Subex India Private Limited",
            "location": "Bangalore"
        },
        {
            "fromYear": 2013,
            "toYear": 2017,
            "designation": "Staff Software Engineer",
            "employerName": "Fiberlink India Private Limited",
            "location": "Bangalore"
        },
        {
            "fromYear": 2017,
            "toYear": 2020,
            "designation": "Senior Software Engineer",
            "employerName": "Intuit India Private Limited",
            "location": "Bangalore"
        }
    ],
    "educationHistory": [
        {
            "fromYear": 2006,
            "toYear": 2010,
            "obtainedGrade": 8.789999961853027,
            "totalGrade": 10.0,
            "location": "Coimbatore",
            "institutionName": "PSG",
            "degreeName": "Engineering"
        },
        {
            "fromYear": 2013,
            "toYear": 2015,
            "obtainedGrade": 8.630000114440918,
            "totalGrade": 10.0,
            "location": "Pilani",
            "institutionName": "BITS",
            "degreeName": "Masters"
        }
    ],
    "publicationHistory": [
        {
            "title": "Publication1",
            "content": "Content1",
            "year": 2015
        },
        {
            "title": "Publication2",
            "content": "Content2",
            "year": 2020
        }
    ]
}
```



3.REST + Spring Boot + Cassandra - Backend
-------------------------------------------

This layer is built using Spring Boot, REST & Cassandra. This layer acts as datasource for middleware.

Following REST API request is made from middleware

API Request
-------------

http://localhost:8080/linkedin/users/9a0735fb-fb2b-41c3-9edb-0b1334fbe6b6


API Response
-------------

```
{
    "userId": "9a0735fb-fb2b-41c3-9edb-0b1334fbe6b6",
    "firstname": "Ramasubramani",
    "lastname": "N",
    "email": "noname@noname.com",
    "about": "Passionate Programmer",
    "jobHistory": [
        {
            "fromYear": 2010,
            "toYear": 2013,
            "designation": "Software Engineer",
            "employerName": "Subex India Private Limited",
            "location": "Bangalore"
        },
        {
            "fromYear": 2013,
            "toYear": 2017,
            "designation": "Staff Software Engineer",
            "employerName": "Fiberlink India Private Limited",
            "location": "Bangalore"
        },
        {
            "fromYear": 2017,
            "toYear": 2020,
            "designation": "Senior Software Engineer",
            "employerName": "Intuit India Private Limited",
            "location": "Bangalore"
        }
    ],
    "educationHistory": [
        {
            "fromYear": 2006,
            "toYear": 2010,
            "obtainedGrade": 8.789999961853027,
            "totalGrade": 10.0,
            "location": "Coimbatore",
            "institutionName": "PSG",
            "degreeName": "Engineering"
        },
        {
            "fromYear": 2013,
            "toYear": 2015,
            "obtainedGrade": 8.630000114440918,
            "totalGrade": 10.0,
            "location": "Pilani",
            "institutionName": "BITS",
            "degreeName": "Masters"
        }
    ],
    "publicationHistory": [
        {
            "title": "Publication1",
            "content": "Content1",
            "year": 2015
        },
        {
            "title": "Publication2",
            "content": "Content2",
            "year": 2020
        }
    ]
}
```

Setup Cassandra in Local
----------------------------------
Download Cassandra from official server. Unzip & go to bin folder.

```
BANXXXXXXe:bin ram$ 

Start Cassandra server : ./cassandra

Start Cassandra Client : ./cqlsh
```

Connected to Test Cluster at 127.0.0.1:9042.

[cqlsh 5.0.1 | Cassandra 3.0.20 | CQL spec 3.4.0 | Native protocol v4]


Create Keyspace
-----------------
Create Keyspaces for our tables.

```
cqlsh> CREATE KEYSPACE linkedinkeyspace WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 3};

cqlsh> USE linkedinkeyspace;
```

Create tables
---------------------------

1. User Profile
-----------------

```
CREATE TABLE user_profile
( 
id uuid, 
firstname text, 
lastname text,
email text,
about text,
PRIMARY KEY(id) 
);
```

  
2. Find Publication by email
------------------------------
```
CREATE TABLE publication
( 
id int,
email text,
title text,
content text,
year int,
PRIMARY KEY(email, id) 
);
```


3. Find Job History by email
-----------------------------
```
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
```


4. Find Education by email
---------------------------
```
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
```





Add Records in the table
----------------------------
```
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
```


If we maintain all details in user_profile table
---------------------------------------------------------
```
UPDATE user_profile SET publication = publication + [{'title':'Publication1','content':'Content1','year':'2015'},{'title':'Publication2','content':'Content2','year':'2020'}] WHERE id = 9a0735fb-fb2b-41c3-9edb-0b1334fbe6b6;

UPDATE user_profile SET education_history = education_history + [{'fromYear':'2006','toYear':'2010','obtainedGrade':'8.79','totalGrade':'10.0','location':'Coimbatore','institutionName':'PSG','degreeName':'Engineering'},{'fromYear':'2013','toYear':'2015','obtainedGrade':'8.63','totalGrade':'10.0','location':'Pilani','institutionName':'BITS','degreeName':'Masters'}] WHERE id = 9a0735fb-fb2b-41c3-9edb-0b1334fbe6b6;


UPDATE user_profile SET job_history = job_history + [{'fromYear':'2010','toYear':'2013','designation':'Trainee','companyName':'Subex','location':'Bangalore'},{'fromYear':'2013','toYear':'2017','designation':'Senior Staff','companyName':'Fiberlink','location':'Bangalore'},{'fromYear':'2017','toYear':'2020','designation':'Senior Software Engineer','companyName':'Intuit','location':'Bangalore'}] WHERE id = 9a0735fb-fb2b-41c3-9edb-0b1334fbe6b6;

UPDATE user_profile SET language_known = language_known + ['Tamil','English'] WHERE id = 9a0735fb-fb2b-41c3-9edb-0b1334fbe6b6;

UPDATE user_profile SET dob = '2000-01-01' WHERE id = 9a0735fb-fb2b-41c3-9edb-0b1334fbe6b6;
```
