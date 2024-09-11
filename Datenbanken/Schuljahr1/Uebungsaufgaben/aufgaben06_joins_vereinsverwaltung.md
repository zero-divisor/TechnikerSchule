Sie sollen in Ihrem Sportverein die Vereinsverwaltung übernehmen. Von Ihrem Vorgänger erhalten Sie dazu Zugriff auf die Datenbank.

Ziemlich schnell stellen Sie fest, dass Ihr Vorgänger von Datenbanken nicht all zu viel Ahnung hatte, hat er doch alle Informationen in einer Tabelle gespeichert.

So machen Sie es sich zur Aufgabe, den bestehenden Datenbestand in eine vernünftige Datenstruktur zu überführen.


## Datenbereinigung

### 1.) Laden Sie die Vereinsdaten indem Sie das SQL-Skript „verein.sql“ ausführen. Analysieren Sie die Datenstruktur und die vorhandenen Daten.

```sql
-- hatte bei mir Probleme mit den Umlauten
source /pfad/zur/datei/verein.sql;
```

```sql
describe mitglieder;
```

```
+---------+-------------+------+-----+---------+----------------+
| Field   | Type        | Null | Key | Default | Extra          |
+---------+-------------+------+-----+---------+----------------+
| mnr     | int(5)      | NO   | PRI | NULL    | auto_increment |
| name    | varchar(30) | NO   |     | NULL    |                |
| vorname | varchar(30) | NO   |     | NULL    |                |
| strasse | varchar(30) | NO   |     | NULL    |                |
| plz     | varchar(5)  | NO   |     | NULL    |                |
| ort     | varchar(30) | NO   |     | NULL    |                |
| sparte  | varchar(30) | NO   |     | NULL    |                |
+---------+-------------+------+-----+---------+----------------+
```

```sql
select * from mitglieder;
```

```
+-----+---------+---------+-----------------------+-------+----------------+-------------+
| mnr | name    | vorname | strasse               | plz   | ort            | sparte      |
+-----+---------+---------+-----------------------+-------+----------------+-------------+
|   1 | Maier   | Hans    | Veilchenweg 5         | 12345 | Glückstadt     | Tennis      |
|   2 | Müller  | Josef   | Rosenweg 8            | 12346 | Neu-Glückstadt | Fußball     |
|   3 | Schmid  | Karl    | Im Löwenzahn 12       | 12346 | Neu-Glückstadt | Tennis      |
|   4 | Müller  | Josef   | Rosenweg 8            | 12346 | Neu-Glückstadt | Tennis      |
|   5 | Maier   | Hans    | Veilchenweg 5         | 12345 | Glückstadt     | Kegeln      |
|   6 | Müller  | Josef   | Rosenweg 8            | 12346 | Neu-Glückstadt | Kegeln      |
|   7 | Schulze | Michael | Sonnenblumenstraße 34 | 12345 | Glückstadt     | Volleyball  |
|   8 | Müller  | Josef   | Rosenweg 8            | 12346 | Neu-Glückstadt | Volleyball  |
|   9 | Schulze | Michael | Sonnenblumenstraße 34 | 12345 | Glückstadt     | Kegeln      |
|  10 | Schmid  | Udo     | Sonnenblumenstraße 54 | 12345 | Glückstadt     | Tischtennis |
+-----+---------+---------+-----------------------+-------+----------------+-------------+
```

### 2.) Erstellen Sie eine Tabelle zur Speicherung der Sparten (snr (primary key, auto_increment), name (not null)).

```sql
create table sparten (
    snr int primary key auto_increment,
    name varchar(20) not null
);
```

```
+-------+-------------+------+-----+---------+----------------+
| Field | Type        | Null | Key | Default | Extra          |
+-------+-------------+------+-----+---------+----------------+
| snr   | int(11)     | NO   | PRI | NULL    | auto_increment |
| name  | varchar(20) | NO   |     | NULL    |                |
+-------+-------------+------+-----+---------+----------------+
```

### 3.) Füllen Sie die Sparten-Tabelle mit den Sparten aus der Mitglieder-Tabelle. Achten Sie darauf, dass jeder Sparte nur 1x angelegt wird.

```sql
insert into sparten (name) select distinct sparte from mitglieder;
```

```
+-----+-------------+
| snr | name        |
+-----+-------------+
|   1 | Tennis      |
|   2 | Fußball     |
|   3 | Kegeln      |
|   4 | Volleyball  |
|   5 | Tischtennis |
+-----+-------------+
```

### 4.) Erstellen Sie eine Tabelle zur Verknüpfung der Mitglieder mit den Sparten (mnr, snr). Beide Felder zusammen sollen den PK bilden.

```sql
create table sparten_zuordnung (
    mnr int not null,
    snr int not null,
    primary key (mnr, snr)
);
```

```
+-------+---------+------+-----+---------+-------+
| Field | Type    | Null | Key | Default | Extra |
+-------+---------+------+-----+---------+-------+
| mnr   | int(11) | NO   | PRI | NULL    |       |
| snr   | int(11) | NO   | PRI | NULL    |       |
+-------+---------+------+-----+---------+-------+
```

### 5.) Füllen Sie die Verknüpfungstabelle für Mitglieder und Sparten mit den Werten aus der Mitgliedertabelle.

```sql
insert into sparten_zuordnung (mnr, snr)
    select mnr, snr from mitglieder 
    inner join sparten
    on (sparten.name = sparte);
```

```
+-----+-----+
| mnr | snr |
+-----+-----+
|   1 |   1 |
|   2 |   2 |
|   3 |   1 |
|   4 |   1 |
|   5 |   3 |
|   6 |   3 |
|   7 |   4 |
|   8 |   4 |
|   9 |   3 |
|  10 |   5 |
+-----+-----+
```

### 6.) Nachdem nun die Sparten übernommen wurden löschen Sie die entsprechende Spalte aus der Mitgliedertabelle.

```sql
alter table mitglieder
    drop column sparte;
```

### 7.) Nun müssen noch die doppelten Mitgliedsnamen entfernt werden. Gehen Sie dabei wie folgt vor (in den SQL-Statements kommen keine Daten vor!):

+ Erstellen einer Tabelle „mitglieder2“, Übernahme der Struktur von „mitglieder“!

```sql
create table mitglieder2 like mitglieder;
```

+ Übernahme der Mitglieder in die neue Tabelle ohne Duplikate.

```sql
insert into mitglieder2 
    (name, vorname, strasse, plz, ort) 
    select distinct name, vorname, strasse, plz, ort
    from mitglieder;
```

```
+-----+---------+---------+-----------------------+-------+----------------+
| mnr | name    | vorname | strasse               | plz   | ort            |
+-----+---------+---------+-----------------------+-------+----------------+
|   1 | Maier   | Hans    | Veilchenweg 5         | 12345 | Glückstadt     |
|   2 | Müller  | Josef   | Rosenweg 8            | 12346 | Neu-Glückstadt |
|   3 | Schmid  | Karl    | Im Löwenzahn 12       | 12346 | Neu-Glückstadt |
|   4 | Schulze | Michael | Sonnenblumenstraße 34 | 12345 | Glückstadt     |
|   5 | Schmid  | Udo     | Sonnenblumenstraße 54 | 12345 | Glückstadt     |
+-----+---------+---------+-----------------------+-------+----------------+
```

+ Korrektur der der Mitgliedernummer in der Verknüpfungstabelle zu den Sparten.

```sql
update sparten_zuordnung
    set sparten_zuordnung.mnr = (
        select mitglieder2.mnr as newmnr
        from mitglieder
        inner join mitglieder2
        on (
            mitglieder.name = mitglieder2.name
            and mitglieder.vorname = mitglieder2.vorname
            and mitglieder.strasse = mitglieder2.strasse
            and mitglieder.plz = mitglieder2.plz
            and mitglieder.ort = mitglieder2.ort
        )
        where sparten_zuordnung.mnr = mitglieder.mnr
    );
```

__Alternativ:__

```sql
update sparten_zuordnung 
    inner join mitglieder on (
        mitglieder.mnr = sparten_zuordnung.mnr
    ) 
    inner join mitglieder2 on (
        mitglieder2.name = mitglieder.name
        and mitglieder2.vorname = mitglieder.vorname
        and mitglieder.strasse = mitglieder2.strasse
        and mitglieder.plz = mitglieder2.plz
        and mitglieder.ort = mitglieder2.ort
    )
    set sparten_zuordnung.mnr = mitglieder2.mnr
    where sparten_zuordnung.mnr = mitglieder.mnr;
```

```
+-----+-----+
| mnr | snr |
+-----+-----+
|   1 |   1 |
|   1 |   3 |
|   2 |   1 |
|   2 |   2 |
|   2 |   3 |
|   2 |   4 |
|   3 |   1 |
|   4 |   3 |
|   4 |   4 |
|   5 |   5 |
+-----+-----+
```

+ Löschen der Tabelle „mitglieder“.

```sql
drop table mitglieder;
```

+ Umbenennen der Tabelle „mitglieder2“ in „mitglieder“.

```sql
alter table mitglieder2 rename to mitglieder;
```

## Auswertungen

### 8.) Erzeugen Sie die gleiche Ausgabe wie die ursprüngliche Tabelle.

```sql
select 
    mitglieder.mnr, 
    mitglieder.name, 
    vorname, 
    strasse, 
    plz, 
    ort, 
    spt.name as sparte
from mitglieder 
left join (
    select mnr, sparten.name 
    from sparten_zuordnung
    left join sparten
    on (sparten_zuordnung.snr = sparten.snr)
) as spt 
on (mitglieder.mnr = spt.mnr);
```

__Alternativ:__

```sql
select 
    mitglieder.mnr, 
    mitglieder.name, 
    vorname, 
    strasse, 
    plz, 
    ort, 
    sparten.name as sparte
from mitglieder 
inner join sparten_zuordnung
    on (sparten_zuordnung.mnr = mitglieder.mnr)
inner join sparten 
    on (sparten.snr = sparten_zuordnung.snr);
```

```
+-----+---------+---------+-----------------------+-------+----------------+-------------+
| mnr | name    | vorname | strasse               | plz   | ort            | sparte      |
+-----+---------+---------+-----------------------+-------+----------------+-------------+
|   1 | Maier   | Hans    | Veilchenweg 5         | 12345 | Glückstadt     | Tennis      |
|   1 | Maier   | Hans    | Veilchenweg 5         | 12345 | Glückstadt     | Kegeln      |
|   2 | Müller  | Josef   | Rosenweg 8            | 12346 | Neu-Glückstadt | Tennis      |
|   2 | Müller  | Josef   | Rosenweg 8            | 12346 | Neu-Glückstadt | Fußball     |
|   2 | Müller  | Josef   | Rosenweg 8            | 12346 | Neu-Glückstadt | Kegeln      |
|   2 | Müller  | Josef   | Rosenweg 8            | 12346 | Neu-Glückstadt | Volleyball  |
|   3 | Schmid  | Karl    | Im Löwenzahn 12       | 12346 | Neu-Glückstadt | Tennis      |
|   4 | Schulze | Michael | Sonnenblumenstraße 34 | 12345 | Glückstadt     | Kegeln      |
|   4 | Schulze | Michael | Sonnenblumenstraße 34 | 12345 | Glückstadt     | Volleyball  |
|   5 | Schmid  | Udo     | Sonnenblumenstraße 54 | 12345 | Glückstadt     | Tischtennis |
+-----+---------+---------+-----------------------+-------+----------------+-------------+
```

### 9.) Lassen Sie sich Name und Vorname von allen Mitgliedern ausgeben, die Tennis spielen.

```sql
select mitglieder.name, vorname 
    from mitglieder
    inner join sparten_zuordnung
    on (mitglieder.mnr = sparten_zuordnung.mnr)
    where sparten_zuordnung.snr = (
        select sparten.snr from sparten where sparten.name = 'Tennis'
    );
```

__Alternativ:__

```sql
select mitglieder.name, vorname from mitglieder 
inner join sparten_zuordnung 
    on (mitglieder.mnr = sparten_zuordnung.mnr) 
inner join sparten 
    on (sparten_zuordnung.snr = sparten.snr) 
where sparten_zuordnung.name = "Tennis";
```

```
+--------+---------+
| name   | vorname |
+--------+---------+
| Maier  | Hans    |
| Müller | Josef   |
| Schmid | Karl    |
+--------+---------+
```

### 10.) Lassen Sie sich die Anzahl Mitglieder je Sparte ausgeben (Spartennummer, Spartenname, Anzahl Mitglieder).

```sql
select
    sparten.snr, 
    name as spartenname, 
    count(mnr) as anzahl
from sparten
left join sparten_zuordnung
on (sparten.snr = sparten_zuordnung.snr)
group by sparten.snr;
```

```
+-----+-------------+--------+
| snr | spartenname | anzahl |
+-----+-------------+--------+
|   1 | Tennis      |      3 |
|   2 | Fußball     |      1 |
|   3 | Kegeln      |      3 |
|   4 | Volleyball  |      2 |
|   5 | Tischtennis |      1 |
+-----+-------------+--------+
```