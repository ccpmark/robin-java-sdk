package com.robinpowered.sdk.model.adapter;

import com.google.gson.*;
import org.joda.time.DateTimeZone;

import java.lang.reflect.Type;

/**
 * Handles adapting {@link org.joda.time.DateTimeZone} from string representations.
 */
public class JodaDateTimeZoneAdapter implements JsonDeserializer<DateTimeZone>, JsonSerializer<DateTimeZone> {

    @Override
    public JsonElement serialize(DateTimeZone src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.toString());
    }

    @Override
    public DateTimeZone deserialize(
            JsonElement json,
            Type type,
            JsonDeserializationContext jsonDeserializationContext
    ) throws JsonParseException {

        if (json.isJsonPrimitive()) {
            String timeZoneString = json.getAsString();

            if (null != timeZoneString && !"".equals(timeZoneString)) {
                if (type == DateTimeZone.class) {
                    return DateTimeZone.forID(timeZoneString);
                }
            }
        }

        return null;
    }
}
