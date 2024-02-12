#define poti A0
#define led4 10
#define led3 11
#define led2 12
#define led1 13

unsigned long adValue = 0;
boolean blinkValue = true;

void setup()
{
  Serial.begin(9600);
  pinMode(led1, OUTPUT);
  pinMode(led2, OUTPUT); 
  pinMode(led3, OUTPUT); 
  pinMode(led4, OUTPUT);
  pinMode(poti, INPUT);
}

void loop()
{
  adValue = analogRead(poti);
  
  Serial.print(adValue, BIN);
  Serial.print("bin ");
  Serial.print(adValue, HEX);
  Serial.print("hex ");
  Serial.print(adValue, DEC);
  Serial.print("dec ");
  Serial.print(literConversion(adValue));
  Serial.print("l ");
  Serial.print(percentConversion(adValue));
  Serial.println("%");
  
  if(literConversion(adValue) < 50){
    digitalWrite(led4, blinkValue);
    digitalWrite(led3, blinkValue);
    digitalWrite(led2, blinkValue);
    digitalWrite(led1, blinkValue);
    blinkValue = !blinkValue;
    delay(1000);
  }else{
    // Leds sind mit invertierter Logik angeschlossen
    digitalWrite(led4, percentConversion(adValue) <= 20);
    digitalWrite(led3, percentConversion(adValue) <= 40);
    digitalWrite(led2, percentConversion(adValue) <= 60);
    digitalWrite(led1, percentConversion(adValue) <= 80);
  }
}

// Der Tank ist bereits bei 2.5V voll
unsigned long percentConversion(unsigned long digitalValue){
  return digitalValue*100/512;
}

unsigned long literConversion(unsigned long digitalValue){
  return percentConversion(digitalValue)*10;
}