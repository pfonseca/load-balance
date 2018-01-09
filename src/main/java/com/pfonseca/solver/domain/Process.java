package com.pfonseca.solver.domain;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@PlanningEntity
public class Process {
	
	private String label;

	private int requiredCpuPower;
	private int requiredMemory;
	private int requiredNetworkBandwidth;
	
	private Computer computer;

	public int getRequiredCpuPower() {
		return requiredCpuPower;
	}

	public void setRequiredCpuPower(int requiredCpuPower) {
		this.requiredCpuPower = requiredCpuPower;
	}

	public int getRequiredMemory() {
		return requiredMemory;
	}

	public void setRequiredMemory(int requiredMemory) {
		this.requiredMemory = requiredMemory;
	}

	public int getRequiredNetworkBandwidth() {
		return requiredNetworkBandwidth;
	}

	public void setRequiredNetworkBandwidth(int requiredNetworkBandwidth) {
		this.requiredNetworkBandwidth = requiredNetworkBandwidth;
	}

	@PlanningVariable(valueRangeProviderRefs = {"computerRange"})
	public Computer getComputer() {
		return computer;
	}

	public void setComputer(Computer computer) {
		
//		if(this.computer != null )
//			System.out.println("Change computer. Old: "+this.computer.getLabel()+ "   new: "+computer.getLabel());
		
		this.computer = computer;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	
}
