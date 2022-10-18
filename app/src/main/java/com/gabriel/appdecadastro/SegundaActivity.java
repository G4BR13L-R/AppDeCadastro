package com.gabriel.appdecadastro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SegundaActivity extends AppCompatActivity {

    Button botaoListagem;
    Button botaoCadastrar;

    Integer opcao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        opcao = getIntent().getIntExtra("opcao", -1);

        if (opcao == -1) {
            onBackPressed();
        } else {
            botaoListagem = findViewById(R.id.botaoListagem);
            botaoCadastrar = findViewById(R.id.botaoCadastrar);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            switch (opcao) {
                case 0: {
                    transaction.add(R.id.frameSegundaActivity, new ListaProdutoFragment());
                    break;
                }

                case 1: {
                    transaction.add(R.id.frameSegundaActivity, new ListaClienteFragment());
                    break;
                }

                case 2: {
                    transaction.add(R.id.frameSegundaActivity, new ListaFornecedorFragment());
                    break;
                }
            }
            transaction.commit();

            botaoListagem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (opcao) {
                        case 0: {
                            getSupportFragmentManager().beginTransaction().replace(R.id.frameSegundaActivity, new ListaProdutoFragment()).commit();
                            break;
                        }

                        case 1: {
                            getSupportFragmentManager().beginTransaction().replace(R.id.frameSegundaActivity, new ListaClienteFragment()).commit();
                            break;
                        }

                        case 2: {
                            getSupportFragmentManager().beginTransaction().replace(R.id.frameSegundaActivity, new ListaFornecedorFragment()).commit();
                            break;
                        }
                    }
                }
            });

            botaoCadastrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (opcao) {
                        case 0: {
                            getSupportFragmentManager().beginTransaction().replace(R.id.frameSegundaActivity, new CadastroProdutoFragment()).commit();
                            break;
                        }

                        case 1: {
                            getSupportFragmentManager().beginTransaction().replace(R.id.frameSegundaActivity, new CadastroClienteFragment()).commit();
                            break;
                        }

                        case 2: {
                            getSupportFragmentManager().beginTransaction().replace(R.id.frameSegundaActivity, new CadastroFornecedorFragment()).commit();
                            break;
                        }
                    }
                }
            });

        }
    }
}