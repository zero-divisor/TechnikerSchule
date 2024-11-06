### Ausgelagertes Home-Verzeichnis

+ Erstellen (oder clonen) Sie eine virtuelle Maschine mit einer aktuellen Ubuntu-Distribution.
+ "Bauen" Sie eine weitere Festplatte in die virtuelle Maschine ein.
+ Partitionieren Sie die Festplatte und legen Sie darauf ein btrfs-Filesystem an.
+ Nehmen Sie einen Eintrag in `/etc/fstab` vor, um die Festplatte permanent unter dem Pfad `/home` zu mounten.
+ Nehmen Sie alle weiteren Konfigurationsschritte (die Sie aus dem Thema "Benutzerverwaltung" kennen müssten) vor, damit Ihr Standard-Benutzer sein persönliches Home-Verzeichnis auf der neu eingebauten Festplatte bekommt.

__Tipp:__ Hierzu müssen Sie u.a ein Verzeichnis für den User auf der Festplatte anlegen sowie die Zugriffsrechte und Ownership entsprechend anpassen.

Notieren Sie sich die entsprechenden Schritte und ausgeführten Befehle!