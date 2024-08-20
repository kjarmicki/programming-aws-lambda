package book;

public class PojoLambda {
    public PojoOutput handler(PojoInput input) {
        return new PojoOutput("Request was " + input.getA());
    }

    public static class PojoInput {
        private String a;

        public void setA(String a) {
            this.a = a;
        }

        public String getA() {
            return this.a;
        }
    }

    public static class PojoOutput {
        private final String b;

        public PojoOutput(String b) {
            this.b = b;
        }

        public String getB() {
            return b;
        }
    }
}
