package book;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class WeatherQueryLambda {
    private final ObjectMapper objectMapper = new ObjectMapper()
            .configure(
                    DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
                    false
            );
    private final AmazonDynamoDB dynamoDB = AmazonDynamoDBClientBuilder.defaultClient();
    private final String tableName = System.getenv("LOCATIONS_TABLE");

    private static final String DEFAULT_LIMIT = "50";

    public ApiGatewayResponse handler(ApiGatewayRequest request) throws IOException {
        String limitParam = request.queryParams == null
                ? DEFAULT_LIMIT
                : request.queryParams.getOrDefault("limit", DEFAULT_LIMIT);
        int limit = Integer.parseInt(limitParam);
        ScanRequest scanRequest = new ScanRequest()
                .withTableName(tableName)
                .withLimit(limit);
        ScanResult scanResult = dynamoDB.scan(scanRequest);

        List<WeatherEvent> events = scanResult.getItems().stream()
                .map(item -> new WeatherEvent(
                        item.get("locationName").getS(),
                        Long.parseLong(item.get("temperature").getN()),
                        Long.parseLong(item.get("timestamp").getN()),
                        Double.parseDouble(item.get("latitude").getN()),
                        Double.parseDouble(item.get("longitude").getN())
                ))
                .collect(Collectors.toList());
        String json = objectMapper.writeValueAsString(events);
        return new ApiGatewayResponse(200, json);
    }
}
