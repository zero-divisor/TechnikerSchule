## Gamblers Ruin

In der Statistik ist Gamblers-Ruin die Tatsache, dass ein Spieler, der ein Glücksspiel mit negativem Erwartungswert spielt, eventuell bankrott getht, unabhängig von der Wettstrategie.

Eine andere Variante des Konzepts ist:\
Ein Spieler mit endlichem Kapital, der Ein faires Spiel (Erwartungswert 0 für beide Seiten) gegen ein Casino mit unendlich Kapital spielt, geht mit 100% wahrscheinlichkeit irgendwann bankrott.

https://tomrocksmaths.com/2021/09/22/gamblers-ruin/

### Beispiel Roulette mit Martingale Strategie

#### Martingale Strategie

+ Es werden immer Wetten mit ~50% Chance gespielt (rot/schwarz, gerade/ungerade, 1-18/19-36)
+ Nach jeder verlorenen Wette wird der Einsatz verdoppelt
+ Nach der ersten gewonnenen Wette ist der Spieler einen Einsatz im Plus

__z.B.:__ erste gewonnene Wette nach 4 Spielen:

+ Gesamter Einsatz: 1 + 2 + 4 + 8 = 2<sup>0</sup> + 2<sup>1</sup> + 2<sup>2</sup> + 2<sup>3</sup> = 15
+ Gewinn: 2x8 = 2<sup>4</sup> = 16
+ Allgemein: 2<sup>0</sup> + 2<sup>1</sup> + ... + 2<sup>n</sup> = 2<sup>n+1</sup>-1

#### Idealisiertes Faires Spiel

+ 1-36

#### Europäisches Roulette

+ Europäisches Roulette 1-36, 0
+ Gewinnchance 18/37 = 48.65%

#### Amerikanisches Roulette

+ Amerikanisches Roulette 1-36, 0, 00
+ Gewinnchance 18/38 = 47.37%
