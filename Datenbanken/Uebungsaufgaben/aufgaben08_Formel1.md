### 0.) Führe die Befehle in datenumgebung_formel1.sql aus.

Es existiert nun folgende Datenumgebung:

#### Tabelle team

Beinhaltet die Formel 1-Teams (Nummer des Teams, Name des Teams).

#### Tabelle fahrer

Beinhaltet die aktuellen Fahrer (Nummer des Fahrers, Name des Fahrers, Land, Alter, Verknüpfung zum Team).

#### Tabelle rennen

Beinhaltet die Rennen der diesjährigen Saison (Nummer des Rennens, Name der Rennstrecke, Land, Ort, Länge einer Runde, Anzahl Runden beim Rennen, Datum des Rennens).

#### Tabelle platzierung

Platzierung der Fahrer beim Rennen (Nummer des Rennens, Platzierung, Nummer des Fahrers, Erhaltene Punkte).

Es sind nur Daten zum ersten Rennen der Saison in der Tabelle.

### 1.) Lassen Sie sich mit dem Kommando desc die Strukturen der 4 Tabellen anzeigen und versuchen Sie, das Datenmodell zu verstehen.

```
MariaDB [est]> desc team;
+-------+-------------+------+-----+---------+-------+
| Field | Type        | Null | Key | Default | Extra |
+-------+-------------+------+-----+---------+-------+
| tnr   | int(11)     | NO   | PRI | NULL    |       |
| tname | varchar(20) | NO   |     | NULL    |       |
+-------+-------------+------+-----+---------+-------+

MariaDB [est]> desc fahrer;
+--------+-------------+------+-----+---------+-------+
| Field  | Type        | Null | Key | Default | Extra |
+--------+-------------+------+-----+---------+-------+
| fnr    | int(11)     | NO   | PRI | NULL    |       |
| fname  | varchar(50) | NO   |     | NULL    |       |
| land   | varchar(20) | NO   |     | NULL    |       |
| falter | int(11)     | NO   |     | NULL    |       |
| tnr    | int(11)     | NO   |     | NULL    |       |
+--------+-------------+------+-----+---------+-------+

MariaDB [est]> desc rennen;
+--------+--------------+------+-----+---------+-------+
| Field  | Type         | Null | Key | Default | Extra |
+--------+--------------+------+-----+---------+-------+
| rnr    | int(11)      | NO   | PRI | NULL    |       |
| sname  | varchar(50)  | NO   |     | NULL    |       |
| land   | varchar(30)  | NO   |     | NULL    |       |
| ort    | varchar(20)  | NO   |     | NULL    |       |
| laenge | decimal(4,3) | NO   |     | NULL    |       |
| runden | int(11)      | NO   |     | NULL    |       |
| datum  | date         | NO   |     | NULL    |       |
+--------+--------------+------+-----+---------+-------+

MariaDB [est]> desc platzierung;
+--------+---------+------+-----+---------+-------+
| Field  | Type    | Null | Key | Default | Extra |
+--------+---------+------+-----+---------+-------+
| rnr    | int(11) | NO   | PRI | NULL    |       |
| platz  | int(11) | NO   | PRI | NULL    |       |
| fnr    | int(11) | NO   |     | NULL    |       |
| punkte | int(11) | NO   |     | NULL    |       |
+--------+---------+------+-----+---------+-------+
```

### 2.) Lassen Sie sich die Daten aller 4 Tabellen anzeigen und verschaffen Sie sich einen Überblick über den Datenumfang.

```sql
select * from team;
select * from fahrer;
select * from rennen;
select * from platzierung;
```

### 3.) Ergänzen Sie die fehlenden foreign keys.

```sql
alter table fahrer 
    add constraint fk_team_nr 
    foreign key (tnr) 
    references team(tnr);

alter table platzierung 
    add constraint fk_race_nr 
    foreign key (rnr) 
    references rennen(rnr),
    add constraint fk_fahrer_nr 
    foreign key (fnr) 
    references fahrer(fnr);
```

### 4.) Lassen Sie sich die Anzahl der Fahrer ausgeben.

```sql
select count(*) from fahrer;
```

__Erwartete Ausgabe:__ 20

### 5.) Lassen Sie sich Name und Land aller Fahrer anzeigen, die älter als 29 sind, sortiert nach dem Fahrernamen.

```sql
select fname, land 
    from fahrer 
    where falter > 29 
    order by fname;
```

__Erwartete Ausgabe:__

```
+-------------------+-----------------+
| fname             | land            |
+-------------------+-----------------+
| Alonso, Fernando  | Spanien         |
| Bottas, Valtteri  | Finnland        |
| Hamilton, Lewis   | Grossbritannien |
| Hülkenberg, Nico  | Deutschland     |
| Magnussen, Kevin  | Dänemark        |
| Perez, Sergio     | Mexiko          |
+-------------------+-----------------+
```

### 6.) Lassen Sie sich das minimale, das durchschnittliche und das maximale Alter aller Fahrer ausgeben.

```sql
select min(falter), avg(falter), max(falter) from fahrer;
```

__Erwartete Ausgabe:__

```
+-------------+-------------+-------------+
| min(falter) | avg(falter) | max(falter) |
+-------------+-------------+-------------+
|          21 |     27.7500 |          41 |
+-------------+-------------+-------------+
```

### 7.) Lassen Sie sich die Strecken mit Nummer, Name, Land und Länge des Rennens (Streckenlänge * Rundenanzahl) ausgeben.

```sql
select rnr, sname, land, laenge*runden from rennen order by rnr;
```

__Erwartete Ausgabe:__

```
+-----+------------------------------------+------------------------------+-----------------+
|   1 | Bahrain International Circuit      | Bahrain                      |         308.484 |
|   2 | Jeddah Corniche Circuit            | Saudi-Arabien                |         308.700 |
|   3 | Albert Park Circuit                | Australien                   |         307.574 |
|   4 | Baku City Circuit                  | Aserbaidschan                |         306.153 |
|   5 | Miami International Autodrome      | USA                          |         308.370 |
|   6 | Autodromo Enzo e Dino Ferrari      | Italien                      |         312.417 |
|   7 | Circuit de Monaco                  | Monaco                       |         260.286 |
|   8 | Circuit de Barcelona-Catalunya     | Spanien                      |         308.550 |
|   9 | Circuit Gilles Villeneuve          | Kanada                       |         305.270 |
|  10 | Red-Bull-Ring                      | Oesterreich                  |         307.146 |
|  11 | Silverstone Circuit                | Grossbrittanien              |         306.332 |
|  12 | Hungaroring                        | Ungarn                       |         306.670 |
|  13 | Circuit de Spa-Francorchamps       | Belgien                      |         308.176 |
|  14 | Circuit Park Zandvoort             | Niederlande                  |         306.648 |
|  15 | Autodromo Nazionale di Monza       | Italien                      |         307.029 |
|  16 | Marina Bay Street Circuit          | Singapur                     |         308.843 |
|  17 | Suzuka International Racing Course | Japan                        |         307.771 |
|  18 | Losail International Circuit       | Katar                        |         306.660 |
|  19 | Circuit of The Americas            | USA                          |         308.896 |
|  20 | Autódromo Hermanos Rodríguez       | Mexiko                       |         305.584 |
|  21 | Autodromo Jose Carlos Pace         | Brasilien                    |         305.939 |
|  22 | Las Vegas Street Circuit           | USA                          |         306.000 |
|  23 | Yas Marina Circuit                 | Vereinigte Arabische Emirate |         306.298 |
+-----+------------------------------------+------------------------------+-----------------+
```

### 8.) Lassen Sie sich die Gesamtlänge aller Rennen ausgeben (Summe der Rennenlänge).

```sql
select sum(laenge*runden) from rennen;
```

Erwartete Ausgabe: 7023.796

### 9.) Lassen Sie sich den Fahrernamen mit dem Teamnamen ausgeben, sortiert nach dem Fahrernamen.

```sql
select fname, tname from fahrer 
    join team on (fahrer.tnr = team.tnr) 
    order by fname;
```

__Erwartete Ausgabe:__

```
+-------------------+--------------+
| fname             | tname        |
+-------------------+--------------+
| Albon, Alexander  | Williams     |
| Alonso, Fernando  | Aston Martin |
| Bottas, Valtteri  | Alfa Romeo   |
| de Vries, Nyck    | Alphatauri   |
| Gasly, Pierre     | Alpine       |
| Hamilton, Lewis   | Mercedes AMG |
| Hülkenberg, Nico  | Haas         |
| Leclerc, Charles  | Ferrari      |
| Magnussen, Kevin  | Haas         |
| Norris, Lando     | McLaren      |
| Ocon, Esteban     | Alpine       |
| Perez, Sergio     | Red Bull     |
| Piastri, Oscar    | McLaren      |
| Russel, George    | Mercedes AMG |
| Sainz jr., Carlos | Ferrari      |
| Sargeant, Logan   | Williams     |
| Stroll, Lance     | Aston Martin |
| Tsunoda, Yuki     | Alphatauri   |
| Verstappen, Max   | Red Bull     |
| Zhou, Guanyu      | Alfa Romeo   |
+-------------------+--------------+
```

### 10.) Lassen Sie sich die Platzierung mit Name des Fahrers und Rang ausgeben, sortiert nach dem Rang absteigend (letzter Platz zuerst).

```sql
select fname, platz from platzierung
    join fahrer on (fahrer.fnr = platzierung.fnr)
    order by platz desc;
```

__Erwartete Ausgabe:__

```
+-------------------+-------+
| fname             | platz |
+-------------------+-------+
| Norris, Lando     |    17 |
| Zhou, Guanyu      |    16 |
| Hülkenberg, Nico  |    15 |
| de Vries, Nyck    |    14 |
| Magnussen, Kevin  |    13 |
| Sargeant, Logan   |    12 |
| Tsunoda, Yuki     |    11 |
| Albon, Alexander  |    10 |
| Gasly, Pierre     |     9 |
| Bottas, Valtteri  |     8 |
| Russel, George    |     7 |
| Stroll, Lance     |     6 |
| Hamilton, Lewis   |     5 |
| Sainz jr., Carlos |     4 |
| Alonso, Fernando  |     3 |
| Perez, Sergio     |     2 |
| Verstappen, Max   |     1 |
+-------------------+-------+
```

### 11.) Setzen Sie in der Tabelle platzierung die Punkte des Erstplatzierten auf 0.

```sql
update platzierung
    set punkte = 0
    where platz = 1;
```

### 12.) Löschen Sie den Letztplatzierten (Platz 17) aus der Tabelle platzierung.

```sql
delete from platzierung
    where platz = (
        select max(platz) from platzierung
    );
```

### 13.) Fügen Sie den Erstplatzierten des 2. Rennens in die Tabelle platzierung ein. Es soll der Fahrer mit dem Namen Sergio Perez sein und er bekommt 25 Punkte.

```sql
insert into platzierung
    (rnr, platz, fnr, punkte)
    values
    (2, 1, 11, 25);
```