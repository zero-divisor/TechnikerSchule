/*
Schreiben Sie im Simulationsprogramm den Programmcode, der folgendes Wort
(Zeichen für Zeichen) nacheinander auf der 7-Segm-Anzeige ausgibt: PULSE. 
*/

#define data 8
#define shift 7
#define latch 4

/*

   a
f     b
   g
e     c
   d    h

*/

// a  b  c  d  e  f  g  h

byte counter = 0;
byte letters[5] = {
  0b00110001,
  0b10000011,
  0b11100011,
  0b01001001,
  0b01100001
};

void setup() {
  pinMode(data, OUTPUT);
  pinMode(shift, OUTPUT);
  pinMode(latch, OUTPUT);
}

void loop() {
  writeByteToRegister(letters[counter%5]);
  delay(500);
  counter++;
}

void writeByteToRegister(byte b){
  digitalWrite(latch, LOW);
  for(int i=0; i<=7; i++){
    writeBitToRegister((b >> i) & 1);
  }
  digitalWrite(latch, HIGH);
  digitalWrite(latch, LOW);
}

void writeBitToRegister(boolean bit){
  digitalWrite(shift, LOW);
  digitalWrite(data, bit);
  digitalWrite(shift, HIGH);
  digitalWrite(shift, LOW);
}
