package com.dto;

// DTO = Data Transfer Object
// VO = Value Object

// db �� �ִ�  data �� ����
// db�� �÷��� ���� �̸����� �ʵ带 �����.
public class DTO {
	// TABLE = KH ���� - MYTEST
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
