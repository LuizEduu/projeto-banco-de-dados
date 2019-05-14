package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
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

import controller.ControllerConsulta;
import model.Consulta;
import model.Hospital;
import model.Medico;
import model.Paciente;

public class InterfaceConsulta {
	ControllerConsulta controllerConsulta = new ControllerConsulta();
	Consulta consulta = new Consulta();
	Paciente paciente = new Paciente();
	Hospital hospital = new Hospital();
	Medico medico = new Medico();
	long idtempPaciente;
	long idtempHospital;
	long idtempMedico;
	long idtemp = 0;

	public void agendarConsulta() {
		JPanel editarConsulta = new JPanel();
		editarConsulta.setLayout(new GridLayout(15, 4, 2, -1));
		JFrame janelaEditarConsulta = new JFrame("Editar Consulta");
		janelaEditarConsulta.setSize(700, 600);
		janelaEditarConsulta.setLocationRelativeTo(null);
		janelaEditarConsulta.setVisible(true);
		janelaEditarConsulta.add(editarConsulta);

		MaskFormatter maskcpfpaciente = null;
		try {
			maskcpfpaciente = new MaskFormatter("### . ### . ### - ##");

		} catch (Exception e) {
			e.printStackTrace();
		}

		MaskFormatter maskcpfpaciente2 = null;
		try {
			maskcpfpaciente2 = new MaskFormatter("### . ### . ### - ##");

		} catch (Exception e) {
			e.printStackTrace();
		}

		JLabel lblcpfPaciente = new JLabel("Cpf Paciente: ");
		JFormattedTextField txtcpfPaciente = new JFormattedTextField(maskcpfpaciente);
		JButton botaoBuscarPaciente = new JButton("Buscar Paciente");
		JLabel lblNomePaciente = new JLabel("Nome Paciente: ");
		JTextField txtNomePaciente = new JTextField(100);
		JLabel lblcpfpaciente2 = new JLabel("CPF Paciente: ");
		JFormattedTextField txtcpfpaciente2 = new JFormattedTextField(maskcpfpaciente2);
		JLabel lbltelefonePaciente = new JLabel("Telefone Paciente: ");

		MaskFormatter masktelefone = null;
		try {
			masktelefone = new MaskFormatter("(##)#### - ####");
		} catch (Exception e) {
			e.printStackTrace();
		}
		JFormattedTextField txtTelefonePaciente = new JFormattedTextField(masktelefone);
		JLabel lblsexo = new JLabel("Sexo: ");
		JTextField txtsexo = new JTextField(10);

		MaskFormatter maskcnpj = null;
		try {
			maskcnpj = new MaskFormatter("##. ###. ### / #### - ##");
		} catch (Exception e) {
			e.printStackTrace();
		}

		MaskFormatter maskcnpj2 = null;
		try {
			maskcnpj2 = new MaskFormatter("##. ### . ### / #### - ##");
		} catch (Exception e) {
			e.printStackTrace();
		}

		MaskFormatter masktelefonemedico = null;
		try {
			masktelefonemedico = new MaskFormatter("(##)#### - ####");
		} catch (Exception e) {
			e.printStackTrace();
		}
		JLabel lblcnpjHospital = new JLabel("CNPJ Hospital: ");
		JFormattedTextField txtcpnjHospital = new JFormattedTextField(maskcnpj);
		JButton botaoBuscarHospital = new JButton("Buscar Hospital");
		JLabel lblNomeHospital = new JLabel("Hospital: ");
		JTextField txtNomeHospital = new JTextField(100);
		JLabel lblcpnjhospital2 = new JLabel("CNPJ Hospital: ");
		JFormattedTextField txtcpnj = new JFormattedTextField(maskcnpj2);
		JLabel lbltelefoneHospital = new JLabel("Telefone Hospital: ");
		JFormattedTextField txtTelefoneHospital = new JFormattedTextField(masktelefonemedico);
		JLabel lblrua = new JLabel("Rua: ");
		JTextField txtrua = new JTextField(100);
		JTextField txtnumero = new JTextField(100);
		JLabel lblbairro = new JLabel("Bairro: ");
		JTextField txtbairro = new JTextField(100);
		JLabel lblcidade = new JLabel("Cidade: ");
		JTextField txtcidade = new JTextField(100);

		MaskFormatter maskcpfmedico = null;
		try {
			maskcpfmedico = new MaskFormatter("### . ### . ### - ##");
		} catch (Exception e) {
			e.printStackTrace();
		}

		MaskFormatter maskcpfmedico2 = null;
		try {
			maskcpfmedico2 = new MaskFormatter("### . ### . ### - ##");
		} catch (Exception e) {
			e.printStackTrace();
		}

		JLabel lblcpfmedico = new JLabel("CPF Medico: ");
		JFormattedTextField txtcpfmedico = new JFormattedTextField(maskcpfmedico);
		JButton botaobuscarMedico = new JButton("Buscar Medico");
		JLabel lblNomeMedico = new JLabel("Nome Medico: ");
		JTextField txtNomeMedico = new JTextField(100);
		JLabel lblcpfmedico2 = new JLabel("CPF Medico: ");
		JFormattedTextField txtcpfmedico2 = new JFormattedTextField(maskcpfmedico2);
		JLabel lblcrmMedico = new JLabel("CRM: ");
		JTextField txtcrmMedico = new JTextField(100);
		JLabel lblbespcialidade = new JLabel("Especialidade: ");
		JTextField txtespecialidade = new JTextField(10);
		JLabel lbldiagnostico = new JLabel("Diagnostico: ");
		JTextField txtdiagnostico = new JTextField(500);
		JLabel lbldataconsulta = new JLabel("Data da Consulta: ");
		MaskFormatter maskDataConsulta = null;
		try {
			maskDataConsulta = new MaskFormatter("##/##/#### ##:##");
		} catch (Exception e) {
			e.printStackTrace();
		}
		JFormattedTextField txtdataconsulta = new JFormattedTextField(maskDataConsulta);
		JButton btnagendarConsulta = new JButton("Agendar Consulta");
		JButton fecharjanela = new JButton("Fechar Janela");

		editarConsulta.add(lblcpfPaciente);
		editarConsulta.add(txtcpfPaciente);
		editarConsulta.add(botaoBuscarPaciente);
		editarConsulta.add(new JLabel());
		editarConsulta.add(lblNomePaciente);
		editarConsulta.add(txtNomePaciente);
		editarConsulta.add(lblcpfpaciente2);
		editarConsulta.add(txtcpfpaciente2);
		editarConsulta.add(lbltelefonePaciente);
		editarConsulta.add(txtTelefonePaciente);
		editarConsulta.add(lblsexo);
		editarConsulta.add(txtsexo);
		editarConsulta.add(new JLabel());
		editarConsulta.add(new JLabel());
		editarConsulta.add(new JLabel());
		editarConsulta.add(new JLabel());
		editarConsulta.add(lblcnpjHospital);
		editarConsulta.add(txtcpnjHospital);
		editarConsulta.add(botaoBuscarHospital);
		editarConsulta.add(new JLabel());
		editarConsulta.add(lblNomeHospital);
		editarConsulta.add(txtNomeHospital);
		editarConsulta.add(lblcpnjhospital2);
		editarConsulta.add(txtcpnj);
		editarConsulta.add(lbltelefoneHospital);
		editarConsulta.add(txtTelefoneHospital);
		editarConsulta.add(lblrua);
		editarConsulta.add(txtrua);
		editarConsulta.add(lblbairro);
		editarConsulta.add(txtbairro);
		editarConsulta.add(lblcidade);
		editarConsulta.add(txtcidade);
		editarConsulta.add(new JLabel());
		editarConsulta.add(new JLabel());
		editarConsulta.add(new JLabel());
		editarConsulta.add(new JLabel());
		editarConsulta.add(lblcpfmedico);
		editarConsulta.add(txtcpfmedico);
		editarConsulta.add(botaobuscarMedico);
		editarConsulta.add(new JLabel());
		editarConsulta.add(lblNomeMedico);
		editarConsulta.add(txtNomeMedico);
		editarConsulta.add(lblcpfmedico2);
		editarConsulta.add(txtcpfmedico2);
		editarConsulta.add(lblcrmMedico);
		editarConsulta.add(txtcrmMedico);
		editarConsulta.add(lblbespcialidade);
		editarConsulta.add(txtespecialidade);
		editarConsulta.add(new JLabel());
		editarConsulta.add(new JLabel());
		editarConsulta.add(new JLabel());
		editarConsulta.add(new JLabel());
		editarConsulta.add(lbldiagnostico);
		editarConsulta.add(txtdiagnostico);
		editarConsulta.add(lbldataconsulta);
		editarConsulta.add(txtdataconsulta);
		editarConsulta.add(new JLabel());
		editarConsulta.add(btnagendarConsulta);
		editarConsulta.add(fecharjanela);

		txtcpfpaciente2.setBorder(null);
		txtNomePaciente.setBorder(null);
		txtTelefonePaciente.setBorder(null);
		txtsexo.setBorder(null);
		txtNomeHospital.setBorder(null);
		txtTelefoneHospital.setBorder(null);
		txtcpnj.setBorder(null);
		txtTelefoneHospital.setBorder(null);
		txtrua.setBorder(null);
		txtnumero.setBorder(null);
		txtbairro.setBorder(null);
		txtcidade.setBorder(null);
		txtNomeMedico.setBorder(null);
		txtcpfmedico2.setBorder(null);
		txtcrmMedico.setBorder(null);
		txtespecialidade.setBorder(null);
		txtrua.setBorder(null);
		txtbairro.setBorder(null);
		txtcidade.setBorder(null);

		txtcpfpaciente2.setEditable(false);
		txtNomePaciente.setEditable(false);
		txtTelefonePaciente.setEditable(false);
		txtsexo.setEditable(false);
		txtNomeHospital.setEditable(false);
		txtTelefoneHospital.setEditable(false);
		txtcpnj.setEditable(false);
		txtTelefoneHospital.setEditable(false);
		txtrua.setEditable(false);
		txtnumero.setEditable(false);
		txtbairro.setEditable(false);
		txtcidade.setEditable(false);
		txtNomeMedico.setEditable(false);
		txtcpfmedico2.setEditable(false);
		txtcrmMedico.setEditable(false);
		txtespecialidade.setEditable(false);
		txtrua.setEditable(false);
		txtbairro.setEditable(false);
		txtcidade.setEditable(false);

		txtcpfpaciente2.setFont(txtcpfpaciente2.getFont().deriveFont(14f));
		txtNomePaciente.setFont(txtNomePaciente.getFont().deriveFont(14f));
		txtTelefonePaciente.setFont(txtTelefonePaciente.getFont().deriveFont(14f));
		txtsexo.setFont(txtsexo.getFont().deriveFont(14f));
		txtNomeHospital.setFont(txtNomeHospital.getFont().deriveFont(14f));
		txtTelefoneHospital.setFont(txtTelefoneHospital.getFont().deriveFont(14f));
		txtcpnj.setFont(txtcpnj.getFont().deriveFont(14f));
		txtTelefoneHospital.setFont(txtTelefoneHospital.getFont().deriveFont(14f));
		txtrua.setFont(txtrua.getFont().deriveFont(14f));
		txtnumero.setFont(txtnumero.getFont().deriveFont(14f));
		txtbairro.setFont(txtbairro.getFont().deriveFont(14f));
		txtcidade.setFont(txtcidade.getFont().deriveFont(14f));
		txtNomeMedico.setFont(txtNomeMedico.getFont().deriveFont(14f));
		txtcpfmedico2.setFont(txtcpfmedico2.getFont().deriveFont(14f));
		txtcrmMedico.setFont(txtcrmMedico.getFont().deriveFont(14f));
		txtespecialidade.setFont(txtespecialidade.getFont().deriveFont(14f));
		txtrua.setFont(txtrua.getFont().deriveFont(14f));
		txtbairro.setFont(txtbairro.getFont().deriveFont(14f));
		txtcidade.setFont(txtcidade.getFont().deriveFont(14f));

		botaoBuscarPaciente.addActionListener(ActionListener -> {
			try {
			paciente = controllerConsulta.buscarDadosPaciente(txtcpfPaciente.getText());
			txtNomePaciente.setText(paciente.getNome());
			txtcpfpaciente2.setText(paciente.getCpf());
			txtTelefonePaciente.setText(paciente.getTelefonePaciente().getNumero());
			txtsexo.setText(paciente.getSexo());
			idtempPaciente = paciente.getId();
			
			}catch (Exception e) {
				JOptionPane.showMessageDialog(botaoBuscarPaciente, "Paciente não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
			}

		});

		botaoBuscarHospital.addActionListener(ActionEvent -> {
			try {
			hospital = controllerConsulta.buscarDadosHospital(txtcpnjHospital.getText());
			txtNomeHospital.setText(hospital.getNome());
			txtcpnj.setText(hospital.getCnpj());
			txtTelefoneHospital.setText(hospital.getTelefoneHospital().getNumerotelefone());
			txtrua.setText(hospital.getRua());
			txtbairro.setText(hospital.getBairro());
			txtcidade.setText(hospital.getCidade());
			idtempHospital = hospital.getIdhospital();
			
			}catch (Exception e) {
				JOptionPane.showMessageDialog(botaoBuscarHospital, "Hospital não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
			}

		});

		botaobuscarMedico.addActionListener(ActionEvent -> {
			try {
			medico = controllerConsulta.buscarDadosMedico(txtcpfmedico.getText());
			txtNomeMedico.setText(medico.getNome());
			txtcpfmedico2.setText(medico.getCpf());
			txtcrmMedico.setText(medico.getCrm());
			txtespecialidade.setText(medico.getEspecialidade());
			idtempMedico = medico.getId();
			
			}catch (Exception e) {
				JOptionPane.showMessageDialog(botaobuscarMedico, "Medico não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		});

		btnagendarConsulta.addActionListener(ActionEvent -> {
			controllerConsulta.agendarConsulta(txtdiagnostico.getText(), txtdataconsulta.getText(), idtempPaciente,
					idtempMedico, idtempHospital);
			JOptionPane.showMessageDialog(null, "Consulta Agendada com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			
			txtcpfPaciente.setText(null);
			txtcpfpaciente2.setText(null);
			txtNomePaciente.setText(null);
			txtTelefonePaciente.setText(null);
			txtsexo.setText(null);
			txtNomeHospital.setText(null);
			txtTelefoneHospital.setText(null);
			txtcpnjHospital.setText(null);
			txtcpnj.setText(null);
			txtTelefoneHospital.setText(null);
			txtrua.setText(null);
			txtnumero.setText(null);
			txtbairro.setText(null);
			txtcidade.setText(null);
			txtNomeMedico.setText(null);
			txtcpfmedico.setText(null);
			txtcpfmedico2.setText(null);
			txtcrmMedico.setText(null);
			txtespecialidade.setText(null);
			txtrua.setText(null);
			txtbairro.setText(null);
			txtcidade.setText(null);
			
		});

		fecharjanela.addActionListener(ActionEvent -> {
			janelaEditarConsulta.dispose();
		});
	}

	public void editarConsulta() {
		JPanel atualizarConsulta = new JPanel();
		atualizarConsulta.setLayout(new GridLayout(14, 4, 5, 10));
		JFrame janelaAtualizarConsulta = new JFrame("Atualizar Consulta");
		janelaAtualizarConsulta.setSize(700, 650);
		janelaAtualizarConsulta.setLocationRelativeTo(null);
		janelaAtualizarConsulta.setVisible(true);
		janelaAtualizarConsulta.add(atualizarConsulta);

		MaskFormatter maskcpfpaciente = null;
		try {
			maskcpfpaciente = new MaskFormatter("###.###.###-##");
		} catch (Exception e) {
			e.printStackTrace();
		}

		JLabel lblidConsulta = new JLabel("ID consulta: ");
		JTextField txtidconsulta = new JTextField(100);
		JButton botaoBuscarConsulta = new JButton("Buscar Consulta");
		JLabel lblcpfPaciente = new JLabel("CPF paciente");
		MaskFormatter maskcpfpaciente2 = null;
		try {
			maskcpfpaciente2 = new MaskFormatter("###.###.###-##");
		} catch (Exception e) {
			e.printStackTrace();
		}
		JFormattedTextField txtcpfPaciente = new JFormattedTextField(maskcpfpaciente2);
		JButton botaoBuscarPaciente = new JButton("Buscar Paciente");
		JLabel lblNomePaciente = new JLabel("Nome Paciente: ");
		JTextField txtNomePaciente = new JTextField(100);
		JLabel lblcpfpaciente2 = new JLabel("CPF Paciente: ");
		JFormattedTextField txtcpfpaciente2 = new JFormattedTextField(maskcpfpaciente);
		JLabel lbltelefonePaciente = new JLabel("Telefone Paciente: ");

		MaskFormatter masktelefone = null;
		try {
			masktelefone = new MaskFormatter("(##)####-####");
		} catch (Exception e) {
			e.printStackTrace();
		}
		JFormattedTextField txtTelefonePaciente = new JFormattedTextField(masktelefone);
		JLabel lblsexo = new JLabel("Sexo: ");
		JTextField txtsexo = new JTextField(10);

		MaskFormatter maskcnpj2 = null;
		try {
			maskcnpj2 = new MaskFormatter("##.###.###/####-##");
		} catch (Exception e) {
			e.printStackTrace();
		}

		MaskFormatter masktelefonemedico = null;
		try {
			masktelefonemedico = new MaskFormatter("(##)####-####");
		} catch (Exception e) {
			e.printStackTrace();
		}

		MaskFormatter maskcnpj = null;
		try {
			maskcnpj = new MaskFormatter("##.###.###/####-##");
		} catch (Exception e) {
			e.printStackTrace();
		}

		JLabel lblcnpj2 = new JLabel("CNPJ Hospital: ");
		JFormattedTextField txtCnpj2 = new JFormattedTextField(maskcnpj);
		JButton btnBuscarHospital = new JButton("Buscar Hospital");
		JLabel lblNomeHospital = new JLabel("Hospital: ");
		JTextField txtNomeHospital = new JTextField(100);
		JLabel lblcpnjhospital2 = new JLabel("CNPJ Hospital: ");
		JFormattedTextField txtcpnj = new JFormattedTextField(maskcnpj2);
		JLabel lbltelefoneHospital = new JLabel("Telefone Hospital: ");
		JFormattedTextField txtTelefoneHospital = new JFormattedTextField(masktelefonemedico);
		JLabel lblrua = new JLabel("Rua: ");
		JTextField txtrua = new JTextField(100);
		JTextField txtnumero = new JTextField(100);
		JLabel lblbairro = new JLabel("Bairro: ");
		JTextField txtbairro = new JTextField(100);
		JLabel lblcidade = new JLabel("Cidade: ");
		JTextField txtcidade = new JTextField(100);

		MaskFormatter maskcpfmedico2 = null;
		try {
			maskcpfmedico2 = new MaskFormatter("###.###.###-##");
		} catch (Exception e) {
			e.printStackTrace();
		}

		MaskFormatter maskcpfmedico = null;
		try {
			maskcpfmedico = new MaskFormatter("###.###.###-##");
		} catch (Exception e) {
			e.printStackTrace();
		}

		JLabel lblcpfMedico2 = new JLabel("CPF Medico: ");
		JFormattedTextField txtCpfMedico2 = new JFormattedTextField(maskcpfmedico);
		JButton btnBuscarMedico = new JButton("Buscar Medico");
		JLabel lblNomeMedico = new JLabel("Nome Medico: ");
		JTextField txtNomeMedico = new JTextField(100);
		JLabel lblcpfmedico = new JLabel("CPF Medico: ");
		JFormattedTextField txtcpfmedico = new JFormattedTextField(maskcpfmedico2);
		JLabel lblcrmMedico = new JLabel("CRM: ");
		JTextField txtcrmMedico = new JTextField(100);
		JLabel lblbespcialidade = new JLabel("Especialidade: ");
		JTextField txtespecialidade = new JTextField(10);
		JLabel lbldiagnostico = new JLabel("Diagnostico: ");
		JTextField txtdiagnostico = new JTextField(500);
		JLabel lbldataconsulta = new JLabel("Data da Consulta: ");
		MaskFormatter maskDataConsulta = null;
		try {
			maskDataConsulta = new MaskFormatter("##/##/#### ##:##");
		} catch (Exception e) {
			e.printStackTrace();
		}
		JFormattedTextField txtdataconsulta = new JFormattedTextField(maskDataConsulta);
		JButton botaoAtualizarConsulta = new JButton("Atualizar Consulta");
		JButton fecharjanela = new JButton("Fechar Janela");

		atualizarConsulta.add(lblidConsulta);
		atualizarConsulta.add(txtidconsulta);
		atualizarConsulta.add(botaoBuscarConsulta);
		atualizarConsulta.add(new JLabel());
		atualizarConsulta.add(lblcpfpaciente2);
		atualizarConsulta.add(txtcpfpaciente2);
		atualizarConsulta.add(botaoBuscarPaciente);
		atualizarConsulta.add(new JLabel());
		atualizarConsulta.add(lblNomePaciente);
		atualizarConsulta.add(txtNomePaciente);
		atualizarConsulta.add(lblcpfPaciente);
		atualizarConsulta.add(txtcpfPaciente);
		atualizarConsulta.add(lbltelefonePaciente);
		atualizarConsulta.add(txtTelefonePaciente);
		atualizarConsulta.add(lblsexo);
		atualizarConsulta.add(txtsexo);
		atualizarConsulta.add(lblcnpj2);
		atualizarConsulta.add(txtCnpj2);
		atualizarConsulta.add(btnBuscarHospital);
		atualizarConsulta.add(new JLabel());
		atualizarConsulta.add(lblNomeHospital);
		atualizarConsulta.add(txtNomeHospital);
		atualizarConsulta.add(lblcpnjhospital2);
		atualizarConsulta.add(txtcpnj);
		atualizarConsulta.add(lbltelefoneHospital);
		atualizarConsulta.add(txtTelefoneHospital);
		atualizarConsulta.add(lblrua);
		atualizarConsulta.add(txtrua);
		atualizarConsulta.add(lblbairro);
		atualizarConsulta.add(txtbairro);
		atualizarConsulta.add(lblcidade);
		atualizarConsulta.add(txtcidade);
		atualizarConsulta.add(lblcpfMedico2);
		atualizarConsulta.add(txtCpfMedico2);
		atualizarConsulta.add(btnBuscarMedico);
		atualizarConsulta.add(new JLabel());
		atualizarConsulta.add(lblNomeMedico);
		atualizarConsulta.add(txtNomeMedico);
		atualizarConsulta.add(lblcpfmedico);
		atualizarConsulta.add(txtcpfmedico);
		atualizarConsulta.add(lblcrmMedico);
		atualizarConsulta.add(txtcrmMedico);
		atualizarConsulta.add(lblbespcialidade);
		atualizarConsulta.add(txtespecialidade);
		atualizarConsulta.add(new JLabel());
		atualizarConsulta.add(new JLabel());
		atualizarConsulta.add(new JLabel());
		atualizarConsulta.add(new JLabel());
		atualizarConsulta.add(lbldiagnostico);
		atualizarConsulta.add(txtdiagnostico);
		atualizarConsulta.add(lbldataconsulta);
		atualizarConsulta.add(txtdataconsulta);
		atualizarConsulta.add(new JLabel());
		atualizarConsulta.add(botaoAtualizarConsulta);
		atualizarConsulta.add(fecharjanela);

		txtcpfPaciente.setBorder(null);
		txtNomePaciente.setBorder(null);
		txtTelefonePaciente.setBorder(null);
		txtsexo.setBorder(null);
		txtNomeHospital.setBorder(null);
		txtTelefoneHospital.setBorder(null);
		txtcpnj.setBorder(null);
		txtTelefoneHospital.setBorder(null);
		txtrua.setBorder(null);
		txtnumero.setBorder(null);
		txtbairro.setBorder(null);
		txtcidade.setBorder(null);
		txtNomeMedico.setBorder(null);
		txtcpfmedico.setBorder(null);
		txtcrmMedico.setBorder(null);
		txtespecialidade.setBorder(null);
		txtrua.setBorder(null);
		txtbairro.setBorder(null);
		txtcidade.setBorder(null);

		txtcpfPaciente.setEditable(false);
		txtNomePaciente.setEditable(false);
		txtTelefonePaciente.setEditable(false);
		txtsexo.setEditable(false);
		txtNomeHospital.setEditable(false);
		txtTelefoneHospital.setEditable(false);
		txtcpnj.setEditable(false);
		txtTelefoneHospital.setEditable(false);
		txtrua.setEditable(false);
		txtnumero.setEditable(false);
		txtbairro.setEditable(false);
		txtcidade.setEditable(false);
		txtNomeMedico.setEditable(false);
		txtcpfmedico.setEditable(false);
		txtcrmMedico.setEditable(false);
		txtespecialidade.setEditable(false);
		txtrua.setEditable(false);
		txtbairro.setEditable(false);
		txtcidade.setEditable(false);

		txtcpfpaciente2.setFont(txtcpfpaciente2.getFont().deriveFont(14f));
		txtNomePaciente.setFont(txtNomePaciente.getFont().deriveFont(14f));
		txtTelefonePaciente.setFont(txtTelefonePaciente.getFont().deriveFont(14f));
		txtsexo.setFont(txtsexo.getFont().deriveFont(14f));
		txtNomeHospital.setFont(txtNomeHospital.getFont().deriveFont(14f));
		txtTelefoneHospital.setFont(txtTelefoneHospital.getFont().deriveFont(14f));
		txtcpnj.setFont(txtcpnj.getFont().deriveFont(14f));
		txtTelefoneHospital.setFont(txtTelefoneHospital.getFont().deriveFont(14f));
		txtrua.setFont(txtrua.getFont().deriveFont(14f));
		txtnumero.setFont(txtnumero.getFont().deriveFont(14f));
		txtbairro.setFont(txtbairro.getFont().deriveFont(14f));
		txtcidade.setFont(txtcidade.getFont().deriveFont(14f));
		txtNomeMedico.setFont(txtNomeMedico.getFont().deriveFont(14f));
		txtcpfmedico.setFont(txtcpfmedico.getFont().deriveFont(14f));
		txtcrmMedico.setFont(txtcrmMedico.getFont().deriveFont(14f));
		txtespecialidade.setFont(txtespecialidade.getFont().deriveFont(14f));
		txtrua.setFont(txtrua.getFont().deriveFont(14f));
		txtbairro.setFont(txtbairro.getFont().deriveFont(14f));
		txtcidade.setFont(txtcidade.getFont().deriveFont(14f));

		botaoBuscarConsulta.addActionListener(ActionListener -> {
			try {
			long idtemp = Long.parseLong(txtidconsulta.getText());
			consulta = controllerConsulta.buscarConsulta(idtemp);
			txtNomePaciente.setText(consulta.getPaciente().getNome());
			txtcpfPaciente.setText(consulta.getPaciente().getCpf());
			txtcpfpaciente2.setText(consulta.getPaciente().getCpf());
			txtTelefonePaciente.setText(consulta.getPaciente().getTelefonePaciente().getNumero());
			txtsexo.setText(consulta.getPaciente().getSexo());
			txtNomeHospital.setText(consulta.getHospital().getNome());
			txtCnpj2.setText(consulta.getHospital().getCnpj());
			txtcpnj.setText(consulta.getHospital().getCnpj());
			txtTelefoneHospital.setText(consulta.getHospital().getTelefoneHospital().getNumerotelefone());
			txtrua.setText(consulta.getHospital().getRua());
			txtbairro.setText(consulta.getHospital().getBairro());
			txtcidade.setText(consulta.getHospital().getCidade());
			txtNomeMedico.setText(consulta.getMedico().getNome());
			txtcpfmedico.setText(consulta.getMedico().getCpf());
			txtCpfMedico2.setText(consulta.getMedico().getCpf());
			txtcrmMedico.setText(consulta.getMedico().getCrm());
			txtespecialidade.setText(consulta.getMedico().getEspecialidade());
			txtdiagnostico.setText(consulta.getDiagnostico());
			txtdataconsulta.setText(consulta.getDataconsulta());
			
			}catch (Exception e) {
				JOptionPane.showMessageDialog(botaoBuscarConsulta, "Consulta não encontrada", "Erro", JOptionPane.ERROR_MESSAGE);
			}

		});

		botaoBuscarPaciente.addActionListener(ActionEvent -> {
			try {
			Paciente paciente = new Paciente();
			paciente = controllerConsulta.buscarDadosPaciente(txtcpfpaciente2.getText());
			txtNomePaciente.setText(paciente.getNome());
			txtcpfPaciente.setText(paciente.getCpf());
			txtTelefonePaciente.setText(paciente.getTelefonePaciente().getNumero());
			txtsexo.setText(paciente.getSexo());
			idtempPaciente = paciente.getId();
			
			}catch (Exception e) {
				JOptionPane.showMessageDialog(botaoBuscarPaciente, "Paciente não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		});

		btnBuscarHospital.addActionListener(ActionEvent -> {
			try {
			Hospital hospital = new Hospital();
			hospital = controllerConsulta.buscarDadosHospital(txtCnpj2.getText());
			txtNomeHospital.setText(hospital.getNome());
			txtcpnj.setText(hospital.getCnpj());
			txtTelefoneHospital.setText(hospital.getTelefoneHospital().getNumerotelefone());
			txtrua.setText(hospital.getRua());
			txtbairro.setText(hospital.getBairro());
			txtcidade.setText(hospital.getCidade());
			idtempHospital = hospital.getIdhospital();
			
			}catch (Exception e) {
				JOptionPane.showMessageDialog(btnBuscarHospital, "Hospital não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		});

		btnBuscarMedico.addActionListener(ActionEvent -> {
			try {
			Medico medico = new Medico();
			medico = controllerConsulta.buscarDadosMedico(txtCpfMedico2.getText());
			txtcpfmedico.setText(medico.getCpf());
			txtNomeMedico.setText(medico.getNome());
			txtcrmMedico.setText(medico.getNome());
			txtespecialidade.setText(medico.getEspecialidade());
			idtempMedico = medico.getId();
			
			}catch (Exception e) {
				JOptionPane.showMessageDialog(btnBuscarMedico, "Medico não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		});

		botaoAtualizarConsulta.addActionListener(ActionEvent -> {
			long idtemp = Long.parseLong(txtidconsulta.getText());
			controllerConsulta.atualizarConsulta(idtemp, txtdiagnostico.getText(), txtdataconsulta.getText(),
					idtempPaciente, idtempMedico, idtempHospital);
		});

		fecharjanela.addActionListener(ActionEvent -> {
			janelaAtualizarConsulta.dispose();
		});
	}

	public void cancelarConsulta() {
		JPanel cancelarConsulta = new JPanel();
		cancelarConsulta.setLayout(new GridLayout(13, 4, 2, 1));
		JFrame janelaCancelarConsulta = new JFrame("Cancelar Consulta");
		janelaCancelarConsulta.setSize(700, 600);
		janelaCancelarConsulta.setLocationRelativeTo(null);
		janelaCancelarConsulta.setVisible(true);
		janelaCancelarConsulta.add(cancelarConsulta);

		MaskFormatter maskcpfpaciente = null;
		try {
			maskcpfpaciente = new MaskFormatter("###.###.###-##");
		} catch (Exception e) {
			e.printStackTrace();
		}

		JLabel lblidConsulta = new JLabel("ID consulta: ");
		JTextField txtidconsulta = new JTextField(100);
		JButton botaoBuscarConsulta = new JButton("Buscar Consulta");
		JLabel lblNomePaciente = new JLabel("Nome Paciente: ");
		JTextField txtNomePaciente = new JTextField(100);
		JLabel lblcpfpaciente2 = new JLabel("CPF Paciente: ");
		JFormattedTextField txtcpfpaciente2 = new JFormattedTextField(maskcpfpaciente);
		JLabel lbltelefonePaciente = new JLabel("Telefone Paciente: ");

		MaskFormatter masktelefone = null;
		try {
			masktelefone = new MaskFormatter("(##)####-####");
		} catch (Exception e) {
			e.printStackTrace();
		}
		JFormattedTextField txtTelefonePaciente = new JFormattedTextField(masktelefone);
		JLabel lblsexo = new JLabel("Sexo: ");
		JTextField txtsexo = new JTextField(10);

		MaskFormatter maskcnpj2 = null;
		try {
			maskcnpj2 = new MaskFormatter("##.###.###/####-##");
		} catch (Exception e) {
			e.printStackTrace();
		}

		MaskFormatter masktelefonemedico = null;
		try {
			masktelefonemedico = new MaskFormatter("(##)####-####");
		} catch (Exception e) {
			e.printStackTrace();
		}

		JLabel lblNomeHospital = new JLabel("Hospital: ");
		JTextField txtNomeHospital = new JTextField(100);
		JLabel lblcpnjhospital2 = new JLabel("CNPJ Hospital: ");
		JFormattedTextField txtcpnj = new JFormattedTextField(maskcnpj2);
		JLabel lbltelefoneHospital = new JLabel("Telefone Hospital: ");
		JFormattedTextField txtTelefoneHospital = new JFormattedTextField(masktelefonemedico);
		JLabel lblrua = new JLabel("Rua: ");
		JTextField txtrua = new JTextField(100);
		JTextField txtnumero = new JTextField(100);
		JLabel lblbairro = new JLabel("Bairro: ");
		JTextField txtbairro = new JTextField(100);
		JLabel lblcidade = new JLabel("Cidade: ");
		JTextField txtcidade = new JTextField(100);

		MaskFormatter maskcpfmedico2 = null;
		try {
			maskcpfmedico2 = new MaskFormatter("###.###.###-##");
		} catch (Exception e) {
			e.printStackTrace();
		}

		JLabel lblNomeMedico = new JLabel("Nome Medico: ");
		JTextField txtNomeMedico = new JTextField(100);
		JLabel lblcpfmedico2 = new JLabel("CPF Medico: ");
		JFormattedTextField txtcpfmedico2 = new JFormattedTextField(maskcpfmedico2);
		JLabel lblcrmMedico = new JLabel("CRM: ");
		JTextField txtcrmMedico = new JTextField(100);
		JLabel lblbespcialidade = new JLabel("Especialidade: ");
		JTextField txtespecialidade = new JTextField(10);
		JLabel lbldiagnostico = new JLabel("Diagnostico: ");
		JTextField txtdiagnostico = new JTextField(500);
		JLabel lbldataconsulta = new JLabel("Data da Consulta: ");
		MaskFormatter maskDataConsulta = null;
		try {
			maskDataConsulta = new MaskFormatter("## / ## / #### - ## : ##");
		} catch (Exception e) {
			e.printStackTrace();
		}
		JFormattedTextField txtdataconsulta = new JFormattedTextField(maskDataConsulta);
		JButton botaoCancelarConsulta = new JButton("Cancelar Consulta");
		JButton fecharjanela = new JButton("Fechar Janela");

		cancelarConsulta.add(lblidConsulta);
		cancelarConsulta.add(txtidconsulta);
		cancelarConsulta.add(botaoBuscarConsulta);
		cancelarConsulta.add(new JLabel());
		cancelarConsulta.add(lblNomePaciente);
		cancelarConsulta.add(txtNomePaciente);
		cancelarConsulta.add(lblcpfpaciente2);
		cancelarConsulta.add(txtcpfpaciente2);
		cancelarConsulta.add(lbltelefonePaciente);
		cancelarConsulta.add(txtTelefonePaciente);
		cancelarConsulta.add(lblsexo);
		cancelarConsulta.add(txtsexo);
		cancelarConsulta.add(new JLabel());
		cancelarConsulta.add(new JLabel());
		cancelarConsulta.add(new JLabel());
		cancelarConsulta.add(new JLabel());
		cancelarConsulta.add(lblNomeHospital);
		cancelarConsulta.add(txtNomeHospital);
		cancelarConsulta.add(lblcpnjhospital2);
		cancelarConsulta.add(txtcpnj);
		cancelarConsulta.add(lbltelefoneHospital);
		cancelarConsulta.add(txtTelefoneHospital);
		cancelarConsulta.add(lblrua);
		cancelarConsulta.add(txtrua);
		cancelarConsulta.add(lblbairro);
		cancelarConsulta.add(txtbairro);
		cancelarConsulta.add(lblcidade);
		cancelarConsulta.add(txtcidade);
		cancelarConsulta.add(new JLabel());
		cancelarConsulta.add(new JLabel());
		cancelarConsulta.add(new JLabel());
		cancelarConsulta.add(new JLabel());
		cancelarConsulta.add(lblNomeMedico);
		cancelarConsulta.add(txtNomeMedico);
		cancelarConsulta.add(lblcpfmedico2);
		cancelarConsulta.add(txtcpfmedico2);
		cancelarConsulta.add(lblcrmMedico);
		cancelarConsulta.add(txtcrmMedico);
		cancelarConsulta.add(lblbespcialidade);
		cancelarConsulta.add(txtespecialidade);
		cancelarConsulta.add(new JLabel());
		cancelarConsulta.add(new JLabel());
		cancelarConsulta.add(new JLabel());
		cancelarConsulta.add(new JLabel());
		cancelarConsulta.add(lbldiagnostico);
		cancelarConsulta.add(txtdiagnostico);
		cancelarConsulta.add(lbldataconsulta);
		cancelarConsulta.add(txtdataconsulta);
		cancelarConsulta.add(new JLabel());
		cancelarConsulta.add(botaoCancelarConsulta);
		cancelarConsulta.add(fecharjanela);

		txtcpfpaciente2.setBorder(null);
		txtNomePaciente.setBorder(null);
		txtTelefonePaciente.setBorder(null);
		txtsexo.setBorder(null);
		txtNomeHospital.setBorder(null);
		txtTelefoneHospital.setBorder(null);
		txtcpnj.setBorder(null);
		txtTelefoneHospital.setBorder(null);
		txtrua.setBorder(null);
		txtnumero.setBorder(null);
		txtbairro.setBorder(null);
		txtcidade.setBorder(null);
		txtNomeMedico.setBorder(null);
		txtcpfmedico2.setBorder(null);
		txtcrmMedico.setBorder(null);
		txtespecialidade.setBorder(null);
		txtrua.setBorder(null);
		txtbairro.setBorder(null);
		txtcidade.setBorder(null);
		txtdiagnostico.setBorder(null);
		txtdataconsulta.setBorder(null);

		txtcpfpaciente2.setEditable(false);
		txtNomePaciente.setEditable(false);
		txtTelefonePaciente.setEditable(false);
		txtsexo.setEditable(false);
		txtNomeHospital.setEditable(false);
		txtTelefoneHospital.setEditable(false);
		txtcpnj.setEditable(false);
		txtTelefoneHospital.setEditable(false);
		txtrua.setEditable(false);
		txtnumero.setEditable(false);
		txtbairro.setEditable(false);
		txtcidade.setEditable(false);
		txtNomeMedico.setEditable(false);
		txtcpfmedico2.setEditable(false);
		txtcrmMedico.setEditable(false);
		txtespecialidade.setEditable(false);
		txtrua.setEditable(false);
		txtbairro.setEditable(false);
		txtcidade.setEditable(false);
		txtdiagnostico.setEditable(false);
		txtdataconsulta.setEditable(false);

		txtcpfpaciente2.setFont(txtcpfpaciente2.getFont().deriveFont(14f));
		txtNomePaciente.setFont(txtNomePaciente.getFont().deriveFont(14f));
		txtTelefonePaciente.setFont(txtTelefonePaciente.getFont().deriveFont(14f));
		txtsexo.setFont(txtsexo.getFont().deriveFont(14f));
		txtNomeHospital.setFont(txtNomeHospital.getFont().deriveFont(14f));
		txtTelefoneHospital.setFont(txtTelefoneHospital.getFont().deriveFont(14f));
		txtcpnj.setFont(txtcpnj.getFont().deriveFont(14f));
		txtTelefoneHospital.setFont(txtTelefoneHospital.getFont().deriveFont(14f));
		txtrua.setFont(txtrua.getFont().deriveFont(14f));
		txtnumero.setFont(txtnumero.getFont().deriveFont(14f));
		txtbairro.setFont(txtbairro.getFont().deriveFont(14f));
		txtcidade.setFont(txtcidade.getFont().deriveFont(14f));
		txtNomeMedico.setFont(txtNomeMedico.getFont().deriveFont(14f));
		txtcpfmedico2.setFont(txtcpfmedico2.getFont().deriveFont(14f));
		txtcrmMedico.setFont(txtcrmMedico.getFont().deriveFont(14f));
		txtespecialidade.setFont(txtespecialidade.getFont().deriveFont(14f));
		txtrua.setFont(txtrua.getFont().deriveFont(14f));
		txtbairro.setFont(txtbairro.getFont().deriveFont(14f));
		txtcidade.setFont(txtcidade.getFont().deriveFont(14f));
		txtdiagnostico.setFont(txtdiagnostico.getFont().deriveFont(14f));
		txtdataconsulta.setFont(txtdataconsulta.getFont().deriveFont(14f));

		botaoBuscarConsulta.addActionListener(ActionListener -> {
			idtemp = Long.parseLong(txtidconsulta.getText());
			consulta = controllerConsulta.buscarConsulta(idtemp);
			txtNomePaciente.setText(consulta.getPaciente().getNome());
			txtcpfpaciente2.setText(consulta.getPaciente().getCpf());
			txtTelefonePaciente.setText(consulta.getPaciente().getTelefonePaciente().getNumero());
			txtsexo.setText(consulta.getPaciente().getSexo());
			txtNomeHospital.setText(consulta.getHospital().getNome());
			txtcpnj.setText(consulta.getHospital().getCnpj());
			txtTelefoneHospital.setText(consulta.getHospital().getTelefoneHospital().getNumerotelefone());
			txtrua.setText(consulta.getHospital().getRua());
			txtbairro.setText(consulta.getHospital().getBairro());
			txtcidade.setText(consulta.getHospital().getCidade());
			txtNomeMedico.setText(consulta.getMedico().getNome());
			txtcpfmedico2.setText(consulta.getMedico().getCpf());
			txtcrmMedico.setText(consulta.getMedico().getCrm());
			txtespecialidade.setText(consulta.getMedico().getEspecialidade());
			txtdiagnostico.setText(consulta.getDiagnostico());
			txtdataconsulta.setText(consulta.getDataconsulta());

		});

		botaoCancelarConsulta.addActionListener(ActionEvent -> {
			controllerConsulta.cancelarConsulta(idtemp);
		});

		fecharjanela.addActionListener(ActionEvent -> {
			janelaCancelarConsulta.dispose();
		});
	}
	
	public void relatorioConsulta() {
		JTextField txtId = new JTextField(100);
		JTextField txtNomePaciente = new JTextField(100);
		JTextField txtcpfPaciente = new JTextField(100);
		JTextField txtTelefonePaciente = new JTextField(100);
		JTextField txtNomeMedico = new JTextField(100);
		JTextField txtCrmMedico = new JTextField(100);
		JTextField txtNomeHospital = new JTextField(100);
		JTextField txtCnpjHospital = new JTextField(100);
		JTextField txtDataConsulta = new JTextField(100);
		JTextField txtDiagnostico = new JTextField(100);

		DefaultTableModel tabelaConsulta = new DefaultTableModel(null,
				new String[] { "ID", "Paciente", "CPF Paciente", "Telefone Paciente", "Nome Medico", "CRM Medico",
						"Nome Hospital", "CNPJ Hospital", "Data Consulta", "Diagnostico" });

		String[] elementosvazio = { "Vazio", "Vazio", "Vazio", "Vazio", "Vazio", "Vazio", "Vazio", "Vazio", "Vazio",
				"Vazio", "Vazio" };

		ArrayList<Consulta> list = controllerConsulta.relatorioConsultas();

		if (list == null) {
			tabelaConsulta.addRow(elementosvazio);

		} else {
			for (Consulta consulta : list) {
				String idtemp = Long.toString(consulta.getIdconsulta());
				txtId.setText(idtemp);
				txtNomePaciente.setText(consulta.getPaciente().getNome());
				txtcpfPaciente.setText(consulta.getPaciente().getCpf());
				txtTelefonePaciente.setText(consulta.getPaciente().getTelefonePaciente().getNumero());
				txtNomeMedico.setText(consulta.getMedico().getNome());
				txtCrmMedico.setText(consulta.getMedico().getCrm());
				txtNomeHospital.setText(consulta.getHospital().getNome());
				txtCnpjHospital.setText(consulta.getHospital().getCnpj());
				txtDataConsulta.setText(consulta.getDataconsulta());
				txtDiagnostico.setText(consulta.getDiagnostico());

				tabelaConsulta.addRow(new String[] { txtId.getText(), txtNomePaciente.getText(), txtcpfPaciente.getText(),
								txtTelefonePaciente.getText(), txtNomeMedico.getText(), txtCrmMedico.getText(),
								txtNomeHospital.getText(), txtCnpjHospital.getText(), txtDataConsulta.getText(),
								txtDiagnostico.getText() });
			}
		}

		JPanel relatorioConsulta = new JPanel();
		relatorioConsulta.setLayout(new FlowLayout());
		JTable tabela = new JTable(tabelaConsulta);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(0);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(40);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(50);
		
		tabela.setPreferredScrollableViewportSize(new Dimension(1366, 768));
		tabela.setFillsViewportHeight(true);
		JScrollPane scroll = new JScrollPane(tabela);
		tabela.getTableHeader().setReorderingAllowed(false);
		JFrame jRelatorioConsulta = new JFrame("Relatorio Consultas");
		jRelatorioConsulta.add(relatorioConsulta);
		relatorioConsulta.add(scroll);
		jRelatorioConsulta.setVisible(true);
		jRelatorioConsulta.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
}
