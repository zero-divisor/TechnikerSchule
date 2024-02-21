Sie sollen in Ihrem Sportverein die Vereinsverwaltung übernehmen. Von Ihrem Vorgänger erhalten Sie dazu Zugriff auf die Datenbank.

Ziemlich schnell stellen Sie fest, dass Ihr Vorgänger von Datenbanken nicht all zu viel Ahnung hatte, hat er doch alle Informationen in einer Tabelle gespeichert.

So machen Sie es sich zur Aufgabe, den bestehenden Datenbestand in eine vernünftige Datenstruktur zu überführen.


## Datenbereinigung

### 1.) Laden Sie die Vereinsdaten indem Sie das SQL-Skript „verein.sql“ ausführen. Analysieren Sie die Datenstruktur und die vorhandenen Daten.

```sql
-- hatte bei mir Probleme mit den Umlauten
source /pfad/zur/datei.sql;
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

### 3.) Füllen Sie die Sparten-Tabelle mit den Sparten aus der Mitglieder-Tabelle. Achten Sie darauf, dass jeder Sparte nur 1x angelegt wird.

### 4.) Erstellen Sie eine Tabelle zur Verknüpfung der Mitglieder mit den Sparten (mnr, snr). Beide Felder zusammen sollen den PK bilden.

### 5.) Füllen Sie die Verknüpfungstabelle für Mitglieder und Sparten mit den Werten aus der Mitgliedertabelle.

### 6.) Nachdem nun die Sparten übernommen wurden löschen Sie die entsprechende Spalte aus der Mitgliedertabelle.

### 7.) Nun müssen noch die doppelten Mitgliedsnamen entfernt werden. Gehen Sie dabei wie folgt vor (in den SQL-Statements kommen keine Daten vor!):

+ Erstellen einer Tabelle „mitglieder2“, Übernahme der Struktur von „mitglieder“!
+ Übernahme der Mitglieder in die neue Tabelle ohne Duplikate.
+ Korrektur der der Mitgliedernummer in der Verknüpfungstabelle zu den Sparten.
+ Löschen der Tabelle „mitglieder“.
+ Umbenennen der Tabelle „mitglieder2“ in „mitglieder“.


## Auswertungen

### 8.) Erzeugen Sie die gleiche Ausgabe wie die ursprüngliche Tabelle.

### 9.) Lassen Sie sich Name und Vorname von allen Mitgliedern ausgeben, die Tennis spielen.

### 10.) Lassen Sie sich die Anzahl Mitglieder je Sparte ausgeben (Spartennummer, Spartenname, Anzahl Mitglieder).