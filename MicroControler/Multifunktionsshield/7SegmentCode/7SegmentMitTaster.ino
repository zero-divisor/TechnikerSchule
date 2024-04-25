/* *******************************************************************************
Einstelliger Wert (0-6) ueber shiftOut an 7-Segment-Anzeige ausgegeben
*******************************************************************************/


/* Verbindung zwischen Arduino und Shift-Register */
#define SDI      8
#define SFTCLK   7
#define LCHCLK   4

// Array zur Anzeige der Ziffern 0 to 9 am MFS (active_low, LSB-FIRST)
//const byte NUMBER[] = {0x03, 0x9F, 0x25, 0x0D, 0x99, 0x49, 0x41, 0x1F, 0x01, 0x09};  //LSBFIRST
// Array zur Anzeige der Ziffern 0 to 9 am MFS (active_high, LSB-FIRST)

//ACHTUNG: Shift-Reihenfolgen: H G F E D C B A !!!

void setup ()
{
  Serial.begin(9600);
  pinMode(LCHCLK, OUTPUT);
  pinMode(SFTCLK, OUTPUT);
  pinMode(SDI,    OUTPUT); 
  pinMode(A1,INPUT);  //DATA
  pinMode(A2,INPUT);  //LATCH
  pinMode(A3,INPUT);  //SHIFT
}

void loop()
{
  // anzeigewert am 7-Segment-Display des MFS anzeigen
  if(analogRead(A1)==0)
  {
    digitalWrite(SDI, HIGH);
    Serial.print("D1");
    delay(20);                                          //you can see the multiplex effect  flimmering display
  }
  else
  {
    digitalWrite(SDI, LOW);
    Serial.print("D0");
    delay(20);                                          //you can see the multiplex effect  flimmering display
  }

  if(analogRead(A3)==0)
  {
    digitalWrite(SFTCLK, HIGH);
    Serial.print(" S1");
    delay(20);                                          //you can see the multiplex effect  flimmering display
  }
  else
  {
    digitalWrite(SFTCLK, LOW);
    Serial.print(" S0");
    delay(20);                                          //you can see the multiplex effect  flimmering display
  }
  
  if(analogRead(A2)==0)
  {
    digitalWrite(LCHCLK, HIGH);
    Serial.print(" L1");
    delay(20);                                          //you can see the multiplex effect  flimmering display
  }
  else
  {
    digitalWrite(LCHCLK, LOW);
    Serial.print(" L0");
    delay(20);                                          //you can see the multiplex effect  flimmering display
  }
  Serial.println(" ");                                        //you can see the multiplex effect  flimmering display
} 
