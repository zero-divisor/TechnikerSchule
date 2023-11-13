# Software Entwicklung


## Index

* [Hello World](#hello-world)
* [Eingabe von Text über die Tastatur](#eingabe-von-text-über-die-tastatur)
* [Variablen](#variablen)
* [Operatoren](#operatoren)
* [Kommentare in Java](#kommentare-in-java)
* [Strings](#strings)


## Hello World

### Das Programm "Hello World"

```java
// Klassenname "HelloWorld"
public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
```

Öffnen Sie einen Texteditor (z.B. notepad, oder notepadd++) und tippen Sie das Programm. Speichern Sie es unter dem Dateinamen "HelloWorld.java" am besten auf Laufwerk H:. in Ihrem Homeverzeichnis in einem Unterordner "SAE". Achten Sie bei Dateinamen auf Groß- und Kleinschreibung.

Der Dateiname eines Java Quelltexts muss immer gleich lauten wie der Klassenname. Er hat immer die Endung ".java".

### Kompilieren von HelloWorld

Wechseln Sie mit Hilfe der Eingabeaufforderung (cmd) in das Verzeichnis in dem sich Ihr neuer Quelltext befindet.

Kompilieren Sie nun Ihr Programm mit dem Befehl.

```
javac HelloWorld.java
```

Ist das Kompilieren erfolgreich, wird nichts am Bildschirm ausgegeben.

### Betrachten des kompilierten ByteCode

Nun sollte das kompilierte Resultat in Form der Datei "HelloWorld.class" entstanden sein. Öffnen Sie die Datei "HelloWorld.class" mit einem Texteditor und betrachten Sie das Ergebnis. Sie sehen nun den kompilierten Bytecode.

### Starten von "HelloWorld"

Da Ihre "HelloWorld.class" nun durch den Compiler erstellt ist, können Sie Ihr Programm mit Hilfe der Laufzeitumgebung (Java Virtual Machine, kurz "JVM") starten. Dazu geben Sie im Verzeichnis der Datei HelloWorld.class folgenden Befehl ein:

```
java HelloWorld
```

## Eingabe von Text über die Tastatur

```java
import java.util.Scanner;

public class ErsteEingabe {

    public static void main(String[] args) {
        int zahl;
        Scanner keyboardInput = new Scanner(System.in);

        System.out.println("Bitte gib eine Zahl ein:");
        zahl = keyboardInput.nextInt();

        System.out.println("Deine eingegebene Zahl lautet: " + zahl);

        keyboardInput.close();
    }

}
```

## Variablen

Eine Variable ist ein Container in dem Daten während der Laufzeit des Programms gespeichert werden kann.

In Java hat eine Variable folgende Eigenschaften:

* __Typ:__ z.B. Zahl oder Text. Eine Liste mit Grundtypen in Java findet sich unten.
* __Name:__ unter diesem Namen kennt der Compiler die Variable. Es sollten nur sinnvolle Namen verwendet werden.
* __Wert:__ der Inhalt den man speichern möchte. Der Inhalt muss zum Typ passen!

| Typ     | Beschreibung          | Größe              | Wertebereich                                               | Literal |
| ------- | --------------------- |------------------- | ---------------------------------------------------------- |-------- |
| int     | ganze Zahl            | 4 Byte             | -2<sup>31</sup> bis 2<sup>31</sup>                         | 34      |
| double  | Zahl mit Komma        | 8 Byte             | &#177;1.4\*10<sup>-45</sup> bis &#177;3.4\*10<sup>38</sup> | 2.6     |
| char    | Ein einzelnes Zeichen | 2 Byte             | Unicode Tabelle                                            | 'F'     |
| String  | Eine Zeichenkette     | 2 Byte pro Zeichen | Unicode Tabelle                                            | "Hello" |
| boolean | Ein Wahrheitswert     | 1-4 Byte           | `true` oder `false`                                        | `true`  |

### Variablen definieren:

z.B. Definieren einer Integer Variable:

```java
int zahl;
```

### Werte zuweisen:

```java
zahl = 3;
```

### Abkürzung (Definition und Zuweisung in einem):

```java
int zahl = 3;
```

### weitere Beispiele:

```java
String text = "HelloWorld";
boolean volljährig = true;
char zeichen = 'x';
double geldbetrag = 3.99;
```

## Operatoren

### Arithmetische Operatoren:

Arithmetische Operatoren sind binäre Operatoren, welche immer mit zwei Operanden arbeiten und bei denen immer die Punkt-vor-Strich-Regel gilt.

| Operator | Verhalten            |
|----|----------------------------|
| \+ | Addition                   |
| \- | Subtraktion                |
| \* |Multiplikation              |
| /  | Division                   |
| %  | Modulo (Rest der Division) |

### Zuweisungsoperator (=):

```java
zahl = 5;
```

Der Zuweisungsoperator weist der Variable auf der linken Seite, den Ausdruck auf der rechten Seite zu.\
Dabei wird der Ausdruck auf der rechten Seite vor der Zuweisung zuerst ausgewertet.

Ein Ausdruck kann aus Variablen oder Werten bestehen.

__Beispiele (Zuweisung von Werten):__

```java
zeichen = 'A';
text = "Hallo";
kommazahl = 3.44;
i = i + 1;
```

__Allgemein:__

```java
variable = anderevariable + 3;
```

### Inkrement- und Dekrementoperatoren (++,--):

Inkrement- und Dekrementoperatoren sind _unär_ und erhöhen bzw. erniedrigen den Wert einer Variablen um eins.

```
++zahl oder zahl++ Addition
--zahl oder zahl-- Subtraktion
```

__Beispiel:__

```java
int zahl = 5;
System.out.println(++zahl); // Ausgabe: 6
System.out.println(zahl++); // Ausgabe: 5
```

### Spezialfall Integerdivision:

```java
double zahl = 3.0 / 2.0; // Zahl hat den Wert 1.5
int zahl = 3 / 2;        // Zahl hat den Wert 1. Das Ergebnis 1.5 wird abgerundet.
```

### Spezialfall Modulo:

Der Modulo-Operator (%) ermittelt den Rest der Division.

__Beispiele:__

```java
10 % 3     // hat den Wert 1 , da 10 : 3 = 3 Rest 1
11 % 3     // hat den Wert 2 , da 11 : 3 = 3 Rest 2
2 % 3      // hat den Wert 2 , da  2 : 3 = 0 Rest 2
10.1 % 3.1 // hat den Wert 0.8 , da 10,1 : 3,1 = 9,3 Rest 0,8
```

## Kommentare in Java

Es gibt in Java ein- und mehrzeilige Kommentare:

__Einzeiliger Kommentar:__ Text, der im Programmcode hinter einem // steht bis zum Zeilenende.\
__Mehrzeiliger Kommentar:__ Alles was zwischen den Zeichenfolgen /* und */ steht, auch über mehrere Zeilen.

__Beispiel:__

```java
// Author: Max Mustermann
// Datum: 09.10.2015
public class HelloWorld {
    public static void main(String[] args) {
        int i = 2;
        i = i * 5; // In dieser Zeile wird i mit 5 multipliziert.
        i++;       // In dieser Zeile wird i um eins erhöht.
        
        /* Der folgende Abschnitt ist noch nicht fertig.
        System.out.println(i);
        i++;
        */
    }
}
```

## Strings

String ist ein Variablentyp, der Zeichenketten als Werte speichern kann.

```java
public class StringsAufgaben {

    public static void main(String[] args) {
        String text;
        text = "Hello World";
        System.out.println(text);

        String stundenplan;
        stundenplan = "1.\tSAE\n2.\tSAE\n3.\tBWL\n4.\tBWL\n5.\tWI\n6.\tREL";
        System.out.println(stundenplan);

        // Aneinanderhängen von beliebig vielen Zeichenketten (Der + Operator)
        String vname = "Vorname";
        String nname = "Nachname";
        String ausgabe = vname + " " + nname;
        System.out.println(ausgabe);
    }
}
```

### Methoden des String-Objekts:

Eine String-Variable ist kein primitiver Datentyp sondern ein Objekt. Sie besitzt nicht nur einen Wert (die Zeichenkette), sondern auch Methoden um bestimmte Eigenschaften dieser Zeichenkette zu ermitteln oder die gespeicherte Zeichenkette zu verändern.

#### Die length-Methode: Länge einer Zeichenkette ermitteln:

```java
String text = "Hello World";
int laenge = text.length();
System.out.println("Der Text ist " + laenge + " Zeichen lang.");
```

#### Die charAt-Methode: Zeichen an einer bestimmten Position ermitteln:

Die Zeichen in einer Zeichenkette sind mit einem Index durchnummeriert, beginnend bei 0.

|H |e |l |l |o |  |W |o |r |l |d |
|--|--|--|--|--|--|--|--|--|--|--|
|0 |1 |2 |3 |4 |5 |6 |7 |8 |9 |10|


```java
String text = "Hello World";
char zeichen = text.charAt(4);
System.out.println("Das ermittelte Zeichen lautet " + zeichen + ".");
```

#### Die substring-Methode: Einen Teil der Zeichenkette ermitteln:

```java
String text = "Hello World";
String erstesWort = text.substring(0, 5); // Ermittelt die Zeichen 0 bis 4
String zweitesWort = text.substring(6, 11); // Ermittelt die Zeichen 6 bis 10
```

Der Startindex ist mit dabei, der Endindex nicht mehr.

#### Die replace-Methode: Ein Zeichen in der Zeichenkette ersetzen:

```java
String text = "Hello World";
String neuerText = text.replace('W','w');
System.out.println(neuerText);
```
