package com.example.viewlogin;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class LoginViewModel extends AndroidViewModel {

    Executor executor;

    SimuladorLogin simuladorLogin;

    MutableLiveData<String> mensaje = new MutableLiveData<>();

    public LoginViewModel(@NonNull Application application) {
        super(application);

        executor = Executors.newSingleThreadExecutor();
        simuladorLogin = new SimuladorLogin();

    }

    public void verificar(String email, String password) {

        final SimuladorLogin.Solicitud solicitud = new SimuladorLogin.Solicitud(email, password);

        executor.execute(new Runnable() {
            @Override
            public void run() {

                simuladorLogin.verificar(solicitud, new SimuladorLogin.Callback() {
                    @Override
                    public void cuandoLosDatosSonCorrectos(String textoVerificacion) {
                        mensaje.postValue(textoVerificacion);
                    }

                    @Override
                    public void cuandoLosDatosSonIncorrectos(String textoVerificacion) {
                        mensaje.postValue(textoVerificacion);
                    }
                });
            }
        });

    }

}
