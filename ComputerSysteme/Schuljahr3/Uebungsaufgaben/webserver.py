# Programmieren Sie einen einfachen (minimalen!) Webserver, der anhand eines (einfachen) HTTP-Requests eine HTML-Seite ausliefert.

from http.server import BaseHTTPRequestHandler, HTTPServer
from pathlib import Path

hostName = "localhost"
serverPort = 6666
basePath = "./pages"

class MyServer(BaseHTTPRequestHandler):
    def do_GET(self):
        # homepage
        if self.path == "/":
            self.path = "/page1.html"
        
        file_path = Path(basePath + "/page1.html")
        file_content = file_path.read_text()
        
        self.send_response(200)
        self.send_header("Content-type", "text/html")
        self.end_headers()
        self.wfile.write(bytes(file_content, "utf-8"))

if __name__ == "__main__":        
    webServer = HTTPServer((hostName, serverPort), MyServer)
    print("Server started http://%s:%s" % (hostName, serverPort))

    try:
        webServer.serve_forever()
    except KeyboardInterrupt:
        pass

    webServer.server_close()
    print("Server stopped.")
