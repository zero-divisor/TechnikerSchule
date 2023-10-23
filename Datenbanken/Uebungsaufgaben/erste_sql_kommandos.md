### 1. Erstellen Sie die Datenbank „est“.

```sql
create database EST;
```

### 2.Legen Sie den Benutzer „master“ mit einem Passwort Ihrer Wahl an. Beschränken Sie den Benutzer auf einen Login am Datenbankserver.

```sql
create user 'master'@'localhost' identified by 'masterpw';
```

### 3. Weisen Sie dem Benutzer „master“ alle Rechte auf die Datenbank „est“ zu.

```sql
grant all on est.* to 'master'@'localhost';
```

### 4. Lassen Sie sich alle Datenbanken anzeigen.

```sql
show databases;
```

Output:

```
+--------------------+
| Database           |
+--------------------+
| est                |
| information_schema |
| mysql              |
| performance_schema |
| phpmyadmin         |
+--------------------+
```

### 5. Lassen Sie sich alle Benutzer anzeigen (host, user, password).

```sql
SELECT host, user, password FROM mysql.user;
```

Output:

```
+-----------+----------+-------------------------------------------+
| Host      | User     | Password                                  |
+-----------+----------+-------------------------------------------+
| localhost | root     | *94BDCEBE19083CE2A1F959FD02F964C7AF4CFC29 |
| localhost | schueler | *462366917EEDD1970A48E87D8EF59EB67D2CA26F |
| 127.0.0.1 | root     |                                           |
| ::1       | root     |                                           |
| localhost | pma      |                                           |
| localhost | master   | *F6F7ECBF464B8386EAA4851BF281D3F27437E317 |
+-----------+----------+-------------------------------------------+
```

## Arbeiten Sie ab jetzt mit dem Benutzer „master“ in der Datenbank „est“!

### 6. Erstellen Sie die Tabelle „schueler“ mit folgenden Feldern:

| Spaltenname | Datentyp    |
|-------------|-------------|
| nr          | integer     |
| nachame     | varchar(30) |
| vorname     | varchar(30) |

```sql
create table schueler (
    nr int, 
    nachname varchar(30), 
    vorname varchar(30), 
    primary key (nr)
);
```

### 7. Lassen Sie sich alle Tabellen der Datenbank „est“ ausgeben.

```sql
show tables;
```

Output:

```
+---------------+
| Tables_in_est |
+---------------+
| schueler      |
+---------------+
```

### 8. Lassen Sie sich die Struktur der Tabelle „schueler“ anzeigen.

```sql
show columns from schueler;
```

Output:

```
+----------+-------------+------+-----+---------+-------+
| Field    | Type        | Null | Key | Default | Extra |
+----------+-------------+------+-----+---------+-------+
| nr       | int(11)     | NO   | PRI | NULL    |       |
| nachname | varchar(30) | YES  |     | NULL    |       |
| vorname  | varchar(30) | YES  |     | NULL    |       |
+----------+-------------+------+-----+---------+-------+
```

### 9. Fügen Sie Ihren Namen unter Nr. 1 und den Namen eines Klassenkameraden unter Nr. 2 in die Tabelle ein.

```sql
insert into schueler (nr, nachname, vorname) 
    values (1, 'Weiß', 'Alex');

insert into schueler (nr, nachname, vorname) 
    values (2, 'Pfaffengut', 'Robin');
```

### 10. Lassen Sie sich alle Datensätze der Tabelle „schueler“ ausgeben.

```sql
select * from schueler;
```

Output:

```
+----+------------+---------+
| nr | nachname   | vorname |
+----+------------+---------+
|  1 | Weiß       | Alex    |
|  2 | Pfaffengut | Robin   |
+----+------------+---------+
```

### 11. Lassen Sie sich Vorname und Nachname aller Datensätze der Tabelle „schueler“ ausgeben.

```sql
select vorname, nachname from schueler;
```

Output:

```
+---------+------------+
| vorname | nachname   |
+---------+------------+
| Alex    | Weiß       |
| Robin   | Pfaffengut |
+---------+------------+
```

### 12. Löschen Sie alle Datensätze der Tabelle „schueler“.

```sql
truncate table schueler;
```

### 13. Lassen Sie sich alle Datensätze der Tabelle „schueler“ ausgeben.

```sql
select * from schueler;
```

Output:

```
Empty set (0.000 sec)
```

### 14. Löschen Sie die Tabelle „schueler“.

```sql
drop table schueler;
```

### 15. Lassen Sie sich alle Tabellen der Datenbank „est“ ausgeben.

```sql
show tables;
```

Output:

```
Empty set (0.000 sec)
```

### 16. Löschen Sie die Datenbank „est“.

```sql
drop database est;
```

### 17. Lassen Sie sich alle Datenbanken anzeigen.

```sql
show databases;
```

Output:

```
+--------------------+
| Database           |
+--------------------+
| information_schema |
+--------------------+
```

### 18. Lassen Sie sich alle Benutzer mit allen Daten anzeigen.

```sql
select * from mysql.user;
```

Als master:

```
SELECT command denied to user 'master'@'localhost' for table `mysql`.`user`
```
