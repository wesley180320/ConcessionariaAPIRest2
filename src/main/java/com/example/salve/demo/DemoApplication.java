package com.example.salve.demo;

import com.example.salve.demo.Domain.Carro;
import com.example.salve.demo.Domain.Cliente;
import com.example.salve.demo.Domain.Endereco;
import com.example.salve.demo.Domain.Funcionario;
import com.example.salve.demo.Repository.CarroRepository;
import com.example.salve.demo.Repository.ClienteRepository;
import com.example.salve.demo.Repository.EnderecoRepository;
import com.example.salve.demo.Repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@Autowired
	private CarroRepository carroRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Funcionario funcionario = new Funcionario(null,"vanderson","0840273094");

		Cliente cliente1 = new Cliente(null,"wesley","679811345675");
		Cliente cliente2 = new Cliente(null,"joao","679811345675");
		Carro c1 = new Carro(null,"fiat","verde",sdf.parse("13/10/2021"),20000.00,cliente1);
		Carro c2 = new Carro(null,"fiat","verde",sdf.parse("13/10/2021"),20000.00,cliente2);
		Endereco endereco1 = new Endereco(null,"isaque pereira da silva","343425","125",cliente1,funcionario);
		Endereco endereco2 = new Endereco(null,"isaque pereira da silva","343425","125",cliente2,funcionario);

		cliente1.getCarros().add(c1);
		cliente2.getCarros().add(c1);

		cliente1.getEnderecos().add(endereco1);
		cliente2.getEnderecos().add(endereco2);

		funcionario.getEnderecos().add(endereco1);

		funcionarioRepository.save(funcionario);
		clienteRepository.saveAll(Arrays.asList(cliente1,cliente2));
		carroRepository.saveAll(Arrays.asList(c1,c2));
		enderecoRepository.saveAll(Arrays.asList(endereco1,endereco2));

	}
}
