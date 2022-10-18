package com.gabriel.appdecadastro;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.gabriel.appdecadastro.bancoDeDados.DBHelper;
import com.gabriel.appdecadastro.bancoDeDados.FornecedorDB;
import com.gabriel.appdecadastro.entidades.Fornecedor;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListaFornecedorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListaFornecedorFragment extends Fragment {

    ListView listaDados;
    static List<Fornecedor> listaForneceres;
    static ArrayAdapter adapter;

    static FornecedorDB fornecedorDB;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ListaFornecedorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListaFornecedorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListaFornecedorFragment newInstance(String param1, String param2) {
        ListaFornecedorFragment fragment = new ListaFornecedorFragment();
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
        View view = inflater.inflate(R.layout.fragment_lista_fornecedor, container, false);

        listaDados = view.findViewById(R.id.listaFornecedor);

        DBHelper db = new DBHelper(getActivity());
        fornecedorDB = new FornecedorDB(db);

        listaForneceres = new ArrayList<>();
        adapter = new ArrayAdapter(getActivity(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listaForneceres);
        listaDados.setAdapter(adapter);

        atualizarDadosFornecedor();

        return view;
    }

    protected static void atualizarDadosFornecedor() {
        fornecedorDB.listar(listaForneceres);
        adapter.notifyDataSetChanged();
    }
}