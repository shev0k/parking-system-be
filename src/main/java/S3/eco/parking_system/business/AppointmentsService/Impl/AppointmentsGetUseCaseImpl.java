package S3.eco.parking_system.business.AppointmentsService.Impl;

import S3.eco.parking_system.business.AppointmentsService.AppointmentsGetUseCase;
import S3.eco.parking_system.business.AppointmentsService.Exceptions.AppointmentNotFoundException;
import S3.eco.parking_system.domain.Appointmets.AppointmentData;
import S3.eco.parking_system.persistence.Entities.AppointmentEntity;
import S3.eco.parking_system.persistence.Repositories.AppointmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static S3.eco.parking_system.business.AppointmentsService.Utils.Converter.convertToAppointmentData;

@Service
@AllArgsConstructor
public class AppointmentsGetUseCaseImpl implements AppointmentsGetUseCase {
    private final AppointmentRepository appointmentRepository;

    @Override
    public List<AppointmentData> getAll() {
        List<AppointmentEntity> appointments = appointmentRepository.findAll();

        if (appointments.isEmpty()) {
            throw new AppointmentNotFoundException("No appointments found");
        }

        return convertToAppointmentData(appointments);
    }

    @Override
    public AppointmentData getById(Long id) {
        Optional<AppointmentEntity> optionalAppointment = appointmentRepository.findById(id);
        AppointmentEntity appointmentEntity = optionalAppointment.orElseThrow(() -> new AppointmentNotFoundException("Appointment not found for id: " + id));
        return convertToAppointmentData(appointmentEntity);
    }

    @Override
    public AppointmentData getByEmployee(String employee) {
        Optional<AppointmentEntity> appointmentOptional = appointmentRepository.findByEmployee(employee);
        AppointmentEntity appointmentEntity = appointmentOptional.orElseThrow(() -> new AppointmentNotFoundException("Appointment not found for employee: " + employee));
        return convertToAppointmentData(appointmentEntity);
    }

    @Override
    public AppointmentData getByEmployeeEmail(String employeeEmail) {
        Optional<AppointmentEntity> appointmentOptional = appointmentRepository.findByEmployeeEmail(employeeEmail);
        AppointmentEntity appointmentEntity = appointmentOptional.orElseThrow(() -> new AppointmentNotFoundException("Appointment not found for employee email: " + employeeEmail));
        return convertToAppointmentData(appointmentEntity);
    }

    @Override
    public AppointmentData getByGuest(String guest) {
        Optional<AppointmentEntity> appointmentOptional = appointmentRepository.findByGuest(guest);
        AppointmentEntity appointmentEntity = appointmentOptional.orElseThrow(() -> new AppointmentNotFoundException("Appointment not found for guest: " + guest));
        return convertToAppointmentData(appointmentEntity);
    }

    @Override
    public AppointmentData getByGuestEmail(String guestEmail) {
        Optional<AppointmentEntity> appointmentOptional = appointmentRepository.findByGuestEmail(guestEmail);
        AppointmentEntity appointmentEntity = appointmentOptional.orElseThrow(() -> new AppointmentNotFoundException("Appointment not found for guest email: " + guestEmail));
        return convertToAppointmentData(appointmentEntity);
    }

    @Override
    public AppointmentData getByDatetime(LocalDateTime dateTime) {
        Optional<AppointmentEntity> appointmentOptional = appointmentRepository.findByDatetime(dateTime);
        AppointmentEntity appointmentEntity = appointmentOptional.orElseThrow(() -> new AppointmentNotFoundException("Appointment not found for datetime: " + dateTime));
        return convertToAppointmentData(appointmentEntity);
    }

    @Override
    public AppointmentData getByCarPlateNumber(String carPlateNumber) {
        Optional<AppointmentEntity> appointmentOptional = appointmentRepository.findByCarPlateNumber(carPlateNumber);
        AppointmentEntity appointmentEntity = appointmentOptional.orElseThrow(() -> new AppointmentNotFoundException("Appointment not found for car plate number: " + carPlateNumber));
        return convertToAppointmentData(appointmentEntity);
    }
}
