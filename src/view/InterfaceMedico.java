package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import controller.ControllerMedico;
import model.Medico;

public class InterfaceMedico {

	ControllerMedico controllerMedico = new ControllerMedico();

	public void cadastrarMedico() {
		JPanel cadastrarMedico = new JPanel();
		cadastrarMedico.setLayout(new GridLayout(11, 2, -5, 3));
		JFrame janelaCadastrarMedico = new JFrame("Cadastrar");
		janelaCadastrarMedico.setSize(560, 410);
		janelaCadastrarMedico.setLocationRelativeTo(null);
		janelaCadastrarMedico.setVisible(true);
		janelaCadastrarMedico.add(cadastrarMedico);

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
		JComboBox<String> ComboSexo = new JComboBox<String>();
		ComboSexo.addItem("M");
		ComboSexo.addItem("F");
		ComboSexo.setSelectedItem(null);
		JLabel lblSexo = new JLabel("Sexo: ");
		JLabel lblespecialidade = new JLabel("Especialidade: ");
		JTextField txtespecialidade = new JTextField(100);
		JLabel lblcrm = new JLabel("CRM: ");
		JTextField txtcrm = new JTextField(100);
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

		JButton btnCadastrar = new JButton("Cadastrar");
		JButton btnFecharcadastro = new JButton("Fechar Cadastro");

		cadastrarMedico.add(lblNome);
		cadastrarMedico.add(txtNome);
		cadastrarMedico.add(lblcpf);
		cadastrarMedico.add(txtcpf);
		cadastrarMedico.add(lblSexo);
		cadastrarMedico.add(ComboSexo);
		cadastrarMedico.add(lblespecialidade);
		cadastrarMedico.add(txtespecialidade);
		cadastrarMedico.add(lblcrm);
		cadastrarMedico.add(txtcrm);
		cadastrarMedico.add(lbltelefone);
		cadastrarMedico.add(txttelefone);
		cadastrarMedico.add(lblrua);
		cadastrarMedico.add(txtrua);
		cadastrarMedico.add(lblnumero);
		cadastrarMedico.add(txtnumero);
		cadastrarMedico.add(lblbairro);
		cadastrarMedico.add(txtbairro);
		cadastrarMedico.add(lblcidade);
		cadastrarMedico.add(txtcidade);
		cadastrarMedico.add(btnCadastrar);
		cadastrarMedico.add(btnFecharcadastro);

		btnCadastrar.addActionListener((ActionEvent) -> {
			try {
				controllerMedico.cadastrarMedico(txtNome.getText(), txtcpf.getText(),
						(String) ComboSexo.getSelectedItem(), txtespecialidade.getText(), txtcrm.getText(),
						txttelefone.getText(), txtrua.getText(), txtnumero.getText(), txtbairro.getText(),
						txtcidade.getText());

				txtNome.setText(null);
				txtcpf.setText(null);
				ComboSexo.setSelectedItem(null);
				txtespecialidade.setText(null);
				txtcrm.setText(null);
				txttelefone.setText(null);
				txtrua.setText(null);
				txtnumero.setText(null);
				txtbairro.setText(null);
				txtcidade.setText(null);

				JOptionPane.showMessageDialog(null, "Medico cadastrado com sucesso", "Sucesso",
						JOptionPane.INFORMATION_MESSAGE);

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro, Medico não cadastrado", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		});

		btnFecharcadastro.addActionListener((ActionEvent) -> {
			janelaCadastrarMedico.dispose();
		});
	}

	public void editarMedico() {
		JPanel editarMedico = new JPanel();
		editarMedico.setLayout(new GridLayout(13, 2, -1, 3));
		JFrame janelaEditarMedico = new JFrame("Editar");
		janelaEditarMedico.setSize(560, 480);
		janelaEditarMedico.setLocationRelativeTo(null);
		janelaEditarMedico.setVisible(true);
		janelaEditarMedico.add(editarMedico);

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
		JLabel lblespecialidade = new JLabel("Especialidade: ");
		JLabel lblcrm = new JLabel("CRM: ");
		JTextField txtcrm = new JTextField(10);
		JTextField txtespecialidade = new JTextField(100);
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
		JButton editar = new JButton("Editar");
		JButton fecharRemocao = new JButton("Fechar Tela");

		editarMedico.add(lblid);
		editarMedico.add(txtid);
		editarMedico.add(botaobuscar);
		editarMedico.add(new JLabel());
		editarMedico.add(lblNome);
		editarMedico.add(txtNome);
		editarMedico.add(lblcpf);
		editarMedico.add(txtcpf);
		editarMedico.add(lblSexo);
		editarMedico.add(ComboSexo);
		editarMedico.add(lblespecialidade);
		editarMedico.add(txtespecialidade);
		editarMedico.add(lblcrm);
		editarMedico.add(txtcrm);
		editarMedico.add(lbltelefone);
		editarMedico.add(txttelefone);
		editarMedico.add(lblrua);
		editarMedico.add(txtrua);
		editarMedico.add(lblnumero);
		editarMedico.add(txtnumero);
		editarMedico.add(lblbairro);
		editarMedico.add(txtbairro);
		editarMedico.add(lblcidade);
		editarMedico.add(txtcidade);
		editarMedico.add(editar);
		editarMedico.add(fecharRemocao);
		editar.setEnabled(false);

		botaobuscar.addActionListener(ActionEvent -> {
			try {
				Medico medico = new Medico();
				Long idtemp = (long) Integer.parseInt(txtid.getText());
				medico = controllerMedico.buscarMedico(idtemp);

				txtNome.setText(medico.getNome());
				txtcpf.setText(medico.getCpf());
				ComboSexo.setSelectedItem(medico.getSexo());
				txtespecialidade.setText(medico.getEspecialidade());
				txtcrm.setText(medico.getCrm());
				txttelefone.setText(medico.getTelefoneMedico().getNumero());
				txtrua.setText(medico.getEnderecoMedico().getRua());
				txtnumero.setText(medico.getEnderecoMedico().getNumero());
				txtbairro.setText(medico.getEnderecoMedico().getBairro());
				txtcidade.setText(medico.getEnderecoMedico().getCidade());
				editar.setEnabled(true);

			}catch (Exception e) {
				JOptionPane.showMessageDialog(botaobuscar, "Medico não encontrado", "Erro",
						JOptionPane.ERROR_MESSAGE);
			}
		});

		editar.addActionListener(ActionEvent -> {
				int opc = JOptionPane.showConfirmDialog(null, "Deseja Realmente editar o medico " + txtNome.getText(),
						"", JOptionPane.YES_NO_OPTION);

				if (opc == JOptionPane.YES_OPTION) {
					Long idtemp = (long) Integer.parseInt(txtid.getText());
					controllerMedico.atualizarMedico(idtemp, txtNome.getText(), txtcpf.getText(),
							(String) ComboSexo.getSelectedItem(), txtespecialidade.getText(), txtcrm.getText(),
							txttelefone.getText(), txtrua.getText(), txtnumero.getText(), txtbairro.getText(),
							txtcidade.getText());
					JOptionPane.showMessageDialog(null, "Medico Editado com Sucesso", "Sucesso",
							JOptionPane.INFORMATION_MESSAGE);

					txtNome.setText(null);
					txtcpf.setText(null);
					ComboSexo.setSelectedItem(null);
					txtespecialidade.setText(null);
					txtcrm.setText(null);
					txttelefone.setText(null);
					txtrua.setText(null);
					txtnumero.setText(null);
					txtbairro.setText(null);
					txtcidade.setText(null);

				} else {
					JOptionPane.showMessageDialog(null, "Edição cancelada com sucesso", "Erro",
							JOptionPane.ERROR_MESSAGE);
				}
		});
		fecharRemocao.addActionListener((ActionEvent) -> {
			janelaEditarMedico.dispose();
		});
	}

	public void removerMedico() {
		JPanel removerMedico = new JPanel();
		removerMedico.setLayout(new GridLayout(13, 2, -1, 3));
		JFrame janelaRemoverMedico = new JFrame("Remover");
		janelaRemoverMedico.setSize(560, 480);
		janelaRemoverMedico.setLocationRelativeTo(null);
		janelaRemoverMedico.setVisible(true);
		janelaRemoverMedico.add(removerMedico);

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
		JLabel lblSexo = new JLabel("Sexo: ");
		JTextField txtsexo = new JTextField(10);
		JLabel lblespecialidade = new JLabel("Especialidade: ");
		JTextField txtespecialidade = new JTextField(100);
		JLabel lblcrm = new JLabel("CRM: ");
		JTextField txtcrm = new JTextField(10);
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

		JButton remover = new JButton("Remover");
		JButton fechartela = new JButton("Fechar Tela");

		removerMedico.add(lblid);
		removerMedico.add(txtid);
		removerMedico.add(botaobuscar);
		removerMedico.add(new JLabel());
		removerMedico.add(lblNome);
		removerMedico.add(txtNome);
		removerMedico.add(lblcpf);
		removerMedico.add(txtcpf);
		removerMedico.add(lblSexo);
		removerMedico.add(txtsexo);
		removerMedico.add(lblespecialidade);
		removerMedico.add(txtespecialidade);
		removerMedico.add(lblcrm);
		removerMedico.add(txtcrm);
		removerMedico.add(lbltelefone);
		removerMedico.add(txttelefone);
		removerMedico.add(lblrua);
		removerMedico.add(txtrua);
		removerMedico.add(lblnumero);
		removerMedico.add(txtnumero);
		removerMedico.add(lblbairro);
		removerMedico.add(txtbairro);
		removerMedico.add(lblcidade);
		removerMedico.add(txtcidade);
		removerMedico.add(remover);
		removerMedico.add(fechartela);

		txtNome.setEditable(false);
		txtcpf.setEditable(false);
		txtsexo.setEditable(false);
		txtespecialidade.setEditable(false);
		txtcrm.setEditable(false);
		txttelefone.setEditable(false);
		txtrua.setEditable(false);
		txtnumero.setEditable(false);
		txtbairro.setEditable(false);
		txtcidade.setEditable(false);

		txtNome.setBorder(null);
		txtcpf.setBorder(null);
		txtsexo.setBorder(null);
		txtespecialidade.setBorder(null);
		txtcrm.setBorder(null);
		txttelefone.setBorder(null);
		txtrua.setBorder(null);
		txtnumero.setBorder(null);
		txtbairro.setBorder(null);
		txtcidade.setBorder(null);

		txtNome.setFont(txtNome.getFont().deriveFont(14f));
		txtcpf.setFont(txtcpf.getFont().deriveFont(14f));
		txtsexo.setFont(txtsexo.getFont().deriveFont(14f));
		txtespecialidade.setFont(txtespecialidade.getFont().deriveFont(14f));
		txtcrm.setFont(txtcrm.getFont().deriveFont(14f));
		txttelefone.setFont(txttelefone.getFont().deriveFont(14f));
		txtrua.setFont(txtrua.getFont().deriveFont(14f));
		txtnumero.setFont(txtnumero.getFont().deriveFont(14f));
		txtbairro.setFont(txtbairro.getFont().deriveFont(14f));
		txtcidade.setFont(txtcidade.getFont().deriveFont(14f));

		remover.setEnabled(false);

		botaobuscar.addActionListener(ActionEvent -> {
			try {
				Medico medico = new Medico();
				Long idtemp = (long) Integer.parseInt(txtid.getText());
				medico = controllerMedico.buscarMedico(idtemp);
				txtNome.setText(medico.getNome());
				txtcpf.setText(medico.getCpf());
				txtsexo.setText(medico.getSexo());
				txtespecialidade.setText(medico.getEspecialidade());
				txtcrm.setText(medico.getCrm());
				txttelefone.setText(medico.getTelefoneMedico().getNumero());
				txtrua.setText(medico.getEnderecoMedico().getRua());
				txtnumero.setText(medico.getEnderecoMedico().getNumero());
				txtbairro.setText(medico.getEnderecoMedico().getBairro());
				txtcidade.setText(medico.getEnderecoMedico().getCidade());
				txtNome.setEditable(false);
				txtsexo.setEditable(false);
				txtespecialidade.setEditable(false);
				txttelefone.setEditable(false);
				txtrua.setEditable(false);
				txtnumero.setEditable(false);
				txtbairro.setEditable(false);
				txtcidade.setEditable(false);

			} catch (Exception e) {
				JOptionPane.showMessageDialog(botaobuscar, "Medico não encontrado", "Erro",
						JOptionPane.ERROR_MESSAGE);
			}

		});
		
		remover.addActionListener((ActionEvent) -> {
			int idtemp = Integer.parseInt(txtid.getText());
			controllerMedico.removerMedico(idtemp);

			txtNome.setText(null);
			txtcpf.setText(null);
			txtsexo.setText(null);
			txtespecialidade.setText(null);
			txtcrm.setText(null);
			txttelefone.setText(null);
			txtrua.setText(null);
			txtnumero.setText(null);
			txtbairro.setText(null);
			txtcidade.setText(null);
		});

		fechartela.addActionListener((ActionEvent) -> {
			janelaRemoverMedico.dispose();
		});
	}

	public void listarMedico() {

		JTextField txtId = new JTextField(100);
		JTextField txtNome = new JTextField(100);
		JTextField txtcpf = new JTextField(100);
		JTextField txtsexo = new JTextField(100);
		JTextField txtespecialidade = new JTextField(100);
		JTextField txtcrm = new JTextField(100);
		JTextField txtTelefone = new JTextField(100);
		JTextField txtRua = new JTextField(100);
		JTextField txtNumero = new JTextField(100);
		JTextField txtBairro = new JTextField(100);
		JTextField txtCidade = new JTextField(100);

		DefaultTableModel tabelaMedico = new DefaultTableModel(null, new String[] { "ID", "Nome", "CPF", "Sexo",
				"Especialidade", "CRM", "Telefone", "Rua", "Numero", "Bairro", "Cidade" });

		ArrayList<Medico> list = controllerMedico.listarMedico();

		if (list != null) {
			for (Medico medico : list) {
				String idtemp = Long.toString(medico.getId());
				txtId.setText(idtemp);
				txtNome.setText(medico.getNome());
				txtcpf.setText(medico.getCpf());
				txtsexo.setText(medico.getSexo());
				txtespecialidade.setText(medico.getEspecialidade());
				txtcrm.setText(medico.getCrm());
				txtTelefone.setText(medico.getTelefoneMedico().getNumero());
				txtRua.setText(medico.getEnderecoMedico().getRua());
				txtNumero.setText(medico.getEnderecoMedico().getNumero());
				txtBairro.setText(medico.getEnderecoMedico().getBairro());
				txtCidade.setText(medico.getEnderecoMedico().getCidade());

				tabelaMedico.addRow(new String[] { txtId.getText(), txtNome.getText(), txtcpf.getText(),
						txtsexo.getText(), txtespecialidade.getText(), txtcrm.getText(), txtTelefone.getText(),
						txtRua.getText(), txtNumero.getText(), txtBairro.getText(), txtCidade.getText() });
			}

		} else if (list == null) {
			tabelaMedico.addRow(new String[] { "Vazio", "Vazio", "Vazio", "Vazio", "Vazio", "Vazio", "Vazio", "Vazio",
					"Vazio", "Vazio", "Vazio" });
		}

		JPanel listarMedico = new JPanel();
		listarMedico.setLayout(new FlowLayout());
		JTable tabela = new JTable(tabelaMedico);

		tabela.getColumnModel().getColumn(0).setPreferredWidth(2);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(140);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(50);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(20);
		tabela.getColumnModel().getColumn(4).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(5).setPreferredWidth(50);
		tabela.getColumnModel().getColumn(6).setPreferredWidth(70);
		tabela.getColumnModel().getColumn(7).setPreferredWidth(50);
		tabela.setPreferredScrollableViewportSize(new Dimension(1366, 768));

		tabela.setFillsViewportHeight(true);
		JScrollPane scroll = new JScrollPane(tabela);
		tabela.getTableHeader().setReorderingAllowed(false);
		JFrame jListarMedico = new JFrame("Listagem Medicos");
		jListarMedico.add(listarMedico);
		listarMedico.add(scroll);
		jListarMedico.setVisible(true);
		jListarMedico.setExtendedState(JFrame.MAXIMIZED_BOTH);

	}

}
