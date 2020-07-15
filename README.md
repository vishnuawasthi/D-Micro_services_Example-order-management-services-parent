# order-management-services-parent steps to run the application

Step 1. clone the repository 

git clone https://github.com/vishnuawasthi/order-management-services-parent.git

Step 2.  Import the code into STS or eclipse as existing maven project 

step 3.  Run MAVEN goal to make it compatible to eclipse 

			eclipse:eclipse
			
step 4. Run goal clean install 

			clean install 
			
step 5. We have below deployaable as part of order management 

		1. discovery-server (Eureka Server)
		2. order-service-config-server (Config server -> Not requied right now)
		3. order-item-service (ORDER ITEM SERVICE)
		4. order-service  (ORDER SERVICE)
		
step 6. Run the discovery server 

step 7. run order-service-config-server

step 8. run order-item-service 

step 9.  run order-service 

step 10. Once all applications are up and running we can see Eureka dashboard at http://localhost:8761/


step 11.  Use below request from post man or any rest client to post the order 
URL http://localhost:8095/api/v1/orders
Method : POST
{
  "customerName": "Vishnu Awasthi",
  "shippingAddress" :"3179 MIG ",
  "orderDate": "2020-07-14",
 
  "orderItems": [
    {
      "productCode": "EC-01",
      "productName": "LG Laptop",
      "quantity": "1",
      "price": "2000"
    },
    {
      "productCode": "EC-02",
      "productName": "LG TV",
      "quantity": "2",
      "price": "1500"
    }
    
  ]
}

Step 12 . Use below end point to get the order details once it is created 

 Url: http://localhost:8095/api/v1/orders/{orderId}
 Ex : http://localhost:8095/api/v1/orders/1
 Method : GET
 Response 
 
 {
    "id": 2,
    "customerName": "Vishnu Awasthi",
    "shippingAddress": "3179 MIG ",
    "orderDate": "2020-07-14",
    "orderItems": [
        {
            "productCode": "EC-01",
            "productName": "LG Laptop",
            "quantity": 1
        },
        {
            "productCode": "EC-02",
            "productName": "LG TV",
            "quantity": 2
        }
    ],
    "total": 5000
}

Step 13. Exception response
{ "status": 400, "description": "Bad Request", "errors": [ "customerName must not be empty" ] }


