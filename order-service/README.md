

# Sample request of order service
http://localhost:8095/api/v1/orders
Method : POST


{
  "customerName": "Vishnu Awasthi",
  "shippingAddress" :"3179 MIG",
  "orderDate": "2020-07-14",
 
  "orderItems": [
    {
      "productCode": "EC-01",
      "productName": "LG Laptop",
      "quantity": "1",
      "price": "29653"
    }
  ]
}

{
  "customerName": "Vishnu Awasthi",
  "shippingAddress" :"3179 MIG ",
  "orderDate": "2020-07-14",
 
  "orderItems": [
    {
      "productCode": "EC-01",
      "productName": "LG Laptop",
      "quantity": "1",
      "price": "29653"
    },
    {
      "productCode": "EC-01",
      "productName": "LG Laptop",
      "quantity": "1",
      "price": "29653"
    },
    {
      "productCode": "EC-01",
      "productName": "LG Laptop",
      "quantity": "1",
      "price": "29653"
    }
    
  ]
}