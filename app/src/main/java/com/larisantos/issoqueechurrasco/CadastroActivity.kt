package com.larisantos.issoqueechurrasco

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.larisantos.issoqueechurrasco.databinding.ActivityCadastroBinding

class CadastroActivity : AppCompatActivity() {


    private val binding by lazy {
        ActivityCadastroBinding.inflate(layoutInflater)
    }

    private lateinit var nome: String
    private lateinit var email: String
    private lateinit var senha: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        inicializarToolbar()
        inicializarEventosClique()


    }


    private fun inicializarEventosClique() {
        binding.btnCadastrar.setOnClickListener {
            if (validarCampos()){
                cadastrarUsuario(nome, email, senha)
        }

    }


}

    private fun cadastrarUsuario(nome: String, email: String, senha: String) {

    }

    private fun validarCampos(): Boolean {

            nome = binding.editNome.text.toString()
            email = binding.editEmail.text.toString()
            senha = binding.editSenha.text.toString()

            if (nome.isNotEmpty()){

                binding.textInputLayoutNome.error = null

                if (email.isNotEmpty()){

                    binding.textInputLayoutEmail.error = null

                    if (senha.isNotEmpty()){

                        binding.textInputLayoutSenha.error = null
                        return true


                    }else{
                        binding.textInputLayoutSenha.error = "Preencha sua senha!"
                        return false
                    }

                }else{
                    binding.textInputLayoutEmail.error = "Preencha o seu e-mail!"
                    return false
                }

            }else{
                binding.textInputLayoutNome.error = "Preencha o seu nome!"
                return false

            }

        }



    private fun inicializarToolbar() {
        val toolbar = binding.includeToobar.tbPrincipal
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            title = "Faça o seu cadastro"
            setDisplayHomeAsUpEnabled(true)
        }
    }
}


