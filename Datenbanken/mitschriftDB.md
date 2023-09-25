# Datenbanken


## Index

* [Datenbank und Benutzer anlegen, Rechte zuweisen](#datenbank-und-benutzer-anlegen-rechte-zuweisen)


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