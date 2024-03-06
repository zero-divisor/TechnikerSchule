## Übungsaufgabe zu CSV-Import

Die bereitgestellte Datei „Bundesligatabelle.csv“ (CSV = Comma Separated Values) enthält die folgenden Felder:

+ Rang
+ Mannschaft
+ Spiele
+ Siege
+ Unentschieden
+ Niederlagen
+ Tore
+ Gegentore
+ Punkte

### 1.) Erstellen Sie eine Tabelle, um die Daten der CSV-Datei aufzunehmen.

```sql
create table bundesliga (
    rang int, 
    mannschaft varchar(50), 
    spiele int, 
    siege int, 
    unentschieden int, 
    niederlagen int, 
    tore int, 
    gegentore int, 
    punkte int
);
```

### 2.) Laden Sie die Daten aus der CSV-Datei in die angelegte Tabelle. 

```sql
load data local infile 'C:/pfad/zur/datei/Bundesligatabelle.csv'
    into table bundesliga 
    fields terminated by ';'
    lines terminated by '\n'
    ignore 1 rows;
```

### 3.) Geben Sie die Tabelle aus.

```sql
select * from bundesliga;
```

Output:

```
+------+---------------------------+--------+-------+---------------+-------------+------+-----------+--------+
| rang | mannschaft                | spiele | siege | unentschieden | niederlagen | tore | gegentore | punkte |
+------+---------------------------+--------+-------+---------------+-------------+------+-----------+--------+
|    1 | Borussia Dortmund         |      8 |     6 |             1 |           1 |   23 |         5 |     19 |
|    2 | FC Bayern Muenchen        |      8 |     5 |             2 |           1 |   21 |         7 |     17 |
|    3 | RB Leipzig                |      8 |     5 |             1 |           2 |   15 |        10 |     16 |
|    4 | Hoffenheim                |      8 |     4 |             3 |           1 |   15 |        10 |     15 |
|    5 | Borussia Moenchengladbach |      8 |     4 |             2 |           2 |   12 |        12 |     14 |
|    6 | Schalke 04                |      8 |     4 |             1 |           3 |   10 |         9 |     13 |
|    7 | Eintracht Frankfurt       |      8 |     4 |             1 |           3 |    8 |         7 |     13 |
|    8 | FC Augsburg               |      8 |     3 |             3 |           2 |   11 |         8 |     12 |
|    9 | Hannover 96               |      8 |     3 |             3 |           2 |    8 |         6 |     12 |
|   10 | Mainz 05                  |      8 |     3 |             1 |           4 |   10 |        13 |     10 |
|   11 | VfB Stuttgart             |      8 |     3 |             1 |           4 |    6 |        10 |     10 |
|   12 | Bayer Leverkusen          |      8 |     2 |             3 |           3 |   15 |        13 |      9 |
|   13 | Hertha BSC                |      8 |     2 |             3 |           3 |    8 |        10 |      9 |
|   14 | VfL Wolfsburg             |      8 |     1 |             5 |           2 |    8 |        11 |      8 |
|   15 | Hamburger SV              |      8 |     2 |             1 |           5 |    6 |        14 |      7 |
|   16 | SC Freiburg               |      8 |     1 |             4 |           3 |    5 |        16 |      7 |
|   17 | Werder Bremen             |      8 |     0 |             4 |           4 |    3 |         9 |      4 |
|   18 | 1. FC Koeln               |      8 |     0 |             1 |           7 |    3 |        17 |      1 |
+------+---------------------------+--------+-------+---------------+-------------+------+-----------+--------+
```

### 4.) Zeigen Sie Rang, Mannschaft, Tordifferenz und Punkte an.

```sql
select rang, mannschaft, tore - gegentore as tordifferenz, punkte
    from bundesliga;
```

Output:

```
+------+---------------------------+--------------+--------+
| rang | mannschaft                | tordifferenz | punkte |
+------+---------------------------+--------------+--------+
|    1 | Borussia Dortmund         |           18 |     19 |
|    2 | FC Bayern Muenchen        |           14 |     17 |
|    3 | RB Leipzig                |            5 |     16 |
|    4 | Hoffenheim                |            5 |     15 |
|    5 | Borussia Moenchengladbach |            0 |     14 |
|    6 | Schalke 04                |            1 |     13 |
|    7 | Eintracht Frankfurt       |            1 |     13 |
|    8 | FC Augsburg               |            3 |     12 |
|    9 | Hannover 96               |            2 |     12 |
|   10 | Mainz 05                  |           -3 |     10 |
|   11 | VfB Stuttgart             |           -4 |     10 |
|   12 | Bayer Leverkusen          |            2 |      9 |
|   13 | Hertha BSC                |           -2 |      9 |
|   14 | VfL Wolfsburg             |           -3 |      8 |
|   15 | Hamburger SV              |           -8 |      7 |
|   16 | SC Freiburg               |          -11 |      7 |
|   17 | Werder Bremen             |           -6 |      4 |
|   18 | 1. FC Koeln               |          -14 |      1 |
+------+---------------------------+--------------+--------+
```

### 5.) Geben Sie nur die 5 bestplatzierten Mannschaften aus.

```sql
select mannschaft 
    from bundesliga 
    order by rang asc 
    limit 5;
```

Output:

```
+---------------------------+
| mannschaft                |
+---------------------------+
| Borussia Dortmund         |
| FC Bayern Muenchen        |
| RB Leipzig                |
| Hoffenheim                |
| Borussia Moenchengladbach |
+---------------------------+
```

### 6.) Geben Sie die Mannschaftsnamen sortiert aus. 

```sql
select mannschaft 
    from bundesliga 
    order by mannschaft asc;
```

Output:

```
+---------------------------+
| mannschaft                |
+---------------------------+
| 1. FC Koeln               |
| Bayer Leverkusen          |
| Borussia Dortmund         |
| Borussia Moenchengladbach |
| Eintracht Frankfurt       |
| FC Augsburg               |
| FC Bayern Muenchen        |
| Hamburger SV              |
| Hannover 96               |
| Hertha BSC                |
| Hoffenheim                |
| Mainz 05                  |
| RB Leipzig                |
| SC Freiburg               |
| Schalke 04                |
| VfB Stuttgart             |
| VfL Wolfsburg             |
| Werder Bremen             |
+---------------------------+
```

### 7.) „Willst Du Werder oben sehn, musst Du die Tabelle drehn“. Geben Sie die Tabelle in umgekehrter Rangfolge aus.

```sql
select * from bundesliga 
    order by rang desc;
```

Output:

```
+------+---------------------------+--------+-------+---------------+-------------+------+-----------+--------+
| rang | mannschaft                | spiele | siege | unentschieden | niederlagen | tore | gegentore | punkte |
+------+---------------------------+--------+-------+---------------+-------------+------+-----------+--------+
|   18 | 1. FC Koeln               |      8 |     0 |             1 |           7 |    3 |        17 |      1 |
|   17 | Werder Bremen             |      8 |     0 |             4 |           4 |    3 |         9 |      4 |
|   16 | SC Freiburg               |      8 |     1 |             4 |           3 |    5 |        16 |      7 |
|   15 | Hamburger SV              |      8 |     2 |             1 |           5 |    6 |        14 |      7 |
|   14 | VfL Wolfsburg             |      8 |     1 |             5 |           2 |    8 |        11 |      8 |
|   13 | Hertha BSC                |      8 |     2 |             3 |           3 |    8 |        10 |      9 |
|   12 | Bayer Leverkusen          |      8 |     2 |             3 |           3 |   15 |        13 |      9 |
|   11 | VfB Stuttgart             |      8 |     3 |             1 |           4 |    6 |        10 |     10 |
|   10 | Mainz 05                  |      8 |     3 |             1 |           4 |   10 |        13 |     10 |
|    9 | Hannover 96               |      8 |     3 |             3 |           2 |    8 |         6 |     12 |
|    8 | FC Augsburg               |      8 |     3 |             3 |           2 |   11 |         8 |     12 |
|    7 | Eintracht Frankfurt       |      8 |     4 |             1 |           3 |    8 |         7 |     13 |
|    6 | Schalke 04                |      8 |     4 |             1 |           3 |   10 |         9 |     13 |
|    5 | Borussia Moenchengladbach |      8 |     4 |             2 |           2 |   12 |        12 |     14 |
|    4 | Hoffenheim                |      8 |     4 |             3 |           1 |   15 |        10 |     15 |
|    3 | RB Leipzig                |      8 |     5 |             1 |           2 |   15 |        10 |     16 |
|    2 | FC Bayern Muenchen        |      8 |     5 |             2 |           1 |   21 |         7 |     17 |
|    1 | Borussia Dortmund         |      8 |     6 |             1 |           1 |   23 |         5 |     19 |
+------+---------------------------+--------+-------+---------------+-------------+------+-----------+--------+
```

### 8.) Ermitteln Sie die Gesamtzahl der geschossenen Tore. 

```sql
select sum(tore) as tore_gesamt 
    from bundesliga;
```

Output:

```
+-------------+
| tore_gesamt |
+-------------+
|         187 |
+-------------+
```

### 9.) Ermitteln Sie die durchschnittlich in einem Spiel geschossenen Tore.

```sql
select sum(tore)/sum(spiele) as tore_durchschnitt 
    from bundesliga;
```

Output:

```
+-------------------+
| tore_durchschnitt |
+-------------------+
|            1.2986 |
+-------------------+
``` 

## Überprüfen Sie die folgenden Aufgaben, indem Sie sich die gesamte Tabelle nach Änderung anzeigen lassen.

### 10.) Ein weiterer Spieltag hat stattgefunden. Erhöhen Sie die Spiele auf 9. 

```sql
update bundesliga 
    set spiele = 9;
```

Tabelle nach änderung:

```
+------+---------------------------+--------+-------+---------------+-------------+------+-----------+--------+
| rang | mannschaft                | spiele | siege | unentschieden | niederlagen | tore | gegentore | punkte |
+------+---------------------------+--------+-------+---------------+-------------+------+-----------+--------+
|    1 | Borussia Dortmund         |      9 |     6 |             1 |           1 |   23 |         5 |     19 |
|    2 | FC Bayern Muenchen        |      9 |     5 |             2 |           1 |   21 |         7 |     17 |
|    3 | RB Leipzig                |      9 |     5 |             1 |           2 |   15 |        10 |     16 |
|    4 | Hoffenheim                |      9 |     4 |             3 |           1 |   15 |        10 |     15 |
|    5 | Borussia Moenchengladbach |      9 |     4 |             2 |           2 |   12 |        12 |     14 |
|    6 | Schalke 04                |      9 |     4 |             1 |           3 |   10 |         9 |     13 |
|    7 | Eintracht Frankfurt       |      9 |     4 |             1 |           3 |    8 |         7 |     13 |
|    8 | FC Augsburg               |      9 |     3 |             3 |           2 |   11 |         8 |     12 |
|    9 | Hannover 96               |      9 |     3 |             3 |           2 |    8 |         6 |     12 |
|   10 | Mainz 05                  |      9 |     3 |             1 |           4 |   10 |        13 |     10 |
|   11 | VfB Stuttgart             |      9 |     3 |             1 |           4 |    6 |        10 |     10 |
|   12 | Bayer Leverkusen          |      9 |     2 |             3 |           3 |   15 |        13 |      9 |
|   13 | Hertha BSC                |      9 |     2 |             3 |           3 |    8 |        10 |      9 |
|   14 | VfL Wolfsburg             |      9 |     1 |             5 |           2 |    8 |        11 |      8 |
|   15 | Hamburger SV              |      9 |     2 |             1 |           5 |    6 |        14 |      7 |
|   16 | SC Freiburg               |      9 |     1 |             4 |           3 |    5 |        16 |      7 |
|   17 | Werder Bremen             |      9 |     0 |             4 |           4 |    3 |         9 |      4 |
|   18 | 1. FC Koeln               |      9 |     0 |             1 |           7 |    3 |        17 |      1 |
+------+---------------------------+--------+-------+---------------+-------------+------+-----------+--------+
```

### 11.) Am 9. Spieltag sind alle Spiele 1:1 ausgegangen. Erhöhen Sie Punkte, Tore, Gegentore und Unentschieden jeweils um 1 bei allen Mannschaften.

```sql
update bundesliga set 
    punkte = punkte + 1, 
    tore = tore + 1, 
    gegentore = gegentore + 1, 
    unentschieden = unentschieden + 1;
```

Tabelle nach änderung:

```
+------+---------------------------+--------+-------+---------------+-------------+------+-----------+--------+
| rang | mannschaft                | spiele | siege | unentschieden | niederlagen | tore | gegentore | punkte |
+------+---------------------------+--------+-------+---------------+-------------+------+-----------+--------+
|    1 | Borussia Dortmund         |      9 |     6 |             2 |           1 |   24 |         6 |     20 |
|    2 | FC Bayern Muenchen        |      9 |     5 |             3 |           1 |   22 |         8 |     18 |
|    3 | RB Leipzig                |      9 |     5 |             2 |           2 |   16 |        11 |     17 |
|    4 | Hoffenheim                |      9 |     4 |             4 |           1 |   16 |        11 |     16 |
|    5 | Borussia Moenchengladbach |      9 |     4 |             3 |           2 |   13 |        13 |     15 |
|    6 | Schalke 04                |      9 |     4 |             2 |           3 |   11 |        10 |     14 |
|    7 | Eintracht Frankfurt       |      9 |     4 |             2 |           3 |    9 |         8 |     14 |
|    8 | FC Augsburg               |      9 |     3 |             4 |           2 |   12 |         9 |     13 |
|    9 | Hannover 96               |      9 |     3 |             4 |           2 |    9 |         7 |     13 |
|   10 | Mainz 05                  |      9 |     3 |             2 |           4 |   11 |        14 |     11 |
|   11 | VfB Stuttgart             |      9 |     3 |             2 |           4 |    7 |        11 |     11 |
|   12 | Bayer Leverkusen          |      9 |     2 |             4 |           3 |   16 |        14 |     10 |
|   13 | Hertha BSC                |      9 |     2 |             4 |           3 |    9 |        11 |     10 |
|   14 | VfL Wolfsburg             |      9 |     1 |             6 |           2 |    9 |        12 |      9 |
|   15 | Hamburger SV              |      9 |     2 |             2 |           5 |    7 |        15 |      8 |
|   16 | SC Freiburg               |      9 |     1 |             5 |           3 |    6 |        17 |      8 |
|   17 | Werder Bremen             |      9 |     0 |             5 |           4 |    4 |        10 |      5 |
|   18 | 1. FC Koeln               |      9 |     0 |             2 |           7 |    4 |        18 |      2 |
+------+---------------------------+--------+-------+---------------+-------------+------+-----------+--------+
```

### 12.) Die Saison ist abgeschlossen, die letzten drei Mannschaften steigen ab. Löschen Sie sie aus der Tabelle.

```sql
delete from bundesliga 
    where rang > (select count(*) from bundesliga) - 3;
```

Tabelle nach änderung:

```
+------+---------------------------+--------+-------+---------------+-------------+------+-----------+--------+
| rang | mannschaft                | spiele | siege | unentschieden | niederlagen | tore | gegentore | punkte |
+------+---------------------------+--------+-------+---------------+-------------+------+-----------+--------+
|    1 | Borussia Dortmund         |      9 |     6 |             2 |           1 |   24 |         6 |     20 |
|    2 | FC Bayern Muenchen        |      9 |     5 |             3 |           1 |   22 |         8 |     18 |
|    3 | RB Leipzig                |      9 |     5 |             2 |           2 |   16 |        11 |     17 |
|    4 | Hoffenheim                |      9 |     4 |             4 |           1 |   16 |        11 |     16 |
|    5 | Borussia Moenchengladbach |      9 |     4 |             3 |           2 |   13 |        13 |     15 |
|    6 | Schalke 04                |      9 |     4 |             2 |           3 |   11 |        10 |     14 |
|    7 | Eintracht Frankfurt       |      9 |     4 |             2 |           3 |    9 |         8 |     14 |
|    8 | FC Augsburg               |      9 |     3 |             4 |           2 |   12 |         9 |     13 |
|    9 | Hannover 96               |      9 |     3 |             4 |           2 |    9 |         7 |     13 |
|   10 | Mainz 05                  |      9 |     3 |             2 |           4 |   11 |        14 |     11 |
|   11 | VfB Stuttgart             |      9 |     3 |             2 |           4 |    7 |        11 |     11 |
|   12 | Bayer Leverkusen          |      9 |     2 |             4 |           3 |   16 |        14 |     10 |
|   13 | Hertha BSC                |      9 |     2 |             4 |           3 |    9 |        11 |     10 |
|   14 | VfL Wolfsburg             |      9 |     1 |             6 |           2 |    9 |        12 |      9 |
|   15 | Hamburger SV              |      9 |     2 |             2 |           5 |    7 |        15 |      8 |
+------+---------------------------+--------+-------+---------------+-------------+------+-----------+--------+
```