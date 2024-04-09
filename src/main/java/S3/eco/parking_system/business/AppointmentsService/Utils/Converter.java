package S3.eco.parking_system.business.AppointmentsService.Utils;

import S3.eco.parking_system.domain.Appointmets.AppointmentData;
import S3.eco.parking_system.persistence.Entities.AppointmentEntity;

import java.util.ArrayList;
import java.util.List;

public class Converter {
    public static AppointmentData convertToAppointmentData(AppointmentEntity entity) {
        return AppointmentData.builder()
                .id(entity.getId())
                .datetime(entity.getDatetime())
                .employee(entity.getEmployee())
                .employeeEmail(entity.getEmployeeEmail())
                .guest(entity.getGuest())
                .guestEmail(entity.getGuestEmail())
                .carPlateNumber(entity.getCarPlateNumber())
                .description(entity.getDescription())
                .build();
    }

    public static List<AppointmentData> convertToAppointmentData(List<AppointmentEntity> entities) {
        List<AppointmentData> appointmentDataLst = new ArrayList<>();

        for (AppointmentEntity entity : entities) {
            appointmentDataLst.add(AppointmentData.builder()
                    .id(entity.getId())
                    .datetime(entity.getDatetime())
                    .employee(entity.getEmployee())
                    .employeeEmail(entity.getEmployeeEmail())
                    .guest(entity.getGuest())
                    .guestEmail(entity.getGuestEmail())
                    .carPlateNumber(entity.getCarPlateNumber())
                    .description(entity.getDescription())
                    .build());
        }

        return appointmentDataLst;
    }
}
