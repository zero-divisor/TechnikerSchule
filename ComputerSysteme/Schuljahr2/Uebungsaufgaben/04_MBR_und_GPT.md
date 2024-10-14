### Wofür stehen die Abkürzungen MBR und GPT? Welche Vorteile bietet GPT gegenüber MBR?

#### master boot record (MBR)

+ Für MBR-Partitionen ist die Anzahl an primären Partitionen auf 4 limitiert.
+ 32 Bit Adressen womit bis zu 2TiB (2<sup>32</sup> × 512‑bytes) adressiert werden können.

#### GUID Partition Table (GPT)

+ Bis zu 128 Partitionen
+ GPT benutzt zur Adressierung 64-bit Werte (Logical Block Adresses (LBA)), womit bis zu 9,4 Zettabyte adressiert werden können.

### Finden Sie heraus, von welchen Faktoren die Anzahl der Inodes in einem ext-Dateisystem abhängt.

Hängt vom bytes/inode Verhältniss ab.
Dieses kann beim Erstellen des Dateisystems konfiguriert werden.
Ein größeres bytes/inode Verhältniss bedeutet weniger inodes werden erstellt.
bytes/inode sollte nicht kleiner als die Blocksize sein, sonst werden mehr inodes erstellt als verwendet werden können.

Bei standard Debian Installation:
```
blocksize = 4096
inode_size = 256
inode_ratio = 16384
```