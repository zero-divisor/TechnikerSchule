### Aufgabe 1

#### 1.1 Legen Sie lediglich durch manuelle Einträge in die Dateien /etc/passwd und /etc/group einen neuen Benutzer namens tux an, der einer neuen Gruppe namens tux angehört. 

+ Tragen Sie als Homeverzeichnis für tux zwar /home/tux ein, jedoch erstellen Sie das Verzeichnis noch nicht! 
+ Als Login-Shell stellen Sie, wie es auch beim Standardbenutzer der Fall ist, /bin/bash ein. 
+ Führen Sie anschliessend den Befehl sudo passwd tux aus, um für den neu angelegten Benutzer ein Passwort zu setzen.

```
# in /etc/passwd
tux:x:1001:1001:tux,,,:/home/tux:/bin/bash

# in /etc/group
tux:x:1001:tux
```

#### 1.2 Simulieren Sie mit dem Befehl sudo login tux das Einloggen von tux in das System. Welche Meldungen erscheinen?

```
No directory, logging in with HOME=/
```

#### 1.3 Loggen Sie sich aus der shell von 1.2 mit exit wieder aus. Erstellen Sie dort als root (mit sudo) das Home-Verzeichnis für tux unter /home/tux. 

+ Nun muss das Verzeichnis /home/tux in das Besitztum des Benutzers tux und
der Gruppe tux gebracht werden. Die geschieht durch die beiden Befehle
sudo chown tux /home/tux und sudo chgrp tux /home/tux

#### 1.4 Wiederholen Sie den Schritt 1.2. Schauen Sie sich alle Dateien in tux's Home an und versuchen Sie als user tux neue Dateien anzulegen.

```
tux@LinuxMint:~$ pwd
/home/tux

tux@LinuxMint:~$ touch testfile

tux@LinuxMint:~$ ls
testfile
```

#### 1.5 Beenden Sie alle Terminals und loggen Sie sich vollständig aus der grafischen Benutzeroberfläche aus. Loggen Sie sich als Benutzer tux in das System ein.

### Aufgabe 2

#### 2.1 Untersuchen Sie mithilfe der man-pages die grundsätzliche Wirkungsweise der folgenden Befehle useradd, usermod, userdel, groupadd, groupmod und groupdel.

```
useradd - erstellt einen neuen Benutzer oder aktualisiert die Standardwerte für neue Benutzer
usermod - verändert ein Benutzerkonto
userdel - löscht ein Benutzerkonto und die dazugehörigen Dateien
groupadd - erstellt eine neue Gruppe
groupmod - ändert die Eigenschaften einer Gruppe auf dem System
groupdel - löscht eine Gruppe
```

#### 2.2 Verwenden Sie die o.g. Werkzeuge um einen weiteren Benutzer namens linus anzulegen.

+ Loggen Sie sich danach komplett aus und als Benutzer linus wieder ein. Welche Unterschiede zum zuvor manuell angelegten Benutzer tux können Sie finden?

### Aufgabe 3

#### 3.1 Untersuchen Sie das Verzeichnis /etc/skel. Welche Bedeutung hat es für die Benutzerverwaltung?

#### 3.2 Sperren Sie als Administrator den Benutzer tux mithilfe des Befehls passwd.

+ Untersuchen Sie die Auswirkungen auf den Benutzer und suchen Sie in der Datei /etc/shadow und /etc/passwd nach entsprechenden Veränderungen.