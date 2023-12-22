// nicht switch als bezeichnung benutzen,
// sonst funktioniert 'switch case' nicht mehr
#define schalter A1
#define data 8
#define shift 7
#define latch 4
/*
shift 0 latch 0
input anlegen
shift von 0 auf 1
shift auf 0
latch von 0 auf 1
latch auf 0

register 1-4 7-Segment enable 1-4
register 9-16 einzelne segmente

   a
f    b
   g
e    c
   d   h
*/

boolean werte[10][8] = {
// a  b  c  d  e  f  g  h
  {1, 1, 1, 1, 1, 1, 1, 1},//0
  {1, 0, 0, 1, 1, 1, 1, 1},//1
  {0, 0, 1, 0, 0, 1, 0, 1},//2
  {0, 0, 0, 0, 1, 1, 0, 1},//3
  {1, 0, 0, 1, 1, 0, 0, 1},//4
  {0, 1, 0, 0, 1, 0, 0, 1},//5
  {0, 1, 0, 0, 0, 0, 0, 1},//6
  {0, 0, 0, 1, 1, 1, 1, 1},//7
  {0, 0, 0, 0, 0, 0, 0, 1},//8
  {0, 0, 0, 0, 1, 0, 0, 1} //9
};


int wuerfelWert = 0;

void setup() {
  pinMode(data, OUTPUT);
  pinMode(shift, OUTPUT);
  pinMode(latch, OUTPUT);
}

// !!! untested !!!
void loop() {
  while(!digitalRead(schalter)){
    // Wert zwischen 0 und 9999 generieren
    wuerfelWert = milis() % 10000;
    displayNumberOn7SegmentDisplay(wuerfelWert, 50);
  }
  displayNumberOn7SegmentDisplay(wuerfelWert, 200);
}

// !!! untested !!! number 0-9999
void displayNumberOn7SegmentDisplay(int number, long duration){
  long startMilis = millis();
  //                  tausender          hunderter        zehner        einer
  byte digits[4] = {(number/1000)%10, (number/100)%10, (number/10)%10, number%10};
  
  while(milis() < startMilis + duration){
    for(int i=0; i<4; i++){
      writeDigitToSegment(digits[i], i);
      delay(50);
    }
  }
}

// digit 0-9; segmentNr 0-3
void writeDigitToSegment(byte digit, byte segmentNr){
  writeNumberToRegister(digit);
  enableSegment(segmentNr);
}

// segNr 0-3
void enableSegment(byte segNr){
  for(byte i=7; i>=0; i--){
    writeBitToRegister(i==segNr);
  }
}

// num 0-9
void writeNumberToRegister(byte num){
  for(byte i=7; i>=0; i--){
    writeBitToRegister(werte[num][i]);
  }
}

void writeBitToRegister(boolean bit){
  digitalWrite(shift, LOW);
  digitalWrite(latch, LOW);
  //delay(10);
  digitalWrite(data, bit);
  //delay(10);
  digitalWrite(shift, HIGH);
  //delay(10);
  digitalWrite(shift, LOW);
  digitalWrite(latch, HIGH);
  //delay(10);
  digitalWrite(latch, LOW);
  //delay(10);
}
