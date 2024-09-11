### Aufgabe 1

Erstellen Sie die Datenstruktur wie in den folgenden Kommandos angegeben.

```sql
drop table if exists tierarten;
drop table if exists tiere;
drop table if exists gehege;
drop table if exists tiere_gehege;

create table tierarten(
  tierartnr int primary key auto_increment,
  name      varchar(30) not null
);

create table tiere(
  tiernr      int primary key auto_increment,
  tierartnr   int not null,
  name        varchar(20),
  geburtstag  date not null,
  todestag    date
);

create table gehege(
  gehegenr    int primary key auto_increment,
  name        varchar(20),
  groesse     int not null
);

create table tiere_gehege(
  tiernr         int,
  gehegenr       int,
  in_gehege_seit date not null,
  primary key (tiernr, gehegenr)
);

insert into tierarten values
(NULL, "Tiger"),
(NULL, "Zebra");

insert into tiere values
(NULL, 1, "Shirkan", "2002-03-01", "2019-06-30"),
(NULL, 1, "Mogli",   "2005-05-01", NULL),
(NULL, 2, "Bambi",   "2007-12-12", NULL),
(NULL, 2, "Anulu",   "2010-05-05", NULL),
(NULL, 2, "Streifi", "2010-06-06", NULL);

insert into gehege values
(NULL, "Safari Outdoor", 100),
(NULL, "Safari spezial", 200);

insert into tiere_gehege values
(1, 1, "2019-01-01"),
(2, 1, "2019-01-02"),
(3, 2, "2019-01-03"),
(4, 2, "2019-01-04"),
(5, 2, "2019-01-04");
```

### Aufgabe 2

Analysieren Sie die Datenstruktur und erstellen Sie die fehlenden Fremdschlüssel.

+ tiere -> tierarten
+ tiere_gehege -> tiere
+ tiere_gehege -> gehege

```sql
alter table tiere 
    add constraint fk_tierart
    foreign key (tierartnr) 
    references tierarten(tierartnr);

alter table tiere_gehege 
    add constraint fk_tiernr
    foreign key (tiernr) 
    references tiere(tiernr);

alter table tiere_gehege 
    add constraint fk_gehegenr
    foreign key (gehegenr) 
    references gehege(gehegenr);
```


### Aufgabe 3

Ermitteln Sie die Anzahl Tiere je Tierart (auch die nicht mehr lebenden), aufsteigende Sortierung nach Tierartenname.

```sql
select tierarten.name, count(*)
    from tierarten
    inner join tiere
    on (tierarten.tierartnr = tiere.tierartnr)
    group by tiere.tierartnr
    order by tierarten.name asc;
```

Ausgabe:
```
+-------+----------+
| name  | count(*) |
+-------+----------+
| Tiger |        2 |
| Zebra |        3 |
+-------+----------+
```

### Aufgabe 4

Ermitteln Sie die Anzahl der lebenden Tiere je Tierart, Sortierung nach Anzahl absteigend.

```sql
select tierarten.name, count(*) as anzahl
    from tierarten
    inner join tiere
    on (tierarten.tierartnr = tiere.tierartnr)
    where todestag is null
    group by tiere.tierartnr
    order by anzahl desc;
```

Ausgabe:
```
+-------+--------+
| name  | anzahl |
+-------+--------+
| Zebra |      3 |
| Tiger |      1 |
+-------+--------+
```

### Aufgabe 5

Erstellen Sie eine View v_tierliste, die eine Liste der Tiere zum Gehege enthält, sortiert nach Tiernamen. Beachten Sie die Spaltenüberschriften.

```sql
create or replace view v_tierliste as
    select tiere.name as Tiername,
        tierarten.name as Tierart,
        gehege.name as Gehege,
        geburtstag,
        todestag
    from tiere_gehege
    inner join tiere on (tiere_gehege.tiernr = tiere.tiernr)
    inner join tierarten on (tierarten.tierartnr = tiere.tierartnr)
    inner join gehege on (tiere_gehege.gehegenr = gehege.gehegenr)
    order by Tiername asc;
```

Ausgabe:
```
+----------+---------+----------------+------------+------------+
| Tiername | Tierart | Gehege         | geburtstag | todestag   |
+----------+---------+----------------+------------+------------+
| Anulu    | Zebra   | Safari spezial | 2010-05-05 | NULL       |
| Bambi    | Zebra   | Safari spezial | 2007-12-12 | NULL       |
| Mogli    | Tiger   | Safari Outdoor | 2005-05-01 | NULL       |
| Shirkan  | Tiger   | Safari Outdoor | 2002-03-01 | 2019-06-30 |
| Streifi  | Zebra   | Safari spezial | 2010-06-06 | NULL       |
+----------+---------+----------------+------------+------------+
```

### Aufgabe 6

Ermitteln Sie den durchschnittlichen Platz (Größe geteilt durch Anzahl Tiere) je lebendem Tier im Gehege, Sortierung nach Gehegename.

```sql
select gehege.name, groesse/count(tiere.tiernr) as 'Platz je Tier'
    from tiere_gehege
    inner join gehege on (gehege.gehegenr = tiere_gehege.gehegenr)
    inner join tiere on (tiere.tiernr = tiere_gehege.tiernr)
where todestag is null
group by tiere_gehege.gehegenr
order by gehege.name asc;
```

Ausgabe:
```
+----------------+---------------+
| name           | Platz je Tier |
+----------------+---------------+
| Safari Outdoor |      100.0000 |
| Safari spezial |       66.6667 |
+----------------+---------------+
```

### Aufgabe 7

Erstellen Sie einen Check-Constraint der verhindert, dass ein Todesdatum eingetragen werden kann, das vor dem Geburtsdatum liegt.

```sql
alter table tiere 
    add constraint check_todestag
    check (todestag > geburtstag);
```

### Aufgabe 8

Erstellen Sie ein prepared Statement, welches unter Angabe des Tiernamens ein Todesdatum einträgt, sofern bei diesem Tier noch kein Todesdatum eingetragen ist. Tragen Sie über das prepared Statement den Todestag von Anulu mit dem 23.4.2022 ein.

```sql
prepare set_death from 
    "update tiere set todestag = ? where name = ? and todestag is null";

set @nm = 'Anulu';
set @day = '2022-04-23';

execute set_death using @day, @nm;
```