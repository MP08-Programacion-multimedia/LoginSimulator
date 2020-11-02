package com.example.viewlogin;

public class SimuladorLogin {

    public static class Solicitud {

        public String email;
        public String password;

        public Solicitud(String email, String password) {

            this.email = email;
            this.password = password;

        }
    }

    interface Callback {
        void cuandoLosDatosSonCorrectos(String textoVerificacion);
        void cuandoLosDatosSonIncorrectos(String textoVerificacion);
    }

    public void verificar(Solicitud solicitud, Callback callback) {
        double interes = 0;
        try {
            Thread.sleep(1000);   // simular operacion de larga duracion (10s)
            interes = 0.01605;
        } catch (InterruptedException e) {}

        String mensaje = "";

        if (solicitud.email.equals("email@gmail.com") && solicitud.password.equals("password")) {
            mensaje = "Bienvenido";
            callback.cuandoLosDatosSonCorrectos(mensaje);
        } else {
            mensaje = "Los datos introcidos no son correctos";
            callback.cuandoLosDatosSonIncorrectos(mensaje);
        }



    }

}
