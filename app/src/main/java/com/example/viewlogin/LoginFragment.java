package com.example.viewlogin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.viewlogin.databinding.FragmentLoginBinding;

public class LoginFragment extends Fragment {
    private FragmentLoginBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentLoginBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final LoginViewModel loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        binding.botonVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = (binding.email.getText().toString());
                String password = (binding.password.getText().toString());

                loginViewModel.verificar(email, password);
            }
        });

        loginViewModel.mensaje.observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String mensaje) {
                binding.textoVerificacion.setText(mensaje);
            }
        });
    }
}