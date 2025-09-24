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
* [Benutzer und Gruppen](#benutzer-und-gruppen)
* [Prozesse und Prozessmanagement](#prozesse-und-prozessmanagement)
* [Jobs and Job Control in Bash](#jobs-and-job-control-in-bash)
* [Partitionen und Mounten](#partitionen-und-mounten)
* [Hardlinks und Symbolische Links](#hardlinks-und-symbolische-links)
* [Logical Volume Manager](#logical-volume-manager)
* [Datenkomprimierung](#datenkomprimierung)
* [Backups](#Backups)
* [Linux Bootvorgang](#linux-bootvorgang)
* [Softwaremanagement](#softwaremanagement)
* [Basic Networking](#basic-networking)

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

__Beispiel__

```bash
$ find <directory_path> <search_parameter>
$ find . -name .gitignore
```

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
 
There are two special permissions that can be set on executable files: Set User ID (setuid) and Set Group ID (sgid). These permissions allow the file being executed to be executed with the privileges of the owner or the group. Similarly, there are two special permissions for directories: the sticky bit and the setgid bit.

### What is Set User ID (setuid)?

SUID is a special permission assigned to a file. These permissions allow the file being executed to be executed with the privileges of the owner. For example, if a file was owned by the root user and has the setuid bit set, no matter who executed the file it would always run with root user privileges.

### How to set SUID bit on a file?

You must be the owner of the file or the root user to set the setuid bit. Run the following command to set the setuid bit:

```
# chmod u+s file1
```

View the permissions using the ls -l command:

```
# ls -l file1
-rwSrw-r-- 1 user1 user1 0 2017-10-29 21:41 file1
```

Note the __capital S__. This means there are no execute permissions. Run the following command to add execute permissions to the file1 file, noting the __lower case s__.

```
# chmod u+x file1
```
```
# ls -l file1
-rwsrw-r-- 1 user1 user1 0 2017-10-29 21:41 file1
```

Note the lower case s. This means there are execute permissions.

Alternatively, you can set the setuid bit using the numeric method by prepending a 4 to the mode. For example, to set the setuid bit, read, write, and execute permissions for the owner of the file1 file, run the following command:

```
# chmod 4700 file1
```

### What is Set Group ID (setgid) for files?

When the Set Group ID bit is set, the executable is run with the authority of the group. For example, if a file was owned by the users’ group, no matter who executed that file it would always run with the authority of the user’s group.

### How to set the SGID bit for files?

Run the following command as to set the setgid bit on the file1 file:

```
# chmod g+s
```

__Note:__ Both the setuid and setgid bits are set using the s symbol. The setgid is represented the same as the setuid bit, except in the group section of the permissions.

Run the following command as root to set the setgid bit, and read, write, and execute permissions for the owner of the file1 file:

```
# chmod 2700 file1
```

The setgid is represented the same as the setuid bit, except in the group section of the permissions:

```
ls -l file1
-rwx--S--- 1 user1 user1 0 2017-10-30 21:40 file1
```

### What is Set Group ID permissions for directories?

When the setgid bit is set on a directory, all files created within said directory inherit the group ownership of that directory. For example, the folder1 folder is owned by the user user1, and the group group1:

```
# ls -ld folder1
drwxrwxr-x 2 user1 group1 4096 2017-10-30 22:25 folder1
```

Files created in the folder1 folder will inherit the group1 group membership:

```
# touch folder1/file1
# ls -l folder1/file1
-rw-rw-r-- 1 user1 group1 0 2017-10-30 22:29 folder1/file1
```

## How to set the SGID bit for directories?

To set the setgid bit on a directory, use the chmod g+s command:

```
# chmod g+s folder1
```

View the permissions using the ls -ld command, noting the s in the group permissions:

```
# ls -ld folder1
drwxrwsr-x 2 user1 group1 4096 2017-10-30 22:32 folder1
```

Alternatively, prepend a 2 to the directories mode:

```
# chmod 2770 folder1
```

### What is sticky bit on a directory

When the sticky bit is set on a directory, only the root user, the owner of the directory, and the owner of a file can remove files within said directory.

### How to set sticky bit

An example of the sticky bit is the /tmp directory. Use the ls -ld /tmp command to view the permissions:

```
# ls -ld /tmp
drwxrwxrwt  24 root root  4096 2017-10-30 22:00 tmp
```

The __t__ at the end symbolizes that the sticky bit is set. A file created in the /tmp directory can only be removed by its owner, or the root user. For example, run the following command to set the sticky bit on the folder1 folder:

```
# chmod a+t folder1
```

Alternatively, prepend a 1 to the mode of a directory to set the sticky bit:

```
# chmod 1777 folder1
```

The permissions should be read, write, and execute for the owner, group, and everyone else, on directories that have the sticky bit set. This allows anyone to cd into the directory and create files.

### how to find files with SUID/SGID but set

1. To find all the files with SUID but set, use the below command:

```
# find / -perm +4000
```

2. Tofind all the files with SGID bit set, use the below command:

```
# find / -perm +2000
```

You can also combine both the commands to find both SGID and SUID but set files.

```
# find / -type f \\( -perm -4000 -o -perm -2000 \\) -exec ls -l {} \\;
```

## Benutzer und Gruppen

In Debian, there are two command-line tools that you can use to create a new user account: `useradd` and `adduser`.

`useradd` is a low-level utility for adding users while the `adduser` is a friendly interactive frontend to useradd written in Perl.

To create a new user account named `username` using the `adduser` command you would run:

```
$ sudo adduser username
```


Output:

```
Adding user `username' ...
Adding new group `username' (1001) ...
Adding new user `username' (1001) with group `username' ...
Creating home directory `/home/username' ...
Copying files from `/etc/skel' ...
```

You will be asked a series of questions. The password is required, and all other fields are optional.

```
Enter new UNIX password: 
Retype new UNIX password: 
passwd: password updated successfully
Changing the user information for username
Enter the new value, or press ENTER for the default
	Full Name []: 
	Room Number []: 
	Work Phone []: 
	Home Phone []: 
	Other []: 
Is the information correct? [Y/n]
```

On the last prompt you’ll need to confirm that the information is correct by entering `Y`.

The command will create the new user’s home directory, and copy files from `/etc/skel` directory to the user’s home directory. Within the home directory, the user can write, edit, and delete files and directories.

By default on Debian, members of the group sudo are granted with sudo access.

If you want the newly created user to have administrative rights, add the user to the sudo group:

```
$ sudo usermod -aG sudo username
```

### Beispiel

Es werden zwei neue Benutzer angelegt, die einer eigenen ebenfalls neu angelegten Sekundärgruppe angehören.

```
$ sudo adduser newuser1
Adding user `newuser1' ...
Adding new group `newuser1' (1004) ...
Adding new user `newuser1' (1004) with group `newuser1' ...
Creating home directory `/home/newuser1' ...
Copying files from `/etc/skel' ...
Geben Sie ein neues Passwort ein:
Geben Sie das neue Passwort erneut ein:
passwd: Passwort erfolgreich geändert
Benutzerinformationen für newuser1 werden geändert.
Geben Sie einen neuen Wert an oder drücken Sie ENTER für den Standardwert
        Vollständiger Name []: new1
        Zimmernummer []:
        Telefon geschäftlich []:
        Telefon privat []:
        Sonstiges []:
Is the information correct? [Y/n] Y
```

```
$ sudo adduser newuser2
Adding user `newuser2' ...
Adding new group `newuser2' (1005) ...
Adding new user `newuser2' (1005) with group `newuser2' ...
Creating home directory `/home/newuser2' ...
Copying files from `/etc/skel' ...
Geben Sie ein neues Passwort ein:
Geben Sie das neue Passwort erneut ein:
passwd: Passwort erfolgreich geändert
Benutzerinformationen für newuser2 werden geändert.
Geben Sie einen neuen Wert an oder drücken Sie ENTER für den Standardwert
        Vollständiger Name []: new2
        Zimmernummer []:
        Telefon geschäftlich []:
        Telefon privat []:
        Sonstiges []:
Is the information correct? [Y/n] Y
```

```
$ sudo addgroup newgroup1
Adding group `newgroup1' (GID 1006) ...
Done.
```

```
$ sudo usermod -aG newgroup1 newuser1
$ sudo usermod -aG newgroup1 newuser2
```


#### Die Einträge in `/etc/passwd`, `/etc/shadow` und `/etc/group` sehen dann wie folgt aus.


```
$ tail -n 2 /etc/passwd
newuser1:x:1004:1004:new1,,,:/home/newuser1:/bin/bash
newuser2:x:1005:1005:new2,,,:/home/newuser2:/bin/bash
```

```
$ sudo tail -n 2 /etc/shadow
newuser1:$y$j9T$2SK2e7mRHvE/FGiOTtE5A/$zLR0d.9OGRxiAuV5ogsHhprR04n2wURnISq6PwrjtsA:19856:0:99999:7:::
newuser2:$y$j9T$uGUxKRUEMGYN3aTcfUrhg1$nMNYLEOm0KWqlrXH0ra2WllSESTX4YoWvYNc7cdS4cA:19856:0:99999:7:::
```

```
$ tail -n 3 /etc/group
newuser1:x:1004:
newuser2:x:1005:
newgroup1:x:1006:newuser1,newuser2
```

## Prozesse und Prozessmanagement

### What is a process?

+ A process is an instance of a program that is being executed
+ A process may have one or more child processes and be a child of its parent process.
+ Instructions within one process may be executed concurrently by multiple threads.

### Program vs. Process

+ Baking analogy
  + CPU → Baker
  + Input Data → Cake Ingredients
  + Program → Recipe
+ “... a program is something that may be stored on disk, not doing anything.”

### Process Model

<img src="images/prozesse.PNG">

### Execution on a Single-Core CPU

<img src="images/single_core.PNG">

### Context Switch

+ A context completely describes a process’s current state of
execution.
  + Program counter
  + Registers
  + Virtual address space
+ During a context switch ...
  + the current process’s execution is suspended
  + the context information for that process is stored
  + the context of the next process is retrieved from memory and restored in
the CPU’s registers
  + the execution of the new process is resumed at the location indicated by
the program counter
+ Hardware context switching
  + Context switch completely performed by CPU hardware
+ Software context switching
  + Context switch performed by the operating system
  + Often preferred for performance and portability reasons
+ Context switches are performed by a component
called dispatcher, which is part of the scheduler. The
dispatcher also alters the flow of execution that is
required in a context switch.

### Processes vs. Threads

+ A single process can have multiple threads.
+ A thread represents a separate, independent, path of execution
within a process.
+ All threads of a process share the process’s address space
(memory).
+ Each thread has its own execution stack
  + Multiple threads can call the execute the same function concurrently
+ Advantages of threads over processes
  + less context switching time
  + easier, more efficient, communication between threads
  + concurrency within a process

### Process-related OS Objectives

+ Maximize processor utilization
+ Allocate resources to processes
+ Prioritize execution
+ Allow for user creation of processes
+ Provide mechanisms for synchronization and
inter-process communication

### Process Control Block (PCB)

<img src="images/pcb.PNG">

### Process States

<img src="images/states.PNG">

### Process States on Linux

<img src="images/states_linux.PNG">

## Jobs and Job Control in Bash

### Processes and Jobs in bash Shell

A process in Linux means any running program. For example, when we run `ls`, it’s run as a process. If we search for a filename, by using `ls -l` and piping the result to `grep`, we’re actually running two processes:

```bash
$ ls -l | grep script
-rwxr-xr-x 1 ubuntu users 18 Aug  2 21:44 myscript.sh
```

Since one command may cause several processes to run, it’s represented as a job in the bash shell and is the logical grouping of processes run from a single command or script.

### Pausing and Resuming Jobs

In our `ls` example, we usually expect execution to complete immediately and return us to the shell prompt. But if a command takes a while, we need to wait for it to terminate. And, if we want to run another command while we’re waiting, we would need to open another shell.

Let’s say we ran a `find` command and it has already displayed the file we think we’re looking for. We could press `Ctrl+C` to stop the command. But, maybe it would be preferable to pause find so we can double-check, and resume it if necessary.

We can pause the current job with `Ctrl+Z`:

```bash
$ find . -name "*.java"
./code/com/my/package/Main.java
^Z
[1]+  Stopped                 find . -name "*.java"
```

Here, we ran the `find` command and pressed `Ctrl+Z` (^Z) after we saw some output. Pausing the job caused a prompt showing us the job number `[1]` and a message that it has been Stopped. We can refer to the paused job by this job number.

We should note that even though the shell says the job is Stopped, it is, in fact, paused – not terminated – and we’ll be able to resume it.

When we pause the `find` command, we’ll get back to the shell prompt to run further commands. If we wish to resume the find operation, we can use the `fg` command:

```bash
$ fg
find . -name "*.java"

./code/com/my/package2/Util.java
```

Here, the last paused job is resumed and runs in the foreground, tying up the shell until it is completed or we choose to stop or pause it again.

### Job Control

To understand what more we can do with jobs, let’s start two long-running jobs and press `Ctrl+Z` after each to pause them:

```bash
$ make -j4
^Z
[1]+  Stopped                 make -j4
$ find . -name "*.java"
^Z
[2]+  Stopped                 find . -name "*.java"
```

#### List Jobs

We list jobs using the `jobs` command:

```bash
$ jobs
[1]-  Stopped                 make -j4
[2]+  Stopped                 find . -name "*.java"
```

The `jobs` command marks the last paused job with the + sign and the immediate previous stopped job with the – sign. If we use `fg` and other job commands without a job number, the last paused job is implied.

#### Resume a Specific Job in the Foreground

The `fg` command allows us to resume a specific job by its job number. The job’s name is output when it starts:

```bash
$ fg %1
make -j4
```

#### Run the Job in the Background

We can also resume a job in the background. A background job runs without tying up the shell. It doesn’t have access to the shell input, but it can still output to the shell:

```bash
$ bg %1
[1]+ make -j4 &

```

As with `fg`, we can omit the job number in the `bg` command to resume the last paused job in the background:

```bash
$ bg
[2]+ find . -name "*.java" &
```

#### Start a Job in the Background

We can also start a job directly as a background process by adding the ampersand `&` character to the end of its command line:

```bash
$ find . -name "*.java" &
[1] 1726
```

### Message: There Are Stopped Jobs

Sometimes when we try to exit the shell by pressing `Ctrl+D` or by using `logout`, we may receive an error message:

```bash
$ logout
There are stopped jobs.
```

When bash shows this message, it also prevents logout.

This is because bash doesn’t allow us to exit the shell while there are paused jobs. The current shell’s process manages its jobs. When we pause a job, it’s left in an incomplete state. If we exit the shell with jobs paused, we might lose some critical data.

So, we need to take care of these paused jobs before we can exit the shell.

#### List Jobs to Handle

To decide what to do with our jobs, let’s list them:

```bash
$ jobs
[1]-  Stopped                 python
[2]+  Stopped                 find . -name "*.java" > javafiles.txt
```

Depending on these jobs, we may wish to keep them running or kill them.

#### Keeping the Job Running

We’ve already seen how to keep a job running in the background:

```bash
$ bg %2
[2]+ find . -name "*.java" > javafiles.txt &
```

As we earlier noted about background jobs, this job can still output to the shell while running in the background. If we exit the shell now, the job might terminate anyway if it tries to output to the shell as the shell doesn’t exist anymore. It can also get killed when it receives certain signals.

To avoid this, we can remove the background job from the current shell using the `disown` command:

```bash
$ disown %2
$ logout
```

This will make sure the background job keeps running in the background even after the shell exits.

#### Killing the Job

Alternatively, we can kill a job we don’t need by using the `kill` command:

```bash
$ kill %1
[1]+  Stopped                 python

$ logout
```

`kill` allows us to use `%1` as the job number, though it is also commonly used to terminate processes by their process id.

## Partitionen und Mounten

+ Partitionieren (mit einem dieser Tools)
  + `fdisk`
  + `parted`
  + `gparted`
+ Dateisystem anlegen ("Formatieren")
  + mit `mkfs`
  + z.B. `mkfs -t ext4 /dev/vdb1`
  + Es gibt in manchen Distributionen auch "Shortcuts" für mkfs mit dem entsprechenden Type, z.B. `mkfs.ntfs`
+ Mounten ("Einhängen") von Filesystemen
  + Hierzu braucht man einen "mountpoint" (Einhängepunkt) irgendwo im Systembaum
  + Dieser muss nur einfach ein Verzeichnis sein
  + z.B. `mkdir meindatentraeger`
  + `mount /dev/vde1 meindatentraeger`
  + ... hängt `/dev/vde1` unter dem Pfad meindatentraeger ein
+ Aushängen mit `umount` (Achtung: kein n!)

Hinweis: Filesysteme können auch in "normalen" Dateien angelegt werden und davon gemountet werden. -> Images!

+ Permanentes Mounten: `/etc/fstab` (oder "mount" Units von systemd)

## Hardlinks und Symbolische Links

### Hardlinks

+ Bedeutet: Einen oder mehrere Verzeichniseinträge zeigen auf den selben Inode. (Konsequenz: Eine Datei hat einen oder mehrere Namen/Einträge im Verzeichnis)
+ -> Jeder Verzeichniseintrag ist ein Hardlink!
+ Wenn der letzte Hardlink auf einen Inode gelöscht wird, dann wird der Inode für anderweitige Verwendung freigegeben.
+ Es gibt de facto keine "Originaldatei", sondern einfach nur einmal die Daten auf der Filesystem (an der entsprechenden Inode Nr.) und 1 oder mehrere Verzeichniseinträge.
+ Werden Dateirechte über einen Hardlink geändert, dann sind sie für jeden anderen Hardlink auch so sichtbar.

__Nachteil:__

+ Hardlinks funktionieren nur auf dem selben Filesystem! (Also z.B. nicht über Partitionen hinaus)

__Vorteil:__

+ Deutlich schnellere Zugriffszeiten
+ Verbrauchen keinen inode

### Symblinks (Symbolic Link)

+ Symbolisch => Namensbasierte Verknüpfungen, nicht Inode
+ Zum Namen gehört der Pfad dazu
+ Ein Symblink bekommt einen eigenen, neuen Inode.
+ Konsequenz: Es gibt eine Originaldatei! Im Symblink selber steht nur der Name (mit der Location)
+ Wird das Original gelöscht, ensteht ein "stale link" (kaputter Link, der auf "nix" zeigt)
+ Ein Symblink kann die Rechte seines Targets nicht "kennen" (hat immer 0777). Werden die Rechte auf einen Symblink gesetzt, so verändert das nur die Rechte des Targets.

__Nachteile:__

+ Inode wird verbraucht
+ Zugriffszeit ist deutlich langsamer als bei Hardlinks

__Vorteil:__

+ Funktioniert über Filesystem-Grenzen hinaus

### Zweck von Links (allgemein)

+ Benutzerfreundlichkeit (z.B. eine Anwendung vom Desktop aus Starten)
+ Zur Konfiguration von System- und Applikationen
    + Verschiedene Konfig-Files können z.B. versions- oder profil-abhängig verlinkt werden
    + Beispiel: Java JDK + JRE

## Logical Volume Manager

### Nachteile/Grenzen der herkömmlichen Partitionierung

+ Partionsgröße kann nicht größer sein als die physikalische Platte, daher kann sich eine Partition nicht über mehrere Platten erstrecken
+ Änderungen der Partitionsgrößen sind schwierig, z.B. kann nicht einfach eine ganze Festplatte nachträglich zu einer Partition dazu genommen werden

__Lösung:__ Abstraktion (Einbau einer "Zwischenschicht") -> Logical Volume Management (LVM)

### Wie funktioniert's?

+ Mehrere Physical Volumes (PV) - das sind physikalische Festplatten - werden zu einer Volume Group (VG) zusammengefasst - das ist sozusagen ein "Speicher-Pool"
+ Dieser "Speicher-Pool" (VG) kann in eine oder mehrere Logische Volumes (LV) aufgeteilt werden, auf denen dann das Filesystem angelegt werden kann.
+ __Vorteil:__ Ein LV kann sich über mehrere physikalische Platten erstrecken

### In der Praxis:

+ LVM installieren `sudo apt install lvm2`
+ PVs definieren `pvcreate`
+ VGs definieren und PVs zur VG hinzufügen `vgcreate`
+ LVs definieren `lvcreate`
+ Filesystem auf LV anlegen `mkfs`
+ Mounten
+ Freuen

### LVM Snapshots

+ Snapshot (= "Wiederherstellungszeitpunkt") (=Zustand des Systems zum Zeitpunkt x)
+ Ab einem bestimmten Zeitpunkt (wenn der Snapshot "gestartet" wird), werden alle Änderungen mitgeschrieben. Durch Rückgängigmachen kann dann zu diesem Zeitpunkt zurückgekehrt werden.
+ __Konsequenz:__ Ein Snapshot alleine ist KEIN Backup und ersetzt auch keines!!!
+ Größe des Snapshots bemisst sich nach der Änderungsrate und der Zeit, die der Snapshot "aktiv" ist. Snapshot kann auch größer als das Original-Image werden.
+ __Nachteil:__ Performance-Einbußen, Speicherplatzverbrauch -> Man sollte Snapshots nur dann aktiv haben, wenn man sie auch wirklich braucht.
+ Anwendungsfälle (Vorteile):
  + Für Testumgebungen geeignet (z.B. Testen von Softwareinstalltionen und Konfigurationen)
  + Wiederherstellung einzelner Dateien mit entsprechenden Möglichkeiten
  + Einfrieren des Zustands für den Zeitpunkt während ein Backup gemacht wird ("Blitzlicht")

## Datenkomprimierung


+ Zwei Arten der Datenkompression
    + __Verlustbehaftete__ Verfahren\
        Beispiel: SCHL MCHT SPSS :)\
        Verfahren: Bildkomprimierung mit JPEG, Audiokomprimierung MP3, Videokompromierung MPEG\
        Charakteristik: Die Originaldaten können nach der Dekompromierung nicht wieder vollständig hergestellt werden. -> Datenverlust
    + __Verlustlose__ Verfahren\
        Verfahren: zip, rar, lha, ...\
        Charakteristik: Jedes Bit der Originaldaten kann bei der Dekompromierung wieder hergestellt werden.
+ __Redundanz:__ "Überflüssige" Information, benötigt meist nur der Mensch, wird aber auch verwendet, um z.B. Datenverlust zu vermeiden (siehe RAID)
+ __Informationsgehalt (Entropie):__ Wie gehaltvoll an Informationen ist ein Zeichen, Text, Bild, ...
+ __Komprimierung:__ Entfernung von Redundanz -> Erhöhung des Informationsgehalts

[Huffman-Verfahren (am Beispiel erklärt)](https://bitjunkie.wordpress.com/2011/05/23/never-waste-your-memory-huffman-encoding/)

## Backups

__Sinn des Backups__

+ Ermöglichen einer Rückkehr zum Zustand vor dem Zeitpunkt des Backups, z.B. bei Upgrades
+ Schutz vor Datenverlust durch Soft- und/oder Hardwareausfälle (z.B. Malware, Schadensereignisse, ...)

__Backup-Medien__

+ Tapes
+ Festplatten (HDD, SSD) 
+ CDs/DVDs
+ Cloud

__Backup-Strategien__

+ Vollsicherung
    + Komplette Kopie der Daten
    + __Nachteil:__ Viel Speicher (pro Kopie) erforderlich, Sicherung und Restaurierung zeitaufwändig

+ Differentielles Backup
    + Es wird zunächst eine Vollsicherung benötigt.
    + Jedes (Teil-)Backup sichert jeweils die Änderungen seit der Vollsicherung.
    + Logischerweise benötigt man zum Restaurieren neben dem letzten (Teil-)Backup auch das ursprüngliche Vollbackup.
    + __Vorteil:__ Die ersten (Teil-)Backups nach dem Vollbackup sind klein und schnell.
    + __Nachteil:__ Mit jedem weiteren (Teil-)Backup wächst die Datenmenge

+ Inkrementelles Backup
    + Startet mit einem Vollbackup.
    + Jedes (Teil-)Backup sichert jeweils die Änderungen seit dem letzten (Teil-)Backup.
    + Logischerweise benötigt man zur Restaurierung das Vollbackup sowie alle (Teil-)Backups.
    + __Vorteil:__ Teilbackups sind klein und schnell (beim Sichern)
    + __Nachteil:__ Geht ein Backup in der "Kette" kaputt, so gibt es Datenverlust
    + Restaurierung ist zeitaufwändig.

+ 3-2-1 Regel (Empfehlung)
    + 3 separate Kopien auf 2 unterschiedlichen Medien, wobei 1 davon örtlich getrennt sein soll (heute meist Cloud).

+ Generationen-Prinzip (Empfehlung)
    + Empfiehlt, in welchen Zeitabständen Backups "gefahren" werden sollen.
    + Sohn => Tagesbackup
    + Vater => Wochenbackup
    + Großvater => Monatsbackup

## Linux Bootvorgang

1. Einschalten des PC.
1. Hardware / UEFI (Unified Extensible Firmware Interface), früher BIOS (Basic Input/Output System)
   - POST (Power-On Self Test)
   - Hardwareerkennung (Controller und Peripherals)
   - Bootreihenfolge durchgehen und nach "bootbarer" Partition suchen
1. Bootloader wird geladen (z.B. Windows Bootloader, GRUB2, manchmal auch im UEFI integriert)
Der Bootloader erlaubt ggf. eine Auswahl unter mehreren Betriebssystemen (Multiboot)
1. Laden des Betriebssystems, zuerst Kernel (Kern des Betriebssystems)
1. Ab diesem Punkt Distributionsabhängig

__Es gibt bei Linux zwei Varianten!__

### SysVInit (Legacy, da viele Nachteile)

+ Einen Systemprozess, der den Bootvorgang und das Starten von Services (Dienste) übernimmt. Dieser heißt "initd"
+ Weiterer Bootvorgang erfolgt durch Skripte, die sequentiell (nacheinander) ausgeführt werden.
+ Runlevels 0-6
   + 0: Aus
   + 1: Single-User ohne Netzwerk (zum Debuggen, Konfigurieren)
   + 2-4: Distributionsabhängig
   + 5: Voll hochgefahren
   + 6: Reboot
+ Nachteile: Langsamer Systemstart wegen sequentiellen Skripten, Aufwändige Einrichtung von neuen Diensten, Fehleranfällig bei der Konfiguration
+ Beispiel-Distro: Devuan (Debian mit SysVInit statt systemd)

### systemd

+ "Allumfassendes" System Management Framework
+ __Service:__ Dienst, Kleinste Einheit eines Programms, das im Hintergrund läuft (z.B. Grafische Oberfläche, Druckerserver, Webserver)
+ __Target:__ Zusammenfassung von Diensten
   + ähnlich wie Runlevels, aber nicht streng hierarchisch aufgebaut und auch nicht auf 6 Stück begrenzt :), frei definierbar
   + Bei den "gängigen bekannten" v.a. konservativen Distributionen werden die SysVInit-Runlevels als Targets abgebildet ("simuliert")
+ __Unit:__ Überbegriff für Services, Targets u.v.m. (z.B. Mounts, Timers, ...)
+ Konfigurationstool zum Starten/Stoppen u.s.w. von Services heißt systemctl

## Softwaremanagement

### Grundbegriffe

+ Individualsoftware
    + Software, speziell für einen(!) konkreten Anwendungsfall und/oder Kunden
+ Native Applikation
    + Software, das (nur) auf einem bestimmen Betriebssystem und/oder in einer bestimmten Umgebung läuft (z.B. compiliertes Windows .exe)
+ Virtualisierte Applikationen
    + Client-Server Applikation (z.B. mit Webinterface)
    + Applikationsvirtualisierung (z.B. mit Docker)

+ Software-Pakete
    + Applikationen inklusive (teilw. Shared-) Bibliotheken, Konfigurationsdatein, Multimedia
    + Werden durch Paketmanagement-Systeme verwaltet
        + Betriebssystemspezifisch (z.B. apt, snap, msi, ...)
        + Herstellspezifisch (z.B. für UEFI-Systeme, Grafikkarten, NAS-Boxen) 
        + Sorgen automatisch für die Versionskontrolle
        + Funktionalität umfasst (meist) Installer, Deinstaller, Upgrade und (häufig) netzbasierte/ 
 client-server basierte "Software-Lager" (Repositories)
 
## Basic Networking

### Basic Networking Tools und Files

__Allgemeine Tools:__

+ ping
+ traceroute (Linux), tracert (Windows)
+ arp
+ host, dig
+ route (Linux-Legacy)
+ ipconfig (Windows), ifconfig/iwconfig (Linux - Legacy), ip, iw, iwlist
+ Powershell cmdlets, netsh
+ netstat
+ nmap
+ whois
+ nc (netcat) <-- "Schweizer Taschenmesser" der Netzwerker und Hacker
+ wireshark, tcpdump
+ GUI-Tools
+ Konfigurationsfiles unter Linux (Everything is a file)
+ /etc/hostname
+ /etc/hosts (statische Namensauflösung)
+ /etc/nsswitch.conf (Konfig-Datei aus der hervorgeht, ob /etc/hosts und/oder DNS verwendet wird)
+ /etc/resolv.conf
+ /etc/hosts.allow
+ /etc/hosts.deny