### Aufgabe 1

Untersuchen Sie mithilfe der man pages auf einer Linux-Maschine die folgenden Befehle

#### adduser

Die Befehle `adduser` und `addgroup` richten im System Benutzer und Gruppen ein, deren Eigenschaften durch die Befehlszeilen-Optionen und die Konfigurationsinformationen in `/etc/adduser.conf` festgelegt werden. Sie sind freundlichere Frontends für systemnahe  Werkzeuge  wie die Programme useradd, groupadd und usermod. Standardmäßig werden zu der Debian-Richtlinie konforme Werte für UID und GID gewählt, ein Home-Verzeichnis mit einer Grundkonfiguration eingerichtet, ein benutzerdefiniertes Skript ausgeführt und andere Funktionen.

#### deluser

`deluser` und `delgroup` entfernen Benutzer und Gruppen aus dem System. Ihr Vorgehen richtet sich nach den auf der Befehlszeile übergebenen Optionen und Konfigurationsinformationen in `/etc/deluser.conf` und `/etc/adduser.conf`. Sie sind bedienungsfreundlichere Frontends für die Programme `userdel` und `groupdel`. Unter anderem löschen sie optional das Home-Verzeichnis oder sogar alle im System vorhandenen Dateien des zu entfernenden Benutzers und lassen benutzerdefinierte Skripte laufen.

#### useradd

`useradd` is a low level utility for adding users. On Debian, administrators should usually use `adduser` instead. By default, a group will also be created for the new user.

#### userdel

`userdel` is a low level utility for removing users. On Debian, administrators should usually use `deluser` instead.
The `userdel` command modifies the system account files, deleting all entries that refer to the user name. The named user must exist.

#### usermod

The `usermod` command modifies the system account files to reflect the changes that are specified on the command line.

#### passwd

The `passwd` command changes passwords for user accounts. A normal user may only change the password for their own account, while the superuser may change the password for any account. `passwd` also changes the account or associated password validity period.

### Manche der Befehle machen im Grund das selbe. Welche sollten verwendet werden, d.h. was ist hier "best practice"?

### Aufgabe 2

Erstellen Sie sich unter Verwendung von seriösen Quellen ein Tutorial, wie bei Debian lokale Benutzer und Gruppen eingerichtet werden können.

### Aufgabe 3

Legen Sie in Ihrer Linux VM zwei neue Benutzer an, die einer eigenen ebenfalls neu angelegten Sekundärgruppe angehören.

### Aufgabe 4

Schauen Sie sich die Einträge an, die beim Anlegen der Benutzer und Gruppen in `/etc/passwd`, `/etc/shadow` und `/etc/group` entstanden sind.

### Aufgabe 5

Untersuchen sie den Befehl `chage`. Welche Features bietet er, und warum sind diese im Alltag wichtig?

### Aufgabe 6

Erstellen Sie sich unter Verwendung von seriösen Quellen ein Tutorial, wie bei Windows 10 lokale Benutzer und Gruppen eingerichtet werden können.

### Aufgabe 7

Legen Sie auf einer Windows 10 Maschine zwei weitere Benutzer an, die einer eigenen, ebenso neu angelegten Gruppe angehören. Gibt es bei Windows auch Primär- und Sekundärgruppen?

### Aufgabe 8

Finden Sie heraus, wo und in welchem Format die Passwörter der Benutzer gespeichert sind. Welches Verschlüsselungsverfahren verwendet Windows dabei?

### Aufgabe 9

Welche Möglichkeiten und Features zum Passwort Aging (aquivalent zu `chage`) unterstützt Windows 10?