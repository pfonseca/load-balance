package com.pfonseca.solver.domain;

public class Computer {

	private String label;
	
	private int cpuPower;
	private int memory;
	private int networkBandwidth;
	
	private int cost;

	public int getCpuPower() {
		return cpuPower;
	}

	public void setCpuPower(int cpuPower) {
		this.cpuPower = cpuPower;
	}

	public int getMemory() {
		return memory;
	}

	public void setMemory(int memory) {
		this.memory = memory;
	}

	public int getNetworkBandwidth() {
		return networkBandwidth;
	}

	public void setNetworkBandwidth(int networkBandwidth) {
		this.networkBandwidth = networkBandwidth;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((label == null) ? 0 : label.hashCode());
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
		Computer other = (Computer) obj;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		return true;
	}
	
	
}
