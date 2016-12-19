--------------------------------------------------------
--  DDL for Table SECURITY_USER
--------------------------------------------------------

  CREATE TABLE "SECURITY_USER" 
   (	"NAME" VARCHAR2(35), 
	"PASSWORD" VARCHAR2(20), 
	"ENABLED" VARCHAR2(20)
   ) ;
--------------------------------------------------------
--  DDL for Table USER_ROLES
--------------------------------------------------------

  CREATE TABLE "USER_ROLES" 
   (	"NAME" VARCHAR2(35), 
	"ROLE" VARCHAR2(20)
   ) ;
REM INSERTING into SECURITY_USER
SET DEFINE OFF;
Insert into SECURITY_USER (NAME,PASSWORD,ENABLED) values ('shehata','password','TRUE');
Insert into SECURITY_USER (NAME,PASSWORD,ENABLED) values ('user','password','TRUE');
REM INSERTING into USER_ROLES
SET DEFINE OFF;
Insert into USER_ROLES (NAME,ROLE) values ('shehata','ROLE_USER');
Insert into USER_ROLES (NAME,ROLE) values ('shehata','ADMIN');
Insert into USER_ROLES (NAME,ROLE) values ('user','ROLE_USER');
--------------------------------------------------------
--  DDL for Index SECURITY_USER_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "SECURITY_USER_PK" ON "SECURITY_USER" ("NAME") 
  ;
--------------------------------------------------------
--  Constraints for Table USER_ROLES
--------------------------------------------------------

  ALTER TABLE "USER_ROLES" MODIFY ("NAME" NOT NULL ENABLE);
 
  ALTER TABLE "USER_ROLES" MODIFY ("ROLE" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table SECURITY_USER
--------------------------------------------------------

  ALTER TABLE "SECURITY_USER" ADD CONSTRAINT "SECURITY_USER_PK" PRIMARY KEY ("NAME") ENABLE;
 
  ALTER TABLE "SECURITY_USER" MODIFY ("NAME" NOT NULL ENABLE);
 
  ALTER TABLE "SECURITY_USER" MODIFY ("PASSWORD" NOT NULL ENABLE);
