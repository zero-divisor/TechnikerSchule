### 1. Prüfen Sie, ob der auf dem System installierte Kernel die RAID-Levels 1 und 6 unterstützt.

### 2. Fügen Sie zur virtuellen Maschine insgesamt sechs (virtuelle) Festplatten mit je 100 MByte hinzu.

```
test@debian:~$ lsblk
NAME   MAJ:MIN RM  SIZE RO TYPE MOUNTPOINTS
fd0      2:0    1    4K  0 disk
sda      8:0    0   50G  0 disk
├─sda1   8:1    0   49G  0 part /
├─sda2   8:2    0    1K  0 part
└─sda5   8:5    0  975M  0 part [SWAP]
sdb      8:16   0    1G  0 disk
└─sdb1   8:17   0 1023M  0 part
sdc      8:32   0    1G  0 disk
└─sdc1   8:33   0 1023M  0 part
sdd      8:48   0    1G  0 disk
└─sdd1   8:49   0 1023M  0 part
sde      8:64   0    1G  0 disk
└─sde1   8:65   0 1023M  0 part
sdf      8:80   0    1G  0 disk
└─sdf1   8:81   0 1023M  0 part
sdg      8:96   0    1G  0 disk
└─sdg1   8:97   0 1023M  0 part
```

### 3. Erstellen Sie mithilfe des mdadm-Tools

+ mit zwei der sechs Platten einen RAID1 – Verbund

```
test@debian:~$ sudo mdadm --create /dev/md/md_lvl_1 --level=1 --raid-devices=2 /dev/sdb1 /dev/sdc1
mdadm: Defaulting to version 1.2 metadata
mdadm: array /dev/md/md_lvl_1 started.
```


+ und mit den restlichen vier Platten einen RAID6 – Verbund

```
test@debian:~$ sudo mdadm --create /dev/md/md_lvl_6 --level=6 --raid-devices=4 /dev/sdd1 /dev/sde1 /dev/sdf1 /dev/sdg1
mdadm: Defaulting to version 1.2 metadata
mdadm: array /dev/md/md_lvl_6 started.
```

### 4. Legen Sie auf beiden RAID-Systemen ein ext4-Filesystem an.

```
test@debian:~$ sudo mkfs.ext4 /dev/md/md_lvl_1
test@debian:~$ sudo mkfs.ext4 /dev/md/md_lvl_6
```

### 5. Mounten Sie die unter 3. erstellten RAID-Systeme unter /mnt/raid_1 bzw. /mnt/raid_6

```
test@debian:~$ sudo mkdir /mnt/raid_1
test@debian:~$ sudo mkdir /mnt/raid_6
test@debian:~$ sudo mount /dev/md/md_lvl_1 /mnt/raid_1
test@debian:~$ sudo mount /dev/md/md_lvl_6 /mnt/raid_6
test@debian:~$ df | grep md
/dev/md127       1011148      24    942416    1% /mnt/raid_1
/dev/md126       2019240      24   1898284    1% /mnt/raid_6
```

### 6. Wie viel Speicherplatz steht dem Nutzer auf den einzelnen RAID-Systemen zur Verfügung?

```
test@debian:~$ df -h
Dateisystem    Größe Benutzt Verf. Verw% Eingehängt auf
/dev/md127      988M     24K  921M    1% /mnt/raid_1
/dev/md126      2,0G     24K  1,9G    1% /mnt/raid_6
```

### 7. Füllen Sie beide RAID-Systeme, in dem Sie große Datei mit zufälligem Inhalt erzeugen (z.B. aus /dev/urandom).

```
test@debian:~$ head -c 500M </dev/urandom >largeFile
test@debian:~$ sudo cp largeFile /mnt/raid_1/largeFile1
test@debian:~$ sudo cp largeFile /mnt/raid_6/largeFile2
```

### 8. Untersuchen Sie das Verhalten der RAID-Arrays beim "Ziehen" von Platten aus der virtuellen Maschine. Was stellen Sie fest?