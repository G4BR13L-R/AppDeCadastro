package com.gabriel.appdecadastro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button botaoProdutos;
    Button botaoClientes;
    Button botaoFornecedores;
    Button botaoSair;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoProdutos = findViewById(R.id.botaoProdutos);
        botaoClientes = findViewById(R.id.botaoClientes);
        botaoFornecedores = findViewById(R.id.botaoFornecedores);
        botaoSair = findViewById(R.id.botaoSair);

        botaoProdutos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, SegundaActivity.class);

                intent.putExtra("opcao", 0);

                startActivity(intent);
            }
        });

        botaoClientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, SegundaActivity.class);

                intent.putExtra("opcao", 1);

                startActivity(intent);
            }
        });

        botaoFornecedores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, SegundaActivity.class);

                intent.putExtra("opcao", 2);

                startActivity(intent);
            }
        });

        botaoSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });

    }
}