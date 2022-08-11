import  java.io.*;
import java.util.*;

public class ValidTriangle {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Values : " );
        System.out.print("a = ");
        int a = sc.nextInt();
        System.out.print("b = ");
        int b = sc.nextInt();
        System.out.print("c = ");
        int c = sc.nextInt();

        System.out.println((a + b <= c || a + c <= b || b + c <= a) ? "Triangle is Not Valid." : "Triangle is Valid.");
    }
}


/**
Use cms;


SELECT : - 
Select *from user;
Select *from user where id = 2;
Select *from user where name = ‘name’;
Select *from user order by id;
Select *from user order by id desc;
Select *from user order by id asc;
Select *from user order by first_name, last_name asc; 
Select *, id/10 from user;
Select *, id/10 as newCol from user;    // as gives an alias to the quantity we wanna see.
Select 1,2,3,4,5;
select 1 as abc, 2 as abcd;
select *from user where id between 2 AND 3;
select distinct password from user;
select distinct password from user order by id desc;
select *from user where id > 2;
select *from user where id >= 2 order by id desc;
select *from user where id != 3 order by id desc; (all operators (<> == !=))
select *from user where (id = 2 or id = 3);
select *from user where not(id = 2 or id = 3);
select *from user where (id = 2 and id = 3);
select *from user where not(id = 2 and id = 3);
(_) one character ….. (%) any number of characters.
select *from user where mobileNumber like '%6%'; ( like string startsWith and endsWith)
select *from user where answer like '_o_';
select *from user where name like '_____';
select *from user where name like 'Admin'; (perfect match)
select *from user where name regexp 'Admin';
^string -> it will check if your string comes at the beginning
String$ -> it will check if your string comes at the end 
select *from user where answer regexp '^k'; (starting from)
select *from user where answer regexp ‘m$’; (ending from)
select *from user where id in(2,3);
select *from user where id not in(2,3);
select *from user where mobileNumber regexp 'b|v|3';    (spaces will count)
first_names containing ae or be or ce or de ……….he  ( [a-h]e )
select *form user where mobileNumber is null;
select *from user where mobileNumber is not null;
select *from user limit 5;

INNER JOIN / EQUI JOIN : 
select *from user join bill on user.id = bill.id;
 SELECT * FROM user u JOIN bill b ON u.id = b.id;
SELECT user.id, bill.id, user.name, bill.name FROM user JOIN bill ON user.id = bill.id;
SELECT user.id, bill.id, user.name, bill.name FROM user u JOIN bill b ON user.id = bill.id;

*/
