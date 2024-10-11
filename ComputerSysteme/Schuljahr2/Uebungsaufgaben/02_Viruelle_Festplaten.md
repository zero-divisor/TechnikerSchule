### Vorbereitung
1. Erstelle einen leeren Ordner für diese Aufgabe und navigiere in diesen
2. Erstelle darin einen Ordner mit einem Namen deiner Wahl. Hier wird später der Inhalt der virtuellen Festplatte angezeigt.

### 1. Erstelle eine leere Datei mit der Größe 10MB
```
dd if=/dev/zero of=virtDisk.img bs=1024 count=10240
```
### 2. Erstelle ein Dateisystem in der leeren Datei
```
mkfs -t ext4 virtDisk.img
```
### 3. Mounte die Datei in dem in der Vorbereitung erstellten Ordner
```
sudo mount virtDisk.img virtDiskMountPoint
```
### 4. Prüfe mit dem untenstehenden Befehl, ob die Datei korrekt gemountet wurde
```
$ df -h

/dev/loop0  5,4M  24K  4,7M  1% /home/myUserName/virtDiskMountPoint

```

__Nun ist die Datei datei.img in dem oben gewählten Ordner geöffnet. Dieser kann nun wie eine normale Festplatte genutzt werden. Navigiere in diesen Ordner__

1. Erstelle innerhalb des Ordners die Datei inhalt.txt und schreibe einen Inhalt deiner Wahl rein. Wenn gewollt, können die restlichen 5MB mit weiterem Inhalt belegt werden.

```
touch inhalt.txt
echo "some text" > inhalt.txt
```
2. „Entbinde“ die Festplatte mittels
`sudo umount virtDiskMountPoint`
3. Suche dir einen Partner und schicke ihm deine datei.img über die Schul-E-Mail oder auf anderem Wege zu. Alternativ kannst du sie dir auch selbst zusenden und die nächsten Schritte in einem neuen Ordner selber durchführen.
4. Lade deine empfangene Datei in einen neuen Ordner runter.
5. Binde die Datei deines Partners mit den oben genannten Schritten ein.
6. Öffne die Datei inhalt.txt und rede mit deinem Partner, ob der Inhalt mit seinem eingegebenen Text übereinstimmt.


__Hinweis:__\
Der Inhalt der virtuellen Festplatte ist, ähnlich zu einer normal .ZIP-Datei, nicht verschlüsselt oder geheim und kann von jedem eingesehen werden.
Um den Inhalt zu verschlüsseln, kann zusätzlich zu einem Dateisystem die LUKS-Festplattenverschlüsselung genutzt werden. Hierzu kann die Übung weiter unten genutzt werden.
Alternativ kann auf Software wie Veracrypt (https://www.veracrypt.fr/) genutzt werden.
Diese erstellt verschlüsselte Container und erlaubt einfaches mounten via einer GUI.

### Verschlüsseln des Inhalts der Datei

#### 1. Erstelle eine leere Datei mit einer Größe von 20MB oder mehr

```
dd if=/dev/zero of=virtDiskEncrypted.img bs=1024 count=20480
```

#### 2. Installiere „cryptsetup“ auf deinem System

```
sudo apt install cryptsetup
```

#### 3. Verschlüssele nun den Inhalt der Datei mittels cryptsetup.

```
sudo cryptsetup luksFormat virtDiskEncrypted.img
```

Hierbei wird die komplette datei.img zu LUKS formatiert und mit dem
gewählten Passwort verschlüsselt.\
__ACHTUNG: Eventuell vorhandener Inhalt wird gelöscht.__

#### 4. Entschlüssele die Datei, um ein Dateisystem zu erstellen

```
sudo cryptsetup open virtDiskEncrypted.img virtDiskDecrypted.img
````

Hier wird der Name der Datei (normalerweise die Festplatte/Partition)
angegeben, welche geöffnet werden soll. `virtDiskDecrypted.img` kann hierbei mit einem beliebigen Namen ersetzt werden und stellt nur den Namen dar, unter welchem die Datei entschlüsselt wird.

#### 5. Nun ist die Datei entschlüsselt worden und kann als normale Festplatte verwendet werden.

Der Pfad zu der entschlüsselten Partition ist `/dev/mapper/virtDiskDecrypted.img`, abhängig von dem vorher gewählten Entschlüsselungsnamen.

#### 6. Gehe nun die Schritte 2 bis 4 aus der 1. Aufgabe durch, um ein Dateisystem zu erstellen und zu mounten. 

Achte darauf, die Verweise auf "datei.img" mit dem
oben genannten Pfad zu der entschlüsselten Partition zu wählen.
Das Dateisystem ist nun nicht direkt innerhalb der Datei erstellt, sondern hat die LUKS-Partition als Mantel, welche die enthaltenen Daten verschlüsselt. Dadurch kann der Inhalt nur noch mithilfe des Passworts angesehen werden.

__Optional:__ Sende diese Datei deinem Partner und prüfe, ob sich die Datei mithilfe des
Passworts wieder öffnen lässt.