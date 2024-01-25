# Computer Systeme


## Index

* [Grundlagen der Befehlszeile](#grundlagen-der-befehlszeile)
* [Hilfe suchen über die Befehlszeile](#hilfe-suchen-über-die-befehlszeile)
* [Verzeichnisse verwenden und Dateien auflisten](#verzeichnisse-verwenden-und-dateien-auflisten)
* [Erstellen, Verschieben und Löschen von Dateien](#erstellen-verschieben-und-löschen-von-dateien)
* [Suchen und Finden von Dateien](#suchen-und-finden-von-dateien)
* [Streams](#streams)
* [Stream Editor sed](#stream-editor-sed)
* [Vim](#vim)

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



## Vim

Mode verlassen/zurück zu command mode: `Esc`.
Input mode: `i,I,a,A,o,O`
Replace mode: `r,R`
Ex mode: `:`

Zeile Löschen: `dd`
Wort löschen: `dw`