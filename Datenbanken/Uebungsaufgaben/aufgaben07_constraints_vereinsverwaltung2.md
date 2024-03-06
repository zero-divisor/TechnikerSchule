### 1.) Die Verknüpfungstabelle zwischen Mitglied und Sparte darf nur Schlüsselnummern aus der entsprechenden Stammdatentabelle enthalten.

Sichern Sie die Verknüpfungstabelle entsprechend ab. Testen Sie anschließend was passiert, wenn Sie einen nicht vorhandenen Schlüssel einfügen oder wenn Sie versuchen, eine Sparte zu löschen, die ein Mitglied enthält.

### 2.) Erstellen Sie eine neue Tabelle zur Erfassung der Mitgliedsbeiträge je Kalenderjahr.

+  Welche Felder und Datentypen muss diese Tabelle enthalten? 
+ Wie wählen Sie den Primary Key? 
+ Sollten Sie auch hier einen Constraint anlegen?

### 3.) Erweitern Sie die Tabelle Sparten um den Jahresbeitrag.

Tragen Sie dazu die folgenden Werte ein:

+ Tennis: 95,-€
+ Fußball: 25,-€
+ Kegeln: 40,-€
+ Volleyball: 35,-€
+ Tischtennis: 30,-€

### 4.) Füllen Sie die Tabelle für die Mitgliedsbeiträge mit den Beiträgen für das Jahr 2021. 

Schaffen Sie das mit einer SQL-Anweisung unter Verwendung der existierenden Daten?

### 5.) Erstellen Sie die Jahresrechnung für Ihre Mitglieder. Dazu soll über einen Select die folgende die Ausgabe erzeugt werden.

```
Sehr geehrter Herr Hans Maier, bitte überweisen Sie den Betrag von 135.00 auf unser Konto.
Sehr geehrter Herr Josef Müller, bitte überweisen Sie den Betrag von 195.00 auf unser Konto.
Sehr geehrter Herr Karl Schmid, bitte überweisen Sie den Betrag von 95.00 auf unser Konto.
Sehr geehrter Herr Michael Schulze, bitte überweisen Sie den Betrag von 75.00 auf unser Konto.
Sehr geehrter Herr Udo Schmid, bitte überweisen Sie den Betrag von 30.00 auf unser Konto.
```


### 6.) Nun tritt die erste Frau in Ihren Verein ein. Die Anrede der Jahresrechnung passt so nicht mehr. 

+ Erweitern Sie die Tabelle Mitglieder um das Feld „geschlecht“ und setzen Sie die Werte der bestehenden Mitglieder auf „m“. 

+ Richten Sie das Feld "geschlecht" so ein, dass nur "m" und "w" zulässig sind. Fügen Sie anschließend ein weibliches Mitglied ein und weisen Sie sie einer Sparte zu.

### 7.) Nun muss die Tabelle „beitraege“ aktualisiert werden. Erstellen Sie dazu einen insert-Befehl, der nur noch Mitglieder berücksichtigt, die noch nicht in der Beitrags-Tabelle vorhanden sind.

### 8.) Zuletzt passen Sie den Select für die Jahresrechnung an um die korrekte Anrede auszugeben.

```
Sehr geehrter Herr Hans Maier, bitte überweisen Sie den Betrag von 135.00 auf unser Konto.
Sehr geehrter Herr Josef Müller, bitte überweisen Sie den Betrag von 195.00 auf unser Konto.
Sehr geehrter Herr Karl Schmid, bitte überweisen Sie den Betrag von 95.00 auf unser Konto.
Sehr geehrter Herr Michael Schulze, bitte überweisen Sie den Betrag von 75.00 auf unser Konto.
Sehr geehrter Herr Udo Schmid, bitte überweisen Sie den Betrag von 30.00 auf unser Konto.
Sehr geehrte Frau Beate Maier, bitte überweisen Sie den Betrag von 40.00 auf unser Konto.
```