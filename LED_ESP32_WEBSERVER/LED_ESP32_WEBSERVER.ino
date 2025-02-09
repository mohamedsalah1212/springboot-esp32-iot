#include <WiFi.h>
#include <WebServer.h>

const char* ssid = "ASDASD";
const char* password = "*A15*02468";

WebServer server(80);
const int ledPin = 2;

void handleRoot() {
  String html = "<h1>ESP32 Web Server</h1>"
                "<p><a href='/on'>Turn LED ON</a></p>"
                "<p><a href='/off'>Turn LED OFF</a></p>";
  server.send(200, "text/html", html);
}

void handleOn() {
  digitalWrite(ledPin, HIGH);
  server.send(200, "text/html", "LED is ON From ESP");
}

void handleOff() {
  digitalWrite(ledPin, LOW);
  server.send(200, "text/html", "LED is OFF From ESP");
}

void setup() {
  Serial.begin(115200);
  pinMode(ledPin, OUTPUT);
  
  WiFi.begin(ssid, password);
  while (WiFi.status() != WL_CONNECTED) {
    delay(1000);
    Serial.println("Connecting...");
  }
  Serial.println("Connected to WiFi");
Serial.print("IP Address: ");
Serial.println(WiFi.localIP());

  server.on("/", handleRoot);
  server.on("/on", handleOn);
  server.on("/off", handleOff);
  
  server.begin();
  Serial.println("HTTP Server Started");
}

void loop() {
  server.handleClient();
}
