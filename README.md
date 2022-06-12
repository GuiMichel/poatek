# Poatek :rocket:
 Repository to my technical challenge.

## 1. Challenge One :trophy:
![image](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)

#### In this challenge i used Java 17 in Intellij IDEA to solve the problems.

 
##### To acess this challenge you need:
    1. clone this repository using git. <https://github.com/GuiMichel/poatek.git>
    2. open the project in your IDE.
    3. browse the directories named with the challenge name.
    4. run the executable class of each challenge how below:
       1. to challenge 1.1 run ChallengeOneLists.
       2. to challenge 1.2 run ChallengeOneFunctions.
       3. to challenge 1.3 run ChallengeOneClasses.
   

## 2. Challenge Two :trophy:
![image](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)

#### In this challenge i used pgAdmin 4 and SQL consults to solve the problems.

**2.1. 5 CUSTOMERS BOUGHT THE MOST IN USD.**

C_ID |	C_NAME	        |	    TOTAL IN USD    |
-----|------------------|-----------------------|
12	 |   "Medline "	    |    2248332.40         |
29	 |   "Apotheca, Ltd"|	 2112221.90         |
17	 |  "Pure Group"	|    1962014.59         |
34	 |   "OUR Ltd"	    |    1937827.59         |
33	 |   "Trigen "	    |    1895188.80         |

~~~SQL
    SELECT CL.CUSTOMER_ID, CL.CUSTOMER_NAME, SUM(SO.UNIT_PRICE*SO.ORDER_QUANTITY) AS "SOMA"
    FROM SALES_ORDER SO
    INNER JOIN CUSTOMERS CL
    ON CL.CUSTOMER_ID=SO.CUSTOMER_ID
    GROUP BY (CL.CUSTOMER_ID, CL.CUSTOMER_NAME)
    ORDER BY "SOMA" DESC
    LIMIT 5;
~~~

**2.2. STATE THE HAS SOLD THE MOST IN TERMS OF UNITS.**

STATE       |   UNITS
------------|---------
CALIFORNIA  |   7605

~~~SQL
    SELECT SL.STATE, SUM(SO.ORDER_QUANTITY) AS "SOMA"
    FROM SALES_ORDER SO
    INNER JOIN STORE_LOCATIONS SL
    ON SL.STORE_ID=SO.STORE_ID
    GROUP BY (SL.STATE)
    ORDER BY "SOMA" DESC
    LIMIT 1;
~~~
**2.3. CITY IN STATE OF INDIANA HAVE THE BIGGEST TOTAL OF SALES(UNITS).**

CITY    |   SALES(UNITS)
--------|----------------
WAYNE   |   193

~~~SQL
    SELECT SL.CITY_NAME, SUM(SO.ORDER_QUANTITY) AS "SOMA"
    FROM SALES_ORDER SO
    INNER JOIN STORE_LOCATIONS SL
    ON SL.STORE_ID=SO.STORE_ID
    WHERE SL.STATE = 'Indiana'
    GROUP BY (SL.CITY_NAME)
    ORDER BY "SOMA" DESC
    LIMIT 1;
~~~

**2.4. CITY HAS THE BIGGEST SALES PER CAPITA.**

CITY		  |  STATE	|	SALES PER CAPITA |
--------------|---------|--------------------|
BROKEN ARROW  |	OKLAHOMA|  	4,60 USD/RESIDENT|

~~~SQL
    SELECT SL.CITY_NAME, SL.STATE, SUM(((SO.ORDER_QUANTITY*SO.UNIT_PRICE)/SL.POPULATION)) AS "PERCAPITA"
    FROM SALES_ORDER SO
    INNER JOIN STORE_LOCATIONS SL
    ON SL.STORE_ID=SO.STORE_ID
    GROUP BY SL.CITY_NAME, SL.STATE
    ORDER BY "PERCAPITA" DESC
    LIMIT 1;
~~~

**2.5. PRODUCT THAT HAS SOLD MORE (UNITS)?**

PRODUCT_ID|	PRODUCT_NAME|	QUANTIDADE
----------|-------------|--------------
23		  | ACCESSORIES	|    956

~~~SQL
    SELECT SO.PRODUCT_ID, PR.PRODUCT_NAME, SUM(SO.ORDER_QUANTITY) AS "QUANTIDADE"
    FROM SALES_ORDER SO
    INNER JOIN PRODUCTS PR
    ON PR.PRODUCT_ID=SO.PRODUCT_ID
    GROUP BY SO.PRODUCT_ID, PR.PRODUCT_NAME
    ORDER BY "QUANTIDADE" DESC
    LIMIT 1;
~~~

**2.6. PRODUCT THAT HAS SOLD MORE (UNITS) IN THE CITY THAT HAS THE LARGEST
AMOUNT OF WATER AREA.**

PRODUCT-ID| P_NAME	 |	CITY_NAME	    |	 WATER_AREA	    |   QUANTITY
----------|----------|------------------|-------------------|-----------
43		  | "Festive"|	"Corpus Christi"|	852118618	    |   13

~~~SQL
    SELECT SO.PRODUCT_ID, PR.PRODUCT_NAME,
    SL.CITY_NAME,SL.WATER_AREA ,SUM(SO.ORDER_QUANTITY) AS "QUANTITY"
    FROM SALES_ORDER SO
    INNER JOIN PRODUCTS PR
    ON PR.PRODUCT_ID=SO.PRODUCT_ID
    INNER JOIN STORE_LOCATIONS SL
    ON SL.STORE_ID=SO.STORE_ID
    GROUP BY SO.PRODUCT_ID, PR.PRODUCT_NAME,SL.CITY_NAME,SL.WATER_AREA 
    ORDER BY SL.WATER_AREA DESC, "QUANTITY" DESC
    LIMIT 1;
~~~

**2.7. AVARAGE DELIVERY TIME (DAYS) IN THE REGION NORTHEAST.**

|AVARAGE DELIVERY TIME|
|---------------------| 
|    20 DAYS          |

~~~SQL
    SELECT AVG(( SO.DELIVERY_DATE - SO.ORDER_DATE)) AS "DELIVERY TIME"
    FROM SALES_ORDER SO
    INNER JOIN STORE_LOCATIONS SL
    ON SL.STORE_ID=SO.STORE_ID
    INNER JOIN REGIONS RG
    ON SL.STATE_CODE=RG.STATE_CODE
    WHERE RG.REGION ='Northeast';
~~~

**2.8. SELLER WHO OBTAINED THE MOST TOTAL PROFIT.**
	
SELLER			       |     PROFIT(USD)
-----------------------|-----------------
"Donald Reynolds"	   |     1251542.98

~~~SQL
    SELECT ST.SALES_TEAM, SUM(SO.ORDER_QUANTITY*(SO.UNIT_PRICE-SO.UNIT_COST)) AS "PROFIT"
    FROM SALES_ORDER SO
    INNER JOIN SALES_TEAM ST
    ON ST.SALES_TEAM_ID=SO.SALES_TEAM_ID
    GROUP BY ST.SALES_TEAM
    ORDER BY "PROFIT" DESC
    LIMIT 1;
~~~
