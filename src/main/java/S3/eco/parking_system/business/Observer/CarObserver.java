package S3.eco.parking_system.business.Observer;

import S3.eco.parking_system.microservices.Arduino.ArduinoSerialReaderUseCase;
import S3.eco.parking_system.microservices.Arduino.SensorDataProcessorUseCase;
import S3.eco.parking_system.microservices.PlateDetection.CarPlateProcessorUseCase;
import S3.eco.parking_system.microservices.PlateDetection.PlateDetectionReceiverUseCase;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Async
@Service
@AllArgsConstructor
public class CarObserver {
    private final CarPlateProcessorUseCase carPlateProcessorUseCase;
    private final PlateDetectionReceiverUseCase plateDetectionReceiverUseCase;
    private final ArduinoSerialReaderUseCase arduinoSerialReaderUseCase;
    private final SensorDataProcessorUseCase sensorDataProcessorUseCase;

    @PostConstruct
    public void init() {
        startSensorPort();
        startPlateDetectionReceiver();
    }

    @Async
    public void startPlateDetectionReceiver() {
        plateDetectionReceiverUseCase.getCarPlateNumber(carPlateProcessorUseCase);
    }

    @Async
    public void startSensorPort() {
        arduinoSerialReaderUseCase.getSensorInfo(sensorDataProcessorUseCase);
    }
}
