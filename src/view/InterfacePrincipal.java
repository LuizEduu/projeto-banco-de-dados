package view;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import view.InterfacePaciente;

public class InterfacePrincipal {
	InterfacePaciente interfacePaciente = new InterfacePaciente();

	public void janelaprincipal() {
		JMenuBar jBarraMenu = new JMenuBar();
		JMenu menuPaciente = new JMenu("Paciente");
		jBarraMenu.add(menuPaciente);
		JMenuItem cadastrarpaciente = new JMenuItem("Cadastrar");
		JMenuItem editarpaciente = new JMenuItem("Editar");
		JMenuItem removerpaciente = new JMenuItem("Remover");
		JMenuItem listarpaciente = new JMenuItem("Listar");
		menuPaciente.add(cadastrarpaciente);
		menuPaciente.addSeparator();
		menuPaciente.add(editarpaciente);
		menuPaciente.addSeparator();
		menuPaciente.add(removerpaciente);
		menuPaciente.addSeparator();
		menuPaciente.add(listarpaciente);

		JMenu menumedico = new JMenu("Medico");
		jBarraMenu.add(menumedico);
		JMenuItem cadastrarMedico = new JMenuItem("Cadastrar");
		JMenuItem editarMedico = new JMenuItem("Editar");
		JMenuItem removerMedico = new JMenuItem("Remover");
		JMenuItem listarMedico = new JMenuItem("Listar");
		menumedico.add(cadastrarMedico);
		menumedico.addSeparator();
		menumedico.add(editarMedico);
		menumedico.addSeparator();
		menumedico.add(removerMedico);
		menumedico.addSeparator();
		menumedico.add(listarMedico);

		JMenu menuHospital = new JMenu("Hospital");
		jBarraMenu.add(menuHospital);
		JMenuItem cadastrarHospital = new JMenuItem("Cadastrar");
		JMenuItem editarHospital = new JMenuItem("Editar");
		JMenuItem removerHospital = new JMenuItem("Remover");
		JMenuItem listarHospital = new JMenuItem("Listar");
		menuHospital.add(cadastrarHospital);
		menuHospital.addSeparator();
		menuHospital.add(editarHospital);
		menuHospital.addSeparator();
		menuHospital.add(removerHospital);
		menuHospital.addSeparator();
		menuHospital.add(listarHospital);

		JMenu MenuConsulta = new JMenu("Consulta");
		jBarraMenu.add(MenuConsulta);
		JMenuItem Agendar = new JMenuItem("Agendar");
		JMenuItem Editar = new JMenuItem("Editar");
		JMenuItem Cancelar = new JMenuItem("Cancelar");
		JMenuItem Listar = new JMenuItem("Listar");
		MenuConsulta.add(Agendar);
		MenuConsulta.addSeparator();
		MenuConsulta.add(Editar);
		MenuConsulta.addSeparator();
		MenuConsulta.add(Cancelar);
		MenuConsulta.addSeparator();
		MenuConsulta.add(Listar);

		// Configuração Janela Principal
		JFrame jPrincipal = new JFrame("Clinica");
		jPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jPrincipal.setSize(390, 320);
		jPrincipal.setLocationRelativeTo(null);
		jPrincipal.setVisible(true);
		jPrincipal.setJMenuBar(jBarraMenu);

		cadastrarPaciente(cadastrarpaciente);
		
		  editarPaciente(editarpaciente);
		  removerPaciente(removerpaciente);
		  listarPaciente(listarpaciente);
		 
		 
	}

	private void cadastrarPaciente(JMenuItem cadastrarpaciente) {
		cadastrarpaciente.addActionListener(ActionEvent -> {
			interfacePaciente.cadastrarpaciente();
		});
	}

	
	 private void editarPaciente(JMenuItem editarpaciente) {
	 editarpaciente.addActionListener(ActionEvent -> {
	 interfacePaciente.editarpaciente(); }); }
	
	 private void removerPaciente(JMenuItem removerpaciente) {
	 removerpaciente.addActionListener(ActionEvent -> {
	 interfacePaciente.removerpaciente(); }); }
	 
	 private void listarPaciente(JMenuItem listarpaciente) {
	 listarpaciente.addActionListener(ActionEvent -> {
	 interfacePaciente.listarpaciente(); }); }
	
}
