package logs;

public record LoggingMsg() {

    public static final String REGISTER_SUCCESS =
            "Registro exitoso de usuario";
    public static final String REGISTER_FAIL =
            "Intento fallido de registro de usuario";
    public static final String LOGIN_SUCCESS =
            "Autenticación de usuario exitosa";
    public static final String LOGIN_FAIL =
            "Intento fallido de autenticación de usuario";
}
