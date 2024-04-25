//Beispielprogramm: Quadrat blinkt wechselweise oben und unten auf Digit_2

/* Verbindung zwischen Arduino und Shift-Register */
#define SDI      8
#define SFTCLK   7
#define LCHCLK   4  //Pinbelegung siehe Schaltplan MFS

boolean quad_oben[16]  = {0,1,1,0,0,0,1,1, 0,0,0,0,1,0,1,1}; //Quadrat oben an Stelle Zehner anzeigen
boolean quad_unten[16] = {0,1,0,1,1,1,0,0, 0,0,0,0,1,0,1,1}; //Quadrat unten an Stelle Zehner anzeigen
//           high-active  h g f e d c b a  x x x x E Z H T
void setup ()
{
  pinMode(LCHCLK, OUTPUT);
  pinMode(SFTCLK, OUTPUT);
  pinMode(SDI,    OUTPUT); 

  digitalWrite(LCHCLK, LOW);
  digitalWrite(SFTCLK, LOW);
  digitalWrite(SDI,    LOW); 
}

void loop()
{
  digitalWrite(LCHCLK, LOW);
  delay(5);
  for(byte i=0; i<16; i++)
  {
    digitalWrite(SFTCLK, LOW);  
    delay(1);
    digitalWrite(SDI, !quad_unten[i]);
    delay(1);
    digitalWrite(SFTCLK, HIGH);
    delay(1);
  }   
  digitalWrite(LCHCLK, HIGH);
  delay(500);

  digitalWrite(LCHCLK, LOW);
  delay(5);
  for(byte i=0; i<16; i++)
  {
    digitalWrite(SFTCLK, LOW);  
    delay(1);
    digitalWrite(SDI, !quad_oben[i]);
    delay(1);
    digitalWrite(SFTCLK, HIGH);
    delay(1);
  }   
  digitalWrite(LCHCLK, HIGH);
  delay(500);  
} 