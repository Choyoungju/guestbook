

-- insert
insert into guestbook values(GUESTBOOK_SEQ,'dhodksehla','1234','gd', SYSDATE);

--select
select no, name, password, message, to_char(reg_date,'YYYY-MM-DD HH:MI:SS') from guestbook;


--delete
delete from guestbook where no =1 and password = '...';



commit;