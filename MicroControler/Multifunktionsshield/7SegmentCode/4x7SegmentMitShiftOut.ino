// Zeigt Pulse in laufschrift an mit Helligkeit über poti
/* Verbindung zwischen Arduino und Shift-Register */
#define SDI      8
#define SFTCLK   7
#define LCHCLK   4
#define ANALOG_VAL A0

/*

   a
f     b
   g
e     c
   d    h

*/

// a  b  c  d  e  f  g  h

// Array zur Anzeige des Texts PULSE am MFS (active_high, LSB-FIRST)
byte TEXT[6] = {0x00, B11001110, B01111100, B00011100, B10110110, B10011110};  //LSBFIRST
//              NULL      P       abcdefgh      L          S          E 
//    Indes:     0        1          2          3          4          5          

byte segments[4] = {B10000000, B01000000, B00100000, B00010000};                      

byte anzeigewert = 0;

void setup ()
{
  Serial.begin(9600);
  pinMode(LCHCLK, OUTPUT);
  pinMode(SFTCLK, OUTPUT);
  pinMode(SDI,    OUTPUT); 
  pinMode(ANALOG_VAL, INPUT);
}

void loop()
{
  anzeigewert = anzeigewert%6;
  // AnalogRead bestimmt helligkeit
  long currentTime = millis();
  while(millis() - currentTime < 500){
    for(byte i=0; i<analogRead(ANALOG_VAL)/20; i++){
      writeByteToSegment(segments[i%4], ~TEXT[(anzeigewert+i%4)%6]);
    }
    for(byte i=0; i<(1023-analogRead(ANALOG_VAL))/20; i++){
      writeByteToSegment(segments[i%4], ~TEXT[0]);
    }
  }

  anzeigewert++;
  Serial.println(analogRead(ANALOG_VAL));
  
}

void writeByteToSegment(byte segmentNr, byte content){
  digitalWrite(LCHCLK, LOW);
  shiftOut(SDI, SFTCLK, LSBFIRST, content); //look by help -> referenz ->shift out
  shiftOut(SDI, SFTCLK, LSBFIRST, segmentNr);
  digitalWrite(LCHCLK, HIGH);
}