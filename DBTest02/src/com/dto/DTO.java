package com.dto;

// DTO = Data Transfer Object
// VO = Value Object

// db 에 있는  data 를 전달
// db의 컬럼과 같은 이름으로 필드를 만든다.
public class DTO {
	// TABLE = KH 계정 - MYTEST
	/*
	 * NO NUMBER PRIMARY KEY,
	 * NAME VARCHAR2(100), 
	 * NICKNAME VARCHAR2(200)
	 */

	private int NO;
	private String NAME;
	private String NICKNAME;

	public DTO() {
		super();
	}

	public DTO(int nO, String nAME, String nICKNAME) {
		super();
		NO = nO;
		NAME = nAME;
		NICKNAME = nICKNAME;
	}

	public void setNO(int NO) {
		this.NO = NO;
	}

	public int getNO() {
		return NO;
	}

	public void setNAME(String NAME) {
		this.NAME = NAME;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNICKNAME(String NICKNAME) {
		this.NICKNAME = NICKNAME;
	}

	public String getNICKNAME() {
		return NICKNAME;
	}

	@Override
	public String toString() {
		return " [NO=" + NO + ", NAME=" + NAME + ", NICKNAME=" + NICKNAME + "]";
	}
}
