package br.com.letsCode;

import br.com.letsCode.model.Pessoa;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.Year;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
public class StreamsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StreamsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{

		String HOME_PATH = System.getProperty("user.dir");
		System.out.println(HOME_PATH);
		String participantes = HOME_PATH.concat("/files/participantes.txt");

		Path path = Paths.get(participantes);
		List<String> lines = Files.readAllLines(path);
		lines.forEach(line -> {
			String[] campos = line.split(",");
			String nome = campos[0];
			String zona = campos[1];
			LocalDate dataNascimento = LocalDate.parse(campos[2]);

			Pessoa pessoa = new Pessoa(nome, zona, dataNascimento);
			System.out.println(pessoa.getNome());
		});
	}

}
