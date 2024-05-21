### Erstellen Sie in der Artikeltabelle einen Index auf der Benennung und löschen Sie ihn anschließend wieder.

```sql
CREATE INDEX artikel_index ON artikel (benennung);

DROP INDEX artikel_index ON artikel;
```

### Testen Sie das Beispiel mit und ohne Index auf dem Benennungs-Feld und analysieren Sie die Ausgabe.

```sql
explain select * from artikel where benennung = 'Apfel';
```

__Ohne Index__

```
+------+-------------+---------+------+---------------+------+---------+------+------+-------------+
| id   | select_type | table   | type | possible_keys | key  | key_len | ref  | rows | Extra       |
+------+-------------+---------+------+---------------+------+---------+------+------+-------------+
|    1 | SIMPLE      | artikel | ALL  | NULL          | NULL | NULL    | NULL | 7    | Using where |
+------+-------------+---------+------+---------------+------+---------+------+------+-------------+
```

__Mit Index__

```
+------+-------------+---------+------+---------------+---------------+---------+-------+------+-----------------------+
| id   | select_type | table   | type | possible_keys | key           | key_len | ref   | rows | Extra                 |
+------+-------------+---------+------+---------------+---------------+---------+-------+------+-----------------------+
|    1 | SIMPLE      | artikel | ref  | artikel_index | artikel_index | 122     | const | 1    | Using index condition |
+------+-------------+---------+------+---------------+---------------+---------+-------+------+-----------------------+
```

### Erstellen Sie einen Unique Key auf den Mehrwertsteuersatz in der Mehrwertsteuertabelle. Testen Sie die Wirksamkeit des Unique Keys.

```sql
alter table mwst add unique key (mwst);
```

```
+-----------+---------------+------+-----+---------+-------+
| Field     | Type          | Null | Key | Default | Extra |
+-----------+---------------+------+-----+---------+-------+
| mwstgr    | int(11)       | NO   | PRI | NULL    |       |
| benennung | varchar(30)   | NO   |     | NULL    |       |
| mwst      | decimal(10,0) | NO   | UNI | NULL    |       |
+-----------+---------------+------+-----+---------+-------+
```

```sql
insert into mwst (mwstgr, benennung, mwst) 
    values (3, 'platzhalter', 19);
```

```
ERROR 1062 (23000): Duplicate entry '19' for key 'mwst'
```