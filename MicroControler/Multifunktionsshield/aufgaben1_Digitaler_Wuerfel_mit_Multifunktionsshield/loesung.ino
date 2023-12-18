// Pins der LEDs
// (für bessere Lesbarkeit)
#define D1 13
#define D2 12
#define D3 11
#define D4 10
// nicht switch als bezeichnung benutzen,
// sonst funktioniert 'switch case' nicht mehr
#define schalter A1

byte loopCounter = 0;
byte wuerfelWert = 0;

// Array mit den Pins der LEDs
byte wuerfelLeds[7] = 
{
  D4,
  D3,
  D2,
  D1
};

// Array mit Bitmustern für die verschiedenen Ergebnisse
// resultArray ist invertiert, da LEDs low aktiv sind
boolean resultArray[7][4] = 
{
// D4 D3 D2 D1
  {1, 1, 1, 1},// Wüfelwert 0
  {1, 1, 1, 0},// Wüfelwert 1
  {1, 1, 0, 0},// Wüfelwert 2
  {1, 0, 0, 0},// Wüfelwert 3
  {1, 0, 0, 1},// Wüfelwert 4
  {0, 1, 1, 0},// Wüfelwert 5
  {0, 0, 0, 0} // Wüfelwert 6
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
  Serial.println("FTIT23_Weiss");
  // Schalter-Pin als input deklarieren
  // Schalter ist LOW aktiv
  pinMode(schalter, INPUT);
  
  // LED-Pins als outputs deklarieren
  for(byte i=0; i<wuerfelLedsSize; i++){
    pinMode(wuerfelLeds[i], OUTPUT);
  }
}

void loop()
{
  // Wenn die Schaltung in Hardware aufgebaut wird
  // muss evtl. der Schalter entprellt werden
  while(!digitalRead(schalter)){
    // um 1 inkrementieren
    loopCounter++;
  }
  
  // Wert zwischen 0 und 6 generieren
  wuerfelWert = loopCounter % 7;
  showWuerfelWert(wuerfelWert);
   // Wert ausgeben, mit anschließendem Zeilenumbruch
  Serial.print("wuerfelWert: ");
  Serial.println(wuerfelWert);
  // 200ms warten
  delay(200);
  // Leds ausschalten
  ledsOff();
}

// Alle LEDs aus
void ledsOff(){
  for(byte i=0; i<wuerfelLedsSize; i++){
	// HIGH weil LEDs low aktiv angeschlossen sind
	digitalWrite(wuerfelLeds[i], HIGH);
  }
}

// Zeigt Zahl zwischen 0 und 6 an
void showWuerfelWert(int result){
  for(int i=0; i<wuerfelLedsSize; i++){
	digitalWrite(wuerfelLeds[i], resultArray[result][i]);
  }
}