select * from customers;

select * from product_types;

select * from products;

select * from purchases;

select * from employees;

select * from salary_grades;

insert into customers
  (customer_id, first_name, last_name, dob, phone)
values
  (6, 'Fred', 'Brown', '01-JAN-1970', '800-555-1215');

update customers set last_name = 'Orange' where customer_id = 2;

delete from customers c where c.customer_id = 6;

rollback;

select product_id, product_type_id, name
  from products
intersect
select prd_id, prd_type_id, name from more_products;

select product_id, product_type_id, name
  from products
minus
select prd_id, prd_type_id, name from more_products;

select translate('meet me in the park',
                 'abcdefghijklmnopqrstuvwxyz',
                 'efghijklmnopqrstuvwxyzabcd')
  from dual;

select prd_id,
       available,
       decode(available,
              'Y',
              'Product is available',
              'Product is not available')
  from more_products;



select product_id, product_type_id, 
decode(product_type_id,
1, 'Book',
2, 'Video',
3, 'DVD',
4, 'CD',
'Magazine')
from products;



select product_id,
       product_type_id,
       case product_type_id
         when 1 then 'Book'
         when 2 then 'Video'
         when 3 then 'DVD'
         when 4 then 'CD'
         else
          'Magazine'
       end
  from products;

select product_id,
       product_type_id,
       case 
         when product_type_id = 1 then 'Book'
         when product_type_id = 2 then 'Video'
         when product_type_id = 3 then 'DVD'
         when product_type_id = 4 then 'CD'
         else
          'Magazine'
       end
  from products;
  
select product_id,
       price,
       (case
         when price > 15 then
          'Expensive'
         else
          'Cheap'
       end) CheapOrExpesive
  from products;
