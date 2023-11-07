// Pins der LEDs
// (für bessere Lesbarkeit)
#define ledPinTopRight 3
#define ledPinMiddleRight 4
#define ledPinBottomRight 5
#define ledPinMiddleMiddle 6
#define ledPinTopLeft 7
#define ledPinMiddleLeft 8
#define ledPinBottomLeft 9
// nicht switch als bezeichnung benutzen,
// sonst funktioniert 'switch case' nicht mehr
#define schalter 2

byte wuerfelWert = 0;
byte d6Result = 0;

// Array mit den Pins der LEDs
byte wuerfelLeds[] = 
{
  ledPinTopLeft,
  ledPinTopRight,
  ledPinMiddleLeft,
  ledPinMiddleMiddle,
  ledPinMiddleRight,
  ledPinBottomLeft,
  ledPinBottomRight
};

// Anzahl der Würfel LEDs:
// sizeof() ist Größe in Byte, 
// desshalb muss man noch durch die Größe der Elemente teilen,
// um die Anzahl der Elemente zu erhalten.
int wuerfelLedsSize = sizeof(wuerfelLeds) / sizeof(wuerfelLeds[0]);

void setup()
{
  // initialisiert serielle Schnittstelle mit 9600 Baud
  Serial.begin(9600);
  // Schalter-Pin als input deklarieren
  pinMode(schalter, OUTPUT);
  
  // LED-Pins als outputs deklarieren
  for(byte i=0; i<wuerfelLedsSize; i++){
    pinMode(wuerfelLeds[i], OUTPUT);
  }
}

// wuerfelWert zähl hoch solange der Schalter gedrückt ist
// Wenn der Schalter losgelassen wird, wird wuerfelWert
// über die serielle Schnittstelle ausgegeben und 200ms gewartet.
void loop()
{
  // Wenn die Schaltung in Hardware aufgebaut wird
  // muss evtl. der Schalter entprellt werden
  while(digitalRead(schalter)){
    // um 1 inkrementieren
    wuerfelWert++;
  }
  
  // Wert ausgeben, mit anschließendem Zeilenumbruch
  Serial.print("wuerfelWert: ");
  Serial.println(wuerfelWert);
  // Wert zwischen 1 und 6 generieren
  d6Result = wuerfelWert % 6 + 1;
  // d6Result ausgeben
  Serial.print("d6Result:    ");
  Serial.println(d6Result);
  // Ergebnis anzeigen
  showD6Result(d6Result);
  // 200ms warten
  delay(200);
  // Leds ausschalten
  ledsOff();
}

// Alle LEDs aus
void ledsOff(){
  for(byte i=0; i<wuerfelLedsSize; i++){
	digitalWrite(wuerfelLeds[i], LOW);
  }
}

// Zeigt Zahl zwischen 1 und 6 an
void showD6Result(int result){
  byte ledStates;
  switch (result) {
    case 1:
	  // lsb = topLeft, msb = bottomRight
      ledStates = 0b0001000;
      break;
    case 2:
      ledStates = 0b1000001;
      break;
	case 3:
      ledStates = 0b1001001;
      break;
	case 4:
      ledStates = 0b1100011;
      break;
	case 5:
      ledStates = 0b1101011;
      break;
	case 6:
      ledStates = 0b1110111;
      break;
    default:
	  // Bei ungültigem wert alle LEDs an
	  ledStates = 0b1111111;
      break;
  }
  
  for(int i=0; i<wuerfelLedsSize; i++){
	digitalWrite(wuerfelLeds[i], (ledStates >> i) & 1);
  }
}
