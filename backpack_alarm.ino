//the URL of my realtime channel is :https://thingspeak.com/channels/559747
#include <MPU6050_tockn.h>//includ the libarary for MPU6050
#include <Wire.h>

MPU6050 mpu6050(Wire);

long timer = 0;
String writeAPIKey = "V3M6978U78IN6XFT"; 
unsigned int interval = 1000;  //Update every 1s. 
long int now=0, previous=-50000; //Used to hold time variables.
#define DST_IP "api.thingspeak.com"  //Thingspeak Server
int buzzerPin  = 5 ;  //The buzzerPin is connected to pin 5 of the Arduino.

void setup() {
  pinMode(buzzerPin, OUTPUT);  //Setup buzzer pin as an output pin.
  Serial.begin(9600);  // Open serial Connection to Computer
  Wire.begin();
  mpu6050.begin();
  mpu6050.calcGyroOffsets(true);// calculate calibration of the gyroscope.
  Serial1.begin(115200);  // Open serial Connection to ESP8266 
  
  while (!Serial) {// wait for serial port to connect. Needed for Leonardo only
  }  
  
  Serial.println("Thingspeak Demo");
  Serial1.println("AT+RST");  //Issue Reset Command
  Serial.println("AT+RST");
  delay(8000);

  //DEBUG LOOP- display ESP output to serial Monitor.
  while (Serial1.available()) { 
  Serial.println(Serial1.read());
  }

  Serial.println("AT+CIFSR");
  Serial1.println("AT+CIFSR"); //Display IP Information
  delay(3000);
  //DEBUG LOOP- display ESP output to serial Monitor.
  while (Serial1.available()) {  
  Serial.println(Serial1.read());
  }
  
  Serial.println("AT+CIPMUX=0");  
  Serial1.println("AT+CIPMUX=0");  //Sets up Single connection mode.
  delay(2000);

  //DEBUG LOOP- display ESP output to serial Monitor.
  while (Serial1.available()) { 
    Serial.write(Serial1.read());
  }
  delay(1000);
  }

void loop()
{
now=millis(); //Get the current time.
//get the value of MPU6050 measured
if(now - previous >= interval){  //Check to see if it's time to run.
  previous = now; 
  Serial.println("Running Update");
  updateThingSpeak();
  }
   mpu6050.update();
   if(millis() - timer > 1000){
    
  //cause I fixed my MPU6050 horizontally, so I don't need to consier the affact of gravity in X and Y axis.
  float AccX; 
  float AccY;
  float distanceX;
  float distanceY;
  float distance;

  //convert g to m/s^2 and we know that 1g=9.80665m/s^2
  AccX= (mpu6050.getAccX())*9.80665;//Read the acceleration in X axis.
  AccY= (mpu6050.getAccY())*9.80665;//Read the acceleration in Y axis.
  
  distanceX=AccX*AccX;//calculate distance in X axis.
  distanceY=AccY*AccY;//calculate distance in Y axis.
  distance=sqrt(distanceX*distanceX+distanceY*distanceY);
  
 //Play a tone of 2000Hz for 50 milliseconds.
    if (distance>3){
      tone(buzzerPin, 2000,50); }   

  timer = millis();
 }
}

void updateThingSpeak(){ 
  
    //Builds the connection string for the ESP8266
    String cmd = "AT+CIPSTART=\"TCP\",\"";
  float AccX; 
  float AccY;
  float distanceX;
  float distanceY;
  float distance;
  
  AccX= (mpu6050.getAccX())*9.80665;
  AccY= (mpu6050.getAccY())*9.80665;
  distanceX=AccX*AccX;
  distanceY=AccY*AccY;
  distance=sqrt(distanceX*distanceX+distanceY*distanceY);
  
    cmd += DST_IP;
    cmd += "\",80";
    Serial1.println(cmd);  //Run the command
    Serial.println(cmd);    //Print this to the debug window
    delay(500);

    //DEBUG LOOP- display ESP output to serial Monitor.
    while (Serial1.available()) {
    Serial.write(Serial1.read());
    } 

   //I NEED TO UPDATE THIS IF STATEMENT TO MAKE SURE CONNECTION WORKED
   //if (client.connect(thingSpeakAddress, 80)){         
    String httpcmd = "GET /update?api_key=";
    httpcmd += writeAPIKey+"&field1=";
    httpcmd += distance;
    httpcmd += " HTTP/1.1\r\n";
    httpcmd += "Host: api.thingspeak.com\n";
    httpcmd += "Connection: close\r\n\r\n";
    
    Serial.print("AT+CIPSEND=");
    Serial.println(httpcmd.length());
  
    Serial1.print("AT+CIPSEND=");
    Serial1.println(httpcmd.length());
    delay(500);

    Serial.print(">");
    Serial1.println(httpcmd);
    Serial.println(httpcmd);
    delay(500);

    //DEBUG LOOP- display ESP output to serial Monitor.
     while (Serial1.available()) {
      Serial.write(Serial1.read());
      }
   
    Serial.println("AT+CIPCLOSE");
    Serial1.println("AT+CIPCLOSE"); //Close the Web Connection
    delay(500);
    
     //DEBUG LOOP- display ESP output to serial Monitor.
     while (Serial1.available()) {
      Serial.write(Serial1.read());
      }
}


