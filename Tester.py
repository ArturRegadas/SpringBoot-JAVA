import requests

with open("tests.txt", 'r') as file:
    tests = file.read().split("\n\n")

APILink = "http://localhost:8080/api"
for i in tests:
    print(tests)