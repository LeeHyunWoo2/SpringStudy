create user book_ex identified by book_ex default tablespace users temporary tablespace temp;

grant connect, dba to book_ex;

select dbms_xdb.gethttpport() from dual; -- 8080 포트 사용중임을 확인한다.

exec dbms_xdb.sethttpport(9090); -- 이클립스에서 안되는 명령어라서 sqlplus에서 해야함