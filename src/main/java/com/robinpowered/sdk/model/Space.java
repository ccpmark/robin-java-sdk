package com.robinpowered.sdk.model;

import com.google.common.base.Objects;
import org.joda.time.DateTime;

import java.util.List;

/**
 * A room or area in a location.
 *
 * <p>
 * Common examples include a "Conference Room" or "Lobby". Spaces are an important resource in that
 * they are the parent model of a {@link Device}, {@link Presence} or {@link Event}. The space model
 * contains references to the current and next events if they exist, as well as its parent location.
 */
public class Space implements IdentifiableApiResponseModel<Integer> {

    /**
     * Constants
     */

    public static final String MIME_TYPE = "vnd.robinpowered.space.v1";


    /**
     * Properties
     */

    // Immutable
    private final int id;
    private final int locationId;
    private final DateTime createdAt;
    private final DateTime updatedAt;

    // Mutable
    private String name;
    private String description;
    private String image;
    private Float discoveryRadius;
    private Integer capacity;
    private String type;
    private Boolean isDisabled;

    // Submodels
    private State state;
    private Location location;
    private Calendar calendar;
    private List<Amenity> amenities;


    /**
     * Methods
     */

    public Space(int id, int locationId, DateTime createdAt, DateTime updatedAt) {
        this.id = id;
        this.locationId = locationId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Float getDiscoveryRadius() {
        return discoveryRadius;
    }

    public void setDiscoveryRadius(Float discoveryRadius) {
        this.discoveryRadius = discoveryRadius;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Boolean isDisabled() {
        return isDisabled;
    }

    public void setIsDisabled(Boolean isDisabled) {
        this.isDisabled = isDisabled;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public DateTime getUpdatedAt() {
        return updatedAt;
    }

    public DateTime getCreatedAt() {
        return createdAt;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public List<Amenity> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<Amenity> amenities) {
        this.amenities = amenities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Space space = (Space) o;
        return Objects.equal(id, space.id) &&
                Objects.equal(locationId, space.locationId) &&
                Objects.equal(createdAt, space.createdAt) &&
                Objects.equal(updatedAt, space.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, locationId, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        return "Space{" +
                "id=" + id +
                ", locationId=" + locationId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", discoveryRadius=" + discoveryRadius +
                ", capacity=" + capacity +
                ", type=" + type +
                ", isDisabled=" + isDisabled +
                ", updatedAt=" + updatedAt +
                ", createdAt=" + createdAt +
                ", location=" + location +
                ", calendar=" + calendar +
                ", amenities=" + amenities +
                '}';
    }

    @Override
    public String getMimeType() {
        return MIME_TYPE;
    }

    /**
     * Represents the current state of the space, containing information about availability and whether there is
     * presence.
     */
    public static class State implements ApiResponseModel {

        public static final String MIME_TYPE = "vnd.robinpowered.space.state.v1";

        public static final String AVAILABLE = "available";
        public static final String BOOKED = "booked";
        public static final String IN_USE = "in_use";
        public static final String DISABLED = "disabled";

        private final String availability;
        private final int present;
        private final DateTime nextBusyChange;

        public State(String availability, int present, DateTime nextBusyChange) {
            this.availability = availability;
            this.present = present;
            this.nextBusyChange = nextBusyChange;
        }

        public String getAvailability() {
            return availability;
        }

        public int getPresent() {
            return present;
        }

        public DateTime getNextBusyChange() {
            return nextBusyChange;
        }

        @Override
        public String getMimeType() {
            return MIME_TYPE;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            State state = (State) o;
            return Objects.equal(present, state.present) &&
                    Objects.equal(availability, state.availability) &&
                    Objects.equal(nextBusyChange, state.nextBusyChange);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(availability, present, nextBusyChange);
        }

        @Override
        public String toString() {
            return "State{" +
                    "availability=" + availability +
                    ", present=" + present +
                    ", nextBusyChange=" + nextBusyChange +
                    '}';
        }
    }
}
