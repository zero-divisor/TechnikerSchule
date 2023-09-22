# Digitaler Würfel

#### [Schaltungsaufbau](https://github.com/zero-divisor/TechnikerSchule/blob/master/MicroControler/Schaltung.PNG)

## Vorwiderstand für LED berechnen

* Spannung an der LED: U<sub>led</sub> (bei roten LEDs meist &#8776; 2V)
* Strom durch LED: I<sub>led</sub> (typisch &#8776; 20mA)
* Versorgungsspannung: U (bei Arduino digital Pins = 5V)

Gewünschte Spannung am Vorwiderstand: U<sub>R</sub> = U - U<sub>led</sub> = 5V - 2V = 3V
\
Strom durch den Vorwiderstand: I<sub>R</sub> = I<sub>gesamt</sub> = I<sub>led</sub> = 20mA = 0.02A
(da Reihenschaltung)

Vorwiderstand: R = U<sub>R</sub> / I<sub>R</sub> = 3V / 0.02A = 150&#937;

