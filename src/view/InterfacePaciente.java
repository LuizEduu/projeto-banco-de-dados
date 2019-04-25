package view;

import java.awt.GridLayout;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controller.ControllerPaciente;

public class InterfacePaciente {
	ControllerPaciente controllerPaciente = new ControllerPaciente();

	public void cadastrarpaciente() {
		JPanel cadastrarPaciente = new JPanel();
		cadastrarPaciente.setLayout(new GridLayout(10, 2, -5, 3));
		JFrame janelaCadastrarPaciente = new JFrame("Cadastrar");
		janelaCadastrarPaciente.setSize(560, 410);
		janelaCadastrarPaciente.setLocationRelativeTo(null);
		janelaCadastrarPaciente.setVisible(true);
		janelaCadastrarPaciente.add(cadastrarPaciente);

		JLabel lblNome = new JLabel("Nome: ");
		JTextField txtNome = new JTextField(20);

		JComboBox<String> ComboSexo = new JComboBox<String>();
		ComboSexo.addItem("M");
		ComboSexo.addItem("F");
		ComboSexo.setSelectedItem(null);
		JLabel lblSexo = new JLabel("Sexo: ");
		JLabel lblemail = new JLabel("Email: ");
		JTextField txtemail = new JTextField(100);
		JLabel lbltelefone = new JLabel("Telefone: ");

		MaskFormatter masktelefone = null;
		try {
			masktelefone = new MaskFormatter("(##)#####-####");
		} catch (Exception e) {
			e.printStackTrace();
		}

		JFormattedTextField txttelefone = new JFormattedTextField(masktelefone);
		JLabel lblrua = new JLabel("Rua: ");
		JTextField txtrua = new JTextField(100);
		JLabel lblnumero = new JLabel("Numero: ");
		JTextField txtnumero = new JTextField(100);
		JLabel lblbairro = new JLabel("Bairro: ");
		JTextField txtbairro = new JTextField(100);
		JLabel lblcidade = new JLabel("Cidade: ");
		JTextField txtcidade = new JTextField(100);

		JLabel lbldatanascimento = new JLabel("Data Nascimento: ");

		MaskFormatter masknascimento = null;
		try {
			masknascimento = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		JFormattedTextField txtnascimento = new JFormattedTextField(masknascimento);

		JButton btnCadastrar = new JButton("Cadastrar");
		JButton btnFecharcadastro = new JButton("Fechar Cadastro");

		cadastrarPaciente.add(lblNome);
		cadastrarPaciente.add(txtNome);
		cadastrarPaciente.add(lblSexo);
		cadastrarPaciente.add(ComboSexo);
		cadastrarPaciente.add(lblemail);
		cadastrarPaciente.add(txtemail);
		cadastrarPaciente.add(lbltelefone);
		cadastrarPaciente.add(txttelefone);
		cadastrarPaciente.add(lblrua);
		cadastrarPaciente.add(txtrua);
		cadastrarPaciente.add(lblnumero);
		cadastrarPaciente.add(txtnumero);
		cadastrarPaciente.add(lblbairro);
		cadastrarPaciente.add(txtbairro);
		cadastrarPaciente.add(lblcidade);
		cadastrarPaciente.add(txtcidade);
		cadastrarPaciente.add(lbldatanascimento);
		cadastrarPaciente.add(txtnascimento);
		cadastrarPaciente.add(btnCadastrar);
		cadastrarPaciente.add(btnFecharcadastro);

		btnCadastrar.addActionListener((ActionEvent) -> {
			controllerPaciente.cadastrarPaciente(txtNome.getText(), (String) ComboSexo.getSelectedItem(),
					txtemail.getText(), txttelefone.getText(), txtrua.getText(), txtnumero.getText(),
					txtbairro.getText(), txtcidade.getText(), txtnascimento.getText());

			txtNome.setText(null);
			ComboSexo.setSelectedItem(null);
			txtemail.setText(null);
			txttelefone.setText(null);
			txtrua.setText(null);
			txtnumero.setText(null);
			txtbairro.setText(null);
			txtcidade.setText(null);
			txtnascimento.setText(null);
		});

		btnFecharcadastro.addActionListener((ActionEvent) -> {
			janelaCadastrarPaciente.dispose();
		});
	}

	/*
	public void editarpaciente() {
		JPanel editarPaciente = new JPanel();
		editarPaciente.setLayout(new GridLayout(12, 2, -1, 3));
		JFrame janelaEditarPaciente = new JFrame("Editar");
		janelaEditarPaciente.setSize(560, 410);
		janelaEditarPaciente.setLocationRelativeTo(null);
		janelaEditarPaciente.setVisible(true);
		janelaEditarPaciente.add(editarPaciente);

		JLabel lblid = new JLabel("ID: ");
		JTextField txtid = new JTextField(100);
		JButton botaobuscar = new JButton("Buscar");

		JLabel lblNome = new JLabel("Nome: ");
		JTextField txtNome = new JTextField(100);
		JComboBox<String> ComboSexo = new JComboBox<String>();
		ComboSexo.addItem("M");
		ComboSexo.addItem("F");
		ComboSexo.setSelectedItem(null);
		JLabel lblSexo = new JLabel("Sexo: ");
		JLabel lblemail = new JLabel("Email: ");
		JTextField txtemail = new JTextField(100);
		JLabel lbltelefone = new JLabel("Telefone: ");

		MaskFormatter masktelefone = null;
		try {
			masktelefone = new MaskFormatter("(##)#####-####");
		} catch (Exception e) {
			e.printStackTrace();
		}

		JFormattedTextField txttelefone = new JFormattedTextField(masktelefone);
		JLabel lblrua = new JLabel("Rua: ");
		JTextField txtrua = new JTextField();
		JLabel lblnumero = new JLabel("Numero: ");
		JTextField txtnumero = new JTextField(100);
		JLabel lblbairro = new JLabel("Bairro: ");
		JTextField txtbairro = new JTextField(100);
		JLabel lblcidade = new JLabel("Cidade: ");
		JTextField txtcidade = new JTextField(100);
		JLabel lbldatanascimento = new JLabel("Data Nascimento: ");
		MaskFormatter masknascimento = null;

		try {
			masknascimento = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		JFormattedTextField txtnascimento = new JFormattedTextField(masknascimento);
		JButton editar = new JButton("Editar");
		JButton fecharRemocao = new JButton("Fechar Tela");

		editarPaciente.add(lblid);
		editarPaciente.add(txtid);
		editarPaciente.add(botaobuscar);
		editarPaciente.add(new JLabel());
		editarPaciente.add(lblNome);
		editarPaciente.add(txtNome);
		editarPaciente.add(lblSexo);
		editarPaciente.add(ComboSexo);
		editarPaciente.add(lblemail);
		editarPaciente.add(txtemail);
		editarPaciente.add(lbltelefone);
		editarPaciente.add(txttelefone);
		editarPaciente.add(lblrua);
		editarPaciente.add(txtrua);
		editarPaciente.add(lblnumero);
		editarPaciente.add(txtnumero);
		editarPaciente.add(lblbairro);
		editarPaciente.add(txtbairro);
		editarPaciente.add(lblcidade);
		editarPaciente.add(txtcidade);
		editarPaciente.add(lbldatanascimento);
		editarPaciente.add(txtnascimento);
		editarPaciente.add(editar);
		editarPaciente.add(fecharRemocao);

		botaobuscar.addActionListener(ActionEvent -> {
			Paciente paciente = new Paciente();
			paciente = controllerPaciente.buscarPaciente(idtemp);
			txtNome.setText(paciente.getNome());
			ComboSexo.setSelectedItem(paciente.getSexo());
			txtemail.setText(paciente.getEmail());
			txttelefone.setText(paciente.getTelefone());
			txtrua.setText(paciente.getRua());
			txtnumero.setText(paciente.getNumero());
			txtbairro.setText(paciente.getBairro());
			txtcidade.setText(paciente.getCidade());
			txtnascimento.setText(paciente.getNascimento());

		});

		editar.addActionListener(ActionEvent -> {
			int idtemp = Integer.parseInt(txtid.getText());
			controllerPaciente.atualizarpaciente(idtemp, txtNome.getText(), (String) ComboSexo.getSelectedItem(),
					txtemail.getText(), txttelefone.getText(), txtrua.getText(), txtnumero.getText(),
					txtbairro.getText(), txtcidade.getText(), txtnascimento.getText());
		});

		fecharRemocao.addActionListener((ActionEvent) -> {
			janelaEditarPaciente.dispose();
		});
	}

	public void removerpaciente() {
		JPanel editarPaciente = new JPanel();
		editarPaciente.setLayout(new GridLayout(12, 2, -1, 3));
		JFrame janelaRemoverPaciente = new JFrame("Remover");
		janelaRemoverPaciente.setSize(560, 410);
		janelaRemoverPaciente.setLocationRelativeTo(null);
		janelaRemoverPaciente.setVisible(true);
		janelaRemoverPaciente.add(editarPaciente);

		JLabel lblid = new JLabel("ID: ");
		JTextField txtid = new JTextField(100);
		JButton botaobuscar = new JButton("Buscar");

		JLabel lblNome = new JLabel("Nome: ");
		JTextField txtNome = new JTextField(20);
		JComboBox<String> ComboSexo = new JComboBox<String>();
		ComboSexo.addItem("M");
		ComboSexo.addItem("F");
		ComboSexo.setSelectedItem(null);
		JLabel lblSexo = new JLabel("Sexo: ");
		JLabel lblemail = new JLabel("Email: ");
		JTextField txtemail = new JTextField(100);
		JLabel lbltelefone = new JLabel("Telefone: ");

		MaskFormatter masktelefone = null;
		try {
			masktelefone = new MaskFormatter("(##)#####-####");
		} catch (Exception e) {
			e.printStackTrace();
		}

		JFormattedTextField txttelefone = new JFormattedTextField(masktelefone);
		JLabel lblrua = new JLabel("Rua: ");
		JTextField txtrua = new JTextField(100);
		JLabel lblnumero = new JLabel("Numero: ");
		JTextField txtnumero = new JTextField(100);
		JLabel lblbairro = new JLabel("Bairro: ");
		JTextField txtbairro = new JTextField(100);
		JLabel lblcidade = new JLabel("Cidade: ");
		JTextField txtcidade = new JTextField(100);

		JLabel lbldatanascimento = new JLabel("Data Nascimento: ");

		MaskFormatter masknascimento = null;
		try {
			masknascimento = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		JFormattedTextField txtnascimento = new JFormattedTextField(masknascimento);

		JButton remover = new JButton("Remover");
		JButton fechartela = new JButton("Fechar Tela");

		editarPaciente.add(lblid);
		editarPaciente.add(txtid);
		editarPaciente.add(botaobuscar);
		editarPaciente.add(new JLabel());
		editarPaciente.add(lblNome);
		editarPaciente.add(txtNome);
		editarPaciente.add(lblSexo);
		editarPaciente.add(ComboSexo);
		editarPaciente.add(lblemail);
		editarPaciente.add(txtemail);
		editarPaciente.add(lbltelefone);
		editarPaciente.add(txttelefone);
		editarPaciente.add(lblrua);
		editarPaciente.add(txtrua);
		editarPaciente.add(lblnumero);
		editarPaciente.add(txtnumero);
		editarPaciente.add(lblbairro);
		editarPaciente.add(txtbairro);
		editarPaciente.add(lblcidade);
		editarPaciente.add(txtcidade);
		editarPaciente.add(lbldatanascimento);
		editarPaciente.add(txtnascimento);
		editarPaciente.add(remover);
		editarPaciente.add(fechartela);

		txtNome.setEditable(false);
		ComboSexo.setEnabled(false);
		txtemail.setEditable(false);
		txttelefone.setEditable(false);
		txtrua.setEditable(false);
		txtnumero.setEditable(false);
		txtbairro.setEditable(false);
		txtcidade.setEditable(false);
		txtnascimento.setEditable(false);

		botaobuscar.addActionListener((ActionEvent) -> {
			Paciente paciente = new Paciente();
			int idtemp = Integer.parseInt(txtid.getText());
			paciente = controllerPaciente.buscarPaciente(idtemp);
			txtNome.setText(paciente.getNome());
			ComboSexo.setSelectedItem(paciente.getSexo());
			txtemail.setText(paciente.getEmail());
			txttelefone.setText(paciente.getTelefone());
			txtrua.setText(paciente.getRua());
			txtnumero.setText(paciente.getNumero());
			txtbairro.setText(paciente.getBairro());
			txtcidade.setText(paciente.getCidade());
			txtnascimento.setText(paciente.getNascimento());
			txtNome.setEditable(false);
			ComboSexo.setEnabled(false);
			txtemail.setEditable(false);
			txttelefone.setEditable(false);
			txtrua.setEditable(false);
			txtnumero.setEditable(false);
			txtbairro.setEditable(false);
			txtcidade.setEditable(false);
			txtnascimento.setEditable(false);

		});

		remover.addActionListener((ActionEvent) -> {
			int idtemp = Integer.parseInt(txtid.getText());
			controllerPaciente.removerpaciente(idtemp, txtNome.getText(), (String) ComboSexo.getSelectedItem(),
					txtemail.getText(), txttelefone.getText(), txtrua.getText(), txtnumero.getText(),
					txtbairro.getText(), txtcidade.getText(), txtnascimento.getText());
		});

		fechartela.addActionListener((ActionEvent) -> {
			janelaRemoverPaciente.dispose();
		});
	}

	public void listarpaciente() {

		JTextField txtId = new JTextField(100);
		JTextField txtNome = new JTextField(100);
		JTextField txtsexo = new JTextField(100);
		JTextField txtEmail = new JTextField(100);
		JTextField txtTelefone = new JTextField(100);
		JTextField txtRua = new JTextField(100);
		JTextField txtNumero = new JTextField(100);
		JTextField txtBairro = new JTextField(100);
		JTextField txtCidade = new JTextField(100);
		JTextField txtDataNascimento = new JTextField(100);

		DefaultTableModel tabelaPaciente = new DefaultTableModel(null, new String[] { "ID", "Nome", "Sexo", "Email",
				"Telefone", "Rua", "Numero", "Bairro", "Cidade", "Data Nascimento" });

		String[] elementosvazio = { "Vazio", "Vazio", "Vazio", "Vazio", "Vazio", "Vazio", "Vazio", "Vazio", "Vazio",
				"Vazio" };

		ArrayList<Paciente> list = controllerPaciente.listarpaciente();

		if(list !=null) {
			for (Paciente paciente : list) {
				String idtemp = Integer.toString(paciente.getId());
				txtId.setText(idtemp);
				txtNome.setText(paciente.getNome());
				txtsexo.setText(paciente.getSexo());
				txtEmail.setText(paciente.getEmail());
				txtTelefone.setText(paciente.getTelefone());
				txtRua.setText(paciente.getRua());
				txtNumero.setText(paciente.getNumero());
				txtBairro.setText(paciente.getBairro());
				txtCidade.setText(paciente.getCidade());
				txtDataNascimento.setText(paciente.getNascimento());

				tabelaPaciente.addRow(new String[] { txtId.getText(), txtNome.getText(), txtsexo.getText(),
						txtEmail.getText(), txtTelefone.getText(), txtRua.getText(), txtNumero.getText(),
						txtBairro.getText(), txtCidade.getText(), txtDataNascimento.getText() });
			}
		}else {
			tabelaPaciente.addRow(elementosvazio);
		}

		JPanel listarPaciente = new JPanel();
		listarPaciente.setLayout(new FlowLayout());
		JTable tabela = new JTable(tabelaPaciente);

		tabela.getColumnModel().getColumn(0).setPreferredWidth(5);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(140);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(10);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(5).setPreferredWidth(120);
		tabela.getColumnModel().getColumn(6).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(7).setPreferredWidth(35);
		tabela.setPreferredScrollableViewportSize(new Dimension(1920, 1080));

		tabela.setFillsViewportHeight(true);
		JScrollPane scroll = new JScrollPane(tabela);
		tabela.getTableHeader().setReorderingAllowed(false);
		JFrame jlistarPaciente = new JFrame("Listagem Medicos");
		jlistarPaciente.add(listarPaciente);
		listarPaciente.add(scroll);
		jlistarPaciente.setVisible(true);
		jlistarPaciente.setExtendedState(JFrame.MAXIMIZED_BOTH);

	}
	
	*/

}
