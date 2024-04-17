## Sie bekommen den Auftrag, die Zimmer eines Hotels zu verwalten. Folgende Anforderungen sollen abgedeckt werden:

### 1. Die Zimmer sollen in 3 Kategorien eingeteilt werden (1=Premium, 2=Superior, 3=Standard), jede Kategorie hat einen festen Zimmerpreis für Einzel- und Doppelzimmer (EZ 500,-/200,-/100,-, DZ 600,-/250,-/150,-).

```sql
create table zimmer_kategorie(
    kategorie int primary key,
    preis_ez int not null,
    preis_dz int not null
);

insert into zimmer_kategorie
    (kategorie, preis_ez, preis_dz)
    values
    (1, 500, 600),
    (2, 200, 250),
    (3, 100, 150);
```

### 2. Das Hotel hat 4 Stockwerke, in Stockwerk 1-3 gibt es jeweils 2 Superior- und 3 Standard-Zimmer. Die Zimmernummer ist 3-stellig fortlaufend wobei die Hunderterstelle dem Stockwerk entspricht. Der 4. Stock besteht komplett aus dem Premium-Zimmer und hat somit die Nummer 401.

```sql
create table zimmer(
    zimmer_nr int primary key,
    kategorie int not null
);

insert into zimmer(zimmer_nr, kategorie) values
    (101, 2),
    (102, 2),
    (103, 3),
    (104, 3),
    (105, 3),
    (201, 2),
    (202, 2),
    (203, 3),
    (204, 3),
    (205, 3),
    (301, 2),
    (302, 2),
    (303, 3),
    (304, 3),
    (305, 3),
    (401, 1);
```

### 3. Alle Zimmer sind Doppelzimmer, die aber auch als Einzelzimmer belegt werden können. Die Belegung bestimmt den Preis.

### 4. Die Buchungen der Zimmer soll jeweils pro Gast und Zimmer möglich sein bezogen auf einen Zeitraum und den Verweis auf das gebuchte Zimmer unter Angabe auf Belegung als Einzel- oder Doppelzimmer.

```sql
create table buchung(
    buchungs_id int primary key auto_increment,
    gast_id int not null,
    zimmer_nr int not null,
    belegung varchar(2) not null,
    date_beginn date not null,
    date_end date not null
);
```

### 5. Beim Auschecken soll zum Gast der passende Rechnungsbetrag ermittelt werden.

```sql
insert into buchung(
    gast_id,
    zimmer_nr,
    belegung,
    date_beginn,
    date_end
)values(
    1,
    401,
    'EZ',
    '2020-09-01',
    '2020-09-04'
);

select 
    buchungs_id, 
    gast_id, 
    zimmer.zimmer_nr, 
    belegung, 
    floor(datediff(date_end, date_beginn)) as dauer,
    if(belegung='EZ', preis_ez, preis_dz) as preis_pro_nacht,
    floor(datediff(date_end, date_beginn))*if(belegung='EZ', preis_ez, preis_dz) as preis_gesamt
from buchung
inner join zimmer on (zimmer.zimmer_nr = buchung.zimmer_nr)
inner join zimmer_kategorie on (zimmer.kategorie = zimmer_kategorie.kategorie)
where buchungs_id = 1;
```

### 6. Vor dem Buchen soll es möglich sein, ein bestimmtes Zimmer auf Belegung innerhalb eines vorgegebenen Zeitraums zu prüfen (Antwort "belegt" oder "frei").

```sql
-- ist Zimmer 401 zwischen 2020-09-02 und 2020-09-08 frei?
select if(
    '2020-09-02' > date_end 
    or
    '2020-09-08' < date_beginn, 
    'frei', 'belegt') as status
from buchung
where zimmer_nr=401;
```

### 7. Sichern Sie die Datenbank so gut wie möglich gegen fehlende Werte ab mit den bekannten Methoden.

```sql
alter table buchung 
    add constraint check_ez_dz 
    check(belegung = 'EZ' or belegung = 'DZ');

alter table buchung 
    add constraint check_dates 
    check(date_beginn < date_end);

alter table zimmer 
    add constraint fk_kategorie 
    foreign key (kategorie) 
    references zimmer_kategorie(kategorie);

alter table buchung 
    add constraint fk_zimmer_nr 
    foreign key (zimmer_nr) 
    references zimmer(zimmer_nr);
```