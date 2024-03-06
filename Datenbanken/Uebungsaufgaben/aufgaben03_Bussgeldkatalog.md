### 1.) Betrachten Sie die bereitgestellte Datei „bussgeld.sql“.

#### a) Was bewirken die SQL-Kommandos in der Datei?

Der erste Befehl erstellt die Tabelle bussgeld.\
Der zweite Befehl füllt die Tabelle mit Daten.

#### b) Was bewirkt „if not exists“ im ersten Kommando?

Der befehl wird nur ausgeführt falls keine Tabelle mit dem Namen bussgeld existiert.

### 2.) Führen Sie die SQL-Datei im MySQL-Client aus.

```sql
source C:/pfad/zur/datei/bussgeld.sql
```

Output

```
Query OK, 0 rows affected (0.011 sec)

Query OK, 20 rows affected (0.015 sec)
Records: 20  Duplicates: 0  Warnings: 0
```

### 3.) Lassen Sie sich den Inhalt der neu erstellten Tabelle anzeigen.

```sql
select * from bussgeld;
```

Output:

```
+--------------+------------+------------+--------+----------+----------------+
| inner_ausser | geschw_von | geschw_bis | punkte | bussgeld | fahrverbot_mon |
+--------------+------------+------------+--------+----------+----------------+
| innerorts    |          1 |         10 |      0 |       15 |              0 |
| innerorts    |         11 |         15 |      0 |       25 |              0 |
| innerorts    |         16 |         20 |      0 |       35 |              0 |
| innerorts    |         21 |         25 |      1 |       80 |              0 |
| innerorts    |         26 |         30 |      1 |      100 |              0 |
| innerorts    |         31 |         40 |      2 |      160 |              1 |
| innerorts    |         41 |         50 |      2 |      200 |              1 |
| innerorts    |         51 |         60 |      2 |      280 |              2 |
| innerorts    |         61 |         70 |      2 |      480 |              3 |
| innerorts    |         71 |        999 |      2 |      680 |              3 |
| ausserorts   |          1 |         10 |      0 |       10 |              0 |
| ausserorts   |         11 |         15 |      0 |       20 |              0 |
| ausserorts   |         16 |         20 |      0 |       30 |              0 |
| ausserorts   |         21 |         25 |      1 |       70 |              0 |
| ausserorts   |         26 |         30 |      1 |       80 |              0 |
| ausserorts   |         31 |         40 |      1 |      120 |              0 |
| ausserorts   |         41 |         50 |      2 |      160 |              1 |
| ausserorts   |         51 |         60 |      2 |      240 |              1 |
| ausserorts   |         61 |         70 |      2 |      440 |              2 |
| ausserorts   |         71 |        999 |      2 |      600 |              3 |
+--------------+------------+------------+--------+----------+----------------+
```

### 4.) Lassen Sie sich alle Bußgelder für Geschwindigkeitsüberschreitungen anzeigen, die außerorts begangen werden.

```sql
select * from bussgeld
    where inner_ausser = 'ausserorts';
```

Output:

```
+--------------+------------+------------+--------+----------+----------------+
| inner_ausser | geschw_von | geschw_bis | punkte | bussgeld | fahrverbot_mon |
+--------------+------------+------------+--------+----------+----------------+
| ausserorts   |          1 |         10 |      0 |       10 |              0 |
| ausserorts   |         11 |         15 |      0 |       20 |              0 |
| ausserorts   |         16 |         20 |      0 |       30 |              0 |
| ausserorts   |         21 |         25 |      1 |       70 |              0 |
| ausserorts   |         26 |         30 |      1 |       80 |              0 |
| ausserorts   |         31 |         40 |      1 |      120 |              0 |
| ausserorts   |         41 |         50 |      2 |      160 |              1 |
| ausserorts   |         51 |         60 |      2 |      240 |              1 |
| ausserorts   |         61 |         70 |      2 |      440 |              2 |
| ausserorts   |         71 |        999 |      2 |      600 |              3 |
+--------------+------------+------------+--------+----------+----------------+
```

### 5.) Lassen Sie sich die Bußgelder sortiert nach Geschwindigkeitsüberschreitung anzeigen in der Reihenfolge innerorts, außerorts.

```sql
select * from bussgeld order by geschw_von asc, inner_ausser desc;
```

Output:

```
+--------------+------------+------------+--------+----------+----------------+
| inner_ausser | geschw_von | geschw_bis | punkte | bussgeld | fahrverbot_mon |
+--------------+------------+------------+--------+----------+----------------+
| innerorts    |          1 |         10 |      0 |       15 |              0 |
| ausserorts   |          1 |         10 |      0 |       10 |              0 |
| innerorts    |         11 |         15 |      0 |       25 |              0 |
| ausserorts   |         11 |         15 |      0 |       20 |              0 |
| innerorts    |         16 |         20 |      0 |       35 |              0 |
| ausserorts   |         16 |         20 |      0 |       30 |              0 |
| innerorts    |         21 |         25 |      1 |       80 |              0 |
| ausserorts   |         21 |         25 |      1 |       70 |              0 |
| innerorts    |         26 |         30 |      1 |      100 |              0 |
| ausserorts   |         26 |         30 |      1 |       80 |              0 |
| innerorts    |         31 |         40 |      2 |      160 |              1 |
| ausserorts   |         31 |         40 |      1 |      120 |              0 |
| innerorts    |         41 |         50 |      2 |      200 |              1 |
| ausserorts   |         41 |         50 |      2 |      160 |              1 |
| innerorts    |         51 |         60 |      2 |      280 |              2 |
| ausserorts   |         51 |         60 |      2 |      240 |              1 |
| innerorts    |         61 |         70 |      2 |      480 |              3 |
| ausserorts   |         61 |         70 |      2 |      440 |              2 |
| innerorts    |         71 |        999 |      2 |      680 |              3 |
| ausserorts   |         71 |        999 |      2 |      600 |              3 |
+--------------+------------+------------+--------+----------+----------------+
```

### 6.) Lassen Sie sich alle Bußgelder für Geschwindigkeitsüberschreitungen anzeigen, die außerorts begangen werden und für die es Punkte gibt.

```sql
select * from bussgeld
    where inner_ausser = 'ausserorts'
    and punkte > 0;
```

Output:

```
+--------------+------------+------------+--------+----------+----------------+
| inner_ausser | geschw_von | geschw_bis | punkte | bussgeld | fahrverbot_mon |
+--------------+------------+------------+--------+----------+----------------+
| ausserorts   |         21 |         25 |      1 |       70 |              0 |
| ausserorts   |         26 |         30 |      1 |       80 |              0 |
| ausserorts   |         31 |         40 |      1 |      120 |              0 |
| ausserorts   |         41 |         50 |      2 |      160 |              1 |
| ausserorts   |         51 |         60 |      2 |      240 |              1 |
| ausserorts   |         61 |         70 |      2 |      440 |              2 |
| ausserorts   |         71 |        999 |      2 |      600 |              3 |
+--------------+------------+------------+--------+----------+----------------+
```

### 7.) Sie sind innerorts 12 km/h zu schnell gefahren. Lassen Sie sich das passende Bußgeld anzeigen.

```sql
select * from bussgeld
    where inner_ausser = 'innerorts'
    and 12 between geschw_von and geschw_bis;
```

Output:

```
+--------------+------------+------------+--------+----------+----------------+
| inner_ausser | geschw_von | geschw_bis | punkte | bussgeld | fahrverbot_mon |
+--------------+------------+------------+--------+----------+----------------+
| innerorts    |         11 |         15 |      0 |       25 |              0 |
+--------------+------------+------------+--------+----------+----------------+
```

### 8.) Lassen Sie sich das durchschnittliche Bußgeld für alle Geschwindigkeiten ausgeben.

```sql
select avg(bussgeld) as average from bussgeld;
```

Output:

```
+----------+
| average  |
+----------+
| 191.2500 |
+----------+
```

### 9.) Lassen Sie sich das durchschnittliche Bußgeld für alle Geschwindigkeiten ausgeben, getrennt nach innerorts und außerorts (nur 1 Select-Kommando!).

```sql
select inner_ausser, avg(bussgeld) as average 
    from bussgeld 
    group by inner_ausser;
```

Output:

```
+--------------+----------+
| inner_ausser | average  |
+--------------+----------+
| ausserorts   | 177.0000 |
| innerorts    | 205.5000 |
+--------------+----------+
```
