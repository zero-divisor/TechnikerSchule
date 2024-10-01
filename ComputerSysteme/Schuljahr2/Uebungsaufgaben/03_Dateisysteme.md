+ Journaling / COW (Was ist das überhaupt und wozu benötigt man das?)
+ Besondere Features / Anwendungsfälle (Wo/warum wird dieses Filesystem eingesetzt?)

||Unterstützung von Benutzern und Zugriffsberechtigungen|Journaling|COW|max. Partitionsgröße|max. Dateigröße|max. Anzahl von Dateien|Besondere Features / Anwendungsfälle|
|-|-|-|-|-|-|-|-|
|ext3|Unix permissions, POSIX ACLs|Ja|Nein|4TiB–32TiB|16GiB–2TiB|Variabel||
|ext4|Unix permissions, POSIX ACLs|Ja|Nein|1EiB|16-256TiB|4 billion||
|btrfs|Unix permissions, POSIX ACLs|Nein|Ja|16EiB|16EiB|2<sup>64||
|FAT32|Partial, only with DR-DOS, REAL/32 and 4690 OS|Nein|Nein|2TB/8TB/16TB|2GiB (without LFS) 4GiB (with LFS)|268,173,300||
|NTFS|
|RsFS|
|APFS|