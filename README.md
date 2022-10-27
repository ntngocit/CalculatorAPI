# CalculatorAPI
A Spring Boot Rest API to calculate the square root of an input number array

To Test the API:
- Start the application
- Call API :
                  curl --location --request GET 'http://localhost:8080/api/v1/calculator/rootsquare' \
                  --header 'Content-Type: application/json' \
                  --data-raw '{"data":[5,4,6,1]}'
