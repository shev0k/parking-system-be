package S3.eco.parking_system.business.AppointmentsService.Impl;

import S3.eco.parking_system.business.AppointmentsService.AppointmentsDeleteUseCase;
import S3.eco.parking_system.business.AppointmentsService.Exceptions.AppointmentNotFoundException;
import S3.eco.parking_system.persistence.Repositories.AppointmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppointmentsDeleteUseCaseImpl implements AppointmentsDeleteUseCase {
    private final AppointmentRepository appointmentRepository;

    @Override
    public void deleteAppointment(Long appointmentId) {
        if (!appointmentRepository.existsById(appointmentId)) {
            throw new AppointmentNotFoundException("Appointment not found with id: " + appointmentId);
        }

        appointmentRepository.deleteById(appointmentId);
    }
}
