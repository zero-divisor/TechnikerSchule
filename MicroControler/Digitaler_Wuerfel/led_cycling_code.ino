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
int currentLedIndex = 0;


void setup()
{
  // LED-Pins als outputs deklarieren
  for(int i=0; i<wuerfelLedsSize; i++){
    pinMode(wuerfelLeds[i], OUTPUT);
  }
}

void loop()
{
  // An
  digitalWrite(wuerfelLeds[currentLedIndex], HIGH);
  delay(onTime);
  // Aus
  digitalWrite(wuerfelLeds[currentLedIndex], LOW);
  delay(offTime);
  
  // nächste LED
  // modulo um Wertebereich auf wuerfelLedsSize zu beschränken
  currentLedIndex = (currentLedIndex + 1) % wuerfelLedsSize;
}
