### Ausgelagertes Home-Verzeichnis

+ Erstellen (oder clonen) Sie eine virtuelle Maschine mit einer aktuellen Ubuntu-Distribution.
+ "Bauen" Sie eine weitere Festplatte in die virtuelle Maschine ein.
+ Partitionieren Sie die Festplatte und legen Sie darauf ein btrfs-Filesystem an.

```bash
sudo mkfs.btrfs -f /dev/sdb
```

```
zero-divisor@LinuxMint:~$ lsblk -f
NAME   FSTYPE FSVER LABEL UUID                                 FSAVAIL FSUSE% MOUNTPOINTS
sda                                                                           
├─sda1 vfat   FAT32       CED1-00D4                             504,9M     1% /boot/efi
└─sda2 ext4   1.0         7eb83a87-8e59-4f53-84e1-cbba5ef692ec   98,1G    16% /
sdb    btrfs              bb432c08-39bf-4e67-82a3-bb4c3016e0e7                                

```

+ Nehmen Sie einen Eintrag in `/etc/fstab` vor, um die Festplatte permanent unter dem Pfad `/home` zu mounten.

```
UUID=bc504fee-0a4b-45f6-8d75-ee78e18ccdb4 /home  auto  rw,user,auto 0 0
```

+ Nehmen Sie alle weiteren Konfigurationsschritte (die Sie aus dem Thema "Benutzerverwaltung" kennen müssten) vor, damit Ihr Standard-Benutzer sein persönliches Home-Verzeichnis auf der neu eingebauten Festplatte bekommt.

__Tipp:__ Hierzu müssen Sie u.a ein Verzeichnis für den User auf der Festplatte anlegen sowie die Zugriffsrechte und Ownership entsprechend anpassen.

Notieren Sie sich die entsprechenden Schritte und ausgeführten Befehle!