--set serveroutput on;
--declare
--	v_product_id products.product_id%TYPE;
--	v_name products.name%TYPE;
--	v_price products.price%TYPE;
--	
--	cursor cv_product_cursor is
--		select product_id, name, price
--		from products
--		order by product_id;
--		
--	begin
--		open cv_product_cursor;
--		
--		loop
--			fetch cv_product_cursor
--			into v_product_id, v_name, v_price;
--			exit when cv_product_cursor%NOTFOUND;
--			
--			dbms_output.put_line('v_product_id = ' || v_product_id || ', v_name = ' || v_name || ', v_price = ' || v_price);
--		end loop;
--		
--		close cv_product_cursor;
--	end;
--	/

set serveroutput on;
declare
--	v_product_id products.product_id%TYPE;
--	v_name products.name%TYPE;
--	v_price products.price%TYPE;
	oid integer;
	
	cursor cv_product_cursor is
		select product_id, name, price
		from products
		order by product_id;
	
	begin
		--open cv_product_cursor;
		for v_product in cv_product_cursor loop		
			insert into products values ((select max(product_id) + 1 from products), null, 'my fucking test', 'my description', 11.22);
		end loop;	
		commit;
		--close cv_product_cursor;
	end;
	/