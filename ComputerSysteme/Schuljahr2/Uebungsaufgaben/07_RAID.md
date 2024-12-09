### Recherchieren Sie den grundlegenden Aufbau und die Eigenschaften der folgenden RAID-Levels:

__Arbeiten Sie insbesondere folgende Unterschiede heraus.__

+ Brutto- vs. Netto-Speicherkapazität 
+ Lese- und Schreibperformance
+ Ausfallsicherheit
+ min. Anzahl an Festplatten, mit denen ein derartiger Verbund realisiert werde kann.

Beachten Sie, dass nicht alle ähnlichen Aufstellungen, die im Internet verfügbar sind, valides Wissen enthalten. ;)

+ RAID 0
    * Verfügbarer Speicherplatz: 100%
    * Leseperformance: n
    * Schreibperformance: 1
    * keine Disk darf ausfallen
    * mind. 2 Disks
+ RAID 1
    * Verfügbarer Speicherplatz: kleinste Disk
    * Leseperformance: n
    * Schreibperformance: 1
    * alle bis auf eine Disk dürfen aufallen
    * mind. 2 Disks
+ RAID 4
    * Verfügbarer Speicherplatz: eine Disk weniger
    * Leseperformance: n-1
    * Schreibperformance: n-1
    * eine Disk kann ausfallen
    * mind. 3 Disks
+ RAID 5
    * Verfügbarer Speicherplatz: eine Disk weniger
    * Leseperformance: n
    * Schreibperformance: n-1
    * eine Disk kann ausfallen
    * mind. 3 Disks
+ RAID 6 
    * Verfügbarer Speicherplatz: 2 Disks weniger
    * Leseperformance: n
    * Schreibperformance: n-1
    * 2 Disks können ausfallen
    * mind 4 Disks
