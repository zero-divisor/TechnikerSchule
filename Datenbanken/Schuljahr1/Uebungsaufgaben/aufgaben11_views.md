### Aufgabe 1

Erstellen Sie eine View Artikelliste, die lediglich die Felder ArtNr und Benennung enthält.

```sql
CREATE OR REPLACE VIEW art_view AS SELECT artnr, benennung FROM artikel;
```

Führen Sie die View aus und lassen sich alle Artikel von 1002 bis 1004 anzeigen.

```sql
select * from art_view where artnr between 1002 and 1004;
```

```
+-------+--------------------------+
| artnr | benennung                |
+-------+--------------------------+
|  1002 | Birne2                   |
|  1003 | Bildzeitung              |
|  1004 | Kochtopf 20cm mit Deckel |
+-------+--------------------------+
```

Ändern Sie anschließend über die View eine Artikelbenennung und prüfen Sie die Änderung in der Tabelle artikel.

```sql
update art_view set benennung = 'Birne2' where artnr = 1002;
```

__Vorher__

```
+-------+--------------------------+-------+----+-------+--------+
| artnr | benennung                | artgr | me | preis | mwstgr |
+-------+--------------------------+-------+----+-------+--------+
|  1001 | Apfel                    |     1 | ST |  0.50 |      2 |
|  1002 | Birne                    |     1 | ST |  0.75 |      2 |
|  1003 | Bildzeitung              |     2 | ST |  1.20 |      2 |
|  1004 | Kochtopf 20cm mit Deckel |     3 | ST | 34.95 |      1 |
|  1005 | Kartoffeln               |     1 | KG |  4.95 |      2 |
|  1006 | Platzhalter1             |     1 | ST |  0.50 |      2 |
|  1007 | Platzhalter2             |     1 | ST |  0.75 |      2 |
+-------+--------------------------+-------+----+-------+--------+
```

__Nacher__

```
+-------+--------------------------+-------+----+-------+--------+
| artnr | benennung                | artgr | me | preis | mwstgr |
+-------+--------------------------+-------+----+-------+--------+
|  1001 | Apfel                    |     1 | ST |  0.50 |      2 |
|  1002 | Birne2                   |     1 | ST |  0.75 |      2 |
|  1003 | Bildzeitung              |     2 | ST |  1.20 |      2 |
|  1004 | Kochtopf 20cm mit Deckel |     3 | ST | 34.95 |      1 |
|  1005 | Kartoffeln               |     1 | KG |  4.95 |      2 |
|  1006 | Platzhalter1             |     1 | ST |  0.50 |      2 |
|  1007 | Platzhalter2             |     1 | ST |  0.75 |      2 |
+-------+--------------------------+-------+----+-------+--------+
```

### Aufgabe 2

Erstellen Sie eine View Lagerbestand, die Artikelnummer, Artikelbenennung und Lagerbestand aller Artikel anzeigt.

```sql
create or replace view lagerbestand AS
    select artikel.artnr, benennung, sum(menge) as ges_menge from artikel
    left join lager on (lager.artnr = artikel.artnr)
    group by artikel.artnr
    order by artikel.artnr asc;
```

Lassen Sie sich den Lagerbestand aller Artikel über die View anzeigen.

```sql
select * from lagerbestand;
```

```
+-------+--------------------------+------------+
| artnr | benennung                |  ges_menge |
+-------+--------------------------+------------+
|  1001 | Apfel                    |        275 |
|  1002 | Birne2                   |         29 |
|  1003 | Bildzeitung              |         54 |
|  1004 | Kochtopf 20cm mit Deckel |         11 |
|  1005 | Kartoffeln               |         34 |
|  1006 | Platzhalter1             |         17 |
|  1007 | Platzhalter2             |          4 |
+-------+--------------------------+------------+
```

Ändern Sie den Lagerbestand bei Artikel 1001.

```sql
update lagerbestand set ges_menge = 1 where artnr = 1001;
```

```
ERROR 1288 (HY000): The target table lagerbestand of the UPDATE is not updatable
```