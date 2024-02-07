## Aufgabe 1

Erstellen Sie reguläre Ausdrücke, die folgende Zeichenketten beschreiben.

### Deutsche KFZ-Kennzeichen
### Datum im Format TT.MM.JJJJ

__Einfache Version__

+ Tage 01-31
+ Monate 01-12
+ Jahr 0000-9999

|01-09|10-29|30-31|10-12|0000-9999|
|-----|-----|-----|-----|---------|
|`0[1-9]`|`[1-2][0-9]`|`3[0-1]`|`1[0-2]`|`[0-9]{4}`|

=>

|01-31|01-12|0000-9999|
|-----|-----|---------|
|`(0[1-9]\|[1-2][0-9]\|3[0-1])`|`(0[1-9]\|1[0-2])`|`[0-9]{4}`|

```
(0[1-9]|[1-2][0-9]|3[0-1])\.(0[1-9]|1[0-2])\.([0-9]{4})
```

Bei verwendung mit `grep` müssen '(', ')', '{', '}' und '|' escaped werden.

```
grep "\(0[1-9]\|[1-2][0-9]\|3[0-1]\)\.\(0[1-9]\|1[0-2]\)\.\([0-9]\{4\}\)" filename
```

### IPv4-Adresse

+ 4 Zahlen 0-255 mit Punkten getrennt

| 0-9 | 10-99 | 100-199 | 200-249 | 250-255 | Punkt | Zeilenanfang | Zeilenende |
|-----|-------|-|-|---------|-|-|-|
|`[0-9]`|`[1-9][0-9]`|`1[0-9][0-9]`|`2[0-4][0-9]`|`25[0-5]`|`\.`|`^`|`$`|

__=>__

|0-255|
|-----|
|`([0-9]\|[1-9][0-9]\|1[0-9][0-9]\|2[0-4][0-9]\|25[0-5])`|

__IPv4:__ Zeilenanfang + (0-255 + Punkt) 3 mal + 0-255 + Zeilenende.

```
^(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\.){3}([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])$
```

Bei verwendung mit `grep` müssen '(', ')', '{', '}' und '|' escaped werden.

```
grep "^\(\([0-9]\|[1-9][0-9]\|1[0-9][0-9]\|2[0-4][0-9]\|25[0-5]\)\.\)\{3\}\([0-9]\|[1-9][0- 9]\|1[0-9][0-9]\|2[0-4][0-9]\|25[0-5]\)$" filename
```

### MAC-Adresse
### Überschriften in HTML

+ Beginnt mit \<h1\> bis \<h6\> oder \<H1\> bis \<H6\>
+ Dann eine beliebige Zeichenkette (die eigentliche Überschrift)
+ Endet mit \</h1\> bis \</h6\> oder \</H1\> bis \</H6\>

| Tag Anfang | Beliebiger Text (ohne Newlines) | Tag Ende |
|------------|----------------------|----------|
|`\<[Hh][1-6]\>`| `.*` |`\</[Hh][1-6]\>`|

```
\<[Hh][1-6]\>.*\</[Hh][1-6]\>
```

__Test Strings__

```
<!-- Matches -->
<H1>Heading 1</H1>
<h2>Heading 2</h2>
<h3>Heading 3</h3>
<h4></h4>
<h5> _</h5>
<H6>asdf%$§</h6>

<!-- Matches nicht -->
<H7>Heading 1</H7>
< h2>Heading 2</h2>
<h3>Heading 3<h3>
<p>normaler text</p>

<!-- Matches trotz syntaxfehler -->
<h1>false positive</h2>
```

### Gleitkommazahlen (z.B. -2.5e12)
### Klassenbezeichnungen an der Elektronikschule

## Aufgabe 2

Laden Sie sich den Linux-Sourcecode herunter.

`sudo apt source linux`

Falls das nicht funktioniert, zuvor in `/etc/apt/sources.list` das #-Zeichen vor den Zeilen mit deb-src entfernen.

Verwenden Sie den grep-Befehl um den kompletten Sourcecode des Linux-Kernels nach Schimpfwörtern zu durchsuchen.