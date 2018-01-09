package com.pfonseca.solver.load_balance;

import java.time.LocalDateTime;

import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;

import com.pfonseca.solver.domain.CloudBalance;
import com.pfonseca.solver.domain.Computer;
import com.pfonseca.solver.domain.Process;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {

		
		
		// Build the Solver
		SolverFactory<CloudBalance> solverFactory = SolverFactory
				.createFromXmlResource("cloudBalancingSolverConfig.xml");
		Solver<CloudBalance> solver = solverFactory.buildSolver();

		// Load a problem with 400 computers and 1200 processes
		CloudBalance unsolvedCloudBalance = new CloudBalancingGenerator().createCloudBalance(400, 1200);

		LocalDateTime beginingTime = LocalDateTime.now();
		
		// Solve the problem
		CloudBalance solvedCloudBalance = solver.solve(unsolvedCloudBalance);
		
		
		System.out.println("Initial Score: " + solvedCloudBalance.getScore().getInitScore());
		System.out.println("Hard Score: " + solvedCloudBalance.getScore().getHardScore());
		System.out.println("Soft Score: " + solvedCloudBalance.getScore().getSoftScore());

		// Display the result
		System.out.println(
				"\nSolved cloudBalance with 400 computers and 1200 processes:\n" + toDisplayString(solvedCloudBalance));
		
		System.out.println("Initial time: "+ beginingTime);
		System.out.println("End time: "+ LocalDateTime.now());

	}

	public static String toDisplayString(CloudBalance cloudBalance) {
		StringBuilder displayString = new StringBuilder();
//		for (Process process : cloudBalance.getProcesses()) {
//			Computer computer = process.getComputer();
//			displayString.append("  ").append(process.getLabel()).append(" -> ")
//					.append(computer == null ? null : computer.getLabel()).append("\n");
//		}
		
		for(Computer computer : cloudBalance.getComputers()) {
			displayString.append("\n").append("Computer: ").append(computer.getLabel());
			
			for(Process process : cloudBalance.getProcessesByComputer(computer)) {
				displayString.append("\n\t").append("Process: ").append(process.getLabel())
					.append("  cpu: ").append(process.getRequiredCpuPower())
					.append("  memory: ").append(process.getRequiredMemory())
					.append("  networkBandwidth: ").append(process.getRequiredNetworkBandwidth());
			}
			
		}
		
		
		
		return displayString.toString();
	}

}
