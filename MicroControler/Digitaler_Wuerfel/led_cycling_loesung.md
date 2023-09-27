# Digitaler Würfel

#### [Aufgabe](led_cycling_Aufgabenstellung.pdf)

#### [Schaltungsaufbau](Digitaler_Wuerfel/Schaltung.PNG)

#### [Code](led_cycling_code.ino)


## Vorwiderstand für LED berechnen[^1]

* Spannung an der LED: U<sub>led</sub> (bei roten LEDs meist &#8776; 2V)
* Strom durch LED: I<sub>led</sub> (typisch &#8776; 20mA)
* Versorgungsspannung: U (bei Arduino digital Pins = 5V)

Gewünschte Spannung am Vorwiderstand: U<sub>R</sub> = U - U<sub>led</sub> = 5V - 2V = 3V
\
Strom durch den Vorwiderstand: I<sub>R</sub> = I<sub>gesamt</sub> = I<sub>led</sub> = 20mA = 0.02A
(da Reihenschaltung)

Vorwiderstand: R = U<sub>R</sub> / I<sub>R</sub> = 3V / 0.02A = 150&#937;

[^1]: Mir ist erst später aufgefallen, dass die Vorwiderstände in der Aufgabenstellung gegeben sind. 