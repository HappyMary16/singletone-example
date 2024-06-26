package nopatterns.service;

import nopatterns.db.ParkingDb;
import nopatterns.model.Car;

import java.util.Collection;

/**
 * Відповідальний за всі дії, які можуть відбуватися на парковці:
 * <pre>
 * - паркування автомобілів
 * - видалення автомобілів з парковки
 * </pre>
 */
public class ParkingService {

    private final ParkingDb parkingDb;
    private final int parkingSize;

    /**
     * Конструктор класу.
     *
     * @param parkingSize розмір парковки
     */
    public ParkingService(int parkingSize) {
        this.parkingDb = new ParkingDb();
        this.parkingSize = parkingSize;
    }

    /**
     * Додає автомобіль на парковку, якщо ще є вільне місце.
     *
     * @param car автомобіль, який треба припаркувати
     * @return true - якщо автомобіль вдалося припаркувати,
     * false - якщо на парковці не було місця для автомобіля
     */
    public boolean parkCar(Car car) {
        if (parkingDb.getAmountOfCars() == parkingSize) {
            return false;
        }

        parkingDb.addCar(car);
        return true;
    }

    /**
     * Видаляє автомобіль з парковки.
     *
     * @param carNumber номер автомобіля, який потрібно видалити
     */
    public void removeCar(String carNumber) {
       parkingDb.removeCar(carNumber);
    }

    public Collection<Car> getAllCars() {
        return parkingDb.getAllCars();
    }
}
