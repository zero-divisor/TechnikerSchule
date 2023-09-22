int loopCounter = 0;

int onTime = 500;
int offTime = 200;

int ledPin0 = 3;
int ledPin1 = 4;
int ledPin2 = 5;
int ledPin3 = 6;
int ledPin4 = 7;
int ledPin5 = 8;
int ledPin6 = 9;

int wuerfelLeds[] = 
{
  ledPin0,
  ledPin1,
  ledPin2,
  ledPin3,
  ledPin4,
  ledPin5,
  ledPin6
};

int wuerfelLedsSize = sizeof(wuerfelLeds) / sizeof(wuerfelLeds[0]);

void setup()
{
  for(int i=0; i<wuerfelLedsSize; i++){
    pinMode(wuerfelLeds[i], OUTPUT);
  }
}

void loop()
{
  digitalWrite(wuerfelLeds[loopCounter], HIGH);
  delay(onTime);
  digitalWrite(wuerfelLeds[loopCounter], LOW);
  delay(offTime);
  loopCounter = (loopCounter + 1) % wuerfelLedsSize;
}
