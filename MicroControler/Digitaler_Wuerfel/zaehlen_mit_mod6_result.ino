// nicht switch als bezeichnung benutzen,
// sonst funktioniert 'switch case' nicht mehr
// human readable name für den Pin an den der Schalter angeschlossen ist
#define schalter 2

unsigned long wuerfelWert = 0;

void setup()
{
  // initialisiert serielle Schnittstelle mit 9600 Baud
  Serial.begin(9600);
  // Schalter-Pin als input deklarieren
  pinMode(schalter, OUTPUT);
}

// wuerfelWert zählt hoch solange der Schalter gedrückt ist
// Wenn der Schalter losgelassen wird, wird wuerfelWert
// über die serielle Schnittstelle ausgegeben und 200ms gewartet.
void loop()
{
  // Wenn die Schaltung in Hardware aufgebaut wird
  // muss evtl. der Schalter entprellt werden
  if(digitalRead(schalter) == HIGH){
    // um 1 inkrementieren
    wuerfelWert++;
  } else {
    // Wert ausgeben, mit anschließendem Zeilenumbruch
    Serial.print("wuerfelWert: ");
    Serial.println(wuerfelWert);
    // Wert zwischen 1 und 6 generieren
    d6Result = wuerfelWert % 6 + 1;
    // d6Result ausgeben
    Serial.print("d6Result:    ");
    Serial.println(d6Result);
    // 200ms warten
    delay(200);
  }
}
