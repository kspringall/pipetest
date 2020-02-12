import os
import requests

for root, dirs, files in os.walk("."):
    for filename in files:
        print(filename)


r = requests.get('http://localhost:8080/kimball')
print(r)

r2 = requests.post('http://localhost:8080/greeting/kimball')
print(r2)



