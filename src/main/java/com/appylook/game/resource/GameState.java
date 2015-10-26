package com.appylook.game.resource;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GameState implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1737963166518737874L;
	Integer m;
	Integer n;
	String[][] array;
	public Integer getM() {
		return m;
	}
	public void setM(int m) {
		this.m = m;
	}
	public Integer getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public String[][] getArray() {
		return array;
	}
	public void setArray(String[][] array) {
		this.array = array;
	}

}
