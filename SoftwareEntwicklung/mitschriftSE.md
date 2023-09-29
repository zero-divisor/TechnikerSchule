# Software Entwicklung


## Index

* [Hello World](#hello-world)


## Hello World

### Das Programm „Hello World“

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