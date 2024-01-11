### Aufgabe 1

Die fünfte Zeile der Datei /etc/passwd soll in eine Datei namens x kopiert werden.

```
sed -n 5p /etc/passwd > x
```

### Aufgabe 2

Erstellen Sie aus /etc/passwd eine Datei namens accounts.list, in der alle Accounts des Systems alphabetisch sortiert und nummeriert sind.

```
sort /etc/passwd | awk -F : '{print NR " " $1}' > accounts.list
```

### Aufgabe 3

Erstellen Sie eine Liste files.list aller derjenigen Dateien im Schulnetz, die Ihnen gehören. Vor dem Dateinamen und Pfad soll die Dateigröße (in K, M, G, ...) "human readable" angezeigt werden.

```
sudo find / -user $(whoami) -type f -exec ls -lh {} + | tr -s ' ' | cut -d' ' -f5,9- > files.list
```

### Aufgabe 4

Lassen Sie sich eine alphabetisch sortierte Liste aller aktuell eingeloggten User anzeigen. Ein mehrfach eingeloggter User soll nur einmal in der Liste auftreten.

```
users | sed s/\\s/\\n/g | sort | uniq
```

### Aufgabe 5

Erstellen Sie sich eine leicht veränderte Version einer Datei, die Sourcecode enthält. Lassen Sie sich eine Datei changes.txt erzeugen, die nur die geänderten Zeilen enthält.

```
diff <original_file> <changed_file> | grep -G ^[0-9] > changes.txt
```

Grep um nur die Zeilennummern zu sehen nich den geänderten Inhalt

### Aufgabe 6

Es soll gezählt werden, wie oft ein bestimmtes Wort im Zweig des aktuellen Verzeichnisbaums vorkommt. Die Summe soll ausgegeben werden.

```
pwd | grep -oi <wort> | wc -l
```

### Aufgabe 7

Erzeugen Sie mithilfe von /dev/urandom eine unendliche Folge von 16-bit Zufallszahlen in hexadezimaler Darstellung, die durch Semikolons voneinander getrennt sind.

Beispiel:

d994;7fa6;a182;9936;83df;bd7e;da9b;77d5;1459;9607;1d2a;...

```
hexdump -x /dev/urandom | awk '{printf "%s;", $2}'
```