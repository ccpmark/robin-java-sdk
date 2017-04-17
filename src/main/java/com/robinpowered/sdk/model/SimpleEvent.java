package com.robinpowered.sdk.model;

import com.google.common.base.Objects;

/**
 * A simplified {@link Event}.
 *
 * <p>
 * A simplified version of an event containing start and end times, as well as a matching ID for
 * referencing the associated {@link Event}.
 */
public class SimpleEvent implements ApiResponseModel {

    /**
     * Constants
     */

    public static final String MIME_TYPE = "vnd.robinpowered.simple-event.v1";


    /**
     * Properties
     */

    private String id;
    private DateTimeZone start;
    private DateTimeZone end;


    /**
     * Methods
     */

    /**
     * Constructs a SimpleEvent.
     *
     * @param id The id of the event.
     * @param start When the event started.
     * @param end When the event ended.
     */
    public SimpleEvent(String id, DateTimeZone start, DateTimeZone end) {
        this.id = id;
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || !(that instanceof SimpleEvent)) return false;
        return Objects.equal(id, ((SimpleEvent) that).id);
    }

    @Override
    public String getMimeType() {
        return MIME_TYPE;
    }

    public String getId() {
        return id;
    }

    public DateTimeZone getStart() {
        return start;
    }

    public DateTimeZone getEnd() {
        return end;
    }
}
