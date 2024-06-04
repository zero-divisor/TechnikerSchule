/* *******************************************************************************
Text PULSE nacheinander ueber shiftOut an 7-Segment-Anzeige ausgegeben
Leerzeichen - P - U - L - S - E - Leerzeichen - P - U - ....
*******************************************************************************/

/* Verbindung zwischen Arduino und Shift-Register */
#define SDI      8
#define SFTCLK   7
#define LCHCLK   4

void setup ()
{
  Serial.begin(9600);
  pinMode(LCHCLK, OUTPUT);
  pinMode(SFTCLK, OUTPUT);
  pinMode(SDI,    OUTPUT); 
}

void loop()
{
  // Text PULSE 7-Segment-Anzeigen ausgeben
  digitalWrite(LCHCLK, LOW);            //Shift register 74xx595: https://www.arduino.cc/en/Tutorial/ShiftOut
  shiftOut(SDI, SFTCLK, LSBFIRST, 0x00);   //Ausgabe: alles aus
  digitalWrite(LCHCLK, HIGH);
  delay(500);                              
  digitalWrite(LCHCLK, LOW);            
  shiftOut(SDI, SFTCLK, LSBFIRST, B11001110);   //Ausgabe: P
  digitalWrite(LCHCLK, HIGH);
  delay(500);                              
  digitalWrite(LCHCLK, LOW);               
  shiftOut(SDI, SFTCLK, LSBFIRST, B01111100);   //Ausgabe: U
  digitalWrite(LCHCLK, HIGH);
  delay(500);         
  digitalWrite(LCHCLK, LOW);               
  shiftOut(SDI, SFTCLK, LSBFIRST, B00011100);   //Ausgabe: L
  digitalWrite(LCHCLK, HIGH);
  delay(500);                              
  digitalWrite(LCHCLK, LOW);              
  shiftOut(SDI, SFTCLK, LSBFIRST, B10110110);   //Ausgabe: S
  digitalWrite(LCHCLK, HIGH);
  delay(500);                              
  digitalWrite(LCHCLK, LOW);               
  shiftOut(SDI, SFTCLK, LSBFIRST, B10011110);   //Ausgabe: E
  digitalWrite(LCHCLK, HIGH);
  delay(500);
} 
