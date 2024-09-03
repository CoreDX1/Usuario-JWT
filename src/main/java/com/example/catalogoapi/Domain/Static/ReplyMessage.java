package com.example.catalogoapi.Domain.Static;

public class ReplyMessage {
    private ReplyMessage() {
    } // Prevent instantiation

    public static class Success {
        public static final String QUERY = "Consulta exitosa";
        public static final String SAVE = "Se registró correctamente";
        public static final String UPDATE = "Se actualizó correctamente";
        public static final String DELETE = "Se eliminó correctamente";
        public static final String ACTIVATE = "El registro ha sido activado";
        public static final String TOKEN = "Token generado correctamente";
    }

    public static class Error {
        public static final String QUERY_EMPTY = "No se encontraron registros";
        public static final String EXISTS = "El registro ya existe";
        public static final String FAILED = "Operación fallida";
        public static final String TOKEN_ERROR = "El usuario y/o contraseña es incorrecta, compruébala";
        public static final String INTERNAL_SERVER_ERROR = "Error interno del servidor";
        public static final String NOT_FOUND = "Recurso no encontrado";
        public static final String BAD_REQUEST = "Solicitud incorrecta";
        public static final String UNAUTHORIZED = "Acceso no autorizado";
        public static final String FORBIDDEN = "Acción no permitida";
    }

    public static class Validate {
        public static final String VALIDATE_EMAIL = "El email ya existe";
        public static final String VALIDATE_PASSWORD = "Las contraseñas no coinciden";
        public static final String VALIDATE_ERROR = "Errores de validación";
    }

    public static class Info {
        public static final String LOGOUT = "Sesión cerrada correctamente";
        public static final String LOGIN = "Sesión iniciada correctamente";
    }
}
