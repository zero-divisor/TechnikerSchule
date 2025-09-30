Bewerkstelligen Sie die folgenden Aufgaben und notieren Sie sich die verwendeten Befehle. Recherchieren und notieren Sie sich ferner die dafür benötigten Optionen.

### 1. Finden Sie die IP- und die MAC-Adresse heraus, über die Sie mit dem Netzwerk verbunden sind.

__Windows:__

```
> ipconfig /all

...
Physische Adresse . . . . . . . . : 00-15-5D-29-37-1A
...
IPv4-Adresse  . . . . . . . . . . : 172.26.18.81
...
```

__Linux:__

```
$ ip a

...
link/ether 18:66:da:07:b4:8e
...
inet 172.26.19.59...
...
```

### 2. Finden Sie die IP-Adresse des eingestellten Default-Gateway heraus.

__Windows:__

```
> ipconfig

...
Standardgateway . . . . . . . . . : 172.26.18.1
...
```

__Linux:__

```
$ ip route

default via 172.26.19.1
...
```

### 3. Veranlassen Sie das System zu einem DHCP-Request und lassen Sie sich detailierte Informationen zu den Einzelschritten anzeigen.

```
# dhclient -v

Internet Systems Consortium DHCP Client 4.4.1
Copyright 2004-2018 Internet Systems Consortium.
All rights reserved.
For info, please visit https://www.isc.org/software/dhcp/

Listening on LPF/eno1/3c:ec:ef:cc:ed:d6
Sending on   LPF/eno1/3c:ec:ef:cc:ed:d6
Listening on LPF/eno2/3c:ec:ef:cc:ed:d7
Sending on   LPF/eno2/3c:ec:ef:cc:ed:d7
Sending on   Socket/fallback
DHCPDISCOVER on eno1 to 255.255.255.255 port 67 interval 3 (xid=0x52965846)
DHCPDISCOVER on eno2 to 255.255.255.255 port 67 interval 3 (xid=0x2585a94a)
DHCPOFFER of 172.27.224.193 from 172.27.224.129
DHCPREQUEST for 172.27.224.193 on eno1 to 255.255.255.255 port 67 (xid=0x46589652)
DHCPACK of 172.27.224.193 from 172.27.224.129 (xid=0x52965846)
bound to 172.27.224.193 -- renewal in 265322 seconds.
```

### 4. Stellen Sie eine DNS-Anfrage für 8.8.8.8 mit host, dig und nslookup.

__Windows:__

```
> nslookup 8.8.8.8

Server:  AE-PFD-ADC-001.admiralde.net
Address:  10.255.0.20

Name:    dns.google
Address:  8.8.8.8
```

__Linux:__

```
$ host 8.8.8.8

8.8.8.8.in-addr.arpa domain name pointer dns.google.

-------------------------------------------------------------------------------------------

$ dig 8.8.8.8

; <<>> DiG 9.18.30-0ubuntu0.24.04.2-Ubuntu <<>> 8.8.8.8
;; global options: +cmd
;; Got answer:
;; ->>HEADER<<- opcode: QUERY, status: NXDOMAIN, id: 20646
;; flags: qr rd ra; QUERY: 1, ANSWER: 0, AUTHORITY: 1, ADDITIONAL: 1

;; OPT PSEUDOSECTION:
; EDNS: version: 0, flags:; udp: 65494
;; QUESTION SECTION:
;8.8.8.8.                       IN      A

;; AUTHORITY SECTION:
.                       900     IN      SOA     a.root-servers.net. nstld.verisign-grs.com. 2025093000 1800 900 604800 86400

;; Query time: 7 msec
;; SERVER: 127.0.0.53#53(127.0.0.53) (UDP)
;; WHEN: Tue Sep 30 09:18:21 CEST 2025
;; MSG SIZE  rcvd: 111

-------------------------------------------------------------------------------------------

$ nslookup 8.8.8.8

8.8.8.8.in-addr.arpa    name = dns.google.

Authoritative answers can be found from:
```

### 5. Richten Sie durch einen zusätzlichen Eintrag in der Datei /etc/hosts eine statische Namensauflösung auf Ihrem Rechner ein, so dass sie den edu-Server der Elektronikschule unter dem Namen schule erreichen können. Wenden Sie anschließend die unter 5. aufgeführten Tools auf den neuen Namen an und analysieren Sie deren Ausgabe.

### 6. Finden Sie heraus, welche Wireless Access Points sich in Ihrer Umgebung befinden.

### 7. Finden Sie heraus, wie hoch die mittlere Laufzeit eines Datenpakets zur Webseite des Whitehouse in Washington D.C ist, und über welche Hops die Verbindung erfolgt.

```

```

### 8. Verwenden Sie nmap, um sich die offenen Ports des Servers edu.elektronikschule.de anzeigen zu lassen. Wiederholen Sie den Versuch mit netcat (nc)

### 9. Benutzer Sie netcat (nc), um einen Konsolen-Chat zwischen zwei Rechnern zu ermöglichen.