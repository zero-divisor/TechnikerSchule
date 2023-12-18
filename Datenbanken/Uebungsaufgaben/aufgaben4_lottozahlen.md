### 1.) Geben Sie 6 zufällige Lottozahlen zwischen 1 und 49 aus. Die Feldnamen sollen zahl1 bis zahl6 lauten.

Allgemeine qery für Zufallszahl zwischen max und min:\
`FLOOR(RAND()*(max - min + 1) + min);`

#### Einfache version, kann Duplikate enthalten:

```sql
select FLOOR(RAND()*49 + 1) as zahl1,
    FLOOR(RAND()*49 + 1) as zahl2,
    FLOOR(RAND()*49 + 1) as zahl3,
    FLOOR(RAND()*49 + 1) as zahl4,
    FLOOR(RAND()*49 + 1) as zahl5,
    FLOOR(RAND()*49 + 1) as zahl6;
```

#### Ohne Duplikate:

Um 6 Zufallszahlen zwischen 0 und 49 ohne Duplikate zu generieren, weisen wir den Zahlen 1 bis 49 eine zufällige zahl zu und wählen die 6 ergebnisse mit den höchsten Zufallszahlen.

__Tabelle mit 2 Spalten erstellen__
```sql
create or replace table random1_49 (row_number int, random_number float);
```

__Funktion erstellen, die die Tabelle mit 49 Werten befüllt__
```sql
DELIMITER $$

CREATE OR REPLACE PROCEDURE fill_random1_49()
BEGIN
    DECLARE counter INT DEFAULT 1;
    -- random1_49 leeren
    DELETE FROM random1_49;
    -- mit 49 neuen Zeilen füllen
    WHILE counter <= 49 DO
        insert into random1_49 (row_number, random_number) values (counter, rand());
        SET counter = counter + 1;
    END WHILE;

END$$

DELIMITER ;
```

__Oben erstellte Funktion ausführen:__
```sql
call fill_random1_49();
```

__Die 6 Zeilen aus `random1_49` mit den größten Zufallszahlen auswählen__
```sql
select
    (select row_number
    from random1_49 order by random_number limit 1 offset 0) as zahl1,
    (select row_number
    from random1_49 order by random_number limit 1 offset 1) as zahl2,
    (select row_number
    from random1_49 order by random_number limit 1 offset 2) as zahl3,
    (select row_number
    from random1_49 order by random_number limit 1 offset 3) as zahl4,
    (select row_number
    from random1_49 order by random_number limit 1 offset 4) as zahl5,
    (select row_number
    from random1_49 order by random_number limit 1 offset 5) as zahl6;
```

### 2.) Erstellen Sie eine Tabelle mit Namen „lottozahlen“ welche die folgenden Felder zur Aufnahme von Ganzzahlen (außer „zeitstempel“) beinhalten soll:

| Feldname | Bedingungen |
|-|-|
|ziehung|primärer Schlüssel, automatischer Wert|
|zeitstempel|Datums-/Zeitfeld (Datentyp datetime)|
|zahl1|darf nicht leer sein|
|zahl2|darf nicht leer sein|
|zahl3|darf nicht leer sein|
|zahl4|darf nicht leer sein|
|zahl5|darf nicht leer sein|
|zahl6|darf nicht leer sein|


```sql
create or replace table lottozahlen (
    ziehung int primary key auto_increment,
    zeitstempel datetime,
    zahl1 int not null,
    zahl2 int not null,
    zahl3 int not null,
    zahl4 int not null,
    zahl5 int not null,
    zahl6 int not null
    );
```

### 3.) Setzen Sie den nächsten Autoincrement-Wert der Tabelle „lottozahlen“ auf 50.

```sql
alter table lottozahlen auto_increment=50;
```

### 4.) Ermitteln Sie 6 zufällige Lottozahlen zwischen 1 und 49 und tragen Sie sie in die Tabelle „lottozahlen“ ein.

```sql
-- siehe Aufgabe 1.
call fill_random1_49();

insert into lottozahlen (zahl1, zahl2, zahl3, zahl4, zahl5, zahl6)
    select
        (select row_number
        from random1_49 order by random_number limit 1 offset 0) as zahl1,
        (select row_number
        from random1_49 order by random_number limit 1 offset 1) as zahl2,
        (select row_number
        from random1_49 order by random_number limit 1 offset 2) as zahl3,
        (select row_number
        from random1_49 order by random_number limit 1 offset 3) as zahl4,
        (select row_number
        from random1_49 order by random_number limit 1 offset 4) as zahl5,
        (select row_number
        from random1_49 order by random_number limit 1 offset 5) as zahl6;
```

```
MariaDB [est]> select * from lottozahlen;
+---------+-------------+-------+-------+-------+-------+-------+-------+
| ziehung | zeitstempel | zahl1 | zahl2 | zahl3 | zahl4 | zahl5 | zahl6 |
+---------+-------------+-------+-------+-------+-------+-------+-------+
|      50 | NULL        |    16 |    42 |    12 |     8 |    45 |    19 |
+---------+-------------+-------+-------+-------+-------+-------+-------+
1 row in set (0.000 sec)
```

### 5.) Wie Aufgabe 4, aber füllen Sie das Feld „zeitstempel“ zusätzlich mit dem aktuellen Datum-/Zeitwert.

```sql
call fill_random1_49();

insert into lottozahlen (zeitstempel, zahl1, zahl2, zahl3, zahl4, zahl5, zahl6)
    select
        now(),
        (select row_number
        from random1_49 order by random_number limit 1 offset 0) as zahl1,
        (select row_number
        from random1_49 order by random_number limit 1 offset 1) as zahl2,
        (select row_number
        from random1_49 order by random_number limit 1 offset 2) as zahl3,
        (select row_number
        from random1_49 order by random_number limit 1 offset 3) as zahl4,
        (select row_number
        from random1_49 order by random_number limit 1 offset 4) as zahl5,
        (select row_number
        from random1_49 order by random_number limit 1 offset 5) as zahl6;
```

```
MariaDB [est]> select * from lottozahlen;
+---------+---------------------+-------+-------+-------+-------+-------+-------+
| ziehung | zeitstempel         | zahl1 | zahl2 | zahl3 | zahl4 | zahl5 | zahl6 |
+---------+---------------------+-------+-------+-------+-------+-------+-------+
|      50 | NULL                |    16 |    42 |    12 |     8 |    45 |    19 |
|      51 | 2023-12-18 11:12:02 |     8 |    22 |    24 |    17 |    28 |     9 |
+---------+---------------------+-------+-------+-------+-------+-------+-------+
2 rows in set (0.000 sec)
```

### 6.) Gibt es eine Möglichkeit, wie Sie die 6 Lottozahlen einer Ziehung sortiert ausgeben können?

Man könnte die Gezogenen Zahlen schon sortiert in die Tabelle eintragen.

Alternativ falls es nicht möglich ist die Zahlen schon sortirert anzulegen, kann man jede Zahl in eine eigene Zeile schreiben.

### 7.) Wie könnte eine Tabellenstruktur aussehen, mit der eine sortierte Ausgabe der Lottozahlen möglich ist. Erstellen Sie die Tabelle mit Namen „lottozahlen2“.

| Feldname | Bedingungen |
|-|-|
|id|primärer Schlüssel, automatischer Wert|
|ziehungs_nr|darf nicht leer sein|
|zeitstempel|Datums-/Zeitfeld (Datentyp datetime)|
|zahl_nr|1-6|
|gezogene_zahl|darf nicht leer sein|

```sql
create or replace table lottozahlen2 (
    id int primary key auto_increment,
    ziehungs_nr int not null,
    zeitstempel datetime,
    zahl_nr int not null,
    gezogene_zahl int not null
    );
```

```
MariaDB [est]> describe lottozahlen2;
+---------------+----------+------+-----+---------+----------------+
| Field         | Type     | Null | Key | Default | Extra          |
+---------------+----------+------+-----+---------+----------------+
| id            | int(11)  | NO   | PRI | NULL    | auto_increment |
| ziehungs_nr   | int(11)  | NO   |     | NULL    |                |
| zeitstempel   | datetime | YES  |     | NULL    |                |
| zahl_nr       | int(11)  | NO   |     | NULL    |                |
| gezogene_zahl | int(11)  | NO   |     | NULL    |                |
+---------------+----------+------+-----+---------+----------------+
5 rows in set (0.009 sec)
```

### 8.) Füllen Sie die neue Tabelle mit Lottozahlen (2-3 Ziehungen).

```sql
-- 3 mal ausführen, ziehungs_nr jedesmal ändern
call fill_random1_49();

insert into lottozahlen2 (ziehungs_nr, zeitstempel, zahl_nr, gezogene_zahl)
    values (
        1,
        now(),
        1,
        (select row_number from random1_49 order by random_number limit 1 offset 0)
    ),(
        1,
        now(),
        2,
        (select row_number from random1_49 order by random_number limit 1 offset 1)
    ),(
        1,
        now(),
        3,
        (select row_number from random1_49 order by random_number limit 1 offset 2)
    ),(
        1,
        now(),
        4,
        (select row_number from random1_49 order by random_number limit 1 offset 3)
    ),(
        1,
        now(),
        5,
        (select row_number from random1_49 order by random_number limit 1 offset 4)
    ),(
        1,
        now(),
        6,
        (select row_number from random1_49 order by random_number limit 1 offset 5)
    );
```

```
MariaDB [est]> select * from lottozahlen2;
+----+-------------+---------------------+---------+---------------+
| id | ziehungs_nr | zeitstempel         | zahl_nr | gezogene_zahl |
+----+-------------+---------------------+---------+---------------+
|  1 |           1 | 2023-12-18 11:39:27 |       1 |             9 |
|  2 |           1 | 2023-12-18 11:39:27 |       2 |             2 |
|  3 |           1 | 2023-12-18 11:39:27 |       3 |             5 |
|  4 |           1 | 2023-12-18 11:39:27 |       4 |             1 |
|  5 |           1 | 2023-12-18 11:39:27 |       5 |            16 |
|  6 |           1 | 2023-12-18 11:39:27 |       6 |            43 |
|  7 |           2 | 2023-12-18 11:40:45 |       1 |            19 |
|  8 |           2 | 2023-12-18 11:40:45 |       2 |             7 |
|  9 |           2 | 2023-12-18 11:40:45 |       3 |            25 |
| 10 |           2 | 2023-12-18 11:40:45 |       4 |            29 |
| 11 |           2 | 2023-12-18 11:40:45 |       5 |            27 |
| 12 |           2 | 2023-12-18 11:40:45 |       6 |            49 |
| 13 |           3 | 2023-12-18 11:41:47 |       1 |             9 |
| 14 |           3 | 2023-12-18 11:41:47 |       2 |            30 |
| 15 |           3 | 2023-12-18 11:41:47 |       3 |            22 |
| 16 |           3 | 2023-12-18 11:41:47 |       4 |             6 |
| 17 |           3 | 2023-12-18 11:41:47 |       5 |            31 |
| 18 |           3 | 2023-12-18 11:41:47 |       6 |            14 |
+----+-------------+---------------------+---------+---------------+
18 rows in set (0.000 sec)
```

### 9.) Geben Sie die Lottozahlen sortiert nach Zahlen innerhalb der Ziehung aus.

```sql
select gezogene_zahl
    from lottozahlen2 
    where ziehungs_nr = 1 
    order by gezogene_zahl asc;
```

```
+---------------+
| gezogene_zahl |
+---------------+
|             1 |
|             2 |
|             5 |
|             9 |
|            16 |
|            43 |
+---------------+
6 rows in set (0.000 sec)
```

### 10.) Geben Sie die Häufigkeit der gezogenen Zahlen aus sortiert nach der Zahl.

```sql
select gezogene_zahl, count(gezogene_zahl)
    from lottozahlen2
    group by gezogene_zahl
    order by gezogene_zahl asc;
```

```
+---------------+----------------------+
| gezogene_zahl | count(gezogene_zahl) |
+---------------+----------------------+
|             1 |                    1 |
|             2 |                    1 |
|             5 |                    1 |
|             6 |                    1 |
|             7 |                    1 |
|             9 |                    2 |
|            14 |                    1 |
|            16 |                    1 |
|            19 |                    1 |
|            22 |                    1 |
|            25 |                    1 |
|            27 |                    1 |
|            29 |                    1 |
|            30 |                    1 |
|            31 |                    1 |
|            43 |                    1 |
|            49 |                    1 |
+---------------+----------------------+
17 rows in set (0.000 sec)
```

### 11.) Geben Sie die Häufigkeit der gezogenen Zahlen aus nach Häufigkeit (die am meisten gezogenen Zahlen zu Beginn). Bei gleicher Häufigkeit sollen die Zahlen aufsteigend sortiert erscheinen.

```sql
select gezogene_zahl, count(gezogene_zahl) as haeufigkeit
    from lottozahlen2
    group by gezogene_zahl
    order by haeufigkeit desc, gezogene_zahl asc;
```

```
+---------------+-------------+
| gezogene_zahl | haeufigkeit |
+---------------+-------------+
|             9 |           2 |
|             1 |           1 |
|             2 |           1 |
|             5 |           1 |
|             6 |           1 |
|             7 |           1 |
|            14 |           1 |
|            16 |           1 |
|            19 |           1 |
|            22 |           1 |
|            25 |           1 |
|            27 |           1 |
|            29 |           1 |
|            30 |           1 |
|            31 |           1 |
|            43 |           1 |
|            49 |           1 |
+---------------+-------------+
17 rows in set (0.000 sec)
```

### 12.) Tippen Sie 6 Zahlen (direkt im SQL-Kommando angegeben) und lassen Sie sich zu den Ziehungen in Tabelle „lottozahlen2“ die Anzahl der richtigen Zahlen ausgeben je Ziehung.

```sql
select 
    ziehungs_nr, 
    (select count(id) from lottozahlen2 lz2_2 
        where lz2_2.gezogene_zahl in (1,2,3,4,5,6) 
        and lz2_2.ziehungs_nr = lz2.ziehungs_nr) 
        as treffer
from lottozahlen2 lz2
group by ziehungs_nr
order by ziehungs_nr asc;
```

```
+-------------+---------+
| ziehungs_nr | treffer |
+-------------+---------+
|           1 |       3 |
|           2 |       0 |
|           3 |       1 |
+-------------+---------+
3 rows in set (0.000 sec)
```