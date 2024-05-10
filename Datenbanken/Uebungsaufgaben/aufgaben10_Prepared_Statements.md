### 1. Analysieren Sie die Datei artikel.sql und führen Sie sie aus.

```sql
source C:/Users/ale040/Git/TechnikerSchule/Datenbanken/Uebungsaufgaben/artikel.sql;
```

```sql
MariaDB [est]> desc artikel;
+-----------+--------------+------+-----+---------+-------+
| Field     | Type         | Null | Key | Default | Extra |
+-----------+--------------+------+-----+---------+-------+
| artnr     | int(11)      | NO   | PRI | NULL    |       |
| benennung | varchar(30)  | NO   |     | NULL    |       |
| artgr     | int(11)      | NO   |     | NULL    |       |
| me        | varchar(2)   | NO   |     | NULL    |       |
| preis     | decimal(6,2) | NO   |     | NULL    |       |
| mwstgr    | int(11)      | NO   |     | NULL    |       |
+-----------+--------------+------+-----+---------+-------+
6 rows in set (0.010 sec)

MariaDB [est]> desc artikelgruppen;
+-----------+-------------+------+-----+---------+-------+
| Field     | Type        | Null | Key | Default | Extra |
+-----------+-------------+------+-----+---------+-------+
| artgr     | int(11)     | NO   | PRI | NULL    |       |
| benennung | varchar(30) | NO   |     | NULL    |       |
+-----------+-------------+------+-----+---------+-------+
2 rows in set (0.008 sec)

MariaDB [est]> desc mwst;
+-----------+---------------+------+-----+---------+-------+
| Field     | Type          | Null | Key | Default | Extra |
+-----------+---------------+------+-----+---------+-------+
| mwstgr    | int(11)       | NO   | PRI | NULL    |       |
| benennung | varchar(30)   | NO   |     | NULL    |       |
| mwst      | decimal(10,0) | NO   |     | NULL    |       |
+-----------+---------------+------+-----+---------+-------+
3 rows in set (0.008 sec)

MariaDB [est]> desc lagerorte;
+-----------+-------------+------+-----+---------+-------+
| Field     | Type        | Null | Key | Default | Extra |
+-----------+-------------+------+-----+---------+-------+
| lagnr     | int(11)     | NO   | PRI | NULL    |       |
| benennung | varchar(30) | NO   |     | NULL    |       |
+-----------+-------------+------+-----+---------+-------+
2 rows in set (0.009 sec)

MariaDB [est]> desc lager;
+-------+---------------+------+-----+---------+-------+
| Field | Type          | Null | Key | Default | Extra |
+-------+---------------+------+-----+---------+-------+
| lagnr | int(11)       | NO   | PRI | NULL    |       |
| artnr | int(11)       | NO   | PRI | NULL    |       |
| menge | decimal(10,0) | NO   |     | NULL    |       |
+-------+---------------+------+-----+---------+-------+
3 rows in set (0.009 sec)
```

### 2. Legen Sie die fehlenden Foreign Keys an.

### 3. Erstellen Sie das ERM.

### 4. Erstellen Sie ein Prepared Statement zur Suche in der Tabelle "artikel" nach einer bestimmten Artikelbenennung und der Artikelgruppe.

### 5. Erstellen Sie ein Prepared Statement zur Erhöhung des Lagerbestands in der Tabelle "lager" unter Angabe Artikelnummer, Lagernummer und Einlagermenge.