### Journaling

A journaling file system is a file system that keeps track of changes not yet committed to the file system's main part by recording the goal of such changes in a data structure known as a "journal".

In the event of a system crash or power failure, such file systems can be brought back online more quickly with a lower likelihood of becoming corrupted.

### COW (Was ist das überhaupt und wozu benötigt man das?)

In traditional file systems, file changes overwrite the original data. With COW, when changes are made, a new version of the file is created while keeping the original intact. This approach enables features like snapshots, which capture the state of a file at a specific time without consuming much additional space.

||Unterstützung von Benutzern und Zugriffsberechtigungen|Journaling|COW|max. Partitionsgröße|max. Dateigröße|max. Anzahl von Dateien|Besondere Features / Anwendungsfälle|
|-|-|-|-|-|-|-|-|
|ext3|Unix permissions, POSIX ACLs|Ja|Nein|4TiB–32TiB|16GiB–2TiB|Variabel||
|ext4|Unix permissions, POSIX ACLs|Ja|Nein|1EiB|16-256TiB|4 billion||
|btrfs|Unix permissions, POSIX ACLs|Nein|Ja|16EiB|16EiB|2<sup>64</sup>||
|FAT32|Partial, only with DR-DOS, REAL/32 and 4690 OS|Nein|Nein|2TB/8TB/16TB|2GiB (without LFS) 4GiB (with LFS)|268,173,300||
|NTFS|ACLs|Ja|Nein|8PB|8PB|2<sup>32</sup>-1||
|RsFS|ACLs|Ja|Ja|35PB|35PB|-||
|APFS|Unix permissions, NFSv4, ACLs||Ja||8EB|9,223,372,036,854,775,808||