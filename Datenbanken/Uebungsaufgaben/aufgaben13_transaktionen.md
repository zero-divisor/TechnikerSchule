### Aufgabe

+ Lagern Sie in einer Transaktion 5 Äpfel von Lager 2 in Lager 1 um. 

+ Testen Sie nach jedem Schritt mit SELECT den Lagerbestand. 

+ Melden Sie sich über ein zweites Fenster ein weiteres Mal an der Datenbank an und prüfen Sie von dieser Seite aus nach jedem Schritt im ersten Fenster mit SELECT den Lagerbestand.

### Schritt 1

```sql
begin;
update lager set menge = menge - 5 where artnr = 1001 and lagnr = 2;
```

```
Query OK, 1 row affected (0.014 sec)
Rows matched: 1  Changed: 1  Warnings: 0
```

#### Select Zum überprüfen:

```sql
select * from lager where artnr = 1001;
```

```
+-------+-------+-------+
| lagnr | artnr | menge |
+-------+-------+-------+
|     1 |  1001 |   122 |
|     2 |  1001 |   148 |
+-------+-------+-------+
```

#### Mit anderem login:

```sql
select * from lager where artnr = 1001;
```

```
+-------+-------+-------+
| lagnr | artnr | menge |
+-------+-------+-------+
|     1 |  1001 |   122 |
|     2 |  1001 |   153 |
+-------+-------+-------+
```

### Schritt 2

```sql
update lager set menge = menge + 5 where artnr = 1001 and lagnr = 1;
```

```
Query OK, 1 row affected (0.000 sec)
Rows matched: 1  Changed: 1  Warnings: 0
```

#### Select zum überprüfen:

```sql
select * from lager where artnr = 1001;
```

```
+-------+-------+-------+
| lagnr | artnr | menge |
+-------+-------+-------+
|     1 |  1001 |   127 |
|     2 |  1001 |   148 |
+-------+-------+-------+
```

#### Mit anderem login:

```sql
select * from lager where artnr = 1001;
```

```
+-------+-------+-------+
| lagnr | artnr | menge |
+-------+-------+-------+
|     1 |  1001 |   122 |
|     2 |  1001 |   153 |
+-------+-------+-------+
```

### Schritt 3

```sql
commit;
```

```
Query OK, 0 rows affected (0.002 sec)
```

#### Select zum überprüfen:

```sql
select * from lager where artnr = 1001;
```

```
+-------+-------+-------+
| lagnr | artnr | menge |
+-------+-------+-------+
|     1 |  1001 |   127 |
|     2 |  1001 |   148 |
+-------+-------+-------+
```

#### Mit anderem login:

```sql
select * from lager where artnr = 1001;
```

```
+-------+-------+-------+
| lagnr | artnr | menge |
+-------+-------+-------+
|     1 |  1001 |   127 |
|     2 |  1001 |   148 |
+-------+-------+-------+
```