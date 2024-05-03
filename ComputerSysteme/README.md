# Computer Systeme


## Index

* [Grundlagen der Befehlszeile](#grundlagen-der-befehlszeile)
* [Hilfe suchen über die Befehlszeile](#hilfe-suchen-über-die-befehlszeile)
* [Verzeichnisse verwenden und Dateien auflisten](#verzeichnisse-verwenden-und-dateien-auflisten)
* [Erstellen, Verschieben und Löschen von Dateien](#erstellen-verschieben-und-löschen-von-dateien)
* [Suchen und Finden von Dateien](#suchen-und-finden-von-dateien)
* [Streams](#streams)
* [Stream Editor sed](#stream-editor-sed)
* [Reguläre Ausdrücke](#reguläre-ausdrücke)
* [Lokale Benutzerverwaltung](#lokale-benutzerverwaltung)
* [Special permissions SUID SGID and sticky bit](#special-permissions-suid-sgid-and-sticky-bit)

## Grundlagen der Befehlszeile

#### [Lektion 1](https://learning.lpi.org/de/learning-materials/010-160/2/2.1/2.1_01/)

#### [Lektion 2](https://learning.lpi.org/de/learning-materials/010-160/2/2.1/2.1_02/)

## Hilfe suchen über die Befehlszeile

#### [Lektion 1](https://learning.lpi.org/de/learning-materials/010-160/2/2.2/2.2_01/)

## Verzeichnisse verwenden und Dateien auflisten

#### [Lektion 1](https://learning.lpi.org/de/learning-materials/010-160/2/2.3/2.3_01/)

#### [Lektion 2](https://learning.lpi.org/de/learning-materials/010-160/2/2.3/2.3_02/)

## Erstellen, Verschieben und Löschen von Dateien

#### [Lektion 1](https://learning.lpi.org/de/learning-materials/010-160/2/2.4/2.4_01/)

## Suchen und Finden von Dateien

### Tiefensuche

- `find` Befehl
- Nachteile: Suche ist zeitaufwändig, weil jeder Dateiname auf der Festplatte "angeschaut" werden muss.

### Datenbnkbasiert/Indiziert

- `locate` Befehl
- Vorteile: Deutlich schneller als Tiefensuche
- Nachteile: Es werden nur Dateien gefunden, die in der Datenbank vorhanden sind. Wird eine Datei gelöscht kann es sein, dass sie fälschlicherweise dennoch als existent angezeigt wird.

## Streams

```
Standardinput (stdin/stream 0)
    -> Programm/Skript
        -> Standardoutput (stdout/stream 1)
        -> Standarderror  (stderr/stream 2)
```

### Streams in Dateien umleiten

`stdout` in Datei umleiten

```
befehl 1> Dateiname
befehl > Dateiname
```

`stdout` an Datei anhängen

```
befehl >> Dateiname
```

`stderr` in Datei umleiten

```
befehl 2> Dateiname
```

`stderr` an Datei anhängen

```
befehl 2>> Dateiname
```

Inhalt von Datei als `stdin` verwenden

```
befehl < Dateiname
```

### Pipes (Streams in andere Programme umleiten)

Standardoutput von Programm1 zu Standardinput von Programm2 leiten

```
Prgoramm1 | Programm2
```

## Stream Editor sed

```
sed [options] sed-command [input-file]
```

| Option | Description                             | Example                                      |
| ------ |---------------------------------------- | -------------------------------------------- |
| `-n`   | Suppress default pattern space printing | `sed -n '3 p' config.conf`                   |
| `-i`   | Backup and modify input file directly   | `sed -ibak 's/On/Off/' php.ini`              |
| `-f`   | Execute sed script file                 | `sed -f script.sed config.conf`              |
| `-e`   | Execute multiple sed commands           | `sed -e 'command1' -e 'command2' input-file` |

### Sed commands

| Command | Description                  | Example                                   |
| ------- |----------------------------- | ----------------------------------------- |
| `p`     | Print pattern space          | `sed -n '1,4 p' input.txt`                |
| `d`     | Delete lines                 | `sed -n '1,4 d' input.txt`                |
| `w`     | Write pattern space to file  | `sed -n '1,4 w output.txt' input.txt`     |
| `a`     | Append line after            | `sed '2 a new-line' input.txt`            |
| `a`     | Insert line before           | `sed '2 i new-line' input.txt`            |

### Sed substitute command and flags

```
 sed 's/original-string/replacement-string/[flags]' [input-file]
 ```
 
| Flag             | Description                                 | Example                                                |
| ---------------- |-------------------------------------------- | ------------------------------------------------------ |
| `g`              | Global substitution                         | `sed 's/development/production/g' .env`                |
| `1,2...`         | Substitute the nth occurrence               | `sed 's/latin1/utf8/2' locale.sql`                     |
| `p`              | Print only the substituted line             | `sed -n 's/error_log = 0/error_log = 1/p' php.ini`     |
| `w`              | Write only the substituted line to a file   | `sed -n 's/One/Two/w output.txt' words.txt`            |
| `i`              | Ignore case while searching                 | `sed 's/true/FALSE/i' config.php`                      |
| `e`              | Substitute and execute in the command line  | `sed 's/^/ls -l /e' files.list`                        |
| `/ | ^ @ !`      | Substitution delimiter can be any character | `sed 's|/usr/local/bin|/usr/bin|' paths.list`          |
| `&`              | Gets the matched pattern                    | `sed 's/^.*/<&>/' index.xml`                           |
| `( ) \1 \2 \3` | Group using `(` and `)`.<br>Use `\1`, `\2` in replacement to refer the group | `sed 's/([^,]*),([^,]*),([^,]*).*/\1,\3/g' words.txt` |

### Loops and multi-line sed commands

| Command    | Description                                                        | Example                                         |
| ---------- |------------------------------------------------------------------- | ----------------------------------------------- |
| `b lablel` | Branch to a label (for looping)                                    |                                                 |
| `t lablel` | Branch to a label only on successful substitution<br>(for looping) |                                                 |
| `:lablel`  | Label for the b and t commands (for looping)                       |                                                 |
| `N`        | Append next line to pattern space                                  | `sed = file.txt | sed "N;s/\n/$(printf '\t')/"` |
| `P`        | Print 1st line in multi-line                                       |                                                 |
| `D`        | Delete 1st line in multi-line                                      |                                                 |

### Sed hold and pattern space commands

| Command | Description                                                  |
| ------- |------------------------------------------------------------- |
| `n`     | Print pattern space, empty pattern space, and read next line |
| `x`     | Swap pattern space with hold space                           |
| `h`     | Copy pattern space to hold space                             |
| `H`     | Append pattern space to hold space                           |
| `g`     | Copy hold space to pattern space                             |
| `G`     | Append hold space to pattern space                           |


## Reguläre Ausdrücke

Regular Expressions (regex) sind Zeichenketten, die Zeichenketten beschreiben.

__z.B.__ 
- `Tag` beschreibt die Zeichenkette Tag.
- `[0-3]` eine Zahl zwischen 0 und 3
- `[Tt]` T oder t

```
grep [Tt]est fileName
```

Regex sind universell und werden durch alle gängigen Skript- und Programmiersprachen unterstützt.

__Vorsicht :__ Es gibt verschiedene Dialekte.\
__Vorsicht2:__ Regex können schnell unübersichtlich werden

## Lokale Benutzerverwaltung

### Zugriffsrechte auf Dateien

[Ubuntu Wiki Rechte](https://wiki.ubuntuusers.de/Rechte/)

[Crash Course File & Directory Permissions](https://www.youtube.com/watch?v=4e669hSjaX8)

### Grundsätzliche Forderungen der IT-Sicherheit an Accounts und Passwörter

+ __Probleme mit dem root-Verfahren:__
    + Wenn es mehr als einen Administrator gibt, teilen sich mehrere Personen     ein Password/Account! -> NO GO!
    + Aktionen auf dem System sind nicht auf den Verursacher rückführbar -> NO GO!
    + Jeder, der das Passwort hat und den Account nutzt, hat *alle* Rechte, egal ob er sich braucht oder nicht -> NO GO!
+ __Forderungen der IT-Sicherheit:__
    + Hinter jedem für Menschen zugänglichen Benutzeraccount darf nur *EINE* menschliche Person stehen!
    + Jede Aktion muss (technisch) auf genau diesen EINZELNEN Benutzer zurückführbar sein.
    + Rechte dürfen nur so sparsam wie möglich vergeben werden (d.h. wenn jemand z.B. nur für die Softwareinstallationen zuständig ist, dann darf er keinen Zugriff auf die Benutzeradministration haben)
+ __Lösung der Problematik:__
    + sudo ("Super-User Do")
    + RBAC (Role-based Access Control)
    + Mittlerweile bei gängigen Distributionen der Standard
    + Bei Ubuntu: Erster Benutzer, der angelegt wird ist eine sogenannter "sudoer"
    + Wer sudoers ist, wird in der Datei /etc/sudoers festgelegt
    + Editieren nur mit visudo, nicht mit dem "blanken" vi
    + Vorsicht: Man kann sich "aussperren"!
 
 ## Special permissions SUID SGID and sticky bit