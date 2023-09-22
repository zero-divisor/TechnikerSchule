// Pins der LEDs
// (für bessere Lesbarkeit)
#define ledPinTopRight 3
#define ledPinMiddleRight 4
#define ledPinBottomRight 5
#define ledPinMiddleMiddle 6
#define ledPinTopLeft 7
#define ledPinMiddleLeft 8
#define ledPinBottomLeft 9

// An/Aus Zeiten
int onTime = 500;//ms
int offTime = 200;//ms

// Array mit den Pins der LEDs
int wuerfelLeds[] = 
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

// Aktuell benutzte LED
int loopCounter = 0;


void setup()
{
  // LED-Pins als outputs deklarieren
  for(int i=0; i<wuerfelLedsSize; i++){
    pinMode(wuerfelLeds[i], OUTPUT);
  }
}

void loop()
{
  showD6Result(loopCounter);
  delay(onTime);
  ledsOff();
  delay(offTime);
  // nächste LED
  // modulo um Wertebereich auf wuerfelLedsSize zu beschränken
  loopCounter = (loopCounter + 1) % wuerfelLedsSize;
}

// Alle LEDs aus
void ledsOff(){
  for(int i=0; i<wuerfelLedsSize; i++){
	digitalWrite(wuerfelLeds[i], LOW);
  }
}

// Zeigt Zahl zwischen 1 und 6 an
void showD6Result(int result){
  int ledStates;
  switch (result) {
    case 1:
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