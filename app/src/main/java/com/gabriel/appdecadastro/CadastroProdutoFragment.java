package com.gabriel.appdecadastro;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gabriel.appdecadastro.bancoDeDados.DBHelper;
import com.gabriel.appdecadastro.bancoDeDados.ProdutoDB;
import com.gabriel.appdecadastro.entidades.Produto;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CadastroProdutoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CadastroProdutoFragment extends Fragment {

    EditText campoNomeProduto;
    EditText campoMarca;
    EditText campoQuantidade;
    EditText campoPreco;

    Button botaoSalvar;

    ProdutoDB produtoDB;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CadastroProdutoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CadastroProdutoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CadastroProdutoFragment newInstance(String param1, String param2) {
        CadastroProdutoFragment fragment = new CadastroProdutoFragment();
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
        View view = inflater.inflate(R.layout.fragment_cadastro_produto, container, false);

        DBHelper db = new DBHelper(getActivity());
        produtoDB = new ProdutoDB(db);

        campoNomeProduto = view.findViewById(R.id.nomeProduto);
        campoMarca = view.findViewById(R.id.marcaProduto);
        campoQuantidade = view.findViewById(R.id.quantidadeProduto);
        campoPreco = view.findViewById(R.id.precoProduto);
        botaoSalvar = view.findViewById(R.id.salvarProduto);

        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Produto produto = new Produto();

                produto.setNome(campoNomeProduto.getText().toString());
                produto.setMarca(campoMarca.getText().toString());
                produto.setQuantidade(Integer.parseInt(campoQuantidade.getText().toString()));
                produto.setPreco(Float.parseFloat(campoPreco.getText().toString()));

                produtoDB.inserir(produto);
                campoNomeProduto.setText("");
                campoMarca.setText("");
                campoQuantidade.setText("");
                campoPreco.setText("");
                ListaProdutoFragment.atualizarDadosProduto();
                Toast.makeText(getActivity(), "Salvo com Sucesso!", Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }
}