// Pins der LEDs
// (für bessere Lesbarkeit)
#define ledPinTopRight 3

long previousMilis = 0;
long currentMilis = 0;
boolean currentLedState = false;

void setup()
{
  // eine LED als Output
  pinMode(ledPinTopRight, OUTPUT);
}

void loop()
{
  currentMilis = millis();
  
  if(millis() > previousMilis + 500){
    previousMilis = currentMilis;
    currentLedState = !currentLedState;

    digitalWrite(ledPinTopRight, currentLedState);
  }
}
