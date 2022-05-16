package it.polito.tdp.borders.model;

public class Country {
	
	private String StateAbb;
	private int CCode;
	private String StateName;
	private int degree = 0;
	
	
	public Country(String stateAbb, int cCode, String stateName) {
		super();
		StateAbb = stateAbb;
		CCode = cCode;
		StateName = stateName;
	}


	public String getStateAbb() {
		return StateAbb;
	}


	public void setStateAbb(String stateAbb) {
		StateAbb = stateAbb;
	}


	public int getCCode() {
		return CCode;
	}


	public void setCCode(int cCode) {
		CCode = cCode;
	}


	public String getStateName() {
		return StateName;
	}


	public void setStateNme(String stateNme) {
		StateName = stateNme;
	}

	

	public int getDegree() {
		return degree;
	}


	public void setDegree(int degree) {
		this.degree = degree;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + CCode;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		if (CCode != other.CCode)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return StateName + "\n";
	}

	public String getNomeDegree() {
		return StateName + ", " + degree + "\n";
	}
}
	

