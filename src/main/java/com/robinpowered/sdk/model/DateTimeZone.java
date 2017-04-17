package com.robinpowered.sdk.model;

import com.google.common.base.Objects;
import org.joda.time.DateTime;

/**
 * A representation of a datetime with a timezone.
 */
public class DateTimeZone implements ApiResponseModel {

    public static final String MIME_TYPE = "vnd.robinpowered.date-time-zone.v1";

    private final DateTime dateTime;
    private final org.joda.time.DateTimeZone timeZone;

    public DateTimeZone (DateTime dateTime, org.joda.time.DateTimeZone timeZone) {
        this.dateTime = dateTime;
        this.timeZone = timeZone;
    }

    @Override
    public String getMimeType() {
        return MIME_TYPE;
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    public org.joda.time.DateTimeZone getTimeZone() {
        return timeZone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DateTimeZone that = (DateTimeZone) o;
        return Objects.equal(dateTime, that.dateTime) &&
                Objects.equal(timeZone, that.timeZone);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(dateTime, timeZone);
    }

    @Override
    public String toString() {
        return "DateTimeZone{" +
                "dateTime=" + dateTime +
                ", timeZone=" + timeZone +
                "}";
    }
}
