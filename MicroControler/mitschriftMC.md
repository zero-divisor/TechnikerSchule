# Microcontroler


## Index

* [Kontrollstrukturen](#kontrollstrukturen)


## Kontrollstrukturen

### if-else

<img src="images/if-else.PNG" width="80%">

Programmcode:

```c
// bedingung muss vom Typ boolean (true/false) sein

if(bedingung) {
	// Aktion 1
}

if(bedingung) {
	// Aktion 1
} else {
	// Aktion 2
}
```

### Schleifen

#### while-Schleife

<img src="images/while-loop.PNG" width="70%">

Eine while-Schleife wiederholt den Code innerhalb der geschweiften { } Klammern, bis die Bedingung in den runden Klammern nicht mehr wahr ist.

Um die Schleife zu verlassen, muss der Wert der Bedingung innerhalb der geschweiften { } Klammern geändert werden.

__oder:__ Die Bedingung ist von einem externen Event abhängig
z.B.
```c
while(digitalRead(someInput) == HIGH)
```

Programmcode:

```c
while(bedingung) {
	// Schleifenkörper
}
```

#### do-while-Schleife

<img src="images/do-while-loop.PNG" width="40%">

Die do-while-Schleife verhält sich wie die while-Schleife, jedoch wird die Bedingung erst am Ende der Schleife überprüft.\
Die do-while-Schleife wird also immer mindestens 1x durchlaufen.

Programmcode:

```c
do {
	// Schleifenkörper
} while(bedingung)
```

#### for-Schleife

<img src="images/for-loop.PNG" width="70%">

Die for-Schleife wird dann benutzt, wenn zu Beginn feststeht wie oft die Schleife durchlaufen werden soll.

Programmcode:

```c
for(byte i=0; i<10; i++) {
	// Schleifenkörper
}

// "byte i=0;" Initialisierung: Startwert festlegen (Variable)
// "i<10;" Bedingung: Wann soll die Schleife abgebrochen werden?
// "i++" Postoperation: Behandlung des Schleifenzählers 
//                      nach einem Schleifendurchlauf
```

### switch-case

<img src="images/switch-case.PNG" width="50%">

### Funktionen