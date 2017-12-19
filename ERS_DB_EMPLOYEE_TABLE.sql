--------------------------------------------------------
--  File created - Tuesday-December-19-2017   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table EMPLOYEE
--------------------------------------------------------

  CREATE TABLE "ERS"."EMPLOYEE" 
   (	"EMPLOYEEID" NUMBER(*,0), 
	"USERNAME" VARCHAR2(40 BYTE), 
	"PASS" VARCHAR2(40 BYTE), 
	"FIRSTNAME" VARCHAR2(40 BYTE), 
	"LASTNAME" VARCHAR2(40 BYTE), 
	"EMPLOYEETYPE" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into ERS.EMPLOYEE
SET DEFINE OFF;
Insert into ERS.EMPLOYEE (EMPLOYEEID,USERNAME,PASS,FIRSTNAME,LASTNAME,EMPLOYEETYPE) values (3,'aGirl','1234','A','Girl','employee');
Insert into ERS.EMPLOYEE (EMPLOYEEID,USERNAME,PASS,FIRSTNAME,LASTNAME,EMPLOYEETYPE) values (4,'aGuy','1234','A','Guy','employee');
Insert into ERS.EMPLOYEE (EMPLOYEEID,USERNAME,PASS,FIRSTNAME,LASTNAME,EMPLOYEETYPE) values (1,'aSwan','aSon','Alex','Swanson','employee');
Insert into ERS.EMPLOYEE (EMPLOYEEID,USERNAME,PASS,FIRSTNAME,LASTNAME,EMPLOYEETYPE) values (2,'meh','rab','Mehrab','Rahman','manager');
--------------------------------------------------------
--  DDL for Index PK_EMPLOYEEID
--------------------------------------------------------

  CREATE UNIQUE INDEX "ERS"."PK_EMPLOYEEID" ON "ERS"."EMPLOYEE" ("EMPLOYEEID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Trigger TRG_EMPLOYEEID
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "ERS"."TRG_EMPLOYEEID" 
  BEFORE INSERT ON EMPLOYEE
  FOR EACH ROW
BEGIN
  :new.EMPLOYEEID := employee_id_seq.nextval;
END;

CREATE OR REPLACE TRIGGER TRG_REIMID
  BEFORE INSERT ON REIMBURSEMENT
  FOR EACH ROW
BEGIN
  :new.REIMBURSEMENTEID := reim_id_seq.nextval;
END;

/
ALTER TRIGGER "ERS"."TRG_EMPLOYEEID" ENABLE;
--------------------------------------------------------
--  Constraints for Table EMPLOYEE
--------------------------------------------------------

  ALTER TABLE "ERS"."EMPLOYEE" ADD CONSTRAINT "PK_EMPLOYEEID" PRIMARY KEY ("EMPLOYEEID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "ERS"."EMPLOYEE" MODIFY ("EMPLOYEEID" NOT NULL ENABLE);
