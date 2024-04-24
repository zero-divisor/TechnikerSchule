#define data 8
#define shift 7
#define latch 4
#define schalter A1
/*
shift 0 latch 0
-- Solange wiederholen bis alle werte drin sind
input anlegen
shift von 0 auf 1
shift auf 0
--
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
  {0, 0, 0, 0, 0, 0, 1, 1},//0
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

void loop() {
  while(!digitalRead(schalter)){
    // Wert zwischen 0 und 9999 generieren
    wuerfelWert = random(0, 9999);
    displayNumberOn7SegmentDisplay(wuerfelWert, 20);
  }
  displayNumberOn7SegmentDisplay(wuerfelWert, 200);
}

// number 0-9999
void displayNumberOn7SegmentDisplay(int number, long duration){
  long startMilis = millis();
  //                  tausender          hunderter        zehner        einer
  byte digits[4] = {(number/1000)%10, (number/100)%10, (number/10)%10, number%10};

  // um voranstehende nullen zu entfernen
  if(number < 1000) digits[0] = 255;
  if(number < 100) digits[1] = 255;
  if(number < 10) digits[2] = 255;
  
  while(millis() < startMilis + duration){
    for(int i=0; i<4; i++){
      if(digits[i] == 255){
        writeEmptyToSegment(i);
      }else{
        writeDigitToSegment(digits[i], i);
      }
    }
  }
}

// digit 0-9; segmentNr 0-3
void writeDigitToSegment(byte digit, byte segmentNr){
  digitalWrite(latch, LOW);
  
  writeNumberToRegister(digit);
  enableSegment(segmentNr);
  
  digitalWrite(latch, HIGH);
  digitalWrite(latch, LOW);
}

void writeEmptyToSegment(byte segmentNr){
  digitalWrite(latch, LOW);
  
  for(int i=7; i>=0; i--){
    writeBitToRegister(1);
  }
  enableSegment(segmentNr);
  
  digitalWrite(latch, HIGH);
  digitalWrite(latch, LOW);
}

// segNr 0-3
void enableSegment(byte segNr){
  for(int i=7; i>=0; i--){
    writeBitToRegister(i==segNr);
  }
}

// num 0-9
void writeNumberToRegister(byte num){
  for(int i=7; i>=0; i--){
    writeBitToRegister(werte[num][i]);
  }
}

void writeBitToRegister(boolean bit){
  digitalWrite(shift, LOW);
  
  digitalWrite(data, bit);
  
  digitalWrite(shift, HIGH);
  
  digitalWrite(shift, LOW);
}
