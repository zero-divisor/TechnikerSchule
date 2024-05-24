### Make yourself familiar with the following Unix/Linux tools.

__ps:__ Zeigt laufende Prozesse an.

__pstree:__ Zeigt laufende Prozesse als Baum an.

__top, htop:__ Zeigt laufende Prozesse in echtzeit an. Hat auch Prozessverwaltungsfunktionen.

__GUI system resource monitor:__ Gleich wie top/htop aber mit gui.

### Find out how you can use ps to identify and display

__the PID of a process with a certain name__

```
ps -C <prozessname> -o pid=<Spaltenüberschrift>
```

+ `-C` wählt nach Befehlsnamen aus.\
+ `-o` legt das benutzerdefinierte Format fest.\
+ `pid=<Spaltenüberschrift>` legt den Titel in der Kopfzeile fest. Ohne Kopfzeile falls leer.

```
$ ps -C cmus -o pid=ProzessID
ProzessID
     1943

$ ps -C cmus -o pid=
   1943
```

__the process state of a process with a certain PID or name__


### Make yourself familiar with the following bash features:

+ jobs
+ bg
+ fg
+ &


### What do bash jobs have to do with processes?

### Analyze the following C program and explain what it does.

```c
#include <unistd.h>
int main(int argc, char** argv)
{
    while(1)
        fork();
    return 0;
}
```

### Open your GUI system resource monitor, compile and run the program.


### What security mechanism does Linux provide to prevent such code from causing harm?
