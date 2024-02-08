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

Bei verwendung mit `grep` müssen die Metacharacters '(', ')', '{', '}' und '|' escaped werden.

```
grep "\(0[1-9]\|[1-2][0-9]\|3[0-1]\)\.\(0[1-9]\|1[0-2]\)\.\([0-9]\{4\}\)" filename
```

Eine Regex, die berücksichtigt, dass Monate unterschiedlich viele Tage haben, ist dem Leser als Übungsaufgabe überlassen.

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

Bei verwendung mit `grep` müssen die Metacharacters '(', ')', '{', '}' und '|' escaped werden.

```
grep "^\(\([0-9]\|[1-9][0-9]\|1[0-9][0-9]\|2[0-4][0-9]\|25[0-5]\)\.\)\{3\}\([0-9]\|[1-9][0- 9]\|1[0-9][0-9]\|2[0-4][0-9]\|25[0-5]\)$" filename
```

### MAC-Adresse

+ 6 Bytes Hexadezimal
+ getrennt durch ':', '-' oder ohne trennzeichen

| Trennzeichen (':', '-' oder nichts) | 2-Stellige Hexadezimalzahl |
|--------------|------------------|
|`[:-]?`       |`[:xdigit:]{2}`   |

__MAC:__ (byte + Trennzeichen) 5 mal + Byte

```
^([:xdigit:]{2}[:-]?){5}[:xdigit:]{2}$
```

Bei verwendung mit `grep` müssen die Metacharacters '(', ')', '{', '}' und '?' escaped werden, und die Syntax für `[:xdigit:]` ist `[[:xdigit:]]`

```
grep "^\([[:xdigit:]]\{2\}[:-]\?\)\{5\}[[:xdigit:]]\{2\}$" filename
```

__Test Strings__

```
// Matches
d7:bd:db:00:c6:02
ef-3b-de-e2-44-2d
ae76f5fadf83
9c:7b:13:f1:04:94
1c:e5:e8:8b:d7:21
D7:BD:DB:00:c6:02
ef-3b-de-e2-44-2d
Ae76f5fadf83
9C:7B:13:F1:04:94
1c:e5:e8:8b:d7:21

// Matches nicht
D7:HD:DB:00:c6:02
ef-3j-de-e2-44-2d
Ae76f5fadf83ab
9C:7B:13:F1:04:94:94
1c:e5:e8:8b:d7
```

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

+ Beginnt mit '+' oder '-' oder ohne Vorzeichen
+ ene Ziffer 
+ dann Dezimalpunkt
+ dann beliebig viele Nachkommastellen (min. 1)
+ danach 'e' oder 'E'
+ dann '+' oder '-' oder kein Vorzeichen
+ dann exponent 0 bis Unendlich bzw. 1 bis Unendlich bei negativem Vorzeichen

|e oder E|+, - oder nichts|Ziffer|Punkt|1 bis Unendlich|0 bis Unendlich|0 bis Unendlich ohne voranstehende nullen|
|--------|----------------|------|-----|---------------|---------------|---------------|
|`[Ee]`|`[\+-]?`|`[0-9]`|`\.`|`[1-9][0-9]*`|`[0-9]+`|`(0\|[1-9][0-9]*)`|

```
^[\+-]?[0-9]\.[0-9]+[Ee](-[1-9][0-9]*|\+?(0|[1-9][0-9]*))$
```

Bei verwendung mit `grep` müssen die Metacharacters '(', ')', '?', '+' und '|' escaped werden.

```
grep "^[\+-]\?[0-9]\.[0-9]\+[Ee]\(-[1-9][0-9]*\|+\?\(0\|[1-9][0-9]*\)\)$" filename
```

__Test Strings__

```
// Matches
-2.5e12
2.5e120
-2.5e-12
2.5344E12
2.0000005e1
2.5e+12
1.0E1
0.0e-1234

// Keine Matches
-21.5e12
1.5e-0
2.5e012
2.5E-01
2e12
2e-12
```

### Klassenbezeichnungen an der Elektronikschule

## Aufgabe 2

Laden Sie sich den Linux-Sourcecode herunter.

`sudo apt source linux`

Falls das nicht funktioniert, zuvor in `/etc/apt/sources.list` das #-Zeichen vor den Zeilen mit deb-src entfernen.

Verwenden Sie den grep-Befehl um den kompletten Sourcecode des Linux-Kernels nach Schimpfwörtern zu durchsuchen.