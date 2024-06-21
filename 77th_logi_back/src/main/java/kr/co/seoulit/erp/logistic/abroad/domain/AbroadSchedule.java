package kr.co.seoulit.erp.logistic.abroad.domain;

import lombok.Data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ABROAD_SCHEDULE")
@Data
public class AbroadSchedule {
    @Id
    @Column(name="ABROAD_SCHEDULE_CODE")
    private String abroadScheduleCode;;
    private String eventName;
    private String eventType;
    private String eventLocation;
    private String eventDate;
    private String eventExplanation;
    private String eventTarget;
    private String eventHost;
    private String eventState;
}
