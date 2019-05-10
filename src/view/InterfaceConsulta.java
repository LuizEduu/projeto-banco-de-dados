package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
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
			masktelefone = new MaskFormatter("(##)####-####");
		} catch (Exception e) {
			e.printStackTrace();
		}
		JFormattedTextField txtTelefonePaciente = new JFormattedTextField(masktelefone);
		JLabel lblsexo = new JLabel("Sexo: ");
		JTextField txtsexo = new JTextField(10);

		MaskFormatter maskcnpj = null;
		try {
			maskcnpj = new MaskFormatter("##.###.###/####-##");
		} catch (Exception e) {
			e.printStackTrace();
		}

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
			maskcpfmedico = new MaskFormatter("###.###.###-##");
		} catch (Exception e) {
			e.printStackTrace();
		}

		MaskFormatter maskcpfmedico2 = null;
		try {
			maskcpfmedico2 = new MaskFormatter("###.###.###-##");
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
			paciente = controllerConsulta.buscarDadosPaciente(txtcpfPaciente.getText());
			txtNomePaciente.setText(paciente.getNome());
			txtcpfpaciente2.setText(paciente.getCpf());
			txtTelefonePaciente.setText(paciente.getTelefonePaciente().getNumero());
			txtsexo.setText(paciente.getSexo());
			idtempPaciente = paciente.getId();

		});

		botaoBuscarHospital.addActionListener(ActionEvent -> {
			hospital = controllerConsulta.buscarDadosHospital(txtcpnjHospital.getText());
			txtNomeHospital.setText(hospital.getNome());
			txtcpnj.setText(hospital.getCnpj());
			txtTelefoneHospital.setText(hospital.getTelefoneHospital().getNumerotelefone());
			txtrua.setText(hospital.getRua());
			txtbairro.setText(hospital.getBairro());
			txtcidade.setText(hospital.getCidade());
			idtempHospital = hospital.getIdhospital();

		});

		botaobuscarMedico.addActionListener(ActionEvent -> {
			medico = controllerConsulta.buscarDadosMedico(txtcpfmedico.getText());
			txtNomeMedico.setText(medico.getNome());
			txtcpfmedico2.setText(medico.getCpf());
			txtcrmMedico.setText(medico.getCrm());
			txtespecialidade.setText(medico.getEspecialidade());
			idtempMedico = medico.getId();
		});

		btnagendarConsulta.addActionListener(ActionEvent -> {
			controllerConsulta.agendarConsulta(txtdiagnostico.getText(), txtdataconsulta.getText(), idtempPaciente,
					idtempMedico, idtempHospital);
		});

		fecharjanela.addActionListener(ActionEvent -> {
			janelaEditarConsulta.dispose();
		});
	}

	public void editarConsulta() {
		JPanel atualizarConsulta = new JPanel();
		atualizarConsulta.setLayout(new GridLayout(13, 4, 2, 1));
		JFrame janelaAtualizarConsulta = new JFrame("Atualizar Consulta");
		janelaAtualizarConsulta.setSize(700, 600);
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
		JButton botaoAtualizarConsulta = new JButton("Atualizar Consulta");
		JButton fecharjanela = new JButton("Fechar Janela");

		atualizarConsulta.add(lblidConsulta);
		atualizarConsulta.add(txtidconsulta);
		atualizarConsulta.add(botaoBuscarConsulta);
		atualizarConsulta.add(new JLabel());
		atualizarConsulta.add(lblNomePaciente);
		atualizarConsulta.add(txtNomePaciente);
		atualizarConsulta.add(lblcpfpaciente2);
		atualizarConsulta.add(txtcpfpaciente2);
		atualizarConsulta.add(lbltelefonePaciente);
		atualizarConsulta.add(txtTelefonePaciente);
		atualizarConsulta.add(lblsexo);
		atualizarConsulta.add(txtsexo);
		atualizarConsulta.add(new JLabel());
		atualizarConsulta.add(new JLabel());
		atualizarConsulta.add(new JLabel());
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
		atualizarConsulta.add(new JLabel());
		atualizarConsulta.add(new JLabel());
		atualizarConsulta.add(new JLabel());
		atualizarConsulta.add(new JLabel());
		atualizarConsulta.add(lblNomeMedico);
		atualizarConsulta.add(txtNomeMedico);
		atualizarConsulta.add(lblcpfmedico2);
		atualizarConsulta.add(txtcpfmedico2);
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

		botaoBuscarConsulta.addActionListener(ActionListener -> {
			long idtemp = Long.parseLong(txtidconsulta.getText());
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

		botaoAtualizarConsulta.addActionListener(ActionEvent -> {
			controllerConsulta.atualizarConsulta(txtdiagnostico.getText(), txtdataconsulta.getText(), idtempPaciente,
					idtempMedico, idtempHospital);
		});

		fecharjanela.addActionListener(ActionEvent -> {
			janelaAtualizarConsulta.dispose();
		});
	}
}
