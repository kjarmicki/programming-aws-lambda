package book;

import java.util.HashMap;
import java.util.Map;

public class ApiGatewayRequest {
    public String body;
    public Map<String, String> queryParams = new HashMap<>();
}
