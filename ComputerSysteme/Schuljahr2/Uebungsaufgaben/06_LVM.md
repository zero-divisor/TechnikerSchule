### Erstellen Sie eine Debian virtuelle Maschine mit fünf zusätzlichen (virtuellen) Festplatten, die jeweils 1 GiB groß sind.

```
NAME   FSTYPE FSVER LABEL UUID                                 FSAVAIL FSUSE% MOUNTPOINTS
fd0                                                                           
sda                                                                           
├─sda1 ext4   1.0         da91d3b7-84a6-4c35-8d56-877d65a66af7    1,6G    48% /
├─sda2                                                                        
├─sda5 swap   1           69760b99-8917-47c3-bd47-09fa5962cee5                [SWAP]
└─sda6 ext4   1.0         859b8167-0b09-43c9-84f6-d1b3687322cb      5G     0% /home
sdb                                                                           
└─sdb1 ext4   1.0         0276dd80-c5d5-4f5e-9b71-097478e796f7                
sdc                                                                           
└─sdc1 ext4   1.0         21fe954f-99b4-4bdd-a600-0c326c5c86b0                
sdd                                                                           
└─sdd1 ext4   1.0         fdfc4785-52ba-44d5-981c-67e472c7f0d3                
sde                                                                           
└─sde1 ext4   1.0         ae3f0fc7-9e0f-466f-a21d-c1b7ec52f14d                
sdf                                                                           
└─sdf1 ext4   1.0         aa7cbc14-d938-4e18-8354-d7aebdad076e                
sr0                                                                           
```

### Konfigurieren Sie den Plattenverbund so, dass mithilfe dieser Platten zwei LVs (2 GiB und 3 GiB) zur Verfügung gestellt werden.

#### PVs Erstellen 
```
sudo pvcreate /dev/sdb1
sudo pvcreate /dev/sdc1
sudo pvcreate /dev/sdd1
sudo pvcreate /dev/sde1
sudo pvcreate /dev/sdf1
```

```
NAME   FSTYPE      FSVER    LABEL UUID                                   FSAVAIL FSUSE% MOUNTPOINTS
fd0                                                                                     
sda                                                                                     
├─sda1 ext4        1.0            da91d3b7-84a6-4c35-8d56-877d65a66af7      1,6G    48% /
├─sda2                                                                                  
├─sda5 swap        1              69760b99-8917-47c3-bd47-09fa5962cee5                  [SWAP]
└─sda6 ext4        1.0            859b8167-0b09-43c9-84f6-d1b3687322cb        5G     0% /home
sdb                                                                                     
└─sdb1 LVM2_member LVM2 001       C6nxJE-pyyZ-jX3u-jjeg-dSBm-aE7M-uv4eDe                
sdc                                                                                     
└─sdc1 LVM2_member LVM2 001       OhZV16-CTn0-Hbg1-NmJe-9C8B-Iob6-Kq5cGN                
sdd                                                                                     
└─sdd1 LVM2_member LVM2 001       nlEfhP-t5ym-pJ2r-7vo2-5mRa-43Vo-Fbm8RU                
sde                                                                                     
└─sde1 LVM2_member LVM2 001       nzjkqq-XKAs-EsdV-teQ3-8h5G-ce0F-FafLXI                
sdf                                                                                     
└─sdf1 LVM2_member LVM2 001       p4XB8n-iOPD-vCe1-iCk4-kGdz-63GK-g4zwJp                
sr0                                                                                     

```

#### VGs Erstellen

```
sudo vgcreate vg00 /dev/sdb1 /dev/sdc1
sudo vgcreate vg01 /dev/sdd1 /dev/sde1 /dev/sdf1
```

Mit `sudo pvdisplay` und `sudo vgdisplay` kann man die PVs und VGs überprüfen.

#### Anlegen von LVs

```
sudo lvcreate -n data -l100%VG vg00
sudo lvcreate -n data1 -l100%VG vg01
```

### Legen Sie auf jedem dieser beiden LVs ein ext4 Dateisystem an und richten Sie das System so ein, dass sie automatisch unter `/mnt/volume1` sowie `/mnt/volume2` gemountet werden.

#### Dateisystem anlegen

```
sudo mkfs.ext4 /dev/vg00/data
sudo mkfs.ext4 /dev/vg01/data1
```

```
NAME           FSTYPE      FSVER    LABEL UUID                                   FSAVAIL FSUSE% MOUNTPOINTS
fd0                                                                                             
sda                                                                                             
├─sda1         ext4        1.0            da91d3b7-84a6-4c35-8d56-877d65a66af7      1,6G    48% /
├─sda2                                                                                          
├─sda5         swap        1              69760b99-8917-47c3-bd47-09fa5962cee5                  [SWAP]
└─sda6         ext4        1.0            859b8167-0b09-43c9-84f6-d1b3687322cb        5G     0% /home
sdb                                                                                             
└─sdb1         LVM2_member LVM2 001       C6nxJE-pyyZ-jX3u-jjeg-dSBm-aE7M-uv4eDe                
  └─vg00-data  ext4        1.0            7d5c0f67-86e5-45ca-8bdb-95918b66ed3d                  
sdc                                                                                             
└─sdc1         LVM2_member LVM2 001       OhZV16-CTn0-Hbg1-NmJe-9C8B-Iob6-Kq5cGN                
  └─vg00-data  ext4        1.0            7d5c0f67-86e5-45ca-8bdb-95918b66ed3d                  
sdd                                                                                             
└─sdd1         LVM2_member LVM2 001       nlEfhP-t5ym-pJ2r-7vo2-5mRa-43Vo-Fbm8RU                
  └─vg01-data1 ext4        1.0            bee1ce67-5efa-4db0-af04-94df09cff2b4                  
sde                                                                                             
└─sde1         LVM2_member LVM2 001       nzjkqq-XKAs-EsdV-teQ3-8h5G-ce0F-FafLXI                
  └─vg01-data1 ext4        1.0            bee1ce67-5efa-4db0-af04-94df09cff2b4                  
sdf                                                                                             
└─sdf1         LVM2_member LVM2 001       p4XB8n-iOPD-vCe1-iCk4-kGdz-63GK-g4zwJp                
  └─vg01-data1 ext4        1.0            bee1ce67-5efa-4db0-af04-94df09cff2b4                  
sr0                                                                                             

```

#### In fstab hinzufügen

```
# /etc/fstab: static file system information.
#
# Use 'blkid' to print the universally unique identifier for a
# device; this may be used with UUID= as a more robust way to name devices
# that works even if disks are added and removed. See fstab(5).
#
# systemd generates mount units based on this file, see systemd.mount(5).
# Please run 'systemctl daemon-reload' after making changes here.
#
# <file system> <mount point>   <type>  <options>       <dump>  <pass>
# / was on /dev/sda1 during installation
UUID=da91d3b7-84a6-4c35-8d56-877d65a66af7 /               ext4    errors=remount-ro 0       1
# /home was on /dev/sda6 during installation
UUID=859b8167-0b09-43c9-84f6-d1b3687322cb /home           ext4    defaults        0       2
# swap was on /dev/sda5 during installation
UUID=69760b99-8917-47c3-bd47-09fa5962cee5 none            swap    sw              0       0
/dev/sr0        /media/cdrom0   udf,iso9660 user,noauto     0       0
# LVs
UUID=7d5c0f67-86e5-45ca-8bdb-95918b66ed3d /mnt/volume1           ext4    rw,user,auto    0    0
UUID=bee1ce67-5efa-4db0-af04-94df09cff2b4 /mnt/volume2           ext4    rw,user,auto    0    0

```

### Prüfen Sie, ob sich auf den Volumes Daten speichern lassen

```
sudo touch /mnt/volume1/testFile1
sudo touch /mnt/volume2/testFile2
```