# Datenbanken


## Index

* [Datenbank](#datenbank)
* [Datenbankmanagementsystem](#datenbankmanagementsystem)
* [Tabellen](#tabellen)
* [Datenbank und Benutzer anlegen, Rechte zuweisen](#datenbank-und-benutzer-anlegen-rechte-zuweisen)
* [Structured Querry Language SQL](#structured-querry-language-sql)
* [Erste SQL Kommandos](#erste-sql-kommandos)


## Datenbank

+ Tabellen
+ Views
+ Indizes
+ Stored Procedures
+ Trigger

## Datenbankmanagementsystem

+ Verarbeitung
+ Zugriffsrechte
+ Sitzungsverwaltung
+ Transaktionsverarbeitung
+ Datensicherung
+ API (Application Programming Interface)

## Tabellen

| KundenNr | Name          | Ort        |
|----------|---------------|------------|
| 4711     | Müller, Otto  | Tettnang   |
| 4712     | Schmid, Luis  | Ravensburg |
| 4713     | Maier, Martin | Mengen     |

+ __Spalte:__ (Attribut, Datenfeld, Eigenschaft, Property)
  + Beinhaltet Daten desselben Typs (z.B. Zahlen)
  + Beinhaltet Daten derselben logischen Zuordnung (z.B. Name)
  + Haben einen eindeutigen Namen
+ __Zeile:__ (Datensatz, Entität, Record, Objekt)
  + Enthält inhaltlich zusammenhängende Daten
+ __Tabelle:__ (Matrix, Entitätstyp, Relation, Klasse, Recordset)
   + Besteht aus mindestens einer Spalte mit endlich vielen Zeilen (0 bis n Zeilen)

## Datenbank und Benutzer anlegen, Rechte zuweisen

###  Datenbank anlegen

Um eine Datenbank mit dem Namen EST anzulegen, verwenden Sie das folgende Kommando:

```sql
create database EST;
```

### Anlegen eines Benutzers

Außer dem Benutzer root hat in diesem Moment niemand Zugriff auf die neue Datenbank. OK, im Moment gibt es auch nur den einen Benutzer. Dies ist aber auch der Fall, wenn schon weitere Benutzer vorhanden wären.

Im nächsten Schritt erstellen wir einen weiteren Benutzer. Die Benutzerverwaltung unterscheidet sich etwas von anderen Datenbanksystemen. Bei MariaDB besteht ein Benutzer immer aus dem Namen und Netzwerknamen, von wo aus dieser Zugriff haben wird. Getrennt werden die beiden Teile durch den Klammeraffen @. In der Regel werden lokale Benutzer (@localhost) und Benutzer, die Zugriff über das Netzwerk haben (@%) angelegt. Das Prozentzeichen % ist hier der Platzhalter für beliebige Zeichen.

Legen wir einen Benutzer an mit Namen schueler, der lediglich auf dem Datenbankserver direkt Zugriff haben wird:

```sql
create user 'schueler'@'localhost' identified by 'geheim';
```

Achten Sie darauf, die Hochkommas um @ zu beenden, ansonsten wird eine Benutzer mit dem Namen schueler@localhost angelegt. Als Passwort wird hier das Wort geheim gesetzt.

### Vergeben von Rechten

Der neue Benutzer kann nun zwar zur Anmeldung benutzt werden, allerdings verfügt er darüber hinaus über keine Rechte. Wir wollen ihm nun die vollen Zugriffsrechte auf die Datenbank EST geben:

```sql
grant all on EST.* to 'schueler'@'localhost';
```

Zugriff über den neuen Benutzer

Nun können wir uns mit dem neuen Benutzer anmelden und in die Datenbank EST wechseln.

```
mysql -u schueler -p
```

Die Option -p fragt nach dem Kennwort.

```sql
use EST;
```

Mit dem use-Kommando kann in eine Datenbank gewechselt werden. So kann bei allen Zugriffen der Datenbankname weggelassen werden und die Tabellennamen können direkt angegeben werden.

Mit dem Kommando

```sql
show databases;
```

können Sie sich alle Datenbanken anzeigen lassen, auf die Sie Zugriff haben.

### Passwort Ändern

Mit den folgenden Befehlen kann das Passwort eines Benutzers geändert werden.

```sql
ALTER USER 'user'@'hostname' IDENTIFIED BY 'newPassword';
flush privileges;
exit;
```

## Structured Querry Language SQL

SQL (Structured Query Language) ist eine genormte Sprache zur Verarbeitung von Daten in Datenbanksystemen. Die Wurzeln der Sprache liegen bereits in den 1970er Jahren und wurden ursprünglich von IBM entwickelt. Bis heute hat sich SQL stetig weiterentwickelt und ist eine ANSI-Norm. Die meisten DBMS verwenden SQL.

<img src="images/sql.png">

Wie dem Diagramm zu entnehmen ist, gibt es sehr wenige Kommandos (wobei die Liste nicht vollständig ist). Die eigentliche Mächtigkeit liegt allerdings in den Teilkommandos. Hier werden wir nicht alles behandeln können, wir beschränken uns auf die wichtigsten Befehle.

### Allgemeines zu SQL-Befehlen

+ Hilfe im Internet:
    + https://dev.mysql.com/doc/refman/5.7/en/
    + https://mariadb.com/kb/en/library/documentation/
    + https://www.w3schools.com/sql/
+ Bei den Befehlen wird nicht zwischen Groß- und Kleinschreibung unterschieden
+ Bei Namen für Datenbanken, Tabellen, Feldern, … wird zwischen Groß- und Kleinschreibung unterschieden. Es kann also z.B. eine Tabelle TEST und eine Tabelle Test existieren (sollte aber vermieden werden!). Wenn Leerzeichen verwendet werden, dann müssen die Namen in Hochkomma stehen (' oder ").
+ Empfehlungen für Namen: 
    + Halten Sie sich konsequent an Konventionen (z.B. Groß-/Kleinschreibung, deutsch/englisch, Wörter/Abkürzungen).
    + Verwenden Sie keine Leerzeichen oder Umlaute --> "lästig" beim Programmieren, teilweise auch problematisch wegen unterschiedlicher Zeichensätze.
    + Inhalt sollte am Namen erkennbar sein, aber je kürzer desto besser.
+ Die Reihenfolge der Teilkommandos ist fest vorgegeben. (z.B. select XY from ABC where xy > 0).
+ SQL-Kommandos werden mit einem Semikolon ; abgeschlossen.

## Erste SQL Kommandos

### Anmelden an der Datenbank mit dem MySQL-Client

In der Regel greifen spezielle Softwareprodukte (SAP) auf Datenbanken zu, teilweise auch in Form von Web-Seiten (Amazon,...). Es gibt aber in der Regel vom Softwarehersteller des DBMS auch ein kleines Hilfsprogramm, mit dem direkt auf die Datenbank zugegriffen werden kann. So ist es auf bei MariaDB. Um den MySQL-Client zu starten und sich am Datenbankserver anzumelden, verwenden Sie das folgende Kommando:

```
mysql -u USERNAME -p
```

USERNAME steht hier stellvertretend für Ihren Anmeldenamen. Anschließend werden Sie nach dem Passwort gefragt. Wundern Sie sich nicht, wenn die eingegebenen Passwort-Zeichen nicht auf dem Bildschirm angezeigt werden.

Wenn alles richtig eingegeben wurde, dann sollte Sie der Datenbankserver begrüßen. Nun können Sie SQL-Kommandos ausführen.

### Anlegen einer Datenbank

```sql
create database DATENBANKNAME -- (z.B. create database SAP).
```

### Anlegen eines Benutzers und zuweisen von Rechten

```sql
create user 'schueler'@'localhost' identified by 'passwort'; 
grant all on SAP.* to 'schueler'@'localhost';
```

### Nützliches zum mysql-Client

+ Mit den Tasten hoch/runter kann zwischen den letzten Kommandos geblättert werden.
+ Help bzw. help BEFEHL wird die entsprechende Hilfe angezeigt (z.B. help create database).
+ Mit use DATENBANK wird in die gewünschte Datenbank gewechselt - kann auch direkt an den mysql-Aufruf gehängt werden (z.B. mysql DATENBANK).


### Erste hilfreiche Kommandos (teilweise nicht SQL-Standard, sondern speziell für MySQL)

__Alle Datenbanken anzeigen:__
```sql
show databases;
```
 
__Alle Benutzer anzeigen (nur möglich mit root-Rechten):__

```sql
select * from mysql.user;

-- Oder nur Name/Passwort:

select host, user, password from mysql.user;
```
 
__Alle Tabellen anzeigen:__

```sql
show tables;
```
 
__Tabellenstruktur anzeigen:__

```sql
describe TABELLE;
```
 
__Anlegen einer Tabelle:__

```sql
create table artikel (artikelnummer integer, benennung varchar(30));
```
 
__Datensatz in eine Tabelle einfügen:__

```sql
insert into artikel values (1, "Blauer Gummiball");
```
 
__Alle Datensätze einer Tabelle anzeigen:__

```sql
select * from artikel;
```
\* für alle Felder oder Feldnamen mit Komma getrennt.

__Alle Datensätze einer Tabelle löschen:__

```sql
delete from artikel;
```

__Eine Tabelle löschen:__

```sql
drop table artikel;
```
