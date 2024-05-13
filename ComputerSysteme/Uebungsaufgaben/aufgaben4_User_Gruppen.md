### Aufgabe 1

### Untersuchen Sie mithilfe der man pages auf einer Linux-Maschine die folgenden Befehle

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

Anstelle von `useradd` und `userdel` sollten `adduser` und `deluser` verwendet werden.

### Aufgabe 2

#### Erstellen Sie sich unter Verwendung von seriösen Quellen ein Tutorial, wie bei Debian lokale Benutzer und Gruppen eingerichtet werden können.

In Debian, there are two command-line tools that you can use to create a new user account: `useradd` and `adduser`.

`useradd` is a low-level utility for adding users while the `adduser` is a friendly interactive frontend to useradd written in Perl.

To create a new user account named `username` using the `adduser` command you would run:

```
$ sudo adduser username
```


Output:

```
Adding user `username' ...
Adding new group `username' (1001) ...
Adding new user `username' (1001) with group `username' ...
Creating home directory `/home/username' ...
Copying files from `/etc/skel' ...
```

You will be asked a series of questions. The password is required, and all other fields are optional.

```
Enter new UNIX password: 
Retype new UNIX password: 
passwd: password updated successfully
Changing the user information for username
Enter the new value, or press ENTER for the default
	Full Name []: 
	Room Number []: 
	Work Phone []: 
	Home Phone []: 
	Other []: 
Is the information correct? [Y/n]
```

On the last prompt you’ll need to confirm that the information is correct by entering `Y`.

The command will create the new user’s home directory, and copy files from `/etc/skel` directory to the user’s home directory. Within the home directory, the user can write, edit, and delete files and directories.

By default on Debian, members of the group sudo are granted with sudo access.

If you want the newly created user to have administrative rights, add the user to the sudo group:

```
$ sudo usermod -aG sudo username
```

### Aufgabe 3

#### Legen Sie in Ihrer Linux VM zwei neue Benutzer an, die einer eigenen ebenfalls neu angelegten Sekundärgruppe angehören.

```
$ sudo adduser newuser1
Adding user `newuser1' ...
Adding new group `newuser1' (1004) ...
Adding new user `newuser1' (1004) with group `newuser1' ...
Creating home directory `/home/newuser1' ...
Copying files from `/etc/skel' ...
Geben Sie ein neues Passwort ein:
Geben Sie das neue Passwort erneut ein:
passwd: Passwort erfolgreich geändert
Benutzerinformationen für newuser1 werden geändert.
Geben Sie einen neuen Wert an oder drücken Sie ENTER für den Standardwert
        Vollständiger Name []: new1
        Zimmernummer []:
        Telefon geschäftlich []:
        Telefon privat []:
        Sonstiges []:
Is the information correct? [Y/n] Y
```

```
$ sudo adduser newuser2
Adding user `newuser2' ...
Adding new group `newuser2' (1005) ...
Adding new user `newuser2' (1005) with group `newuser2' ...
Creating home directory `/home/newuser2' ...
Copying files from `/etc/skel' ...
Geben Sie ein neues Passwort ein:
Geben Sie das neue Passwort erneut ein:
passwd: Passwort erfolgreich geändert
Benutzerinformationen für newuser2 werden geändert.
Geben Sie einen neuen Wert an oder drücken Sie ENTER für den Standardwert
        Vollständiger Name []: new2
        Zimmernummer []:
        Telefon geschäftlich []:
        Telefon privat []:
        Sonstiges []:
Is the information correct? [Y/n] Y
```

```
$ sudo addgroup newgroup1
Adding group `newgroup1' (GID 1006) ...
Done.
```

```
$ sudo usermod -aG newgroup1 newuser1
$ sudo usermod -aG newgroup1 newuser2
```

```
$ tail -n 2 /etc/passwd
newuser1:x:1004:1004:new1,,,:/home/newuser1:/bin/bash
newuser2:x:1005:1005:new2,,,:/home/newuser2:/bin/bash
```

```
$ tail -n 3 /etc/group
newuser1:x:1004:
newuser2:x:1005:
newgroup1:x:1006:newuser1,newuser2
```

### Aufgabe 4

#### Schauen Sie sich die Einträge an, die beim Anlegen der Benutzer und Gruppen in `/etc/passwd`, `/etc/shadow` und `/etc/group` entstanden sind.

### Aufgabe 5

#### Untersuchen sie den Befehl `chage`. Welche Features bietet er, und warum sind diese im Alltag wichtig?

### Aufgabe 6

#### Erstellen Sie sich unter Verwendung von seriösen Quellen ein Tutorial, wie bei Windows 10 lokale Benutzer und Gruppen eingerichtet werden können.

### Aufgabe 7

#### Legen Sie auf einer Windows 10 Maschine zwei weitere Benutzer an, die einer eigenen, ebenso neu angelegten Gruppe angehören. Gibt es bei Windows auch Primär- und Sekundärgruppen?

### Aufgabe 8

#### Finden Sie heraus, wo und in welchem Format die Passwörter der Benutzer gespeichert sind. Welches Verschlüsselungsverfahren verwendet Windows dabei?

### Aufgabe 9

#### Welche Möglichkeiten und Features zum Passwort Aging (aquivalent zu `chage`) unterstützt Windows 10?