# Setup steps of order-item-service




#Application run at port 
http://localhost:8888/order-item-service/default


# Used DDL Queries 
create table order_item (id bigint not null, product_code varchar(255), product_name varchar(255), quantity bigint, primary key (id));

create sequence seq_order_item start with 1 increment by 1;

# H2 Console 
http://localhost:8095/h2-console/login.jsp?jsessionid=3839e20971d8f37b9750c97a4b2a35d2

http://localhost:8091/h2-console/login.jsp?jsessionid=3839e20971d8f37b9750c97a4b2a35d2