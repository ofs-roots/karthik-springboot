# Service of Chatbot for ordering a garment
A chatbot which gets the product name and its size and color and adds the product to the cart.
It holds the customer details and has hands on with the product service which has the product details.

## How to run
Product service has got deployed in the port
```
http://localhost:7070/product
```
Customer service has got deployed in the port
```
http://localhost:6060/customer
```
To add product to cart through Webhook, Post call with the request body which should constitute of
a map whose keys are product, size & color
```
http://localhost:8080/customer/cart
```

## Deployment
To integrate service with dialogflow, Have to expose the web service to ngrok or to cloud                                     
### To download ngrok [click here](https://ngrok.com/download)

## Author
* **Karthikeyan Umapathy** - *Omnibot*
