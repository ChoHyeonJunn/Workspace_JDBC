DROP TABLE TB_MEMBER;

CREATE TABLE TB_MEMBER(
--번호, 이름, 나이, 성별, 주소, 직업, 전화번호, 이메일
	NO NUMBER PRIMARY KEY,
	NAME VARCHAR2(100) NOT NULL,
	AGE NUMBER NOT NULL,
	GENDER VARCHAR2(2) CHECK(GENDER IN('M','F')) NOT NULL,
	
	LOCATION VARCHAR2(500),
	JOB VARCHAR2(300),
	TEL VARCHAR2(20),
	EMAIL VARCHAR2(100)
);
SELECT * FROM TB_MEMBER;

