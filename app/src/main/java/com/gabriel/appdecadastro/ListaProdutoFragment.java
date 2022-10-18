package com.gabriel.appdecadastro;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.gabriel.appdecadastro.bancoDeDados.DBHelper;
import com.gabriel.appdecadastro.bancoDeDados.ProdutoDB;
import com.gabriel.appdecadastro.entidades.Produto;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListaProdutoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListaProdutoFragment extends Fragment {

    ListView listaDados;
    static List<Produto> listaProdutos;
    static ArrayAdapter adapter;

    static ProdutoDB produtoDB;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ListaProdutoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListaProdutoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListaProdutoFragment newInstance(String param1, String param2) {
        ListaProdutoFragment fragment = new ListaProdutoFragment();
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
        View view = inflater.inflate(R.layout.fragment_lista_produto, container, false);

        listaDados = view.findViewById(R.id.listaProduto);

        DBHelper db = new DBHelper(getActivity());
        produtoDB = new ProdutoDB(db);

        listaProdutos = new ArrayList<>();
        adapter = new ArrayAdapter(getActivity(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listaProdutos);
        listaDados.setAdapter(adapter);

        atualizarDadosProduto();

        return view;
    }

    protected static void atualizarDadosProduto() {
        produtoDB.listar(listaProdutos);
        adapter.notifyDataSetChanged();
    }
}