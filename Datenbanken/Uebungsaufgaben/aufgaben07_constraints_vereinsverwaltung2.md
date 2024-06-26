### 1.) Die Verknüpfungstabelle zwischen Mitglied und Sparte darf nur Schlüsselnummern aus der entsprechenden Stammdatentabelle enthalten.

+ Sichern Sie die Verknüpfungstabelle entsprechend ab.

```sql
alter table sparten_zuordnung 
    add constraint fk_mnr 
    foreign key (mnr) 
    references mitglieder(mnr);

alter table sparten_zuordnung 
    add constraint fk_snr 
    foreign key (snr) 
    references sparten(snr);
```

+ Testen Sie anschließend was passiert, wenn Sie einen nicht vorhandenen Schlüssel einfügen oder wenn Sie versuchen, eine Sparte zu löschen, die ein Mitglied enthält.

__Nicht vorhandenen Schlüssel einfügen:__

```sql
insert into sparten_zuordnung values(10,10);
```

```
ERROR 1452 (23000): Cannot add or update a child row: a foreign key constraint fails (`est`.`sparten_zuordnung`, CONSTRAINT `fk_mnr` FOREIGN KEY (`mnr`) REFERENCES `mitglieder` (`mnr`))
```

__Sparte löschen, die ein Mitglied enthält:__

```sql
delete from sparten where snr=1;
```

```
ERROR 1451 (23000): Cannot delete or update a parent row: a foreign key constraint fails (`est`.`sparten_zuordnung`, CONSTRAINT `fk_snr` FOREIGN KEY (`snr`) REFERENCES `sparten` (`snr`))
```

### 2.) Erstellen Sie eine neue Tabelle zur Erfassung der Mitgliedsbeiträge je Kalenderjahr.

1. Welche Felder und Datentypen muss diese Tabelle enthalten? 

   + `mnr int not null`
   + `jahr int not null`
   + `vorname` + `nachname` wie bei `mitglieder`. Falls ein mitglied den Verein verlässt sollten Name und Vorname immer noch in der DB stehen, um alte Beiträge zuordnen zu können. Eventuell entstehende Abweichungen, falls ein Mitglied seinen Namen ändert, sind ok, da die Einträge in dieser Tabelle reflektieren, was zu einem bestimmten Zeitpunkt war.
   + `beitrag decimal(8, 2) not null`

1. Wie wählen Sie den Primary Key?

   + `mnr` + `jahr`

1. Sollten Sie auch hier einen Constraint anlegen?

   + Constraints sind ungeschickt, da Mitglieder, die den Verein verlassen in der Mitgliedsbeiträge-Tabelle bleiben sollten, aber nicht in der Mitglieder-Tabelle.

```sql
create table mitglieds_beitraege(
    mnr int not null,
    jahr int not null,
    name varchar(20) not null,
    vorname varchar(20) not null,
    beitrag decimal(8, 2) not null,
    primary key (mnr, jahr)
);
```


### 3.) Erweitern Sie die Tabelle Sparten um den Jahresbeitrag.

Tragen Sie dazu die folgenden Werte ein:

+ Tennis: 95,-€
+ Fußball: 25,-€
+ Kegeln: 40,-€
+ Volleyball: 35,-€
+ Tischtennis: 30,-€

```sql
alter table sparten add jahresbeitrag decimal(5, 2);

update sparten set jahresbeitrag = 95.00 where snr = 1;
update sparten set jahresbeitrag = 25.00 where snr = 2;
update sparten set jahresbeitrag = 40.00 where snr = 3;
update sparten set jahresbeitrag = 35.00 where snr = 4;
update sparten set jahresbeitrag = 30.00 where snr = 5;
```

```
+-----+-------------+---------------+
| snr | name        | jahresbeitrag |
+-----+-------------+---------------+
|   1 | Tennis      |         95.00 |
|   2 | Fußball     |         25.00 |
|   3 | Kegeln      |         40.00 |
|   4 | Volleyball  |         35.00 |
|   5 | Tischtennis |         30.00 |
+-----+-------------+---------------+
```

### 4.) Füllen Sie die Tabelle für die Mitgliedsbeiträge mit den Beiträgen für das Jahr 2021. 

Schaffen Sie das mit einer SQL-Anweisung unter Verwendung der existierenden Daten?

```sql
insert into mitglieds_beitraege(mnr, jahr, name, vorname, beitrag)
    select mitglieder.mnr, 2021, mitglieder.name, vorname, sum(jahresbeitrag)
    from mitglieder
    join sparten_zuordnung 
    on (mitglieder.mnr = sparten_zuordnung.mnr)
    join sparten
    on (sparten.snr = sparten_zuordnung.snr)
    group by mitglieder.mnr;
```

`select * from mitgliedsbeitraege;`

```
+-----+------+---------+---------+---------+
| mnr | jahr | name    | vorname | beitrag |
+-----+------+---------+---------+---------+
|   1 | 2021 | Maier   | Hans    |  135.00 |
|   2 | 2021 | Müller  | Josef   |  195.00 |
|   3 | 2021 | Schmid  | Karl    |   95.00 |
|   4 | 2021 | Schulze | Michael |   75.00 |
|   5 | 2021 | Schmid  | Udo     |   30.00 |
+-----+------+---------+---------+---------+
```

### 5.) Erstellen Sie die Jahresrechnung für Ihre Mitglieder. Dazu soll über einen Select die folgende die Ausgabe erzeugt werden.

```
Sehr geehrter Herr Hans Maier, bitte überweisen Sie den Betrag von 135.00 auf unser Konto.
Sehr geehrter Herr Josef Müller, bitte überweisen Sie den Betrag von 195.00 auf unser Konto.
Sehr geehrter Herr Karl Schmid, bitte überweisen Sie den Betrag von 95.00 auf unser Konto.
Sehr geehrter Herr Michael Schulze, bitte überweisen Sie den Betrag von 75.00 auf unser Konto.
Sehr geehrter Herr Udo Schmid, bitte überweisen Sie den Betrag von 30.00 auf unser Konto.
```

```sql
select 
    concat(
        'Sehr geehrter Herr ', 
        vorname, 
        ' ', 
        mitglieder.name, 
        ', bitte überweisen Sie den Betrag von ',
        sum(jahresbeitrag),
        ' auf unser Konto.'
    ) as message
    from mitglieder
    join sparten_zuordnung 
    on (mitglieder.mnr = sparten_zuordnung.mnr)
    join sparten
    on (sparten.snr = sparten_zuordnung.snr)
    group by mitglieder.mnr;
```

```
+------------------------------------------------------------------------------------------------+
| message                                                                                        |
+------------------------------------------------------------------------------------------------+
| Sehr geehrter Herr Hans Maier, bitte überweisen Sie den Betrag von 135.00 auf unser Konto.     |
| Sehr geehrter Herr Josef Müller, bitte überweisen Sie den Betrag von 195.00 auf unser Konto.   |
| Sehr geehrter Herr Karl Schmid, bitte überweisen Sie den Betrag von 95.00 auf unser Konto.     |
| Sehr geehrter Herr Michael Schulze, bitte überweisen Sie den Betrag von 75.00 auf unser Konto. |
| Sehr geehrter Herr Udo Schmid, bitte überweisen Sie den Betrag von 30.00 auf unser Konto.      |
+------------------------------------------------------------------------------------------------+
```

### 6.) Nun tritt die erste Frau in Ihren Verein ein. Die Anrede der Jahresrechnung passt so nicht mehr. 

+ Erweitern Sie die Tabelle Mitglieder um das Feld „geschlecht“ und setzen Sie die Werte der bestehenden Mitglieder auf „m“.

```sql
alter table mitglieder add geschlecht char(1) not null;

update mitglieder set geschlecht = 'm';
```

+ Richten Sie das Feld "geschlecht" so ein, dass nur "m" und "w" zulässig sind. 

```sql
alter table mitglieder 
    add constraint check_mw 
    check(geschlecht = 'm' or geschlecht = 'w');
```

+ Fügen Sie anschließend ein weibliches Mitglied ein und weisen Sie sie einer Sparte zu.

```sql
insert into mitglieder(
    name,
    vorname,
    strasse,
    plz,
    ort,
    geschlecht
)Values(
    'Müller',
    'Maria',
    'Rosenweg 8',
    12346,
    'Neu-Glückstadt',
    'w'
);

insert into sparten_zuordnung(mnr, snr) values(6, 1);
```

### 7.) Nun muss die Tabelle „beitraege“ aktualisiert werden. Erstellen Sie dazu einen insert-Befehl, der nur noch Mitglieder berücksichtigt, die noch nicht in der Beitrags-Tabelle vorhanden sind.

```sql
insert into mitglieds_beitraege(mnr, jahr, name, vorname, beitrag)
    select mitglieder.mnr, 2021, mitglieder.name, vorname, sum(jahresbeitrag)
    from mitglieder
    join sparten_zuordnung 
    on (mitglieder.mnr = sparten_zuordnung.mnr)
    join sparten
    on (sparten.snr = sparten_zuordnung.snr)
    where mitglieder.mnr not in (
        select mitglieds_beitraege.mnr from mitglieds_beitraege
    )
    group by mitglieder.mnr;
```

### 8.) Zuletzt passen Sie den Select für die Jahresrechnung an um die korrekte Anrede auszugeben.

```sql
select 
    concat(
        'Sehr geehrte', 
        if(geschlecht = 'm','r Herr ', ' Frau '),
        vorname, 
        ' ', 
        mitglieder.name, 
        ', bitte überweisen Sie den Betrag von ',
        sum(jahresbeitrag),
        ' auf unser Konto.'
    ) as message
    from mitglieder
    join sparten_zuordnung 
    on (mitglieder.mnr = sparten_zuordnung.mnr)
    join sparten
    on (sparten.snr = sparten_zuordnung.snr)
    group by mitglieder.mnr;
```

```
+------------------------------------------------------------------------------------------------+
| message                                                                                        |
+------------------------------------------------------------------------------------------------+
| Sehr geehrter Herr Hans Maier, bitte überweisen Sie den Betrag von 135.00 auf unser Konto.     |
| Sehr geehrter Herr Josef Müller, bitte überweisen Sie den Betrag von 195.00 auf unser Konto.   |
| Sehr geehrter Herr Karl Schmid, bitte überweisen Sie den Betrag von 95.00 auf unser Konto.     |
| Sehr geehrter Herr Michael Schulze, bitte überweisen Sie den Betrag von 75.00 auf unser Konto. |
| Sehr geehrter Herr Udo Schmid, bitte überweisen Sie den Betrag von 30.00 auf unser Konto.      |
| Sehr geehrte Frau Maria Müller, bitte überweisen Sie den Betrag von 95.00 auf unser Konto.     |
+------------------------------------------------------------------------------------------------+
```