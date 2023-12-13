package com.example.democinema.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ReservationId implements Serializable {

    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "SCREENING_ID")
    private Long screeningId;

    public ReservationId() {}

    public ReservationId(Long userId, Long screeningId) {
        this.userId = userId;
        this.screeningId = screeningId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getScreeningId() {
        return screeningId;
    }

    public void setScreeningId(Long screeningId) {
        this.screeningId = screeningId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReservationId)) return false;

        ReservationId that = (ReservationId) o;

        if (!getUserId().equals(that.getUserId())) return false;
        return getScreeningId().equals(that.getScreeningId());
    }

    @Override
    public int hashCode() {
        int result = getUserId().hashCode();
        result = 31 * result + getScreeningId().hashCode();
        return result;
    }
}
