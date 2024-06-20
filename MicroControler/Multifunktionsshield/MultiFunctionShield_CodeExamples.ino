// Den relevanten Pins human-readable Namen geben

// Welches Bauteil mit welchen Pins verbunden ist
// kann man im Schaltplan Nachlesen
#define LATCH_CLOCK 4 
#define SHIFT_CLOCK 7
#define SERIAL_DIN 8 

#define LED_D1 13
#define LED_D2 12
#define LED_D3 11
#define LED_D4 10

#define SWITCH_S1 A1
#define SWITCH_S2 A2
#define SWITCH_S3 A3

#define ANALOG_IN A0

// In-/Outputs gleicher Art in ein Array zu speichern kann späterten Code einfacher machen
// Array mit den Led Pins
byte led_pins[4] = {LED_D1, LED_D2, LED_D3, LED_D4};
// Array mit den Schalter Pins
byte switch_pins[3] = {SWITCH_S1, SWITCH_S2, SWITCH_S3};

// Array für die 4 Blöcke der 7Segment Anzeige
// Welche Blöcke aktiv sind wird durch die ersten 4 Bits des Schieberegisters bestimmt
// 1 bedeutet der Bolck ist Aktiv
//                  Tausender  Hunderter  Zehner     Einer
byte segments[4] = {B10000000, B01000000, B00100000, B00010000};

/* Anordnung der 7SegmentAnzeige
   a
f     b
   g
e     c
   d    h
*/

// Ein Array mit Zeichen/Zahlen, die an der 7SegmentAnzeige ausgegeben werden können
//                  Alle Leds aus    P           U          L          S          E
byte TEXT[6] =     {B00000000,    B11001110, B01111100, B00011100, B10110110, B10011110};
//                   abcdefgh      abcdefgh   abcdefgh   abcdefgh   abcdefgh   abcdefgh

// Alternativ, da die Leds der 7SegmentAnzeige eigentlich Low-Aktiv sind
byte TEXT_INV[6] = {B11111111,    B00110001, B10000011, B11100011, B01001001, B01100001};
//                   abcdefgh      abcdefgh   abcdefgh   abcdefgh   abcdefgh   abcdefgh

// Die setup Funktion wird einmal zu beginn des Programms ausgeführt
void setup() {
  // Serieller Monitor, default Baudrate ist 9600
  Serial.begin(9600);
  
  // Die mit #define definierten Pins als Inputs/Outputs deklarieren
  // Analog Input
  pinMode(ANALOG_IN, INPUT);
  // Outputs für Schieberegister
  pinMode(LATCH_CLOCK, OUTPUT);
  pinMode(SHIFT_CLOCK, OUTPUT);
  pinMode(SERIAL_DIN,  OUTPUT);
  // Outputs für Leds
  for(byte i=0; i<4; i++){
	pinMode(led_pins[i], OUTPUT);
  }
  // Inputs für Schalter
  for(byte i=0; i<3; i++){
	pinMode(switch_pins[i], INPUT);
  }
}

void loop() {
  // Ausgabe am seriellen Monitor
  // Wert ausgeben, mit anschließendem Zeilenumbruch
  int eineZahl = 2;
  Serial.print("Die Zahl ist: ");
  Serial.println(eineZahl);
  
  // Lesen des Zustands von Schalter S1
  // HIGH: Schalter ist offen
  // LOW:  Schalter ist geschlossen
  if(digitalRead(SWITCH_S1) == HIGH){
    // some Code
  }
  // oder
  if(digitalRead(switch_pins[0]) == HIGH){
    // some Code
  }
  
  // Lesen des Analog Inputs
  // analogRead() gibt einen Wert zwischen 0 und 1023 zurück
  int analog_value = analogRead(ANALOG_IN);
  
  
  // Ein-/Ausschalten der Leds
  // Die Leds sind Low-Aktiv d.h.
  // HIGH: Led ist aus
  // LOW:  Led ist an
  digitalWrite(LED_D1, HIGH);
  // oder
  digitalWrite(led_pins[0], HIGH);
  
  
  // Anzeigen eines Werts auf der 7SegmentAnzeige
  // Zeigt den Buchstaben U an der Tausender stelle der 7SegmentAnzeige an
  // LATCH_CLOCK muss vor beginn der Übertragung auf LOW gesetzt werden
  digitalWrite(LATCH_CLOCK, LOW);
  // shiftOut() :  Schiebt ein Byte in das Schieberegister
  // SERIAL_DIN :  Input Pin des Schieberegisters
  // SHIFT_CLOCK : Takt Pin für Schieberegister
  // LSBFIRST bzw. MSBFIRST legt die Reihenfolge der bits fest
  // TEXT[2] :     Das Byte, das angzeigt werden soll (Die letzten 8 Bit des Schieberegister Outputs)
  // segments[0] : Das Segment auf dem der Wert angezeigt werden soll (Die ersten 4 Bits des Schieberegister Outputs, der rest des Bytes ist egal)
  // ~ : Bitweise Negation (Wird benötigt, da die Leds der 7SegmentAnzeige Low-Aktiv sind)
  shiftOut(SERIAL_DIN, SHIFT_CLOCK, LSBFIRST, ~TEXT[2]); /*oder*/ shiftOut(SERIAL_DIN, SHIFT_CLOCK, LSBFIRST, TEXT_INV[2]);
  shiftOut(SERIAL_DIN, SHIFT_CLOCK, LSBFIRST, segments[0]);
  // Beim Wechsel der LATCH_CLOCK von LOW auf HIGH wird der Inhalt des Schieberegisters an den Outputs ausgegeben
  digitalWrite(LATCH_CLOCK, HIGH);
  
  
  // Anzeigen von mehreren Werten auf der 7SegmentAnzeige
  // Zeigt P U L S auf der 7SegmentAnzeige an solange SWITCH_S1 gedrückt ist
  while(digitalRead(SWITCH_S1) == LOW){ 
    for(byte i=0; i<4; i++){
      // Bei Jedem Schleifendurchgang wird der nächste Buchstabe von TEXT auf dem nächsten Segment angezeigt
      // Durch den schnellen wechsel sieht es aus als würden alle Werte gleichzeitig angezeigt
      digitalWrite(LATCH_CLOCK, LOW);
      shiftOut(SERIAL_DIN, SHIFT_CLOCK, LSBFIRST, ~TEXT[i+1]); /*oder*/ shiftOut(SERIAL_DIN, SHIFT_CLOCK, LSBFIRST, TEXT_INV[i+1]);
      shiftOut(SERIAL_DIN, SHIFT_CLOCK, LSBFIRST, segments[i]);
      digitalWrite(LATCH_CLOCK, HIGH);
    }
  }
}