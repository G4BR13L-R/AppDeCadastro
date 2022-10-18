package com.gabriel.appdecadastro;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gabriel.appdecadastro.bancoDeDados.ClienteDB;
import com.gabriel.appdecadastro.bancoDeDados.DBHelper;
import com.gabriel.appdecadastro.entidades.Cliente;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CadastroClienteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CadastroClienteFragment extends Fragment {

    EditText campoNome;
    EditText campoTelefone;
    EditText campoEmail;

    Button botaoSalvar;

    ClienteDB clienteDB;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CadastroClienteFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CadastroClienteFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CadastroClienteFragment newInstance(String param1, String param2) {
        CadastroClienteFragment fragment = new CadastroClienteFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cadastro_cliente, container, false);

        DBHelper db = new DBHelper(getActivity());
        clienteDB = new ClienteDB(db);

        campoNome = view.findViewById(R.id.nomeCliente);
        campoTelefone = view.findViewById(R.id.telefoneCliente);
        campoEmail = view.findViewById(R.id.emailCliente);
        botaoSalvar = view.findViewById(R.id.salvarCliente);

        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cliente cliente = new Cliente();

                cliente.setNome(campoNome.getText().toString());
                cliente.setTelefone(campoTelefone.getText().toString());
                cliente.setEmail(campoEmail.getText().toString());

                clienteDB.inserir(cliente);
                campoNome.setText("");
                campoTelefone.setText("");
                campoEmail.setText("");
                ListaClienteFragment.atualizarDadosCliente();
                Toast.makeText(getActivity(), "Salvo com Sucesso!", Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }
}