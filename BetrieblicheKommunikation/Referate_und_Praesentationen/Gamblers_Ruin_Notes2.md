## Gamblers Ruin

In der Statistik ist Gamblers-Ruin die Tatsache, dass ein Spieler, der ein Glücksspiel mit negativem Erwartungswert spielt, eventuell bankrott getht, unabhängig von der Wettstrategie.

Eine andere Variante des Konzepts ist:\
Ein Spieler mit endlichem Kapital, der Ein faires Spiel (Erwartungswert 0 für beide Seiten) gegen ein Casino mit unendlich Kapital spielt, geht mit 100% wahrscheinlichkeit irgendwann bankrott.


https://tomrocksmaths.com/2021/09/22/gamblers-ruin/

https://discrete.openmathbooks.org/dmoi2/sec_recurrence.html

https://mpaldridge.github.io/math2750/S03-gamblers-ruin.html

### Klassiche Formulierung:

+ Alice (a€) spielt gegen Bob (b€) 
+ Gesamtes Geld im Spiel a€ + b€ = m€
+ Einsatz jedesmal 1€
+ Gespielt wird bis ein Spieler alles Geld hat (m€)
+ Was ist die Wahrscheinlichkeit, dass Alice gewinnt

Dies ist äquivalent zu Alice hat a€ und spielt gegen ein Casino mit unendlich Kapital bis sie entweder m€ hat oder pleite ist.

#### Zu Zeigen

1. wahrscheinlichkeit für m€ gewinn bei fairem Spiel
2. Bei einem unfairen Spiel (z.B. rot/Schwarz Roulette 18/37) sinken Alices chancen drastisch trotz fast 50:50 Wahrscheinlichkeit
3. Gegen ein Casino mit unendlich Kapital ist Alice auch bei einem Fairen Spiel irgendwann Pleite falls sie nich aufhört zu spielen (lim m -> unendlich)
4. Warum ist Gamblers ruin unabhängig von der Wettstratergie

### 1-3

ist in den handschriftlichen Notitzen ausgerechnet

### 4 Verallgemeinerung für beliebige Wettstratergien

__Wahrscheinlichkeit kann variieren__

Solange P <= 1/2 geht lim m -> unendlich gegen 1 Wahrscheinlichkeit der einzelnen Wetten ist bis auf die Obergrenze 0.5 egal.


__Einsatz kann variieren__

Gamblers Ruin gilt für beliebige endliche anzahl von Einsätzen unabhängig, davon ob ein einsatz 1€ ist oder eine beliebige Teilmenge von a€

// todo: bisher nur intuiton, echter Mathematischer beweis fehlt noch

```
For red-and-black, however, it is known that for favorable games (i.e., p > 1/2)
timid play is optimal, and for unfavorable games (p <= 1/2) bold play is optimal.
This corresponds to the intuitively plausible idea that for favorable games,
the random walk will tend to drift to the right, so taking steps as small as possible
will make this drift look almost deterministic, making the probability of reaching
the goal high. For unfavorable games however, the drift is to the left, and
small bets will be a poor strategy for exactly the same reason; playing just the
opposite by maximizing bets (bold play) is much better.
```