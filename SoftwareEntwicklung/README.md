# Software Entwicklung


## Index

* [Hello World](#hello-world)
* [Eingabe von Text über die Tastatur](#eingabe-von-text-über-die-tastatur)
* [Variablen](#variablen)


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