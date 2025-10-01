import requests

x = requests.get('http://localhost:6666')

print(x.text)