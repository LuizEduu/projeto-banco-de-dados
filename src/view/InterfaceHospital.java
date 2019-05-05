package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import controller.ControllerHospital;
import model.Hospital;

public class InterfaceHospital {

	private ControllerHospital controllerHospital = new ControllerHospital();

	public void cadastrarHospital() {
		JPanel cadastrarHospital = new JPanel();
		cadastrarHospital.setLayout(new GridLayout(7, 2, -5, 3));
		JFrame janelaCadastrarHospital = new JFrame("Cadastrar");
		janelaCadastrarHospital.setSize(450, 350);
		janelaCadastrarHospital.setLocationRelativeTo(null);
		janelaCadastrarHospital.setVisible(true);
		janelaCadastrarHospital.add(cadastrarHospital);

		JLabel lblNome = new JLabel("Nome: ");
		JTextField txtNome = new JTextField(20);

		MaskFormatter maskcnpj = null;
		try {
			maskcnpj = new MaskFormatter("##.###.###/####-##");
		} catch (Exception e) {
			e.printStackTrace();
		}
		JLabel lblcnpj = new JLabel("CNPJ");
		JFormattedTextField txtcnpj = new JFormattedTextField(maskcnpj);
		JLabel lbltelefone = new JLabel("Telefone: ");

		MaskFormatter masktelefone = null;
		try {
			masktelefone = new MaskFormatter("(##)####-####");
		} catch (Exception e) {
			e.printStackTrace();
		}

		JFormattedTextField txttelefone = new JFormattedTextField(masktelefone);
		JLabel lblrua = new JLabel("Rua: ");
		JTextField txtrua = new JTextField(100);
		JLabel lblbairro = new JLabel("Bairro: ");
		JTextField txtbairro = new JTextField(100);
		JLabel lblcidade = new JLabel("Cidade: ");
		JTextField txtcidade = new JTextField(100);

		JButton btnCadastrar = new JButton("Cadastrar");
		JButton btnFecharcadastro = new JButton("Fechar Cadastro");

		cadastrarHospital.add(lblNome);
		cadastrarHospital.add(txtNome);
		cadastrarHospital.add(lblcnpj);
		cadastrarHospital.add(txtcnpj);
		cadastrarHospital.add(lbltelefone);
		cadastrarHospital.add(txttelefone);
		cadastrarHospital.add(lblrua);
		cadastrarHospital.add(txtrua);
		cadastrarHospital.add(lblbairro);
		cadastrarHospital.add(txtbairro);
		cadastrarHospital.add(lblcidade);
		cadastrarHospital.add(txtcidade);
		cadastrarHospital.add(btnCadastrar);
		cadastrarHospital.add(btnFecharcadastro);

		btnCadastrar.addActionListener((ActionEvent) -> {
			controllerHospital.cadastrarHospital(txtNome.getText(), txtcnpj.getText(), txttelefone.getText(),
					txtrua.getText(), txtbairro.getText(), txtcidade.getText());

			txtNome.setText(null);
			txtcnpj.setText(null);
			txttelefone.setText(null);
			txtrua.setText(null);
			txtbairro.setText(null);
			txtcidade.setText(null);
		});

		btnFecharcadastro.addActionListener((ActionEvent) -> {
			janelaCadastrarHospital.dispose();
		});
	}

	public void editarHospital() {
		JPanel editarHospital = new JPanel();
		editarHospital.setLayout(new GridLayout(9, 2, -1, 3));
		JFrame janelaEditarHospital = new JFrame("Editar");
		janelaEditarHospital.setSize(500, 420);
		janelaEditarHospital.setLocationRelativeTo(null);
		janelaEditarHospital.setVisible(true);
		janelaEditarHospital.add(editarHospital);

		JLabel lblid = new JLabel("ID: ");
		JTextField txtid = new JTextField(100);
		JButton botaobuscar = new JButton("Buscar");

		JLabel lblNome = new JLabel("Nome: ");
		JTextField txtNome = new JTextField(100);

		MaskFormatter maskcnpj = null;
		try {
			maskcnpj = new MaskFormatter("##.###.###/####-##");
		} catch (Exception e) {
			e.printStackTrace();
		}

		JLabel lblcnpj = new JLabel("CNPJ");
		JFormattedTextField txtcnpj = new JFormattedTextField(maskcnpj);
		JLabel lbltelefone = new JLabel("Telefone: ");
		MaskFormatter masktelefone = null;
		try {
			masktelefone = new MaskFormatter("(##)####-####");
		} catch (Exception e) {
			e.printStackTrace();
		}

		JFormattedTextField txttelefone = new JFormattedTextField(masktelefone);
		JLabel lblrua = new JLabel("Rua: ");
		JTextField txtrua = new JTextField();
		JLabel lblbairro = new JLabel("Bairro: ");
		JTextField txtbairro = new JTextField(100);
		JLabel lblcidade = new JLabel("Cidade: ");
		JTextField txtcidade = new JTextField(100);
		JButton editar = new JButton("Editar");
		JButton fecharRemocao = new JButton("Fechar Tela");

		editarHospital.add(lblid);
		editarHospital.add(txtid);
		editarHospital.add(botaobuscar);
		editarHospital.add(new JLabel());
		editarHospital.add(lblNome);
		editarHospital.add(txtNome);
		editarHospital.add(lblcnpj);
		editarHospital.add(txtcnpj);
		editarHospital.add(lbltelefone);
		editarHospital.add(txttelefone);
		editarHospital.add(lblrua);
		editarHospital.add(txtrua);
		editarHospital.add(lblbairro);
		editarHospital.add(txtbairro);
		editarHospital.add(lblcidade);
		editarHospital.add(txtcidade);
		editarHospital.add(editar);
		editarHospital.add(fecharRemocao);

		botaobuscar.addActionListener(ActionEvent -> {
			Hospital hospital = new Hospital();
			Long idtemp = (long) Integer.parseInt(txtid.getText());
			hospital = controllerHospital.buscarHospital(idtemp);
			txtNome.setText(hospital.getNome());
			txtcnpj.setText(hospital.getCnpj());
			txttelefone.setText(hospital.getTelefoneHospital().getNumerotelefone());
			txtrua.setText(hospital.getRua());
			txtbairro.setText(hospital.getBairro());
			txtcidade.setText(hospital.getCidade());

		});

		editar.addActionListener(ActionEvent -> {
			Long idtemp = (long) Integer.parseInt(txtid.getText());
			controllerHospital.atualizarHospital(idtemp, txtNome.getText(), txtcnpj.getText(), txttelefone.getText(),
					txtrua.getText(), txtbairro.getText(), txtcidade.getText());
			txtNome.setText(null);
			txtcnpj.setText(null);
			txttelefone.setText(null);
			txtrua.setText(null);
			txtbairro.setText(null);
			txtcidade.setText(null);
		});

		fecharRemocao.addActionListener((ActionEvent) -> {
			janelaEditarHospital.dispose();
		});
	}

	public void removerHospital() {
		JPanel editarHospital = new JPanel();
		editarHospital.setLayout(new GridLayout(9, 2, -1, 3));
		JFrame jenelaEditarHospital = new JFrame("Remover");
		jenelaEditarHospital.setSize(480, 400);
		jenelaEditarHospital.setLocationRelativeTo(null);
		jenelaEditarHospital.setVisible(true);
		jenelaEditarHospital.add(editarHospital);

		JLabel lblid = new JLabel("ID: ");
		JTextField txtid = new JTextField(100);
		JButton botaobuscar = new JButton("Buscar");

		JLabel lblNome = new JLabel("Nome: ");
		JTextField txtNome = new JTextField(100);

		MaskFormatter maskcnpj = null;
		try {
			maskcnpj = new MaskFormatter("##.###.###/####-##");
		} catch (Exception e) {
			e.printStackTrace();
		}
		JLabel lblcpf = new JLabel("CNPJ");
		JFormattedTextField txtcnpj = new JFormattedTextField(maskcnpj);
		JLabel lbltelefone = new JLabel("Telefone: ");
		MaskFormatter masktelefone = null;
		try {
			masktelefone = new MaskFormatter("(##)####-####");
		} catch (Exception e) {
			e.printStackTrace();
		}

		JFormattedTextField txttelefone = new JFormattedTextField(masktelefone);
		JLabel lblrua = new JLabel("Rua: ");
		JTextField txtrua = new JTextField(100);
		JLabel lblbairro = new JLabel("Bairro: ");
		JTextField txtbairro = new JTextField(100);
		JLabel lblcidade = new JLabel("Cidade: ");
		JTextField txtcidade = new JTextField(100);
		JButton remover = new JButton("Remover");
		JButton fechartela = new JButton("Fechar Tela");

		editarHospital.add(lblid);
		editarHospital.add(txtid);
		editarHospital.add(botaobuscar);
		editarHospital.add(new JLabel());
		editarHospital.add(lblNome);
		editarHospital.add(txtNome);
		editarHospital.add(lblcpf);
		editarHospital.add(txtcnpj);
		editarHospital.add(lbltelefone);
		editarHospital.add(txttelefone);
		editarHospital.add(lblrua);
		editarHospital.add(txtrua);
		editarHospital.add(lblbairro);
		editarHospital.add(txtbairro);
		editarHospital.add(lblcidade);
		editarHospital.add(txtcidade);
		editarHospital.add(remover);
		editarHospital.add(fechartela);

		txtNome.setBorder(null);
		txtcnpj.setBorder(null);
		txttelefone.setBorder(null);
		txtrua.setBorder(null);
		txtbairro.setBorder(null);
		txtcidade.setBorder(null);

		txtNome.setEditable(false);
		txtcnpj.setEditable(false);
		txttelefone.setEditable(false);
		txtrua.setEditable(false);
		txtbairro.setEditable(false);
		txtcidade.setEditable(false);

		txtNome.setFont(txtNome.getFont().deriveFont(14f));
		txtcnpj.setFont(txtcnpj.getFont().deriveFont(14f));
		txttelefone.setFont(txttelefone.getFont().deriveFont(14f));
		txtrua.setFont(txtrua.getFont().deriveFont(14f));
		txtbairro.setFont(txtbairro.getFont().deriveFont(14f));
		txtcidade.setFont(txtcidade.getFont().deriveFont(14f));

		botaobuscar.addActionListener((ActionEvent) -> {
			Hospital hospital = new Hospital();
			Long idtemp = (long) Integer.parseInt(txtid.getText());
			hospital = controllerHospital.buscarHospital(idtemp);
			txtNome.setText(hospital.getNome());
			txtcnpj.setText(hospital.getCnpj());
			txttelefone.setText(hospital.getTelefoneHospital().getNumerotelefone());
			txtrua.setText(hospital.getRua());
			txtbairro.setText(hospital.getBairro());
			txtcidade.setText(hospital.getCidade());

		});

		remover.addActionListener((ActionEvent) -> {
			int idtemp = Integer.parseInt(txtid.getText());
			controllerHospital.removerHospital(idtemp);
		});

		fechartela.addActionListener((ActionEvent) -> {
			jenelaEditarHospital.dispose();
		});
	}

	public void listarHospital() {

		JTextField txtId = new JTextField(100);
		JTextField txtNome = new JTextField(100);
		JTextField txtcnpj = new JTextField(100);
		JTextField txtTelefone = new JTextField(100);
		JTextField txtBairro = new JTextField(100);
		JTextField txtCidade = new JTextField(100);

		DefaultTableModel tabelaHospital = new DefaultTableModel(null,
				new String[] { "ID", "Nome", "CNPJ", "Telefone", "Bairro", "Cidade" });

		String[] elementosvazio = { "Vazio", "Vazio", "Vazio", "Vazio", "Vazio", "Vazio" };

		ArrayList<Hospital> list = controllerHospital.listarHospital();

		if (list == null) {
			tabelaHospital.addRow(elementosvazio);

		} else {
			for (Hospital hospital : list) {
				String idtemp = Long.toString(hospital.getIdhospital());
				txtId.setText(idtemp);
				txtNome.setText(hospital.getNome());
				txtcnpj.setText(hospital.getCnpj());
				txtTelefone.setText(hospital.getTelefoneHospital().getNumerotelefone());
				txtBairro.setText(hospital.getBairro());
				txtCidade.setText(hospital.getCidade());

				tabelaHospital.addRow(new String[] { txtId.getText(), txtNome.getText(), txtcnpj.getText(),
						txtTelefone.getText(), txtBairro.getText(), txtCidade.getText() });
			}
		}

		JPanel listarHospital = new JPanel();
		listarHospital.setLayout(new FlowLayout());
		JTable tabela = new JTable(tabelaHospital);

		tabela.getColumnModel().getColumn(0).setPreferredWidth(2);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(160);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(10);
		tabela.getColumnModel().getColumn(4).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(5).setPreferredWidth(50);
		tabela.setPreferredScrollableViewportSize(new Dimension(1366, 768));

		tabela.setFillsViewportHeight(true);
		JScrollPane scroll = new JScrollPane(tabela);
		tabela.getTableHeader().setReorderingAllowed(false);
		JFrame jlistarPaciente = new JFrame("Listagem Hospitais");
		jlistarPaciente.add(listarHospital);
		listarHospital.add(scroll);
		jlistarPaciente.setVisible(true);
		jlistarPaciente.setExtendedState(JFrame.MAXIMIZED_BOTH);

	}

}
