package book;

public class EnvVarLambda {
    public void handler(Object event) {
        String envVariable = System.getenv("ENV_VARIABLE");
        if (envVariable == null || envVariable.isEmpty()) {
            System.out.println("env variable not set");
        } else {
            System.out.println("env variable set to " + envVariable);
        }
    }
}
