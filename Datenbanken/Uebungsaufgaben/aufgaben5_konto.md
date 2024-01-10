### 1. Erstellen Sie eine Tabelle mit dem Namen „konto“ welche die folgenden Felder beinhaltet:

|Feldname|Bedingungen|
|-|-|
|nr|Ganzzahlig, primärer Schlüssel, automatischer Wert|
|datum|Datumsfeld (Datentyp date), nicht leer|
|verwendung|Textfeld mit 30 Stellen, nicht leer
|betrag|Dezimalzahl, 8-stellig mit 2 Nachkommastellen, nicht leer

```sql
create table konto (
    nr int primary key auto_increment, 
    datum date not null, 
    verwendung varchar(30) not null, 
    betrag decimal(8, 2) not null
);
```

```
+------------+--------------+------+-----+---------+----------------+
| Field      | Type         | Null | Key | Default | Extra          |
+------------+--------------+------+-----+---------+----------------+
| nr         | int(11)      | NO   | PRI | NULL    | auto_increment |
| datum      | date         | NO   |     | NULL    |                |
| verwendung | varchar(30)  | NO   |     | NULL    |                |
| betrag     | decimal(8,2) | NO   |     | NULL    |                |
+------------+--------------+------+-----+---------+----------------+
```


### 2. Füllen Sie die Tabelle Konto mit den bereitgestellten Datensätzen aus der Datei „konto.csv“.

```sql
load data local infile 'C:/pfad/zur/datei/konto.csv'
    into table konto 
    fields terminated by ';'
    lines terminated by '\n';
```

```
+----+------------+---------------------------+---------+
| nr | datum      | verwendung                | betrag  |
+----+------------+---------------------------+---------+
|  1 | 2020-09-01 | Gehalt 09/2020            | 2717.32 |
|  2 | 2020-09-02 | Miete 09/2020             | -850.00 |
|  3 | 2020-09-02 | Strom 09/2020             |  -66.00 |
|  4 | 2020-09-02 | Heizung 09/2020           |  -40.00 |
|  5 | 2020-09-02 | Wasser 09/2020            |  -50.00 |
|  6 | 2020-09-04 | Tanken                    |  -72.30 |
|  7 | 2020-09-04 | Einkaufen                 |  -54.13 |
|  8 | 2020-09-14 | Tanken                    |  -33.67 |
|  9 | 2020-09-15 | Einkaufen                 |  -88.77 |
| 10 | 2020-09-22 | Tanken                    |  -48.88 |
| 11 | 2020-09-22 | Einkaufen                 |  -25.17 |
| 12 | 2020-09-28 | Tanken                    |  -23.45 |
| 13 | 2020-09-29 | Einkaufen                 | -108.54 |
| 14 | 2020-09-30 | Essen gehen               |  -55.00 |
| 15 | 2020-10-01 | Gehalt 10/2020            | 2717.32 |
| 16 | 2020-10-02 | Miete 10/2020             | -850.00 |
| 17 | 2020-10-02 | Strom 10/2020             |  -66.00 |
| 18 | 2020-10-02 | Heizung 10/2020           |  -40.00 |
| 19 | 2020-10-02 | Wasser 10/2020            |  -50.00 |
| 20 | 2020-10-03 | Versicherung Auto Q4/2020 | -555.22 |
| 21 | 2020-10-04 | Tanken                    |  -70.13 |
| 22 | 2020-10-04 | Einkaufen                 |  -52.50 |
| 23 | 2020-10-14 | Tanken                    |  -32.65 |
| 24 | 2020-10-15 | Einkaufen                 |  -86.10 |
| 25 | 2020-10-22 | Tanken                    |  -47.41 |
| 26 | 2020-10-22 | Einkaufen                 |  -24.41 |
| 27 | 2020-10-28 | Tanken                    |  -22.74 |
| 28 | 2020-10-28 | Einkaufen                 | -105.28 |
| 29 | 2020-10-28 | Essen gehen               |  -48.00 |
| 30 | 2020-11-01 | Gehalt 11/2020            | 2717.32 |
| 31 | 2020-11-02 | Miete 11/2020             | -850.00 |
| 32 | 2020-11-02 | Strom 11/2020             |  -66.00 |
| 33 | 2020-11-02 | Heizung 11/2020           |  -40.00 |
| 34 | 2020-11-02 | Wasser 11/2020            |  -50.00 |
| 35 | 2020-11-04 | Tanken                    |  -80.64 |
| 36 | 2020-11-04 | Einkaufen                 |  -60.37 |
| 37 | 2020-11-14 | Tanken                    |  -37.54 |
| 38 | 2020-11-15 | Einkaufen                 |  -99.01 |
| 39 | 2020-11-22 | Tanken                    |  -54.52 |
| 40 | 2020-11-22 | Einkaufen                 |  -28.07 |
| 41 | 2020-11-28 | Tanken                    |  -26.15 |
| 42 | 2020-11-28 | Einkaufen                 | -121.07 |
| 43 | 2020-11-28 | Essen gehen               |  -55.20 |
+----+------------+---------------------------+---------+
```

### 3. Fügen Sie das Gehalt und die Miete des Monats Dezembers ein (Beträge wie die Monate zuvor, können als Zahl direkt angegeben werden).

```sql
insert into konto 
    (datum, verwendung, betrag)
    values
    ('2020-12-01', 'Gehalt 12/2020', 2717.32),
    ('2020-12-02', 'Miete 12/2020', -850.00);
```

### 4. Lassen Sie sich den aktuellen Kontostand anzeigen.

```sql
select sum(betrag) as kontostand from konto;
```

```
+------------+
| kontostand |
+------------+
|    4884.36 |
+------------+
```

### 5. Lassen Sie sich alle Kontobewegungen des 1.11.2020 anzeigen.

```sql
select verwendung, betrag from konto where datum = '2020-11-01';
```

```
+----------------+---------+
| verwendung     | betrag  |
+----------------+---------+
| Gehalt 11/2020 | 2717.32 |
+----------------+---------+
```

### 6. Lassen Sie sich alle Kontobewegungen des Monats November anzeigen.

```sql
select verwendung, betrag from konto where month(datum) = 11;
```

```
+-----------------+---------+
| verwendung      | betrag  |
+-----------------+---------+
| Gehalt 11/2020  | 2717.32 |
| Miete 11/2020   | -850.00 |
| Strom 11/2020   |  -66.00 |
| Heizung 11/2020 |  -40.00 |
| Wasser 11/2020  |  -50.00 |
| Tanken          |  -80.64 |
| Einkaufen       |  -60.37 |
| Tanken          |  -37.54 |
| Einkaufen       |  -99.01 |
| Tanken          |  -54.52 |
| Einkaufen       |  -28.07 |
| Tanken          |  -26.15 |
| Einkaufen       | -121.07 |
| Essen gehen     |  -55.20 |
+-----------------+---------+
```

### 7. Lassen Sie sich die Mehrwertsteuer aller vorhandenen Ausgaben (voll MwSt.-Satz von 19%) als Summe anzeigen.

```sql
select sum(-betrag*0.19) as mwst_sum 
    from konto 
    where betrag < 0;
```

```
+-----------+
| mwst_sum  |
+-----------+
| 1137.1348 |
+-----------+
```

### 8. Lassen Sie sich die Mehrwertsteuer aller vorhandenen Ausgaben (voll MwSt.-Satz von 19%) als monatliche Summe anzeigen.

```sql
select month(datum) as m, year(datum) as y, sum(-betrag*0.19) as mwst_sum 
    from konto 
    where betrag < 0
    group by month(datum), year(datum)
    order by datum;
```

```
+------+------+----------+
| m    | y    | mwst_sum |
+------+------+----------+
|    9 | 2020 | 288.0229 |
|   10 | 2020 | 389.5836 |
|   11 | 2020 | 298.0283 |
|   12 | 2020 | 161.5000 |
+------+------+----------+
```

### 9. Duplizieren Sie alle Datensätze des Jahres 2020 in das Jahr 2021 (gleiches Tagesdatum) – ein SQL-Kommando!

```sql
insert into konto (datum, verwendung, betrag)
    select datum, verwendung, betrag
    from konto;
    
    #########################################
    todo
```

### 10. Erhöhen Sie alle Beträge des Jahres 2021 um 10%.

### 11. Passen Sie die Verwendungstexte in ihrer Jahreszahl an (alle Vorkommen von 2020 in 2021 ändern).

### 12. Geben Sie die Ersparnisse (Einkünfte – Ausgaben) nach Jahren aus.

### 13. Geben Sie alle Einnahmen und Ausgaben gruppiert nach Verwendung aus (ohne Berücksichtigung des Monats/Jahres durch Beschränkung auf die ersten 6 Zeichen).