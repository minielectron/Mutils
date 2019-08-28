package electrophile.mutils;

public class NetworkStatusCode {
    private NetworkStatusCode(){}
    public static final int OK = 200;
    public static final int CREATED = 201;
    public static final int ACCEPTED = 202;
    public static final int NON_AUTHORITATIVE_INFORMATION = 203;
    public static final int NO_CONTENT = 204;
    public static final int RESET_CONTENT = 205;
    public static final int PARTIAL_CONTENT = 206;
    public static final int MOVED_PERMANENTALY = 301;
    public static final int NOT_MODIFIED = 304;
    public static final int UNAUTHORIZED = 401;
    public static final int NOT_FOUND = 404;
    public static final int FORBIDDEN = 403;
    public static final int BAD_REQUEST = 400;
    public static final int INTERNAL_SERVER_ERROR = 500;

    public static String getStatusString(int code){
        switch (code){
            case OK: return "STATUS_OK";
            case CREATED : return "CREATED-201";
            case ACCEPTED : return "ACCEPTED-"+ACCEPTED;
            case NON_AUTHORITATIVE_INFORMATION : return "NON_AUTHORITATIVE_INFORMATION-"+NON_AUTHORITATIVE_INFORMATION;
            case NO_CONTENT : return "NO_CONTENT-"+NO_CONTENT;
            case RESET_CONTENT : return "RESET_CONTENT-"+RESET_CONTENT;
            case PARTIAL_CONTENT : return "PARTIAL_CONTENT-"+PARTIAL_CONTENT;
            case MOVED_PERMANENTALY : return "MOVED_PERMANENTALY-"+MOVED_PERMANENTALY;
            case NOT_FOUND : return "NOT_FOUND-"+NOT_FOUND;
            case FORBIDDEN : return "FORBIDDEN-"+FORBIDDEN;
            case BAD_REQUEST : return "BAD_REQUEST-"+BAD_REQUEST;
            case INTERNAL_SERVER_ERROR : return "CREATED-"+INTERNAL_SERVER_ERROR;
            case UNAUTHORIZED : return "UNAUTHORIZED-"+UNAUTHORIZED;
            case NOT_MODIFIED : return "NOT_MODIFIED-"+NOT_MODIFIED;
        }
        return "NOT_DEFINED_STATUS_CODE : "+code;
    }
}
