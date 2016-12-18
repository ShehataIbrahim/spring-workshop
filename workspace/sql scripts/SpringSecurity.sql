--------------------------------------------------------
--  File created - Wednesday-December-14-2016   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence SPRINGUSERID_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "SPRINGJDBC"."SPRINGUSERID_SEQ"  MINVALUE 0 MAXVALUE 9999999999999 INCREMENT BY 1 START WITH 20 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Table SECURITY_USER
--------------------------------------------------------

  CREATE TABLE "SPRINGJDBC"."SECURITY_USER" 
   (	"NAME" VARCHAR2(35), 
	"PASSWORD" VARCHAR2(20), 
	"ENABLED" VARCHAR2(20)
   ) ;
--------------------------------------------------------
--  DDL for Table SPRING_USER
--------------------------------------------------------

  CREATE TABLE "SPRINGJDBC"."SPRING_USER" 
   (	"ID" NUMBER(8,0), 
	"NAME" VARCHAR2(35), 
	"AGE" NUMBER(3,0)
   ) ;
--------------------------------------------------------
--  DDL for Table USER_ROLES
--------------------------------------------------------

  CREATE TABLE "SPRINGJDBC"."USER_ROLES" 
   (	"NAME" VARCHAR2(35), 
	"ROLE" VARCHAR2(20)
   ) ;
REM INSERTING into SPRINGJDBC.SECURITY_USER
SET DEFINE OFF;
Insert into SPRINGJDBC.SECURITY_USER (NAME,PASSWORD,ENABLED) values ('shehata','password','TRUE');
Insert into SPRINGJDBC.SECURITY_USER (NAME,PASSWORD,ENABLED) values ('user','password','TRUE');
REM INSERTING into SPRINGJDBC.SPRING_USER
SET DEFINE OFF;
Insert into SPRINGJDBC.SPRING_USER (ID,NAME,AGE) values (0,'Zara',11);
Insert into SPRINGJDBC.SPRING_USER (ID,NAME,AGE) values (1,'Nuha',2);
Insert into SPRINGJDBC.SPRING_USER (ID,NAME,AGE) values (2,'Ayan',21);
REM INSERTING into SPRINGJDBC.USER_ROLES
SET DEFINE OFF;
Insert into SPRINGJDBC.USER_ROLES (NAME,ROLE) values ('shehata','ROLE_USER');
Insert into SPRINGJDBC.USER_ROLES (NAME,ROLE) values ('shehata','ADMIN');
Insert into SPRINGJDBC.USER_ROLES (NAME,ROLE) values ('user','ROLE_USER');
--------------------------------------------------------
--  DDL for Index SECURITY_USER_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "SPRINGJDBC"."SECURITY_USER_PK" ON "SPRINGJDBC"."SECURITY_USER" ("NAME") 
  ;
--------------------------------------------------------
--  DDL for Index STUDENT_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "SPRINGJDBC"."STUDENT_PK" ON "SPRINGJDBC"."SPRING_USER" ("ID") 
  ;
--------------------------------------------------------
--  Constraints for Table SECURITY_USER
--------------------------------------------------------

  ALTER TABLE "SPRINGJDBC"."SECURITY_USER" ADD CONSTRAINT "SECURITY_USER_PK" PRIMARY KEY ("NAME") ENABLE;
 
  ALTER TABLE "SPRINGJDBC"."SECURITY_USER" MODIFY ("NAME" NOT NULL ENABLE);
 
  ALTER TABLE "SPRINGJDBC"."SECURITY_USER" MODIFY ("PASSWORD" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table SPRING_USER
--------------------------------------------------------

  ALTER TABLE "SPRINGJDBC"."SPRING_USER" ADD CONSTRAINT "STUDENT_PK" PRIMARY KEY ("ID") ENABLE;
 
  ALTER TABLE "SPRINGJDBC"."SPRING_USER" MODIFY ("ID" NOT NULL ENABLE);
 
  ALTER TABLE "SPRINGJDBC"."SPRING_USER" MODIFY ("NAME" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table USER_ROLES
--------------------------------------------------------

  ALTER TABLE "SPRINGJDBC"."USER_ROLES" MODIFY ("NAME" NOT NULL ENABLE);
 
  ALTER TABLE "SPRINGJDBC"."USER_ROLES" MODIFY ("ROLE" NOT NULL ENABLE);
--------------------------------------------------------
--  DDL for Trigger ID_TRIG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "SPRINGJDBC"."ID_TRIG" 
   before insert on "SPRINGJDBC"."SPRING_USER" 
   for each row 
begin  
   if inserting then 
      if :NEW."ID" is null then 
         select SPRINGUSERID_SEQ.nextval into :NEW."ID" from dual; 
      end if; 
   end if; 
end;

/
ALTER TRIGGER "SPRINGJDBC"."ID_TRIG" ENABLE;
