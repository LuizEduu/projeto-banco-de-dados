package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import controller.ControllerPaciente;
import model.Paciente;

public class InterfacePaciente {
	ControllerPaciente controllerPaciente = new ControllerPaciente();

	public void cadastrarpaciente() {
		JPanel cadastrarPaciente = new JPanel();
		cadastrarPaciente.setLayout(new GridLayout(11, 2, -5, 3));
		JFrame janelaCadastrarPaciente = new JFrame("Cadastrar");
		janelaCadastrarPaciente.setSize(560, 410);
		janelaCadastrarPaciente.setLocationRelativeTo(null);
		janelaCadastrarPaciente.setVisible(true);
		janelaCadastrarPaciente.add(cadastrarPaciente);

		JLabel lblNome = new JLabel("Nome: ");
		JTextField txtNome = new JTextField(20);

		MaskFormatter maskcpf = null;
		try {
			maskcpf = new MaskFormatter("###.###.###-##");
		} catch (Exception e) {
			e.printStackTrace();
		}
		JLabel lblcpf = new JLabel("CPF: ");
		JFormattedTextField txtcpf = new JFormattedTextField(maskcpf);
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
		cadastrarPaciente.add(lblcpf);
		cadastrarPaciente.add(txtcpf);
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
			controllerPaciente.cadastrarPaciente(txtNome.getText(), txtcpf.getText(),
					(String) ComboSexo.getSelectedItem(), txtemail.getText(), txttelefone.getText(), txtrua.getText(),
					txtnumero.getText(), txtbairro.getText(), txtcidade.getText(), txtnascimento.getText());

			txtNome.setText(null);
			txtcpf.setText(null);
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

	public void editarpaciente() {
		JPanel editarPaciente = new JPanel();
		editarPaciente.setLayout(new GridLayout(13, 2, -1, 3));
		JFrame janelaEditarPaciente = new JFrame("Editar");
		janelaEditarPaciente.setSize(560, 480);
		janelaEditarPaciente.setLocationRelativeTo(null);
		janelaEditarPaciente.setVisible(true);
		janelaEditarPaciente.add(editarPaciente);

		JLabel lblid = new JLabel("ID: ");
		JTextField txtid = new JTextField(100);
		JButton botaobuscar = new JButton("Buscar");

		JLabel lblNome = new JLabel("Nome: ");
		JTextField txtNome = new JTextField(100);

		MaskFormatter maskcpf = null;
		try {
			maskcpf = new MaskFormatter("###.###.###-##");
		} catch (Exception e) {
			e.printStackTrace();
		}
		JLabel lblcpf = new JLabel("CPF");
		JFormattedTextField txtcpf = new JFormattedTextField(maskcpf);
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
		editarPaciente.add(lblcpf);
		editarPaciente.add(txtcpf);
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
			Long idtemp = (long) Integer.parseInt(txtid.getText());
			paciente = controllerPaciente.buscarPaciente(idtemp);

			txtNome.setText(paciente.getNome());
			txtcpf.setText(paciente.getCpf());
			ComboSexo.setSelectedItem(paciente.getSexo());
			txtemail.setText(paciente.getEmail());
			txttelefone.setText(paciente.getTelefonePaciente().getNumero());
			txtrua.setText(paciente.getEnderecoPaciente().getRua());
			txtnumero.setText(paciente.getEnderecoPaciente().getNumero());
			txtbairro.setText(paciente.getEnderecoPaciente().getBairro());
			txtcidade.setText(paciente.getEnderecoPaciente().getCidade());
			txtnascimento.setText(paciente.getNascimento());

		});

		editar.addActionListener(ActionEvent -> {
			Long idtemp = (long) Integer.parseInt(txtid.getText());
			controllerPaciente.atualizarpaciente(idtemp, txtNome.getText(), txtcpf.getText(),
					(String) ComboSexo.getSelectedItem(), txtemail.getText(), txttelefone.getText(), txtrua.getText(),
					txtnumero.getText(), txtbairro.getText(), txtcidade.getText(), txtnascimento.getText());
		});

		fecharRemocao.addActionListener((ActionEvent) -> {
			janelaEditarPaciente.dispose();
		});
	}

	public void removerpaciente() {
		JPanel editarPaciente = new JPanel();
		editarPaciente.setLayout(new GridLayout(13, 2, -1, 3));
		JFrame janelaRemoverPaciente = new JFrame("Remover");
		janelaRemoverPaciente.setSize(560, 480);
		janelaRemoverPaciente.setLocationRelativeTo(null);
		janelaRemoverPaciente.setVisible(true);
		janelaRemoverPaciente.add(editarPaciente);

		JLabel lblid = new JLabel("ID: ");
		JTextField txtid = new JTextField(100);
		JButton botaobuscar = new JButton("Buscar");

		JLabel lblNome = new JLabel("Nome: ");
		JTextField txtNome = new JTextField(20);

		MaskFormatter maskcpf = null;
		try {
			maskcpf = new MaskFormatter("###.###.###-##");
		} catch (Exception e) {
			e.printStackTrace();
		}
		JLabel lblcpf = new JLabel("CPF");
		JFormattedTextField txtcpf = new JFormattedTextField(maskcpf);
		JTextField txtsexo = new JTextField(5);
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
		editarPaciente.add(lblcpf);
		editarPaciente.add(txtcpf);
		editarPaciente.add(lblSexo);
		editarPaciente.add(txtsexo);
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

		txtNome.setBorder(null);
		txtcpf.setBorder(null);
		txtsexo.setBorder(null);
		txtemail.setBorder(null);
		txttelefone.setBorder(null);
		txtrua.setBorder(null);
		txtnumero.setBorder(null);
		txtbairro.setBorder(null);
		txtcidade.setBorder(null);
		txtnascimento.setBorder(null);

		txtNome.setEditable(false);
		txtcpf.setEditable(false);
		txtsexo.setEditable(false);
		txtemail.setEditable(false);
		txttelefone.setEditable(false);
		txtrua.setEditable(false);
		txtnumero.setEditable(false);
		txtbairro.setEditable(false);
		txtcidade.setEditable(false);
		txtnascimento.setEditable(false);
		
		txtNome.setFont(txtNome.getFont().deriveFont(14f));
		txtcpf.setFont(txtcpf.getFont().deriveFont(14f));
		txtsexo.setFont(txtsexo.getFont().deriveFont(14f));
		txtemail.setFont(txtemail.getFont().deriveFont(14f));
		txttelefone.setFont(txttelefone.getFont().deriveFont(14f));
		txtrua.setFont(txtrua.getFont().deriveFont(14f));
		txtnumero.setFont(txtnumero.getFont().deriveFont(14f));
		txtbairro.setFont(txtbairro.getFont().deriveFont(14f));
		txtcidade.setFont(txtcidade.getFont().deriveFont(14f));
		txtnascimento.setFont(txtnascimento.getFont().deriveFont(14f));

		botaobuscar.addActionListener((ActionEvent) -> {
			Paciente paciente = new Paciente();
			Long idtemp = (long) Integer.parseInt(txtid.getText());
			paciente = controllerPaciente.buscarPaciente(idtemp);
			txtNome.setText(paciente.getNome());
			txtcpf.setText(paciente.getCpf());
			txtsexo.setText(paciente.getSexo());
			txtemail.setText(paciente.getEmail());
			txttelefone.setText(paciente.getTelefonePaciente().getNumero());
			txtrua.setText(paciente.getEnderecoPaciente().getRua());
			txtnumero.setText(paciente.getEnderecoPaciente().getNumero());
			txtbairro.setText(paciente.getEnderecoPaciente().getBairro());
			txtcidade.setText(paciente.getEnderecoPaciente().getCidade());
			txtnascimento.setText(paciente.getNascimento());

		});

		remover.addActionListener((ActionEvent) -> {
			int idtemp = Integer.parseInt(txtid.getText());
			controllerPaciente.removerpaciente(idtemp);
		});

		fechartela.addActionListener((ActionEvent) -> {
			janelaRemoverPaciente.dispose();
		});
	}

	public void listarpaciente() {

		JTextField txtId = new JTextField(100);
		JTextField txtNome = new JTextField(100);
		JTextField txtcpf = new JTextField(100);
		JTextField txtsexo = new JTextField(100);
		JTextField txtEmail = new JTextField(100);
		JTextField txtTelefone = new JTextField(100);
		JTextField txtRua = new JTextField(100);
		JTextField txtNumero = new JTextField(100);
		JTextField txtBairro = new JTextField(100);
		JTextField txtCidade = new JTextField(100);
		JTextField txtDataNascimento = new JTextField(100);

		DefaultTableModel tabelaPaciente = new DefaultTableModel(null, new String[] { "ID", "Nome", "CPF", "Sexo",
				"Email", "Telefone", "Rua", "Numero", "Bairro", "Cidade", "Data Nascimento" });

		String[] elementosvazio = { "Vazio", "Vazio", "Vazio", "Vazio", "Vazio", "Vazio", "Vazio", "Vazio", "Vazio",
				"Vazio", "Vazio" };

		ArrayList<Paciente> list = controllerPaciente.listarpaciente();

		if (list == null) {
			tabelaPaciente.addRow(elementosvazio);

		} else {
			for (Paciente paciente : list) {
				String idtemp = Long.toString(paciente.getId());
				txtId.setText(idtemp);
				txtNome.setText(paciente.getNome());
				txtcpf.setText(paciente.getCpf());
				txtsexo.setText(paciente.getSexo());
				txtEmail.setText(paciente.getEmail());
				txtTelefone.setText(paciente.getTelefonePaciente().getNumero());
				txtRua.setText(paciente.getEnderecoPaciente().getRua());
				txtNumero.setText(paciente.getEnderecoPaciente().getNumero());
				txtBairro.setText(paciente.getEnderecoPaciente().getBairro());
				txtCidade.setText(paciente.getEnderecoPaciente().getCidade());
				txtDataNascimento.setText(paciente.getNascimento());

				tabelaPaciente.addRow(new String[] { txtId.getText(), txtNome.getText(), txtcpf.getText(),
						txtsexo.getText(), txtEmail.getText(), txtTelefone.getText(), txtRua.getText(),
						txtNumero.getText(), txtBairro.getText(), txtCidade.getText(), txtDataNascimento.getText()});
			}
		}

		JPanel listarPaciente = new JPanel();
		listarPaciente.setLayout(new FlowLayout());
		JTable tabela = new JTable(tabelaPaciente);

		tabela.getColumnModel().getColumn(0).setPreferredWidth(2);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(140);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(50);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(10);
		tabela.getColumnModel().getColumn(4).setPreferredWidth(150);
		tabela.getColumnModel().getColumn(5).setPreferredWidth(50);
		tabela.getColumnModel().getColumn(6).setPreferredWidth(10);
		tabela.getColumnModel().getColumn(7).setPreferredWidth(50);
		tabela.setPreferredScrollableViewportSize(new Dimension(1366, 768));

		tabela.setFillsViewportHeight(true);
		JScrollPane scroll = new JScrollPane(tabela);
		tabela.getTableHeader().setReorderingAllowed(false);
		JFrame jlistarPaciente = new JFrame("Listagem Medicos");
		jlistarPaciente.add(listarPaciente);
		listarPaciente.add(scroll);
		jlistarPaciente.setVisible(true);
		jlistarPaciente.setExtendedState(JFrame.MAXIMIZED_BOTH);

	}

}
