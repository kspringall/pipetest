import requests

r = requests.get('http://localhost:8080/kimball')
print(r)

r2 = requests.post('http://localhost:8080/greeting/kimball')
print(r2)



