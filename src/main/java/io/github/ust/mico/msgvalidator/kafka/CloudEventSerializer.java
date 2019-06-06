package io.github.ust.mico.msgvalidator.kafka;

import com.fasterxml.jackson.databind.JsonNode;
import io.cloudevents.json.Json;
import org.apache.kafka.common.serialization.Serializer;

import java.nio.charset.StandardCharsets;
import java.util.Map;

public class CloudEventSerializer implements Serializer<MicoCloudEventImpl<JsonNode>> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public byte[] serialize(String topic, MicoCloudEventImpl<JsonNode> data) {
        if (data == null)
            return null;
        else {
            return Json.encode(data).getBytes(StandardCharsets.UTF_8);
        }
    }

    @Override
    public void close() {

    }
}
