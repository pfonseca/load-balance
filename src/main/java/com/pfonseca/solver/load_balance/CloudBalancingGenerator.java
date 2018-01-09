package com.pfonseca.solver.load_balance;

import org.apache.commons.math3.random.RandomDataGenerator;

import com.pfonseca.solver.domain.CloudBalance;
import com.pfonseca.solver.domain.Computer;
import com.pfonseca.solver.domain.Process;

public class CloudBalancingGenerator {

	public CloudBalance createCloudBalance(int computers, int processes) {
		
		CloudBalance cloudBalance = new CloudBalance();
		
		
		for(int i = 0 ; i<computers ; i++) {
			cloudBalance.getComputers().add(getComputer(i));
		}
		
		for (int i = 0; i < processes; i++) {
			cloudBalance.getProcesses().add(getProcess(i));
		}
		
		return cloudBalance;
	}

	private Process getProcess(int i) {
		Process process = new Process();
		
		process.setRequiredCpuPower(new RandomDataGenerator().nextInt(1, 3));
		process.setRequiredMemory(new RandomDataGenerator().nextInt(1, 3));
		process.setRequiredNetworkBandwidth(new RandomDataGenerator().nextInt(50, 500));
		
		process.setLabel(String.valueOf(i));
		
		return process;
	}

	private Computer getComputer(int i) {
		Computer computer = new Computer();
		
		computer.setCpuPower(8);
		computer.setMemory(8);
		computer.setNetworkBandwidth(1000);
		
		computer.setLabel(String.valueOf(i));
		
		computer.setCost(1);
		
		return computer;
	}

}
