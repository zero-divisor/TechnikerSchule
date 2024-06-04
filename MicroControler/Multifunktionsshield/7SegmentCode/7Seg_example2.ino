/* *******************************************************************************
Text PULSE nacheinander ueber shiftOut an 7-Segment-Anzeige ausgegeben
Leerzeichen - P - U - L - S - E - Leerzeichen - P - U - ....
*******************************************************************************/

/* Verbindung zwischen Arduino und Shift-Register */
#define SDI      8
#define SFTCLK   7
#define LCHCLK   4

// Array zur Anzeige des Texts PULSE am MFS (active_high, LSB-FIRST)
byte TEXT[6] = {0x00, B11001110, B01111100, B00011100, B10110110, B10011110};  //LSBFIRST
//              NULL      P       abcdefgh      L          S          E 
//    Indes:     0        1          2          3          4          5
byte anzeigewert = 0; //B00000000 ,0x00                                   

void setup ()
{
  Serial.begin(9600);
  pinMode(LCHCLK, OUTPUT);
  pinMode(SFTCLK, OUTPUT);
  pinMode(SDI,    OUTPUT); 
}

void loop()
{
  if(anzeigewert>5)
  {
    anzeigewert = 0;
  }
  Serial.println(anzeigewert);
  // anzeigewert am 7-Segment-Display des MFS anzeigen
  digitalWrite(LCHCLK, LOW);                            //Shift register 74xx595: https://www.arduino.cc/en/Tutorial/ShiftOut
  shiftOut(SDI, SFTCLK, LSBFIRST, ~TEXT[anzeigewert]); //look by help -> referenz ->shift out
  shiftOut(SDI, SFTCLK, LSBFIRST, 0b00101111);          //Anzeige an Zehner-Stelle - letzten 4 bit nicht relevant
  digitalWrite(LCHCLK, HIGH);
  delay(500);                                          //you can see the multiplex effect  flimmering display
  anzeigewert++;
} 
