package ug.dbelgrau.main;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ug.dbelgrau.main.service.GpuService;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner setUpApp(GpuService gpuService) {
//		return (args) -> {
//			gpuService.setUpApp();
//		};
//	}

}
