package dev.ceos.springbootbeginner.model;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DeliveryRepository  extends JpaRepository<Delivery, Long> {
}
