package com.pfonseca.solver.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.drools.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

@PlanningSolution
public class CloudBalance {
	
	private List<Computer> computers;
	private List<Process> processes;
	
	private HardSoftScore score;

	@ValueRangeProvider(id = "computerRange")
    @ProblemFactCollectionProperty
	public List<Computer> getComputers() {
		
		if(computers == null)
			computers = new ArrayList<Computer>();
		
		return computers;
	}

	public void setComputers(List<Computer> computers) {
		this.computers = computers;
	}

	@PlanningEntityCollectionProperty
	public List<Process> getProcesses() {
		
		if(processes == null)
			processes = new ArrayList<Process>();
		
		return processes;
	}

	public void setProcesses(List<Process> processes) {
		this.processes = processes;
	}

	@PlanningScore
	public HardSoftScore getScore() {
		return score;
	}

	public void setScore(HardSoftScore score) {
		this.score = score;
	}

	public List<Process> getProcessesByComputer(Computer computer) {
		return processes.stream().filter(process -> process.getComputer().equals(computer)).collect(Collectors.toList());
	}
	
	
	
}
